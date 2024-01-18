package com.techlab.citizenservice.repository;

import com.techlab.citizenservice.entities.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CitizenRepo extends JpaRepository<Citizen, Integer>{
    List<Citizen> findByVaccinationCenterId(int vaccinationCenterId);
}
