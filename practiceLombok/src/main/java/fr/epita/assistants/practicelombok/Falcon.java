package fr.epita.assistants.practicelombok;

import lombok.EqualsAndHashCode;



@EqualsAndHashCode(of = {"name", "nickname", "speed"})
public class Falcon {
    String name = null;
    String nickname = null;
    int speed = 0;
    public Falcon(){
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

    public void setSpeed(int speed){
        this.speed = speed;
    }
    public String toString(){
        return "Falcon(name=" + name + ", nickname=" + nickname + ", speed=" + speed + ")";
    }
}
