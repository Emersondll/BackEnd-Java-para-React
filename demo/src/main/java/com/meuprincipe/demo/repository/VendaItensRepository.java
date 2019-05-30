package com.meuprincipe.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meuprincipe.demo.model.VendaItens;

public interface VendaItensRepository extends JpaRepository<VendaItens, Long> {
	
	VendaItens findById(long id);
	

}
