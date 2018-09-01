/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import domain.Banco;
import domain.Cliente;
import domain.Domicilio;
import java.time.LocalDate;

/**
 *
 * @author 180827Gpo.Salinas
 */
public class TestBanco {
    public static void main(String[] args) {
        Banco banco = Banco.getInstance();
        Domicilio dom = new Domicilio("Av. Benito", 123, "Las Palomas", "CDMX", 123);
        Cliente[] clientes = new Cliente[]{
            new Cliente(123, "Juan", "ABCD123456123", LocalDate.of(1992, 06, 01), dom),
            new Cliente(2172, "Hugo", "PORE948556121", LocalDate.of(1982, 10, 11), dom),
            new Cliente(294, "Lorena", "PWOR012956123", LocalDate.of(1972, 05, 19), dom),
            new Cliente(11827, "Julia", "PWOR129346124", LocalDate.of(1986, 01, 28), dom)
        };
        
        banco.altaClientes(clientes);
        banco.report();
        
        
    }
}
