package com.chatclient.client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ChatClient extends Application {
    static Stage mainStage;
    @Override
    public void start(Stage stage) throws IOException {
        mainStage=stage;
        FXMLLoader fxmlLoader = new FXMLLoader(ChatClient.class.getResource("loginWindow.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();



    }

    public static void main(String[] args) throws IOException{
        launch(args);

    }

    public static void changeScreen(String name, float width, float height) throws  IOException{
        mainStage.setScene(new Scene(new FXMLLoader(ChatClient.class.getResource(name)).load(),width,height));
    }
}