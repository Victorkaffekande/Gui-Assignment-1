package BE;

import java.util.ArrayList;

public class Student {


    private String userImagePath;
    private ArrayList<Lesson> lessonList;
    private String name;
    private ArrayList<Integer> absenceList;
    private Integer absenceSum=0;
    public Student(String name,String userImagePath, ArrayList<Lesson> lessonList, ArrayList<Integer> absenceList){
        this.name = name;
        this.userImagePath = userImagePath;
        this.lessonList = lessonList;
        this.absenceList = absenceList;
        setAbsenceSum();
    }

    public ArrayList<Integer> getAbsenceList() {
        return absenceList;
    }

    private void setAbsenceSum(){
        for(Integer i : getAbsenceList()){
            absenceSum += i;
        }
    }

    public Integer getAbsenceSum() {
        return absenceSum;
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
