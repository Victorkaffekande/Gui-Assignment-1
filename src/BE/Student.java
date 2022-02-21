package BE;

import java.util.ArrayList;

public class Student {


    private String userImagePath;
    private ArrayList<Lesson> lessonList;
    private String name;
    private double absence;
    public Student(String name,String userImagePath, ArrayList<Lesson> lessonList, double absence){
        this.name = name;
        this.userImagePath = userImagePath;
        this.lessonList = lessonList;
        this.absence = absence;
    }


    public String getUserImagePath() {
        return userImagePath;
    }

    public ArrayList<Lesson> getLessonList() {
        return lessonList;
    }

    @Override
    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }
}
