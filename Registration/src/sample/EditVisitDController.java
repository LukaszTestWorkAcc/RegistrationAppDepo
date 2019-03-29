package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import sample.datamodel.Datasource;
import sample.datamodel.Patient;
import sample.datamodel.V_Visit;
import sample.datamodel.Visit;

import java.io.IOException;

public class EditVisitDController {

    @FXML
    TableView tableViewVisits;

    @FXML
    ComboBox<String> statusComboBox;

    @FXML
    public void initialize() throws IOException {
        initTableView();
        ObservableList<String> options =
                FXCollections.observableArrayList(
                        "Registered","Done","Cancelled","Missed"
                );
        statusComboBox.setItems(options);
    }

    @FXML
    public void initTableView() {
        Task<ObservableList<V_Visit>> task = new GetAllViewsVisitTask();
        tableViewVisits.itemsProperty().bind(task.valueProperty());

        new Thread(task).start();
    };

    @FXML
    public void applyChanges()
    {

        V_Visit v_visit = null;
        String sStatus = null;
        try
        {
            v_visit = (V_Visit)tableViewVisits.getSelectionModel().getSelectedItem();
            sStatus = statusComboBox.getSelectionModel().getSelectedItem();
        }
        catch(Exception e)
        {}

        //System.out.println(v_visit.getId()+ " " + sStatus);
        if( v_visit == null || sStatus == null )
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setHeaderText("WARNING");
            alert.setContentText("Please select visit and its new status before applying changes.");
            alert.showAndWait();
            return;
        }
        else
        {
            Datasource.getInstance().updateVisit(v_visit.getId(), sStatus);
            initTableView();
        }
    };
}
