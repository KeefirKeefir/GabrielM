package com.example.gabrielm;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import lombok.Getter;

import java.util.Stack;

public class Views {
    private Views() {}

    public static Scene MAIN_SCENE;

    public static S_Home HOME;
    public static S_Topic TOPIC;
    public static S_TopicBrowser TOPIC_BROWSER;
    //public static S_Problem PROBLEM;
    //public static S_ProblemBrowser PROBLEM_BROWSER;

    public static S_Base CURRENT_VIEW;

    static double WINDOW_WIDTH;
    static double WINDOW_HEIGHT;

    private static void setWindowDimensions() {
        WINDOW_WIDTH = Main.STAGE.getWidth();
        WINDOW_HEIGHT = Main.STAGE.getHeight();
    }

    private static boolean isInitDone = false;
    public static void init() {
        assert !isInitDone : "Views.init was called more than once";

        HOME = new S_Home();
        MAIN_SCENE = new Scene(HOME);
        CURRENT_VIEW = HOME;

        TOPIC = new S_Topic();
        TOPIC_BROWSER = new S_TopicBrowser();

        MAIN_SCENE.getStylesheets().add(Views.class.getResource("/styles.css").toExternalForm());

        MAIN_SCENE.setRoot(HOME);

        //Main.STAGE.setScene(MAIN_SCENE);

        isInitDone = true;
    }

    private static Stack<S_Base> PREVIOUS_VIEWS_STACK = new Stack<>();
    public static void goBack() {
        if (PREVIOUS_VIEWS_STACK.isEmpty()) {
            return;
        }
        setWindowDimensions();

        S_Base v_view = PREVIOUS_VIEWS_STACK.pop();

        CURRENT_VIEW.onExit();
        MAIN_SCENE.setRoot(v_view);

        CURRENT_VIEW = v_view;

        Main.STAGE.setWidth(WINDOW_WIDTH);
        Main.STAGE.setHeight(WINDOW_HEIGHT);

        v_view.onEnter();
    }

    public static void change(S_Base i_view) {
        setWindowDimensions();

        CURRENT_VIEW.onExit();
        MAIN_SCENE.setRoot(i_view);

        PREVIOUS_VIEWS_STACK.push(CURRENT_VIEW);
        CURRENT_VIEW = i_view;

        Main.STAGE.setWidth(WINDOW_WIDTH);
        Main.STAGE.setHeight(WINDOW_HEIGHT);

        i_view.onEnter();
    }
}
