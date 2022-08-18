package br.com.empregaelas.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.empregaelas.domain.entity.Candidato;
import br.com.empregaelas.domain.entity.Empresa;
import br.com.empregaelas.domain.vo.v1.CandidatoVO;
import br.com.empregaelas.domain.vo.v1.EmpresaVO;
import br.com.empregaelas.domain.vo.v1.VagaVO;
import br.com.empregaelas.security.CredenciaisContaVO;
import br.com.empregaelas.service.CandidatoService;
import br.com.empregaelas.service.EmpresaService;
import br.com.empregaelas.service.UserService;
import br.com.empregaelas.service.VagaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Authentication Endpoint")
@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserService userService;
	
	@Autowired
	CandidatoService candidatoService;
	
	@Autowired
	EmpresaService empresaService;
	
	@Autowired
	VagaService service;

	//login público
	@PostMapping(value = "/login", produces = { "application/json", "application/xml" }, consumes = {
			"application/json", "application/xml" })
	public ResponseEntity signin(@RequestBody CredenciaisContaVO cred) {
		return userService.login(cred.getEmail(), cred.getSenha());
	}

	// Cadastrar candidato
	@PostMapping(value = "/candidato", consumes = { "application/json", "application/xml" }, produces = { "application/json",
			"application/xml" })
	@Operation(summary = "Cadastrar candidato")
	@ResponseStatus(value = HttpStatus.CREATED)
	public CandidatoVO create(@Valid @RequestBody Candidato candidato) {
		CandidatoVO candidatoVO = candidatoService.create(candidato);
		candidatoVO.add(linkTo(methodOn(CandidatoController.class).findById(candidatoVO.getKey())).withSelfRel());
		return candidatoVO;
	}
	
	// Cadastrar empresa
	
	@PostMapping (value = "/empresa",consumes = { "application/json", "application/xml" }, produces = { "application/json",
			"application/xml" })
	@Operation(summary = "Cadastrar empresa")
	@ResponseStatus(value = HttpStatus.CREATED)
	public EmpresaVO create(@Valid @RequestBody Empresa empresa) {
		EmpresaVO empresaVO = empresaService.create(empresa);
		empresaVO.add(linkTo(methodOn(EmpresaController.class).findById(empresaVO.getKey())).withSelfRel());
		return empresaVO;
	}
	
	// listar todas as empresas
	
	@RequestMapping(value = "/empresa", method = RequestMethod.GET, produces = { "application/json", "application/xml" })
	@Operation(summary = "Listar todas as empresas")
	@ResponseStatus(value = HttpStatus.OK)
	public List<EmpresaVO> findAll() {
		List<EmpresaVO> empresasVO = empresaService.findAll();
		empresasVO.stream()
				.forEach(p -> p.add(linkTo(methodOn(EmpresaController.class).findById(p.getKey())).withSelfRel()));

		return empresasVO;
	}
	
	//Listar todas as vaga
	@RequestMapping(value = "/vagas",method = RequestMethod.GET, produces = { "application/json", "application/xml" })
	@Operation(summary = "Listar todos as vagas")
	@ResponseStatus(value = HttpStatus.OK)
	public List<VagaVO> findAllVagas() {
		List<VagaVO> vagasVO = service.findAll();
		vagasVO.stream().forEach(p -> p.add(linkTo(methodOn(VagaController.class).findById(p.getKey())).withSelfRel()));
		return vagasVO;

	}
	
}




