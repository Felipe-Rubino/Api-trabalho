package br.com.api.g3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.g3.domain.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
