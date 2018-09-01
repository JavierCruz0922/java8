package com.company;

import java.time.Duration;
import java.time.LocalTime;

public class Main {

    public static void main(String[] args) {
	// write your code here
        var men = "hello!";
        System.out.println(men);

        LocalTime t2 = LocalTime.now();
        LocalTime t1 = LocalTime.now();
        System.out.println("Tiempo: " + Duration.between(t1, t2));
    }
}
