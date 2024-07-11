package com.cirpaci.leo.examen_election.examen_election.controller;

import com.cirpaci.leo.examen_election.examen_election.Service.CandidatService;
import com.cirpaci.leo.examen_election.examen_election.entities.Candidat;
import com.cirpaci.leo.examen_election.examen_election.entities.District;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller public class CandidatController {
    @Autowired private CandidatService CandidatService;
    @GetMapping("/candidat/getAll") public String getAllCandidat(
            Model model) {
        model.addAttribute("listCandidat",CandidatService.getAllCandidat()) ;
        return "candidats";
    }
    @GetMapping("/candidat/new") public String getNewCandidat(
            Model model
    ) {
        model.addAttribute("listDistrict",CandidatService.getAllDistrict()) ;
        model.addAttribute("Candidat", new Candidat());
        return "candidat_formulaire";
    }
    @PostMapping("/candidat/create") public String createCandidat(
            Model model,
            @ModelAttribute("Candidat") Candidat candidat
    ) {
        CandidatService.save(candidat);
        model.addAttribute("operation","Le candidat " + candidat.getNom() + " à été ajouté avec succès") ;
        model.addAttribute("listCandidat",CandidatService.getAllCandidat()) ;
        return "candidats";
    }
    @GetMapping("/district/search") public String getDistrict(
            Model model) {
        model.addAttribute("District",new District()) ;
        return "recherche_district";
    }
    @PostMapping("/district/found") public String getDistrictInfo(
            Model model,
            @RequestParam("nom") String district_nom) {
        model.addAttribute("listCandidat",CandidatService.getAllByDistrict(district_nom)) ;
        model.addAttribute("District",CandidatService.getIfDistrictExists(district_nom)) ;
        Integer votes = 0 ;
        Candidat CandidatBigger = CandidatService.getAllByDistrict(district_nom).get(0) ;
        for (Candidat candidat : CandidatService.getAllByDistrict(district_nom)) {
            votes += candidat.getVotes() ;
            if (candidat.getVotes() > CandidatBigger.getVotes()) CandidatBigger = candidat ;
        }
        model.addAttribute("Votes",votes) ;
        model.addAttribute("CandidatBigger",CandidatBigger) ;
        return "resultats_candidats_district" ;
    }
}
