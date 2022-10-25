package br.com.viagem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.viagem.model.Viagem;

public interface ViagemRepository extends JpaRepository<Viagem, Integer>{

}
