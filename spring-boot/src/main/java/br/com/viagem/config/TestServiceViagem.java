package br.com.viagem.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.viagem.service.DBServiceViagem;

@Configuration
public class TestServiceViagem {

	@Autowired
	private DBServiceViagem service;
	
	@Bean
	public void inicializarViagem() {
		service.inicializarBandoDadosViagem();
	}
}
