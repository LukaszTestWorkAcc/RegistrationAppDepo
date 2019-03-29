package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import sample.datamodel.Datasource;

public class Main extends Application {

    private boolean exceptionInInit = false;

    @Override
    public void start(Stage primaryStage) throws Exception{
        if(exceptionInInit)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("FATAL ERROR");
            alert.setContentText("Cannot open database");
            alert.showAndWait();
            Platform.exit();
        }
        else
        {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("main.fxml"));
            Parent root = loader.load();
            Controller controller = loader.getController();

            //data init actions
            controller.pupulatePatientsComboBox();
            controller.pupulateDoctorsComboBox();
            controller.pupulateRoomsComboBox();
            controller.pupulateHourComboBox();
            controller.initVisitsAvTable();





            primaryStage.setTitle("RegistrationClient");
            primaryStage.setScene(new Scene(root, 1024, 600));
            primaryStage.show();
        }


//        List<Doctor> doctors = Datasource.getInstance().queryDoctors();
//        for(Doctor doctor : doctors)
//        {
//            System.out.println(doctor.getId() + " " + doctor.getName() + " " + doctor.getSurname());
//        }
//        List<Patient> patients = Datasource.getInstance().queryPatients();
//        for(Patient patient : patients)
//        {
//            System.out.println(patient.getId() + " " + patient.getName() + " " + patient.getSurname());
//        }
//        List<Room> rooms = Datasource.getInstance().queryRooms();
//        for(Room room : rooms)
//        {
//            System.out.println(room.getId() + " " + room.getRoom_name() );
//        }
//        List<V_VisitAv> v_visitsAv = Datasource.getInstance().queryV_VisitAv();
//        for( V_VisitAv v : v_visitsAv)
//        {
//            System.out.println(v.getId() + " " + v.getDoctor_name() + " " + v.getDoctor_surname());
//        }
    }


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void init() throws Exception
    {
        super.init();

        if(!Datasource.getInstance().open())
        {
            exceptionInInit = true;
        }

    }

    @Override
    public void stop() throws Exception
    {
        super.stop();
        Datasource.getInstance().close();
    }
}
