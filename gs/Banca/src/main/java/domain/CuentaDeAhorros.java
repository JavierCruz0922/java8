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
public class CuentaDeAhorros extends Cuenta{
    
    private double tasaInteresAnual;
    
    public CuentaDeAhorros(int numero, double saldo, double tasaInteresAnual) {
        super(numero, saldo);
        this.tasaInteresAnual = tasaInteresAnual;
    }
    
    public void calcularInteres(){}

    @Override
    public String toString() {
        return "CuentaDeAhorros{" + "tasaInteresAnual=" + tasaInteresAnual + '}';
    }
    
    
    
}
