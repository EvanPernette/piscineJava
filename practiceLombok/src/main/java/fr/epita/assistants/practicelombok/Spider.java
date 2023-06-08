package fr.epita.assistants.practicelombok;

import lombok.*;

@Getter
@Setter
public class Spider{
    public String name;
    public Spider(String name){
        this.name = name;
    }
}
