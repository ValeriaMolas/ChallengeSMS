package com.ar.smslatam.asteroidem.repo;

import com.ar.smslatam.asteroidem.entities.Mutante;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * MutanteRepository
 */
@Repository
public interface MutanteRepository extends MongoRepository<Mutante, ObjectId> {
    Mutante findBy_id(ObjectId _id);

    Mutante findByAdn(String adn);

    Mutante findByNombre(String nombre);

}