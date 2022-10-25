package br.com.viagem.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.viagem.service.DBServiceDestino;

@Configuration
public class TestServiceDestino {

	@Autowired
	private DBServiceDestino service;
	
	@Bean
	public void inicializarDestino() {
		service.inicializarBandoDadosDestino();
	}
}
