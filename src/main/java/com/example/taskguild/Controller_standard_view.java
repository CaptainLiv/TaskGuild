package com.example.taskguild;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
public class Controller_standard_view implements Initializable {

    public Avatar avatar = Avatar.load();

    @FXML
    private ImageView view_legs;

    @FXML
    private ImageView view_tops;

    @FXML
    private ImageView view_heads;

    @FXML
    private Label avatar_name;

    @FXML
    private Label avatar_level;

    @FXML
    private Label avatar_next_level;

    @FXML
    private Label orbsvalue;

    @FXML
    private ProgressBar avatar_xp;

    @FXML
    private ProgressBar avatar_strength;

    @FXML
    private ProgressBar avatar_luck;

    @FXML
    private ProgressBar avatar_speed;

    @FXML
    private ProgressBar avatar_hp;

    @FXML
    private ProgressBar avatar_endurance;

    @FXML
    private ProgressBar avatar_intelligence;

    @FXML
    private ProgressBar avatar_wisedom;

    @FXML 
    private Button mirror_button;

    @FXML
    private Pane task_space;

    @FXML
    private ScrollPane tasklist;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        view_heads.setImage(new Image(avatar.head));
        view_legs.setImage(new Image(avatar.bottom));
        view_tops.setImage(new Image(avatar.tops));
        avatar_name.setText(avatar.name);
        String level =  avatar.level + "";
        avatar_level.setText(level);
        String nextlevel =  avatar.level+1 + "";
        avatar_next_level.setText(nextlevel);
        avatar_strength.setProgress((double)avatar.attributes.strength / 100);
        avatar_luck.setProgress((double)avatar.attributes.luck / 100);
        avatar_speed.setProgress((double)avatar.attributes.speed / 100);
        avatar_hp.setProgress((double)avatar.attributes.hp / 100);
        avatar_endurance.setProgress((double)avatar.attributes.endurance / 100);
        avatar_intelligence.setProgress((double)avatar.attributes.intelligence / 100);
        avatar_wisedom.setProgress((double)avatar.attributes.wisedom / 100);

    }

    public void switch_window() throws IOException {
        Stage stage = (Stage) avatar_name.getScene().getWindow();
        Start_Application.change_window("character_creator_v3.fxml", stage);
        stage.setFullScreen(true);
        stage.setResizable(false);
        stage.setFullScreenExitHint("");
        stage.setAlwaysOnTop(true);
        Start_Application.mp.dispose();
        Start_Application.play_music("Avatar_umziehenErstellen_Hintergrundmusik");
    }

    public void switch_window_newtask() throws IOException {
        Stage stage = (Stage) avatar_name.getScene().getWindow();
        Start_Application.change_window("taskcreate.fxml", stage);
        stage.setFullScreen(true);
        stage.setResizable(false);
        stage.setFullScreenExitHint("");
        stage.setAlwaysOnTop(true);
    }

    
    
}
