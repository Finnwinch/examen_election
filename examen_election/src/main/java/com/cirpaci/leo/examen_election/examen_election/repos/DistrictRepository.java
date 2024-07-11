package com.cirpaci.leo.examen_election.examen_election.repos;

import com.cirpaci.leo.examen_election.examen_election.entities.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface DistrictRepository extends CrudRepository<District, Integer>, JpaRepository<District, Integer> {
    public District findDistrictByNom(String nom);
}
