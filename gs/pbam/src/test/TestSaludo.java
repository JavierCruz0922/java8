package test;

import domain.*;

public class TestSaludo{
	public static void main(String[] args) {
		Saludo sal;

		sal = new Saludo("Bienvenido a JAVA");

		System.out.println(sal.toString());
	}
}