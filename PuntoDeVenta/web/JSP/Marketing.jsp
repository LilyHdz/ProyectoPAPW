<%-- 
    Document   : Marketing
    Created on : Nov 11, 2015, 10:01:21 PM
    Author     : Owner
--%>

<%@page import="papw.model.Sucursal"%>
<%@page import="java.util.List"%>
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
                        <li><a href="<%= request.getServletContext().getContextPath()%>/mostrar">Personal</a></li>
                        <li><a href="<%= request.getServletContext().getContextPath()%>/mostrarsuc">Sucursales</a></li>
                        <li><a href="<%= request.getServletContext().getContextPath()%>/mostrardepa">Departamentos</a></li>
                       </ul>
                </li>
                <li><a href="/PuntoDeVenta/JSP/Marketing.jsp">Marketing</a></li>
                <li><a href="<%= request.getServletContext().getContextPath()%>/mostrararti">Inventario</a></li>
                <li><a href="/PuntoDeVenta/ReporteServlet">Reportes</a></li>
            </ul>
            <hr>
         </div>
         
        </header>
            

           
            <div class="merca">
                <form method="post" enctype="multipart/form-data" action="/PuntoDeVenta/MarketingServlet" >
                <label>Programaci&oacute;n de Promocionales</label>
                
                <table>
                    <tr>
                        <th>Eliminar</th>
                        <th>Video</th> 
                        <th>Hora</th> 
                        <th>Dia</th> 
                        <th>Mes</th> 
                        <th>Sucursal</th>
                    </tr>
                    
                    <tr>
                        <th><input type="image" action="/PuntoDeVenta/VentaArticulo"  name="eliminar" class="AgreButton"  value="" src="/PuntoDeVenta/images/cross.png"></th>
                        <th></th>
                    </tr>
                    
                    
                    <tr>
                        <th></th>
                        <th><input type="file" name="archivo" size="50"></th>
                        <th> 
                            
                             <input type="date" name="fechaInicio" >
                            
                             <input type="date" name="fechaFinal" >
                             <% //List<Sucursal> listSucursal = (List<Sucursal>) request.getAttribute("listSucursal"); 
                             %>
                            <select>
                                <option value="" name="">Selecciona una sucursal</option>
                                <%
                                   // for(Sucursal suc:listSucursal)
                                   // {
                                %>
                                <%-- <option value="<%= suc.getId() %>" id="idSucursal" name="idSucursal"> <%= suc.getNombre() %> </option> --%>
                                <%
                                    //}
                                %>
                            </select>
                        </th>
                        <th>
                            <input type="submit" name="videoBoton" method="post" text="agregar" value="agregarVideo">
                        </th>
                    </tr>
                   
                        
                </table>
                </form>
            </div>
        
        <div id="inferior">
        <h4 id="inferior_1">MercaTodo &reg; S.A de C.V  Miguel Hidalgo 2405 Col. Obispado Monterrey, N.L. 64060</h4>  
        </div>
            
        <div style="clear:both"></div>
    </div>
    </body>
</html>

