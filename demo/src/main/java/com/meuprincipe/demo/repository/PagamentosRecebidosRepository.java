package com.meuprincipe.demo.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.meuprincipe.demo.model.PagamentosRecebidos;

public interface PagamentosRecebidosRepository extends JpaRepository<PagamentosRecebidos, Long> {
	
	PagamentosRecebidos findById(long id);
	
	@Query(value = "SELECT *  FROM pagamentos_recebidos where id_cliente = ?", nativeQuery = true)
	Collection<PagamentosRecebidos> listFilter(Integer id);

}
