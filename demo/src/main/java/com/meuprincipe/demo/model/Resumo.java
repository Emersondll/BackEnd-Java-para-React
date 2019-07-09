package com.meuprincipe.demo.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ResumoVendas") // Ver View
public class Resumo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	private Integer idCliente;
	private String nome;
	private float soma;
	private String evento;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getSoma() {
		return soma;
	}

	public void setSoma(float soma) {
		this.soma = soma;
	}

	public String getEvento() {
		return evento;
	}

	public void setEvento(String evento) {
		this.evento = evento;
	}

}
