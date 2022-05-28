package com.chatclient.client;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class ChatAppController {
    public static Account user;

    @FXML
    private Button changeLoginButton;

    @FXML
    private Button changeNameButton;

    @FXML
    private Button changePasswordButton;

    @FXML
    private Button changeSurnameButton;

    @FXML
    private Text chat;

    @FXML
    private Text errorField;

    @FXML
    private Text login;

    @FXML
    private Button logoutButton;

    @FXML
    private TextField messageFieldToSend;

    @FXML
    private Text name;

    @FXML
    private TextField newLoginField;

    @FXML
    private TextField newNameField;

    @FXML
    private TextField newPasswordField;

    @FXML
    private TextField newSurnameField;

    @FXML
    private Button sendButton;

    @FXML
    private Text surname;

    @FXML
    void doTransfer(ActionEvent event) {

    }

    @FXML
    void logout(ActionEvent event) {

    }

    @FXML
    void sendCreditQuery(ActionEvent event) {

    }

}
