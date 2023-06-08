package fr.epita.assistants;

import fr.epita.assistants.travel.Country;
import fr.epita.assistants.travel.Travel;

public class Main {
    public static void main(String[] args) {
        Country fr = new Country("France", "Europe/Paris", "src/main/resources/travel_times.csv");
        System.out.println(fr.travelTimes);
    }
}
