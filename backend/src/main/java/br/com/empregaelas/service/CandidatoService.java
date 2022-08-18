package br.com.empregaelas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.empregaelas.adapter.DozerConverter;
import br.com.empregaelas.domain.entity.Candidato;
import br.com.empregaelas.domain.vo.v1.CandidatoVO;
import br.com.empregaelas.enums.USER_PERMISSIONS;
import br.com.empregaelas.exceptions.ResourceNotFoundException;
import br.com.empregaelas.repository.CandidatoRepository;

@Service
public class CandidatoService {

	@Autowired
	CandidatoRepository repository;

	public CandidatoVO create(Candidato candidato) {
		candidato.setTipoPermissao(USER_PERMISSIONS.candidato);
		var candidatoVO = DozerConverter.parseObject(repository.save(candidato), CandidatoVO.class);
		return candidatoVO;
	}

	public List<CandidatoVO> findAll() {
		return DozerConverter.parseListObject(repository.findAll(), CandidatoVO.class);
	}

	public CandidatoVO findById(Long id) {
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado registro em esse Id"));
		return DozerConverter.parseObject(entity, CandidatoVO.class);
	}

	public void delete(Long id) {
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado registro em esse Id"));
		repository.delete(entity);
	}

	public CandidatoVO update(CandidatoVO candidato) {
		var entity = repository.findById(candidato.getKey())
				.orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado registro com esse Id"));

		entity.setNome(candidato.getNome());
		entity.setCpf(candidato.getCpf());
		entity.setNomeSocial(candidato.getNomeSocial());
		entity.setDataNasc(candidato.getDataNasc());
		entity.setEstadoCivil(candidato.getEstadoCivil());
		entity.setLinkedin(candidato.getLinkedin());
		entity.setGitHub(candidato.getGitHub());
		entity.setPortfolio(candidato.getPortfolio());
		entity.setRaca(candidato.getRaca());
		entity.setGenero(candidato.getGenero());
		entity.setSexoBio(candidato.getSexoBio());
		entity.setSobre(candidato.getSobre());
		entity.setIdioma(candidato.getIdioma());
		entity.setPretensaoSalarial(candidato.getPretensaoSalarial());
		entity.setDataCadastro(candidato.getDataCadastro());

		var vo = DozerConverter.parseObject(repository.save(entity), CandidatoVO.class);
		return vo;
	}
}

