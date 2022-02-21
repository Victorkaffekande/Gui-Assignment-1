package GUI.Model;

import BE.Teacher;
import BLL.TeacherManager;

import java.util.ArrayList;

public class TeacherModel {
    TeacherManager teacherManager = new TeacherManager();
    public ArrayList<Teacher> getAllTeachers(){
        return teacherManager.getAllTeachers();
    }
}
