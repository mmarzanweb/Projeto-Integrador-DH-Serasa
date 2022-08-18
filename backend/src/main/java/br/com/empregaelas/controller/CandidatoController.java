package br.com.empregaelas.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.empregaelas.domain.vo.v1.CandidatoVO;
import br.com.empregaelas.service.CandidatoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Candidato Endpoint")
@RestController
@RequestMapping("/api/candidato/v1")
public class CandidatoController {

	@Autowired
	CandidatoService service;

	// buscar todos
	@CrossOrigin("localhost:8080") // permitido o acesso
	@RequestMapping(method = RequestMethod.GET, produces = { "application/json", "application/xml" })
	@Operation(summary = "Listar todos os candidatos")
	@ResponseStatus(value = HttpStatus.OK)
	public List<CandidatoVO> findAll() {
		List<CandidatoVO> candidatosVO = service.findAll();
		candidatosVO.stream()
				.forEach(p -> p.add(linkTo(methodOn(CandidatoController.class).findById(p.getKey())).withSelfRel()));
		return candidatosVO;

	}

	// buscar por Id
	@GetMapping(value = "/{id}", produces = { "application/json", "application/xml" })
	@Operation(summary = "Procurar candidato por ID")
	@ResponseStatus(value = HttpStatus.OK)
	public CandidatoVO findById(@PathVariable("id") Long id) {
		CandidatoVO candidatoVO = service.findById(id);
		candidatoVO.add(linkTo(methodOn(CandidatoController.class).findById(id)).withSelfRel());
		return candidatoVO;
	}


	// atualizar candidato
	@PutMapping(consumes = { "application/json", "application/xml" }, produces = { "application/json",
			"application/xml" })
	@Operation(summary = "Atualizar candidato")
	@ResponseStatus(value = HttpStatus.OK)
	public CandidatoVO update(@Valid @RequestBody CandidatoVO candidato) {
		CandidatoVO candidatoVO = service.update(candidato);
		candidatoVO.add(linkTo(methodOn(CandidatoController.class).findById(candidatoVO.getKey())).withSelfRel());
		return candidatoVO;

	}

	// deletar candidato
	@DeleteMapping(value = "/{id}")
	@Operation(summary = "Deletar candidato")
	@ResponseStatus(value = HttpStatus.OK)
	public void delete(@PathVariable("id") Long id) {
		service.delete(id);
	}

}

