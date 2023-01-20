/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejericioBaseDatosPruebas;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author alumno
 */
public class Main {

    public static void main(String[] args) throws SQLException {
        Conexion con = new Conexion();
        Connection conn = con.conectar();

        String sentencia = "";
        Statement st = conn.createStatement();
        ResultSet rs = null;

        //1 Listar los nombres de los usuarios
        sentencia = "SELECT usuario,NOMBRE FROM tblusuarios ";
        rs = st.executeQuery(sentencia);
        System.out.println("------Lista de usuarios con  los nombres------");
        while (rs.next()) {
            String usuario = rs.getString(2);
            String nombre = rs.getString("nombre");

            System.out.println("Usuario: " + usuario + " Nombre: " + nombre);
        }

        //2 Calcular el saldo máximo de los usuarios de sexo “Mujer”
        sentencia = "SELECT MAX(saldo) from tblusuarios where sexo='M'";
        rs = st.executeQuery(sentencia);
        System.out.println("------Saldo maximo  de usuarios mujer------");
        while (rs.next()) {
            double saldo = rs.getDouble(1);
            System.out.println("Saldo maximo: " + saldo);
        }

        //3 Listar nombre y teléfono de los usuarios con teléfono NOKIA, BLACKBERRY o SONY
        sentencia = "SELECT NOMBRE,TELEFONO FROM TBLUSUARIOS WHERE marca in('nokia','blackberry','sony')";
        rs = st.executeQuery(sentencia);
        System.out.println("------Nombre y telefono de usuarios con marca telefono marca, blackberry y sony------");
        while (rs.next()) {

            String nombre = rs.getString("nombre");
            String telefono = rs.getString("telefono");
            System.out.println("Nombre: " + nombre + " Telefono: " + telefono);
        }

        //4 Contar los usuarios sin saldo o inactivos
        sentencia = "SELECT COUNT(*) FROM tblUsuarios WHERE NOT activo OR saldo <= 0";
        rs = st.executeQuery(sentencia);
        System.out.println("------Usuarios sin saldo o inactivos------");
        while (rs.next()) {
            int cuenta = rs.getInt(1);
            System.out.println("Usuarios sin saldo o incactivos " + cuenta);
        }

        
        //5 Listar el login de los usuarios con nivel 1, 2 o 3 
        sentencia="SELECT usuario,nivel FROM tblUsuarios WHERE nivel IN(1, 2, 3)";
        rs = st.executeQuery(sentencia);
        System.out.println("------Usuarios con nivel 1,2 y 3");
        while(rs.next()){
            String usuario= rs.getString(1);
            int nivel = rs.getInt(2);
            System.out.println("Usuarios: "+usuario+ "  Nivel: "+nivel);
        }
        
        //6 Listar los números de teléfono con saldo menor o igual a 300
        sentencia="SELECT TELEFONO,saldo FROM TBLUSUARIOS WHERE SALDO<=300";
        rs= st.executeQuery(sentencia);
        System.out.println("------Numero de telefono con saldo menor o igual a 300------");
        while(rs.next()){
            String telefono = rs.getString(1);
            double saldo = rs.getDouble(2);
            
            System.out.println("Telefono: "+telefono+ " Saldo: "+saldo);

        }
        //7 Calcular la suma de los saldos de los usuarios de la compañia telefónica NEXTEL
        sentencia="SELECT SUM(saldo) FROM tblUsuarios WHERE compañia = 'NEXTEL'";
        rs=st.executeQuery(sentencia);
        System.out.println("------Suma de los saldos de los usuarios de la compañia NEXTEL------");
        while(rs.next()){
            double saldo= rs.getDouble(1);
            System.out.println("Suma saldo: "+saldo);
        }
        
        //8 Contar el número de usuarios por compañía telefónica
        sentencia="SELECT compañia, COUNT(*) FROM tblUsuarios GROUP BY compañia;";
        rs= st.executeQuery(sentencia);
        System.out.println("------Numero usuarios por compañia telefonica------");
        while(rs.next()){
            String compania= rs.getString(1);
            int numero = rs.getInt(2);
            System.out.println("Compañia: "+compania + " Numero usuarios: "+numero);
        }
        
        //9 Contar el número de usuarios por nivel
        sentencia="SELECT NIVEL, COUNT(*) FROM TBLUSUARIOS GROUP BY NIVEL";
        rs=st.executeQuery(sentencia);
        System.out.println("------Numero usuarios por nivel------");
        while(rs.next()){
            int nivel = rs.getInt(1);
            int numero = rs.getInt(2);
            System.out.println("Nivel: "+nivel + " Numero: "+numero);

        }
       
        //10 Listar el login de los usuarios con nivel 2
        sentencia="SELECT USUARIO,nivel FROM TBLUSUARIOS WHERE nivel=2";
        rs=st.executeQuery(sentencia);
        System.out.println("------Login de usuarios de nivel 2------");
        while(rs.next()){
            String usuario = rs.getString(1);
            int nivel = rs.getInt(2);
            System.out.println("Usuario: "+usuario + " Nivel: "+nivel );

        }
        
        //11 Mostrar el email de los usuarios que usan gmail
        sentencia="SELECT nombre,email from tblusuarios where email LIKE '%gmail.com'";
        rs=st.executeQuery(sentencia);
        System.out.println("-----Usuarios con email tipo gmail------");
        while(rs.next()){
            String nombre = rs.getString(1);
            String email = rs.getString(2);     
            System.out.println("Nombre: "+nombre + " Email: "+email);

        }
        
        //12 Listar nombre y teléfono de los usuarios con teléfono LG, SAMSUNG o MOTOROLA
        sentencia="SELECT NOMBRE,TELEFONO,marca FROM TBLUSUARIOS WHERE MARCA IN('LG','SAMSUNG','MOTOROLA')";
        rs= st.executeQuery(sentencia);
        System.out.println("------Nombre y telefono de usuarios con marca lg, samsung o motorola------");
        while (rs.next()) {

            String nombre = rs.getString("nombre");
            String telefono = rs.getString("telefono");
            String marca = rs.getString("marca");
            System.out.println("Nombre: " + nombre + " Telefono: " + telefono+ " Marca: "+marca);
        }
        
        con.cerrarConexion();
    }
}
