package com.juegos.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.juegos.backend.dto.Mensaje;
import com.juegos.backend.entity.Alquiler;

import com.juegos.backend.exception.ResourceNotFoundException;
import com.juegos.backend.repository.ClienteRepository;
import com.juegos.backend.repository.JuegoRepository;
import com.juegos.backend.service.AlquilerService;

@RestController
@RequestMapping("/tienda")
@CrossOrigin(origins = "http://localhost:4200")
public class AlquilerController {

	private Alquiler alquiler;

	@Autowired
	private AlquilerService alquilerService;

	@Autowired
	ClienteRepository clienteRepository;

	@Autowired
	JuegoRepository juegoRepository;

	@GetMapping("/lista")
	public ResponseEntity<List<Alquiler>> obtenerAlquiler() {
		List<Alquiler> listado = alquilerService.listaAlquiler();
		return new ResponseEntity(listado, HttpStatus.OK);
	}
	

	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/alquiler/cliente/{fk_cliente}/juego/{fk_juego}")
	public ResponseEntity<Alquiler> crearAlquiler(@RequestBody Alquiler alquiler,
			@PathVariable(value = "fk_cliente")Integer fk_cliente,@PathVariable(value = "fk_juego")Integer fk_juego) {
		
		this.alquiler = alquiler;	
		clienteRepository.findById(fk_cliente).map((cliente) ->{
			this.alquiler.setCliente(cliente);
			return this.alquiler;
		}).orElseThrow(()-> new ResourceNotFoundException("Cliente", "id", fk_cliente));
		
		juegoRepository.findById(fk_juego).map((videoJuego) ->{
			this.alquiler.setVideoJuego(videoJuego);
			return this.alquiler;
		}).orElseThrow(() ->new ResourceNotFoundException("VideoJuego", "id", fk_juego));
		
		alquilerService.save(alquiler);
		return new ResponseEntity(new Mensaje("alquiler creado"),HttpStatus.OK);
	}

}
