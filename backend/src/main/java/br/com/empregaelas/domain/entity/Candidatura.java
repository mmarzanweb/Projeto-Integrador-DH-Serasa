package br.com.empregaelas.domain.entity; 

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
@Entity
@Table(name="ee_candidatura")
public class Candidatura{

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	
	@ManyToOne
	@JoinColumn(name="id_candidato")
	Candidato candidato;
	
	@ManyToOne
	@JoinColumn(name="id_vaga")
	Vaga vaga;
	
	@NotBlank
    @Column(name="data_candidatura")
	private Date data_candidatura;
	
}

