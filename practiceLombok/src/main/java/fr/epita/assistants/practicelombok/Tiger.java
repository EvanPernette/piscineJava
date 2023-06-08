package fr.epita.assistants.practicelombok;

import lombok.*;

@Getter
@Setter
@ToString
public class Tiger {
    public String name;
    public String nickname;
    public Tiger(String name, String nickname){
        this.name = name;
        this.nickname = nickname;
    }
    public Tiger(){
    }
}
