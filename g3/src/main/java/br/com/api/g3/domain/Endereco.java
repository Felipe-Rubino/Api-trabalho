package br.com.api.g3.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="endereco")
public class Endereco {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="end_cd_id")
	private Integer enderecoId;
	
	@Column(name="end_tx_cep")
	private String cep;
	
	@Column(name="end_tx_logradouro")
	private String logradouro;
	
	@Column(name="end_tx_bairro")
	private String bairro;
	
	@Column(name="end_tx_localidade")
	private String localidade;
	
	@Column(name="end_tx_uf")
	private String uf;
	
	@Column(name="end_tx_num")
	private String numero;
	
//	@OneToMany(mappedBy="endereco")
//	private List<Cliente> clientes;
		
	
	public Endereco() {
	}
	
	public Endereco(Integer enderecoId, String cep, String logradouro, String bairro, String localidade, String uf,
			String numero) {
		this.enderecoId = enderecoId;
		this.cep = cep;
		this.logradouro = logradouro;
		this.bairro = bairro;
		this.localidade = localidade;
		this.uf = uf;
		this.numero = numero;
	}

	public Integer getEnderecoId() {
		return enderecoId;
	}

	public void setEnderecoId(Integer enderecoId) {
		this.enderecoId = enderecoId;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getLocalidade() {
		return localidade;
	}

	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
}
