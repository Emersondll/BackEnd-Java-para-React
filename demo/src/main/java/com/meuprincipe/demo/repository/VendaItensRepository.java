package com.meuprincipe.demo.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.meuprincipe.demo.model.VendaItens;

public interface VendaItensRepository extends JpaRepository<VendaItens, Long> {
	
	VendaItens findById(long id);
	
	@Query(value = "SELECT id_cliente, nome_cliente, sum(venda), data_atualizacao\r\n" + 
			"  FROM venda group by id_cliente,nome_cliente, data_atualizacao\r\n" + 
			"  order by id_cliente, data_atualizacao desc;", nativeQuery = true)
	Collection<Object> listAllCost();
	

}
