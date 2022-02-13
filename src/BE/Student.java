package BE;

import java.util.ArrayList;

public class Student {


    private String userImagePath;
    private ArrayList<Lesson> lessonList;
    private String name;
    public Student(String name,String userImagePath, ArrayList<Lesson> lessonList){
        this.name = name;

        this.userImagePath = userImagePath;
        this.lessonList = lessonList;
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
}
