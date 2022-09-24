package br.com.viagem.model;

public class Viagem {

	private String datavoo;
	private String datacompra;
	private int id_destino;
	private int id_cliente;
	//Getters and setters

	public String getDatavoo() {
		return datavoo;
	}
	public void setDatavoo(String datavoo) {
		this.datavoo = datavoo;
	}
	public String getDatacompra() {
		return datacompra;
	}
	public void setDatacompra(String datacompra) {
		this.datacompra = datacompra;
	}
	public int getId_cliente() {
		return id_cliente;
	}
	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}
	public int getId_destino() {
		return id_destino;
	}
	public void setId_destino(int id_destino) {
		this.id_destino = id_destino;
	}
}
			