package com.example.gabrielm;

import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

import java.io.File;
import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Collectors;

public class S_TopicBrowser extends S_Base {

    private VBox m_vbox;

    private FlowPane m_topicsPane;
    private B_Button m_backButton;

    public S_TopicBrowser() {
        m_vbox = new VBox();
        m_topicsPane = new FlowPane();

        m_topicsPane.getStyleClass().add("topic-pane");

        m_backButton = new B_Button("back", e -> {
            Views.change(Views.HOME);
        });

        m_vbox.getChildren().addAll(m_backButton, m_topicsPane);
        m_vbox.getStyleClass().add("basic-vbox");

        initCards();

        this.getChildren().add(m_vbox);
    }

    private ArrayList<TopicCard> m_cardsList = new ArrayList<>();
    private File[] m_files;

    private void makeFilesArray() {
        m_files = Paths.HTML_FOLDER.listFiles((dir, name) -> name.endsWith(".html"));
    }

    private void initCards() {
        makeFilesArray();
        if (m_files == null) return;

        for (File v_file : m_files) {
            String v_fileName = v_file.getName();

            TopicCard v_card = new TopicCard(v_fileName);
            m_cardsList.add(v_card);
            m_topicsPane.getChildren().add(v_card);
        }
    }

    public void loadHtml() {
        makeFilesArray();
        if (m_files == null) return;

        Set<String> v_existingNames = m_cardsList.stream()
                .map(topicCard -> topicCard.m_fileName)
                .collect(Collectors.toSet());

        for (File v_file : m_files) {
            String v_fileName = v_file.getName();
            if (v_existingNames.contains(v_fileName)) continue;

            TopicCard v_card = new TopicCard(v_fileName);
            m_cardsList.add(v_card);
            m_topicsPane.getChildren().add(v_card);
        }
    }

    public void unloadHtml() {
        m_cardsList.clear();
        m_topicsPane.getChildren().clear();
    }
}
