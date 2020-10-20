package com.juegos.backend.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.juegos.backend.dto.ClienteDto;
import com.juegos.backend.dto.Mensaje;
import com.juegos.backend.entity.Cliente;
import com.juegos.backend.service.ClienteService;




@RestController
@RequestMapping("/cliente")
@CrossOrigin(origins = "http://localhost:4200")
public class ClienteController {
	
	@Autowired
	ClienteService clienteService;
	
	@GetMapping("/lista")
	public ResponseEntity<List<Cliente>> listarClientes(){
		
		List<Cliente> lista = clienteService.listaClientes();
		return new ResponseEntity(lista, HttpStatus.OK);
	}
	
	@PostMapping("/crear/")
	public ResponseEntity<?> crearCliente(@RequestBody ClienteDto clienteDto){
		
		if(StringUtils.isAllBlank(clienteDto.getNombreCompleto()))
			return new ResponseEntity(new Mensaje("El nombre es obligatorio"),HttpStatus.BAD_REQUEST);
		
		if(StringUtils.isAllBlank(clienteDto.getDocumento()))
			return new ResponseEntity(new Mensaje("El documento es obligatorio"),HttpStatus.BAD_REQUEST);
		
		if(StringUtils.isAllBlank(clienteDto.getTelefono()))
			return new ResponseEntity(new Mensaje("El telefono es obligatorio"),HttpStatus.BAD_REQUEST);	
		
		if(clienteService.existePorNombre(clienteDto.getNombreCompleto()))
			return new ResponseEntity(new Mensaje("Este nombre ya existe"),HttpStatus.BAD_REQUEST);
			
		Cliente cliente = new Cliente(clienteDto.getCorreo(),clienteDto.getDocumento(),clienteDto.getNombreCompleto(),
				clienteDto.getTelefono(),clienteDto.getTipoDocumento());
		cliente.setCorreo(clienteDto.getCorreo());
		cliente.setDocumento(clienteDto.getDocumento());
		cliente.setNombreCompleto(clienteDto.getNombreCompleto());
		cliente.setTelefono(clienteDto.getTelefono());
		cliente.setTipoDocumento(clienteDto.getTipoDocumento());
		clienteService.guardarCliente(cliente);
		return new ResponseEntity(new Mensaje("cliente creado"),HttpStatus.OK);
		
	}
	
	

}
