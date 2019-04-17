package com.meuprincipe.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meuprincipe.demo.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	Cliente findById(long id);

}
