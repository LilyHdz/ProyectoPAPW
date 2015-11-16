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
import papw.model.Departamento;
import papw.dao.DepartamentoDao;
/**
 *
 * @author Owner
 */
public class MostrarDepartamentos extends HttpServlet{
    
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
                DepartamentoDao.borrar(Integer.parseInt(strId));
                request.setAttribute("mensaje", "Registro borrado exitosamente!");

                List<Departamento> dep = DepartamentoDao.buscarDepartamentos();
                request.setAttribute("dep", dep);

                RequestDispatcher disp = getServletContext().getRequestDispatcher("/JSP/Departamentos.jsp");
                disp.forward(request, response);
                
            } else if (("editar".equals(accion) && id > 0) || "agregar".equals(accion)) {
                //List<Departamento> departamentos = DepartamentoDao.buscarDepartamentos();
                //request.setAttribute("departamentos", departamentos);

                if ("editar".equals(accion)) {
                    Departamento departamento = DepartamentoDao.buscarDepartamento(id);
                    request.setAttribute("departamento", departamento);
                }

                RequestDispatcher disp = getServletContext().getRequestDispatcher("/JSP/ModificarDepartamento.jsp");
                disp.forward(request, response);

            } else {
               List<Departamento> dep = DepartamentoDao.buscarDepartamentos();
                request.setAttribute("dep", dep);

                RequestDispatcher disp = getServletContext().getRequestDispatcher("/JSP/Departamentos.jsp");
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
