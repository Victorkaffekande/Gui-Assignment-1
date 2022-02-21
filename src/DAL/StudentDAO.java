package DAL;

import BE.Student;
import BE.Subject;

import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    public List<Student> students;
    public TeacherDAO teacherDAO;


    public StudentDAO() {
        teacherDAO = new TeacherDAO();
        students = new ArrayList<>();
    }

    public List<Student> getAllStudents(){
        Student student1 = new Student("Hanne", "asd", teacherDAO.getAllSubjects(), "hanne123", "hanne1234");
        Student student2 = new Student("Sofie", "asd", teacherDAO.getAllSubjects(), "sofie123", "sofie1234");
        Student student3 = new Student("Flemming", "asd", teacherDAO.getAllSubjects(), "flemse123", "flemse1234");

        students.add(student1);
        students.add(student2);
        students.add(student3);

        return students;
    }


}
