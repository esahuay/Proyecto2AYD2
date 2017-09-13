/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.data;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author wxjoy
 */
public class DBUsuario {
    private Conexion conexion;
    protected PreparedStatement stmt;
    protected String strQuery;
    
    public DBUsuario(){
        conexion = new Conexion();
    }
    
    public char guardarInformacion(String nombre, String apellido, String correo, String pwd){
        strQuery = "INSERT INTO TB_USUARIO VALUES(?,?,?,?) ";
        char status='g';
        try {
            try {
                conexion.establecerConexion();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DBUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
            stmt = conexion.getConexion().prepareStatement(strQuery);
            stmt.setString(1, correo);
            stmt.setString(2, nombre);
            stmt.setString(3, apellido);
            stmt.setString(4, pwd);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DBUsuario.class.getName()).log(Level.SEVERE, null, ex);
            //error especifico de mysql de llave duplicada ojo
            if(ex.getErrorCode() == 1062){
                status = 'd';
            }else{
                status='e';
            }
        }
        return status;
    }
}
