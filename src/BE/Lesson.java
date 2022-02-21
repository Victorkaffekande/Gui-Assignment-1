package BE;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Lesson {
    private final String subjectName;
    private boolean attended;
    private final Teacher teacher;
    private final LocalDateTime localDateTime;
    private String time;
    private StringProperty status = new SimpleStringProperty();
    public Lesson(String subjectName, Teacher teacher, LocalDateTime localDateTime){
        this.attended = true;
        this.subjectName = subjectName;
        this.teacher = teacher;
        this.localDateTime = localDateTime;
        this.time = getStartTime();
        setStatus("Til stede");

    }

    public String getStatus() {
        return status.get();
    }

    public StringProperty statusProperty() {
        return status;
    }

    public void setStatus(String status) {
        this.status.set(status);
    }

    public String getSubjectName() {
        return subjectName;
    }

    public String getTime() {
        return time;
    }

    public boolean getAttended() {
        return attended;
    }

    public Teacher getTeacher(){
        return teacher;
    }

    public LocalDateTime getDate() {
        return localDateTime;
    }

    public void setAttended(boolean b){
        attended = b;
    }

    private String getStartTime(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        return localDateTime.format(formatter)+" : "+localDateTime.plusMinutes(45).format(formatter);
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return subjectName + " " + teacher +" "+ localDateTime.format(formatter) + " " + "Attended:" + getAttended();
    }
}
