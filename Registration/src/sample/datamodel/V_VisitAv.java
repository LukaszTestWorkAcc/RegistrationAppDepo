package sample.datamodel;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class V_VisitAv {

    private SimpleIntegerProperty id;
    private SimpleStringProperty doctor_name;
    private SimpleStringProperty doctor_surname;
    private SimpleStringProperty room_name;
    private SimpleStringProperty from;
    private SimpleStringProperty date;
    private SimpleIntegerProperty limit;

    public V_VisitAv() {
        id = new SimpleIntegerProperty();
        doctor_name = new SimpleStringProperty();
        doctor_surname = new SimpleStringProperty();
        room_name = new SimpleStringProperty();
        from = new SimpleStringProperty();
        date = new SimpleStringProperty();
        limit = new SimpleIntegerProperty();
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

    public String getDoctor_name() {
        return doctor_name.get();
    }

    public SimpleStringProperty doctor_nameProperty() {
        return doctor_name;
    }

    public void setDoctor_name(String doctor_name) {
        this.doctor_name.set(doctor_name);
    }

    public String getDoctor_surname() {
        return doctor_surname.get();
    }

    public SimpleStringProperty doctor_surnameProperty() {
        return doctor_surname;
    }

    public void setDoctor_surname(String doctor_surname) {
        this.doctor_surname.set(doctor_surname);
    }

    public String getRoom_name() {
        return room_name.get();
    }

    public SimpleStringProperty room_nameProperty() {
        return room_name;
    }

    public void setRoom_name(String room_name) {
        this.room_name.set(room_name);
    }

    public String getFrom() {
        return from.get();
    }

    public SimpleStringProperty fromProperty() {
        return from;
    }

    public void setFrom(String from) {
        this.from.set(from);
    }

    public String getDate() {
        return date.get();
    }

    public SimpleStringProperty dateProperty() {
        return date;
    }

    public void setDate(String date) {
        this.date.set(date);
    }

    public int getLimit() {
        return limit.get();
    }

    public SimpleIntegerProperty limitProperty() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit.set(limit);
    }
}
