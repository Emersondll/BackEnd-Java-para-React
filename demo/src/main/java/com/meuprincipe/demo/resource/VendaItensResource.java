package com.meuprincipe.demo.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meuprincipe.demo.model.VendaItens;
import com.meuprincipe.demo.repository.VendaItensRepository;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*")
public class VendaItensResource {

	@Autowired
	VendaItensRepository vendaItensRepository;

	@GetMapping("/vendas")
	public List<VendaItens> listAll() {
		return vendaItensRepository.findAll();
	}
	
	@GetMapping("/vendasConsolidadas")
	public ArrayList<Object> listAllCost() {
		return new ArrayList<Object>(vendaItensRepository.listAllCost());
	}

	@PostMapping("/venda")
	public VendaItens save(@RequestBody VendaItens vendas) {
		return vendaItensRepository.save(vendas);
	}

}
