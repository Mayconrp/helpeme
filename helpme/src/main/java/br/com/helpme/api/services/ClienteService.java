package br.com.helpme.api.services;

import java.util.List;
import java.util.Optional;
import br.com.helpme.api.entities.Cliente;

public interface ClienteService {
	
	/**
	 * Persiste um cliente na base de dados.
	 * 
	 * @param cliente
	 * @return Cliente
	 */
	Cliente persistir(Cliente cliente);
	
	/**
	 * Busca e retorna um cliente dado um telefone.
	 * 
	 * @param email
	 * @return Optional<Cliente>
	 */
	Optional<Cliente> buscarPorTelefone(String telefone);
	
	
	/**
	 * Busca e retorna um cliente por ID.
	 * 
	 * @param id
	 * @return Optional<Cliente>
	 */
	Optional<Cliente> buscarPorId(Long id);
	
	
	public List<Cliente> listagem();
	

}
