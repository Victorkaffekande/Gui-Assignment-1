package GUI.Controller;

import BE.Lesson;
import BE.Student;
import GUI.Model.StudentModel;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

public class TodaysLessonsView implements Initializable {
    public TableView<Lesson> tableView;
    public TableColumn<Lesson,String> TCLessons;
    public TableColumn<Lesson, String> TCkl;
    private final StudentModel studentModel;
    private final Student student;

    public TodaysLessonsView(){
        studentModel = new StudentModel();
        student = studentModel.getAllStudents().get(0);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        TCLessons.setCellValueFactory(new PropertyValueFactory<>("subjectName"));
        TCkl.setCellValueFactory(new PropertyValueFactory<>("time"));
        tableView.setItems(studentModel.getTodaysLessons(student));
    }

}
