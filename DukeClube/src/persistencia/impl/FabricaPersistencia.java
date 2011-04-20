/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package persistencia.impl;

import persistencia.IFabricaPersistencia;
import persistencia.IGatewaySocio;

/**
 *
 * @author Marlon
 */
public class FabricaPersistencia implements IFabricaPersistencia {

    public IGatewaySocio getGatewaySocio() {
        return new GatewaySocio();
    }

}
