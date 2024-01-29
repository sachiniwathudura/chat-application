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
import javafx.scene.control.TextField;

public class LoginFromController {

    static  String name="";

    @FXML
    private TextField txtJoin;

    public void btnJoinOnAction(ActionEvent actionEvent) {
       String name= txtJoin.getText();
        String[] words=name.split("");
        LoginFromController.name=words[0];

        if(txtJoin.getText().equals("stop")){
            System.exit(0);
            return;
        }
        if(txtJoin.getText().equals("")|| txtJoin.getText().equals("please enter your name")){
            txtJoin.setText("enter your name");
            txtJoin.selectAll();
            return;
        }
        Stage stage = new Stage();

        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("/veiw/ClientFromController.fxml"));

        try {
            stage.setScene(new Scene(fxmlLoader.load()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        stage.setResizable(false);
        stage.setTitle(LoginFromController.name +" in your chat");

        stage.centerOnScreen();
        stage.show();
        stage.setOnCloseRequest(Event::consume);
        txtJoin.clear();

    }

    public void txtJoinOnAction(ActionEvent actionEvent) {
    }
}
