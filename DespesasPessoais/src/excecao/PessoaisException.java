/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package excecao;

/**
 *
 * @author Marlon
 */
public class PessoaisException extends Exception{

    public PessoaisException() {
        super("Causa do erro: Desconhecida");
    }

    public PessoaisException(String message) {
        super(message);
    }


   
}
