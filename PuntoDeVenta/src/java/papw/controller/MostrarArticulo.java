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
import papw.dao.ArticuloDao;
import papw.dao.DepartamentoDao;
import papw.dao.SucursalDao;
import papw.model.Articulo;
import papw.model.Departamento;
import papw.model.Sucursal;


public class MostrarArticulo extends HttpServlet  {
   
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
                ArticuloDao.borrar(Integer.parseInt(strId));
                request.setAttribute("mensaje", "Registro borrado exitosamente!");

                RequestDispatcher disp = getServletContext().getRequestDispatcher("/mostrarinfo?accion=articulo");
                disp.forward(request, response);
                
            } else if (("editar".equals(accion) && id > 0) || "agregar".equals(accion)) {
                

                if ("editar".equals(accion)) {
                    List<Departamento> departamento = DepartamentoDao.buscarDepartamentos();
                    List<Sucursal> sucursal =SucursalDao.buscarSucursales();
                    List<Articulo> unidad = ArticuloDao.obtenerMedida();
                    
                    Articulo articulo = ArticuloDao.buscarArticulo(id);
                    
                    request.setAttribute("sucursal", sucursal);
                    request.setAttribute("departamento", departamento);
                    request.setAttribute("articulo", articulo);
                    request.setAttribute("unidad", unidad);
                }

                RequestDispatcher disp = getServletContext().getRequestDispatcher("/JSP/ModificarArticulo.jsp");
                disp.forward(request, response);

            } else {
                
                List<Articulo> arti = ArticuloDao.obtenerArticulos();
                List<Departamento> departamento = DepartamentoDao.buscarDepartamentos();
                List<Sucursal> sucursal =SucursalDao.buscarSucursales();
                List<Articulo> unidad = ArticuloDao.obtenerMedida();

                request.setAttribute("sucursal", sucursal);
                request.setAttribute("departamento", departamento);
                request.setAttribute("arti", arti);
                request.setAttribute("unidad", unidad);
                        
                RequestDispatcher disp = getServletContext().getRequestDispatcher("/JSP/PaginaInventario.jsp");
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
