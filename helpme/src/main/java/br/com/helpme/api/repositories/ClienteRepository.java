package br.com.helpme.api.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import br.com.helpme.api.entities.Cliente;

@Transactional(readOnly = true)
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	
	Cliente findByTelefone(String telefone);
	

	Optional<Cliente> findById(Long id); 
}
