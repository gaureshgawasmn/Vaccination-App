package com.techlab.vaccinationcenter.model;


import com.techlab.vaccinationcenter.entities.VaccinationCenter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VaccinationInfo {
    private VaccinationCenter vaccinationCenter;

    private List<Citizen> citizen;
}
