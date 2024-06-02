package com.example.taskguild;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCombination;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class Start_Application extends Application {
    //String File name als auch Pfad
    public static final String filepath_profile = "profile.txt";
    public static final String filepath_todolist = "todolist.txt";
    public static final String filepath_activitylist = "activitylist.txt";
    public static boolean does_profile_exists;
    public static Stage hauptstage;
    @SuppressWarnings("exports")
    public static MediaPlayer mp;
    // Start methode des Fensters
    @Override
    public void start(Stage stage) throws IOException {
        play_music("Avatar_umziehenErstellen_Hintergrundmusik");

        Avatar avatar = new Avatar();
        System.out.println(avatar.tutorial);
        //  Start methode des Fenster mit dem jeweiling Fxml je nach existens der Profile Datei
         String view = "character_creator_v3.fxml";
         //     Hier Checken ob Todoliste existiert
         if(check_profile()){
             avatar = Avatar.load();
             //view = "mainframe.fxml";
                view = "mainframe_v3.fxml";
                // view = "create-profile-view.fxml";
                mp.dispose();
                play_music("Hintergrundmusik(ToDo_Liste)");
             System.out.println(view);
         }else{
             System.out.println(view);
         }
         change_window(view, stage);
         if (!avatar.tutorial) {
             popups_open(0);
         }
    }

    public static void change_window(String view, Stage stage) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(Start_Application.class.getResource(view));
        hauptstage=stage;
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("TaskGuild");
        stage.setFullScreen(true);
        stage.setResizable(false);
        stage.setFullScreenExitHint("");
        stage.setAlwaysOnTop(true);
        stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
        stage.setScene(scene);
        File iconFile = new File("src/main/resources/com/example/taskguild/assets/bg/icon.png");
        stage.getIcons().add(new Image(iconFile.toURI().toString()));
        stage.show();
    }

    public static boolean check_profile() {
        // Prüfung der Profile Datei, Rückgabe Boolean Wert
        File profilefile = new File(filepath_profile);
        File todoFile = new File(filepath_todolist);
        File activityFile = new File(filepath_activitylist);
        does_profile_exists = true;
        if (!profilefile.isFile()) {
            try{
               if(profilefile.createNewFile()){
                    does_profile_exists = false;
                    activityFile.createNewFile();
                    todoFile.createNewFile();
               }
            }catch (IOException e){
                e.printStackTrace();
                System.out.println("aisjd");
            }
        }
        else {
            if (profilefile.length() == 0) {
                does_profile_exists = false;
            }
        }
        return does_profile_exists;
    }
    public static void play_music(String path) {
        File file = new File("src/main/resources/com/example/taskguild/musik/" + path + ".mp3");
        Media media = new Media(file.toURI().toString());
        try{
            mp = new MediaPlayer(media);
            mp.setVolume(0.05);
            Runnable onEnd = new Runnable() {
                @Override
                public void run() {
                    mp.dispose();
                    mp = new MediaPlayer(media);
                    mp.setVolume(0.05);
                    mp.play();
                    mp.setOnEndOfMedia(this);
                }
            };
            mp.setOnEndOfMedia(onEnd);
            mp.play();


        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void popups_open(int popupnummer){
        ButtonType type = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
        Rectangle2D bounds = Screen.getPrimary().getVisualBounds();
        File iconFilepoup = new File("src/main/resources/com/example/taskguild/assets/bg/icon.png");
        Stage stage;
        switch (popupnummer){
            case 0:
                Alert characterScreen = new Alert(Alert.AlertType.NONE);
                characterScreen.setTitle("Information");
                characterScreen.setContentText("Welcome, adventurer! Time to sculpt your character and give them a name above! When you're ready, hit DONE.");
                characterScreen.getDialogPane().getButtonTypes().add(type);
                characterScreen.initOwner(hauptstage);
                stage = (Stage) characterScreen.getDialogPane().getScene().getWindow();
                stage.getIcons().add(new Image(iconFilepoup.toURI().toString()));
                characterScreen.showAndWait();
                break;
            case 1:
                //erstermal mainscreen popup
                Alert firstMain = new Alert(Alert.AlertType.NONE);
                firstMain.setTitle("Information");
                firstMain.setContentText("Congratulations! You've crafted your character! Now, a quick intro before the real fun begins!");
                firstMain.getDialogPane().getButtonTypes().add(type);
                stage = (Stage) firstMain.getDialogPane().getScene().getWindow();
                stage.getIcons().add(new Image(iconFilepoup.toURI().toString()));
                firstMain.showAndWait();
                break;
            case 2:
                //popup für den Spiegel
                Alert mirrorPopup = new Alert(Alert.AlertType.NONE);
                mirrorPopup.setTitle("Alert");
                mirrorPopup.setContentText("Behold the mirror, where you can tweak your character's appearance anytime you desire!");
                mirrorPopup.getDialogPane().getButtonTypes().add(type);
                mirrorPopup.setX(bounds.getMaxX() - 1750);
                mirrorPopup.setY(bounds.getMaxY() - 400);
                stage = (Stage) mirrorPopup.getDialogPane().getScene().getWindow();
                stage.getIcons().add(new Image(iconFilepoup.toURI().toString()));
                mirrorPopup.showAndWait();
                break;
            case 3:
                //popup für die Levelanzeige
                Alert levelPopup = new Alert(Alert.AlertType.NONE);
                levelPopup.setTitle("Alert");
                levelPopup.setContentText("Behold your level gauge! Completing tasks fills it with XP. Level up and earn Skill Orbs to enhance your abilities!");
                levelPopup.getDialogPane().getButtonTypes().add(type);
                levelPopup.setX(bounds.getMaxX() - 1750);
                levelPopup.setY(bounds.getMaxY() - 600);
                stage = (Stage) levelPopup.getDialogPane().getScene().getWindow();
                stage.getIcons().add(new Image(iconFilepoup.toURI().toString()));
                levelPopup.showAndWait();

                break;
            case 4:
                //popup für die Skillanzeige
                Alert skillPopup = new Alert(Alert.AlertType.NONE);
                skillPopup.setTitle("Alert");
                skillPopup.setContentText("Here's your skill display. Leveling up unlocks exciting features like expeditions for rare items!");
                skillPopup.getDialogPane().getButtonTypes().add(type);
                skillPopup.setX(bounds.getMaxX() - 450);
                skillPopup.setY(bounds.getMaxY() - 550);
                stage = (Stage) skillPopup.getDialogPane().getScene().getWindow();
                stage.getIcons().add(new Image(iconFilepoup.toURI().toString()));
                skillPopup.showAndWait();

                break;
            case 5:
                //popup für die Taskanzeige
                Alert taskPopup = new Alert(Alert.AlertType.NONE);
                taskPopup.setTitle("Alert");
                taskPopup.setContentText("And here's the heart of it all, the tasks! Every mission completed brings you closer to the next level.");
                taskPopup.getDialogPane().getButtonTypes().add(type);
                stage = (Stage) taskPopup.getDialogPane().getScene().getWindow();
                stage.getIcons().add(new Image(iconFilepoup.toURI().toString()));
                taskPopup.showAndWait();
                break;
            case 6:

                //popup für das Task hinzufügen
                Alert taskAddPopup = new Alert(Alert.AlertType.NONE);
                taskAddPopup.setTitle("Alert");
                taskAddPopup.setContentText("Hit the plus sign to add various types of tasks. Remember, the tougher the task, the more XP you'll earn!");
                taskAddPopup.getDialogPane().getButtonTypes().add(type);
                taskAddPopup.setX(bounds.getMaxX() - 1180);
                taskAddPopup.setY(bounds.getMaxY() - 300);
                stage = (Stage) taskAddPopup.getDialogPane().getScene().getWindow();
                stage.getIcons().add(new Image(iconFilepoup.toURI().toString()));
                taskAddPopup.showAndWait();
                break;
        }
    }
    public static void main(String[] args) {
        launch(); // Main Methode -> Aufruf des Fensters
    }
}