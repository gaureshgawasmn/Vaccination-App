package com.techlab.citizenservice.service;

import com.techlab.citizenservice.entities.Citizen;
import com.techlab.citizenservice.repository.CitizenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitizenService {

    @Autowired
    CitizenRepo repository;

    public List<Citizen> getAllCitizens() {
        return repository.findAll();
    }

    public Citizen addCitizen(Citizen citizen) {
        return repository.save(citizen);
    }

    public List<Citizen> getCitizensByVaccinationCenterId(int vaccinationCenterId) {
        return repository.findByVaccinationCenterId(vaccinationCenterId);
    }

    public Citizen getCitizenById(int id) {
        return repository.findById(id).orElse(null);
    }
}
