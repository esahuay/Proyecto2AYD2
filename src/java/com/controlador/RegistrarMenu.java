/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controlador;

import com.data.Consultas;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.tomcat.util.codec.binary.Base64;

/**
 *
 * @author Blanqui
 */
public class RegistrarMenu extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
           String nombre = request.getParameter("nombre");
            String descripcion = request.getParameter("descripcion");
            String precio = request.getParameter("Precio");
            String imagen = request.getParameter("imagen");

            Consultas con = new Consultas();
            
            File file = new File(imagen); 
            BufferedInputStream bufferis = new BufferedInputStream(new 
            FileInputStream(file)); 
            int bytes = (int) file.length(); 
            byte[] buffer = new byte[bytes]; 
            int readBytes = bufferis.read(buffer); 
            bufferis.close(); 

            /*Codificamos a base 64*/ 
            String encodedString = Base64.encodeBase64String(buffer);

            int resultado = con.guardarMenu(nombre, descripcion, Double.parseDouble(precio), encodedString);

            switch(resultado){
                    case 1:
                        out.print("<div class='alert alert-success' role='alert'><strong>Registro</strong> satisfactorio Menu guardado</div>");
                        break;
                    case 0:
                        out.print("<div class='alert alert-danger' role='alert'><strong>Error</strong> en la base de datos no se pudo guardar</div>");
                        break;
                    case 2:
                        out.print("<div class='alert alert-warning' role='alert'><strong>El nombre</strong> ya esta siendo utilizado</div>");
                        break;
            }
        }
        
        System.err.println("llego la solicitud");

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
