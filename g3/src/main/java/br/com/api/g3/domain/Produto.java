package br.com.api.g3.domain;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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

 
    @ManyToOne
	@JoinColumn(name="fk_ped_cd_id")
	private Pedido pedidoRel;

	@ManyToOne
	@JoinColumn(name="fk_fun_cd_id")
	private Funcionario funcionarioRel;

	@OneToMany(mappedBy="produtoRel")
	private List<Categoria> categoria;

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

	
	public Produto() {
		
	}
	
	public Produto(Long produtoId, String nome, String descricao, Double valor) {
		this.produtoId = produtoId;
		this.nome = nome;
		this.descricao = descricao;
		this.valor = valor;
		
	}
    


}
