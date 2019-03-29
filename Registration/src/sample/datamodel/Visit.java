package sample.datamodel;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Visit {

    private SimpleIntegerProperty id;
    private SimpleIntegerProperty patient_id;
    private SimpleIntegerProperty visits_availability_id;
    private SimpleStringProperty status;
    private SimpleIntegerProperty number;

    public Visit()
    {
        id = new SimpleIntegerProperty();
        patient_id = new SimpleIntegerProperty();
        visits_availability_id = new SimpleIntegerProperty();
        status = new SimpleStringProperty();
        number = new SimpleIntegerProperty();
    }

    public int getId() {
        return id.get();
    }

    public SimpleIntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public int getPatient_id() {
        return patient_id.get();
    }

    public SimpleIntegerProperty patient_idProperty() {
        return patient_id;
    }

    public void setPatient_id(int patient_id) {
        this.patient_id.set(patient_id);
    }

    public int getVisits_availability_id() {
        return visits_availability_id.get();
    }

    public SimpleIntegerProperty visits_availability_idProperty() {
        return visits_availability_id;
    }

    public void setVisits_availability_id(int visits_availability_id) {
        this.visits_availability_id.set(visits_availability_id);
    }

    public String getStatus() {
        return status.get();
    }

    public SimpleStringProperty statusProperty() {
        return status;
    }

    public void setStatus(String status) {
        this.status.set(status);
    }

    public int getNumber() {
        return number.get();
    }

    public SimpleIntegerProperty numberProperty() {
        return number;
    }

    public void setNumber(int number) {
        this.number.set(number);
    }

}
