/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package persistencia.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import net.antoniopassos.dukeclube.excecao.DukeClubeException;
import net.antoniopassos.dukeclube.modelo.dominio.Socio;
import net.antoniopassos.dukeclube.modelo.dominio.constante.Constante;
import persistencia.IGatewaySocio;

/**
 *
 * @author Marlon
 */
public class GatewaySocio implements IGatewaySocio {

    public void gravarSocio(Socio socio) throws DukeClubeException {
        if (socio.getCodigo() == Constante.NOVO) {
          incluirSocio(socio);
       }

    }

    private static final String SQL_INCLUIRSOCIO = "INSERT INTO socio " +
                                                                 "(codigosocio, categoria, nome, sexo, datanascimento, telefonefixo,telefonecelular, email) " +
                                                          "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";


private void incluirSocio(Socio socio) throws DukeClubeException {
   if (socio == null) {
      String mensagem = "Não foi informado o socio a cadastrar.";
      throw new DukeClubeException(mensagem);
   }
   Connection con = null;
   PreparedStatement stmt = null;
   try {
       con = GerenciadorDeConexao.getConexao();
      stmt = con.prepareStatement(SQL_INCLUIRSOCIO);
      GeradorDeChave geradorDeChave = new GeradorDeChave("socio");
      long codigosocio = geradorDeChave.getProximoCodigo();
      stmt.setLong(1, codigosocio);
      stmt.setInt(2, socio.getCategoria());
      stmt.setString(3, socio.getNome());
      stmt.setInt(4, socio.getSexo());
      java.util.Date dataNascimento = socio.getDataNascimento();
      stmt.setDate(5, new java.sql.Date(dataNascimento.getTime()));
      stmt.setString(6, socio.getTelefoneFixo());
      stmt.setString(7, socio.getTelefoneCelular());
      stmt.setString(8, socio.getEmail());
      stmt.executeUpdate();
     } catch (SQLException exc) {
        StringBuffer mensagem = new StringBuffer("Não foi possível incluir o sócio.");
        mensagem.append("\nMotivo: " + exc.getMessage());
        throw new DukeClubeException(mensagem.toString());
      } finally {
          GerenciadorDeConexao.closeConexao(con, stmt);
        }
}



}
