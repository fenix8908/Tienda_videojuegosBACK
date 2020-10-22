package com.juegos.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.juegos.backend.entity.Alquiler;

@Repository
public interface AlquilerRepository extends JpaRepository<Alquiler, Integer> {

	@Query(value = "SELECT  alquiler.fecha_alquiler,alquiler.fecha_entrega,\r\n" + 
			"alquiler.precio_alquiler, cliente.nombre_completo,video_juego.nombre\r\n" + 
			"FROM alquiler\r\n" + 
			"INNER JOIN cliente ON alquiler.id_cliente = cliente.id\r\n" + 
			"INNER JOIN video_juego ON alquiler.id_juego = video_juego.id;", nativeQuery = true)
	public List<String> quienAlquiloJuegoNativo();
}
