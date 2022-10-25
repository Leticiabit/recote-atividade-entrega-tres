package br.com.viagem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.viagem.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}
