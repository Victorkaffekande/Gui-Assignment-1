package BE;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Subject {
    private final String subjectName;
    private boolean attended;
    private final Teacher teacher;
    private LocalDateTime localDateTime;

    public Subject(String subjectName,Teacher teacher,LocalDateTime localDateTime){
        this.attended = true;
        this.subjectName = subjectName;
        this.teacher = teacher;
        this.localDateTime = localDateTime;
    }

    public String getSubjectName() {
        return subjectName;
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

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return subjectName + " " + teacher +" "+ localDateTime.format(formatter) + " " + "Attended:" + getAttended();
    }
}
