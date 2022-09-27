package com.viagem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viagem.domain.Cliente;
import com.viagem.repositories.ClienteRepository;

@Service
public class DBService {
	
	@Autowired
	private ClienteRepository repo;
	
	public void incializarBancoDados() {
		Cliente cliente = new Cliente ("Vitor", "1191231231", "vitorgmailcom", null);
		repo.save(cliente);
	}
}
