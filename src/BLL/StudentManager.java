package BLL;

import BE.Student;
import BE.Lesson;
import DAL.StudentDAO;
import javafx.collections.ObservableList;

import java.util.ArrayList;
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
    public ObservableList<Lesson> getRecentSubjects(Student student){
        return studentDAO.getRecentLessons(student);
    }
}
