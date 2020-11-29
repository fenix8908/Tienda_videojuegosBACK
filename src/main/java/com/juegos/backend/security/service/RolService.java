package com.juegos.backend.security.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juegos.backend.security.entity.Rol;
import com.juegos.backend.security.enums.RolNombre;
import com.juegos.backend.security.repository.RolRepository;



@Service
@Transactional
public class RolService {

    @Autowired
    RolRepository rolRepository;

    public Optional<Rol> getByNombre(RolNombre rolNombre){
        return rolRepository.findByRolNombre(rolNombre);
    }

    public void save(Rol rol ){
        rolRepository.save(rol);
    }

}
