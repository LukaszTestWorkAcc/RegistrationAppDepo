package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import sample.datamodel.Patient;


public class AddPatientDController {

    @FXML
    TextField firstNameField;

    @FXML
    TextField lastNameField;

    @FXML
    TextField phoneNumberField;

    @FXML
    TextField addressField;

    public Patient getNewPatient() {
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String phoneNumber = phoneNumberField.getText();
        String address = addressField.getText();

        Patient newContact = new Patient();
        newContact.setName(firstName);
        newContact.setSurname(lastName);
        newContact.setTelephone(phoneNumber);
        newContact.setAddress(address);
        return newContact;
    }
}
