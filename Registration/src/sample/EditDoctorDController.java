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
import sample.datamodel.Doctor;
import sample.datamodel.Patient;

import java.io.IOException;


public class EditDoctorDController {

    @FXML
    TextField firstNameField;

    @FXML
    TextField lastNameField;

    @FXML
    TextField phoneNumberField;

    @FXML
    TextField addressField;

    @FXML
    TableView tableViewDoctors;

    @FXML
    Button buttonApplyChanges;

    public void initialize() throws IOException {
        initTableView();
    }

    @FXML
    public void initTableView() {
        Task<ObservableList<Doctor>> task = new GetAllDoctorsTask();
        tableViewDoctors.itemsProperty().bind(task.valueProperty());

        new Thread(task).start();
    };

    @FXML
    public void fillTFields()
    {
        Doctor doctor = (Doctor) tableViewDoctors.getSelectionModel().getSelectedItem();
        firstNameField.setText(doctor.getName());
        lastNameField.setText(doctor.getSurname());
        phoneNumberField.setText(doctor.getTelephone());
        addressField.setText(doctor.getAddress());

    };
    @FXML
    public void applyChanges()
    {
        Doctor doctor = (Doctor) tableViewDoctors.getSelectionModel().getSelectedItem();
        if( doctor == null)
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setHeaderText("WARNING");
            alert.setContentText("Please select doctor to edit.\nDoctor not selected");
            alert.showAndWait();
            return;
        }
        else
        {
            Datasource.getInstance().updateDoctor(doctor.getId(), firstNameField.getText(),
                    lastNameField.getText(), phoneNumberField.getText(), addressField.getText());
            initTableView();
        }
    };

}
