package com.juegos.backend.servicestest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.juegos.backend.entity.Cliente;
import com.juegos.backend.repository.ClienteRepository;
import com.juegos.backend.service.ClienteService;


@SpringBootTest
public class TestClienteService {
	
	@MockBean
	private ClienteRepository repository;
	
	@Autowired
	private ClienteService clienteService;
	
	List<Cliente> listaClientes = new ArrayList<Cliente>();
	
	@Test
	public void retornoListaDeClientes() {
		
		listaClientes.add(new Cliente("1152184","cedula","Jorge Caro","2161734","jorge@hot"));
		listaClientes.add(new Cliente("1128474","cedula","EstefiAlvarez","4328900","estefi@hot"));
		listaClientes.add(new Cliente("1134567","cedula","Pepe perez","4238950","pep@hot"));
		when(this.repository.findAll()).thenReturn(listaClientes);
		
	}
	
	@Test
	public void retornoClientePorId() {

		listaClientes.add(new Cliente(1,"1152184","cedula","Jorge Caro","2161734","jorge@hot"));
		listaClientes.add(new Cliente(2,"1128474","cedula","EstefiAlvarez","4328900","estefi@hot"));
		listaClientes.add(new Cliente(3,"1134567","cedula","Pepe perez","4238950","pep@hot"));
		Optional<Cliente> clienteOptional = clienteService.obtenerPorId(1);
	
		when(clienteService.obtenerPorId(1)).thenReturn(clienteOptional);
	
	}


}
