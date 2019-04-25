package com.meuprincipe.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meuprincipe.demo.model.SaidaItens;

public interface SaidaItensRepository extends JpaRepository<SaidaItens, Long> {

	SaidaItens findById(long id);

}
