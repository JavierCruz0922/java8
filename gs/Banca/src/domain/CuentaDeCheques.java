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
public class CuentaDeCheques extends Cuenta{
    
    private double costoManejoMensual;
    
    public CuentaDeCheques(int numero, double saldo, double costoManejoMensual) {
        super(numero, saldo);
        this.costoManejoMensual = costoManejoMensual;
    }

    @Override
    public String toString() {
        return "CuentaDeCheques{" + "costoManejoMensual=" + costoManejoMensual + '}';
    }
}
