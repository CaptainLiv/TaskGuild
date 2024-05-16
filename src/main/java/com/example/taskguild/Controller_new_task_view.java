package com.example.taskguild;

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
import javafx.scene.layout.VBox;
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
    private AnchorPane create_new_activity;

    @FXML
    private VBox select_time;

    @FXML
    private DatePicker enddate;

    @FXML
    private ChoiceBox select_activity;

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
        }
        else if (select_time_task.isSelected()) {
            select_time.setVisible(true);
        }
        else {
            // Daily Task -> Monday... muss angezeigt werden (Task wird jeden Montag gemacht)
            select_time.setVisible(false);
        }
    }
    public void make_new_activity() {
        create_new_activity.setVisible(!create_new_activity.isVisible());
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
            new_todo = new Todo(task_title.getText(), selected_activity.name, task_description.getText(), Type.Normal, selected_activity.difficulty);
            new_todo.endDate = enddate.getValue().toString();
        }
        else {
            new_todo = new Todo(task_title.getText(), selected_activity.name, task_description.getText(), Type.Normal, selected_activity.difficulty);
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
