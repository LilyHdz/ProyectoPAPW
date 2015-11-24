/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package papw.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import papw.dao.DepartamentoDao;
import papw.dao.ReporteDao;
import papw.dao.SucursalDao;
import papw.model.Departamento;
import papw.model.Reporte;
import papw.model.Sucursal;

/**
 *
 * @author Ayrton
 */
public class ReporteServlet extends HttpServlet {

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
            List<Departamento> listDepartamento ;
            List<Sucursal> listSucursal;
            listDepartamento= DepartamentoDao.buscarDepartamentos();
            listSucursal=SucursalDao.buscarSucursales();
            
            String reporteDepartamento= request.getParameter("departamento");
            String reporteSucursal=request.getParameter("sucursal");
            String repoteFecha=request.getParameter("fecha");
            String idDepartamento=request.getParameter("idDepartamento");
            String idSucursal= request.getParameter("idSucursal");
            String fechaInicio=request.getParameter("fecha1");
            String fechaFin=request.getParameter("fecha2");
            
            
            if(!"".equals(reporteDepartamento)&&reporteDepartamento!=null)
            {
                List<Reporte> listReporte;
                listReporte=ReporteDao.consultaReporteDepartamento(Integer.parseInt( reporteDepartamento));
                request.setAttribute("listReporte", listReporte);
            }
            
            if(!"".equals(reporteSucursal)&&reporteSucursal!=null)
            {
                List<Reporte> listReporte;
                listReporte=ReporteDao.consultaReporteDepartamento(Integer.parseInt( reporteSucursal));
                request.setAttribute("listReporte", listReporte);
            }
            
            if((!"".equals(fechaInicio)&&fechaInicio!=null)&&(!"".equals(fechaFin)&&fechaFin!=null))
            {
                List<Reporte> listReporte;
                SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd"); 
                Date date1;
                Date date2;
                fechaInicio=request.getParameter("fecha1");
                fechaFin=request.getParameter("fecha2");
                
                try{
                date1=ft.parse(fechaInicio);
                date2=ft.parse(fechaFin);
                listReporte=ReporteDao.consultaReporteFecha(date1, date2);
                request.setAttribute("listReporte", listReporte);
                }
                catch(ParseException  e)
                {
                   RequestDispatcher disp =  getServletContext().getRequestDispatcher("/JSP/Reportes.jsp");
                   disp.forward(request, response); 
                }
                
            }
            
            
            
            request.setAttribute("listSucursal", listSucursal);
            request.setAttribute("listDepartamento", listDepartamento);
               
            RequestDispatcher disp =  getServletContext().getRequestDispatcher("/JSP/Reportes.jsp");
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
    }// </editor-fold>

}
