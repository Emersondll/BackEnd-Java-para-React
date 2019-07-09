package com.meuprincipe.demo.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meuprincipe.demo.model.Resumo;
import com.meuprincipe.demo.repository.ResumoRepository;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*")
public class ResumoResource {

	@Autowired
	ResumoRepository resumoRepository;

	@GetMapping("/vendasConsolidadas")
	public List<Resumo> listAll() {
		return new ArrayList<Resumo>(resumoRepository.listAllResume());
	}
	
	@GetMapping("/vendasConsolidadasFilter/{id}")
	public List<Resumo> listResumeFilter(@PathVariable(value = "id") Integer id) {
		return new ArrayList<Resumo>(resumoRepository.listResumeFilter(id));
	}

}
