package com.example.taskguild;

import java.io.*;
import java.util.ArrayList;

public class Todoliste {
    ArrayList<Todo> todolist = new ArrayList<Todo>();

    public void add_item (Todo item) {
        todolist.add(item);
    }

    public void remove_item(Todo item) {
        todolist.remove(item);
    }

    public void save() {
        
    }

    public void load() {

    }


    // for(Todo i : todolist.todolist) {

    //     System.out.println(i.name);
    //     System.out.println(i.description);
    //     System.out.println(i.difficulty);
    //     System.out.println(i.hp_boss);
    // }
}
