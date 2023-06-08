package fr.epita.assistants.streamstudent;

import org.junit.jupiter.api.Test;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class StreamStudentTest {
    static void assertStreamEquals(Stream<Pair<Integer, String>> expectedStream,
                                   Stream<Pair<Integer, String>> actualStream) {
        // Get iterators from stream
        Iterator<Pair<Integer, String>> iterator1 = expectedStream.iterator();
        Iterator<Pair<Integer, String>> iterator2 = actualStream.iterator();

        while (iterator1.hasNext() && iterator2.hasNext()) {
            // Get next objects
            Pair<Integer, String> login1 = iterator1.next();
            Pair<Integer, String> login2 = iterator2.next();

            // Check if pairs are equal
            assertEquals(login1, login2);
        }

        assertTrue(!iterator1.hasNext() && !iterator2.hasNext(),
                "Streams do not have the same length");

    }

    @Test
    public void validatorLoginContainsTwoOrMoreUnderscore() {
        Pair<Integer, String> loginTwoUnderscore = new Pair<>(50, "xavier_login_");
        Pair<Integer, String> loginValid = new Pair<>(90, "xavier_login");
        Pair<Integer, String> loginMultipleUnderscord = new Pair<>(10, "_login__x");
        Streamer streamer = new Streamer();

        var loginList = List.of(loginTwoUnderscore, loginValid, loginMultipleUnderscord);

        var expected = List.of(loginValid).stream();
        var actual = streamer.validator(loginList.stream());

        assertStreamEquals(expected, actual);
    }

    @Test
    public void orderGrade() {
        Pair<Integer, String> login1 = new Pair<>(2, "zzz_z");
        Pair<Integer, String> login2 = new Pair<>(2, "aaaa_z");
        Pair<Integer, String> login3 = new Pair<>(1, "aaa_z");
        Streamer streamer = new Streamer();

        var loginList = List.of(login1, login2, login3);

        var expected = List.of(login3, login1, login2).stream();
        var actual = streamer.orderGrade(loginList.stream());

        assertStreamEquals(expected, actual);
    }

    @Test
    public void lowercase() {
        Pair<Integer, String> login1 = new Pair<>(10, "abc_a");
        Pair<Integer, String> login2 = new Pair<>(10, "abc_a");
        Streamer streamer = new Streamer();

        var loginList = List.of(login1, login2);

        var expected = List.of(login1, login2).stream();
        var actual = streamer.lowercase(loginList.stream());

        assertStreamEquals(expected, actual);
    }



    @Test
    public void encryption() {
        Pair<Integer, String> login1 = new Pair<>(5, "abc_a");
        Pair<Integer, String> login2 = new Pair<>(15, "abc_b");
        Pair<Integer, String> login3 = new Pair<>(15, "abc_z");
        Streamer streamer = new Streamer();

        var loginList = List.of(login1, login2, login3);

        var expected = List.of(login1, login2, login3).stream();
        var actual = streamer.encryption(loginList.stream());

        assertStreamEquals(expected, actual);
    }

    @Test
    public void quickFix() {
        Pair<Integer, String> login1 = new Pair<>(60, "abc_a");
        Pair<Integer, String> login2 = new Pair<>(60, "mAximu_m");
        Streamer streamer = new Streamer();

        var loginList = List.of(login1, login2);

        var expected = List.of(login1, login2).stream();
        var actual = streamer.quickFix(loginList.stream());

        assertStreamEquals(expected, actual);
    }

    @Test
    public void headOfTheClass() {
        Pair<Integer, String> login1 = new Pair<>(60, "abc_a");
        Pair<Integer, String> login2 = new Pair<>(60, "abc_b");
        Streamer streamer = new Streamer();

        var loginList = List.of(login1, login2);

        var expected = List.of(login1, login2).stream();
        var actual = streamer.headOfTheClass(loginList.stream());

        System.out.println(actual);
    }
}
