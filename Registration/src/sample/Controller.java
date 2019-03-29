package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import sample.datamodel.*;

import java.io.IOException;
import java.util.Optional;

public class Controller {

    @FXML
    private BorderPane mainPanel;

    @FXML
    private TableView visitsAvTable;

    @FXML
    private ComboBox<Patient> patientComboBox;

    @FXML
    private ComboBox<Doctor> doctorComboBox;

    @FXML
    private ComboBox<Room> roomComboBox;

    @FXML
    private ComboBox<String> hourComboBox;

    @FXML
    private Button addVisitAvData;

    @FXML
    private Button registerVisitButton;

    @FXML
    private DatePicker datepicker;

    @FXML
    private TextField limitAv;

    @FXML
    public void initVisitsAvTable() {
        Task<ObservableList<V_VisitAv>> task = new GetAllViewsVisitAvTask();
        visitsAvTable.itemsProperty().bind(task.valueProperty());

        new Thread(task).start();
    };

    @FXML void registerVisit()
    {
        Patient patient = null;
        int visitAvId = -1;
        V_VisitAv selectedV = null;

        try{
            patient = patientComboBox.getValue();
            selectedV = (V_VisitAv)visitsAvTable.getSelectionModel().getSelectedItem();
            visitAvId = selectedV.getId();
        }catch(Exception e)
        {};
        if( patient == null || visitAvId == -1 )
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setHeaderText("WARNING");
            alert.setContentText("Please select patient and aviable date of visit");
            alert.showAndWait();
            return;
        }

