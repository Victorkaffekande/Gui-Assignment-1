package GUI.Model;

import BE.Student;
import BLL.StudentManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public class StudentModel {

    public StudentManager studentManager;
    public ObservableList<Student> studentList;

    public StudentModel() {
    studentManager = new StudentManager();
    studentList = FXCollections.observableArrayList();
    studentList.addAll(studentManager.getAllStudents());
    }

    public List<Student> getAllStudents(){
        return studentManager.getAllStudents();
    }
}
