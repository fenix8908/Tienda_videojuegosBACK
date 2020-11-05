package com.juegos.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.juegos.backend.criterios.CriterioBusqueda;
import com.juegos.backend.entity.VideoJuego;
import com.juegos.backend.entity.VideoJuego_;
import com.juegos.backend.repository.JuegoRepository;

import io.github.jhipster.service.QueryService;

@Service
@Transactional(readOnly = true)
public class VideoJuegoService extends QueryService<VideoJuego> {

	@Autowired
	JuegoRepository juegoRepository;
	
	public List<VideoJuego>getAllGames(){
		return this.juegoRepository.findAll();
	}

	public List<VideoJuego> buscarPorCriterio(CriterioBusqueda criterioBusqueda) {
		final Specification<VideoJuego> specification = crearEspecificacion(criterioBusqueda);
		List<VideoJuego> juegos = juegoRepository.findAll(specification);
		return juegos;
	}
	private Specification<VideoJuego> crearEspecificacion(CriterioBusqueda criterio) {
		Specification<VideoJuego> specification = Specification.where(null);
		if (criterio != null) {
			if (criterio.getDirector() != null) {
				specification = specification
						.and(buildStringSpecification(criterio.getDirector(), VideoJuego_.director));
			}
			if (criterio.getProductor() != null) {
				specification = specification
						.and(buildStringSpecification(criterio.getProductor(), VideoJuego_.productor));
			}
			if (criterio.getProtagonista() != null) {
				specification = specification
						.and(buildStringSpecification(criterio.getProtagonista(), VideoJuego_.protagonista));
			}
			if (criterio.getMarca() != null) {
				specification = specification.and(buildStringSpecification(criterio.getMarca(), VideoJuego_.marca));
			}
			if (criterio.getTecno() != null) {
				specification = specification.and(buildSpecification(criterio.getTecno(), VideoJuego_.tecnologia)); 
			}
		}
		return specification;
	}
}
