/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.antoniopassos.dukeclube.excecao;

/**
 *
 * @author Marlon
 */
public class DukeClubeException extends Exception {

    public DukeClubeException() {
       super("Causa do erro: Desconhecida");
    }

    public DukeClubeException(String message) {
        super(message);
    }




}
