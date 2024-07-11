package com.cirpaci.leo.examen_election.examen_election.repos;

import com.cirpaci.leo.examen_election.examen_election.entities.Candidat;
import com.cirpaci.leo.examen_election.examen_election.entities.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CandidatRepository extends CrudRepository<Candidat, Integer>, JpaRepository<Candidat, Integer> {
    public List<Candidat> findCandidateByDistrictNom(String districtNom);
}