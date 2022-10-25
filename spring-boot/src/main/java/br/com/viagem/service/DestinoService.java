package br.com.viagem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.viagem.model.Destino;
import br.com.viagem.repository.DestinoRepository;

@Service
public class DestinoService {

	@Autowired DestinoRepository repository;
	
	public List<Destino> getAll() {
		return repository.findAll();
	}
	
	public Destino save(Destino destino) {
		return repository.save(destino);
	}
	
	public Destino update(Integer id, Destino newDestino) {
		Destino destino = repository.findById(id).get();
		destino.setPais(newDestino.getPais());
		destino.setCidade(newDestino.getCidade());
		destino.setValor(newDestino.getValor());
		destino.setDias(newDestino.getDias());
		return repository.save(destino);
	}
	
	public void remove(Integer id) {
		repository.deleteById(id);
	}
}
