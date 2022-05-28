module com.chatclient.client {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.google.gson;

    requires retrofit2.converter.gson;
    requires retrofit2;


    opens com.chatclient.client to javafx.fxml;
    exports com.chatclient.client;
}