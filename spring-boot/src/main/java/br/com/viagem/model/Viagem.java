package br.com.viagem.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Viagem implements Serializable{

	private static final long serialVersionUID = 3L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer id_cliente;
	private Integer id_destino;
	
	public Viagem()	{
		
	}

	public Viagem(Integer id_cliente, Integer id_destino) {
		super();
		this.id_cliente = id_cliente;
		this.id_destino = id_destino;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(Integer id_cliente) {
		this.id_cliente = id_cliente;
	}

	public Integer getId_destino() {
		return id_destino;
	}

	public void setId_destino(Integer id_destino) {
		this.id_destino = id_destino;
	}

	@Override
	public String toString() {
		
		return "id: " + this.id +
				" id_cliente: " + this.id_cliente +
				" id_destino: " + this.id_destino;
	}
		
}
