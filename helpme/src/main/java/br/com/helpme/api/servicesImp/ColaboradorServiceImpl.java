package br.com.helpme.api.servicesImp;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.helpme.api.entities.Colaborador;
import br.com.helpme.api.repositories.ColaboradorRepository;
import br.com.helpme.api.services.ColaboradorService;

@Service
public class ColaboradorServiceImpl implements ColaboradorService{
	
	private static final Logger log = LoggerFactory.getLogger(ColaboradorService.class);
	
	@Autowired
	private ColaboradorRepository colaboradorRepository;

	public Colaborador persistir(Colaborador colaborador) {
		log.info("Persistindo colaborador: {}", colaborador);
		return this.colaboradorRepository.save(colaborador);
	}

	public Optional<Colaborador> buscarPorTelefone(String telefone) {
		log.info("Buscando cliente pelo Telefone {}", telefone);
		return Optional.ofNullable(this.colaboradorRepository.findByTelefone(telefone));
	}

	public Optional<Colaborador> buscarPorId(Long id) {
		log.info("Buscando colaborador pelo ID {}", id);
		return this.colaboradorRepository.findById(id);
	}

	public List<Colaborador> listagem() {
		log.info("Iniciando listagem de colaboradores {}");
		return this.colaboradorRepository.findAll();
	}
	

}
