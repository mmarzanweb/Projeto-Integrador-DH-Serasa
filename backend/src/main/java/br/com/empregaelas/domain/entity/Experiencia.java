package br.com.empregaelas.domain.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ee_experiencia")
@Data
@NoArgsConstructor
public class Experiencia implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@ManyToOne
	@JoinColumn(name = "id_candidato")
	private Candidato candidato;

	@NotBlank
	@Size(max = 30)
	@Column(name = "contratante")
	private String contratante;

	@NotBlank
	@Size(max = 30)
	@Column(name = "cargo")
	private String cargo;

	@Column(name = "data_inicio")
	private Date dataInicio;

	@Column(name = "emprego_atual")
	private Boolean empregoAtual;

	@Column(name = "data_saida")
	private Date dataSaida;

	@NotBlank
	@Lob
	@Column(name = "atribuicoes")
	private String atribuicoes;

	@NotBlank
	@Size(max = 30)
	@Column(name = "tipo_contrato")
	private String tipoContrato;

}