/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package persistencia.impl;

/**
 *
 * @author Marlon
 */
public class CriterioDePesquisa {
  
   protected String operadorSQl;
   protected String campo;
   protected Object valor;

    public CriterioDePesquisa(String operadorSQl, String campo, Object valor) {
        this.operadorSQl = operadorSQl;
        this.campo = campo;
        this.valor = valor;
    }

   protected CriterioDePesquisa(String nomeDoCampo, Object valor){
       this.campo = nomeDoCampo;
       this.valor = valor;
   }

   public static CriterioDePesquisa igualA(String nomeDoCampo, int valor){
       return CriterioDePesquisa.igualA(nomeDoCampo, new Integer(valor));
   }

   public static CriterioDePesquisa igualA(String nomeDoCampo, Object valor){
      return new CriterioDePesquisa("=", nomeDoCampo, valor);
   }
   public static CriterioDePesquisa contem(String nomeDoCampo, String valor){
     return new CriterioDePesquisaContem(nomeDoCampo, valor);
   }

   public String gerarSQL(){
     return campo + operadorSQl + valor;
   }
}
