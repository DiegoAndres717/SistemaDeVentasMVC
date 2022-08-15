
package Conexion;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ¡Diego Andres Salas!
 */
public class Conexion {
    private String db = "punto_de_ventas";
    private String user = "root";
    private String password = "root";
    private String urlMysql = "jdbc:mysql://localhost/" + db + "?SslMode=none";
    private Connection conn = null;
    
    public Conexion(){
        //Obtenemos el driver para mysql
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(this.urlMysql, this.user, this.password);
            if (conn != null) {
                System.out.println("Conexion a la base de datos "+this.db + "............Listo");
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: "+e);
        }
    }

    public Connection getConn() {
        return conn;
    }
    
}
