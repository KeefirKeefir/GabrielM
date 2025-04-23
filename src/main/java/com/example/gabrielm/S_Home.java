package com.example.gabrielm;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class S_Home extends S_Base {

    private HBox m_hbox;

    private B_Button m_makeHtmlButton;
    private B_Button m_topicBrowserButton;
    private B_Button m_loadHtmlButton;
    private B_Button m_unloadHtmlButton;


    public S_Home() {
        super();
        //this.getStylesheets().add(this.getClass().getResource("/styles.css").toExternalForm());

        makeUI();

        this.getChildren().add(m_hbox);
        m_hbox.setAlignment(Pos.TOP_CENTER);
    }


    private void makeUI() {
        m_makeHtmlButton = new B_Button("make html", e -> {
            HtmlGenerator.generateHtmlFiles();
            Views.TOPIC_BROWSER.loadHtml();
        });
        m_topicBrowserButton = new B_Button("topic browser", e -> {
            Views.change(Views.TOPIC_BROWSER);
        });
        m_loadHtmlButton = new B_Button("load html", e -> {
            Views.TOPIC_BROWSER.loadHtml();
        });
        m_unloadHtmlButton = new B_Button("unload html", e -> {
            Views.TOPIC_BROWSER.unloadHtml();
        });

        m_hbox = new HBox();
        m_hbox.getStyleClass().add("headbar-hbox");
        m_hbox.getChildren().addAll(
                m_makeHtmlButton,
                m_topicBrowserButton,
                m_loadHtmlButton,
                m_unloadHtmlButton
        );
    }


/*
    public static void init() {
        SCENE = new Scene(HBOX);
        SCENE.getStylesheets().add(S_Home.class.getResource("/styles.css").toExternalForm());

        HBOX.getChildren().addAll(
                MAKE_HTML_BUTTON,
                TOPIC_BROWSER_BUTTON,
                REFRESH_HTML_BUTTON,
                CLEAR_TOPICS_BUTTON
        );
        HBOX.getStyleClass().add("headbar-hbox");

        MAKE_HTML_BUTTON.getStyleClass().add("menu-button");
            MAKE_HTML_BUTTON.setOnAction(e -> {
                HtmlGenerator.generateHtmlFiles();
                S_TopicBrowser.loadHtml();
            });
        TOPIC_BROWSER_BUTTON.getStyleClass().add("menu-button");
            TOPIC_BROWSER_BUTTON.setOnAction(e -> {
                Views.change(S_TopicBrowser.SCENE);
            });
        REFRESH_HTML_BUTTON.getStyleClass().add("menu-button");
            REFRESH_HTML_BUTTON.setOnAction(e -> {
                S_TopicBrowser.loadHtml();
            });
        CLEAR_TOPICS_BUTTON.getStyleClass().add("menu-button");
            CLEAR_TOPICS_BUTTON.setOnAction(e -> {
                S_TopicBrowser.unloadHtml();
            });
    }

 */
}
