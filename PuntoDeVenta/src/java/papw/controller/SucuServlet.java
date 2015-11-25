/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package papw.controller;

import java.io.IOException;
import java.io.InputStream;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import papw.dao.ArticuloDao;
import papw.dao.SucursalDao;
import papw.model.Articulo;
import papw.model.Sucursal;

/**
 *
 * @author Owner
 */
public class SucuServlet extends HttpServlet{
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    String accion = request.getParameter("accion");
         
    String strId = request.getParameter("id");
        
         int id = 0;
            if (strId != null && !strId.equals("")) {
                id = Integer.parseInt(strId);
            }
           
        
        String nombreSuc = request.getParameter("nameSuc");
        String strCiudad = request.getParameter("muni");
        
        int idciudad = 0;
        if (strCiudad != null && !strCiudad.equals("")) {
            idciudad = Integer.parseInt(strCiudad);
        }
       
        if ("modificar".equals(accion)) {
            
        Sucursal suc = new Sucursal(id,nombreSuc,idciudad);
        SucursalDao.editar(suc);
        ServletContext sc = getServletContext();
        response.setContentType("text/html;charset=UTF-8");
        RequestDispatcher disp = getServletContext().getRequestDispatcher("/mostrarsuc");
        disp.forward(request, response);
         } else {
            
        Sucursal suc = new Sucursal(nombreSuc, idciudad);
        SucursalDao.insertar(suc);
        ServletContext sc = getServletContext();
        response.setContentType("text/html;charset=UTF-8");
        RequestDispatcher disp = getServletContext().getRequestDispatcher("/mostrarsuc");
        disp.forward(request, response);
        
         }
        //response.sendRedirect("");
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


