package com.meuprincipe.demo.repository;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.meuprincipe.demo.model.Codigo;
import com.meuprincipe.demo.model.Produto;
import com.meuprincipe.demo.model.ProdutoTamanho;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

	Produto findById(long id);

	@Query(value = "SELECT distinct P.* FROM PRODUTO P WHERE P.QUANTIDADE > 0", nativeQuery = true)
	Collection<Produto> listAllDisponivel();

	@Query(value = "SELECT *  FROM produto where (codigo =upper(?) or tamanho = upper(?)) and tipo in(?)", nativeQuery = true)
	Collection<Produto> listFilterType(String filter, String filter2, String genero1);

	@Query(value = "SELECT *  FROM produto where (codigo =upper(?) or tamanho = upper(?)) and tipo in(?,?)", nativeQuery = true)
	Collection<Produto> listFilterType(String filter, String filter2, String genero1, String genero2);

	@Query(value = "SELECT *  FROM produto where (codigo =upper(?) or tamanho = upper(?)) and tipo in(?,?,?)", nativeQuery = true)
	Collection<Produto> listFilterType(String filter, String filter2, String genero1, String genero2, String genero3);

	@Query(value = "SELECT *  FROM produto where tipo in(?)", nativeQuery = true)
	Collection<Produto> listType(String genero);

	@Query(value = "SELECT *  FROM produto where tipo in(?,?)", nativeQuery = true)
	Collection<Produto> listType(String genero, String genero2);

	@Query(value = "SELECT *  FROM produto where tipo in(?,?,?)", nativeQuery = true)
	Collection<Produto> listType(String genero, String genero2, String genero3);

	@Query(value = "select * from produto where to_date(data_cadastro,'dd/MM/YYYY') >= to_date(?,'dd/MM/YYYY')", nativeQuery = true)
	Collection<Produto> listFilterDate(String dateFormatString);

	@Modifying
	@Transactional
	@Query(value = "UPDATE PRODUTO SET QUANTIDADE = ? WHERE ID = ?", nativeQuery = true)
	void UpdateEstoque(Integer qtd, Integer id);

	@Modifying
	@Transactional
	@Query(value = "DELETE FROM produto WHERE id= ?", nativeQuery = true)
	void deleteById(Integer id);

	default ProdutoTamanho salvar(ProdutoTamanho pt, Codigo codigo) {
		Class<?> classe = pt.getTamanho().getClass();
		Field[] campos = classe.getDeclaredFields();
		List<Produto> produtoList = new ArrayList<Produto>();
		Integer count = 0;
		Calendar c = Calendar.getInstance();
		Date data = c.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		for (Field campo : campos) {
			try {
				String str, str2 = "";
				campo.setAccessible(true);

				if ((boolean) campo.get(pt.getTamanho())) {

					++count;
					if (count < 10) {
						str2 = "0";
					}

					Produto produto = new Produto();
					produto.setCategoria(pt.getProduto().getCategoria());
					produto.setCodigo(pt.getProduto().getCodigo());
					produto.setCusto(pt.getProduto().getCusto());
					produto.setEstacao(pt.getProduto().getEstacao());
					produto.setProduto(pt.getProduto().getProduto());
					produto.setPromocao(pt.getProduto().getPromocao());
					produto.setQuantidade(pt.getProduto().getQuantidade());
					produto.setTipo(pt.getProduto().getTipo());
					produto.setTamanho(campo.getName().toUpperCase());
					produto.setVenda(pt.getProduto().getVenda());
					produto.setDataCadastro(sdf.format(data));

					if (produto.getTamanho().toUpperCase().contains("U")) {
						str = pt.getProduto().getCodigo().toUpperCase() + "T" + produto.getTamanho()
								+ codigo.getSequencia().toString() + str2 + count;
					}

					else if (produto.getTamanho().length() >= 2) {
						str = pt.getProduto().getCodigo().toUpperCase() + produto.getTamanho()
								+ codigo.getSequencia().toString() + str2 + count;
					}

					else if (produto.getTamanho().toUpperCase().contains("P")
							|| produto.getTamanho().toUpperCase().contains("M")
							|| produto.getTamanho().toUpperCase().contains("G")) {

						str = pt.getProduto().getCodigo().toUpperCase() + produto.getTamanho() + "0"
								+ codigo.getSequencia().toString() + str2 + count;
					} else
						str = pt.getProduto().getCodigo().toUpperCase() + "0" + produto.getTamanho()
								+ codigo.getSequencia().toString() + str2 + count;

					produto.setCodigo(str);
					produtoList.add(produto);
				}
				saveAll(produtoList);
			} catch (IllegalArgumentException | IllegalAccessException e) {
				System.out.println("erro");
				e.printStackTrace();
			}
		}
		return pt;
	}

}
