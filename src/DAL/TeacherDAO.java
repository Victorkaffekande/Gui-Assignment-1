package DAL;

import BE.Teacher;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class TeacherDAO {
    TimeHelper timeHelper = new TimeHelper();
    LocalDateTime today = timeHelper.getToday();
    LocalDateTime todayMorning = timeHelper.getTodayMorning();

    public ArrayList<Teacher> getAllTeachers(){
        ArrayList<Teacher> teacherList = new ArrayList<>();
        teacherList.add(new Teacher("Susanne Alhadid","images/teacher.png"));
        teacherList.add(new Teacher("Søren Slot","images/teacher.png"));
        teacherList.add(new Teacher("Kirstine Petersen","images/teacher.png"));
        teacherList.add(new Teacher("Lea Ram","images/teacher.png"));
        return teacherList;
    }


}
