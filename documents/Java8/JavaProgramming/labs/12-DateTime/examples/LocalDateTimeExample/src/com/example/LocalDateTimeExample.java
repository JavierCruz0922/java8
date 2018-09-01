package com.example;

import java.time.LocalDateTime;

import static java.time.Month.AUGUST;
import static java.time.Month.MARCH;
import static java.time.temporal.ChronoUnit.*;
import static java.lang.System.out;
import java.time.LocalDate;
import java.time.LocalTime;


public class LocalDateTimeExample {

  public static void main(String[] args) {
    LocalDateTime meeting, flight, courseStart, courseEnd;
    meeting = LocalDate.of(2019, AUGUST, 21).atTime(13, 30);
    out.println("Meeting is on: " + meeting);
    LocalDate flightDate = LocalDate.of(2014, MARCH, 31);
    LocalTime flightTime = LocalTime.of(21, 45);
    flight = LocalDateTime.of(flightDate, flightTime);
    out.println("Flight leaves: " + flight);
    courseStart = LocalDateTime.of(2018, AUGUST, 27, 8, 0);
    courseEnd = courseStart.plusDays(4).plusHours(7);
    out.println("Course starts: " + courseStart);
    out.println("Course ends:   " + courseEnd); 
    long courseHrs = (courseEnd.getHour() - courseStart.getHour()) * (courseStart.until(courseEnd, DAYS)+1);
    out.println("Course is:     " + courseHrs + " hours long.");

    LocalTime ta = LocalTime.now();
    LocalTime ts = LocalTime.of(14, 55);
    System.out.println("Minutes -> " + MINUTES.between(ta, ts));
  }
  
}
