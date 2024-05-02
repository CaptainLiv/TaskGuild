package com.example.taskguild;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.io.File;

public class Start_Application extends Application {
    //String File name als auch Pfad
    public static final String filepath_profile = "profile.txt";

    MediaPlayer mp;
    // Start methode des Fensters
    @Override
    public void start(Stage stage) throws IOException {
        File file = new File("src/main/resources/com/example/taskguild/musik/Avatar_umziehenErstellen_Hintergrundmusik.mp3");
        Media media = new Media(file.toURI().toString());
        try{
            mp = new MediaPlayer(media);
            mp.setVolume(0.05);
            Runnable onEnd = new Runnable() {
                @Override
                public void run() {
                    mp.dispose();
                    mp = new MediaPlayer(media);
                    mp.play();
                    mp.setOnEndOfMedia(this);
                }
            };
            mp.setOnEndOfMedia(onEnd);
            mp.play();


        }catch (Exception e){
            e.printStackTrace();
        }


        //  Start methode des Fenster mit dem jeweiling Fxml je nach existens der Profile Datei
         String view = "create-profile-view.fxml";
         if(check_profile()){
             view = "create-profile-view.fxml";
        //     Hier Checken ob Todoliste existiert
        //     view = "standard-view.fxml";
             System.out.println(view);
         }else{
             System.out.println(view);
         }
         FXMLLoader fxmlLoader = new FXMLLoader(Start_Application.class.getResource(view));
         Scene scene = new Scene(fxmlLoader.load());
         stage.setTitle("TaskGuild");
         stage.setScene(scene);
         stage.show();
        // Avatar avatar = new Avatar("name", 23, 23,"", "", "", new Attribut(1,1,2,3,4,5,6));
        // Avatar.save(avatar);
        // Avatar.load();
        
    }

    public static boolean check_profile() {
        // Prüfung der Profile Datei, Rückgabe Boolean Wert
        File profilefile = new File(filepath_profile);
        boolean does_profile_exists = true;
        if (!profilefile.isFile()) {
            try{
               if(profilefile.createNewFile()){
                  does_profile_exists = false;
               }
            }catch (IOException e){
                e.printStackTrace();
                System.out.println("aisjd");
            }
        }
        return does_profile_exists;
    }

    public static void main(String[] args) {
        launch(); // Main Methode -> Aufruf des Fensters
    }
}