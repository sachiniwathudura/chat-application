package lk.ijse;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Client2LoginFromController {
    @FXML
    private TextField txtUserName;

    public static String user_name;

    @FXML
    void btnJoinOnAction(ActionEvent event) throws IOException {

        user_name = txtUserName.getText();
        txtUserName.clear();

        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/Client2ChatFrom.fxml"))));
        stage.setTitle("Chat Room");
        stage.show();
    }
}
