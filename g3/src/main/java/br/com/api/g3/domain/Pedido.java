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
@Table(name="pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ped_cd_id", nullable=false, unique=true)
    private Long pedidoId;

	@OneToMany(mappedBy="pedidoRel")
	private List<Produto> produtos;

	@ManyToOne
	@JoinColumn(name="fk_cli_cd_id")
	private Cliente cliente;



	public Pedido(Long pedidoId) {
		this.pedidoId = pedidoId;
	}
	
	public Pedido() {
	}

	public Long getPedidoId() {
		return pedidoId;
	}

	public void setPedidoId(Long pedidoId) {
		this.pedidoId = pedidoId;
	}

    
}
