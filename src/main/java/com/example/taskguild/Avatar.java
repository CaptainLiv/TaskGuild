package com.example.taskguild;

import java.io.*;
import java.nio.file.Files;

import com.example.taskguild.Todo.Type;
import com.google.gson.Gson;

public class Avatar {
        public String name;
        public String head;
        public String bottom;
        public String tops;
        public Attribut attributes;
        public int xp;
        public int xp_needed;
        public int level;
        public static final String filepath_profile = "profile.txt";

        public Avatar(String name, String head, String bottom, String tops, Attribut attributes){
                this.name = name;
                this.xp = 0;
                this.level = 0;
                this.xp_needed = 5;
                this.head = head;
                this.bottom = bottom;
                this.tops = tops;
                this.attributes.endurance = 0;
                this.attributes.hp = 0;
                this.attributes.intelligence = 0;
                this.attributes.luck = 0;
                this.attributes.speed = 0;
                this.attributes.strength = 0;
                this.attributes.wisedom = 0;
        }
        public Avatar(String name, int xp, int level, String head, String bottom, String tops, Attribut attributes){
                this.name = name;
                this.xp = xp;
                this.level = level;
                this.head = head;
                this.bottom = bottom;
                this.tops = tops;
                this.attributes = attributes;
        }

        @Override
        public String toString() {
                return "Avatar{" +
                        "name='" + name + '\'' +
                        ", xp=" + xp +
                        ", level=" + level +
                        '}';
        }

        public static void save(Avatar avatar) {
                Gson gson = new Gson();
                String json = gson.toJson(avatar);
                try {
                        FileWriter myWriter = new FileWriter(filepath_profile);
                        myWriter.write(json);
                        myWriter.close();
                        System.out.println("Successfully wrote to the file.");
                } catch (IOException e) {
                        System.out.println("An error occurred.");
                        e.printStackTrace();
                }
        }

        public static void load() {
                

                try(BufferedReader br = new BufferedReader(new FileReader(filepath_profile))) {
                        
                        Gson gson = new Gson();
                        String json = br.readLine();
                        Avatar avatar = gson.fromJson(json, Avatar.class);
                        System.out.println(avatar.attributes.wisedom);
                    }
                    catch (IOException e) {
                        e.printStackTrace();
                    }

        }

        public void check_level_up() {
                if (xp >= xp_needed) {
                        if (xp - xp_needed > 0)
                        {
                                xp = xp- xp_needed;
                        } 
                        else {
                                xp = 0;
                        }
                        level = level + 1;
                        double x = xp_needed + xp_needed * 0.1;
                        xp_needed = (int)x;
                }
        }

        public void task_completed(int difficulty, Type task_type) {
                switch(difficulty) {
                        case 1: if (task_type.toString() == "Simple") {
                                        xp = xp + attributes.intelligence + 1;
                                } else {
                                       xp = xp + attributes.intelligence + 2; 
                                }
                        case 2: if (task_type.toString() == "Simple") {
                                        xp = xp + attributes.intelligence + 1 * difficulty;
                                } else {
                                       xp = xp + attributes.intelligence + 2 *difficulty; 
                                }
                        case 3: if (task_type.toString() == "Simple") {
                                        xp = xp + attributes.intelligence + 1 * difficulty;
                                } else {
                                       xp = xp + attributes.intelligence + 2 *difficulty; 
                                }
                }
                check_level_up();
        }

}
