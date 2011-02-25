/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo.controle;

import excecao.PessoaisException;
import java.util.List;
import modelo.dominio.EspeciePagamento;
import persistencia.IFabricaPersistencia;
import persistencia.IGatewayEspeciePagamento;
import persistencia.IPesquisadorDeEspeciePagamento;
import persistencia.impl.CriterioDePesquisa;
import persistencia.impl.FabricaPersistencia;
import persistencia.impl.CriterioDePesquisaContem;

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

    private IPesquisadorDeEspeciePagamento pesquisador;


    public void adicionarCriterioDePesquisaIgualA(String campo, int valor) {
       if (this.pesquisador == null) {
           this.criarPesquisador();
       }
       pesquisador.adicionarCriterio(CriterioDePesquisa.igualA(campo, valor));
    }

    public void adicionarCriterioDePesquisaContem(String campo, String valor) {
       if (this.pesquisador == null) {
           this.criarPesquisador();
       }
       pesquisador.adicionarCriterio(CriterioDePesquisaContem.contem(campo, valor));
    }

    public List realizarPesquisa() throws PessoaisException {
       if (this.pesquisador == null) {
       this.criarPesquisador();
       }
       return pesquisador.realizarPesquisa();
    }

    private void criarPesquisador() {
       IFabricaPersistencia fabricaPersistencia = new FabricaPersistencia();
       this.pesquisador = fabricaPersistencia.getPesquisadorDeEspeciePagamento();
    }
}
