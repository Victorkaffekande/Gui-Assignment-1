package GUI.Controller;

import BE.Student;
import BE.Subject;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;


import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class StudentAbsenceController implements Initializable {

    Student student;
    public BorderPane borderpane;
    public PieChart pieChart;
    public Label lblName;

    public StudentAbsenceController() {
        List<Subject> SCO2020 = null;
        student = new Student("Sigurd", "tunsad",SCO2020 ,"soren123", "soren1234");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    drawPieChart();
    lblName.setText("Velkommen" + " " + student.getName());
    }

    private void drawPieChart(){
        ObservableList<PieChart.Data> pieData = FXCollections.observableArrayList(
                new PieChart.Data("SCO", 4),
                new PieChart.Data("ITO",6),
                new PieChart.Data("SDE",1),
                new PieChart.Data("Tilstede",33)
        );
        pieChart.setLegendVisible(false);
        pieChart.setData(pieData);
    }
}
