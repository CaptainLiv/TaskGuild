package com.example.taskguild;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
                // Gson gson = new Gson();
                // String json = gson.toJson(todolist);
                // System.out.println(json);
                System.out.println(todolist.todolist.get(0).name);
                // try {
                //         FileWriter myWriter = new FileWriter(filepath_todolist);
                //         myWriter.write(json);
                //         myWriter.close();
                //         System.out.println("Successfully wrote to the file.");
                // } catch (IOException e) {
                //         System.out.println("An error occurred.");
                //         e.printStackTrace();
                // }
    }

    public static void load() {
        try(BufferedReader br = new BufferedReader(new FileReader(filepath_todolist))) {
                        
            Gson gson = new Gson();
            String json = br.readLine();
            Todoliste todolist = gson.fromJson(json, Todoliste.class);
            // System.out.println(todolist.todolist);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }


    // for(Todo i : todolist.todolist) {

    //     System.out.println(i.name);
    //     System.out.println(i.description);
    //     System.out.println(i.difficulty);
    //     System.out.println(i.hp_boss);
    // }
}
