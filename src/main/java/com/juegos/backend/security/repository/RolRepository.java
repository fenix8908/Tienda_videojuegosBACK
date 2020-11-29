package com.juegos.backend.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.juegos.backend.security.entity.Rol;
import com.juegos.backend.security.enums.RolNombre;

public interface RolRepository  extends JpaRepository<Rol, Integer>{
	
	Optional<Rol> findByRolNombre(RolNombre rolNombre);
	
	
}
