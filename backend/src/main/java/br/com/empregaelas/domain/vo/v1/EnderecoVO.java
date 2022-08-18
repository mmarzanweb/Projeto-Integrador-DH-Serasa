package br.com.empregaelas.domain.vo.v1;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.hateoas.RepresentationModel;

import com.github.dozermapper.core.Mapping;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnderecoVO extends RepresentationModel<EnderecoVO> implements Serializable {

	private static final long serialVersionUID = 1L;

	@Mapping("id")
	private long Key;
	private String logradouro;
	private String num;
	private String compl;
	private String bairro;
	private String cidade;
	private String uf;
	private String cep;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(Key, bairro, cep, cidade, compl, logradouro, num, uf);
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
		EnderecoVO other = (EnderecoVO) obj;
		return Key == other.Key && Objects.equals(bairro, other.bairro) && Objects.equals(cep, other.cep)
				&& Objects.equals(cidade, other.cidade) && Objects.equals(compl, other.compl)
				&& Objects.equals(logradouro, other.logradouro) && Objects.equals(num, other.num)
				&& Objects.equals(uf, other.uf);
	}

}
   

