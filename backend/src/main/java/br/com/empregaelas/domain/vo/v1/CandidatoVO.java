package br.com.empregaelas.domain.vo.v1;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import org.springframework.hateoas.RepresentationModel;

import com.github.dozermapper.core.Mapping;

import br.com.empregaelas.enums.USER_PERMISSIONS;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CandidatoVO extends RepresentationModel<CandidatoVO> implements Serializable {

	private static final long serialVersionUID = 1L;

	@Mapping("id")
	private long key;
	private String cpf;
	private String nome;
	private String nomeSocial;
	private Date dataNasc;
	private String estadoCivil;
	private String linkedin;
	private String gitHub;
	private String portfolio;
	private String raca;
	private String genero;
	private String sexoBio;
	private String sobre;
	private String idioma;
	private String email;
	private USER_PERMISSIONS tipoPermissao;
	private double pretensaoSalarial;
	private Date dataCadastro;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(key, cpf, dataCadastro, dataNasc, estadoCivil, genero, gitHub, idioma,
				linkedin, nome, nomeSocial, portfolio, pretensaoSalarial, raca, sexoBio, sobre, email, tipoPermissao);
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
		CandidatoVO other = (CandidatoVO) obj;
		return key == other.key && Objects.equals(cpf, other.cpf) && Objects.equals(dataCadastro, other.dataCadastro)
				&& Objects.equals(dataNasc, other.dataNasc) && Objects.equals(estadoCivil, other.estadoCivil)
				&& Objects.equals(genero, other.genero) && Objects.equals(gitHub, other.gitHub)
				&& Objects.equals(idioma, other.idioma) && Objects.equals(linkedin, other.linkedin)
				&& Objects.equals(nome, other.nome) && Objects.equals(nomeSocial, other.nomeSocial)
				&& Objects.equals(portfolio, other.portfolio)
				&& Objects.equals(email, other.email)
				&& Objects.equals(tipoPermissao, other.tipoPermissao)
				&& Double.doubleToLongBits(pretensaoSalarial) == Double.doubleToLongBits(other.pretensaoSalarial)
				&& Objects.equals(raca, other.raca) && Objects.equals(sexoBio, other.sexoBio)
				&& Objects.equals(sobre, other.sobre);
	}

}


