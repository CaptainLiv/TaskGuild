module com.example.guildtask {
    requires javafx.controls;
    requires javafx.fxml;
    // opens java.time to com.google.gson;
    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires com.google.gson;
    
    opens com.example.taskguild to com.google.gson, javafx.fxml;
    exports com.example.taskguild;
}