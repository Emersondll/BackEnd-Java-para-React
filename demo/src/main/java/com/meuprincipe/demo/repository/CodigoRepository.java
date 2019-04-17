package com.meuprincipe.demo.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.meuprincipe.demo.model.Codigo;



public interface CodigoRepository extends JpaRepository<Codigo, Long> {

	@Query(value = "SELECT id, codigo,TRIM(lpad(sequencia,4,'0')) as sequencia, descricao FROM CODIGO  WHERE CODIGO = UPPER(?)", nativeQuery = true)
	Codigo getSequecy(String codigo);
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE CODIGO SET SEQUENCIA = (SELECT CAST(coalesce(SEQUENCIA, '0') AS integer) +1 as SEQUENCIA  FROM CODIGO WHERE CODIGO = UPPER(?))  WHERE CODIGO = UPPER(?)", nativeQuery = true)
	void updateSequecy(String codigo1, String codigo2);


}
