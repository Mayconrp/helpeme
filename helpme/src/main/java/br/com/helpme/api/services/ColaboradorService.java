package br.com.helpme.api.services;

import java.util.List;
import java.util.Optional;
import br.com.helpme.api.entities.Colaborador;

public interface ColaboradorService {

	/**
	 * Persiste um Colaborador na base de dados.
	 * 
	 * @param Colaborador
	 * @return Colaborador
	 */
	Colaborador persistir(Colaborador colaborador);
	
	/**
	 * Busca e retorna um Colaborador dado um telefone.
	 * 
	 * @param email
	 * @return Optional<Colaborador>
	 */
	Optional<Colaborador> buscarPorTelefone(String telefone);
	
	
	/**
	 * Busca e retorna um colaborador por ID.
	 * 
	 * @param id
	 * @return Optional<Colaborador>
	 */
	Optional<Colaborador> buscarPorId(Long id);
	
	
	public List<Colaborador> listagem();
}
