
package Conexion;

import Models.TClientes;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.apache.commons.dbutils.*;
import org.apache.commons.dbutils.handlers.BeanListHandler;

/**
 *
 * @author ¡Diego Andres Salas!
 */
public class Consultar extends Conexion{
    private QueryRunner QR = new QueryRunner();
    public List<TClientes> clientes(){
            List<TClientes> cliente = new ArrayList();
        try {
            cliente = (List<TClientes>) QR.query(getConn(), "SELECT * FROM tclientes",
                    new BeanListHandler(TClientes.class));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error: "+ ex);
        }
        return cliente;
    }
}
