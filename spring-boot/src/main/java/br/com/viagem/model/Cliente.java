package br.com.viagem.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Cliente implements Serializable{

	private static final long serialVersionUID = 2L;
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Id
	private Integer id_cliente;
	private String nome;
	private String celular;
	private String email;
	
	public Cliente() {
		
	}
	
	public Cliente(String nome, String celular, String email) {
		this.nome = nome;
		this.celular = celular;
		this.email = email;
	}

	public Integer getId_cliente() {
		return id_cliente;
	}

	public void setId(Integer id_cliente) {
		this.id_cliente = id_cliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		
		return "id_cliente: " + this.id_cliente +
				" nome: " + this.nome +
				" celular: " + this.celular +
				" emila: " + this.email;
	}
	
}
