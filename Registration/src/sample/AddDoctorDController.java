package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import sample.datamodel.Doctor;
import sample.datamodel.Patient;

public class AddDoctorDController {
    @FXML
    TextField firstNameField;

    @FXML
    TextField lastNameField;

    @FXML
    TextField phoneNumberField;

    @FXML
    TextField addressField;

    public Doctor getNewDoctor() {
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String phoneNumber = phoneNumberField.getText();
        String address = addressField.getText();

        Doctor newContact = new Doctor();
        newContact.setName(firstName);
        newContact.setSurname(lastName);
        newContact.setTelephone(phoneNumber);
        newContact.setAddress(address);
        return newContact;
    }
}
