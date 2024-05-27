package com.example.taskguild;

import java.io.*;
import java.nio.file.Files;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

import com.example.taskguild.Todo.Type;
import com.google.gson.Gson;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Avatar {
        public String name;
        public String head;
        public String bottom;
        public String tops;
        public Attribut attributes;
        public int xp;
        public Boolean tutorial =false;
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
                this.skill_orbs = 0;
                this.head = head;
                this.bottom = bottom;
                this.tops = tops;
                this.attributes = new Attribut(0,0,0,0,0,0,0);
        }
        public Avatar(String name, int xp, int level, String head, String bottom, String tops, Attribut attributes, int skill_orbs){
                this.name = name;
                this.xp = xp;
                this.level = level;
                this.head = head;
                this.bottom = bottom;
                this.tops = tops;
                this.attributes = attributes;
                this.skill_orbs = skill_orbs;
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

                System.out.println(xp + " XP Needed:" + xp_needed);
                if (xp >= xp_needed) {
                        System.out.println("oask");
                        if (xp - xp_needed > 0)
                        {
                                System.out.println("HALLO");
                                xp = xp- xp_needed;
                        } 
                        else {
                                System.out.println("else");
                                xp = 0;
                        }
                        level = level + 1;
                        System.out.println("lvl  " + level);
                        double x = xp_needed + xp_needed * 0.25;
                        xp_needed = (int)x;
                        skill_orbs = skill_orbs + 1;
                        if (level % 5 == 0) {
                                skill_orbs = skill_orbs + 2;
                        }
                        Controller_standard_view.get_skillorbs(skill_orbs);
                        File file = new File("src/main/resources/com/example/taskguild/musik/Level_UP_Sound.mp3");
                        Media media = new Media(file.toURI().toString());
                        MediaPlayer mp = new MediaPlayer(media);
                        mp.setVolume(0.2);
                        mp.play();
                }

        }

        public void task_completed(int difficulty, Type task_type, String time, int minutes, int hours) {
                
                switch(task_type.ordinal()) {
                        //Normal
                        case 0: xp = xp + 10 + 5 * difficulty;
                        //Daily
                        case 1: xp = xp + 10 + 5 * difficulty;
                        //Time
                        case 2: String[] x = time.split(":");
                                int start_hours = Integer.parseInt(x[0]);
                                int start_minutes = Integer.parseInt(x[1]);

                                LocalTime endtime = LocalTime.now();
                                endtime = endtime.minusHours(start_hours);
                                endtime = endtime.minusMinutes(start_minutes);

                                String[] y = endtime.toString().split(":");
                                int end_hours = Integer.parseInt(x[0]);
                                int end_minutes = Integer.parseInt(x[1]);
                                int needed_minutes = end_hours * 60 + end_minutes;
                                int expected_minutes = minutes + hours * 60;

                                if (expected_minutes - needed_minutes > 0) {

                                        xp = xp + expected_minutes + (expected_minutes - needed_minutes);
                                }
                                else {
                                        xp = xp + expected_minutes;
                                }

                                
                }
                check_level_up();
        }

}
