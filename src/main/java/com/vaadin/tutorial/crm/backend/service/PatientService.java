package com.vaadin.tutorial.crm.backend.service;

import com.vaadin.tutorial.crm.backend.entity.Patient;
import com.vaadin.tutorial.crm.backend.entity.Ward;
import com.vaadin.tutorial.crm.backend.repository.PatientRepository;
import com.vaadin.tutorial.crm.backend.repository.WardRepository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class PatientService {

    private static final Logger LOGGER = Logger.getLogger(PatientService.class.getName());
    private PatientRepository patientRepository;
    private WardRepository wardRepository;

    public PatientService(PatientRepository patientRepository, WardRepository wardRepository){
        this.patientRepository = patientRepository;
        this.wardRepository = wardRepository;
    }

    public List<Patient> findAll(){
        return patientRepository.findAll();
    }

    public long count(){
        return patientRepository.count();
    }

    public void delete(Patient patient){
        patientRepository.delete(patient);
    }

    public void save(Patient patient){
        if (patient == null){
            LOGGER.log(Level.SEVERE,"Contact is null. Are you sure you have connected your form to the application?");
            return;
        }
        patientRepository.save(patient);
    }

    @PostConstruct
    public void populateTestData(){
        if (wardRepository.count() == 0){
            wardRepository.saveAll(Stream.of("Ward 1","Ward 2").map(Ward::new).collect(Collectors.toList()));
        }

        if(wardRepository.count() == 0){
            Random r = new Random(0);
            List<Ward> wards = wardRepository.findAll();
            patientRepository.saveAll(Stream.of("John","Mary","Ellen","Rowan","Callan")
                    .map(name -> {
                        Patient patient = new Patient();
                        patient.setName(name); // Maybe this is the problem
                        patient.setWard(wards.get(r.nextInt(wards.size())));
                        return patient;
                    }).collect(Collectors.toList()));
        }
    }
}
