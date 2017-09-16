/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import DAOInterfaces.DAOLogin;

/**
 *
 * @author Eliseo
 */
public class DAOLoginImpl extends Conexion implements DAOLogin{

    /**
     *
     * @return
     * @throws Exception
     */
    @Override
    public boolean Ingresar(String us, String psw) throws Exception {
            this.establecerConexion();
            PreparedStatement st = this.conexion.prepareStatement("Select * from usuario where correo='" + us + "' and password='" + psw+"';");
            ResultSet rs = st.executeQuery();
            return rs.next();
    }
}
