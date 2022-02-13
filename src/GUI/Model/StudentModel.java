package GUI.Model;

import BE.Student;
import BE.Lesson;
import BLL.StudentManager;
import javafx.collections.ObservableList;

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

    public ObservableList<Lesson> getRecentLessons(Student student){
        return studentManager.getRecentSubjects(student);
    }
}
