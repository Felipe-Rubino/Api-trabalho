package br.com.api.g3.dto;

public class ClienteDTO {
	private String nome;
	
	private String cpf;
	
	private String email;
	
	private boolean ativo;
	
	private String numero;
	
	
	private String cep;
	
	
	
	
	public ClienteDTO() {
		
	}
	
	public ClienteDTO(String nome, String cpf, String email, String cep, boolean ativo, String numero) {
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.cep = cep;
		this.ativo = ativo;
		this.numero = numero;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
	
}
