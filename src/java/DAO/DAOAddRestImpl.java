 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DAOInterfaces.DAOAddRest;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Eliseo
 */
public class DAOAddRestImpl extends Conexion  implements DAOAddRest{

    @Override
    public void AddRest(String nombre, String descripcion) throws Exception {
            this.establecerConexion();
            PreparedStatement st = this.conexion.prepareStatement("insert into Restaurante (nombre, descripcion) values ('"+nombre+"','"+descripcion+"');");
            System.out.println("consulta: insert into Restaurante (nombre, descripcion) values ('"+nombre+"','"+descripcion+"');");
            st.executeUpdate();
            this.cerrarConexion();
    }
}
