package com.example.taskguild;
import java.time.*;
import java.util.Date; 

public class Todo {
    
    public enum Type {
        Normal,
        Daily,
        Time 
    } 
    public int ID;
    public String name;
    public String activity_name;
    public String description;
    public String startDate;
    public int minutes;
    public int hours;
    public boolean is_done;
    public Type type;
    public int difficulty;
    public String[] Day;


    public Todo(String name, String activity_name, String description, Type type, int difficulty) {
        
        this.startDate = LocalTime.now().toString();
        this.activity_name = activity_name;
        this.name = name;
        this.description = description;
        this.is_done = false;
        this.type = type;
        this.difficulty = difficulty;
        
    }


}
