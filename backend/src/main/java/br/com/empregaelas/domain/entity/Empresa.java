package br.com.empregaelas.domain.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import br.com.empregaelas.enums.USER_PERMISSIONS;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ee_empresa")
@Data
@NoArgsConstructor
public class Empresa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@NotBlank
	@Size(max = 14)
	@Column(name = "cnpj")
	private String cnpj;

	@NotBlank
	@Size(max = 50)
	@Column(name = "senha")
	private String senha;


	@Column(name = "tipo_permissao")
	private USER_PERMISSIONS tipoPermissao;

	@NotBlank
	@Size(max = 50)
	@Email
	@Column(name = "email")
	private String email;

	@NotBlank
	@Size(max = 60)
	@Column(name = "razao_social")
	private String razaoSocial;

	@Column(name = "nome_fantasia")
	private String nomeFantasia;

	@Size(max = 11)
	@Column(name = "telefone")
	private String telefone;

	@NotBlank
	@Size(max = 50)
	@Column(name = "responsavel")
	private String responsavel;

	@NotBlank
	@Size(max = 60)
	@Column(name = "segmento")
	private String segmento;

	@Column(name = "num_func")
    private Integer numFunc;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id", referencedColumnName = "id")
	private Endereco endereco; 
	
}
	
	
