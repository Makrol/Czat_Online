package com.chatclient.client;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class LogInController{
    static APIAccountController apiAccountController = new APIAccountController();
    static {
        apiAccountController.start();
    }

    @FXML
    private Button cancelButton;

    @FXML
    private TextField login;

    @FXML
    private Button loginButton;

    @FXML
    private TextField loginRegister;

    @FXML
    private TextField name;

    @FXML
    private PasswordField passwordLogin;

    @FXML
    private PasswordField passwordRegister;

    @FXML
    private Button registerButton;

    @FXML
    private TextField surname;

    @FXML
    private Label wrongLogin;

    @FXML
    void cancelLogin(ActionEvent event) {

    }

    @FXML
    void userLogin(ActionEvent event) throws IOException {

        ChatAppController.user = apiAccountController.login(login.getText(),passwordLogin.getText());
        if(ChatAppController.user!=null){
            ChatClient.changeScreen("chatApp.fxml", 924.0f,576.0f);
        }


    }
    @FXML
    void userRegister(ActionEvent event) throws IOException{
       apiAccountController.register(name.getText(),surname.getText(),loginRegister.getText(),passwordRegister.getText());
    }

}