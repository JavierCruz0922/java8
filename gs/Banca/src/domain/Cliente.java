/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author 180827Gpo.Salinas
 */
public class Cliente {

    private int numero;
    private String nombre;
    private Domicilio domicilio;
    private LocalDate fechaNacimiento;
    private String rfc;
    private ArrayList<Cuenta> cuentas;

    public Cliente(int numero, String nombre, Domicilio domicilio, String rfc, int diaNac, int mesNac, int anioNac) {
        if (nombre != null && domicilio != null) {
            this.numero = numero;
            this.nombre = nombre;
            this.domicilio = domicilio;
            this.rfc = rfc;
        }
    }

    public ArrayList<Cuenta> getCuentas() {
        return cuentas;
    }

    public void setCuentas(ArrayList<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        if (domicilio != null) {
            this.domicilio = domicilio;
        }
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        if (fechaNacimiento != null) {
            this.fechaNacimiento = fechaNacimiento;
        }
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        if (rfc != null && rfc.trim().length() >= 13) {
            this.rfc = rfc;
        }
    }

    @Override
    public String toString() {
        return numero + " " + nombre + " " + domicilio + " " + fechaNacimiento + " " + rfc;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + this.numero;
        hash = 79 * hash + Objects.hashCode(this.nombre);
        hash = 79 * hash + Objects.hashCode(this.domicilio);
        hash = 79 * hash + Objects.hashCode(this.fechaNacimiento);
        hash = 79 * hash + Objects.hashCode(this.rfc);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        if (this.numero != other.numero) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.rfc, other.rfc)) {
            return false;
        }
        if (!Objects.equals(this.domicilio, other.domicilio)) {
            return false;
        }
        if (!Objects.equals(this.fechaNacimiento, other.fechaNacimiento)) {
            return false;
        }
        return true;
    }
    
    

    //Metodos negocio
    public void addCuenta(Cuenta nuevaCuenta) {
        this.cuentas.add(nuevaCuenta);
    }

    public void delCuenta(Cuenta cuenta) {
        this.cuentas.remove(cuenta);
    }

    public void crearCuentaDeAhorros(double saldoInicial, double tasaDelinteresAnual) {
    }

    public void crearCuentaDeCheques() {
    }
   
}
