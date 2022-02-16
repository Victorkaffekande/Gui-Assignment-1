package BE;

import java.util.List;

public class Teacher {
    private String name;
    private List<Subject> subjects;
    private Classroom classroom;

    public Teacher(String name, List<Subject> subjects, Classroom classroom) {
        this.name = name;
        this.subjects = subjects;
        this.classroom = classroom;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }
}
