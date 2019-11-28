package com.ar.smslatam.asteroidem.repo;

import com.ar.smslatam.asteroidem.entities.Humano;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * HumanoRepository
 */
@Repository
public interface HumanoRepository extends MongoRepository<Humano,ObjectId> {
    Humano findBy_id(ObjectId _id);
    Humano findByAdn(String adn);
    Humano findByNombre(String nombre);
    
}