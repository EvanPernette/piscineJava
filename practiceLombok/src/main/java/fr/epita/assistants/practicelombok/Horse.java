package fr.epita.assistants.practicelombok;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode(of = {"name", "nickname"})
public class Horse {
    private String name;
    private String nickname;
    private int speed;
    public Horse(String name, String nickname, int speed){
        this.name = name;
        this.nickname = nickname;
        this.speed = speed;
    }
    public Horse(){
        this.name = null;
        this.nickname = null;
        this.speed = 0;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getNickname(){
        return nickname;
    }
    public void setNickname(String nickname){
        this.nickname = nickname;
    }
    public int getSpeed(){
        return speed;
    }
    public String toString(){
        return "Horse(name=" + this.name + ", speed=" + this.speed + ")";
    }
}
