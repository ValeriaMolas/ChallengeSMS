package com.ar.smslatam.asteroidem.services;

import java.util.List;

import com.ar.smslatam.asteroidem.entities.Mutante;
import com.ar.smslatam.asteroidem.repo.MutanteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * MutanteService
 */
@Service
public class MutanteService {
    @Autowired
    MutanteRepository repo;



	public  boolean isMutant(char[][] adn) {
		return true;
	}

	public void grabar(Mutante m) {
        this.repo.save(m);

	}

	

    public List<Mutante> buscarTodos() {
		return repo.findAll();
	}

    
}