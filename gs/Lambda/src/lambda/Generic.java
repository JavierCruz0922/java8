package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Crud<T> {

    private T t;

    public void add(T t, String sp) {
        //do code
    }
    
    public void add(List<T> list, String sp){
        //do code
    }
}

class Employee {

    private String name;

    Employee(String name){
        this.name = name;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

public class Generic {

    public static void main(String[] args) {
        Employee emp = new Employee("Juan");
        List<Employee> listEmployee = Arrays.asList(
            new Employee("Juan"),
            new Employee("Pedro"),
            new Employee("Marco"),
            new Employee("Paola")
        );
        
        Crud<Employee> crud = new Crud();
        crud.add(emp, "schema.insertxml()");
        crud.add(listEmployee, "schema.insertxml()");
    }
}
