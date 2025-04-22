package com.example.gabrielm;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;

import java.io.File;

public class S_Topic {
    private S_Topic() {}

    public static Scene SCENE;
    static WebView WEBVIEW;
    static VBox VBOX;
    static Button BACK_BUTTON;

    public static void init() {
        WEBVIEW = new WebView();
        File v_htmlFile = new File(Paths.ROOT_DIR, "example.html");
        WEBVIEW.getEngine().load(v_htmlFile.toURI().toString());
        WEBVIEW.setMaxWidth(500);
        WEBVIEW.setMaxHeight(500);

        BACK_BUTTON = new Button("back");
        BACK_BUTTON.setOnAction(actionEvent -> {
            SceneChanger.change(S_TopicBrowser.SCENE);
        });

        VBOX = new VBox(20);
        VBOX.getChildren().addAll(BACK_BUTTON, WEBVIEW);
        VBOX.setAlignment(Pos.TOP_CENTER);

        SCENE = new Scene(VBOX);
    }

    public static void loadHtmlContent(String i_htmlFileName) {
        File v_htmlFile = new File(Paths.HTML_FOLDER, i_htmlFileName);
        WEBVIEW.getEngine().load(v_htmlFile.toURI().toString());
    }
}