        int number = 1 + Datasource.getInstance().getCountOfRegisteredVisitsOnDate(visitAvId);
        if( number == -1 )
        {
            return;
        }
        if( number > selectedV.getLimit() )
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setHeaderText("WARNING");
            alert.setContentText("Cannot register on selected visit.\nLimit exceeded\nPlease select other date");
            alert.showAndWait();
            return;
        }
        Visit newVisit = new Visit();
        newVisit.setPatient_id(patient.getId());
        newVisit.setVisits_availability_id(selectedV.getId());
        newVisit.setStatus("Registered");
        newVisit.setNumber(number);

        Datasource.getInstance().insertVisit(newVisit.getPatient_id(), newVisit.getVisits_availability_id(), newVisit.getStatus(), newVisit.getNumber());

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Registration summary");
        alert.setHeaderText("INFORMATION");
        alert.setContentText("Patient: " + patient.getName() + " " + patient.getSurname() + "\n is registered to doctor: " + selectedV.getDoctor_name() + " " + selectedV.getDoctor_surname() + "\n" +
                "on " + selectedV.getDate() + " on " + selectedV.getFrom() + " with number " + newVisit.getNumber() );
        alert.showAndWait();


    }

    @FXML
    public void pupulatePatientsComboBox() {
        Task<ObservableList<Patient>> task = new GetAllPatientsTask();
        patientComboBox.itemsProperty().bind(task.valueProperty());

        new Thread(task).start();
    }

    @FXML
    public void pupulateDoctorsComboBox() {
        Task<ObservableList<Doctor>> task = new GetAllDoctorsTask();
        doctorComboBox.itemsProperty().bind(task.valueProperty());

        new Thread(task).start();
    }

    @FXML
    public void pupulateRoomsComboBox() {
        Task<ObservableList<Room>> task = new GetAllRoomsTask();
        roomComboBox.itemsProperty().bind(task.valueProperty());

        new Thread(task).start();
    }

    @FXML
    public void pupulateHourComboBox() {
        ObservableList<String> options =
                FXCollections.observableArrayList(
                        "6:00","7:00","8:00", "9:00", "10:00", "11:00", "12:00"
                );
        hourComboBox.setItems(options);


    }

    @FXML
    public void addVisitAvData()
    {
        Doctor doc = doctorComboBox.getValue();
        Room room = roomComboBox.getValue();
        String hour = hourComboBox.getValue();
        String date = null;
        int limit = -1;
        try
        {
            date = datepicker.getValue().toString();
            limit = Integer.parseInt(limitAv.getText());
        }catch(Exception e)
        {
            //System.out.println("Error" + e.getMessage());
        };



        if(doc == null || room == null || hour ==null || date == null || limit == -1)
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setHeaderText("WARNING");
            alert.setContentText("Please chose and fill all nesessery data before finishing addition\n Field limit accepts only numbers");
            alert.showAndWait();
            return;
        }

        Datasource.getInstance().insertVisitAv(doc.getId(), room.getId(), hour, date, limit );
        initVisitsAvTable();


    }

    @FXML
    public void showAddPatientDialog() {

        Dialog<ButtonType> dialog = new Dialog<ButtonType>();
        dialog.initOwner(mainPanel.getScene().getWindow());
        dialog.setTitle("Add New Patient");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("addpatientdialog.fxml"));

        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());

        } catch (IOException e) {
            System.out.println("Couldn't load the dialog");
            e.printStackTrace();
            return;
        }

        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        Optional<ButtonType> result = dialog.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            AddPatientDController addPatientDController = fxmlLoader.getController();
            //adding new patient to database
            Patient newPatient = addPatientDController.getNewPatient();
            Datasource.getInstance().insertPatient(newPatient.getName(), newPatient.getSurname(), newPatient.getTelephone(), newPatient.getAddress());
            //temporary
            this.pupulatePatientsComboBox();
        }


    }

    @FXML
    public void showEditPatientDialog() {

        Dialog<ButtonType> dialog = new Dialog<ButtonType>();
        dialog.initOwner(mainPanel.getScene().getWindow());
        dialog.setTitle("Edition of patient data");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("editpatientdialog.fxml"));


        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());


        } catch (IOException e) {
            System.out.println("Couldn't load the dialog");
            e.printStackTrace();
            return;
        }

        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        //dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        Optional<ButtonType> result = dialog.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            pupulatePatientsComboBox();
        }


    }

    @FXML
    public void showAddDoctorDialog() {

        Dialog<ButtonType> dialog = new Dialog<ButtonType>();
        dialog.initOwner(mainPanel.getScene().getWindow());
        dialog.setTitle("Add New Doctor");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("adddoctordialog.fxml"));

        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());

        } catch (IOException e) {
            System.out.println("Couldn't load the dialog");
            e.printStackTrace();
            return;
        }

        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        Optional<ButtonType> result = dialog.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            AddDoctorDController addDoctorDController = fxmlLoader.getController();
            //adding new doctor to database
            Doctor newDoctor = addDoctorDController.getNewDoctor();
            Datasource.getInstance().insertDoctor(newDoctor.getName(), newDoctor.getSurname(), newDoctor.getTelephone(), newDoctor.getAddress());
            //refresh all things binded to doctors table
            pupulateDoctorsComboBox();
            initVisitsAvTable();
        }


    }

    @FXML
    public void showEditDoctorDialog() {

        Dialog<ButtonType> dialog = new Dialog<ButtonType>();
        dialog.initOwner(mainPanel.getScene().getWindow());
        dialog.setTitle("Edition of doctor data");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("editdoctordialog.fxml"));


        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());


        } catch (IOException e) {
            System.out.println("Couldn't load the dialog");
            e.printStackTrace();
            return;
        }

        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        //dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        Optional<ButtonType> result = dialog.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            //refresh all things binded to doctors table
            pupulateDoctorsComboBox();
        }


    }

    @FXML
    public void showVisitsManagementDialog() {

        Dialog<ButtonType> dialog = new Dialog<ButtonType>();
        dialog.initOwner(mainPanel.getScene().getWindow());
        dialog.setTitle("Visits management");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("editvisitsdialog.fxml"));


        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());


        } catch (IOException e) {
            System.out.println("Couldn't load the dialog");
            e.printStackTrace();
            return;
        }

        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        //dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        Optional<ButtonType> result = dialog.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            //pupulatePatientsComboBox();
        }


    }

    @FXML
    public void showAboutInfo()
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About");
        alert.setHeaderText("INFORMATION");
        alert.setContentText("Its a simple application based on JavaFX and SQLite database\n" +
                "Aplication is called Registration, it allows adding/editing personal data for patients and doctors.\n" +
                "The main features are managing doctors visits availabilities and registering patients for a aviable dates\n" +
                "Application allows also editing registered visits status\n" +
                "\nApplication made by\n Łukasz Gruszczyński \n 29.03.2019");
        alert.showAndWait();
    }
}




class GetAllDoctorsTask extends Task {

    @Override
    public ObservableList<Doctor> call() {
        return FXCollections.observableArrayList
                (Datasource.getInstance().queryDoctors());
    }
}

class GetAllPatientsTask extends Task {

    @Override
    public ObservableList<Patient> call() {
        return FXCollections.observableArrayList
                (Datasource.getInstance().queryPatients());
    }
}

class GetAllRoomsTask extends Task {

    @Override
    public ObservableList<Room> call()  {
        return FXCollections.observableArrayList
                (Datasource.getInstance().queryRooms());
    }
}

class GetAllViewsVisitAvTask extends Task {

    @Override
    public ObservableList<V_VisitAv> call()  {
        return FXCollections.observableArrayList
                (Datasource.getInstance().queryV_VisitAv());
    }
}

class GetAllViewsVisitTask extends Task {

    @Override
    public ObservableList<V_Visit> call()  {
        return FXCollections.observableArrayList
                (Datasource.getInstance().queryV_Visit());
    }
}

