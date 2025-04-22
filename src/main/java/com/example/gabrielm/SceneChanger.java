package com.example.gabrielm;

import javafx.scene.Scene;

public class SceneChanger {
    private SceneChanger() {}

    static double WINDOW_WIDTH;
    static double WINDOW_HEIGHT;

    private static void setWindowDimensions() {
        WINDOW_WIDTH = Main.STAGE.getWidth();
        WINDOW_HEIGHT = Main.STAGE.getHeight();
    }

    public static void change(Scene scene) {
        setWindowDimensions();
        Main.STAGE.setScene(scene);
            Main.STAGE.setWidth(WINDOW_WIDTH);
            Main.STAGE.setHeight(WINDOW_HEIGHT);
    }
}
