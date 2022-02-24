package GUI.Controller;

import BE.Student;
import BE.Teacher;
import DAL.TimeHelper;
import GUI.Model.StudentModel;
import GUI.Model.TeacherModel;
import javafx.fxml.Initializable;
import javafx.scene.chart.*;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;


import java.net.URL;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

public class TeacherViewController implements Initializable {
    public BorderPane borderPane;
    public ImageView imageView;
    public Label nameLabel;
    public Label klLabel;
    public TableView<Student> tableView;
    public TableColumn<Student, String> TCnavn;
    public TableColumn<String, Number> TCFravær;
    public VBox barCharVbox;
    public Label classAttendanceLabel;
    TimeHelper timeHelper = new TimeHelper();
    LocalDateTime today = timeHelper.getToday();
    StudentModel studentModel = new StudentModel();
    TeacherModel teacherModel = new TeacherModel();
    Teacher teacher = teacherModel.getAllTeachers().get(2);

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        TCnavn.setCellValueFactory(new PropertyValueFactory<>("name"));
        TCFravær.setCellValueFactory(new PropertyValueFactory<>("absenceSum"));
        setTopPaneInfo();
        populateTableView();
        setClassAttendanceLabel();
    }

    public void handleTableViewClicked(MouseEvent mouseEvent) {
        Student student = tableView.getSelectionModel().getSelectedItem();
        if (student != null) {
            assembleBarChartVbox(student);
        }

    }

    private BarChart makeBarchart(Student student) {
        XYChart.Series barData = new XYChart.Series();

        barData.getData().add(new XYChart.Data<>("Mandag", student.getAbsenceList().get(0)));
        barData.getData().add(new XYChart.Data<>("Tirsdag", student.getAbsenceList().get(1)));
        barData.getData().add(new XYChart.Data<>("Onsdag", student.getAbsenceList().get(2)));
        barData.getData().add(new XYChart.Data<>("Torsdag", student.getAbsenceList().get(3)));
        barData.getData().add(new XYChart.Data<>("Fredag", student.getAbsenceList().get(4)));

        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Fraværs %");
        yAxis.setUpperBound(student.getAbsenceSum());
        yAxis.setAutoRanging(false);
        yAxis.setTickUnit(1);

        CategoryAxis xAxis = new CategoryAxis();

        BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);
        barChart.setLegendVisible(false);
        barChart.setAnimated(false);
        barChart.getData().add(barData);
        return barChart;
    }

    private void assembleBarChartVbox(Student student) {
        barCharVbox.getChildren().clear();
        barCharVbox.getChildren().add(createStudentAbsenceLabel(student));
        barCharVbox.getChildren().add(makeBarchart(student));
    }

    private void setTopPaneInfo() {
        nameLabel.setText(teacher.getName());
        imageView.setImage(new Image(teacher.getUserImagePath())); //fix
        klLabel.setText("Kl: " + timeHelper.getTodayTime());
    }

    private Label createStudentAbsenceLabel(Student student) {
        String s = student.getName() + " har " + student.getAbsenceSum() + "% " + "fravær";
        return new Label(s);
    }

    private void populateTableView() {
        tableView.getItems().setAll(studentModel.getAllObservableStudents());
    }

    private void setClassAttendanceLabel() {
        double p = 0;
        for (Student s : tableView.getItems()) {
            p += s.getAbsenceSum();
        }

        classAttendanceLabel.setText("CSe A.21 | " + Double.toString(p).substring(0, 4) + "%");
    }

}
