/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejericioBaseDatosPruebas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author alumno
 */
public class Conexion {
    
     private static final String BbddName = "Tienda";
     private static final String bbddUrl = "jdbc:mysql://localhost/"+ BbddName;//se usa la base de datos america,facilitada por el script
     private static final String usuario = "root";
     private static  final String clave = "";
    
    Connection conn = null;
    
    public Connection conectar() {

      
        

        try {

            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(bbddUrl, usuario, clave);

        } catch (Exception ex) {
            System.out.println("Error al conectar con la base de datos.\n"
                    + ex.getMessage().toString());
        }

        return conn;
    }

    //metodo para cerrar la conexion a la bbdd
    public  void cerrarConexion() {
        try {
            conn.close();
        } catch (SQLException e) {
            System.out.println("la conexion no se ha cerrado");
            System.out.println(e.getMessage().toString());
        }
    }
    
  
}

    

