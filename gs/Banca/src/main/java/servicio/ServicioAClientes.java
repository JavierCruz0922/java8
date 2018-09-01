/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio;

import domain.Cliente;
import utilities.ClienteNoExisteException;

/**
 *
 * @author 180827Gpo.Salinas
 */
public interface ServicioAClientes {
    void altaCliente(Cliente cliente);
    void altaClientes(Cliente[] clientes);
    void bajaCliente(int numero) throws ClienteNoExisteException;
    void actualizarDatosCliente(Cliente cliente) throws ClienteNoExisteException;
    Cliente consultarCliente(int numero) throws ClienteNoExisteException;
}
