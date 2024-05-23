package com.example.taskguild;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
public class Controller_standard_view implements Initializable {

    public static int orbs = 0;

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
    private Label orbsvalue = new Label("assaasasasas");

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

    @FXML
    private Button strength_button;

    @FXML
    private Button luck_button;

    @FXML
    private Button speed_button;

    @FXML
    private Button life_button;

    @FXML
    private Button endurance_button;

    @FXML
    private Button intelligence_button;

    @FXML
    private Button mind_button;

    @FXML
    private VBox todolist_view;
    

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
        update_skillorbs();
        update_todolist();
    }

    public void update_todolist() {
        Todoliste todolist = Todoliste.load();
        for (Todo todo : todolist.todolist) {
            HBox hbox = new HBox();
            Pane pane = new Pane();
            //pane.setMinHeight(1000);
            Label deadline = new Label(todo.endDate);
            deadline.getStyleClass().add("deadline");
            VBox label_box = new VBox();
            Label task_info = new Label(todo.name + " - " + todo.activity_name);
            task_info.getStyleClass().add("task_info");
            Label description = new Label(todo.description);
            label_box.getChildren().add(task_info);
            label_box.getChildren().add(description);
            VBox button_box = new VBox();
            Button complete = new Button();
            Button delete = new Button();
            button_box.getChildren().add(complete);
            button_box.getChildren().add(delete);
            //ImageView image_complete = new ImageView("assets\\bg\\Haken.png");
            //ImageView image_delete = new ImageView("assets\\bg\\trash.png");
           // complete.setGraphic(image_complete);
            //delete.setGraphic(image_delete);
            hbox.getChildren().add(deadline);
            hbox.getChildren().add(label_box);
            hbox.getChildren().add(button_box);
            pane.getChildren().add(hbox);
            pane.getStyleClass().add("task_space");
            
            todolist_view.getChildren().add(pane);
        }
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

    public static void get_skillorbs(int skillorbs) {
        orbs = skillorbs;
        
    }

    public void update_skillorbs() {
        orbsvalue.setText("You can place " + orbs + " Skill Orbs");
        if (orbs != 0) {
            strength_button.setVisible(true);
            luck_button.setVisible(true);
            speed_button.setVisible(true);
            life_button.setVisible(true);
            endurance_button.setVisible(true);
            intelligence_button.setVisible(true);
            mind_button.setVisible(true);
        }
    }

   
    public void add_strength_skillorb() {
        avatar.skill_orbs = avatar.skill_orbs -1;
        avatar.attributes.strength = avatar.attributes.strength + 1;
        Avatar.save(avatar);
    }

    public void add_luck_skillorb() {
        avatar.skill_orbs = avatar.skill_orbs -1;
        avatar.attributes.luck = avatar.attributes.strength + 1;
        Avatar.save(avatar);
    }

    public void add_speed_skillorb() {
        avatar.skill_orbs = avatar.skill_orbs -1;
        avatar.attributes.speed = avatar.attributes.strength + 1;
        Avatar.save(avatar);
    }

    public void add_life_skillorb() {
        avatar.skill_orbs = avatar.skill_orbs -1;
        avatar.attributes.hp = avatar.attributes.strength + 1;
        Avatar.save(avatar);
    }

    public void add_endurance_skillorb() {
        avatar.skill_orbs = avatar.skill_orbs -1;
        avatar.attributes.endurance = avatar.attributes.strength + 1;
        Avatar.save(avatar);
    }   

    public void add_intelligence_skillorb() {
        avatar.skill_orbs = avatar.skill_orbs -1;
        avatar.attributes.intelligence = avatar.attributes.strength + 1;
        Avatar.save(avatar);
    }

    public void add_mind_skillorb() {
        avatar.skill_orbs = avatar.skill_orbs -1;
        avatar.attributes.wisedom = avatar.attributes.strength + 1;
        Avatar.save(avatar);
    }
    
    
}
