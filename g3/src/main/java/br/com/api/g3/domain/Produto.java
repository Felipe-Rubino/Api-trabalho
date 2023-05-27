package br.com.api.g3.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="produto")
public class Produto {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)

    @Column(name="prod_cd_id",nullable=false, unique=true)
    private Long produtoId;

    @Column(name="prod_tx_nome")
    private String nome;

    @Column(name="prod_tx_descricao")
    private String descricao;

    @Column(name="prod_nm_valor")
    private Double valor;

    @Column(name="prod_int_estoque")
    private int estoque;

    
	public Long getProdutoId() {
		return produtoId;
	}

	public void setProdutoId(Long produtoid) {
		this.produtoId = produtoid;
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

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public int getEstoque() {
		return estoque;
	}

	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}

	public Produto() {
		
	}
	
	public Produto(Long produtoId, String nome, String descricao, Double valor, int estoque) {
		this.produtoId = produtoId;
		this.nome = nome;
		this.descricao = descricao;
		this.valor = valor;
		this.estoque = estoque;
	}
    


}
