package br.com.helpme.api.dtos;

import java.sql.Date;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("deprecation")
public class ColaboradorDto {
	
	private int id;
	private String nome;
	private String telefone;
	private String endereco;
	private Date data_Cadastro;
	private String profissao;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@NotEmpty(message = "Nome nao pode ser vazio! ")
	@Length(min = 3 , max = 200, message = "Nome deve conter entre 3 e 200 caracteres. ")
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@NotEmpty(message = "Telefone nao pode ser vazio! ")
	@Length(min = 10 , max = 11, message = "Telefone deve conter entre 10 a 11 caracteres. ")
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	@NotEmpty(message = "Endereco nao pode ser vazio! ")
	@Length(min = 3 , max = 200, message = "Endereco deve conter entre 3 e 200 caracteres. ")
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public Date getData_Cadastro() {
		return data_Cadastro;
	}
	public void setData_Cadastro(Date data_Cadastro) {
		this.data_Cadastro = data_Cadastro;
	}
	
	@NotEmpty(message = "Profissao nao pode ser vazio! ")
	@Length(min = 3 , max = 200, message = "Profissao deve conter entre 3 e 200 caracteres. ")
	public String getProfissao() {
		return profissao;
	}
	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}
	
	@Override
	public String toString() {
		return "ColaboradorDto [id=" + id + ", nome=" + nome + ", telefone=" + telefone + ", endereco=" + endereco
				+ ", data_Cadastro=" + data_Cadastro + ", profissao=" + profissao + "]";
	}
	
}
