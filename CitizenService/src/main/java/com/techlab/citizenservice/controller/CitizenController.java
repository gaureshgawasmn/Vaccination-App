package com.techlab.citizenservice.controller;

import com.techlab.citizenservice.entities.Citizen;
import com.techlab.citizenservice.service.CitizenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/citizens")
public class CitizenController {

    @Autowired
    CitizenService service;

    @GetMapping
    ResponseEntity<List<Citizen>> getAllCitizens() {
        List<Citizen> citizens = service.getAllCitizens();
        if (citizens != null) {
            return ResponseEntity.ok(citizens);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    ResponseEntity<Citizen> addCitizen(@RequestBody Citizen citizen) {
        citizen = service.addCitizen(citizen);
        return ResponseEntity.ok(citizen);
    }

    @GetMapping("/center-id/{vaccinationCenterId}")
    ResponseEntity<List<Citizen>> getCitizensByVaccinationCenterId(@PathVariable int vaccinationCenterId) {
        List<Citizen> citizens = service.getCitizensByVaccinationCenterId(vaccinationCenterId);
        if (citizens != null) {
            return ResponseEntity.ok(citizens);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/citizen-id/{id}")
    ResponseEntity<Citizen> getCitizenById(@PathVariable int id) {
        Citizen citizen = service.getCitizenById(id);
        if (citizen != null) {
            return ResponseEntity.ok(citizen);
        }
        return ResponseEntity.notFound().build();
    }
}
