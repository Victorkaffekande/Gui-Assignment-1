package BE;

import java.util.List;

public class Classroom {
    private List<Student> listOfStudents;
    private String name;
    private double attendance;

    public Classroom( String name, double attendance) {
        this.name = name;
        this.attendance = attendance;
    }

    public List<Student> getListOfStudents() {
        return listOfStudents;
    }

    public void setListOfStudents(List<Student> listOfStudents) {
        this.listOfStudents = listOfStudents;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAttendance() {
        return attendance;
    }

    public void setAttendance(double attendance) {
        this.attendance = attendance;
    }
}
