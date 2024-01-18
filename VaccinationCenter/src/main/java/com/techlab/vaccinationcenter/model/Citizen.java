package com.techlab.vaccinationcenter.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Citizen {
    private int id;
    private String name;
    private int vaccinationCenterId;
}
