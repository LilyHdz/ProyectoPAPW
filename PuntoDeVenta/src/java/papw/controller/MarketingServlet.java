/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package papw.controller;

import java.io.File;
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
import javax.servlet.http.Part;
import papw.dao.DepartamentoDao;
import papw.dao.ReporteDao;
import papw.dao.SucursalDao;
import papw.dao.VideoDao;
import papw.model.Departamento;
import papw.model.Sucursal;
import papw.model.Video;

/**
 *
 * @author Ayrton
 */
public class MarketingServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
    
    */
    
    private String extractExtension(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                String filename = s.substring(s.indexOf("=") + 2, s.length() - 1);
                return filename.substring(filename.indexOf(".") - 1, filename.length());
            }
        }
        return "";
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            List<Sucursal> listSucursal;
            listSucursal=SucursalDao.buscarSucursales();
            
            String agregarVideo =request.getParameter("videoBoton");
            String fechaInicio = request.getParameter("fechaInicio");
            String fechaFin = request.getParameter("fechaFinal");
            String sucursal=request.getParameter("idSucursal");
            String eliminar=request.getParameter("eliminar");
            
            

            
            if(!"".equals(agregarVideo)&&agregarVideo!=null)
            {
                
                Part filePart = request.getPart("archivo");
                Video  video;
                
                 
                 if(filePart !=null && filePart.getSize()>0)
                 {
                     String contentType = filePart.getContentType();
                     if(!contentType.equals("video/mp4"))
                     {
                         /////////////////////request al jsp
                     }
                     else
                     {
                         String uploadPath = getServletContext().getRealPath("/images/videos");
                        File fdir = new File(uploadPath);
                         if (!fdir.exists()) 
                        {
                            fdir.mkdir();
                        }
                         String nombrearchivo = String.valueOf(System.currentTimeMillis());
                         nombrearchivo += extractExtension(filePart);
                         video = new Video();
                         video.setNombre(nombrearchivo);
                         filePart.write(uploadPath+"/"+video.getNombre());
                         SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd"); 
                         Date date1;
                         Date date2;
                         VideoDao.insertarVideo(video,fechaInicio,fechaFin,Integer.parseInt(sucursal));

                        
                     
                         
                     }
                 }
                 
            }
            
             request.setAttribute("listSucursal", listSucursal);
               
            RequestDispatcher disp =  getServletContext().getRequestDispatcher("/JSP/Marketing.jsp");
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
