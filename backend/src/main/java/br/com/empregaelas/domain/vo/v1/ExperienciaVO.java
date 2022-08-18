package br.com.empregaelas.domain.vo.v1;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import org.springframework.hateoas.RepresentationModel;

import com.github.dozermapper.core.Mapping;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExperienciaVO extends RepresentationModel<ExperienciaVO> implements Serializable { 
	
	
	private static final long serialVersionUID = 1L;
	
	
	@Mapping("id")
	private long key;
	private String contratante;
	private String cargo;
	private Date dataInicio;
	private Boolean empregoAtual;
	private Date dataSaida;
	private String atribuicoes;
	private String tipoContrato;

	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(key, atribuicoes, cargo, contratante,tipoContrato,dataInicio,empregoAtual);
		return result;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		ExperienciaVO other = (ExperienciaVO) obj;
		return key == other.key && Objects.equals(atribuicoes, other.atribuicoes) && Objects.equals(cargo, other.cargo)
				&& Objects.equals(contratante, other.contratante) && Objects.equals(dataInicio, other.dataInicio)
				&& Objects.equals(tipoContrato, other.tipoContrato) && Objects.equals(empregoAtual, other.empregoAtual);
	}
	

}


