package com.vaadin.tutorial.crm.ui.view.wards;

import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.progressbar.ProgressBar;
import com.vaadin.flow.component.progressbar.ProgressBarVariant;

import java.util.Random;

public class PatientLayout {
    private VerticalLayout layout_1;
    //private ProgressBar progressBar;
    //private Label name;
    //private Label bScore;

    public PatientLayout(String nameIn, String bScoreIn, String bedNumIn){
        layout_1 = new VerticalLayout();
        layout_1.setWidth("50%");
        layout_1.setHeight("220px");
        layout_1.getStyle().set("border", "1px solid #9E9E9E");
        Random r = new Random();
        int prog = r.nextInt(100);
        ProgressBar progressBar = new ProgressBar(0, 100, prog);
        progressBar.setHeight("20px");
        if (prog < 33)
            progressBar.addThemeVariants(ProgressBarVariant.LUMO_SUCCESS);
        else if (prog > 33 & prog < 67)
            progressBar.addThemeVariants(ProgressBarVariant.LUMO_CONTRAST);
        else
            progressBar.addThemeVariants(ProgressBarVariant.LUMO_ERROR);

        Label bedNum = new Label("Bed Number: " + bedNumIn);
        Label name = new Label("Name: " + nameIn);
        Label bScore = new Label("Braden Score: " + bScoreIn);
        Label time = new Label("Time in Position: 0h 0m 0s");
        layout_1.add(bedNum,name,bScore,progressBar,time);

        layout_1.setSpacing(true);
        layout_1.setMargin(true);
        layout_1.setPadding(true);
    }

    public VerticalLayout getVerticalLayout(){
        return layout_1;
    }
}
