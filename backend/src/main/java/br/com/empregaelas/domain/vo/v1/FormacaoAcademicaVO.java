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
public class FormacaoAcademicaVO extends RepresentationModel<FormacaoAcademicaVO> implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	@Mapping("id")
	private long Key;
	private String formacao;
	private String curso;
	private String instituicao;
	private Date dataInicio;
	private Date dataFinal;
	private String informacoesAdicionais;
	private String cep;
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ Objects.hash(Key, cep, curso, dataFinal, dataInicio, formacao, informacoesAdicionais, instituicao);
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
		FormacaoAcademicaVO other = (FormacaoAcademicaVO) obj;
		return Key == other.Key && Objects.equals(cep, other.cep) && Objects.equals(curso, other.curso)
				&& Objects.equals(dataFinal, other.dataFinal) && Objects.equals(dataInicio, other.dataInicio)
				&& Objects.equals(formacao, other.formacao)
				&& Objects.equals(informacoesAdicionais, other.informacoesAdicionais)
				&& Objects.equals(instituicao, other.instituicao);
	}
	
}


