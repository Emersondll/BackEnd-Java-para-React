package com.meuprincipe.demo.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

	@GetMapping("/vendasReserv")
	public List<VendaItens> listAllReserv() {
		return new ArrayList<VendaItens>(vendaItensRepository.listAllReserv());
	}

	@GetMapping("/vendasSale")
	public List<VendaItens> listAllSale() {
		return new ArrayList<VendaItens>(vendaItensRepository.listAllSale());
	}

	@GetMapping("/vendasSaleDate/{data}")
	public List<VendaItens> listAllSaleDate(@PathVariable(value = "data") String data) {
		String dateFormatString = data.substring(0, 2) + "/" + data.substring(2, 4) + "/" + data.substring(4, 8);
		return new ArrayList<VendaItens>(vendaItensRepository.listAllSaleDate(dateFormatString));
	}

	@PostMapping("/venda")
	public VendaItens save(@RequestBody VendaItens vendas) {
		return vendaItensRepository.save(vendas);
	}

}
