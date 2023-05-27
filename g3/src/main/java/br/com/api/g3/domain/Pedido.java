package br.com.api.g3.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="num_cd_id", nullable=false, unique=true)
    private Long numeroPedido;


}
