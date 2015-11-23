/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package papw.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import papw.dao.ArticuloDao;
import papw.dao.ExistenciaDao;
import papw.dao.VentaDao;
import papw.dao.VentaDetalleDao;
import papw.model.Articulo;
import papw.model.Existencia;
import papw.model.Login;
import papw.model.Ticket;
import papw.model.Venta;
import papw.model.VentaDetalle;

/**
 *
 * @author Ayrton
 */
@WebServlet(name = "Venta", urlPatterns = {"/Venta"})
public class VentaServlet extends HttpServlet {

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
            HttpSession session = request.getSession();
            List<Articulo> ticket =(List<Articulo>)session.getAttribute("Ticket");
            
            String codigo = request.getParameter("Codigo");
            String busqueda = request.getParameter("busqueda");
            String agregar = request.getParameter("agregar");
            String eliminar = request.getParameter("eliminar");
            String finalizar=request.getParameter("finalizar");
            String limpiarTicket=request.getParameter("LimpiarTicket");
            String salir = request.getParameter("salir");
            
            if(!"".equals(limpiarTicket)&&limpiarTicket!=null)
            {
                ticket.removeAll(ticket);
                session.removeAttribute("Ticket");    
            }
            

            
            if(!"".equals(finalizar)&&finalizar!=null)
            {
                ticket =(List<Articulo>)session.getAttribute("Ticket");
                int totalVenta =0;
                for(Articulo ticketL :ticket)
                {
                    totalVenta+=ticketL.getCantidad() * ticketL.getPrecio();
                }
                    
                Login user= (Login)session.getAttribute("user");
                Venta venta = new Venta(user.getId(),totalVenta,"Efectivo");
                int idVenta=VentaDao.InsertarVenta(venta);
                
                for(Articulo ticketL :ticket)
                {
                    VentaDetalle ventaDetalle= new VentaDetalle(idVenta,ticketL.getIdArticulo(),ticketL.getCantidad());
                    Existencia existencia = new Existencia(ventaDetalle.getIdArticulo(), ventaDetalle.getCantidad());
                    VentaDetalleDao.insertarVentaDetalle(ventaDetalle);
                    ExistenciaDao.modificarExistencia(existencia);
                }
                
                ticket.removeAll(ticket);
                session.removeAttribute("Ticket");
                
                RequestDispatcher disp =  getServletContext().getRequestDispatcher("/JSP/CobroArticulo.jsp");
               disp.forward(request, response);
            }
            
            if(!"".equals(eliminar)&&eliminar!=null)
            {

              
               ticket.remove(Integer.parseInt(eliminar));
               request.setAttribute("Ticket", ticket);
               
               RequestDispatcher disp =  getServletContext().getRequestDispatcher("/JSP/CobroArticulo.jsp");
               disp.forward(request, response);
               
            }
            
           if(!"".equals(codigo)&&codigo!=null)
           {   

               request.setAttribute("Ticket", ticket);
               
               Articulo articulo = ArticuloDao.obtenerArticulo(codigo);
               request.setAttribute("Articulo", articulo);
               
               RequestDispatcher disp =  getServletContext().getRequestDispatcher("/JSP/CobroArticulo.jsp");
               disp.forward(request, response);
               
           }
           
           if(!"".equals(busqueda)&& busqueda!=null)
           {

               request.setAttribute("Ticket", ticket);
               
               List<Articulo> listArticulo =  ArticuloDao.consultaArticulo(busqueda);
               request.setAttribute("listArticulos", listArticulo);
               
               RequestDispatcher disp =  getServletContext().getRequestDispatcher("/JSP/CobroArticulo.jsp");
               disp.forward(request, response);
               
           }
           
           if(!"".equals(agregar)&&agregar!=null)
           {

               if(ticket != null)
               {
                  String idArticulo =request.getParameter("idProducto");
                  String Cantidad = request.getParameter("cantidad");
                  Articulo articulo =ArticuloDao.obtenerArticulo(idArticulo) ;
                  articulo.setCantidad(Integer.parseInt(Cantidad));
                  
                int existencia =0;
                for(Articulo ticketL :ticket)
                {
                    if(ticketL.getDescripcionCorta().equals(articulo.getDescripcionCorta()))
                    {
                    existencia += ticketL.getCantidad();
                    }
                }             

                existencia += articulo.getCantidad();
                int articuloExistencia = articulo.getExistencia();
                 if(existencia <= articuloExistencia)
                {
                  ticket.add(articulo);
                }
                  session.setAttribute("Ticket", ticket);
                  request.setAttribute("Ticket", ticket);
                 
               }
               else
               {
                String idArticulo =request.getParameter("idProducto");
                String Cantidad = request.getParameter("cantidad");
                ticket = new ArrayList<Articulo>();
                
                Articulo articulo =ArticuloDao.obtenerArticulo(idArticulo) ;
                articulo.setCantidad(Integer.parseInt(Cantidad));
                
                int existencia = 0;

                existencia=articulo.getCantidad();
                int articuloExistencia = articulo.getExistencia();
                if(existencia <= articuloExistencia)
                {
                ticket.add(articulo);
                }
                session.setAttribute("Ticket", ticket);
                request.setAttribute("Ticket", ticket);

               }
               
               RequestDispatcher disp = getServletContext().getRequestDispatcher("/JSP/CobroArticulo.jsp");
               disp.forward(request, response);
               
           }
           
           
               session.setAttribute("Ticket", ticket);
               request.setAttribute("Ticket", ticket);
               
               RequestDispatcher disp = getServletContext().getRequestDispatcher("/JSP/CobroArticulo.jsp");
               disp.forward(request, response);
           
        }
            catch (Exception ex) {
            ex.printStackTrace();
        
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
    }// </editor-fold>

}
