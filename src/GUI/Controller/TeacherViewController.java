package GUI.Controller;

import BE.Student;
import BE.Teacher;
import DAL.TimeHelper;
import GUI.Model.StudentModel;
import GUI.Model.TeacherModel;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
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
    public TableColumn<Student,String> TCnavn;
    public TableColumn<String, Integer> TCFravær;
    public VBox pieVBox;
    public Label pieLabel;
    public BarChart barChart; //fix
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
    }

    public void handleTableViewClicked(MouseEvent mouseEvent) {
    }

    private void setTopPaneInfo() {
        nameLabel.setText(teacher.getName());
        imageView.setImage(new Image(teacher.getUserImagePath())); //fix
        klLabel.setText("Kl: " + timeHelper.getTodayTime());
    }

    private void populateTableView(){
        tableView.getItems().setAll(studentModel.getAllObservableStudents());
    }

}
