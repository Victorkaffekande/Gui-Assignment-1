package BLL;

import BE.Teacher;
import DAL.TeacherDAO;

import java.util.ArrayList;

public class TeacherManager {
    TeacherDAO teacherDAO = new TeacherDAO();
    public ArrayList<Teacher> getAllTeachers(){
        return teacherDAO.getAllTeachers();
    }

}
