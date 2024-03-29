/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package visao.ouvinte;

import excecao.PessoaisException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import modelo.controle.ControleEspeciePagamento;
import modelo.dominio.EspeciePagamento;
import visao.gui.GUIMensagem;
import visao.gui.GUITemplatePai;

/**
 *
 * @author Marlon
 */
public class OuvinteDeTemplatePai {
    private GUITemplatePai guiTemplatePai;


    class OuvintePesquisarEspeciePagamento implements ActionListener {

        public void actionPerformed(ActionEvent e) {
        try {
               ControleEspeciePagamento controle = new ControleEspeciePagamento();
               String descricao = guiTemplatePai.getDescricao();
            

               if (descricao != null && !descricao.trim().equals("")) {

                  controle.adicionarCriterioDePesquisaContem("descricao", descricao);
               }
               List especiepagamento = controle.realizarPesquisa();
           
              // if(especiepagamento.size() > 0){
                 guiTemplatePai.exibirEspeciePagamento(especiepagamento);
               //} else {
               //       StringBuffer mensagem = new StringBuffer();
               //       mensagem.append("Não há especie cadastradas que");
               //       mensagem.append("\natendam ao critério informado.");
               //       GUIMensagem.exibirMensagem(mensagem.toString(), "Cadastro de especie pagamento", true);
               //}
            } catch (PessoaisException ex) {
                    GUIMensagem.exibirMensagem(ex.getMessage(), "DukeClube - Sócios", true);
               }
        }
    }

    public OuvinteDeTemplatePai(GUITemplatePai guiTemplatePai) {
        this.guiTemplatePai = guiTemplatePai;
        this.guiTemplatePai.bPesquisarAddActionListener(new OuvintePesquisarEspeciePagamento());
        this.guiTemplatePai.bExcluirSocioAddActionListener(new OuvinteExcluirEspeciePagamento());
    }


    class OuvinteExcluirEspeciePagamento implements ActionListener {
         public void actionPerformed(ActionEvent e) {
             try {
                 EspeciePagamento especiepagamento = guiTemplatePai.getEspeciePagamento();
                 StringBuffer mensagem = new StringBuffer("Confirma a exclusão do especie de pagamento: ");
                 mensagem.append("\nCódigo: " + especiepagamento.getId_especie_pagamento());
                 mensagem.append("\nNome: " + especiepagamento.getDescricao());
                 int resposta = guiTemplatePai.pedirConfirmacao(mensagem.toString(), "Exclusão de registro", JOptionPane.YES_NO_OPTION);
                     if (resposta == JOptionPane.OK_OPTION) {
                          ControleEspeciePagamento controle = new ControleEspeciePagamento();
                          controle.excluirEspeciePagamento(especiepagamento);
                          GUIMensagem.exibirMensagem("Espécie de pagamento excluído com sucesso!", "Cadastro de Espécie de Pagamento", false);
                     }
                 } catch (PessoaisException ex) {
                         GUIMensagem.exibirMensagem(ex.getMessage(), "DukeClube - Sócios", true);
                 }
         }
    }
    
}
