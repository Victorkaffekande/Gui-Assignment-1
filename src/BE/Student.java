package BE;

import java.util.ArrayList;

public class Student {


    private String userImagePath;
    private ArrayList<Subject> subjectList;
    private String name;
    public Student(String name,String userImagePath, ArrayList<Subject> subjectList){
        this.name = name;

        this.userImagePath = userImagePath;
        this.subjectList = subjectList;
    }


    public String getUserImagePath() {
        return userImagePath;
    }

    public ArrayList<Subject> getSubjectList() {
        return subjectList;
    }

    @Override
    public String toString() {
        return name;
    }
}
