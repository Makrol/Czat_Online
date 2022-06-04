package com.chatclient.client;

import com.google.gson.Gson;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class ChatAppController {

    static APIAccountController apiAccountController = new APIAccountController();
    static {
        apiAccountController.start();
    }

    static APIMessageController apiMessageController = new APIMessageController();
    static {
        apiMessageController.start();
    }

    public static Account user;
    public static Account chattingUser;
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
    private TextField withWhoChatField;

    @FXML
    private Button connectButton;

    @FXML
    private Label connectionInformation;

    @FXML
    void initialize(){
        name.setText(user.getName());
        surname.setText(user.getSurname());
        login.setText(user.getLogin());

            refreshChat();


    }
    @FXML
    void delete(ActionEvent event) throws IOException{
        apiAccountController.deleteAccount(user.getId());
        logout(new ActionEvent());
    }
    @FXML
    void doLoginTransfer(ActionEvent event)throws IOException {
        apiAccountController.updateLogin(user.getId(),newLoginField.getText());
        newLoginField.setText("");
    }

    @FXML
    void doNameTransfer(ActionEvent event) throws IOException {
        apiAccountController.updateName(user.getId(),newNameField.getText());
        newNameField.setText("");
    }

    @FXML
    void doPasswordTransfer(ActionEvent event) throws IOException {
        apiAccountController.updatePassword(user.getId(),newPasswordField.getText());
        newPasswordField.setText("");
    }

    @FXML
    void doSurnameTransfer(ActionEvent event) throws IOException {
        apiAccountController.updateSurname(user.getId(),newSurnameField.getText());
        newSurnameField.setText("");
    }

    @FXML
    void logout(ActionEvent event) throws IOException {
        ChatClient.changeScreen("loginWindow.fxml",600,277);
        user = null;
        chattingUser=null;
    }

    @FXML
    void sendCreditQuery(ActionEvent event)throws IOException {
        if(chattingUser!=null){
            apiMessageController.sendMessage(messageFieldToSend.getText(),user.getId(),chattingUser.getId());
        }

        messageFieldToSend.setText("");
    }

    @FXML
    void connect(ActionEvent event) throws IOException{

        chattingUser= apiAccountController.connect(withWhoChatField.getText());
        if(chattingUser!=null){
            connectionInformation.setText("Polaczono");
            loadChat();
        }else{
            connectionInformation.setText("Nie polaczono");
            chattingUser=null;
        }

        withWhoChatField.setText("");
    }
    private void loadChat() throws IOException{
        List<Message> tmpMessages = apiMessageController.getMessages(user.getId(), chattingUser.getId());

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Poczatek czatowania"+"\n");
        if(tmpMessages == null) return;
        for (Message m:tmpMessages) {
            if(m.getSrcId()== user.id)
                stringBuilder.append("Ja: "+m.getText()+"\n");
            else
                stringBuilder.append("On/Ona: "+m.getText()+"\n");

        }
        chat.setText(stringBuilder.toString());

    }
    void refreshChat(){

        Thread t1 = new Thread(){
           @Override
            public void run(){
               Integer num = 100000;
               while(true){
                   try {
                       sleep(500);
                       num-=500;
                       if(num==0)
                           start();
                       if(chattingUser!=null)
                       loadChat();
                   }
                   catch (InterruptedException exception){
                       System.exit(1);
                   }
                   catch (IOException exception){
                       System.exit(1);
                   }
                   catch (NullPointerException exception){

                   }

               }

            }
        };
        t1.start();

    }
    @FXML
    void save(ActionEvent event) throws IOException {
        if(chattingUser==null) return;
        FileOutputStream fos = new FileOutputStream(user.getId()+"_"+chattingUser.getId()+" konwersacja.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject( new Gson().toJson(apiMessageController.getMessages(user.getId(), chattingUser.getId())));
        oos.close();
    }

}
