
package sistema.de.ventas;

import Views.Sistema;
import java.awt.Frame;
import javax.swing.UIManager;
/**
 *
 * @author ¡Diego Andres Salas!
 */
public class SistemaDeVentas {

    
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
        }
        Sistema sistema = new Sistema();
        sistema.setExtendedState(Frame.MAXIMIZED_BOTH);
        sistema.setVisible(true);
    }

}
