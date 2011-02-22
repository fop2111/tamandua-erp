/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo.controle;

import excecao.PessoaisException;
import modelo.dominio.EspeciePagamento;
import persistencia.IFabricaPersistencia;
import persistencia.IGatewayEspeciePagamento;
import persistencia.impl.FabricaPersistencia;

/**
 *
 * @author Marlon
 */
public class ControleEspeciePagamento {

    public void gravarEspeciePagamento(EspeciePagamento especie_pagamento) throws PessoaisException {
        IFabricaPersistencia fabricaPersistencia = new FabricaPersistencia();
        IGatewayEspeciePagamento gatewayEspeciePagamento = fabricaPersistencia.getGatewayEspeciePagamento();
        gatewayEspeciePagamento.gravarEspeciePagamento(especie_pagamento);
    }
}
