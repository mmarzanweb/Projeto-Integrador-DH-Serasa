package br.com.empregaelas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.empregaelas.adapter.DozerConverter;
import br.com.empregaelas.domain.entity.Candidato;
import br.com.empregaelas.domain.entity.Vaga;
import br.com.empregaelas.domain.vo.v1.CandidatoVO;
import br.com.empregaelas.domain.vo.v1.VagaVO;
import br.com.empregaelas.enums.USER_PERMISSIONS;
import br.com.empregaelas.exceptions.ResourceNotFoundException;
import br.com.empregaelas.repository.VagaRepository;

@Service
public class VagaService {

	@Autowired
	VagaRepository repository;
	
	
	public VagaVO create(Vaga vaga) {
		var vagaVO = DozerConverter.parseObject(repository.save(vaga), VagaVO.class);
		return vagaVO;
	}
	
	

//	public VagaVO create(VagaVO vaga) {
//		var entity = DozerConverter.parseObject(vaga, VagaVO.class);
//		var vo = DozerConverter.parseObject(entity, VagaVO.class);
//
//		return vo;
//	}

	public List<VagaVO> findAll() {
		return DozerConverter.parseListObject(repository.findAll(), VagaVO.class);
	}

	public VagaVO findById(Long id) {
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado registro em esse Id"));
		return DozerConverter.parseObject(entity, VagaVO.class);
	}

	public void delete(Long id) {
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado registro em esse Id"));
		repository.delete(entity);
	}

	public VagaVO update(VagaVO vaga) {
		var entity = repository.findById(vaga.getKey())
				.orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado registro com esse Id"));

//		entity.setPublicada(vaga.getPublicada());
		entity.setDataPublicacao(vaga.getDataPublicacao());
		entity.setCargo(vaga.getCargo());
		entity.setNivel(vaga.getNivel());
		entity.setJornada(vaga.getJornada());
		entity.setTipoContrato(vaga.getTipoContrato());
		entity.setDescrVaga(vaga.getDescrVaga());
		entity.setRequisitos(vaga.getRequisitos());
		entity.setDesejavel(vaga.getDesejavel());
		entity.setBeneficios(vaga.getBeneficios());
//        entity.setUf(vaga.getUf());
		entity.setCidade(vaga.getCidade());
		entity.setBairro(vaga.getBairro());
		entity.setCep(vaga.getCep());

		var vo = DozerConverter.parseObject(repository.save(entity), VagaVO.class);
		return vo;
	}

}
