package com.example.gabrielm;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;

import java.io.File;
import java.nio.file.Path;

public class S_Topic extends S_Base {

    private VBox m_vbox;

    private WebView m_webview;
    private B_Button m_backButton;

    public S_Topic() {
        m_webview = new WebView();

        File v_htmlFile = new File(Paths.ROOT_DIR, "example.html");
        m_webview.getEngine().load(v_htmlFile.toURI().toString());
        m_webview.setPrefHeight(500);
        m_webview.setPrefWidth(500);

        m_backButton = new B_Button("back", e -> {
            Views.goBack();
        });

        m_vbox = new VBox();
        m_vbox.getStyleClass().add("basic-vbox");
        m_vbox.getChildren().addAll(m_backButton, m_webview);

        this.getChildren().add(m_vbox);
    }

    public void loadHtmlContent(String i_htmlFileName) {
        File v_htmlFile = new File(Paths.HTML_FOLDER, i_htmlFileName);
        m_webview.getEngine().load(v_htmlFile.toURI().toString());
    }

    /*
    public static void init() {
        SCENE = new Scene(VBOX);
        SCENE.getStylesheets().add(S_Topic.class.getResource("/styles.css").toExternalForm());

        File v_htmlFile = new File(Paths.ROOT_DIR, "example.html");
        WEBVIEW.getEngine().load(v_htmlFile.toURI().toString());
            WEBVIEW.setMaxWidth(500);
            WEBVIEW.setMaxHeight(500);

        BACK_BUTTON.setOnAction(actionEvent -> {
            Views.change(S_TopicBrowser.SCENE);
        });

        VBOX.getChildren().addAll(BACK_BUTTON, WEBVIEW);
            VBOX.setSpacing(20);
            VBOX.setAlignment(Pos.TOP_CENTER);
    }
    */

}
