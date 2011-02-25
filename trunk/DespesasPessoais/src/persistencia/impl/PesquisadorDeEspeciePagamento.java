/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package persistencia.impl;

import excecao.PessoaisException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import modelo.dominio.EspeciePagamento;
import persistencia.IPesquisadorDeEspeciePagamento;

/**
 *
 * @author Marlon
 */
public class PesquisadorDeEspeciePagamento implements IPesquisadorDeEspeciePagamento {
    private List criterios = new ArrayList();

    public void adicionarCriterio(CriterioDePesquisa criterio) {
       this.criterios.add(criterio);
    }

    private String gerarClausulaWhere() {
        StringBuffer clausulaWhere = new StringBuffer();
        if (criterios.size() != 0) {
            clausulaWhere.append(" WHERE ");
            Iterator iterator = criterios.iterator();
            while (iterator.hasNext()) {
               if (clausulaWhere.length() != 7) {
                  clausulaWhere.append(" OR ");
               }
               CriterioDePesquisa criterio = (CriterioDePesquisa) iterator.next();
               clausulaWhere.append(criterio.gerarSQL());
            }
        }
         return clausulaWhere.toString();
    }

   private List encontrarEspeciePagamentoOnde(String clausulaWhere) throws PessoaisException {
     String sql = "SELECT * FROM tam_custos.especie_pagamento " + clausulaWhere;
     Connection con = null;
     PreparedStatement stmt = null;
     ResultSet rs = null;
     List resultado = new ArrayList();
     try {
          con = GerenciadorDeConexao.getConexao();
          stmt = con.prepareStatement(sql);
          rs = stmt.executeQuery();
          while (rs.next()) {
            EspeciePagamento especiepagamento = criarEspeciePagamento(rs);
            resultado.add(especiepagamento);
          }
          } catch (SQLException exc) {
             StringBuffer mensagem = new StringBuffer("Não foi possível realizar a consulta.");
             mensagem.append("\nMotivo: " + exc.getMessage());
            throw new PessoaisException(mensagem.toString());
          } finally {
                    GerenciadorDeConexao.closeConexao(con, stmt, rs);
            }
      return resultado;
   }

   private EspeciePagamento criarEspeciePagamento(ResultSet rs) throws PessoaisException {
      EspeciePagamento especiepagamento = new EspeciePagamento();
      try {
             especiepagamento.setId_especie_pagamento(rs.getInt("id_especie_pagamento"));
             especiepagamento.setDescricao(rs.getString("descricao"));
             especiepagamento.setOperacao(rs.getString("operacao"));
             especiepagamento.setTipo_conta(rs.getString("tipo_conta"));
          } catch (SQLException exc) {
               StringBuffer mensagem = new StringBuffer("Não foi possível obter os dados da espécie pagamento.");
               mensagem.append("\nMotivo: " + exc.getMessage());
               throw new PessoaisException(mensagem.toString());
          }
     return especiepagamento;
  }

  public List realizarPesquisa() throws PessoaisException {
     String clausulaWhere = this.gerarClausulaWhere();
    return encontrarEspeciePagamentoOnde(clausulaWhere);
  }
}
