package com.meuprincipe.demo.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meuprincipe.demo.model.PagamentosRecebidos;
import com.meuprincipe.demo.repository.PagamentosRecebidosRepository;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*")
public class PagamentosRecebidosResource {

	@Autowired
	PagamentosRecebidosRepository pagamentosRecebidosRepository;

	@GetMapping("/PagamentosRecebidos")
	public List<PagamentosRecebidos> listAll() {
		return pagamentosRecebidosRepository.findAll();
	}
	
	@GetMapping("/PagamentosRecebidos/{id}")
	public List<PagamentosRecebidos> listFilter(@PathVariable(value = "id") Integer id) {
		return new ArrayList<PagamentosRecebidos>( pagamentosRecebidosRepository.listFilter(id));
	}

	@PutMapping("/PagamentosRecebidos")
	public PagamentosRecebidos update(@RequestBody PagamentosRecebidos pg) {
		return pagamentosRecebidosRepository.save(pg);
	}

	@PostMapping("/PagamentosRecebidos")
	public PagamentosRecebidos save(@RequestBody PagamentosRecebidos pg) {
		return pagamentosRecebidosRepository.save(pg);
	}

}
