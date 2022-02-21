package BE;

import java.time.LocalDateTime;
import java.util.Date;

public class Subject {
    private String name;
    private LocalDateTime start;
    private Teacher teacher;

    public Subject(String name, LocalDateTime start, Teacher teacher) {
        this.name = name;
        this.start = start;
        this.teacher = teacher;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
