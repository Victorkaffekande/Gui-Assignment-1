package GUI.Controller;

import BE.Classroom;
import BE.Student;
import BE.Subject;
import BE.Teacher;
import GUI.Model.StudentModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoginScreenController {


    Student student;
    Teacher teacher;

    StudentModel studentModel;


    @FXML
    private TextField usernameTxt;
    @FXML
    private TextField passwordTxt;

    public LoginScreenController() {
        List<Subject> SCO2020 = null;
        Classroom c3= null;
        studentModel = new StudentModel();
        student = new Student("Søren", "tunsad",SCO2020 ,"soren123", "soren1234");
        teacher = new Teacher("Jeppe", c3, "jeppe123", "jeppe1234");
    }


    public void handleLogin(ActionEvent actionEvent) throws IOException {
        if (usernameTxt.getText().equals(studentModel.getAllStudents().get(2).getUsername()) && passwordTxt.getText().equals(studentModel.getAllStudents().get(2).getPassword())){
        openScene("/GUI/View/SAbsenceTest.fxml",false, true, "Student Absence", false);
        }
        if (usernameTxt.getText().equals(teacher.getUsername()) && passwordTxt.getText().equals(teacher.getPassword())){
            openScene("/GUI/View/TeacherOverview.fxml",false, true, "Teacher Overview", false);
        }
    }

    public void openScene(String pathToFXML, boolean undecorated, boolean showAndWait, String title, boolean resizable) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(pathToFXML));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        if(undecorated){
            stage.initStyle(StageStyle.UNDECORATED);
        }
        if(!undecorated){
            stage.initStyle(StageStyle.DECORATED);
        }

        stage.setTitle(title);
        stage.setResizable(resizable);

        stage.setScene(scene);
        if(showAndWait){
            stage.showAndWait();
        }

        if(!showAndWait){
            stage.show();
        }
    }
}
