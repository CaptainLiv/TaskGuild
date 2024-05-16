package com.example.taskguild;

import java.io.*;
import java.util.*;


import com.google.gson.Gson;

public class Todoliste {
    ArrayList<Todo> todolist = new ArrayList<Todo>();
    public static final String filepath_todolist = "todolist.txt";

    public void add_item (Todo item) {
        todolist.add(item);
    }

    public void remove_item(Todo item) {
        todolist.remove(item);
    }

    public static void save(Todoliste todolist) {
                Gson gson = new Gson();
                String json = gson.toJson(todolist);
                System.out.println(json);
                try {
                        FileWriter myWriter = new FileWriter(filepath_todolist);
                        myWriter.write(json);
                        myWriter.close();
                        System.out.println("Successfully wrote to the file.");
                } catch (IOException e) {
                        System.out.println("An error occurred.");
                        e.printStackTrace();
                }
    }

    public static Todoliste load() {
        Todoliste todolist = new Todoliste();
        if (!filepath_todolist.isEmpty()) {

            try(BufferedReader br = new BufferedReader(new FileReader(filepath_todolist))) {
                            
                Gson gson = new Gson();
                String json = br.readLine();
                todolist = gson.fromJson(json, Todoliste.class);
                System.out.println(todolist.todolist.get(1).name);
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return todolist;
        }
        else return null;
    }


    // for(Todo i : todolist.todolist) {

    //     System.out.println(i.name);
    //     System.out.println(i.description);
    //     System.out.println(i.difficulty);
    //     System.out.println(i.hp_boss);
    // }
}
