package br.com.viagem.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.viagem.model.Viagem;
import br.com.viagem.service.ViagemService;

@RequestMapping("viagens")
@RestController
public class ViagemController {
	
	@Autowired
	private ViagemService service;
	
	@GetMapping
	public ResponseEntity<List<Viagem>> getAll() {
		List<Viagem> viagens = service.getAll();
		return ResponseEntity.ok().body(viagens);
	}
	
	@PostMapping
	public ResponseEntity<Viagem> save(@RequestBody Viagem viagem) {
		
		Viagem savedViagem = service.save(viagem);
		return ResponseEntity.ok().body(savedViagem);
	}
	
	@PutMapping("{id}")
    public ResponseEntity<Viagem> update(@PathVariable("id") Integer id, @RequestBody Viagem viagem) {
		
		Viagem savedViagem = service.update(id, viagem);
		return ResponseEntity.ok().body(savedViagem);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
	    service.remove(id);
		return ResponseEntity.noContent().build();
	}

}
