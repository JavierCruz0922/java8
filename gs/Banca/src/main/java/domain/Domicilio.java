/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author 180827Gpo.Salinas
 */
public class Domicilio {

    private int numero;
    private String calle;
    private String colonia;
    private String estado;
    private int codigoPostal;

    public static class Builder{
        private String calle = "";
        private int numero = -1;
        private String colonia = "";
        private String estado = "";
        private int codigoPostal = 0;

        public Domicilio.Builder calle(String calle){
            this.calle = calle;
            return this;
        }

        public Domicilio.Builder numero(int numero){
            this.numero = numero;
            return this;
        }

        public Domicilio.Builder colonia(String colonia){
            this.colonia = colonia;
            return this;
        }

        public Domicilio.Builder estado(String estado){
            this.estado = estado;
            return this;
        }

        public Domicilio.Builder codigoPostal(int codigoPostal){
            this.codigoPostal = codigoPostal;
            return this;
        }

        public Domicilio build(){ return new Domicilio(this); }
    }

    private Domicilio(){ super(); }

    private Domicilio(Domicilio.Builder builder){
        this.calle = builder.calle;
        this.numero = builder.numero;
        this.colonia = builder.colonia;
        this.estado = builder.estado;
        this.codigoPostal = builder.codigoPostal;
    }

    public Domicilio(String calle, int numero, String colonia, String estado, int codigoPostal) {
        this.calle = calle;
        this.numero = numero;
        this.colonia = colonia;
        this.estado = estado;
        this.codigoPostal = codigoPostal;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    @Override
    public String toString() {
        return numero + " " + calle + " " + colonia + " " + estado + " " + codigoPostal;
    }
}
