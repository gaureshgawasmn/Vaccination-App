package com.techlab.vaccinationcenter.repositories;

import com.techlab.vaccinationcenter.entities.VaccinationCenter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VaccinationCenterRepo extends JpaRepository<VaccinationCenter, Integer> {

}
