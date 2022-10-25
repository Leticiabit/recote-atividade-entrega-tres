package br.com.viagem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.viagem.model.Cliente;
import br.com.viagem.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired ClienteRepository repository;
	
	public List<Cliente> getAll() {
		return repository.findAll();
	}
	
	public Cliente save(Cliente cliente) {
		return repository.save(cliente);
	}
	
	public Cliente update(Integer id, Cliente newCliente) {
		Cliente cliente = repository.findById(id).get();
		cliente.setNome(newCliente.getNome());
		cliente.setCelular(newCliente.getCelular());
		cliente.setEmail(newCliente.getEmail());
		return repository.save(cliente);
	}
	
	public void remove(Integer id) {
		repository.deleteById(id);
	}
}
