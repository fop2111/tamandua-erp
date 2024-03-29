/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * GUITemplatePai.java
 *
 * Created on 20/02/2011, 10:05:09
 */

package visao.gui;

import despesaspessoais.utilitarios.Metodos;
import excecao.PessoaisException;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.dominio.EspeciePagamento;
import modelo.dominio.constante.Constante;
import visao.ouvinte.OuvinteEspeciePagamento;

/**
 *
 * @author Marlon
 */
public class GUITemplatePai extends javax.swing.JInternalFrame {

    /** Creates new form GUITemplatePai */
    public GUITemplatePai() {
        initComponents();


    }

    private GUICadastroEspeciePagamento guiCadastroEspeciePagamento;

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        bNovo = new javax.swing.JButton();
        bSair = new javax.swing.JButton();
        bAlterar = new javax.swing.JButton();
        bPesquisar = new javax.swing.JButton();
        bExcluir = new javax.swing.JButton();
        bImprimir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        gridPrincipal = new javax.swing.JTable();
        jPesquisa = new javax.swing.JPanel();
        edtDescricao = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel2.setBackground(new java.awt.Color(176, 176, 175));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        bNovo.setBackground(new java.awt.Color(176, 176, 175));
        bNovo.setText("Novo");
        bNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bNovoActionPerformed(evt);
            }
        });

        bSair.setBackground(new java.awt.Color(176, 176, 175));
        bSair.setText("Sair");
        bSair.setMaximumSize(new java.awt.Dimension(56, 28));
        bSair.setMinimumSize(new java.awt.Dimension(56, 28));
        bSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSairActionPerformed(evt);
            }
        });

        bAlterar.setBackground(new java.awt.Color(176, 176, 175));
        bAlterar.setText("Alterar");
        bAlterar.setMaximumSize(new java.awt.Dimension(56, 28));
        bAlterar.setMinimumSize(new java.awt.Dimension(56, 28));
        bAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAlterarActionPerformed(evt);
            }
        });

        bPesquisar.setBackground(new java.awt.Color(176, 176, 175));
        bPesquisar.setText("Pesquisar");
        bPesquisar.setMaximumSize(new java.awt.Dimension(56, 28));
        bPesquisar.setMinimumSize(new java.awt.Dimension(56, 28));
        bPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bPesquisarActionPerformed(evt);
            }
        });

        bExcluir.setBackground(new java.awt.Color(176, 176, 175));
        bExcluir.setText("Excluir");
        bExcluir.setMaximumSize(new java.awt.Dimension(56, 28));
        bExcluir.setMinimumSize(new java.awt.Dimension(56, 28));
        bExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bExcluirActionPerformed(evt);
            }
        });

        bImprimir.setBackground(new java.awt.Color(176, 176, 175));
        bImprimir.setText("Imprimir");
        bImprimir.setMaximumSize(new java.awt.Dimension(56, 28));
        bImprimir.setMinimumSize(new java.awt.Dimension(56, 28));
        bImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bImprimirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(bNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bSair, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(bNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(bAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(bPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(bExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(bImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(bSair, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        gridPrincipal.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        gridPrincipal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descrição", "Operação", "Tipo de Conta"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        gridPrincipal.setCellSelectionEnabled(true);
        gridPrincipal.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        gridPrincipal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gridPrincipalMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(gridPrincipal);
        gridPrincipal.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        jPesquisa.setBackground(new java.awt.Color(219, 218, 202));
        jPesquisa.setBorder(null);

        jLabel1.setText("Descrição");

        javax.swing.GroupLayout jPesquisaLayout = new javax.swing.GroupLayout(jPesquisa);
        jPesquisa.setLayout(jPesquisaLayout);
        jPesquisaLayout.setHorizontalGroup(
            jPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPesquisaLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(edtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(253, Short.MAX_VALUE))
        );
        jPesquisaLayout.setVerticalGroup(
            jPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPesquisaLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(edtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPesquisa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 536, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPesquisa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNovoActionPerformed
       EspeciePagamento especiepagamento = new EspeciePagamento();

       especiepagamento.setId_especie_pagamento(Constante.NOVO);
       this.abrirGUICadastroEspeciePagamento(especiepagamento);
    }//GEN-LAST:event_bNovoActionPerformed

    private void bSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSairActionPerformed
      this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_bSairActionPerformed

    private void bAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAlterarActionPerformed
      EspeciePagamento especiepagamento = null;
      try {
           especiepagamento = this.getEspeciePagamento();
           this.abrirGUICadastroEspeciePagamento(especiepagamento);
      } catch (PessoaisException ex) {
              GUIMensagem.exibirMensagem(ex.getMessage(), "DukeClube - Sócios", true);
        }
    }//GEN-LAST:event_bAlterarActionPerformed

    private void bPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPesquisarActionPerformed
        // TODO add your handling code here:
        Metodos metodos = new Metodos();
        metodos.atualizaGrid("table", gridPrincipal);
    }//GEN-LAST:event_bPesquisarActionPerformed

    private void bExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bExcluirActionPerformed
       bPesquisar.doClick();
    }//GEN-LAST:event_bExcluirActionPerformed

    private void bImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bImprimirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bImprimirActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
       
        bPesquisar.doClick();
    }//GEN-LAST:event_formComponentShown

    private void gridPrincipalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gridPrincipalMouseClicked
       if (evt.getClickCount() > 1 )
          bAlterar.doClick();
    }//GEN-LAST:event_gridPrincipalMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAlterar;
    private javax.swing.JButton bExcluir;
    private javax.swing.JButton bImprimir;
    private javax.swing.JButton bNovo;
    private javax.swing.JButton bPesquisar;
    private javax.swing.JButton bSair;
    private javax.swing.JTextField edtDescricao;
    private javax.swing.JTable gridPrincipal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPesquisa;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    private List especie;

   public void setPosicao() {
     Dimension d = this.getDesktopPane().getSize();
     this.setLocation((d.width - this.getSize().width) / 6, (d.height -
     this.getSize().height) / 6);
   }


   private void abrirGUICadastroEspeciePagamento (EspeciePagamento especiepagamento) {
     if ((guiCadastroEspeciePagamento == null) || (!guiCadastroEspeciePagamento.isVisible())) {
         guiCadastroEspeciePagamento = new GUICadastroEspeciePagamento();
         OuvinteEspeciePagamento ouvinte = new
         OuvinteEspeciePagamento(guiCadastroEspeciePagamento);
         this.getParent().add(guiCadastroEspeciePagamento);
         guiCadastroEspeciePagamento.setPosicao();
         guiCadastroEspeciePagamento.setVisible(true);         
         guiCadastroEspeciePagamento.setEspeciePagamento(especiepagamento);
         
     }try {
            guiCadastroEspeciePagamento.setSelected(true);
          } catch (PropertyVetoException exc) {
             StringBuffer mensagem = new StringBuffer();
             mensagem.append("Não foi possível selecionar a janela de cadastro de especie pagamento!");
             mensagem.append("\nMotivo: " + exc.getMessage());
             GUIMensagem.exibirMensagem(mensagem.toString(), "DukeClube - Cadastro desócio", true);
            }
   }


   private void removerLinhasDaTabela(DefaultTableModel model){
     while (model.getRowCount() > 0){
       int ultimaLinha = model.getRowCount()-1;
            model.removeRow(ultimaLinha);
      }
   }

    public void exibirEspeciePagamento(List especie) {
      this.especie  = especie;

      DefaultTableModel model = (DefaultTableModel) gridPrincipal.getModel();
      this.removerLinhasDaTabela(model);
      Iterator resultado = especie.iterator();

      while (resultado.hasNext()) {
        EspeciePagamento especiepagamento = (EspeciePagamento) resultado.next();
        int   codigo     = especiepagamento.getId_especie_pagamento();
        String descricao = especiepagamento.getDescricao();
        String operacao = especiepagamento.getOperacao();
        String tipoConta = especiepagamento.getTipo_conta();

        Object[] linha = {codigo, descricao, operacao, tipoConta};
        model.addRow(linha);
    }
  }

  public void bPesquisarAddActionListener(ActionListener ouvinte) {
    bPesquisar.addActionListener(ouvinte);
  }

  public String getDescricao() {
    return edtDescricao.getText();
  }

  public EspeciePagamento getEspeciePagamento() throws PessoaisException {
      EspeciePagamento especiepagamento = null;
      int linhaSelecionada = gridPrincipal.getSelectedRow();
      if (linhaSelecionada < 0) {
           throw new PessoaisException("Não foi selecionado nenhuma especie de pagamento");
      }
      especiepagamento = (EspeciePagamento) this.especie.get(linhaSelecionada);
         return especiepagamento;
  }

  public int pedirConfirmacao(String mensagem, String titulo, int tipo) {
      int resposta = JOptionPane.showConfirmDialog(null, mensagem, titulo, tipo);
      return resposta;
  }

  public void bExcluirSocioAddActionListener(ActionListener ouvinte) {
    bExcluir.addActionListener(ouvinte);
  }


}
