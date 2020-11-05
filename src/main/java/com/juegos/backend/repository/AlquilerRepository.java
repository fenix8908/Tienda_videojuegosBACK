package com.juegos.backend.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.juegos.backend.entity.Alquiler;

@Repository
public interface AlquilerRepository extends JpaRepository<Alquiler, Integer> {

	Page<Alquiler>findByCliente(Integer clienteId,Pageable pageable);
	Page<Alquiler>findByVideoJuego(Integer juegoId,Pageable pageable);
	
}
