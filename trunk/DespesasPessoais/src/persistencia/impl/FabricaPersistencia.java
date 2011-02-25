/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package persistencia.impl;

import persistencia.IFabricaPersistencia;
import persistencia.IGatewayEspeciePagamento;
import persistencia.IPesquisadorDeEspeciePagamento;

/**
 *
 * @author Marlon
 */
public class FabricaPersistencia implements IFabricaPersistencia {

    public IGatewayEspeciePagamento getGatewayEspeciePagamento() {
        return new GatewayEspeciePagamento();
    }

    public IPesquisadorDeEspeciePagamento getPesquisadorDeEspeciePagamento() {
      return new PesquisadorDeEspeciePagamento();
    }
}
