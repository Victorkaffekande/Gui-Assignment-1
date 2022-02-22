package BE;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Student {


    private String userImagePath;
    private ArrayList<Lesson> lessonList;
    private String name;
    private ArrayList<Double> absenceList;
    private double absenceSum = 0;

    public Student(String name, String userImagePath, ArrayList<Lesson> lessonList, ArrayList<Double> absenceList) {
        this.name = name;
        this.userImagePath = userImagePath;
        this.lessonList = lessonList;
        this.absenceList = absenceList;
        setAbsenceSum();
    }

    public ArrayList<Double> getAbsenceList() {
        return absenceList;
    }

    private void setAbsenceSum() {
        double sum = 0;
        for (Double d : getAbsenceList()) {
            sum += d;
        }

        long factor = (long) Math.pow(10, 2);
        sum = sum * factor;
        long tmp = Math.round(sum);
        absenceSum = (double) tmp / factor;
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
