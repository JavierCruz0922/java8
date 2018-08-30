/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author 180827Gpo.Salinas
 */
public class ExampleBuilder {

    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>(Arrays.asList(
                new Person.Builder()
                        .name("Juan")
                        .age(23)
                        .build(),
                new Person.Builder()
                        .name("Jose")
                        .age(18)
                        .build(),
                new Person.Builder()
                        .name("Ramon")
                        .age(37)
                        .build(),
                new Person.Builder()
                        .name("Lorena")
                        .age(31)
                        .build()
        ));
        persons
                .stream()
                .forEach(System.out::println);
        System.out.println("");
        persons
                .stream()
                .filter(person -> person.getAge() > 10)
                .forEach(System.out::println);
        System.out.println("");
        persons
                .stream()
                .filter(person -> person.getName().contains("o"))
                .sorted()
                .forEach(System.out::println);

        Stream.of("Monday", "Tuesday", "Wedensday", "Thursday")
                .filter(s -> s.startsWith("T"))
                .forEach(s -> System.out.println("Matching Days: " + s));
    }
}
