/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package persistencia.impl;

/**
 *
 * @author Marlon
 */
public class CriterioDePesquisaContem extends CriterioDePesquisa{

    public CriterioDePesquisaContem(String nomeDoCampo, String valor) {
      super(nomeDoCampo, valor);
    }

    public String gerarSQL (){
      return "UPPER (" + this.campo + ") LIKE UPPER ('%" + this.valor + "%')";
    }
}
