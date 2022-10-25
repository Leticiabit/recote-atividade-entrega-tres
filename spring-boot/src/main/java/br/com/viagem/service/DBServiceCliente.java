package br.com.viagem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.viagem.model.Cliente;
import br.com.viagem.repository.ClienteRepository;

@Service
public class DBServiceCliente {

	@Autowired
	private ClienteRepository repo;

		public void inicializarBandoDadosCliente() {
			Cliente cliente = new Cliente("Vitor", "11974682736", "vitorgmailcom");
			repo.save(cliente);
		}
}
