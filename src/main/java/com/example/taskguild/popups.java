package com.example.taskguild;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.layout.HBox;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class popups extends Application {
//Creating a dialog
    public void start(Stage stage) {
        //characterbuilder Popup
        Alert characterScreen = new Alert(Alert.AlertType.NONE);
        characterScreen.setTitle("Alert");
        ButtonType type = new ButtonType("OK", ButtonData.OK_DONE);
        characterScreen.setContentText("Welcome, adventurer! Time to sculpt your character and give them a name above! When you're ready, hit DONE.");
        characterScreen.getDialogPane().getButtonTypes().add(type);
    
        //erstermal mainscreen popup
        Alert firstMain = new Alert(Alert.AlertType.NONE);
        firstMain.setTitle("Alert");
        firstMain.setContentText("Congratulations! You've crafted your character! Now, a quick intro before the real fun begins!");
        firstMain.getDialogPane().getButtonTypes().add(type);

        //popup für den Spiegel
        Alert mirrorPopup = new Alert(Alert.AlertType.NONE);
        mirrorPopup.setTitle("Alert");
        mirrorPopup.setContentText("Behold the mirror, where you can tweak your character's appearance anytime you desire!");
        mirrorPopup.getDialogPane().getButtonTypes().add(type);

        //popup für die Levelanzeige
        Alert levelPopup = new Alert(Alert.AlertType.NONE);
        levelPopup.setTitle("Alert");
        levelPopup.setContentText("Behold your level gauge! Completing tasks fills it with XP. Level up and earn Skill Orbs to enhance your abilities!");
        levelPopup.getDialogPane().getButtonTypes().add(type);

        //popup für die Skillanzeige
        Alert skillPopup = new Alert(Alert.AlertType.NONE);
        skillPopup.setTitle("Alert");
        skillPopup.setContentText("Here's your skill display. Leveling up unlocks exciting features like expeditions for rare items!");
        skillPopup.getDialogPane().getButtonTypes().add(type);

        //popup für die Taskanzeige
        Alert taskPopup = new Alert(Alert.AlertType.NONE);
        taskPopup.setTitle("Alert");
        taskPopup.setContentText("And here's the heart of it all, the tasks! Every mission completed brings you closer to the next level.");
        taskPopup.getDialogPane().getButtonTypes().add(type);

        //popup für das Task hinzufügen
        Alert taskAddPopup = new Alert(Alert.AlertType.NONE);
        taskAddPopup.setTitle("Alert");
        taskAddPopup.setContentText("Hit the plus sign to add various types of tasks. Remember, the tougher the task, the more XP you'll earn!");
        taskAddPopup.getDialogPane().getButtonTypes().add(type);

        Text txt = new Text("Click the button to show the dialog");
        Font font = Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 12);
        txt.setFont(font);
        //Creating a button
        Button button = new Button("Show Dialog");
        //Showing the dialog on clicking the button
        Rectangle2D bounds = Screen.getPrimary().getVisualBounds();
        button.setOnAction(e -> {
            characterScreen.showAndWait();

            firstMain.showAndWait();

            mirrorPopup.setX(bounds.getMaxX() - 1750);
            mirrorPopup.setY(bounds.getMaxY() - 400);
            mirrorPopup.showAndWait();

            levelPopup.setX(bounds.getMaxX() - 1750);
            levelPopup.setY(bounds.getMaxY() - 600);
            levelPopup.showAndWait();

            skillPopup.setX(bounds.getMaxX() - 450);
            skillPopup.setY(bounds.getMaxY() - 550);
            skillPopup.showAndWait();

            taskPopup.showAndWait();

            taskAddPopup.setX(bounds.getMaxX() - 1180);
            taskAddPopup.setY(bounds.getMaxY() - 300);
            taskAddPopup.showAndWait();
        });
        //Creating a vbox to hold the button and the label
        HBox pane = new HBox(15);
        //Setting the space between the nodes of a HBox pane
        pane.setPadding(new Insets(50, 150, 50, 60));
        pane.getChildren().addAll(txt, button);
        //Creating a scene object
        Scene scene = new Scene(new Group(pane), 595, 300, Color.BEIGE);
        stage.setTitle("Alert");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String args[]){
        launch(args);
    }
}
    
