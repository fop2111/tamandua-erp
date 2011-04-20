/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package persistencia;

import net.antoniopassos.dukeclube.excecao.DukeClubeException;
import net.antoniopassos.dukeclube.modelo.dominio.Socio;

/**
 *
 * @author Marlon
 */
public interface IGatewaySocio {

   public abstract void gravarSocio(Socio socio) throws DukeClubeException;

}
