package test;

import java.time.LocalTime;
import static java.time.temporal.ChronoUnit.*;

public class TestGeneral {

    public static void main(String[] args) {
        LocalTime ta = LocalTime.now();
        LocalTime ts = LocalTime.of(14,55);
        System.out.println("Minutes -> " + MINUTES.between(ta, ts));
    }
}
