package fr.epita.assistants;

import fr.epita.assistants.json.Json;

public class Main {
    public static void main(String[] args) {
        Json.addToJson("foo", "bar", "res.json");
        Json.addToJson("ser", "val", "res.json");
        Json.addToJson("ya", "ka", "res.json");
        
        
    }
}
