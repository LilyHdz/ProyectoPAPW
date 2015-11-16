
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package papw.controller;

import papw.dao.UsuarioDao;
import papw.controller.Encriptar;
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
   
    private final String directorio = "archivos"; 
    
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
            
        String uploadPath = getServletContext().getRealPath("/" + directorio + "/");
        System.out.println("PATH: " + uploadPath);
        
        File fdir = new File(uploadPath);
        if (!fdir.exists()) {
            fdir.mkdir();
        }
        
        Part filePart = request.getPart("foto");
        
        InputStream inputStream = filePart.getInputStream();
        
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
        String strSucursal = request.getParameter("Suc");
        
       
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
        
        int idsucursal = 0;
        if (strSucursal != null && !strSucursal.equals("")) {
            idsucursal = Integer.parseInt(strSucursal);
        }
        
        Encriptar enc = new Encriptar();
        
        String encripContra =  enc.Encrip(strContrasena);
        
        if ("modificar".equals(accion)) {
        Usuario usuario = new Usuario(id,nombre, apePaterno, apeMaterno, strPuesto, strSexo, strNivel, strRfc, strCurp, strCalle, calle_num, strColonia,idciudad, idestado,postal,encripContra,idsucursal);
        UsuarioDao.editar(usuario);
        ServletContext sc = getServletContext();
        response.setContentType("text/html;charset=UTF-8");
        RequestDispatcher disp = getServletContext().getRequestDispatcher("/JSP/Personal.jsp");
        disp.forward(request, response);
         } else {
        Usuario usuario = new Usuario(nombre, apePaterno, apeMaterno, strPuesto, strSexo, strNivel, strRfc, strCurp,nomina,inputStream, strCalle, calle_num, strColonia,idciudad, idestado,postal,encripContra,idsucursal);
        UsuarioDao.insertar(usuario);
        ServletContext sc = getServletContext();
        response.setContentType("text/html;charset=UTF-8");
        RequestDispatcher disp = getServletContext().getRequestDispatcher("/JSP/Personal.jsp");
        disp.forward(request, response);
        
         }
        //response.sendRedirect("");
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