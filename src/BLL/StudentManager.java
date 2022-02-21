package BLL;

import BE.Student;
import DAL.StudentDAO;

import java.util.List;

public class StudentManager {

    public StudentDAO studentDAO;

    public StudentManager() {
        studentDAO = new StudentDAO();

    }

    public List<Student> getAllStudents(){
        return studentDAO.getAllStudents();
    }
}
