package lk.ijse;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ServerHandling  extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/view/server_form.fxml"));
        primaryStage.setTitle("Server");
        primaryStage.setScene(new Scene(root, 608, 497));
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);

    }
}
