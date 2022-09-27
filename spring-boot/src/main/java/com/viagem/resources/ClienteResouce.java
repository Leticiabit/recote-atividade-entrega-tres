package com.viagem.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.viagem.domain.Cliente;
import com.viagem.service.ClienteService;

@RestController
@RequestMapping(value = "/clientes")
@CrossOrigin("x")
public class ClienteResouce {

	@Autowired
	private ClienteService service;
	
	@GetMapping(value = "{id}")
	public ResponseEntity<Cliente> findById(@PathVariable Integer id){
		Cliente cliente = service.findById(id);
		return ResponseEntity.ok().body(cliente);
	}
	
	@GetMapping
	public ResponseEntity<List<Cliente>> findAll(){
		List<Cliente>clientes = service.findAll();
		return ResponseEntity.ok().body(clientes);
	}
	
	public ResponseEntity<Cliente> save(@RequestBody Cliente cliente){
		Cliente obj = service.save(cliente);
		return ResponseEntity.ok().body(obj);
	}
	
	public ResponseEntity<Cliente> update(@RequestBody Cliente cliente){
		Cliente obj = service.update(cliente);
		return ResponseEntity.ok().body(obj);
	}
	
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
