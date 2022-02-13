package GUI.Controller;

import BE.Student;
import BE.Lesson;
import GUI.Model.StudentModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.Map;
import java.util.Objects;
import java.util.ResourceBundle;

import static javafx.scene.control.TableView.CONSTRAINED_RESIZE_POLICY;

public class StudentAbsenceController implements Initializable {
    public BorderPane borderPane;

    StudentModel studentModel;
    Student student;

    public StudentAbsenceController() {
        studentModel = new StudentModel();
        student = studentModel.getAllStudents().get(0); // sætter den valgte Student til at være karsten, den første og eneste
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        drawDagensLektioner();
    }



    public void handleSeFravær(ActionEvent actionEvent) {
        drawPieChart();

    }

    public void handleDagensLektioner(ActionEvent actionEvent) {
        drawDagensLektioner();
    }
    public void handleAfslut(ActionEvent actionEvent) {
        System.exit(1);
    }
    private void drawDagensLektioner(){
        borderPane.setCenter(null);
        TableView<Lesson> mondayTV = new TableView<>();
        mondayTV.setItems(studentModel.getRecentLessons(student));
        TableColumn<Lesson,String> mondayTC = new TableColumn<>("Monday");

        TableView<Lesson> tuesdayTV = new TableView<>();
        TableColumn<Lesson,String> tuesdayTC = new TableColumn<>("Tuesday");

        TableView<Lesson> wednesdayTV = new TableView<>();
        TableColumn<Lesson,String> wednesdayTC = new TableColumn<>("Wednesday");
        TableView<Lesson> thursdayTV = new TableView<>();
        TableColumn<Lesson,String> thursdayTC = new TableColumn<>("Thursday");
        TableView<Lesson> fridayTV = new TableView<>();
        TableColumn<Lesson,String> fridayTC = new TableColumn<>("Friday");

        mondayTC.setCellValueFactory(new PropertyValueFactory<>("subjectName"));
        tuesdayTC.setCellValueFactory(new PropertyValueFactory<>("subjectName"));
        wednesdayTC.setCellValueFactory(new PropertyValueFactory<>("subjectName"));
        thursdayTC.setCellValueFactory(new PropertyValueFactory<>("subjectName"));
        fridayTC.setCellValueFactory(new PropertyValueFactory<>("subjectName"));
        mondayTV.getColumns().add(mondayTC);
        tuesdayTV.getColumns().add(tuesdayTC);
        wednesdayTV.getColumns().add(wednesdayTC);
        thursdayTV.getColumns().add(thursdayTC);
        fridayTV.getColumns().add(fridayTC);

        mondayTV.setColumnResizePolicy(CONSTRAINED_RESIZE_POLICY);
        tuesdayTV.setColumnResizePolicy(CONSTRAINED_RESIZE_POLICY);
        wednesdayTV.setColumnResizePolicy(CONSTRAINED_RESIZE_POLICY);
        thursdayTV.setColumnResizePolicy(CONSTRAINED_RESIZE_POLICY);
        fridayTV.setColumnResizePolicy(CONSTRAINED_RESIZE_POLICY);


        ///TODO BUTTONS


        HBox hbox = new HBox();
        hbox.getChildren().add(mondayTV);
        hbox.getChildren().add(tuesdayTV);
        hbox.getChildren().add(wednesdayTV);
        hbox.getChildren().add(thursdayTV);
        hbox.getChildren().add(fridayTV);


        borderPane.setCenter(hbox);
    }
    private void drawPieChart() {
        PieChart pieChart = new PieChart();
        Map<String, Integer> map = studentModel.getStudentAttendance(student);
        int attendedCount = map.get("ATTENDED");
        int scoCount = map.get("SCO");
        int itoCount = map.get("ITO");
        int sdeCount = map.get("SDE");
        ObservableList<PieChart.Data> pieData = FXCollections.observableArrayList();

        if (scoCount > 0) {
            pieData.add(new PieChart.Data("SCO", scoCount));
        }
        if (itoCount > 0) {
            pieData.add(new PieChart.Data("ITO", itoCount));
        }

        if (sdeCount > 0) {
            pieData.add(new PieChart.Data("SDE", sdeCount));
        }

        if (attendedCount > 0) {
            pieData.add(new PieChart.Data("Til stede", attendedCount));
        }

        pieChart.setLegendVisible(false);
        pieChart.setData(pieData);
        javafx.scene.control.Label label = new Label();
        double missing = 0;
        double total = 0;
        for (PieChart.Data data : pieData) {
            if (!Objects.equals(data.getName(), "Til stede")) {
                missing += data.getPieValue();
            }
            total += data.getPieValue();
        }
        String percent = String.format("%.1f%%", 100 * missing / total);
        label.setText(String.valueOf("Dit fravær er " + percent));

        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().add(label);
        vbox.getChildren().add(pieChart);
        borderPane.setCenter(vbox);
    }
}
