package com.cirpaci.leo.examen_election.examen_election.rest;

import com.cirpaci.leo.examen_election.examen_election.Service.CandidatService;
import com.cirpaci.leo.examen_election.examen_election.entities.District;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController public class DistrictRestController {
    @Autowired public CandidatService CandidatService;
    @PostMapping("/utilisateur/{nom}")
    public ResponseEntity<String> checkDistric(@PathVariable("nom") String nom) {
        District district = CandidatService.getIfDistrictExists(nom) ;
        if (district == null) {
            return ResponseEntity.ok("no") ;
        }
        return ResponseEntity.ok("yes");
    }
}
