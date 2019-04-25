package com.meuprincipe.demo.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SaidaItens")
public class SaidaItens implements Serializable {



	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private static final long serialVersionUID = 1L;
	private Integer produtoId;
	private String produtoCodigo;
	private String produtoTipo;
	private Float produtoValorVenda;
	private Float produtoValorPromocao;
	private Integer produtoQuantidade;
	private String produtoTamanho;
	private String clienteId;
	private String clienteNome;
	private String motivoSaida; // Reservado/ Venda/ Historico
	private String dataAtualizacao;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Integer getProdutoId() {
		return produtoId;
	}

	public void setProdutoId(Integer produtoId) {
		this.produtoId = produtoId;
	}

	public String getProdutoCodigo() {
		return produtoCodigo;
	}

	public void setProdutoCodigo(String produtoCodigo) {
		this.produtoCodigo = produtoCodigo;
	}

	public String getProdutoTipo() {
		return produtoTipo;
	}

	public void setProdutoTipo(String produtoTipo) {
		this.produtoTipo = produtoTipo;
	}

	public Float getProdutoValorVenda() {
		return produtoValorVenda;
	}

	public void setProdutoValorVenda(Float produtoValorVenda) {
		this.produtoValorVenda = produtoValorVenda;
	}

	public Float getProdutoValorPromocao() {
		return produtoValorPromocao;
	}

	public void setProdutoValorPromocao(Float produtoValorPromocao) {
		this.produtoValorPromocao = produtoValorPromocao;
	}

	public Integer getProdutoQuantidade() {
		return produtoQuantidade;
	}

	public void setProdutoQuantidade(Integer produtoQuantidade) {
		this.produtoQuantidade = produtoQuantidade;
	}

	public String getProdutoTamanho() {
		return produtoTamanho;
	}

	public void setProdutoTamanho(String produtoTamanho) {
		this.produtoTamanho = produtoTamanho;
	}

	public String getClienteId() {
		return clienteId;
	}

	public void setClienteId(String clienteId) {
		this.clienteId = clienteId;
	}

	public String getClienteNome() {
		return clienteNome;
	}

	public void setClienteNome(String clienteNome) {
		this.clienteNome = clienteNome;
	}

	public String getMotivoSaida() {
		return motivoSaida;
	}

	public void setMotivoSaida(String motivoSaida) {
		this.motivoSaida = motivoSaida;
	}

	public String getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(String dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

}
