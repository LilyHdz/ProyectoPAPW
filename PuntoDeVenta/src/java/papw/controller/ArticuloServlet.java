/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package papw.controller;

import javax.servlet.http.Part;
import java.io.File;
import papw.model.Articulo;
import papw.dao.ArticuloDao;
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
public class ArticuloServlet extends HttpServlet {
    
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
        
    String accion = request.getParameter("accion");
         
    String strId = request.getParameter("id");
        
         int id = 0;
            if (strId != null && !strId.equals("")) {
                id = Integer.parseInt(strId);
            }
        
        Part filePart = request.getPart("ima");
        
        InputStream inputStream = filePart.getInputStream();
        
        String strdesC = request.getParameter("nombreP");
        String strdesL = request.getParameter("descripcion");
        String strDepa = request.getParameter("depa");
        String strPrecio = request.getParameter("precio");
        String strUnidad = request.getParameter("uniM");
        String strImpuesto = request.getParameter("impuesto");
        String strDesc = request.getParameter("descuento");
        String strexistencia = request.getParameter("existencia");
        String strSucursal = request.getParameter("sucursal");
           
        int iDdepartamento = 0;
        if (strDepa != null && !strDepa.equals("")) {
            iDdepartamento = Integer.parseInt(strDepa);
        }
       
        int Precio = 0;
        if (strPrecio != null && !strPrecio.equals("")) {
            Precio = Integer.parseInt(strPrecio);
        }
        
        int iDunidad = 0;
        if (strUnidad != null && !strUnidad.equals("")) {
            iDunidad = Integer.parseInt(strUnidad);
        }
        
        int Existencia = 0;
        if (strexistencia != null && !strexistencia.equals("")) {
            Existencia = Integer.parseInt(strexistencia);
        }
        
        int descuento = 0;
        if (strDesc != null && !strDesc.equals("")) {
            descuento = Integer.parseInt(strDesc);
        }
        
        int sucursal = 0;
        if (strSucursal != null && !strSucursal.equals("")) {
            sucursal = Integer.parseInt(strSucursal);
        }
        
        if ("modificar".equals(accion)) {
            
        Articulo articulo = new Articulo(id,iDdepartamento, strdesC, strdesL, Precio, iDunidad, strImpuesto ,descuento,Existencia);
        articulo.setSucursal(sucursal);
        ArticuloDao.editar(articulo);
        
        ServletContext sc = getServletContext();
        response.setContentType("text/html;charset=UTF-8");
        RequestDispatcher disp = getServletContext().getRequestDispatcher("/mostrararti");
        disp.forward(request, response);
        
         } else {
            
        Articulo arti = new Articulo(sucursal ,iDdepartamento, strdesC, strdesL, Precio, iDunidad, strImpuesto ,descuento ,inputStream, Existencia);
        ArticuloDao.insertar(arti);
        
        ServletContext sc = getServletContext();
        response.setContentType("text/html;charset=UTF-8");
        RequestDispatcher disp = getServletContext().getRequestDispatcher("/mostrararti");
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
    }// </editor-f
     
}
