package com.example.taskguild;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Start_Controller {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}