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

/**
 *
 * @author Marlon
 */
public class GeradorDeChave {

    private Connection con;
    private String tabela;

    public GeradorDeChave(String tabela) throws PessoaisException {
       this.con = GerenciadorDeConexao.getConexao();
       this.tabela = tabela;
       try {
            con.setAutoCommit(false);
           } catch (SQLException exc) {
                StringBuffer mensagem = new StringBuffer ("Não foi possível desligar confirmação automática");
                mensagem.append("\nMotivo: " + exc.getMessage());
             throw new PessoaisException(mensagem.toString());
           }
    }

    public synchronized long getProximoCodigo()throws PessoaisException {

        PreparedStatement stmt = null;
        ResultSet rs           = null;

        long proximoCodigoNovo = 0;
        String sql = "select  nextval(?) proximoCodigo ";
        try {
              stmt = con.prepareStatement(sql);
              stmt.setString(1, tabela);
              rs = stmt.executeQuery();
              rs.next();
              proximoCodigoNovo = rs.getLong("proximoCodigo");
            } catch (SQLException exc) {
                  StringBuffer mensagem = new StringBuffer("Não foi possível gerar o próximo código");
                  mensagem.append("\nMotivo: " + exc.getMessage());
                  throw new PessoaisException(mensagem.toString());
              }finally {
                  GerenciadorDeConexao.closeConexao(con, stmt, rs);
               }
         return proximoCodigoNovo;
     }
}
