package br.com.helpme.api.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id ;
	
	private String nome ;
	private String telefone ;
	//private String email ;
	private String endereco ;
	private Date data_Cadastro ;

	private String problema ;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name= "nome" , nullable = false)
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Column(name= "telefone" , nullable = false)
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	@Column(name= "endereco" , nullable = false)
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	@Column(name= "problema" , nullable = false)
	public String getProblema() {
		return problema;
	}
	public void setProblema(String problema) {
		this.problema = problema;
	}
	
	@Column(name= "dataCadastro")
	public Date getDataCadastro() {
		return data_Cadastro;
	}
	
	public void setDataCadastro(Date dataCadastro) {
		this.data_Cadastro = dataCadastro;
	}
	
	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", telefone=" + telefone + ", endereco=" + endereco
				+ ", problema=" + problema + ", dataCadastro=" + data_Cadastro + "]";
	}
	
}
