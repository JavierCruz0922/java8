/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.time.LocalDateTime;

/**
 *
 * @author 180827Gpo.Salinas
 */
public class SaldoInsuficienteException extends Exception{
    
    private LocalDateTime fecha;
    private String descripcionProblema;        
}
