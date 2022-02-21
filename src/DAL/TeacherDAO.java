package DAL;

import BE.Teacher;

import java.util.ArrayList;

public class TeacherDAO {

    public ArrayList<Teacher> getAllTeachers(){
        ArrayList<Teacher> teacherList = new ArrayList<>();
        teacherList.add(new Teacher("Susanne Alhadid","images/teacher.jpeg"));
        teacherList.add(new Teacher("Søren Slot","images/teacher.jpeg"));
        teacherList.add(new Teacher("Kirstine Petersen","images/teacher.jpeg"));
        teacherList.add(new Teacher("Lea Ram","images/teacher.jpeg"));
        return teacherList;
    }


}
