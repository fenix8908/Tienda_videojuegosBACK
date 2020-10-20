package com.juegos.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.juegos.backend.entity.Cliente;



public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
	
	Optional<Cliente>findByNombreCompleto(String nombre);
    boolean existsByNombreCompleto(String nombre);

}
