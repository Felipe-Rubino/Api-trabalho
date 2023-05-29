package br.com.api.g3.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "funcionarioId", scope = Funcionario.class)
@Entity
@Table(name="funcionario")
public class Funcionario {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="func_cd_id",nullable=false, unique=true)
    private Long funcionarioId;

    @Column(name="func_tx_nome")
    private String nome;
    
    @Column(name="func_tx_email")
    private String email;
    
    @Column(name="func_bl_ativo")
    private boolean ativo;
    
    @OneToMany(mappedBy="funcionarioRel")
	private List<Produto> produtos;
	
	
	public Funcionario() {
	}

	public Funcionario(Long funcionarioId, String nome, String email, boolean ativo) {
		this.funcionarioId = funcionarioId;
		this.nome = nome;
		this.email = email;
		this.ativo = ativo;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	
		
}


