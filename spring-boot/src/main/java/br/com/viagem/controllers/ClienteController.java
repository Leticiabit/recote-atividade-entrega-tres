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

import br.com.viagem.model.Cliente;
import br.com.viagem.service.ClienteService;

@RequestMapping("clientes")
@RestController
public class ClienteController {
	
	@Autowired
	private ClienteService service;
	
	@GetMapping
	public ResponseEntity<List<Cliente>> getAll() {
		List<Cliente> clientes = service.getAll();
		return ResponseEntity.ok().body(clientes);
	}
	
	@PostMapping
	public ResponseEntity<Cliente> save(@RequestBody Cliente cliente) {
		
		Cliente savedCliente = service.save(cliente);
		return ResponseEntity.ok().body(savedCliente);
	}
	
	@PutMapping("{id}")
    public ResponseEntity<Cliente> update(@PathVariable("id") Integer id, @RequestBody Cliente cliente) {
		
		Cliente savedCliente = service.update(id, cliente);
		return ResponseEntity.ok().body(savedCliente);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
	    service.remove(id);
		return ResponseEntity.noContent().build();
	}

}
