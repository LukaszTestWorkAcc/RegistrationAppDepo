package sample.datamodel;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class VisitAv {

    private SimpleIntegerProperty id;
    private SimpleIntegerProperty doctor_id;
    private SimpleIntegerProperty room_id;
    private SimpleStringProperty from;
    private SimpleStringProperty date;
    private SimpleIntegerProperty limit;

    public VisitAv()
    {
        id = new SimpleIntegerProperty();
        doctor_id = new SimpleIntegerProperty();
        room_id = new SimpleIntegerProperty();
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

    public int getDoctor_id() {
        return doctor_id.get();
    }

    public SimpleIntegerProperty doctor_idProperty() {
        return doctor_id;
    }

    public void setDoctor_id(int doctor_id) {
        this.doctor_id.set(doctor_id);
    }

    public int getRoom_id() {
        return room_id.get();
    }

    public SimpleIntegerProperty room_idProperty() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id.set(room_id);
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
