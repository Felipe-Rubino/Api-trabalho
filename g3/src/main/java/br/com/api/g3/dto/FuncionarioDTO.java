package br.com.api.g3.dto;

public class FuncionarioDTO {
	
	private Long funcionarioId;
	private String nome;
	private String email;
	private boolean ativo;
	
	public FuncionarioDTO(boolean ativo) {
		this.ativo = ativo;
	}
	public FuncionarioDTO(String nome) {
			this.nome = nome;
		
	}
	
	public FuncionarioDTO() {
	}
	
	public FuncionarioDTO(Long funcionarioId,String nome, String email) {
		
		this.funcionarioId = funcionarioId;
		this.nome = nome;
		this.email = email;
	}
	
	
	
	public Long getFuncionarioId() {
		return funcionarioId;
	}
	public void setFuncionarioId(Long funcionarioId) {
		this.funcionarioId = funcionarioId;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
	
	
	
}
