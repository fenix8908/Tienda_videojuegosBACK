package com.juegos.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.juegos.backend.dto.AlquilerDTO;
import com.juegos.backend.dto.Mensaje;
import com.juegos.backend.entity.Alquiler;
import com.juegos.backend.service.AlquilerService;

@RestController
@RequestMapping("/alquiler")
@CrossOrigin(origins = "http://localhost:4200")
public class AlquilerController {

	@Autowired
	private AlquilerService alquilerService;

	@GetMapping("/lista")
	public ResponseEntity<List<Alquiler>> obtenerAlquiler() {
		List<Alquiler> listado = alquilerService.listaAlquiler();
		return new ResponseEntity(listado, HttpStatus.OK);
	}

	@PostMapping("/registro")
	public ResponseEntity<?> registroAlquiler(@RequestBody AlquilerDTO alquilerDTO) {

		Alquiler alquiler = new Alquiler(alquilerDTO.getFechaAlquiler(), alquilerDTO.getFechaEntrega(),
				alquilerDTO.getPrecioAlquiler(), alquilerDTO.getId_cliente(), alquilerDTO.getId_juego());

		alquiler.setFechaAlquiler(alquilerDTO.getFechaAlquiler());
		alquiler.setFechaAlquiler(alquilerDTO.getFechaEntrega());
		alquiler.setPrecioAlquiler(alquilerDTO.getPrecioAlquiler());
		alquiler.setId_cliente(alquilerDTO.getId_cliente());
		alquiler.setId_juego(alquilerDTO.getId_juego());
		alquilerService.alquilarJuego(alquiler);
		return new ResponseEntity(new Mensaje("Alquiler registrado"), HttpStatus.OK);
	}
	
	@GetMapping("/alquileres")
	public ResponseEntity<List<String>> obtenerTodoAlquiler() {
		List<String> listado = alquilerService.quienAlquilo();
		return new ResponseEntity(listado, HttpStatus.OK);
	}

}
