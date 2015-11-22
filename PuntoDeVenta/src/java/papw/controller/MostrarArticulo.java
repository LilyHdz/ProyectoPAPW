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
import papw.model.Articulo;


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
//                UsuarioDao.borrar(Integer.parseInt(strId));
//                request.setAttribute("mensaje", "Registro borrado exitosamente!");
//
//                List<Usuario> usuario = UsuarioDao.buscarPersonal();
//                request.setAttribute("usuario", usuario);
//
//                RequestDispatcher disp = getServletContext().getRequestDispatcher("/mostrarinfo");
//                disp.forward(request, response);
                
            } else if (("editar".equals(accion) && id > 0) || "agregar".equals(accion)) {
                

                if ("editar".equals(accion)) {
//                    List<Estado> estado = UsuarioDao.buscarEstados();
//                    List<Sucursal> sucursal =SucursalDao.buscarSucursales();
//                    Usuario usuario = UsuarioDao.buscarPersona(id);
//                    request.setAttribute("usuario", usuario); 
//                    request.setAttribute("sucursal", sucursal);
//                    request.setAttribute("estado_", estado);
                }

                RequestDispatcher disp = getServletContext().getRequestDispatcher("/JSP/ModificarPersonal.jsp");
                disp.forward(request, response);

            } else if ("llenar".equals(accion)) {
                
                String strIdE = request.getParameter("idE");
                int idE = 0;
                if (strIdE != null && !strIdE.equals("")) {
                idE = Integer.parseInt(strIdE);
                }
            
//                List<Estado> estado = UsuarioDao.buscarEstados();
//                List<Sucursal> sucursal =SucursalDao.buscarSucursales();

//                request.setAttribute("sucursal", sucursal);
//                request.setAttribute("estado", estado);
                
                RequestDispatcher disp = getServletContext().getRequestDispatcher("/JSP/AgregarPersonal.jsp");
                disp.forward(request, response);
                
            } else {
                List<Articulo> arti = ArticuloDao.obtenerArticulos();
                request.setAttribute("arti", arti);
            
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
