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

public class LoginTestController implements Initializable {
    public TextField usernameInput;
    public PasswordField passwordInput;

    public void handleLoginButton(ActionEvent actionEvent) throws IOException {
        String sUsername = "k";
        String sPassword = "k";
        //karsten@easv.dk
        if (usernameInput.getText().trim().equals(sUsername) && passwordInput.getText().trim().equals(sPassword)){
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/GUI/View/SAbsenceTest.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("StudentView");
            stage.centerOnScreen();
            stage.show();



            /*
             Stage stageOld = (Stage) usernameInput.getScene().getWindow();
            stageOld.close();
             */


        }
        else {
            error();
        }
        //noget med en Loader
        //TODO RENAME STUDENABCESNCE TO STUDENTVIEW OG LAV EN tEACHER VIEW
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
