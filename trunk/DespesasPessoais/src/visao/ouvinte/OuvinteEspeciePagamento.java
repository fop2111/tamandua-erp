/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package visao.ouvinte;

import excecao.PessoaisException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.controle.ControleEspeciePagamento;
import modelo.dominio.EspeciePagamento;
import visao.gui.GUICadastroEspeciePagamento;
import visao.gui.GUIMensagem;

/**
 *
 * @author Marlon
 */
public class OuvinteEspeciePagamento {
  private GUICadastroEspeciePagamento guiCadastroEspeciePagamento;

    public OuvinteEspeciePagamento(GUICadastroEspeciePagamento guiCadastroEspeciePagamento) {
        this.guiCadastroEspeciePagamento = guiCadastroEspeciePagamento;
        guiCadastroEspeciePagamento.bGravarEspeciePagamentoAddActionListener(new OuvinteGravarEspeciePagamento());
    }



      class OuvinteGravarEspeciePagamento implements ActionListener {
        public void actionPerformed(ActionEvent e) {
          EspeciePagamento especiepagamento;
          try {
               especiepagamento = guiCadastroEspeciePagamento.getEspeciePagamento();
               ControleEspeciePagamento controle = new ControleEspeciePagamento();
               controle.gravarEspeciePagamento(especiepagamento);
               GUIMensagem.exibirMensagem("Especie gravado com sucesso!", "Despesas especie pagamento", false);
               guiCadastroEspeciePagamento.limparCampos();
               } catch (PessoaisException ex) {
                    GUIMensagem.exibirMensagem(ex.getMessage(), "Despesas - Espécie Pagamento", true);
            }
        }
     }

}
