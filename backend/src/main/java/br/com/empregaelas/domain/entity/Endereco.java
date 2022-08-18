package br.com.empregaelas.domain.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.Embeddable;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
//@Embeddable
@Table(name = "ee_endereco")


public class Endereco implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@NotBlank
	@Size(max = 50)
	@Column(name = "logradouro")
	private String logradouro;

	@NotBlank
	@Size(max = 5)
	@Column(name = "num")
	private String num;

	@Size(max = 50)
	@Column(name = "compl")
	private String compl;

	@NotBlank
	@Size(max = 50)
	@Column(name = "bairro")
	private String bairro;

	@NotBlank
	@Size(max = 50)
	@Column(name = "cidade")
	private String cidade;

	@NotBlank
	@Size(max = 2)
	@Column(name = "uf")
	private String uf;

	@NotBlank
	@Size(max = 10)
	@Column(name = "cep")
	private String cep;

	
	
	
}

