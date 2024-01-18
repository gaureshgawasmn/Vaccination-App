package com.techlab.vaccinationcenter.controller;

import com.techlab.vaccinationcenter.entities.VaccinationCenter;
import com.techlab.vaccinationcenter.model.VaccinationInfo;
import com.techlab.vaccinationcenter.service.VaccinationCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vaccination-center")
public class VaccinationCenterController {

    @Autowired
    VaccinationCenterService centerService;

    @PostMapping
    public ResponseEntity<VaccinationCenter> addVaccinationCenter(@RequestBody VaccinationCenter vaccinationCenter) {
        vaccinationCenter = centerService.addVaccinationCenter(vaccinationCenter);
        return ResponseEntity.ok(vaccinationCenter);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VaccinationInfo> getAllDataForVaccinationCenter(@PathVariable int id) {
        VaccinationInfo vaccinationInfo = centerService.getAllDataForVaccinationCenter(id);
        return ResponseEntity.ok(vaccinationInfo);
    }
}
