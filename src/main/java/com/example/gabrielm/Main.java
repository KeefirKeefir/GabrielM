package com.example.gabrielm;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;

import java.net.URL;


public class Main extends Application {
    @Override
    public void start(Stage stage) {
       Paths.init();

       HBox hbox = new HBox(10);
       Button button1 = new Button("Make Html");
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
       webView.setMaxWidth(500);
       webView.setMaxHeight(500);

       VBox mainVBox = new VBox(20);
       mainVBox.getChildren().addAll(hbox, formVBox, webView);
       mainVBox.setAlignment(Pos.TOP_CENTER);
       Scene scene = new Scene(mainVBox, 800, 600);

       VBox vbox2 = new VBox(20);
       Scene scene2 = new Scene(vbox2, 800, 600);
       Button button3 = new Button("Change back");
       button3.setOnAction(e -> stage.setScene(scene));
       vbox2.getChildren().add(button3);
       vbox2.setAlignment(Pos.CENTER);

       Button button4 = new Button("change scene");
       hbox.getChildren().add(button4);
       button4.setOnAction(e -> stage.setScene(scene2));

       button1.setOnAction(actionEvent -> HtmlGenerator.generateHtmlFiles());

       stage.setTitle("Testing");
       stage.setScene(scene);
       stage.show();
    }

    public static void main(String[] args) {
        launch(args); // starts JavaFX app
    }
}
