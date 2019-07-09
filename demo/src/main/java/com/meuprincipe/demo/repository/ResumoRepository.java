package com.meuprincipe.demo.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.meuprincipe.demo.model.Resumo;

public interface ResumoRepository extends JpaRepository<Resumo, Long> {

	@Query(value = "select * from ResumoVendas", nativeQuery = true)
	Collection<Resumo> listAllResume();
	
	
	@Query(value = "select * from ResumoVendas where id_cliente = ?", nativeQuery = true)
	Collection<Resumo> listResumeFilter(Integer id);
	

}
