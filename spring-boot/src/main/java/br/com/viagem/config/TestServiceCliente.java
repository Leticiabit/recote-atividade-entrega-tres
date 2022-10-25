package br.com.viagem.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.viagem.service.DBServiceCliente;

@Configuration
public class TestServiceCliente {

	@Autowired
	private DBServiceCliente service;
	
	@Bean
	public void inicializarCliente() {
		service.inicializarBandoDadosCliente();
	}
}
