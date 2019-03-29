package sample;

import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import sample.datamodel.Datasource;
import sample.datamodel.Patient;

import java.io.IOException;


public class EditPatientDController {

    @FXML
    TextField firstNameField;

    @FXML
    TextField lastNameField;

    @FXML
    TextField phoneNumberField;

    @FXML
    TextField addressField;

    @FXML
    TableView tableViewPatients;

    @FXML
    Button buttonApplyChanges;

    public void initialize() throws IOException {
        initTableView();
    }

    @FXML
    public void initTableView() {
        Task<ObservableList<Patient>> task = new GetAllPatientsTask();
        tableViewPatients.itemsProperty().bind(task.valueProperty());

        new Thread(task).start();
    };

    @FXML
    public void fillTFields()
    {
        Patient patient = (Patient) tableViewPatients.getSelectionModel().getSelectedItem();
        firstNameField.setText(patient.getName());
        lastNameField.setText(patient.getSurname());
        phoneNumberField.setText(patient.getTelephone());
        addressField.setText(patient.getAddress());

    };
    @FXML
    public void applyChanges()
    {
        Patient patient = (Patient) tableViewPatients.getSelectionModel().getSelectedItem();
        if( patient == null)
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setHeaderText("WARNING");
            alert.setContentText("Please select patient do edit.\nPatient not selected");
            alert.showAndWait();
            return;
        }
        else
        {
            Datasource.getInstance().updatePatient(patient.getId(), firstNameField.getText(),
                    lastNameField.getText(), phoneNumberField.getText(), addressField.getText());
            initTableView();
        }
    };

}
