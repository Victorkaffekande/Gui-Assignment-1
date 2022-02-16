package DAL;

import BE.Classroom;
import BE.Subject;
import BE.Teacher;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TeacherDAO {

    public List<Classroom> classrooms;
    public List<Teacher> teachers;
    public List<Subject> subjects;
    public LocalDateTime time;


    public TeacherDAO() {
        teachers = new ArrayList<>();
        subjects = new ArrayList<>();
        classrooms = new ArrayList<>();
    }

    public List<Classroom> getAllClassrooms(){
        Classroom classroom1 = new Classroom("c1", 12.34);
        Classroom classroom2 = new Classroom("c2", 56.78);
        Classroom classroom3 = new Classroom("c3", 91.01);
        Classroom classroom4 = new Classroom("c4", 23.45);

        classrooms.add(classroom1);
        classrooms.add(classroom2);
        classrooms.add(classroom3);
        classrooms.add(classroom4);


        return classrooms;
    }

    public List<Subject> getAllSubjects(){
        Subject subject1 = new Subject("SCO", time, getAllTeachers().get(0));
        Subject subject2 = new Subject("SDE", time, getAllTeachers().get(1));
        Subject subject3 = new Subject("DBO", time, getAllTeachers().get(2));

        subjects.add(subject1);
        subjects.add(subject2);
        subjects.add(subject3);

        return subjects;
    }

    public List<Teacher> getAllTeachers(){
        Teacher teacher1 = new Teacher("Jeppe", getAllClassrooms().get(1), "jeppe123", "jeppe1234");
        Teacher teacher2 = new Teacher("Peter", getAllClassrooms().get(2), "peter123", "peter1234");
        Teacher teacher3 = new Teacher("Kim", getAllClassrooms().get(3), "kim123", "kim1234");

        teachers.add(teacher1);
        teachers.add(teacher2);
        teachers.add(teacher3);

        return teachers;
    }
}
