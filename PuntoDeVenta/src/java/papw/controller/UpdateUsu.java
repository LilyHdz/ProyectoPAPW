/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package papw.controller;

import papw.dao.UsuarioDao;
import papw.model.Usuario;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author Owner
 */
public class UpdateUsu extends HttpServlet  {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nombre = request.getParameter("nombre");
        String apePaterno = request.getParameter("apP");
        String apeMaterno = request.getParameter("apM");
        String strPuesto = request.getParameter("_puesto");
        String strSexo = request.getParameter("Genero");
        String strFecha = request.getParameter("fecha");
        String strNivel = request.getParameter("study");
        String strCalle = request.getParameter("calle");
        String strCalle_num = request.getParameter("calle_num");
        String strColonia = request.getParameter("colonia");
        String strPostal = request.getParameter("postal");
        String strCiudad = request.getParameter("ciudad");
        String strEstado = request.getParameter("estado");
        String strRfc = request.getParameter("rfc");
        String strCurp = request.getParameter("curp");
        String strNomina = request.getParameter("nomina");
        String strContrasena = request.getParameter("contra");
        
        int id = 0;
       
        int idestado = 0;
        if (strEstado != null && !strEstado.equals("")) {
            idestado = Integer.parseInt(strEstado);
        }
        
        int calle_num = 0;
        if (strCalle_num != null && !strCalle_num.equals("")) {
            calle_num = Integer.parseInt(strCalle_num);
        }
        
         int postal = 0;
        if (strPostal != null && !strPostal.equals("")) {
            postal = Integer.parseInt(strPostal);
        }
        
        int idciudad = 0;
        if (strCiudad != null && !strCiudad.equals("")) {
            idciudad = Integer.parseInt(strCiudad);
        }
        
        int nomina = 0;
        if (strNomina != null && !strNomina.equals("")) {
            nomina = Integer.parseInt(strNomina);
        }
        
        
        
        
        Usuario usuario = new Usuario(id,nombre, apePaterno, apeMaterno, strPuesto, strSexo, strNivel, strRfc, strCurp,nomina, strFecha, strCalle, calle_num, strColonia, idciudad, idestado,postal, strContrasena);
   
            UsuarioDao.insertar(usuario);
 
        
        ServletContext sc = getServletContext();
        RequestDispatcher disp = sc.getRequestDispatcher("/lista");
        disp.forward(request, response);
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
