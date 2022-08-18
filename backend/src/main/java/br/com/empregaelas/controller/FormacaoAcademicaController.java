package br.com.empregaelas.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.empregaelas.domain.vo.v1.FormacaoAcademicaVO;
import br.com.empregaelas.service.FormacaoAcademicaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "FormacaoAcademica Endpoint")
@RestController
@RequestMapping("/api/formacaoAcademica/v1")
public class FormacaoAcademicaController {

	@Autowired
	FormacaoAcademicaService service;

	
	@RequestMapping(method = RequestMethod.GET, produces = { "application/json", "application/xml" })
	@Operation(summary = "Listar todas as formações academicas")
	@ResponseStatus(value = HttpStatus.OK)
	public List<FormacaoAcademicaVO> findAll() {
		List<FormacaoAcademicaVO> formacaoAcademicasVO = service.findAll();
		formacaoAcademicasVO.stream().forEach(
				p -> p.add(linkTo(methodOn(FormacaoAcademicaController.class).findById(p.getKey())).withSelfRel()));
		return formacaoAcademicasVO;

	}

	
	@GetMapping(value = "/{id}", produces = { "application/json", "application/xml" })
	@Operation(summary = "Procurar formação academica por ID")
	@ResponseStatus(value = HttpStatus.OK)
	public FormacaoAcademicaVO findById(@PathVariable("id") Long id) {
		FormacaoAcademicaVO formacaoAcademicaVO = service.findById(id);
		formacaoAcademicaVO.add(linkTo(methodOn(FormacaoAcademicaController.class).findById(id)).withSelfRel());
		return formacaoAcademicaVO;
	}

	

	@PostMapping(consumes = { "application/json", "application/xml" }, produces = { "application/json",
			"application/xml" })
	@Operation(summary = "Cadastrar formação academica")
	@ResponseStatus(value = HttpStatus.CREATED)
	public FormacaoAcademicaVO create(@Valid @RequestBody FormacaoAcademicaVO formacaoAcademica) {
		FormacaoAcademicaVO formacaoAcademicaVO = service.create(formacaoAcademica);
		formacaoAcademicaVO
				.add(linkTo(methodOn(FormacaoAcademicaController.class).findById(formacaoAcademicaVO.getKey()))
						.withSelfRel());
		return formacaoAcademicaVO;
	}

	
	@PutMapping(consumes = { "application/json", "application/xml" }, produces = { "application/json",
			"application/xml" })
	@Operation(summary = "Atualizar formação academica")
	@ResponseStatus(value = HttpStatus.OK)
	public FormacaoAcademicaVO update(@Valid @RequestBody FormacaoAcademicaVO formacaoAcademica) {
		FormacaoAcademicaVO formacaoAcademicaVO = service.update(formacaoAcademica);
		formacaoAcademicaVO
				.add(linkTo(methodOn(FormacaoAcademicaController.class).findById(formacaoAcademicaVO.getKey()))
						.withSelfRel());
		return formacaoAcademicaVO;

	}


	@DeleteMapping(value = "/{id}")
	@Operation(summary = "Deletar formação academica")
	@ResponseStatus(value = HttpStatus.OK)
	public void delete(@PathVariable("id") Long id) {
		service.delete(id);
	}

}


