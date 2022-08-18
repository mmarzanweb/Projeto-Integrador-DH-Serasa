package br.com.empregaelas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.empregaelas.adapter.DozerConverter;
import br.com.empregaelas.domain.entity.Empresa;
import br.com.empregaelas.domain.vo.v1.EmpresaVO;
import br.com.empregaelas.enums.USER_PERMISSIONS;
import br.com.empregaelas.exceptions.ResourceNotFoundException;
import br.com.empregaelas.repository.EmpresaRepository;

@Service
public class EmpresaService {

	@Autowired
	EmpresaRepository repository;
	
	public EmpresaVO create(Empresa empresa) {
		empresa.setTipoPermissao(USER_PERMISSIONS.empresa);
		var empresaVO = DozerConverter.parseObject(repository.save(empresa), EmpresaVO.class);
		return empresaVO;
	}

	public List<EmpresaVO> findAll() {
		return DozerConverter.parseListObject(repository.findAll(), EmpresaVO.class);
	}

	public EmpresaVO findById(Long id) {
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado registro em esse Id"));
		return DozerConverter.parseObject(entity, EmpresaVO.class);
	}

	public void delete(Long id) {
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado registro em esse Id"));
		repository.delete(entity);
	}

	public EmpresaVO update(Empresa empresa) {
		var entity = repository.findById(empresa.getId())
				.orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado registro com esse Id"));

		entity.setCnpj(empresa.getCnpj());
		entity.setRazaoSocial(empresa.getRazaoSocial());
		entity.setNomeFantasia(empresa.getNomeFantasia());
		entity.setTelefone(empresa.getTelefone());
		entity.setResponsavel(empresa.getResponsavel());
		entity.setSegmento(empresa.getSegmento());
		entity.setNumFunc(empresa.getNumFunc());

		var vo = DozerConverter.parseObject(repository.save(entity), EmpresaVO.class);
		return vo;
	}

}



