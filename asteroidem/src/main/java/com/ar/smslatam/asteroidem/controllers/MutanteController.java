package com.ar.smslatam.asteroidem.controllers;

import java.util.ArrayList;
import java.util.List;

import com.ar.smslatam.asteroidem.entities.Humano;
import com.ar.smslatam.asteroidem.entities.Mutante;
import com.ar.smslatam.asteroidem.models.request.CandidatoRequest;
import com.ar.smslatam.asteroidem.models.response.MutanteResponse;
import com.ar.smslatam.asteroidem.models.response.StatsResponse;
import com.ar.smslatam.asteroidem.services.HumanoService;
import com.ar.smslatam.asteroidem.services.MutanteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * MutanteController
 */
@RestController
public class MutanteController {
    @Autowired
    MutanteService mutanteService;

    @Autowired
    HumanoService humanoService;


    @PostMapping("/mutantes")
    public MutanteResponse postnewMutante(@RequestBody CandidatoRequest cr) {
        MutanteResponse mr = new MutanteResponse();
        if (mutanteService.isMutant(cr.adn)) {
            Mutante m = new Mutante();
            m.setAdn(cr.adn);
            m.setNombre(cr.nombre);
            mutanteService.grabar(m);
            mr.isMutant= true;
            mr.message= "Se catalogó como mutante";
       

            
        }
        else {
            Humano h = new Humano();
            h.setAdn(cr.adn);
            h.setNombre(cr.nombre);
            humanoService.grabar(h);
            mr.isMutant=false;
            mr.message="Se catalogo como humano";
   

        }
       
        return mr;
    }
    @GetMapping ("/mutantes") 
public List<Mutante> getMutantes() {
    List<Mutante> mt = new ArrayList<>();
    mt = mutanteService.buscarTodos();
    return mt;
}
/**
 * Get del punto 3
 * @return
 */
    @GetMapping("/stats")
    public StatsResponse getStatsResponse(){
        StatsResponse st = new StatsResponse();
        st.count_mutant_dna = mutanteService.contar();
        st.count_human_dna = humanoService.contar();
        st.ratio= st.count_mutant_dna/st.count_human_dna;
        return st;
    }

   
    







  
}