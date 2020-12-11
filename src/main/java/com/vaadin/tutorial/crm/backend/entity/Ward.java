package com.vaadin.tutorial.crm.backend.entity;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
public class Ward extends AbstractEntity {

    private String name;

    @OneToMany(mappedBy = "ward", fetch = FetchType.EAGER)
    private List<Patient> patients = new LinkedList<>();

    public Ward(){

    }

    public Ward(String name){
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Patient> getPatients(){
        return patients;
    }
}
