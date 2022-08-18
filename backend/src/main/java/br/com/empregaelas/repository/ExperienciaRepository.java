package br.com.empregaelas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.empregaelas.domain.entity.Experiencia;

@Repository
public interface ExperienciaRepository extends JpaRepository<Experiencia, Long> {

	List<Experiencia> findById(String nome);

}
