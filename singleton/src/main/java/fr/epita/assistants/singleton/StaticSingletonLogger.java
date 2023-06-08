package fr.epita.assistants.singleton;

import fr.epita.assistants.logger.Logger;

public class StaticSingletonLogger implements Logger {
    private static class InstanceHolder {
        private static final StaticSingletonLogger _INSTANCE = new StaticSingletonLogger();
      }
      
      public static StaticSingletonLogger getInstance() {
        return InstanceHolder._INSTANCE;
      }

    private int infoCounter;
    private int warnCounter;
    private int errorCounter;
      
      @Override
      public void log(Level level, String message) {
        switch (level) {
          case INFO:
            System.err.println("[INFO] " + message);
            infoCounter++;
            break;
          case WARN:
            System.err.println("[WARN] " + message);
            warnCounter++;
            break;
          case ERROR:
            System.err.println("[ERROR] " + message);
            errorCounter++;
            break;
        }
      }

      private StaticSingletonLogger() {
        this.infoCounter = 0;
        this.warnCounter = 0;
        this.errorCounter = 0;
      }
      
      @Override
      public int getInfoCounter() {
        return infoCounter;
      }
      
      @Override
      public int getWarnCounter() {
        return warnCounter;
      }
      
      @Override
      public int getErrorCounter() {
        return errorCounter;
      }
      
      @Override
      public void reset() {
        infoCounter = 0;
        warnCounter = 0;
        errorCounter = 0;
      }
    }
    
