package br.com.viagem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.viagem.model.Viagem;
import br.com.viagem.repository.ViagemRepository;

@Service
public class DBServiceViagem {

	@Autowired
	private ViagemRepository repo;

		public void inicializarBandoDadosViagem() {
			Viagem destino = new Viagem(1, 2);
			repo.save(destino);
		}
}
