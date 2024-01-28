package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;

public class LoginFromController {
    @FXML
     TextField txtJoin;

    public void btnJoinOnAction(ActionEvent actionEvent) {

        Stage stage = new Stage();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/veiw/ClientFromController.fxml"));

        try {
            stage.setScene(new Scene(fxmlLoader.load()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        stage.setResizable(false);
        stage.setTitle(" in your chat");

        stage.centerOnScreen();
        stage.show();
        stage.setOnCloseRequest(Event::consume);
        //clearFields();

    }
  /*  void clearFields() {
        txtJoin.setText("");

    }

   */
}
