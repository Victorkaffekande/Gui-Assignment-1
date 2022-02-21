package BE;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Student {


    private String userImagePath;
    private ArrayList<Lesson> lessonList;
    private String name;
    private ArrayList<Integer> absenceList;
    private double absenceSum = 0;

    public Student(String name, String userImagePath, ArrayList<Lesson> lessonList, ArrayList<Integer> absenceList) {
        this.name = name;
        this.userImagePath = userImagePath;
        this.lessonList = lessonList;
        this.absenceList = absenceList;
        setAbsenceSum();
    }

    public ArrayList<Integer> getAbsenceList() {
        return absenceList;
    }

    private void setAbsenceSum() {
        double sum = 0;
        for (Integer i : getAbsenceList()) {
            sum += i;
        }
        BigDecimal bd = BigDecimal.valueOf(absenceList.size() / sum * 100);
        bd = bd.setScale(1, RoundingMode.HALF_UP);
        absenceSum = bd.doubleValue();
    }

    public Double getAbsenceSum() {
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
