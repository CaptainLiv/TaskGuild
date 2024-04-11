package com.example.taskguild;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.File;

public class Start_Application extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Start_Application.class.getResource("startscreen.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("TaskGuild");
        stage.setScene(scene);
        stage.show();
    }

    public static final String filepath_profil = "profil.txt";

    public static boolean check_profil() {
        File profildatei = new File(filepath_profil);
        if (profildatei.isFile()) {
            System.out.println("lade Profil");
        } else {
            try{
               if(profildatei.createNewFile()){
                   System.out.println("Datei wurde angelegt");
               }
            }catch (IOException e){
                e.printStackTrace();
            }

            System.out.println("erstell Profil");
        }
        return true;
    }

    public static void main(String[] args) {
       // if (check_profil()) {
       //     System.out.println("exist");
       // }
        launch();
    }
}