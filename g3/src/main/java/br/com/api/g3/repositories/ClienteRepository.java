package br.com.api.g3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.g3.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
