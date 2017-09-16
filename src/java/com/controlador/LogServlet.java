/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controlador;

import DAO.DAOLoginImpl;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Eliseo
 */
public class LogServlet extends HttpServlet {

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LogServlet</title> ");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LogServlet at :V " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
        String email = request.getParameter("email");
        String password = request.getParameter("password");
 
        //si el formulario falla
        if (email.isEmpty() || password.isEmpty()) 
        {
            request.setAttribute("error", "Usuario y password no pueden ir vacíos");
            RequestDispatcher rs = request.getRequestDispatcher("/login.jsp");
            rs.forward(request, response);
        } 
        else 
        {
            //si el formulario pasa la validación
 
            //creamos la instancia de LoginDaoImp
            DAOLoginImpl loginDaoImpl = new DAOLoginImpl();
 
            //por defecto el resultado del login es false
            boolean res = false;
            try 
            {
                res = loginDaoImpl.Ingresar(email, password);
                
                if(res) 
                {
                    System.out.println("Login correcto");
                    System.out.println("correo: "+email+" Pass: "+password);
                    PrintWriter out = response.getWriter();
                    out.println("Login Correcto");
                    out.println("Usuario: "+email);
                    out.println("Password: "+password);
                } 
                else 
                {
                    System.out.println("correo: "+email+" Pass: "+password);
                    System.out.println("Login incorrecto");
                    PrintWriter out = response.getWriter();
                    out.println("Login Incorrecto");
                    out.println("Usuario: "+email);
                    out.println("Password: "+password);
                }
            } 
            catch (Exception ex) 
            {
                System.out.println(ex.getMessage());
            }
        }
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
