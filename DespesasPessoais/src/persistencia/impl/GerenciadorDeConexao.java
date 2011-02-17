/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package persistencia.impl;

import excecao.PessoaisException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author Marlon
 */
class GerenciadorDeConexao {
  private static String driver;
  private static String url;
  private static String usuario;
  private static String senha;

  private static void init () throws PessoaisException{
      
     Properties properties = new Properties();
     FileInputStream arquivoDePropriedades = null;
    try {
        arquivoDePropriedades = new FileInputStream("database.properties");
        properties.load(arquivoDePropriedades);
        driver = properties.getProperty("jdbc.driver");
        url = properties.getProperty("jdbc.url");
        usuario = properties.getProperty("jdbc.username");
        senha = properties.getProperty("jdbc.password");
        Class.forName(driver);
        } catch (FileNotFoundException exc) {
                StringBuffer mensagem = new StringBuffer("Não foi possível conectar com banco de dados.");
                mensagem.append("\nMotivo: " + exc.getMessage());
                throw new PessoaisException(mensagem.toString());
         } catch (IOException exc) {
                StringBuffer mensagem = new StringBuffer("Não foi possível conectar com banco de dados.");
                mensagem.append("\nMotivo: " + exc.getMessage());
                throw new PessoaisException(mensagem.toString());
         } catch (ClassNotFoundException exc) {
                StringBuffer mensagem = new StringBuffer("Não foi possível conectar com banco de dados.");
                mensagem.append("\nMotivo: " + exc.getMessage());
                throw new PessoaisException(mensagem.toString());
         }
  }

  static Connection getConexao() throws PessoaisException {
    try {
        init();
        return DriverManager.getConnection(url, usuario, senha);
        } catch (SQLException exc) {
            StringBuffer mensagem = new StringBuffer("Não foi possível estabelecer conexão com o banco de dados.");
            mensagem.append("\nMotivo: " + exc.getMessage());
            throw new PessoaisException(mensagem.toString());
        }
  }

  static void closeConexao(Connection con) throws PessoaisException {
    closeConexao(con, null, null);
  }

  static void closeConexao(Connection con, PreparedStatement stmt) throws
    PessoaisException {
    closeConexao(con, stmt, null);
  }

   static void closeConexao(Connection con, PreparedStatement stmt, ResultSet rs) throws
     PessoaisException {
    try {
        if (rs != null) {
          rs.close();
        }
        if (stmt != null) {
          stmt.close();
        }
        if (con != null) {
          con.close();
        }
    } catch (SQLException exc) {
        StringBuffer mensagem = new StringBuffer("Não foi possível finalizar a conexão com banco de dados.");
        mensagem.append("\nMotivo: " + exc.getMessage());
        throw new PessoaisException(mensagem.toString());
      }
   }

}
