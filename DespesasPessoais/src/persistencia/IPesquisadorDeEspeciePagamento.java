/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package persistencia;

import excecao.PessoaisException;
import java.util.List;
import persistencia.impl.CriterioDePesquisa;

/**
 *
 * @author Marlon
 */
public interface IPesquisadorDeEspeciePagamento {

    void adicionarCriterio(CriterioDePesquisa criterio);

    List realizarPesquisa() throws PessoaisException;

}
