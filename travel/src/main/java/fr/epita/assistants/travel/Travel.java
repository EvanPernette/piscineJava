package fr.epita.assistants.travel;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class Travel {
    
    public static void travelTo(Country source, Country destination) {
    ZoneId sourceZone = source.countryZone;
    ZoneId destinationZone = destination.countryZone;
    if (source.getTravelTimes(source, destination) == null) {
        ZonedDateTime sourceTime = ZonedDateTime.now(sourceZone);
        ZonedDateTime destinationTime = sourceTime.withZoneSameInstant(destinationZone);
        System.out.println("Boarding in " + source.countryName + ", local date and time is: " + sourceTime.format(DateTimeFormatter.RFC_1123_DATE_TIME));
        System.out.println("Landing in " + destination.countryName + ", local date and time on arrival will be: " + destinationTime.format(DateTimeFormatter.RFC_1123_DATE_TIME));
        return;
    }
    int timeDifference = Integer.parseInt(source.getTravelTimes(source, destination));
    ZonedDateTime sourceTime = ZonedDateTime.now(sourceZone);
    ZonedDateTime destinationTime = sourceTime.plusHours(timeDifference).withZoneSameInstant(destinationZone);
    System.out.println("Boarding in " + source.countryName + ", local date and time is: " + sourceTime.format(DateTimeFormatter.RFC_1123_DATE_TIME));
    System.out.println("Landing in " + destination.countryName + ", local date and time on arrival will be: " + destinationTime.format(DateTimeFormatter.RFC_1123_DATE_TIME));
}
}