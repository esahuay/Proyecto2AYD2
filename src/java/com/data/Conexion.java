/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.data;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author wxjoy
 */
public class Conexion {
    private static final String USER = "root";
    private static final String PASSWORD = "w1j2m3";
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String CONEXION = "jdbc:mysql://10.0.3.192:3306/dbP2AYD2";
    private Connection conexion;
    
    public void establecerConexion() throws ClassNotFoundException, SQLException{
        Class.forName(DRIVER);
        conexion = (Connection) DriverManager.getConnection(CONEXION,USER,PASSWORD);
    }
    
    public Connection getConexion(){
        return conexion;
    }
    
    public void cerrarConexion(){
        try {
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
