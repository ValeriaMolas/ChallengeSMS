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

	/**
	 * se graba en el repo los mutantes
	 * @param m
	 */
	public void grabar(Mutante m) {
		this.repo.save(m);

	}

	public List<Mutante> buscarTodos() {
		return repo.findAll();
	}

	public boolean isMutant(String[] adn) {

		int secuenciasRepetidas = 0;
		for (int f = 0; f < adn.length; f++) {
			for (int c = 0; c < adn.length; c++) {

				//System.out.println("procesando fila " + f + " columna  " + c);
				if (c + 1 - 4 >= 0) { // puedo buscar hacia la izquierda horizontal
					//System.out.println("Entro por hacia izquierda horizontal fila " + f + " columna  " + c);
					// Busco hacia la izquierda horizontal
					if (adn[f].charAt(c) == adn[f].charAt(c - 1) && adn[f].charAt(c) == adn[f].charAt(c - 2)
							&& adn[f].charAt(c) == adn[f].charAt(c - 3)) {
						secuenciasRepetidas++;
					}
				}
				if (c - 1 + 4 < adn.length) { // puedo buscar hacia la izquierda
					//System.out.println("Entro por hacia derecha horizontal fila " + f + " columna  " + c);

					// Busco hacia la derecha horizontal
					if (adn[f].charAt(c) == adn[f].charAt(c + 1) && adn[f].charAt(c) == adn[f].charAt(c + 2)
							&& adn[f].charAt(c) == adn[f].charAt(c + 3)) {

						secuenciasRepetidas++;
					}
				}
				if (f - 1 + 4 < adn.length && c + 1 - 4 >= 0) { // puedo buscar hacia la izquierda diagonal
					//System.out.println("Entro por hacia izquierda diagonal " + f + " columna  " + c);

					// Busco hacia la izquierda diagonal
					if (adn[f].charAt(c) == adn[f + 1].charAt(c - 1) && adn[f].charAt(c) == adn[f + 2].charAt(c - 2)
							&& adn[f].charAt(c) == adn[f + 3].charAt(c - 3)) {
						secuenciasRepetidas++;
					}
				}
				if (f - 1 + 4 < adn.length && c - 1 + 4 < adn.length) { // puedo buscar hacia la derecha diagonal
					//System.out.println("Entro por hacia derecha diagonal fila " + f + " columna  " + c);

					// Busco hacia la derecha diagonal
					if (adn[f].charAt(c) == adn[f + 1].charAt(c + 1) && adn[f].charAt(c) == adn[f + 2].charAt(c + 2)
							&& adn[f].charAt(c) == adn[f + 3].charAt(c + 3)) {
						secuenciasRepetidas++;
					}
				}
				if (f - 1 + 4 < adn.length) { // puedo buscar hacia abajo
                    System.out.println("Entro por hacia abajo fila " + f + " columna  " + c);
                    // Busco hacia abajo
                    if (adn[f].charAt(c) == adn[f + 1].charAt(c) && adn[f].charAt(c) == adn[f + 2].charAt(c)
                            && adn[f].charAt(c) == adn[f + 3].charAt(c)) {
                        secuenciasRepetidas ++;
                    }
                } 
					
				
			}
		}

		return secuenciasRepetidas > 1;
	}
/**
 * cuentala cantidad de mutantes  que hay 
 * @return
 */
	public long contar() {
		return this.repo.count();
	}
}
