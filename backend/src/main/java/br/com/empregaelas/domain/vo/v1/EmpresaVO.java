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
public class EmpresaVO extends RepresentationModel<EmpresaVO> implements Serializable {

	private static final long serialVersionUID = 1L;

	@Mapping("id")
	private long key;
	private String cnpj;
	private USER_PERMISSIONS tipoPermissao;
	private String email;
	private String razaoSocial;
	private String nomeFantasia;
	private String telefone;
	private String responsavel;
	private String segmento;
	private Integer numFunc;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(key, cnpj, email, nomeFantasia, numFunc, razaoSocial, responsavel,
				segmento,telefone, tipoPermissao);
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
		EmpresaVO other = (EmpresaVO) obj;
		return key == other.key && Objects.equals(cnpj, other.cnpj) && Objects.equals(email, other.email)
				&& Objects.equals(nomeFantasia, other.nomeFantasia) && numFunc == other.numFunc
				&& Objects.equals(razaoSocial, other.razaoSocial) && Objects.equals(responsavel, other.responsavel)
				&& Objects.equals(segmento, other.segmento) 
				&& Objects.equals(telefone, other.telefone) && tipoPermissao == other.tipoPermissao;
	}

}
