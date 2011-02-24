/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package exemplo.grid;

/**
 *
 * @author Marlon
 */

import javax.swing.*;
import javax.swing.table.*;
import java.sql.*;
import java.util.Vector;


public class DBGrid extends JTable {

  public DBGrid() {
    super();
    this.setAutoResizeMode(this.AUTO_RESIZE_OFF);
  }

  public void setDataSet(ResultSet resultSet) throws Exception{
    try{
      if(resultSet!=null){
        ResultSetMetaData metaData = resultSet.getMetaData();
        int numColunas =  metaData.getColumnCount();
        Vector colunas = new Vector();
        boolean adiciona=true;
        for(int column = 0; column < numColunas; column++){
          colunas.addElement(metaData.getColumnLabel(column+1));
        }
        Vector linhas = new Vector();
        resultSet.beforeFirst();
        while (resultSet.next()){
          Vector novaLinha = new Vector();
          for (int i = 1; i <= metaData.getColumnCount(); i++){
            novaLinha.addElement(resultSet.getObject(i));
          }
          linhas.addElement(novaLinha);
        }
        setModel(new DefaultTableModel(linhas, colunas));
      }
    }
    catch(Exception ex){
      ex.printStackTrace();
    }
  }

  public Object retornaValor(int linha, int coluna) {
    return this.getModel().getValueAt(linha, coluna);
  }


}
