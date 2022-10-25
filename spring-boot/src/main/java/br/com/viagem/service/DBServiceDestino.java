package br.com.viagem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.viagem.model.Destino;
import br.com.viagem.repository.DestinoRepository;

@Service
public class DBServiceDestino {

	@Autowired
	private DestinoRepository repo;
	
		public void inicializarBandoDadosDestino() {
			Destino destino = new Destino("EUA", "NY", 3000.00, 2);
			repo.save(destino);
		}
}
