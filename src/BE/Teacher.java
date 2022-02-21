package BE;

public class Teacher {
    private String name;
    private String userImagePath;
    public Teacher(String name, String userImagePath){
        this.name = name;
        this.userImagePath = userImagePath;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return getName();
    }

    public String getUserImagePath() {
        return userImagePath;
    }
}
