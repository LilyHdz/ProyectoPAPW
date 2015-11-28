<%-- 
    Document   : PaginaInicio
    Created on : Nov 11, 2015, 3:02:40 AM
    Author     : Owner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>BIENVENIDO</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        
         <link rel="stylesheet" type="text/css" href="/PuntoDeVenta/CSS/style.css">
    </head>
    
    <body>
        
        <div class="main">
              
        <div id="Nav">
            
            <ul class="navo">
            <li><a href="">Administraci&oacute;n</a>
                    <ul>
                        <li><a href="<%= request.getServletContext().getContextPath()%>/mostrar">Personal</a></li>
                        <li><a href="<%= request.getServletContext().getContextPath()%>/mostrarsuc">Sucursales</a></li>
                        <li><a href="<%= request.getServletContext().getContextPath()%>/mostrardepa">Departamentos</a></li>
                        
                    </ul>
                    
            </li>
            <li><a href="/PuntoDeVenta/JSP/Marketing.jsp"> Marketing</a></li>
            <li><a href="<%= request.getServletContext().getContextPath()%>/mostrararti"> Inventario  </a></li>
            <li><a href="/PuntoDeVenta/ReporteServlet"> Reportes </a></li>
            </ul>
            
            <div class="Salir"><a  href="/PuntoDeVenta/index.jsp" >Cerrar Sesi&oacute;n</a></div>
             <hr>
         </div>
        
            <div class="cajita">
               <div class="index">
                    
                   <table>
                       <tr>
                           <td><img src="/PuntoDeVenta/images/supermarket.jpg" alt="MercaTodo" width="245" height="145" ></td> <td><img src="/PuntoDeVenta/images/verduras.jpeg" alt="MercaTodo" width="245" height="145" ></td>
                       </tr>
                       <tr>
                           <td><img src="/PuntoDeVenta/images/cajera.jpg" alt="MercaTodo" width="245" height="145"  ></td> <td><img  src="/PuntoDeVenta/images/supermercado.jpg" alt="MercaTodo" width="245" height="145" ></td>
                       </tr>
                   </table>
                   
                </div>
                
            </div>
            
        <div id="inferior" style="clear:both">
        <h4 id="inferior_1">MercaTodo &reg; S.A de C.V  Miguel Hidalgo 2405 Col. Obispado Monterrey, N.L. 64060</h4>  
        </div>
      
    </div>
    </body>
</html>

