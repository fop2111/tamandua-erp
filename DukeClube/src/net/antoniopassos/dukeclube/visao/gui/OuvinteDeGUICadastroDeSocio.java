/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.antoniopassos.dukeclube.visao.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import net.antoniopassos.dukeclube.excecao.DukeClubeException;
import net.antoniopassos.dukeclube.modelo.controle.ControleSocio;
import net.antoniopassos.dukeclube.modelo.dominio.Socio;

/**
 *
 * @author Marlon
 */
public class OuvinteDeGUICadastroDeSocio {

    private GUICadastroDeSocio guiCadastroDeSocio;

    public OuvinteDeGUICadastroDeSocio(GUICadastroDeSocio guiCadastroDeSocio) {
        this.guiCadastroDeSocio = guiCadastroDeSocio;
        guiCadastroDeSocio.bGravarSocioAddActionListener(new OuvinteGravarSocio());
    }



    class OuvinteGravarSocio implements ActionListener {
       public void actionPerformed(ActionEvent e) {
         Socio socio;
         try {
            socio = guiCadastroDeSocio.getSocio();
            ControleSocio controle = new ControleSocio();
            controle.gravarSocio(socio);
            GUIMensagem.exibirMensagem("Sócio gravado com sucesso!", "DukeClube - Sócio", false);
            guiCadastroDeSocio.limparCampos();
            } catch (DukeClubeException ex) {
                GUIMensagem.exibirMensagem(ex.getMessage(), "DukeClube - Sócio", true);
              }
       }
    }

}
