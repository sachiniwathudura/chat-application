package lk.ijse.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;


import java.awt.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ClientFromController {
    @FXML
    private VBox msgVboxAp;
    @FXML
    private Label lblname;

    @FXML
    private TextField txtClient;
    private String clientName;
    static String message = "";
    static String reply = "";

    BufferedReader bufferedReader;
    DataOutputStream dataOutputStream;
    DataInputStream dataInputStream;
    Socket socket;

    public void initialize() throws IOException {

        lblname.setText(LoginFromController.name);
        clientName=lblname.getText();
        new Thread(()->{
            //code
            try {
                ServerSocket serverSocket = new ServerSocket(3003);

                socket = serverSocket.accept();

                dataOutputStream = new DataOutputStream(socket.getOutputStream());
                dataInputStream = new DataInputStream(socket.getInputStream());
               // bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                while (!message.equals("finish")) {
                    message = dataInputStream.readUTF();
                   // msgVboxAp.appendText ("Client: " + message);
                    Platform.runLater(() -> {
                        msgVboxAp.getChildren().addAll(new Label("Client: " + message));
                    });

                    //System.out.println("Client: " + message);
                }

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
            startServer();
        }).start();
    }

    private void startServer() {

    }

  /*  @FXML
    void btnSendOnAction(ActionEvent event) throws IOException {
        reply = txtClient.getText().trim();
        System.out.println(reply);
        dataOutputStream.writeUTF(reply);
        dataOutputStream.flush();

    }*/

    public void btnSendOnAction(javafx.event.ActionEvent actionEvent) {
        reply = txtClient.getText().trim();
        if (dataOutputStream != null) {
        try {
            dataOutputStream.writeUTF(reply);
            dataOutputStream.flush();
        } catch (IOException e) {
            System.out.println("Error sending message: " + e.getMessage());
        }
            }else{
            System.out.println("Error: dataOutputStream is null.");

            }
    }

    public void txtClientOnAction(ActionEvent actionEvent) {
    }
}


