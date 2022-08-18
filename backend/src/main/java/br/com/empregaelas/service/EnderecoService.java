package br.com.empregaelas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.empregaelas.adapter.DozerConverter;
import br.com.empregaelas.domain.vo.v1.EnderecoVO;
import br.com.empregaelas.exceptions.ResourceNotFoundException;
import br.com.empregaelas.repository.EnderecoRepository;

@Service
public class EnderecoService {

	@Autowired
	EnderecoRepository repository;

	public EnderecoVO create(EnderecoVO endereco) {
		var entity = DozerConverter.parseObject(endereco, EnderecoVO.class);
		var vo = DozerConverter.parseObject(entity, EnderecoVO.class);

		return vo;
	}

	public List<EnderecoVO> findAll() {
		return DozerConverter.parseListObject(repository.findAll(), EnderecoVO.class);
	}

	public EnderecoVO findById(Long id) {
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado registro em esse Id"));
		return DozerConverter.parseObject(entity, EnderecoVO.class);
	}

	public void delete(Long id) {
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado registro em esse Id"));
		repository.delete(entity);
	}

	public EnderecoVO update(EnderecoVO endereco) {
		var entity = repository.findById(endereco.getKey())
				.orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado registro com esse Id"));

		entity.setLogradouro(endereco.getLogradouro());
		entity.setNum(endereco.getNum());
		entity.setCompl(endereco.getCompl());
		entity.setBairro(endereco.getBairro());
		entity.setCidade(endereco.getCidade());
		entity.setUf(endereco.getUf());
		entity.setCep(endereco.getCep());
		
		
		
		var vo = DozerConverter.parseObject(repository.save(entity), EnderecoVO.class);
		return vo;
	}
}



