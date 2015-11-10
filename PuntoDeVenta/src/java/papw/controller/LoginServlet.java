/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package papw.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import papw.model.Login;
import papw.dao.LoginDao;

/**
 *
 * @author Owner
 */
public class LoginServlet extends HttpServlet{
    
    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String accion = request.getParameter("accion");
        if ("borrar".equals(accion)) {
            HttpSession session = request.getSession();
            session.removeAttribute("user");
            session.invalidate();
            RequestDispatcher disp = getServletContext().getRequestDispatcher("/index.jsp");
            disp.forward(request, response);
            
        } else {
            String strnomina = request.getParameter("nomina");
            String strpassword = request.getParameter("contra");
            
            int noUsuario = 0;
        if (strnomina != null && !strnomina.equals("")) {
            noUsuario = Integer.parseInt(strnomina);
        }
            
            Login user = LoginDao.validarLogin(noUsuario, strpassword);
            if (user != null) {
                if(user.getPuesto().equalsIgnoreCase("C")){
                    HttpSession session = request.getSession();
                    session.setAttribute("user", user);
                    RequestDispatcher disp = getServletContext().getRequestDispatcher("/JSP/CobroArticulo.html");
                    disp.forward(request, response);
                } else {
                    HttpSession session = request.getSession();
                    session.setAttribute("user", user);
                    RequestDispatcher disp = getServletContext().getRequestDispatcher("/JSP/PaginaInicio.html");
                    disp.forward(request, response);
                }
               
            } else {
                String mensaje = "Usuario no existe.";
                request.setAttribute("mensaje", mensaje);
                RequestDispatcher disp = getServletContext().
                        getRequestDispatcher("/index.jsp");
                disp.forward(request, response);
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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
