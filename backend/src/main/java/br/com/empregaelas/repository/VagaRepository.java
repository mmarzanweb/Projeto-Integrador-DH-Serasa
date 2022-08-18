package br.com.empregaelas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.empregaelas.domain.entity.Vaga;

@Repository
public interface VagaRepository extends JpaRepository<Vaga, Long> { 
	
	List<Vaga> findByPublicada(String publicada);
	
	Vaga findByTipoContrato(String tipoContrato);
}

