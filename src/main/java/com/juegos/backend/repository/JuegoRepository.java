package com.juegos.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.juegos.backend.entity.VideoJuego;

@Repository
public interface JuegoRepository extends JpaRepository<VideoJuego, Integer>, 
JpaSpecificationExecutor<VideoJuego> {

}
