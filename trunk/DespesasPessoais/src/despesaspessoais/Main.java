/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package despesaspessoais;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;
import visao.gui.GUIPrincipal;

/**
 *
 * @author Marlon
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

      try {
           for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
               if ("Nimbus".equals(info.getName())) {
                        UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }
                }
            } catch (UnsupportedLookAndFeelException e) {
                // handle exception
            } catch (ClassNotFoundException e) {
                // handle exception
            } catch (InstantiationException e) {
                // handle exception
            } catch (IllegalAccessException e) {
                // handle exception
            }


      GUIPrincipal guiPrincipal = new GUIPrincipal();
      guiPrincipal.setLocationRelativeTo(null);
      guiPrincipal.setVisible(true);
    }

}
