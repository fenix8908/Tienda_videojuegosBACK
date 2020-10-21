package com.juegos.backend.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.juegos.backend.criterios.CriterioBusqueda;
import com.juegos.backend.criterios.CriterioBusqueda.TecnoFilter;
import com.juegos.backend.dto.BusquedaDTO;
import com.juegos.backend.entity.VideoJuego;
import com.juegos.backend.enums.Tecnologia;
import com.juegos.backend.service.VideoJuegoService;

import io.github.jhipster.service.filter.StringFilter;

@RestController
@RequestMapping("/juego")
@CrossOrigin(origins = "http://localhost:4200")
public class VideoJuegoController {

	@Autowired
	VideoJuegoService videoJuegoService;

	@PostMapping("/lista")
	public ResponseEntity<List<VideoJuego>> obtenerJuegos(@RequestBody BusquedaDTO busquedaDTO) {
		CriterioBusqueda criterioBusqueda = crearCriterioDeBusqueda(busquedaDTO);
		List<VideoJuego> listaJuegos = videoJuegoService.buscarPorCriterio(criterioBusqueda); 
		return new ResponseEntity<List<VideoJuego>>(listaJuegos, HttpStatus.OK);
	}

	private CriterioBusqueda crearCriterioDeBusqueda(BusquedaDTO busquedaDTO) {
		CriterioBusqueda criterioBusqueda = new CriterioBusqueda();
		if (busquedaDTO != null) {
			if (!StringUtils.isBlank(busquedaDTO.getDirector())) {
				StringFilter filter = new StringFilter();
				filter.setContains(busquedaDTO.getDirector());
				criterioBusqueda.setDirector(filter);
			}
			if (!StringUtils.isBlank(busquedaDTO.getMarca())) {
				StringFilter filter = new StringFilter();
				filter.setContains(busquedaDTO.getMarca());
				criterioBusqueda.setMarca(filter);

			}
			if (!StringUtils.isBlank(busquedaDTO.getProductor())) {
				StringFilter filter = new StringFilter();
				filter.setContains(busquedaDTO.getProductor());
				criterioBusqueda.setProductor(filter);

			}
			if (!StringUtils.isBlank(busquedaDTO.getProtagonista())) {
				StringFilter filter = new StringFilter();
				filter.setContains(busquedaDTO.getProtagonista());
				criterioBusqueda.setProtagonista(filter);

			}
			if (!StringUtils.isBlank(busquedaDTO.getTecnologia())) {
				CriterioBusqueda.TecnoFilter filter = new CriterioBusqueda.TecnoFilter();
				String tecnologia = busquedaDTO.getTecnologia().toUpperCase();
				filter.setEquals(Tecnologia.valueOf(tecnologia));
				criterioBusqueda.setTecno(filter);
			}
		}
		return criterioBusqueda;
	}

}
