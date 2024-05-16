package com.example.taskguild;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class Controller_new_task_view implements Initializable {
    @FXML 
    private RadioButton select_normal_task, select_time_task, select_daily_task, difficulty_midiocre, difficulty_hard, difficulty_harder_than_hard;

    @FXML
    private RadioButton difficulty_easy;

    @FXML
    private RadioButton difficulty_middleeasy;

    @FXML
    private TextField task_title, activity_title, task_description, hours, minutes;

    @FXML
    private AnchorPane create_new_activity;

    @FXML
    private VBox select_time;

    @FXML
    private DatePicker enddate;

    @FXML
    private ChoiceBox select_activity;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }

    public void change_task_type(MouseEvent event) {
        if (select_normal_task.isSelected()) {
            select_time.setVisible(false);
        }
        else if (select_time_task.isSelected()) {
            select_time.setVisible(true);
        }
        else {
            select_time.setVisible(false);
        }
    }
    public void make_new_activity(MouseEvent event) {
        create_new_activity.setVisible(!create_new_activity.isVisible());
    }
}
