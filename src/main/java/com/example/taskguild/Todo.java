package com.example.taskguild;
import java.time.*;
import java.util.Date; 

public class Todo {
    
    public enum Type {
        Simple,
        Bossfight,
    } 
    public int ID;
    public String name;
    public String description;
    public String startDate;
    public String endDate;
    public boolean is_done;
    public Type type;
    public int difficulty;
    public int hp_boss;

    public Todo(String name, String description, String endDate, Type type, int difficulty, int hp_boss) {
        
        this.startDate = LocalDateTime.now().toString();
        this.name = name;
        this.description = description;
        this.endDate = endDate;
        this.is_done = false;
        this.type = type;
        this.difficulty = difficulty;
        this.hp_boss = hp_boss;
        
    }


}
