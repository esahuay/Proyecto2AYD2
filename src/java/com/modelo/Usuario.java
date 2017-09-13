/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modelo;

import com.data.DBUsuario;

/**
 *
 * @author wxjoy
 */
public class Usuario {
    private String correo;
    private String nombre;
    private String apellido;
    private String password;
    private DBUsuario dbUser;
    
    public Usuario(String correo, String nombre, String apellido, String password){
        this.apellido = apellido;
        this.nombre = nombre;
        this.correo = correo;
        this.password = password;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public char crearUsuario(){
        dbUser = new DBUsuario();
        return dbUser.guardarInformacion(nombre, apellido, correo, password);
    }
    
}
