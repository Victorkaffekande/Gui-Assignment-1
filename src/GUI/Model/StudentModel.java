package GUI.Model;

import BE.Student;
import BE.Lesson;
import BLL.StudentManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Map;

public class StudentModel {
    StudentManager studentManager;

    public StudentModel(){
        studentManager = new StudentManager();
    }
    public Map<String,Integer> getStudentAttendance(Student student){
        return studentManager.getStudentAttendance(student);
    }

    public ArrayList<Student> getAllStudents(){
        return studentManager.getAllstudents();
    }

    public ObservableList<Student> getAllObservableStudents(){
        ObservableList<Student> observableList = FXCollections.observableArrayList();
        observableList.addAll(studentManager.getAllstudents());
        return  observableList;
    }

    public ObservableList<Lesson> getTodaysLessons(Student student){
        return studentManager.getTodaysLessons(student);
    }


}
