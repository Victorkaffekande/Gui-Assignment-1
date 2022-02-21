package BE;

import java.util.List;

public class Student {
    private String imagePath;
    private String name;
    private List<Subject> lesson;
    private String username;
    private String password;

    public Student(String name, String imagePath, List<Subject> lesson, String username, String password) {
        this.imagePath = imagePath;
        this.name = name;
        this.lesson = lesson;
        this.password = password;
        this.username = username;

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
