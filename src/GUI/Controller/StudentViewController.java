package GUI.Controller;

import BE.Lesson;
import BE.Student;
import DAL.TimeHelper;
import GUI.Model.StudentModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Objects;
import java.util.ResourceBundle;

public class StudentViewController implements Initializable {
    public TableView<Lesson> tableView;
    public TableColumn<Lesson, String> TCLessons;
    public TableColumn<Lesson, String> TCkl;
    public TableColumn<Lesson, String> TCStatus;
    private final StudentModel studentModel;
    private final Student student;
    public BorderPane borderPane;
    public VBox pieVBox;
    public Label pieLabel;
    public PieChart pieChart;
    public ImageView imageView;
    public Label nameLabel;
    public Label klLabel;
    private TimeHelper timeHelper;

    public StudentViewController() {
        studentModel = new StudentModel();
        student = studentModel.getAllStudents().get(0);
        timeHelper = new TimeHelper();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        TCLessons.setCellValueFactory(new PropertyValueFactory<>("subjectName"));
        TCkl.setCellValueFactory(new PropertyValueFactory<>("time"));
        TCStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
        tableView.setItems(studentModel.getTodaysLessons(student));
        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        setTopPaneInfo();
        drawPieChart();
    }

    private void drawPieChart() {
        Map<String, Integer> map = studentModel.getStudentAttendance(student);
        int attendedCount = map.get("ATTENDED");
        int scoCount = map.get("SCO");
        int itoCount = map.get("ITO");
        int sdeCount = map.get("SDE");
        int dboCount = map.get("DBO");
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

        if (dboCount > 0) {
            pieData.add(new PieChart.Data("DBO", dboCount));
        }

        if (attendedCount > 0) {
            pieData.add(new PieChart.Data("Til stede", attendedCount));
        }
        pieChart.setData(pieData);
        pieChart.setLegendVisible(false);


        double missing = 0;
        double total = 0;
        for (PieChart.Data data : pieData) {
            if (!Objects.equals(data.getName(), "Til stede")) {
                missing += data.getPieValue();
            }
            total += data.getPieValue();
        }
        String percent = String.format("%.1f%%", 100 * missing / total);
        pieLabel.setText("Dit fravær er " + percent);
    }

    private void setTopPaneInfo() {
        nameLabel.setText(student.getName());
        imageView.setImage(new Image(student.getUserImagePath()));
        klLabel.setText("Kl: " + timeHelper.getTodayTime());

    }

    public void handleTilStedeBTN(ActionEvent actionEvent) {
        ObservableList<Lesson> pickedLessons = tableView.getSelectionModel().getSelectedItems();
        for (Lesson l : pickedLessons) {
            l.setAttended(true);
            l.setStatus("Til stede");
        }
        drawPieChart();
    }

    public void handleIkkeTilstedeBTN(ActionEvent actionEvent) {
        ObservableList<Lesson> pickedLessons = tableView.getSelectionModel().getSelectedItems();
        for (Lesson l : pickedLessons) {
            l.setAttended(false);
            l.setStatus("Fraværende");
        }
        drawPieChart();
    }
}
