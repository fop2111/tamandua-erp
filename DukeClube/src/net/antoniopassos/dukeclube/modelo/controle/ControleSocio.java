/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.antoniopassos.dukeclube.modelo.controle;

import net.antoniopassos.dukeclube.excecao.DukeClubeException;
import net.antoniopassos.dukeclube.modelo.dominio.Socio;
import persistencia.IFabricaPersistencia;
import persistencia.IGatewaySocio;
import persistencia.impl.FabricaPersistencia;

/**
 *
 * @author Marlon
 */
public class ControleSocio {

    public void gravarSocio(Socio socio) throws DukeClubeException {
      IFabricaPersistencia fabricaPersistencia = new FabricaPersistencia();
      IGatewaySocio gatewaySocio = fabricaPersistencia.getGatewaySocio();
      gatewaySocio.gravarSocio(socio);
    }
}
