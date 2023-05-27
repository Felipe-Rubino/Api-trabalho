package br.com.api.g3.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="categoria")
public class Categoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long categoriaId;
	
	@Column(name="cat_tx_nome")
	private String nome;
	
	@Column(name="cat_tx_desc")
	private String descricao;
	
	
	public Categoria() {
		
	}

	public Categoria(Long categoriaId, String nome, String descricao) {
		super();
		this.categoriaId = categoriaId;
		this.nome = nome;
		this.descricao = descricao;
	}

	public Long getCategoriaId() {
		return categoriaId;
	}

	public void setCategoriaId(Long categoriaId) {
		this.categoriaId = categoriaId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	
	
	
	
	
	
}
