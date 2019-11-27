package com.ar.smslatam.asteroidem.entities;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Mutante
 */
@Document ("Mutantes")
public class Mutante {
    @Id 
    private ObjectId _id;
    private char[][] adn;
    private String nombre;

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public char[][] getAdn() {
        return adn;
    }

    public void setAdn(char[][] adn) {
        this.adn = adn;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

	

    
}