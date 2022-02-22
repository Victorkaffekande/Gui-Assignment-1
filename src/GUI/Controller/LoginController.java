package GUI.Controller;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    public TextField usernameInput;
    public PasswordField passwordInput;

    public void handleLoginButton(ActionEvent actionEvent) throws IOException {
        String sUsername = "flemming@easv.dk";
        String sPassword = "flemming";
        String tUsername = "kirstine@easv.dk";
        String tPassword = "kirstine";
        //karsten@easv.dk
        if (usernameInput.getText().trim().equals(sUsername) && passwordInput.getText().trim().equals(sPassword)){
            openNewScene("/GUI/View/StudentView.fxml","Elev",actionEvent);
        }
        else if (usernameInput.getText().trim().equals(tUsername) && passwordInput.getText().trim().equals(tPassword)){
            openNewScene("/GUI/View/TeacherView.fxml","Lære",actionEvent);
        }
        else {
            error();
        }
    }

    private void openNewScene(String fxmlPath,String Title ,ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlPath));
        Parent root = fxmlLoader.load();
        Stage stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle(Title);
        stage.centerOnScreen();
        stage.setResizable(false);
        stage.show();
    }

    private void error(){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setContentText("WRONG USERNAME OR PASSWORD");
        alert.showAndWait();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
