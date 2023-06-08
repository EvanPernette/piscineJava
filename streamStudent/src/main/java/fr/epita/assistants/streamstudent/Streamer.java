package fr.epita.assistants.streamstudent;

import java.util.Optional;
import java.util.stream.Stream;


public class Streamer {
    
    public Stream<Pair<Integer, String>> validator(Stream<Pair<Integer, String>> stream) {
        return stream.filter(pair -> {
            String login = pair.getValue();
            Integer grade = pair.getKey();
            if (grade < 0 || grade > 100) {
                return false;
            }
            int underscoreCount = 0;
            int dotCount = 0;
            for (int i = 0; i < login.length(); i++) {
                if (login.charAt(i) == '_') {
                    underscoreCount++;
                }
                if (login.charAt(i) == '.') {
                    dotCount++;
                }
            }
            return (underscoreCount == 1 && dotCount == 0) || (underscoreCount == 0 && dotCount == 1);
        });
    }
    
    public Stream<Pair<Integer, String>> orderGrade(Stream<Pair<Integer, String>> stream) {
        return stream.sorted((pair1, pair2) -> {
            int gradeCmp = Integer.compare(pair1.getKey(), pair2.getKey());
            return gradeCmp != 0 ? gradeCmp : pair1.getValue().compareTo(pair2.getValue());
        });
    }
    
    public Stream<Pair<Integer, String>> lowercase(Stream<Pair<Integer, String>> stream) {
        return stream.map(pair -> {
            String login = pair.getValue();
            Integer a = pair.getKey();
            for (int i = 0; i < login.length(); i++) {
                if (login.charAt(i) >= 'A' && login.charAt(i) <= 'Z') {
                    a /= 2;
                    break;
                }
            }
            return new Pair<>(a, login.toLowerCase());
        });
    }
    
    public Optional<Pair<Integer, String>> headOfTheClass(Stream<Pair<Integer, String>> stream) {
        return stream.max((pair1, pair2) -> {
            int gradeCmp = Integer.compare(pair1.getKey(), pair2.getKey());
            return gradeCmp != 0 ? gradeCmp : pair2.getValue().compareTo(pair1.getValue());
        });
    }
    
    public Stream<Pair<Integer, String>> quickFix(Stream<Pair<Integer, String>> stream) {
        return stream.map(pair -> {
            String login = pair.getValue();
            Integer grade = pair.getKey();
            if (login.toLowerCase().startsWith("ma")) {
                grade *= 2;
            } else if (login.toLowerCase().startsWith("l") && login.toLowerCase().endsWith("x")) {
                grade *= 2;
            }
            if (grade > 100) {
                grade = 100;
            }
            return new Pair<>(grade, login);
        });
    }
    
    public Stream<Pair<Integer, String>> encryption(Stream<Pair<Integer, String>> stream) {
        return stream.map(pair -> {
            String login = pair.getValue();
            Integer grade = pair.getKey();
            int half = login.length() / 2;
            String firstHalf = login.substring(0, half);
            String secondHalf = login.substring(half);
            String newLogin = secondHalf + firstHalf;
            return new Pair<>(grade, newLogin);
        });
    }
    
}