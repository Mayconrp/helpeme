package br.com.helpme.api.servicesImp;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.helpme.api.entities.Cliente;
import br.com.helpme.api.repositories.ClienteRepository;
import br.com.helpme.api.services.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {
	
	private static final Logger log = LoggerFactory.getLogger(ClienteServiceImpl.class);

	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente persistir(Cliente cliente) {
		log.info("Persistindo cliente: {}", cliente);
		return this.clienteRepository.save(cliente);
	}
	
	public Optional<Cliente> buscarPorTelefone(String telefone) {
		//log.info("Buscando cliente pelo Telefone {}", telefone);
		return Optional.ofNullable(this.clienteRepository.findByTelefone(telefone));
	}
	
	public Optional<Cliente> buscarPorId(Long id) {
		log.info("Buscando cliente pelo ID {}", id);		
		return this.clienteRepository.findById(id); 
	}
	
	public List<Cliente> listagem(){
		log.info("Iniciando listagem de clientes {}");	
		return this.clienteRepository.findAll();
	}
	
	 
}
