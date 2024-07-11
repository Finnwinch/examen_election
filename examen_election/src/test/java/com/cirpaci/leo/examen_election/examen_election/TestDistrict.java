package com.cirpaci.leo.examen_election.examen_election;

import com.cirpaci.leo.examen_election.examen_election.entities.Candidat;
import com.cirpaci.leo.examen_election.examen_election.entities.District;
import com.cirpaci.leo.examen_election.examen_election.repos.CandidatRepository;
import com.cirpaci.leo.examen_election.examen_election.repos.DistrictRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Rollback(false)
public class TestDistrict {
    @Autowired DistrictRepository DistrictRepository;
    @Autowired CandidatRepository CandidatRepository;
    @Test @Order(1) public void CreateDistrict() {
        District district = new District();
        district.setNom("District 1");
        district.setElecteurs(100);
        DistrictRepository.save(district);
    }
    @Test @Order(2) public void CreateCandidats() {
        Candidat candidat = new Candidat();
        candidat.setNom("Candidat1");
        candidat.setDistrict(DistrictRepository.getById(1));
        candidat.setParti("Partie A");
        candidat.setVotes(75);
        CandidatRepository.save(candidat) ;
        Candidat candidat2 = new Candidat();
        candidat2.setNom("Candidat2");
        candidat2.setDistrict(DistrictRepository.getById(1));
        candidat2.setParti("Partie B");
        candidat2.setVotes(25);
        CandidatRepository.save(candidat2) ;
    }
    @Test @Order(3) public void RemoveTest() {
        Candidat candidat = CandidatRepository.getById(1);
        CandidatRepository.delete(candidat);
        Candidat candidat2 = CandidatRepository.getById(2);
        CandidatRepository.delete(candidat2);
        District district = DistrictRepository.getById(1);
        DistrictRepository.delete(district);
    }
}