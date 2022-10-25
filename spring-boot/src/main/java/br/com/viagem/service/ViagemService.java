package br.com.viagem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.viagem.model.Viagem;
import br.com.viagem.repository.ViagemRepository;

@Service
public class ViagemService {

	@Autowired ViagemRepository repository;
	
	public List<Viagem> getAll() {
		return repository.findAll();
	}
	
	public Viagem save(Viagem viagem) {
		return repository.save(viagem);
	}
	
	public Viagem update(Integer id, Viagem newViagem) {
		Viagem viagem = repository.findById(id).get();
		viagem.setId_cliente(newViagem.getId_cliente());
		viagem.setId_destino(newViagem.getId_destino());
		return repository.save(viagem);
	}
	
	public void remove(Integer id) {
		repository.deleteById(id);
	}
}
