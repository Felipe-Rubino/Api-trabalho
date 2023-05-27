package br.com.api.g3.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="funcionario")
public class Funcionario {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="func_cd_id",nullable=false, unique=true)
    private Long funcionarioId;

    @Column(name="func_tx_nome")
    private String nome;
	
	public Funcionario() {
	}

	public Funcionario(Long funcionarioId, String nome) {
		this.funcionarioId = funcionarioId;
		this.nome = nome;
	}
	public Long getFuncionarioId() {
		return funcionarioId;
	}
	public void setFuncionarioId(Long funcionarioId) {
		this.funcionarioId = funcionarioId;
	}
	public String getNome() {
			return nome;
	}
	public void setNome(String nome) {
			this.nome = nome;
	}
		
}


