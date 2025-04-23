package com.example.gabrielm;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

// naming conventions
// FULL_CAPS for all static fields
// m_camelCase for all non-static member values (private and public)
// v_camelCase for local values
// i_camelCase for parameters/inputs
// S_PascalCase for scene holder classes

public class Main extends Application {

    public static Stage STAGE;

    @Override
    public void start(Stage i_stage) {
       STAGE = i_stage;

       Paths.init();

       STAGE.setTitle("Testing");
       Views.init();
       STAGE.setScene(Views.MAIN_SCENE);
       STAGE.setWidth(800);
       STAGE.setHeight(500);
       STAGE.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
