package com.example.taskguild;

public class Avatar {
        public String name;
        public String avatar_picture;
        public int xp;
        public int level;

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


}
