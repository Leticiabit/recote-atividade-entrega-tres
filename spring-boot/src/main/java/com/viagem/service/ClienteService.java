package com.viagem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viagem.domain.Cliente;
import com.viagem.repositories.ClienteRepository;
import com.viagem.service.exception.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repo;

	public Cliente findById(Integer id) {
		Optional<Cliente> cliente = repo.findById(id);
		return cliente.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado Id: " + id));
	}
	
	public List<Cliente> findAll() {
		return repo.findAll();
	}
	
	public Cliente save(Cliente cliente) {
		cliente.setId(null);
		return repo.save(cliente);
	}
	
	public Cliente update(Cliente cliente) {
		Cliente newCliente = findById(cliente.getId());
		updateCliente(cliente, newCliente);
		return repo.save(newCliente);
	}

	public void delete(Integer id) {
		repo.deleteById(id);
	}
	
	public void updateCliente(Cliente oldCliente, Cliente newCliente) {
		newCliente.setCelular(oldCliente.getCelular());
		newCliente.setEmail(oldCliente.getEmail());
		newCliente.setNome(oldCliente.getNome());
	}
}

