package br.com.empregaelas.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.empregaelas.domain.entity.Experiencia;
import br.com.empregaelas.domain.vo.v1.ExperienciaVO;
import br.com.empregaelas.service.ExperienciaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Experiencia Endpoint")
@RestController
@RequestMapping("/api/experiencia/v1")
public class ExperienciaController {

	@Autowired
	ExperienciaService service;

	@RequestMapping(method = RequestMethod.GET, produces = { "application/json", "application/xml" })
	@Operation(summary = "Listar todos as experiencias")
	@ResponseStatus(value = HttpStatus.OK)
	public List<ExperienciaVO> findAll() {
		List<ExperienciaVO> experienciasVO = service.findAll();
		experienciasVO.stream()
				.forEach(p -> p.add(linkTo(methodOn(ExperienciaController.class).findById(p.getKey())).withSelfRel()));

		return experienciasVO;
	}

	@GetMapping(value = "/{id}", produces = { "application/json", "application/xml" })
	@Operation(summary = "Procurar experiencia por ID")
	@ResponseStatus(value = HttpStatus.OK)
	public ExperienciaVO findById(@PathVariable("id") Long id) {
		ExperienciaVO experienciaVO = service.findById(id);
		experienciaVO.add(linkTo(methodOn(ExperienciaController.class).findById(id)).withSelfRel());
		return experienciaVO;
	}

	@PreAuthorize("hasAnyAuthority('candidato')")
	@PostMapping(consumes = { "application/json", "application/xml" }, produces = { "application/json",
			"application/xml" })
	@Operation(summary = "Cadastrar experiencia")
	@ResponseStatus(value = HttpStatus.CREATED)
	public ExperienciaVO create(@RequestBody Experiencia experiencia) {
		ExperienciaVO experienciaVO = service.create(experiencia);
		experienciaVO.add(linkTo(methodOn(ExperienciaController.class).findById(experienciaVO.getKey())).withSelfRel());
		return experienciaVO;
	}

	@PreAuthorize("hasAnyAuthority('candidato')")
	@PutMapping(consumes = { "application/json", "application/xml" }, produces = { "application/json",
			"application/xml" })
	@Operation(summary = "Atualizar experiencia")
	@ResponseStatus(value = HttpStatus.OK)
	public ExperienciaVO update(@Valid @RequestBody ExperienciaVO experiencia) {
		ExperienciaVO experienciaVO = service.update(experiencia);
		experienciaVO.add(linkTo(methodOn(ExperienciaController.class).findById(experienciaVO.getKey())).withSelfRel());
		return experienciaVO;

	}

	@DeleteMapping(value = "/{id}")
	@Operation(summary = "Deletar experiencia")
	@ResponseStatus(value = HttpStatus.OK)
	public void delete(@PathVariable("id") Long id) {
		service.delete(id);
	}

}
