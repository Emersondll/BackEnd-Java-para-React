package com.meuprincipe.demo.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meuprincipe.demo.model.SaidaItens;
import com.meuprincipe.demo.repository.SaidaItensRepository;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*")
public class SaidaItensResource {

	@Autowired
	SaidaItensRepository saidaItensRepository;

	@GetMapping("/saidaItens")
	public List<SaidaItens> listAll() {
		return saidaItensRepository.findAll();
	}

}
