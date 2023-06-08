package fr.epita.assistants.loggingbasics;

import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;
import ch.qos.logback.classic.Level;

import java.util.*;

public class Trombinoscope {
    private final Logger LOGGER;
    private final HashMap<String, Long> map;
    

    public Trombinoscope() {
        // FIXME: Instantiate logger with level TRACE
        LOGGER = (Logger) LoggerFactory.getLogger(Trombinoscope.class);
        LOGGER.setLevel(Level.TRACE);
        LOGGER.trace("Instantiating new Trombinoscope");
        
        // FIXME: Add logging here

        map = new HashMap<>();
    }


    
    String cur;

    public Long putPerson(String name, long photoId) {
        // FIXME: Add logging here
        LOGGER.setLevel(Level.TRACE);
        LOGGER.debug("Putting person (\"" + name + "\", " + photoId + ")");
        if (cur != name)
        {
            cur = name;
            LOGGER.trace("Added entry for person \"" + name + "\"");
        }
        Long oldPhotoId = map.put(name,
                                  photoId);

        // FIXME: Add logging here
        if (oldPhotoId != null)
            LOGGER.trace("Updated entry for person \"" + name + "\"");

        return oldPhotoId;
    }
}
