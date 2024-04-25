package com.example.taskguild;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.*;

public class Controller_create_profile_view {

    public static final String filepath_profile = "profile.txt";
    public String path_avatar = "src/main/java/com/example/taskguild/pictures/default.jpg";


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
    private TextField txt_name;

    @FXML
    void avatar_confirm(MouseEvent event){
        System.out.println(view_avatar.getImage().getUrl());

        // sichern des Avatars
        if(!txt_name.getText().isEmpty() && !view_avatar.getImage().getUrl().equals("src/main/java/com/example/taskguild/pictures/default.jpg")){ //bedingung definieren vor dem Speichern
            // Avatar neuer_avatar = new Avatar(txt_name.getText(),view_avatar.getImage().getUrl());
            // Avatar.save(neuer_avatar);
            System.out.println("TEST");

            }else{
            System.out.println(1);
        }

    }

    @FXML
    void avatar_select(MouseEvent event) {
        //auswahl eines Avatar anhand der Button id
        String id = ((Node) event.getSource()).getId();
        switch(id) {
            case "btn_av1":
                // code block
                path_avatar ="src/main/java/com/example/taskguild/pictures/a1.jpg";
                System.out.println(id);
                break;
            case "btn_av2":
                // code block
                path_avatar ="src/main/java/com/example/taskguild/pictures/a2.jpg";
                System.out.println(id);
                break;
            case "btn_av3":
                // code block
                path_avatar ="src/main/java/com/example/taskguild/pictures/a3.jpg";
                System.out.println(id);
                break;
            case "btn_av4":
                // code block
                path_avatar ="src/main/java/com/example/taskguild/pictures/a4.jpg";
                System.out.println(id);
                break;
            case "btn_av5":
                // code block
                path_avatar ="src/main/java/com/example/taskguild/pictures/a5.jpg";
                System.out.println(id);
                break;
            case "btn_av6":
                // code block
                path_avatar ="src/main/java/com/example/taskguild/pictures/a6.jpg";
                System.out.println(id);
                break;
            case "btn_av7":
                // code block
                path_avatar ="src/main/java/com/example/taskguild/pictures/a7.jpg";
                System.out.println(id);
                break;
            default:
                // code block
        }
        File file = new File(path_avatar);;
        Image image = new Image(file.toURI().toString());
        view_avatar.setImage(image);
    }
}