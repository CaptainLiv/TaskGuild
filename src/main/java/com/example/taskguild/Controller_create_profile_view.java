package com.example.taskguild;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class Controller_create_profile_view implements Initializable{
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
    private Button top_clear;

    @FXML
    private Button confirm;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (Start_Application.does_profile_exists) {
            Avatar avatar = Avatar.load();
            view_heads.setImage(new Image(avatar.head));
            view_legs.setImage(new Image(avatar.bottom));
            view_tops.setImage(new Image(avatar.tops));
            txt_avatar_name.setText(avatar.name);
        }
        if (txt_avatar_name.getText().length() > 3) {
            confirm.setDisable(false);
        }
    }
    @FXML
    void avatar_confirm(MouseEvent event) throws IOException {
        if (txt_avatar_name.getText().length() <= 3){
            confirm.setDisable(true);
        }
        Avatar avatar = new Avatar(txt_avatar_name.getText(), view_heads.getImage().getUrl(), view_legs.getImage().getUrl(), view_tops.getImage().getUrl());
        Avatar.save(avatar);
        Stage stage = (Stage) txt_avatar_name.getScene().getWindow();
        Start_Application.change_window("mainframe_v3.fxml", stage);
        Start_Application.mp.dispose();
        Start_Application.play_music("Hintergrundmusik(ToDo_Liste)");
        Start_Application.does_profile_exists = true;
}

    @FXML
    void button_activate() {
        if (txt_avatar_name.getText().length() > 3) {
            confirm.setDisable(false);
        }
        else {
            confirm.setDisable(true);
        }
        
    }
    
    @FXML
    void change_head(MouseEvent event) {
        String source_head = event.getPickResult().getIntersectedNode().getId();
        File file = new File("src/main/resources/com/example/taskguild/assets/heads/"+source_head+".png");
        Image image = new Image(file.toURI().toString());
        view_heads.setImage(image);
        change_sound();
    }

    @FXML
    void change_top(MouseEvent event) {
        String source_top = event.getPickResult().getIntersectedNode().getId();
        File file = new File("src/main/resources/com/example/taskguild/assets/tops/"+source_top+".png");
        Image image = new Image(file.toURI().toString());
        view_tops.setImage(image);
        change_sound();
    }

    @FXML
    void change_leg(MouseEvent event) {
        String source_leg = event.getPickResult().getIntersectedNode().getId();
        File file = new File("src/main/resources/com/example/taskguild/assets/legs/"+source_leg+".png");
        Image image = new Image(file.toURI().toString());
        view_legs.setImage(image);
        change_sound();
        
    }
    void change_sound() {
        File mediafile = new File("src/main/resources/com/example/taskguild/musik/Avatar_umziehen_sound.mp3");
        Media media = new Media(mediafile.toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setVolume(0.1);
        mediaPlayer.play();
    }
    

}