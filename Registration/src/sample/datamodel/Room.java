package sample.datamodel;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Room {
    private SimpleIntegerProperty id;
    private SimpleStringProperty room_name;

    public Room() {
        id = new SimpleIntegerProperty();
        room_name = new SimpleStringProperty();

    }

    public int getId() {
        return id.get();
    }


    public void setId(int id) {
        this.id.set(id);
    }

    public String getRoom_name() {
        return room_name.get();
    }

    public void setRoom_name(String room_name) {
        this.room_name.set(room_name);
    }

    @Override
    public String toString() {
        return room_name.get();
    }
}
