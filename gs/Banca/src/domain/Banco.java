/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author 180827Gpo.Salinas
 */
public class Banco {

    private Banco banco;
    private String nombre;
    private Domicilio domicilio;
    private String rfc;
    private String telefono;
    private ArrayList<Cliente> clientes;
    
    private static final Banco INSTANCE = new Banco(
        "Banco De Mexico", 
            new Domicilio(
                "Av. Benito Juarez",
                "132",
                "Las Palmas",
                "Estado de Mexico",
                12345), 
        "BANMEX01234TM",
        "+52(55)123-4567");
    
    private Banco(String nombre, Domicilio domicilio, String rfc, String telefono) {
        if (domicilio != null) {
            this.nombre = nombre;
            this.domicilio = domicilio;
            this.rfc = rfc;
            this.telefono = telefono;
        }
    }
    
    public static Banco getInstance(){
        return INSTANCE;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
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
        this.domicilio = domicilio;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        if (rfc != null && rfc.trim().length() >= 13) {
            this.rfc = rfc;
        }
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    @Override
    public String toString() {
        return banco + " " + nombre + " " + domicilio + " " + rfc + " " + telefono;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(this.banco);
        hash = 47 * hash + Objects.hashCode(this.nombre);
        hash = 47 * hash + Objects.hashCode(this.domicilio);
        hash = 47 * hash + Objects.hashCode(this.rfc);
        hash = 47 * hash + Objects.hashCode(this.telefono);
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
        final Banco other = (Banco) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.rfc, other.rfc)) {
            return false;
        }
        if (!Objects.equals(this.telefono, other.telefono)) {
            return false;
        }
        if (!Objects.equals(this.banco, other.banco)) {
            return false;
        }
        if (!Objects.equals(this.domicilio, other.domicilio)) {
            return false;
        }
        return true;
    }

    //Method
    public void altaCliente(Cliente cliente) {
        this.clientes.add(cliente);
    }
}
