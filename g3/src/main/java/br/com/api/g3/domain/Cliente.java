package br.com.api.g3.domain;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "clienteId", scope = Cliente.class)
@Entity
@Table(name = "cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cli_cd_id")
	private Long clienteId;

	@Column(name = "cli_tx_nome")
	private String nome;

	@Column(name = "cli_tx_cpf")
	private String cpf;

	@Column(name = "cli_tx_email")
	private String email;

	@Column(name = "cli_bl_ativo")
	private boolean ativo;

	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "cliente_endereco", joinColumns = @JoinColumn(name = "fk_cli_cd_id"), inverseJoinColumns = @JoinColumn(name = "fk_end_cd_id"))
	private List<Endereco> endereco;

	public Cliente() {
		this.endereco = new ArrayList<Endereco>();
	}

	public void CadastrarEndereco(Endereco endereco) {
		this.endereco.add(endereco);

	}

	public Cliente(Long clienteId, String nome, String cpf, String email, boolean ativo, List<Endereco> endereco) {
		super();
		this.clienteId = clienteId;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.ativo = ativo;
		this.endereco = endereco;
	}

	public Long getClienteId() {
		return clienteId;
	}

	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
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

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public List<Endereco> getEndereco() {
		return endereco;
	}

	public void setEndereco(List<Endereco> enderecos) {
		this.endereco = enderecos;
	}

}
