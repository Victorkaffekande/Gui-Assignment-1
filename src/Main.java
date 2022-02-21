import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class Main extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
<<<<<<< HEAD
        Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("GUI/View/Login.fxml")));
        Scene scene = new Scene(parent);
        primaryStage.setTitle("Login");
=======
        Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/GUI/View/LoginScreen.fxml")));
        Scene scene = new Scene(parent);
        primaryStage.setTitle("Login screen");
>>>>>>> main
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
