package com.ar.smslatam.asteroidem.services;

import com.ar.smslatam.asteroidem.entities.Humano;
import com.ar.smslatam.asteroidem.repo.HumanoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * HumanoService
 */
@Service
public class HumanoService {
	@Autowired
	HumanoRepository humanorepo;


	/**
	 * se graba en el repo humano los humanos
	 * @param h
	 */
	public void grabar(Humano h) {
		this.humanorepo.save(h);
	}

/**
 * cuenta para la cantidad de humanos que hay 
 * @return
 */
	public long contar() {
		return humanorepo.count();
	}



    
}