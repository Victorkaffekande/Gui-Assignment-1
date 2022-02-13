package BLL;

import BE.Student;
import BE.Subject;
import DAL.StudentDAO;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StudentManager {
    StudentDAO studentDAO;
    public StudentManager(){
        studentDAO = new StudentDAO();
    }
    public Map<String,Integer> getStudentAttendance(Student student){
        return studentDAO.getStudentAttendance(student);
    }
    public ArrayList<Student> getAllstudents(){
        return studentDAO.getAllStudents();
    }
    public ObservableList<Subject> getRecentSubjects(Student student){
        return studentDAO.getRecentLessons(student);
    }
}
