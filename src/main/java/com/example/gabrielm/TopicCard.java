package com.example.gabrielm;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class TopicCard extends VBox {
    Image m_image;
    ImageView m_imageView;
    Button m_button;
    Text m_title;
    String m_fileName;

    public TopicCard(String i_fileName) {
        super(20);

        m_image = new Image(Paths.ROOT_DIR.toURI().toString() + "placeholderCard.png");
        m_imageView = new ImageView(m_image);
            m_imageView.setFitWidth(162);
            m_imageView.setFitHeight(100);
            m_imageView.setPreserveRatio(true);

        m_fileName = i_fileName;
        String v_fileNameNoExtension = i_fileName.substring(0, i_fileName.lastIndexOf('.'));
        m_title = new Text(v_fileNameNoExtension);

        m_button = new Button();
            m_button.getStyleClass().add("topic-button");
            m_button.setGraphic(m_imageView);
            m_button.setOnAction(actionEvent -> {
                S_Topic.loadHtmlContent(m_fileName);
                SceneChanger.change(S_Topic.SCENE);
            });

        this.getChildren().addAll(m_button, m_title);
        this.setAlignment(Pos.CENTER);
    }
}
