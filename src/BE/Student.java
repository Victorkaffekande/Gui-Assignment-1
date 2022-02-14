package BE;

import java.util.List;

public class Student {
    private String imagePath;
    private String name;
    private List<Subject> lesson;

    public Student(String name, String imagePath, List<Subject> lesson) {
        this.imagePath = imagePath;
        this.name = name;
        this.lesson = lesson;

    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Subject> getLesson() {
        return lesson;
    }

    public void setLesson(List<Subject> lesson) {
        this.lesson = lesson;
    }
}
