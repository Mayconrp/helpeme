package br.com.helpme.api.controllers;


import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.helpme.api.entities.Cliente;
import br.com.helpme.api.services.ClienteService;
import br.com.helpme.api.servicesImp.ClienteServiceImpl;
import javassist.bytecode.stackmap.TypeData.ClassName;

@RestController
@RequestMapping("/clientes") 

@CrossOrigin(origins = "*")
public class ListagemClienteController {
	
	private static final org.slf4j.Logger log = LoggerFactory.getLogger(ListagemClienteController.class);
	
	@Autowired
	private ClienteService clienteService;

	@RequestMapping(method = RequestMethod.GET)
    public List<Cliente> AllClientes(){		
		try {	 
			return clienteService.listagem();
		} catch( Exception ex ) {
			log.info("Erro --> " + ex);
		}	
		return null;
	}
}
