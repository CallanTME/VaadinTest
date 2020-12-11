package com.vaadin.tutorial.crm.backend.entity;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Patient extends AbstractEntity implements Cloneable{

    public enum Status{
        InSystem, HighPriority, Discharged
    }

    @NotNull
    @NotEmpty
    private String name = "";

    @NotNull
    @NotEmpty
    private String dOB = "";

    @Enumerated(EnumType.STRING)
    @NotNull
    private Patient.Status status;

    @ManyToOne
    @JoinColumn(name = "ward_id")
    private Ward ward;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getdOB() {
        return dOB;
    }

    public void setdOB(String dOB) {
        this.dOB = dOB;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Ward getWard() {
        return ward;
    }

    public void setWard(Ward ward) {
        this.ward = ward;
    }
}
