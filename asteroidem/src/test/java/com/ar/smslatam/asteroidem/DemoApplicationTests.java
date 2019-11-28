package com.ar.smslatam.asteroidem;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.ar.smslatam.asteroidem.services.MutanteService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void contextLoads() {
	}
	@Autowired
    MutanteService mutanteService;

    
    @Test
    void verificarMutanteDNAHorizontal() {
        
		String[] adn = {"CCTATA", 
						"AAAAAA", 
						"CGTGTT", 
						"CGTTGA", 
						"TTTTTT", 
						"GAACAA" };
        boolean esMutante;
        esMutante = mutanteService.isMutant(adn);
        assertTrue(esMutante);
        
    }
    
  
	void verificarMutanteDNAVertical() {
        
		String[] adn = {"CCTCTC", 
						"GATATA", 
						"CGTATA", 
						"CGTAGA", 
						"TATATA", 
						"GTTTTT" };
        boolean esMutante;
        esMutante = mutanteService.isMutant(adn);
        assertTrue(esMutante);
        
    }
    
    
    
    void verificarMutanteDNADiagonal() {
        
		String[] adn = {"ACTATA",
						"AACAAA", 
						"AGTCTA", 
						"AGTACA", 
						"TATATC", 
						"GTTATA" };
        boolean esMutante;
        esMutante = mutanteService.isMutant(adn);
        assertTrue(esMutante);
        
    }
    @Test
    void verificarHumano() {
        
		String[] adn = {"ACTATA", 
						"ATCGCA", 
						"AGTCTA", 
						"AGTGCG", 
						"TATATC", 
						"GTGATA" };
        boolean esMutante;
        esMutante = mutanteService.isMutant(adn);
        assertFalse(esMutante);
        
    }
}