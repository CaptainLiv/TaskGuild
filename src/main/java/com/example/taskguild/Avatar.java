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
        public int skill_orbs;
        public static final String filepath_profile = "profile.txt";


        public Avatar() {
                
        }
        public Avatar(String name, String head, String bottom, String tops){
                this.name = name;
                this.xp = 0;
                this.level = 1;
                this.xp_needed = 100;
                this.head = head;
                this.bottom = bottom;
                this.tops = tops;
                this.attributes = new Attribut(0,0,0,0,0,0,0);
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
                } catch (IOException e) {
                        System.out.println("An error occurred.");
                        e.printStackTrace();
                }
        }

        public static Avatar load() {
                
                Avatar avatar = new Avatar();
                try(BufferedReader br = new BufferedReader(new FileReader(filepath_profile))) {
                        
                        Gson gson = new Gson();
                        String json = br.readLine();
                        avatar = gson.fromJson(json, Avatar.class);
                }
                catch (IOException e) {
                        e.printStackTrace();
                }
                return avatar;
                    
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
                        double x = xp_needed + xp_needed * 0.25;
                        xp_needed = (int)x;
                        skill_orbs = skill_orbs + 1;
                        if (level % 5 == 0) {
                                skill_orbs = skill_orbs + 2;
                        }
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
