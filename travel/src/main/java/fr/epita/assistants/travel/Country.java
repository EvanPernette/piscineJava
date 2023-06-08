package fr.epita.assistants.travel;

import java.io.FileReader;
import java.io.IOException;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.Map;

import com.opencsv.*;

public class Country {
    String countryName;
    ZoneId countryZone;
    String inputFilePath;
    public Map<String, Integer> travelTimes;
    public Country(String countryName, String countryZone, String inputFilePath)
    {
        this.countryName = countryName;
        this.countryZone = ZoneId.of(countryZone);
        this.inputFilePath = inputFilePath;
        this.travelTimes = initTravelTimes(inputFilePath);
    }

    public Map<String, Integer> initTravelTimes(String inputFilePath) {
		Map<String, Integer> travelTimes = new HashMap<>();
        try {
            CSVReader reader = new CSVReader(new FileReader(inputFilePath));
            
            String[] line;
            while ((line = reader.readNext()) != null) {
                if (line[0].equals(this.countryName)  ) {
                    travelTimes.put(line[1], Integer.parseInt(line[2]));
                }
                if (line[1].equals(this.countryName)  ) {
                    travelTimes.put(line[0], Integer.parseInt(line[2]));
                }
            }
        } catch (Exception e) {
        }
        return travelTimes;	
	}

    public String getTravelTimes(Country source, Country destination)
    {
        String travelTimes = "{";
        try {
            CSVReader reader = new CSVReader(new FileReader(this.inputFilePath));
            String[] line;
            while ((line = reader.readNext()) != null) {
                if (line[0].equals(source.countryName) && line[1].equals(destination.countryName)) {
                    return line[2];
                }
            }
        } catch (Exception e) {
        }
        if (travelTimes.equals("{")) {
            return null;
        }
        travelTimes += "}";
        
        return travelTimes;
    }
}