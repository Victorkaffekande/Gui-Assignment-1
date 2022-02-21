package BLL;

import BE.Classroom;
import BE.Subject;
import BE.Teacher;
import DAL.TeacherDAO;

import java.util.List;

public class TeacherManager {

    public TeacherDAO teacherDAO;

    public TeacherManager() {
        teacherDAO = new TeacherDAO();
    }

    public List<Teacher> getAllTeachers(){
        return teacherDAO.getAllTeachers();
    }

    public List<Classroom> getAllClassrooms(){
        return teacherDAO.getAllClassrooms();
    }

    public List<Subject> getAllSubjects(){
        return teacherDAO.getAllSubjects();
    }
}
