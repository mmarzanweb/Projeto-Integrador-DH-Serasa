package br.com.empregaelas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.empregaelas.adapter.DozerConverter;
import br.com.empregaelas.domain.vo.v1.FormacaoAcademicaVO;
import br.com.empregaelas.exceptions.ResourceNotFoundException;
import br.com.empregaelas.repository.FormacaoAcademicaRepository;

@Service
public class FormacaoAcademicaService {

	@Autowired
	FormacaoAcademicaRepository repository;

	public FormacaoAcademicaVO create(FormacaoAcademicaVO formacaoAcademicaVO) {
		var entity = DozerConverter.parseObject(formacaoAcademicaVO, FormacaoAcademicaVO.class);
		var vo = DozerConverter.parseObject(entity, FormacaoAcademicaVO.class);

		return vo;
	}

	public List<FormacaoAcademicaVO> findAll() {
		return DozerConverter.parseListObject(repository.findAll(), FormacaoAcademicaVO.class);
	}

	public FormacaoAcademicaVO findById(Long id) {
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado registro em esse Id"));
		return DozerConverter.parseObject(entity, FormacaoAcademicaVO.class);
	}

	public void delete(Long id) {
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado registro em esse Id"));
		repository.delete(entity);
	}

	public FormacaoAcademicaVO update(FormacaoAcademicaVO formacaoAcademica) {
		var entity = repository.findById(formacaoAcademica.getKey())
				.orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado registro com esse Id"));

		entity.setFormacao(formacaoAcademica.getFormacao());
		entity.setCurso(formacaoAcademica.getCurso());
		entity.setInstituicao(formacaoAcademica.getInstituicao());
		entity.setDataInicio(formacaoAcademica.getDataInicio());
		entity.setDataFinal(formacaoAcademica.getDataFinal());
		entity.setInformacoesAdicionais(formacaoAcademica.getInformacoesAdicionais());

		var vo = DozerConverter.parseObject(repository.save(entity), FormacaoAcademicaVO.class);
		return vo;
	}
}
