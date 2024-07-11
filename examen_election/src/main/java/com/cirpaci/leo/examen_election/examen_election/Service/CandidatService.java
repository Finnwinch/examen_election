package com.cirpaci.leo.examen_election.examen_election.Service;

import com.cirpaci.leo.examen_election.examen_election.entities.Candidat;
import com.cirpaci.leo.examen_election.examen_election.entities.District;
import com.cirpaci.leo.examen_election.examen_election.repos.CandidatRepository;
import com.cirpaci.leo.examen_election.examen_election.repos.DistrictRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service @Transactional public class CandidatService {
    @Autowired private CandidatRepository CandidatRepository;
    @Autowired private DistrictRepository DistrictRepository;
    @Autowired
    private DistrictRepository districtRepository;

    public List<Candidat> getAllCandidat() {
        List<Candidat> candidats = new ArrayList<Candidat>();
        candidats = CandidatRepository.findAll();
        return candidats;
    }
    public List<District> getAllDistrict() {
        List<District> districts = new ArrayList<>() ;
        districts = DistrictRepository.findAll();
        return districts;
    }
    public void save(Candidat candidat) {
        CandidatRepository.save(candidat);
    }
    public District getIfDistrictExists(String districtName) {
        District district = DistrictRepository.findDistrictByNom(districtName);
        return district;
    }
    public List<Candidat> getAllByDistrict(String district) {
        List<Candidat> candidats = new ArrayList<Candidat>() ;
        candidats = CandidatRepository.findCandidateByDistrictNom(district) ;
        return candidats;
    }
}
