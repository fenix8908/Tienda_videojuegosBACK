package com.juegos.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.juegos.backend.entity.Cliente;
import com.juegos.backend.repository.ClienteRepository;


@Service
@Transactional
public class ClienteService {
	
	@Autowired
	ClienteRepository clienteRepository;
	
	public List<Cliente> listaClientes() {
		return clienteRepository.findAll();
	}

	public Optional<Cliente> obtenerPorId(int id){
		return this.clienteRepository.findById(id);
	}
	
	public boolean existePorId(int id) {
		return this.clienteRepository.existsByid(id);
	}
	
	public void guardarCliente(Cliente cliente) {
		clienteRepository.save(cliente);
	}

	public boolean existePorNombre(String nombre) {
		return clienteRepository.existsByNombreCompleto(nombre);
	}
	
	public boolean existePorDocumento(String documento) {
		return clienteRepository.existsByDocumento(documento);
	}

}
