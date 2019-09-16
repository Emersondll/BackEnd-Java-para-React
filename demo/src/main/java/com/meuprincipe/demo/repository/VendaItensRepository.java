package com.meuprincipe.demo.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.meuprincipe.demo.model.VendaItens;

public interface VendaItensRepository extends JpaRepository<VendaItens, Long> {

	VendaItens findById(long id);

	@Query(value = "SELECT * FROM venda where upper(motivo) = upper('Reservado') order by data_atualizacao desc, id_cliente", nativeQuery = true)
	Collection<VendaItens> listAllReserv();

	@Query(value = "SELECT * FROM venda where upper(motivo) = upper('Venda') order by data_atualizacao desc, id_cliente", nativeQuery = true)
	Collection<VendaItens> listAllSale();

	@Query(value = "SELECT * FROM venda where  to_date(data_atualizacao,'dd/MM/YYYY') >= to_date(?,'dd/MM/YYYY') order by data_atualizacao desc, id_cliente", nativeQuery = true)
	Collection<VendaItens> listAllSaleDate(String data);

}
