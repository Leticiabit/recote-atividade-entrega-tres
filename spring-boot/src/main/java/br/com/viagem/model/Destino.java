package br.com.viagem.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Destino implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_destino;
	private String pais;
	private String cidade;
	private Double valor;
	private Integer dias;

	public Destino() {
		
	}
	
	public Destino(String pais, String cidade, Double valor, Integer dias) {
		this.pais = pais;
		this.cidade = cidade;
		this.valor = valor;
		this.dias = dias;
	}

	public Integer getId_destino() {
		return id_destino;
	}

	public void setId(Integer id_destino) {
		this.id_destino = id_destino;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Integer getDias() {
		return dias;
	}

	public void setDias(Integer dias) {
		this.dias = dias;
	}

	@Override
	public String toString() {
		
		return "id_destino: " + this.id_destino +
				" pais: " + this.pais +
				" cidade: " + this.cidade +
				" valor: " + this.valor +
				" dias: " + this.dias;
	}
}
