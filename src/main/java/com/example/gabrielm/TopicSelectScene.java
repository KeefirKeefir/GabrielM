package com.example.gabrielm;

import com.ibm.icu.util.TimeUnitAmount;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class TopicSelectScene {
    private static FlowPane xTopics = new FlowPane();



    private class TopicCard {
        VBox mVBox;
        Image xImage;
        ImageView xImageView;
        Button xButton;
        Text mTitle;

        TopicCard(String fileName) {
            xImage = new Image(Paths.xBaseDir.toURI().toString() + "placeholderCard.png");
            xImageView = new ImageView(xImage);
            xImageView.setFitWidth(162);
            xImageView.setFitHeight(100);
            xImageView.setPreserveRatio(true);

            xButton = new Button();
            xButton.setGraphic(xImageView);

            xButton.setOnAction(actionEvent -> {
                //TODO: add html page
            });

            mTitle = new Text(fileName);

            mVBox = new VBox(20);
            mVBox.getChildren().addAll(xButton, mTitle);

        }
    }




}
