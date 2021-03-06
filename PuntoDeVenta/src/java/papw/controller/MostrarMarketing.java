/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package papw.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import papw.dao.PublicidadDao;
import papw.dao.SucursalDao;
import papw.dao.UsuarioDao;
import papw.model.Estado;
import papw.model.Publicidad;
import papw.model.Sucursal;

/**
 *
 * @author Liliana
 */
public class MostrarMarketing extends HttpServlet{
    
        protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        if (session.getAttribute("user") != null) { 
            String accion = request.getParameter("accion");
            String strId = request.getParameter("id");
            
            int id = 0;
            if (strId != null && !strId.equals("")) {
                id = Integer.parseInt(strId);
            }
            
            if ("borrar".equals(accion) && id > 0) {
                SucursalDao.borrar(Integer.parseInt(strId));
                request.setAttribute("mensaje", "Registro borrado exitosamente!");

                List<Sucursal> sucu = SucursalDao.buscarSucursales();
                request.setAttribute("sucu", sucu);

                RequestDispatcher disp = getServletContext().getRequestDispatcher("/JSP/Sucursales.jsp");
                disp.forward(request, response);
                
            }
            else if (("editar".equals(accion) && id > 0) || "agregar".equals(accion)) {
                 List<Sucursal> sucu = SucursalDao.buscarSucursales();
                 request.setAttribute("listSucursal", sucu);

                if ("editar".equals(accion)) {
                    Publicidad publi = PublicidadDao.buscarPublicidad2(id);
                    request.setAttribute("publi", publi);
                }

                RequestDispatcher disp = getServletContext().getRequestDispatcher("/JSP/ModificarVideos.jsp");
                disp.forward(request, response);

            }else {
                List<Sucursal> sucu = SucursalDao.buscarSucursales();
                request.setAttribute("listSucursal", sucu);
                
                List<Publicidad> publicidad = PublicidadDao.buscarPublicidad();
                request.setAttribute("publicidad", publicidad);
                
                RequestDispatcher disp = getServletContext().getRequestDispatcher("/JSP/Marketing.jsp");
                disp.forward(request, response);
            }
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
