package com.example.gabrielm;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;

import java.io.File;
import java.net.URL;


public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) {
       HBox hbox = new HBox(10);
       Button button1 = new Button("Button 1");
       Button button2 = new Button("Button 1");
       hbox.getChildren().addAll(button1, button2);
       hbox.setAlignment(Pos.CENTER);

       VBox formVBox = new VBox(10);
       Label nameLabel = new Label("Name:");
       TextField nameField = new TextField();

       formVBox.getChildren().addAll(nameLabel, nameField);
       formVBox.setAlignment(Pos.CENTER);
       nameField.setMaxWidth(200);

       WebView webView = new WebView();
       URL url = getClass().getResource("/topics/example.html");
       //File file = new File("../../topics/example.html");
       webView.getEngine().load(url.toString());
       webView.setPrefWidth(50);

       VBox mainVBox = new VBox(20);
       mainVBox.getChildren().addAll(hbox, formVBox, webView);
       mainVBox.setAlignment(Pos.TOP_CENTER);

       Scene scene = new Scene(mainVBox, 800, 600);
       stage.setTitle("Testing");
       stage.setScene(scene);
       stage.show();
    }

    public static void main(String[] args) {
        launch(); // starts JavaFX app
    }
}
