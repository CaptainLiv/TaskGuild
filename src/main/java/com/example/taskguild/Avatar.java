package com.example.taskguild;

import java.io.*;

public class Avatar {
        public String name;
        public String avatar_picture;
        public int xp;
        public int level;
        public static final String filepath_profile = "profile.txt";

        public Avatar(String name, String avatar_picture){
                this.name = name;
                this.avatar_picture = avatar_picture;
                this.xp = 0;
                this.level = 0;
        }
        public Avatar(String name, String avatar_picture, int xp, int level){
                this.name = name;
                this.avatar_picture = avatar_picture;
                this.xp = xp;
                this.level = level;
        }

        @Override
        public String toString() {
                return "Avatar{" +
                        "name='" + name + '\'' +
                        ", avatar_picture='" + avatar_picture + '\'' +
                        ", xp=" + xp +
                        ", level=" + level +
                        '}';
        }

        public static void save(Avatar avatar) {
               try {
                FileOutputStream f = new FileOutputStream(filepath_profile);
                ObjectOutputStream o = new ObjectOutputStream(f);

                 o.writeObject(avatar);

                 o.close();
                 f.close();
               } 
               catch(IOException e) {
                        e.printStackTrace();
                        System.out.println("Error");
               }
        }

        public void level_up() {
                
        }

        public void task_completed() {

        }

}
