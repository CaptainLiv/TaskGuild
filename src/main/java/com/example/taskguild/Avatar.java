package com.example.taskguild;

import java.io.*;
import java.nio.file.Files;

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
        //        try {
        //         FileOutputStream f = new FileOutputStream(filepath_profile);
        //         ObjectOutputStream o = new ObjectOutputStream(f);

        //          o.writeObject(avatar);
        //          o.writeUTF("TEST");

        //          o.close();
        //          f.close();
        //        } 
        //        catch(IOException e) {
        //                 e.printStackTrace();
        //                 System.out.println("Error");
        //        }
        try {
                FileWriter myWriter = new FileWriter(filepath_profile);
                myWriter.write(avatar.name +"," + avatar.avatar_picture + "," + avatar.level + "," + avatar.xp);
                myWriter.close();
                System.out.println("Successfully wrote to the file.");
              } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
              }
        }

        public static void load() {
                try(BufferedReader br = new BufferedReader(new FileReader(filepath_profile))) {
                        
                        String line = br.readLine();
                        String[] array =  line.split(",");
                        Avatar avatar = new Avatar(array[0], array[1], Integer.parseInt(array[2]), Integer.parseInt(array[3]));
                        System.out.println(avatar.toString());
                        

                    }
                    catch (IOException e) {
                        e.printStackTrace();
                    }

        }

        public void level_up() {
                
        }

        public void task_completed() {

        }

}
