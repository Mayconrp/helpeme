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

import br.com.helpme.api.dtos.ColaboradorDto;
import br.com.helpme.api.entities.Colaborador;
import br.com.helpme.api.response.Response;
import br.com.helpme.api.services.ColaboradorService;

@RestController
@RequestMapping("/cadastrar-colaborador")

//mapeia para aceitar requisições de diversos lugares, o ideal e mapear para uma url padrão
@CrossOrigin(origins = "*")
public class CadastroColaboradorController {
	
	private static final Logger log = LoggerFactory.getLogger(CadastroColaboradorController.class);
	
	@Autowired
	private ColaboradorService colaboradorService;
	
	public CadastroColaboradorController(){
	}
	
	/**
	 * Cadastra um colaborador no sistema.
	 * 
	 * @param colaboradorDto
	 * @param result
	 * @return ResponseEntity<Response<colaboradorDto>>
	 * @throws NoSuchAlgorithmException
	 */
	
	@PostMapping
	public ResponseEntity<Response<ColaboradorDto>> cadastrar(@Valid @RequestBody ColaboradorDto colaboradorDto,
			BindingResult result) throws NoSuchAlgorithmException {
		
		//log.info("Cadastrando: {}", colaboradorDto.toString());
		Response<ColaboradorDto> response = new Response<ColaboradorDto>();
		
		validarDadosExistentes(colaboradorDto, result);
		
		Colaborador colaborador = this.converterDtoParaColaborador(colaboradorDto, result);
		
		if (result.hasErrors()) {
			log.error("Erro validando dados de cadastro: {}", result.getAllErrors());
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		
		this.colaboradorService.persistir(colaborador);
		
		response.setData(this.converterColaboradorDto(colaborador));
		return ResponseEntity.ok(response);
	}
	
	/**
	 * Verifica se colaborador já existe na base de dados pelo telefone.
	 * 
	 * @param colaboradorDto
	 * @param result
	 */
	
	private void validarDadosExistentes(ColaboradorDto colaboradorDto, BindingResult result) {
		this.colaboradorService.buscarPorTelefone(colaboradorDto.getTelefone())
		.ifPresent(func -> result.addError(new ObjectError("Cliente", "Telefone já existente.")));
	}
	
	/**
	 * Converte os dados do DTO para colaborador.
	 * 
	 * @param colaboradorDto
	 * @param result
	 * @return Colaborador
	 * @throws NoSuchAlgorithmException
	 */
	
	private Colaborador converterDtoParaColaborador(ColaboradorDto colaboradorDto, BindingResult result) 
		throws NoSuchAlgorithmException{
			Colaborador colaborador = new Colaborador();
			colaborador.setNome(colaboradorDto.getNome());
			colaborador.setTelefone(colaboradorDto.getTelefone());
			colaborador.setEndereco(colaboradorDto.getEndereco());
			colaborador.setProfissao(colaboradorDto.getProfissao());
			return colaborador;
	}
	
	/**
	 * Converte os dados do colaborador para dto.
	 * 
	 * @param colaborador
	 * @param result
	 * @return ColabpradorDto
	 * @throws NoSuchAlgorithmException
	 */
	
	private ColaboradorDto converterColaboradorDto(Colaborador colaborador) {
		ColaboradorDto cadastroColaboradorDto = new ColaboradorDto();
		cadastroColaboradorDto.setNome(colaborador.getNome());
		cadastroColaboradorDto.setTelefone(colaborador.getTelefone());
		cadastroColaboradorDto.setEndereco(colaborador.getEndereco());
		cadastroColaboradorDto.setProfissao(colaborador.getProfissao());
		return cadastroColaboradorDto;
	}
}
