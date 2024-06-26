package com.example.taskguild;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.example.taskguild.Todo.Type;

import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class Controller_new_task_view implements Initializable {
    @FXML 
    private RadioButton select_normal_task, select_time_task, select_daily_task, difficulty_midiocre, difficulty_hard, difficulty_harder_than_hard;

    @FXML
    private RadioButton difficulty_easy;

    @FXML
    private RadioButton difficulty_middleeasy;

    @FXML
    private TextField  minutes, hours;

    @FXML
    private CheckBox sunday, saturday, friday, thursday, wednesday, tuesday, monday;


    @FXML
    private TextField activity_title;

    @FXML
    private TextField task_title;

    @FXML 
    private TextArea task_description;

    @FXML
    private HBox create_new_activity;

    @FXML
    private Label new_activity_label;

    @FXML
    private DatePicker enddate;

    @FXML
    private ChoiceBox select_activity;

    @FXML
    private ToggleButton create_activity_button;

    @FXML
    private Label deadline;

    @FXML
    private GridPane select_time;

    @FXML
    private Label time;

    @FXML
    private AnchorPane select_day;

    public ActivityList activitylist = new ActivityList();

    public Todoliste todolist = new Todoliste();
     
 

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Activity sport = new Activity("Sport", 3);
        Activity putzen = new Activity("Putzen", 2);
        Activity email = new Activity("E-Mail schreiben", 1);
        Activity termin = new Activity("Termin", 1);
        Activity spazieren = new Activity("Spazieren", 1);
        Activity event = new Activity("Event organisieren", 3);
        Activity arbeitsauftrag = new Activity("Arbeitsauftrag erfüllen", 2);
        Activity recherche = new Activity("Recherche", 2);
        Activity lernen = new Activity("Lernen", 3);
        Activity instrument = new Activity("Instrument üben", 2);
        Activity wanderung = new Activity("Wanderung", 3);
        Activity aussortieren = new Activity("Aussortieren", 3);
        Activity heimwerkarbeit = new Activity("Heimwerkarbeit", 3);

        if (ActivityList.load() == null) {
            activitylist.add_item(sport);
            activitylist.add_item(putzen);
            activitylist.add_item(email);
            activitylist.add_item(termin);
            activitylist.add_item(spazieren);
            activitylist.add_item(event);
            activitylist.add_item(arbeitsauftrag);
            activitylist.add_item(recherche);
            activitylist.add_item(lernen);
            activitylist.add_item(instrument);
            activitylist.add_item(wanderung);
            activitylist.add_item(aussortieren);
            activitylist.add_item(heimwerkarbeit);
            ActivityList.save(activitylist);
        }
        else {
            activitylist = ActivityList.load();
        }
    
        for (Activity activity : activitylist.activitylist) {
            select_activity.getItems().add(activity.name + " ("+ activity.difficulty + ")");
        }
        if (Todoliste.load() == null) {
            todolist = new Todoliste();
        }
        else {
            todolist = Todoliste.load();
        }
    }

    public void change_task_type() {
        if (select_normal_task.isSelected()) {
            select_time.setVisible(false);
            time.setVisible(false);
            deadline.setVisible(false);
            select_day.setVisible(false);
        }
        else if (select_time_task.isSelected()) {
            select_time.setVisible(true);
            time.setVisible(true);
            deadline.setVisible(true);
            select_day.setVisible(false);
        }
        else {
            select_time.setVisible(false);
            deadline.setVisible(false);
            time.setVisible(true);
            select_day.setVisible(true);
        }
    }
    public void make_new_activity() {
        create_new_activity.setVisible(!create_new_activity.isVisible());
        new_activity_label.setVisible(!new_activity_label.isVisible());
        
    }

    public void create_new_activity() {
        Activity new_activity;
        if (difficulty_easy.isSelected()) {
            new_activity = new Activity(activity_title.getText(), 1);
         }
        else if (difficulty_middleeasy.isSelected()) { 
            new_activity = new Activity(activity_title.getText(), 2);
        }
        else if (difficulty_midiocre.isSelected()) { 
            new_activity = new Activity(activity_title.getText(), 3);
        }
        else if (difficulty_hard.isSelected()) { 
            new_activity = new Activity(activity_title.getText(), 4);
        }
        else { 
            new_activity = new Activity(activity_title.getText(), 5);
        }
        activitylist.add_item(new_activity);
        ActivityList.save(activitylist);
        select_activity.getItems().add(new_activity.name + " ("+ new_activity.difficulty + ")");
        create_new_activity.setVisible(false);
        difficulty_easy.setSelected(true);
        activity_title.clear();
        create_activity_button.setSelected(false);
    }

    public void create_new_task() throws IOException {
        Todo new_todo;
        Activity selected_activity = new Activity("", 0);
            for (Activity activity : activitylist.activitylist) {
                String activity_name = activity.name + " ("+ activity.difficulty + ")";
                if (activity_name.equals((String)select_activity.getValue())) {
                    selected_activity = activity;
                }

            }
        if (select_normal_task.isSelected()) {
            

            new_todo = new Todo(task_title.getText(), selected_activity.name, task_description.getText(), Type.Normal, selected_activity.difficulty);
        }
        else if (select_time_task.isSelected()) {
            new_todo = new Todo(task_title.getText(), selected_activity.name, task_description.getText(), Type.Time, selected_activity.difficulty);
            new_todo.minutes = Integer.parseInt(minutes.getText());
            new_todo.hours = Integer.parseInt(hours.getText());
        }
        else {
            new_todo = new Todo(task_title.getText(), selected_activity.name, task_description.getText(), Type.Daily, selected_activity.difficulty);
            String days = "";
            if(monday.isSelected() ) {
                days += "Monday,";
            }
            if (tuesday.isSelected()) {
                days += "Tuesday,";
            }
            if (wednesday.isSelected()) {
                days += "Wednesday,";
            }
            if (thursday.isSelected()) {
                days += "Thursday,";
            }
            if (friday.isSelected()) {
                days += "Friday,";
            }
            if (saturday.isSelected()) {
                days += "Saturday,";
            }
            if (sunday.isSelected()){
                days += "Sunday,";
            }
            new_todo.Day = days.split(",");
        }
        File file = new File("src/main/resources/com/example/taskguild/musik/Task_hinzugefügt (1).mp3");
        Media media = new Media(file.toURI().toString());
        MediaPlayer mp = new MediaPlayer(media);
        mp.setVolume(0.2);
        mp.play();
        todolist.add_item(new_todo);
        Todoliste.save(todolist);
        Stage stage = (Stage) task_title.getScene().getWindow();
        Start_Application.change_window("mainframe_v3.fxml", stage);
        stage.setFullScreen(true);
        stage.setResizable(false);
        stage.setFullScreenExitHint("");
        stage.setAlwaysOnTop(true);

    }
}
