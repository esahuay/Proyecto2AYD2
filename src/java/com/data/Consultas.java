/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Blanqui
 */
public class Consultas {
    
    private Conexion conexion;
    protected PreparedStatement stmt;
    protected String strQuery;
    protected ResultSet res;
    
    public Consultas(){
        conexion = new Conexion();
    }
    
    public int guardarMenu(String nombre, String detalle, double precio, long imagen)    
    { 
        int resultado = 0;
        stmt = null;

        try {
            try {
                conexion.establecerConexion();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
            }
            strQuery = "INSERT INTO Menu (nombre, descripcion, precio, imagen) VALUES(?,?,?,?) ";
            
            stmt = conexion.getConexion().prepareStatement(strQuery);
            stmt.setString(1, nombre);
            stmt.setString(2, detalle);
            stmt.setDouble(3, precio);
            stmt.setLong(4, imagen);
            
            if(stmt.executeUpdate()== 1)
                resultado = 1;
            
        } catch (SQLException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
            //error especifico de mysql de llave duplicada ojo
            if(ex.getErrorCode() == 1062){
                resultado = 2;
            }else{
                resultado = 0;
            }
        }finally{
            try{
                if(conexion.getConexion() != null)
                    conexion.getConexion().close();
                if(stmt != null)
                    stmt.close();
            }catch(SQLException e){
                System.out.print("Error "+e);
            }
                
        }
        return resultado;
    }
}
