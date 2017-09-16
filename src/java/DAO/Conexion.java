/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Eliseo
 */
public class Conexion {
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String CONEXION = "jdbc:mysql://localhost:3306/dbp2ayd2";
    Connection conexion;
    
    public void establecerConexion() throws ClassNotFoundException, SQLException{
        System.out.println("intentando");
        Class.forName(DRIVER);
        conexion = (Connection) DriverManager.getConnection(CONEXION,USER,PASSWORD);
        System.out.println("conexion");
        System.out.println("Conexion establecida");
    }
    
    public Connection getConexion(){
        return conexion;
    }
    
    public void cerrarConexion(){
        try {
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(com.data.Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
