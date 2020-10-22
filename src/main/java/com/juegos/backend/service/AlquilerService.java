package com.juegos.backend.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.juegos.backend.entity.Alquiler;
import com.juegos.backend.repository.AlquilerRepository;

@Service
@Transactional
public class AlquilerService {
	
	@Autowired
	private AlquilerRepository alquilerRepository;
	
	public List<Alquiler>listaAlquiler(){
		return alquilerRepository.findAll();
	}

	public void alquilarJuego(Alquiler alquiler) {
		alquilerRepository.save(alquiler);
	}
	
	public List<String>quienAlquilo(){
		return this.alquilerRepository.quienAlquiloJuegoNativo();
	}
	
	
}
