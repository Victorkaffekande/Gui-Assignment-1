package GUI.Controller;

import BE.Classroom;
import BE.Student;
import BE.Subject;
import BE.Teacher;
import GUI.Model.StudentModel;
import GUI.Model.TeacherModel;
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
    TeacherModel teacherModel;


    @FXML
    private TextField usernameTxt;
    @FXML
    private TextField passwordTxt;

    public LoginScreenController() {
        studentModel = new StudentModel();
        teacherModel = new TeacherModel();
    }


    public void handleLogin(ActionEvent actionEvent) throws IOException {
       for (Student student: studentModel.getAllStudents()){
           if (usernameTxt.getText().equals(student.getUsername()) && passwordTxt.getText().equals(student.getPassword())){
               openScene("/GUI/View/SAbsenceTest.fxml",false, true, "Student Absence", false);
                break;
           }
       }

       for (Teacher teacher: teacherModel.getAllTeachers()){
           if (usernameTxt.getText().equals(teacher.getUsername()) && passwordTxt.getText().equals(teacher.getPassword())){
               openScene("/GUI/View/TeacherOverview.fxml",false, true, "Teacher Overview", false);
                break;
           }
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
