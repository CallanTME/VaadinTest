package com.vaadin.tutorial.crm.ui.view.main;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route("")
@PageTitle("Ward 1")
public class MainView extends VerticalLayout {

    public MainView() {

        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);
        HorizontalLayout h1 = new HorizontalLayout();
        add(new H1("Ward 1"), h1);
        h1.setWidth("100%");
        h1.setHeight("220px");
        PatientLayout p1 = new PatientLayout("Olly","4","1");
        PatientLayout p2 = new PatientLayout("Callan","6","2");
        PatientLayout p3  = new PatientLayout("Nikita","5","3");
        PatientLayout p4 = new PatientLayout("Alice","3","4");
        h1.add(p1.getVerticalLayout());
        h1.add(p2.getVerticalLayout());
        h1.add(p3.getVerticalLayout());
        h1.add(p4.getVerticalLayout());

        HorizontalLayout h2 = new HorizontalLayout();
        h2.setWidth("100%");
        h2.setHeight("22  0px");
        PatientLayout p5 = new PatientLayout("John","13","5");
        PatientLayout p6 = new PatientLayout("Sean","9","6");
        PatientLayout p7  = new PatientLayout("Charlie","23","7");
        PatientLayout p8 = new PatientLayout("Rowan","17","8");
        h2.add(p5.getVerticalLayout());
        h2.add(p6.getVerticalLayout());
        h2.add(p7.getVerticalLayout());
        h2.add(p8.getVerticalLayout());

        add(h1);
        add(h2);

    }
}