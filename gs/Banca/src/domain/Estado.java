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
public enum Estado {
    ABIERTA("Cuenta abierta."),
    CERRADA("Cuenta cerrada."),
    CONGELADA("Sin movimiento en la tarjeta."),
    SOBREGIRADAD("Cuenta con demasiados cargos.");
    
    private final String descripcion;
    
    Estado(String descripcion){
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
