/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio;

import domain.Cuenta;
import java.util.ArrayList;

/**
 *
 * @author 180827Gpo.Salinas
 */
public interface ServicioACuentas {
    void cancelarCuenta(int numero);
    Cuenta consultarCuenta(int numero);
    ArrayList<Cuenta> consultarCuentasClientes();
    void crearCuentaDeAhorros(double saldoInicial, double tasaDeInteresAnual);
    void crearCuentaDeCheques(double saldoInicial, double comisionMensual);
}
