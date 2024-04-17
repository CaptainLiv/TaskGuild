package com.example.taskguild;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.File;

public class Start_Controller {

    @FXML
    private Button btn_next;

    @FXML
    private Button btn_av1;

    @FXML
    private Button btn_av2;

    @FXML
    private Button btn_av3;

    @FXML
    private Button btn_av4;

    @FXML
    private Button btn_av5;

    @FXML
    private Button btn_av6;

    @FXML
    private Button btn_av7;


    @FXML
    private ImageView view_avatar;

    @FXML
    void avatar_confirm(MouseEvent event) {
       System.out.println(1);
    }

    @FXML
    void avatar_select(MouseEvent event) {
        //File file = new File("src/pictures/a1.jpg");
        //Image image = new Image(file.toURI().toString());
        //view_avatar.setImage(image);
    }
}