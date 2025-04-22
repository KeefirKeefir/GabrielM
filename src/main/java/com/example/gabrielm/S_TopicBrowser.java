package com.example.gabrielm;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

import java.io.File;
import java.util.ArrayList;

public class S_TopicBrowser {
    private S_TopicBrowser() {}

    private static FlowPane TOPIC_PANE;
    static VBox VBOX = new VBox(20);
    public static Scene SCENE = new Scene(VBOX);

    public static ArrayList<TopicCard> CARDS_LIST = new ArrayList<TopicCard>();

    static Button BACK_BUTTON;

    public static void init() {
        TOPIC_PANE = new FlowPane(20, 20);
        TOPIC_PANE.setAlignment(Pos.CENTER);

        BACK_BUTTON = new Button("back");
        BACK_BUTTON.setOnAction(actionEvent -> {
            SceneChanger.change(Main.MAIN_SCENE);
        });

        //xVBox = new VBox(20, xBackButton, xTopicPane);
        VBOX.getChildren().addAll(BACK_BUTTON, TOPIC_PANE);
        VBOX.setAlignment(Pos.TOP_CENTER);

        refresh();
    }

    public static void refresh() {
        File[] v_files = Paths.HTML_FOLDER.listFiles((dir, name) -> name.endsWith(".html"));
        if (v_files == null) return;

        for (File v_file : v_files) {
            boolean v_temp = false;
            String v_fileName = v_file.getName();
            for (TopicCard v_card : CARDS_LIST) {
                if (v_fileName.equals(v_card.m_fileName)) {
                    v_temp = true;
                    break;
                }
            }
            if (v_temp) continue;

            TopicCard v_card = new TopicCard(v_fileName);
            CARDS_LIST.add(v_card);
            TOPIC_PANE.getChildren().add(v_card);

        }
    }

    public static void clear() {
        CARDS_LIST.clear();
        TOPIC_PANE.getChildren().clear();
    }
}
