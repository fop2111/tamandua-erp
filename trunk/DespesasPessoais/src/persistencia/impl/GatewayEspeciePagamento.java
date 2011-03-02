/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package persistencia.impl;

import excecao.PessoaisException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelo.dominio.EspeciePagamento;
import modelo.dominio.constante.Constante;
import persistencia.IGatewayEspeciePagamento;

/**
 *
 * @author Marlon
 */
public class GatewayEspeciePagamento implements IGatewayEspeciePagamento {

    public void gravarEspeciePagamento(EspeciePagamento especie_pagamento) throws PessoaisException {
        if (especie_pagamento.getId_especie_pagamento() == Constante.NOVO) {
           incluirEspeciePagamento(especie_pagamento);
        }
        else {
           alterarEspeciePagmento(especie_pagamento);
        }
    }

    private static final String SQL_INCLUIR_ESPECIE_PAGAMENTO = "INSERT INTO tam_custos.especie_pagamento " +
                                                                        "(id_especie_pagamento, descricao, operacao , tipo_conta) "+
                                                                 "VALUES (?, ?, ?, ?)";


    private void incluirEspeciePagamento(EspeciePagamento especie_pagamento) throws PessoaisException {
     if (especie_pagamento == null) {
       String mensagem = "Não foi informado o socio a cadastrar.";
       throw new PessoaisException(mensagem);
     }
     Connection con         = null;
     PreparedStatement stmt = null;
     try {
            con = GerenciadorDeConexao.getConexao();
            stmt = con.prepareStatement(SQL_INCLUIR_ESPECIE_PAGAMENTO);
            GeradorDeChave geradorDeChave = new GeradorDeChave("tam_custos.sq_especie_pagamento");
            long codigosocio =  geradorDeChave.getProximoCodigo();

            stmt.setLong(1, codigosocio);
            stmt.setString(2, especie_pagamento.getDescricao());
            stmt.setString(3, especie_pagamento.getOperacao());
            stmt.setString(4, especie_pagamento.getTipo_conta());

            stmt.executeUpdate();
            } catch (SQLException exc) {
                    StringBuffer mensagem = new StringBuffer("Não foi possível incluir o sócio.");
                    mensagem.append("\nMotivo: " + exc.getMessage());
                    throw new PessoaisException(mensagem.toString());
              } finally {
                    GerenciadorDeConexao.closeConexao(con, stmt);
                }
    }

   private static final String SQL_ALTERARSOCIO = "UPDATE tam_custos.especie_pagamento SET "
                                                          + "descricao =?, tipo_conta =?, operacao = ? "
                                                 + "WHERE id_especie_pagamento = ?";

   private static final String SQL_EXCLUIRSOCIO = "DELETE FROM tam_custos.especie_pagamento "
                                                 + "WHERE id_especie_pagamento = ?";


   private void alterarEspeciePagmento(EspeciePagamento especiepagamento) throws PessoaisException {
      if (especiepagamento == null) {
          String mensagem = "Não foi informado o socio a alterar";
          throw new PessoaisException(mensagem);
      }
       Connection con = null;
       PreparedStatement stmt = null;
      try{
          con  = GerenciadorDeConexao.getConexao();
          stmt = con.prepareStatement(SQL_ALTERARSOCIO);
          stmt.setString(1,   especiepagamento.getDescricao());
          stmt.setString(2,   especiepagamento.getTipo_conta());
          stmt.setString(3, especiepagamento.getOperacao());
          stmt.setInt(4, especiepagamento.getId_especie_pagamento());
          stmt.executeUpdate();
         } catch (SQLException exc) {
                StringBuffer mensagem = new StringBuffer("Não foi possível atualizar os dados do sócio.");
                mensagem.append("\nMotivo: " + exc.getMessage());
                throw new PessoaisException(mensagem.toString());
         } finally {
                     GerenciadorDeConexao.closeConexao(con, stmt);
                   }
   }


   public void excluirEspeciePagamento(EspeciePagamento especiepagamento) throws PessoaisException {
       if (especiepagamento == null) {
            String mensagem = "Não foi informado a especie de pagamento a excluir.";
            throw new PessoaisException(mensagem);
       }
        Connection con = null;
        PreparedStatement stmt = null;
        try {
                con = GerenciadorDeConexao.getConexao();
                stmt = con.prepareStatement(SQL_EXCLUIRSOCIO);
                stmt.setInt(1, especiepagamento.getId_especie_pagamento());
                stmt.executeUpdate();
            } catch (SQLException exc) {
                        StringBuffer mensagem = new StringBuffer("Não foi possível excluir a especie pagamento.");
                        mensagem.append("\nMotivo:" + exc.getMessage());
                        throw new PessoaisException(mensagem.toString());
                    } finally {
                            GerenciadorDeConexao.closeConexao(con, stmt);
                      }
    }
}
