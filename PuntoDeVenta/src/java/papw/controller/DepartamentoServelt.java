/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package papw.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import papw.model.Departamento;
import papw.dao.DepartamentoDao;
/**
 *
 * @author Owner
 */
public class DepartamentoServelt extends HttpServlet{
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    String accion = request.getParameter("accion"); 
    String strId = request.getParameter("id");
        
         int id = 0;
            if (strId != null && !strId.equals("")) {
                id = Integer.parseInt(strId);
            }
             
        String nombre = request.getParameter("nomDepa");
   
        if ("modificar".equals(accion)) {
            
        Departamento departamento = new Departamento(id,nombre);
        DepartamentoDao.editar(departamento);
        ServletContext sc = getServletContext();
        response.setContentType("text/html;charset=UTF-8");
        RequestDispatcher disp = getServletContext().getRequestDispatcher("/mostrardepa");
        disp.forward(request, response);
         } else {
            
        Departamento departamento = new Departamento(nombre);
        DepartamentoDao.insertar(departamento);
        ServletContext sc = getServletContext();
        response.setContentType("text/html;charset=UTF-8");
        RequestDispatcher disp = getServletContext().getRequestDispatcher("/mostrardepa");
        disp.forward(request, response);
        
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
    }// </editor-f
}
