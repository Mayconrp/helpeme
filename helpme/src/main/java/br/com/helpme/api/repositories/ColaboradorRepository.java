package br.com.helpme.api.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import br.com.helpme.api.entities.Colaborador;

@Transactional(readOnly = true)
public interface ColaboradorRepository extends JpaRepository<Colaborador, Long> {

	Colaborador findByTelefone(String telefone);
	
	Optional<Colaborador> findById(Long id);
	
}
