package br.com.empregaelas.service;

import static org.springframework.http.ResponseEntity.ok;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import br.com.empregaelas.domain.entity.Candidato;
import br.com.empregaelas.domain.entity.Empresa;
import br.com.empregaelas.repository.CandidatoRepository;
import br.com.empregaelas.repository.EmpresaRepository;
import br.com.empregaelas.security.jwt.JwtProvider;

@Service
public class UserService {

	@Autowired
	CandidatoRepository candidatoRepository;

	@Autowired
	EmpresaRepository empresaRepository;

	@Autowired
	JwtProvider tokenProvider;

	public UserDetails loadUserByEmail(String email) throws UsernameNotFoundException {
		Candidato candidato = candidatoRepository.findByEmail(email);

		if (candidato != null) {
			List<GrantedAuthority> authorities = new ArrayList<>();
			authorities.add(new SimpleGrantedAuthority(candidato.getTipoPermissao().toString()));
			return new org.springframework.security.core.userdetails.User(candidato.getEmail(), candidato.getSenha(),
					authorities);
		} else {
			Empresa empresa = empresaRepository.findByEmail(email);

			if (empresa != null) {
				List<GrantedAuthority> authorities = new ArrayList<>();
				authorities.add(new SimpleGrantedAuthority(empresa.getTipoPermissao().toString()));
				return new org.springframework.security.core.userdetails.User(empresa.getEmail(), empresa.getSenha(),
						authorities);
			}
		}
		throw new UsernameNotFoundException("O usuario " + email + " não localizado");
	}

	public ResponseEntity<Map<Object, Object>> login(String email, String senha) throws UsernameNotFoundException {
		Map<Object, Object> model = new HashMap<>();
		Candidato candidato = candidatoRepository.findByEmail(email);
		if (candidato != null) {
			if (candidato.getSenha().equals(senha)) {
				String token = tokenProvider.createToken(candidato.getEmail(), candidato.getTipoPermissao().toString());
				model.put("token", token);
				model.put("usuario", candidato);
				return ok(model);
			}
		} else {
			Empresa empresa = empresaRepository.findByEmail(email);
			if (empresa != null) {
				if (empresa.getSenha().equals(senha)) {
					String token = tokenProvider.createToken(empresa.getEmail(), empresa.getTipoPermissao().toString());
					model.put("token", token);
					model.put("usuario", empresa);
					return ok(model);
				}
			}
		}
		throw new UsernameNotFoundException("Usuário com e-mail " + email + " não localizado");
	}

}
