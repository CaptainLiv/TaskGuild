package com.example.taskguild;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.File;

public class Controller_create_profile_view {

    @FXML
    private ImageView view_legs;

    @FXML
    private ImageView view_tops;

    @FXML
    private ImageView view_heads;

    @FXML
    private TextField txt_avatar_name;

    @FXML
    private Button head_bald_model;

    @FXML
    private Button head_beanie_model;

    @FXML
    private Button head_french_model;

    @FXML
    private Button head_halo_model;

    @FXML
    private Button head_pigtails_model;

    @FXML
    private Button head_sunglasses_model;

    @FXML
    private Button head_top_model;

    @FXML
    private Button head_clear;

    @FXML
    private Button legs_carmo_model;

    @FXML
    private Button legs_galaxy_model;

    @FXML
    private Button legs_jeans_model;

    @FXML
    private Button legs_joggers_model;

    @FXML
    private Button legs_jorts_model;

    @FXML
    private Button legs_socks_model;

    @FXML
    private Button legs_tutu_model;

    @FXML
    private Button leg_clear;

    @FXML
    private Button top_crop_model;

    @FXML
    private Button top_hemd_model;

    @FXML
    private Button top_hoodie_model;

    @FXML
    private Button top_jacket_model;

    @FXML
    private Button top_naked_model;

    @FXML
    private Button top_tats_model;

    @FXML
    private Button top_vest_model;

    @FXML
    private Button lop_clear;


    @FXML
    void avatar_confirm(MouseEvent event) {

    }

    @FXML
    void change_head(MouseEvent event) {
        String source_head = event.getPickResult().getIntersectedNode().getId();
        File file = new File("src/main/resources/com/example/taskguild/assets/heads/"+source_head+".png");
        Image image = new Image(file.toURI().toString());
        view_heads.setImage(image);
    }

    @FXML
    void change_top(MouseEvent event) {
        String source_top = event.getPickResult().getIntersectedNode().getId();
        File file = new File("src/main/resources/com/example/taskguild/assets/tops/"+source_top+".png");
        Image image = new Image(file.toURI().toString());
        view_tops.setImage(image);
    }

    @FXML
    void change_leg(MouseEvent event) {
        String source_leg = event.getPickResult().getIntersectedNode().getId();
        File file = new File("src/main/resources/com/example/taskguild/assets/legs/"+source_leg+".png");
        Image image = new Image(file.toURI().toString());
        view_legs.setImage(image);
    }

}