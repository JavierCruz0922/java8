package test;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

class Person implements Serializable{
        private String nombre;
        private int edad;
        private transient String password;

    public Person(String nombre, int edad, String password) {
        this.nombre = nombre;
        this.edad = edad;
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return getEdad() == person.getEdad() &&
                Objects.equals(getNombre(), person.getNombre()) &&
                Objects.equals(getPassword(), person.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNombre(), getEdad(), getPassword());
    }

    @Override
    public String toString() {
        return "Person{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", password='" + password + '\'' +
                '}';
    }
}

public class TestIO {
    public static void main(String[] args) throws Exception{
        ArrayList<Person> personsO = new ArrayList<>(Arrays.asList(
                new Person("Jose", 12, "password"),
                new Person("Rernanda", 23, "123"),
                new Person("Luis", 18, "admin")
        ));

        String fio = "Sal.dat";

        //Read List
        FileOutputStream fos = new FileOutputStream(fio);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(personsO);
        oos.close();

        //Write List
        FileInputStream fis = new FileInputStream(fio);
        ObjectInputStream ois = new ObjectInputStream(fis);
        ArrayList<Person> personsI = (ArrayList<Person>) ois.readObject();
        personsI.forEach(System.out::println);
    }
}
