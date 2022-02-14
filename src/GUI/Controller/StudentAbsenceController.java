package GUI.Controller;

import BE.Student;
import BE.Lesson;
import GUI.Model.StudentModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Map;
import java.util.Objects;
import java.util.ResourceBundle;

import static javafx.scene.control.TableView.CONSTRAINED_RESIZE_POLICY;

public class StudentAbsenceController implements Initializable {
    public BorderPane borderPane;
    public AnchorPane contentArea;

    StudentModel studentModel;
    Student student;

    public StudentAbsenceController() {
        studentModel = new StudentModel();
        student = studentModel.getAllStudents().get(0); // sætter den valgte Student til at være karsten, den første og eneste
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            loadPage("/GUI/View/TodaysLessonsView.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void handleSeFravær(ActionEvent actionEvent) {
        drawPieChart();
    }

    public void handleDagensLektioner(ActionEvent actionEvent) throws IOException {
        loadPage("/GUI/View/TodaysLessonsView.fxml");
        //tableView.setItems(studentModel.getTodaysLessons(student));
    }
    private void loadPage(String pathView) throws IOException {
        Pane pane = null;
        try{
            pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(pathView)));
        }catch(Exception e){
            System.out.println("fuck");
        }
        borderPane.setCenter(pane);
    }
    public void handleAfslut(ActionEvent actionEvent) {
        System.exit(1);
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
