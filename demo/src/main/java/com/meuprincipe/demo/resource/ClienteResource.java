package com.meuprincipe.demo.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meuprincipe.demo.model.Cliente;
import com.meuprincipe.demo.repository.ClienteRepository;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*")

public class ClienteResource {

	@Autowired
	ClienteRepository clienteRepository;

	@GetMapping("/clientes")
	public List<Cliente> listAll() {
		return clienteRepository.findAll();
	}

	@GetMapping("/cliente/{id}")
	public Cliente findById(@PathVariable(value = "id") long id) {
		return clienteRepository.findById(id);
	}

	@PutMapping("/cliente")
	public Cliente update(@RequestBody Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	@PostMapping("/cliente")
	public Cliente save(@RequestBody Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	@DeleteMapping("/clientes")
	public void delete(@RequestBody Cliente cliente) {
		clienteRepository.delete(cliente);
	}

	@DeleteMapping("/cliente/{id}")
	public void deleteById(@PathVariable(value = "id") long id) {
		clienteRepository.deleteById(id);
	}
}
