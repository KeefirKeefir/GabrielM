package com.example.gabrielm;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;



public class B_Button extends Button {

    public B_Button(String i_label, EventHandler<ActionEvent> i_event) {
        super(i_label);

        this.setOnAction(i_event);

        this.getStyleClass().add("menu-button");
    }
    public B_Button(String i_label) {
        this(i_label, null);
    }
    public B_Button(EventHandler<ActionEvent> i_event) {
        this("", i_event);
    }
    public B_Button() {
        this("", null);
    }
}

