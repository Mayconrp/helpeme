package br.com.helpme.api.controllers;

import java.security.NoSuchAlgorithmException;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.helpme.api.dtos.ClienteDto;
import br.com.helpme.api.entities.Cliente;
import br.com.helpme.api.response.Response;
import br.com.helpme.api.services.ClienteService;

@RestController
@RequestMapping("/cadastrar-cliente") 

// mapeia para aceitar requisições de diversos lugares, o ideal e mapear para uma url padrão
@CrossOrigin(origins = "*")
public class CadastroClienteController {

	private static final Logger log = LoggerFactory.getLogger(CadastroClienteController.class);

	@Autowired
	private ClienteService clienteService;

	public CadastroClienteController() {
	}

	/**
	 * Cadastra um cliente no sistema.
	 * 
	 * @param clienteDto
	 * @param result
	 * @return ResponseEntity<Response<clienteDto>>
	 * @throws NoSuchAlgorithmException
	 */
	@PostMapping
	// pegar os dados da requisicao e transformar em dto
	public ResponseEntity<Response<ClienteDto>> cadastrar(@Valid @RequestBody ClienteDto clienteDto,
			BindingResult result) throws NoSuchAlgorithmException {
		
		//log.info("Cadastrando: {}", clienteDto.toString());
		Response<ClienteDto> response = new Response<ClienteDto>();

		validarDadosExistentes(clienteDto, result);
		// conversao de dto pra objeto cliente
		Cliente cliente = this.converterDtoParaCliente(clienteDto, result);

		if (result.hasErrors()) {
			log.error("Erro validando dados de cadastro: {}", result.getAllErrors());
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		
		this.clienteService.persistir(cliente);
			
		response.setData(this.converterClienteDto(cliente));
		return ResponseEntity.ok(response);
	}


	/**
	 * Verifica se cliente já existe na base de dados pelo telefone.
	 * 
	 * @param clienteDto
	 * @param result
	 */
	private void validarDadosExistentes(ClienteDto clienteDto, BindingResult result) {
		this.clienteService.buscarPorTelefone(clienteDto.getTelefone())
			.ifPresent(func -> result.addError(new ObjectError("Cliente", "Telefone já existente.")));
	}

	/**
	 * Converte os dados do DTO para cliente.
	 * 
	 * @param clienteDto
	 * @param result
	 * @return Cliente
	 * @throws NoSuchAlgorithmException
	 */
	private Cliente converterDtoParaCliente(ClienteDto clienteDto, BindingResult result)
		throws NoSuchAlgorithmException {
			Cliente cliente = new Cliente();
			cliente.setNome(clienteDto.getNome());
			//cliente.setDataCadastro(clienteDto.getDataCadastro());
			cliente.setTelefone(clienteDto.getTelefone());
			cliente.setEndereco(clienteDto.getEndereco());
			cliente.setProblema(clienteDto.getProblema());
			return cliente;
	}
	
	/**
	 * Converte os dados do cliente para dto.
	 * 
	 * @param cliente
	 * @param result
	 * @return ClienteDto
	 * @throws NoSuchAlgorithmException
	 */
	private ClienteDto converterClienteDto(Cliente cliente) {
		ClienteDto cadastroClienteDto = new ClienteDto();
		cadastroClienteDto.setNome(cliente.getNome());
		cadastroClienteDto.setTelefone(cliente.getTelefone());
		cadastroClienteDto.setEndereco(cliente.getEndereco());
		cadastroClienteDto.setProblema(cliente.getProblema());
		return cadastroClienteDto;
	}
}
