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
        String view = "create-profile-view.fxml";
        if(check_profile()){
            view = "standard-view.fxml";
            System.out.println(view);
        }else{
            System.out.println(view);
        }
       FXMLLoader fxmlLoader = new FXMLLoader(Start_Application.class.getResource(view));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("TaskGuild");
        stage.setScene(scene);
        stage.show();
    }

    public static final String filepath_profile = "profile.txt";

    public static boolean check_profile() {
        File profilefile = new File(filepath_profile);
        boolean does_profile_exists = true;
        if (!profilefile.isFile()) {
            try{
               if(profilefile.createNewFile()){
                  does_profile_exists = false;
               }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        return does_profile_exists;
    }

    public static void main(String[] args) {
        launch();
    }
}