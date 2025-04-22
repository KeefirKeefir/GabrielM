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

// naming conventions
// FULL_CAPS for all static fields
// m_camelCase for all non-static member values (private and public)
// v_camelCase for local values
// i_camelCase for parameters/inputs
// S_PascalCase for scene holder classes

public class Main extends Application {

   public static Stage STAGE;
   public static Scene MAIN_SCENE;

    @Override
    public void start(Stage i_stage) {
       STAGE = i_stage;

       Paths.init();
       S_TopicBrowser.SCENE.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());

       HBox v_hbox = new HBox(10);
       Button v_makeHtmlButton = new Button("Make Html");
       Button v_openBrowseSceneButton = new Button("Button 2");
       v_hbox.getChildren().addAll(v_makeHtmlButton, v_openBrowseSceneButton);
       v_hbox.setAlignment(Pos.CENTER);

       VBox v_formVBox = new VBox(10);
       Label v_nameLabel = new Label("Name:");
       TextField v_nameField = new TextField();

       v_formVBox.getChildren().addAll(v_nameLabel, v_nameField);
       v_formVBox.setAlignment(Pos.CENTER);
       v_nameField.setMaxWidth(200);

       WebView v_webView = new WebView();
       URL v_url = getClass().getResource("/topics/example.html");
       //File file = new File("../../topics/example.html");
       v_webView.getEngine().load(v_url.toString());
       v_webView.setMaxWidth(500);
       v_webView.setMaxHeight(500);

       VBox v_mainVBox = new VBox(20);
       v_mainVBox.getChildren().addAll(v_hbox, v_formVBox, v_webView);
       v_mainVBox.setAlignment(Pos.TOP_CENTER);
       MAIN_SCENE = new Scene(v_mainVBox, 800, 600);

       VBox v_vbox2 = new VBox(20);
       Scene v_scene2 = new Scene(v_vbox2, 800, 600);
       Button v_button3 = new Button("Change back");
       v_button3.setOnAction(e -> SceneChanger.change(MAIN_SCENE));
       v_vbox2.getChildren().add(v_button3);
       v_vbox2.setAlignment(Pos.CENTER);

       Button v_button4 = new Button("change scene");
       v_hbox.getChildren().add(v_button4);
       v_button4.setOnAction(e -> {
          SceneChanger.change(v_scene2);
          S_TopicBrowser.clear();
       });

       v_makeHtmlButton.setOnAction(actionEvent -> {
          HtmlGenerator.generateHtmlFiles();
          S_TopicBrowser.refresh();
       });

       v_openBrowseSceneButton.setOnAction(actionEvent -> {
          SceneChanger.change(S_TopicBrowser.SCENE);
       });

       S_TopicBrowser.init();
       S_Topic.init();

       i_stage.setTitle("Testing");
       SceneChanger.change(MAIN_SCENE);
       i_stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
