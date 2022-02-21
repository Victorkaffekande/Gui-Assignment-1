package GUI.Controller;

import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class TeacherViewController implements Initializable {
    public BorderPane borderPane;
    public ImageView imageView;
    public Label nameLabel;
    public Label klLabel;
    public TableView tableView;
    public TableColumn TCnavn;
    public TableColumn TCFravær;
    public VBox pieVBox;
    public Label pieLabel;
    public BarChart barChart;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void handleTableViewClicked(MouseEvent mouseEvent) {
    }


}
