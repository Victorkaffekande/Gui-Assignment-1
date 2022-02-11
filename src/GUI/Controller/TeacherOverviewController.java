package GUI.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class TeacherOverviewController implements Initializable {

    @FXML
    private Label sco2020Student;
    @FXML
    private Label sde2021Student;
    @FXML
    private Label sde2020Student;
    @FXML
    private Button sde2020Classbutton;
    @FXML
    private Label sde2020Fravaerlist;
    @FXML
    private Button sde2021ClassButton;
    @FXML
    private Label sde2021Fravaerlist;
    @FXML
    private Button sco2020ClassButon;
    @FXML
    private Label sco2020Fravaerlist;
    @FXML
    private Button backButton;
    @FXML
    private Label teacherLabelName;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        teacherLabelName.setText("Welcome Søren!");
        setStudents();
    }

    public void setStudents(){
        sde2020Fravaerlist.setText("Flemming A. Sørensen" + " " + "27%");
        sde2021Fravaerlist.setText("Ole Ram" + " " + "17%");
        sco2020Fravaerlist.setText("Flemming A. Sørensen" + " " + "67%");
    }

    public void handleBackButton(ActionEvent actionEvent) {
        System.exit(0);
    }
}
