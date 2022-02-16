package GUI.Model;

import BE.Classroom;
import BE.Subject;
import BE.Teacher;
import BLL.TeacherManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class TeacherModel {

    public TeacherManager teacherManager;
    public ObservableList<Teacher> teacherList;
    public ObservableList<Classroom> classroomList;
    public ObservableList<Subject> subjectList;

    public TeacherModel() {
        teacherManager = new TeacherManager();
        teacherList = FXCollections.observableArrayList();
        teacherList.addAll(teacherManager.getAllTeachers());
        classroomList = FXCollections.observableArrayList();
        classroomList.addAll(teacherManager.getAllClassrooms());
        subjectList = FXCollections.observableArrayList();
        subjectList.addAll(teacherManager.getAllSubjects());
    }
}
