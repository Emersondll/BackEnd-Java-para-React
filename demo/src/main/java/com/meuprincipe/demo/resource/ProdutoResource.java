package com.meuprincipe.demo.resource;

import java.util.ArrayList;
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

import com.meuprincipe.demo.model.Produto;
import com.meuprincipe.demo.model.ProdutoTamanho;
import com.meuprincipe.demo.repository.CodigoRepository;
import com.meuprincipe.demo.repository.ProdutoRepository;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*")
public class ProdutoResource {

	@Autowired
	ProdutoRepository produtoRepository;

	@Autowired
	CodigoRepository codigoRepository;

	@GetMapping("/produtos")
	public List<Produto> listAll() {
		return produtoRepository.findAll();
	}

	@GetMapping("/produtoDisponivel")
	public List<Produto> listAllDisponivel() {
		return new ArrayList<Produto>(produtoRepository.listAllDisponivel());
	}

	@GetMapping("/produtos/{filter}/{genero}")
	public List<Produto> listFilter(@PathVariable(value = "filter") String filter,
			@PathVariable(value = "genero") String genero) {

		String frase = genero;
		String array[] = new String[3];
		array = frase.split(",");
		ArrayList<Produto> produtosTamanhoGenero = new ArrayList<Produto>();

		if (array.length == 1) {
			produtosTamanhoGenero = (ArrayList<Produto>) produtoRepository.listFilterType(filter, filter,array[0]);
		}
		if (array.length == 2) {
			produtosTamanhoGenero = (ArrayList<Produto>) produtoRepository.listFilterType(filter, filter, array[0], array[1]);
		}
		if (array.length == 3) {
			produtosTamanhoGenero = (ArrayList<Produto>) produtoRepository.listFilterType(filter, filter,array[0], array[1], array[2]);
		}

		return produtosTamanhoGenero;
	

	}

	@GetMapping("/produtos/type/{genero}")
	public List<Produto> listType(@PathVariable(value = "genero") String genero) {

		String frase = genero;
		String array[] = new String[3];
		array = frase.split(",");
		ArrayList<Produto> produtosGenero = new ArrayList<Produto>();

		if (array.length == 1) {
			produtosGenero = (ArrayList<Produto>) produtoRepository.listType(array[0]);
		}
		if (array.length == 2) {
			produtosGenero = (ArrayList<Produto>) produtoRepository.listType(array[0], array[1]);
		}
		if (array.length == 3) {
			produtosGenero = (ArrayList<Produto>) produtoRepository.listType(array[0], array[1], array[2]);
		}

		return produtosGenero;
	}

	@GetMapping("/produto/{id}")
	public Produto listById(@PathVariable(value = "id") long id) {
		return produtoRepository.findById(id);
	}

	@GetMapping("/produtosDate/{text}")
	public List<Produto> listFilterDate(@PathVariable(value = "text") String text) {
		String dateFormatString = text.substring(0, 2) + "/" + text.substring(2, 4) + "/" + text.substring(4, 8);
		return new ArrayList<Produto>(produtoRepository.listFilterDate(dateFormatString));
	}

	/*
	 * @PostMapping("/produto") public Produto save(@RequestBody Produto produto,
	 * Tamanho tamanho) { System.out.println(produto.toString());
	 * System.out.println(tamanho.toString()); return
	 * produtoRepository.save(produto); }
	 */

	@PostMapping("/produto")
	public ProdutoTamanho save(@RequestBody ProdutoTamanho pt) {
		codigoRepository.updateSequecy(pt.getProduto().getCodigo(), pt.getProduto().getCodigo());
		return produtoRepository.salvar(pt, codigoRepository.getSequecy(pt.getProduto().getCodigo()));

	}

	@DeleteMapping("/produto/{id}")
	public void delete(@PathVariable(value = "id") Integer id) {
		produtoRepository.deleteById(id);

	}

	@DeleteMapping("/produto")
	public void delete(@RequestBody Produto produto) {
		produtoRepository.delete(produto);

	}

	@PutMapping("/produto")
	public Produto update(@RequestBody Produto produto) {
		System.out.println("");
		return produtoRepository.save(produto);
	}

	@PostMapping("/ajusteProduto/{id}/{qtd}")
	public void AjusteProduto(@PathVariable(value = "id") Integer id, @PathVariable(value = "qtd") Integer qtd) {
		produtoRepository.UpdateEstoque(produtoRepository.findById(id).getQuantidade() - qtd, id);

	}

}
