package com.example.taskguild;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;

public class ActivityList {
    ArrayList<Activity> activitylist = new ArrayList<Activity>();
    public static final String filepath_activitylist = "activitylist.txt";

    public void add_item (Activity item) {
        activitylist.add(item);
    }

    public void remove_item(Activity item) {
        activitylist.remove(item);
    }

    public static void save(ActivityList activitylist) {
                Gson gson = new Gson();
                String json = gson.toJson(activitylist);
                try {
                        FileWriter myWriter = new FileWriter(filepath_activitylist);
                        myWriter.write(json);
                        myWriter.close();
                } catch (IOException e) {
                        System.out.println("An error occurred.");
                        e.printStackTrace();
                }
    }

    public static ActivityList load() {
        ActivityList activityList = new ActivityList();
        try(BufferedReader br = new BufferedReader(new FileReader(filepath_activitylist))) {
                        
            Gson gson = new Gson();
            String json = br.readLine();
            activityList = gson.fromJson(json, ActivityList.class);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return activityList;
    }
}
