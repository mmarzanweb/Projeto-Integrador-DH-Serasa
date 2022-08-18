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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.empregaelas.domain.vo.v1.EnderecoVO;
import br.com.empregaelas.service.EnderecoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Endereco Endpoint")
@RestController
@RequestMapping("/api/endereco/v1")
public class EnderecoController {

	@Autowired
	EnderecoService service;

	
	@RequestMapping(method = RequestMethod.GET, produces = { "application/json", "application/xml" })
	@Operation(summary = "Listar todos os endereços")
	@ResponseStatus(value = HttpStatus.OK)
	public List<EnderecoVO> findAll() {
		List<EnderecoVO> enderecosVO = service.findAll();
		enderecosVO.stream()
				.forEach(p -> p.add(linkTo(methodOn(EnderecoController.class).findById(p.getKey())).withSelfRel()));
		return enderecosVO;

	}

	
	@GetMapping(value = "/{id}", produces = { "application/json", "application/xml" })
	@Operation(summary = "Procurar endereço por ID")
	@ResponseStatus(value = HttpStatus.OK)
	public EnderecoVO findById(@PathVariable("id") Long id) {
		EnderecoVO enderecoVO = service.findById(id);
		enderecoVO.add(linkTo(methodOn(EnderecoController.class).findById(id)).withSelfRel());
		return enderecoVO;
	}

	

	@PostMapping(consumes = { "application/json", "application/xml" }, produces = { "application/json",
			"application/xml" })
	@Operation(summary = "Cadastrar endereço")
	@ResponseStatus(value = HttpStatus.CREATED)
	public EnderecoVO create(@Valid @RequestBody EnderecoVO endereco) {
		EnderecoVO enderecoVO = service.create(endereco);
		enderecoVO.add(linkTo(methodOn(EnderecoController.class).findById(enderecoVO.getKey())).withSelfRel());
		return enderecoVO;
	}

	
	@PutMapping(consumes = { "application/json", "application/xml" }, produces = { "application/json",
			"application/xml" })
	@Operation(summary = "Atualizar endereço")
	@ResponseStatus(value = HttpStatus.OK)
	public EnderecoVO update(@Valid @RequestBody EnderecoVO endereco) {
		EnderecoVO enderecoVO = service.update(endereco);
		enderecoVO.add(linkTo(methodOn(EnderecoController.class).findById(enderecoVO.getKey())).withSelfRel());
		return enderecoVO;

	}

	
	@DeleteMapping(value = "/{id}")
	@Operation(summary = "Deletar endereço")
	@ResponseStatus(value = HttpStatus.OK)
	public void delete(@PathVariable("id") Long id) {
		service.delete(id);
	}

}



