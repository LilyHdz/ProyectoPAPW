<%-- 
    Document   : Marketing
    Created on : Nov 11, 2015, 10:01:21 PM
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
        <title>Marketing</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        
         <link rel="stylesheet" type="text/css" href="/PuntoDeVenta/CSS/style.css">
    </head>
    
    <body>
        <div class="main">
        
        <header id="Encabezado">  
            
         <img id="Letrero" src="/PuntoDeVenta/images/Logo_Tienda3.png" alt="MercaTodo" >
        <h3>"Donde encuentra de todo"</h3>
         <a id="Salir" href="/PuntoDeVenta/index.jsp" >Cerrar Sesi&oacute;n</a>
        
         <div id="Nav">
            <ul class="navo">
                <li><a href="">Administraci&oacute;n</a>
                       <ul>
                        <li><a href="<%= request.getServletContext().getContextPath()%> /mostrar">Personal</a></li>
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
         
        </header>
            

           
            <div class="merca">
                <label>Programaci&oacute;n de Promocionales</label>
                <table>
                    <tr>
                    <th>Video</th> <th>Hora</th> <th>Dia</th> <th>Mes</th> <th>Sucursak</th>
                    </tr>
                </table>
            </div>
        
        <div id="inferior">
        <h4 id="inferior_1">MercaTodo &reg; S.A de C.V  Miguel Hidalgo 2405 Col. Obispado Monterrey, N.L. 64060</h4>  
        </div>
            
        <div style="clear:both"></div>
    </div>
    </body>
</html>

