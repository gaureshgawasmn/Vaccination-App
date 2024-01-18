package com.techlab.vaccinationcenter.service;

import com.techlab.vaccinationcenter.config.ServiceInfoConfig;
import com.techlab.vaccinationcenter.entities.VaccinationCenter;
import com.techlab.vaccinationcenter.model.Citizen;
import com.techlab.vaccinationcenter.model.VaccinationInfo;
import com.techlab.vaccinationcenter.repositories.VaccinationCenterRepo;
import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class VaccinationCenterService {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    VaccinationCenterRepo vaccinationCenterRepo;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    ServiceInfoConfig serviceInfoConfig;

    @Autowired
    CircuitBreaker circuitBreaker;

    public VaccinationCenter addVaccinationCenter(VaccinationCenter vaccinationCenter) {
        return vaccinationCenterRepo.save(vaccinationCenter);
    }

    public VaccinationInfo getAllDataForVaccinationCenter(int id) {
        VaccinationCenter vaccinationCenter = vaccinationCenterRepo.findById(id).get();
        VaccinationInfo vaccinationInfo = new VaccinationInfo();
        vaccinationInfo.setVaccinationCenter(vaccinationCenter);
        // when not used load balanced in rest template
        //List<Citizen> citizens = restTemplate.getForObject("http://localhost:8081/citizens/center-id/" + id, List.class);
        // normal call
        // List<Citizen> citizens = restTemplate.getForObject("http://"+serviceInfoConfig.getCitizenService()+"/citizens/center-id/" + id, List.class);
        // call with circuit breaker
        try{
            List<Citizen> citizens = circuitBreaker.executeSupplier(() ->
                    restTemplate.getForObject("http://" + serviceInfoConfig.getCitizenService() + "/citizens/center-id/" + id, List.class)
            );
            vaccinationInfo.setCitizen(citizens);
        }catch (Exception e){
            logger.error("Circuit breaker is open");
            vaccinationInfo.setCitizen(new ArrayList<>());
        }
        return vaccinationInfo;
    }
}
