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
        
        <header id="Encabezado">  
            
         <img id="Letrero" src="/PuntoDeVenta/images/Logo_Tienda3.png" alt="MercaTodo" >
         <h3>"Donde encuentra de todo"</h3>
        
        <div id="Salir"><a  href="/PuntoDeVenta/index.jsp" >Cerrar Sesi&oacute;n</a></div>
        </header>
            
         <div id="Nav">
            
            <ul class="navo">
            <li><a href="">Administraci&oacute;n</a>
                    <ul>
                        <li><a href="<%= request.getServletContext().getContextPath()%>/mostrar">Personal</a></li>
                        <li><a href="<%= request.getServletContext().getContextPath()%>/mostrarsuc">Sucursales</a></li>
                        <li><a href="<%= request.getServletContext().getContextPath()%>/mostrardepa">Departamentos</a></li>
                        
                    </ul>
                    
            </li>
            <li><a href="/PuntoDeVenta/JSP/Marketing.jsp">Marketing</a></li>
            <li><a href="/PuntoDeVenta/JSP/PaginaInventario.jsp">Inventario</a></li>
            <li><a href="/PuntoDeVenta/JSP/Reportes.jsp">Reportes</a></li>
            </ul>
             <hr>
         </div>
            <div class="index">
                <p>El mejor supermercado del pais MERCATODO :D</p>
                 <img id="ima1" src="/PuntoDeVenta/images/supermarket.jpg" alt="MercaTodo" >
                  <img id="ima2" src="/PuntoDeVenta/images/supermercado.jpg" alt="MercaTodo" >
                   <img id="ima3" src="/PuntoDeVenta/images/Promociom.png" alt="MercaTodo" >
            </div>
        <div id="inferior">
        <h4 id="inferior_1">MercaTodo &reg; S.A de C.V  Miguel Hidalgo 2405 Col. Obispado Monterrey, N.L. 64060</h4>  
        </div>
         <div style="clear:both"></div>
    </div>
    </body>
</html>

