package com.example.taskguild;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
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

    public Todoliste todolist;

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
        if (Todoliste.load() == null) {
            todolist = new Todoliste();
        }
        else {
            todolist = Todoliste.load();
        }
        view_heads.setImage(new Image(avatar.head));
        view_legs.setImage(new Image(avatar.bottom));
        view_tops.setImage(new Image(avatar.tops));
        update_avatar();
        update_todolist();
    }

    public void update_avatar() {
        avatar = Avatar.load();
        avatar_name.setText(avatar.name);
        String level =  avatar.level + "";
        avatar_level.setText(level);
        String nextlevel =  avatar.level+1 + "";
        avatar_xp.setProgress((double) avatar.xp / avatar.xp_needed );
        avatar_next_level.setText(nextlevel);
        avatar_strength.setProgress((double)avatar.attributes.strength / 100);
        avatar_luck.setProgress((double)avatar.attributes.luck / 100);
        avatar_speed.setProgress((double)avatar.attributes.speed / 100);
        avatar_hp.setProgress((double)avatar.attributes.hp / 75);
        avatar_endurance.setProgress((double)avatar.attributes.endurance / 100);
        avatar_intelligence.setProgress((double)avatar.attributes.intelligence / 100);
        avatar_wisedom.setProgress((double)avatar.attributes.wisedom / 100);
        orbsvalue.setText("You can place " + avatar.skill_orbs + " Skill Orbs");
        
        if (avatar.skill_orbs > 0) {
            strength_button.setVisible(true);
            luck_button.setVisible(true);
            speed_button.setVisible(true);
            life_button.setVisible(true);
            endurance_button.setVisible(true);
            intelligence_button.setVisible(true);
            mind_button.setVisible(true);
        }
        else {
            strength_button.setVisible(false);
            luck_button.setVisible(false);
            speed_button.setVisible(false);
            life_button.setVisible(false);
            endurance_button.setVisible(false);
            intelligence_button.setVisible(false);
            mind_button.setVisible(false);
        }
        if (avatar.attributes.strength >= 100) {
            strength_button.setVisible(false);
        }

        if (avatar.attributes.luck >= 100) {
            strength_button.setVisible(false);
        }

        if (avatar.attributes.speed >= 100) {
            strength_button.setVisible(false);
        }

        if (avatar.attributes.hp >= 100) {
            strength_button.setVisible(false);
        }

        if (avatar.attributes.endurance >= 100) {
            strength_button.setVisible(false);
        }

        if (avatar.attributes.intelligence >= 100) {
            strength_button.setVisible(false);
        }

        if (avatar.attributes.wisedom >= 100) {
            strength_button.setVisible(false);
        }
        Avatar.save(avatar);
    }

    public void update_todolist() {
        todolist_view.getChildren().clear();
        for (Todo todo : todolist.todolist) {
            HBox hbox = new HBox();
            Pane pane = new Pane();
            //pane.setMinHeight(1000);
            String x = todo.startDate.substring(0, todo.startDate.indexOf("."));
            LocalTime startTime = LocalTime.parse(x);
            startTime = startTime.plusHours(todo.hours);
            startTime = startTime.plusMinutes(todo.minutes);
            String[] y = startTime.toString().split(":");
            Label deadline = new Label(y[0] + ":" + y[1]);
            deadline.getStyleClass().add("deadline");
            deadline.setAlignment(Pos.CENTER_LEFT);
            VBox label_box = new VBox();
            Label task_info = new Label(todo.name + " - " + todo.activity_name);
            task_info.getStyleClass().add("task_info");
            Label description = new Label(todo.description);
            description.getStyleClass().add("task_description");
            label_box.getChildren().add(task_info);
            label_box.getChildren().add(description);
            label_box.getStyleClass().add("middle_box");
            VBox button_box = new VBox();
            Button complete = new Button();
            Button delete = new Button();
            complete.setOnMouseClicked(event -> {complete_task(todo);});
            delete.setOnMouseClicked(event -> {delete_task(todo);});
            button_box.getChildren().add(complete);
            button_box.getChildren().add(delete);
            File imageFile_haken = new File("src/main/resources/com/example/taskguild/assets/bg/Haken.png");
            File imageFile_trash = new File("src/main/resources/com/example/taskguild/assets/bg/trash.png");
            Image haken = new Image(imageFile_haken.toURI().toString());
            Image trash = new Image(imageFile_trash.toURI().toString());
            ImageView image_complete = new ImageView(haken);
            ImageView image_delete = new ImageView(trash);
            complete.setGraphic(image_complete);
            delete.setGraphic(image_delete);
            complete.getStyleClass().add("btn_complete");
            delete.getStyleClass().add("btn_delete");
            hbox.getChildren().add(deadline);
            hbox.getChildren().add(label_box);
            hbox.getChildren().add(button_box);
            hbox.getStyleClass().add("hbox");
            pane.getChildren().add(hbox);
            pane.getStyleClass().add("task_space");
            
            todolist_view.getChildren().add(pane);
        }
    }
  
    public void complete_task(Todo todo) {
        // todolist.todolist.remove(todo);
        avatar.task_completed(todo.difficulty, todo.type, todo.startDate, todo.minutes, todo.hours);
        Avatar.save(avatar);
        update_avatar();
        Todoliste.save(todolist);
        update_todolist();
        File file = new File("src/main/resources/com/example/taskguild/musik/Task_beendet.mp3");
        Media media = new Media(file.toURI().toString());
        MediaPlayer mp = new MediaPlayer(media);
        mp.setVolume(0.2);
        mp.play();
    }

    public void delete_task(Todo todo) {
        todolist.todolist.remove(todo);
        Todoliste.save(todolist);
        update_todolist();
        File file = new File("src/main/resources/com/example/taskguild/musik/Task_löschen.mp3");
        Media media = new Media(file.toURI().toString());
        MediaPlayer mp = new MediaPlayer(media);
        mp.setVolume(0.2);
        mp.play();
    }


    public void switch_window() throws IOException {
        System.out.println(avatar.tutorial+"");
        update_avatar();
        Avatar.save(avatar);
        System.out.println(avatar.tutorial+"");
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


   
    public void add_strength_skillorb() {
        avatar.skill_orbs = avatar.skill_orbs -1;
        avatar.attributes.strength = avatar.attributes.strength + 1;
        Avatar.save(avatar);
        update_avatar();
    }

    public void add_luck_skillorb() {
        avatar.skill_orbs = avatar.skill_orbs -1;
        avatar.attributes.luck = avatar.attributes.luck + 1;
        Avatar.save(avatar);
        update_avatar();
    }

    public void add_speed_skillorb() {
        avatar.skill_orbs = avatar.skill_orbs -1;
        avatar.attributes.speed = avatar.attributes.speed + 1;
        Avatar.save(avatar);
        update_avatar();
    }

    public void add_life_skillorb() {
        avatar.skill_orbs = avatar.skill_orbs -1;
        avatar.attributes.hp = avatar.attributes.hp + 1;
        Avatar.save(avatar);
        update_avatar();
    }

    public void add_endurance_skillorb() {
        avatar.skill_orbs = avatar.skill_orbs -1;
        avatar.attributes.endurance = avatar.attributes.endurance + 1;
        Avatar.save(avatar);
        update_avatar();
    }   

    public void add_intelligence_skillorb() {
        avatar.skill_orbs = avatar.skill_orbs -1;
        avatar.attributes.intelligence = avatar.attributes.intelligence + 1;
        Avatar.save(avatar);
        update_avatar();
    }

    public void add_mind_skillorb() {
        avatar.skill_orbs = avatar.skill_orbs -1;
        avatar.attributes.wisedom = avatar.attributes.wisedom + 1;
        Avatar.save(avatar);
        update_avatar();
    }
    
    
}
