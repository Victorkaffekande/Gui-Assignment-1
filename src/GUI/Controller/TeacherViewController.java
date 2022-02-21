package GUI.Controller;

import javafx.scene.chart.BarChart;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class TeacherViewController {
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

    public void handleTableViewClicked(MouseEvent mouseEvent) {
    }
}
