package test;

import domain.Cliente;
import domain.Domicilio;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class TestDate {
    public static void main(String[] args) {
        Domicilio domicilio = new Domicilio.Builder()
                .calle("Av. Benito Juarez")
                .numero(143)
                .colonia("Atlacomulco")
                .estado("Michoacan")
                .codigoPostal(36251)
                .build();
        ArrayList<Cliente> clientes = new ArrayList<>(Arrays.asList(
                new Cliente.Builder()
                        .numero(123)
                        .nombre("Jose")
                        .fechaNacimiento(LocalDate.of(1992, Month.AUGUST, 2))
                        .rfc("JSMA102938RTM9")
                        .domicilio(domicilio)
                        .build(),
                new Cliente.Builder()
                        .numero(11223)
                        .nombre("Arturo")
                        .fechaNacimiento(LocalDate.of(1982, Month.SEPTEMBER, 15))
                        .rfc("LKER745839RTM9")
                        .domicilio(domicilio)
                        .build(),
                new Cliente.Builder()
                        .numero(984)
                        .nombre("Martha")
                        .fechaNacimiento(LocalDate.of(1962, Month.JANUARY, 27))
                        .rfc("JSMA984738YTR9")
                        .domicilio(domicilio)
                        .build()
        ));

        Consumer<Cliente> formatDate = t -> System.out.println("Date: " + t.getFechaNacimiento());
        clientes.stream().peek(formatDate).forEach(System.out::println);
    }
}
