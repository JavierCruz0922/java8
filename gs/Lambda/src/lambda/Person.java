/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lambda;

/**
 *
 * @author 180827Gpo.Salinas
 */
public class Person implements Comparable<Person>{
    private String name;
    private int age;

    @Override
    public int compareTo(Person t) {
        return -t.getName().compareTo(this.getName());
    }
    
    public static class Builder{
        private String name = "";
        private int age = 0;
        
        public Person.Builder name (String name){
            this.name = name;
            return this;
        }
        
        public Person.Builder age (int age){
            this.age = age;
            return this;
        }
        
        public Person build(){
            return new Person(this);
        }  
    }

    private Person(){
        super();
    }
    
    private Person(Person.Builder builder){
        this.name = builder.name;
        this.age = builder.age;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return name + " " + age;
    }
    
    
    
}
