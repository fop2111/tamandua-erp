/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package persistencia;

import excecao.PessoaisException;
import modelo.dominio.EspeciePagamento;

/**
 *
 * @author Marlon
 */
public interface IGatewayEspeciePagamento {
   public abstract void gravarEspeciePagamento(EspeciePagamento especie_pagamento) throws PessoaisException;
   public abstract void excluirEspeciePagamento(EspeciePagamento especiepagamento) throws PessoaisException;
}

