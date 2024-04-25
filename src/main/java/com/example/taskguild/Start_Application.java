package com.example.taskguild;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import com.example.taskguild.Todo.Type;

import java.io.File;

public class Start_Application extends Application {
    //String File name als auch Pfad
    public static final String filepath_profile = "profile.txt";

    // Start methode des Fensters
    @Override
    public void start(Stage stage) throws IOException {
        // Start methode des Fenster mit dem jeweiling Fxml je nach existens der Profile Datei
        // String view = "create-profile-view.fxml";
        // if(check_profile()){
        //     view = "create-profile-view.fxml";
        //     Hier Checken ob Todoliste existiert
        //     view = "standard-view.fxml";
        //     System.out.println(view);
        // }else{
        //     System.out.println(view);
        // }
        // FXMLLoader fxmlLoader = new FXMLLoader(Start_Application.class.getResource(view));
        // Scene scene = new Scene(fxmlLoader.load());
        // stage.setTitle("TaskGuild");
        // stage.setScene(scene);
        // stage.show();
        // Avatar avatar = new Avatar("name", 23, 23,"", "", "", new Attribut(1,1,2,3,4,5,6));
        // Avatar.save(avatar);
        // Avatar.load();

        Todo todo1 = new Todo("name", "dec", "2", Type.Bossfight, 2, 2);
        Todo todo2 = new Todo("name", "dec", "2", Type.Bossfight, 2, 2);
        Todoliste todolist = new Todoliste();
        todolist.add_item(todo1);
        todolist.add_item(todo2);
        Todoliste.save(todolist);
        Todoliste.load();
        
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