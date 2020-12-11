package com.vaadin.tutorial.crm.backend.service;

import com.vaadin.tutorial.crm.backend.entity.Ward;
import com.vaadin.tutorial.crm.backend.repository.WardRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WardService {

    private WardRepository wardRepository;

    public WardService(WardRepository wardRepository){
        this.wardRepository = wardRepository;
    }

    public List<Ward> findAll(){
        return wardRepository.findAll();
    }
}
