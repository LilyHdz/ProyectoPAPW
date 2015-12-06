<%-- 
    Document   : Personal
    Created on : 11/10/2015, 11:18:24 PM
    Author     : Liliana
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="papw.model.Usuario"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.io.OutputStream"%>
<%@page import="papw.model.Login"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>ADMINISTRACION</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        
         <link rel="stylesheet" type="text/css" href="/PuntoDeVenta/CSS/style.css">
    </head>
    
    <body >
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
            <li><a href="<%= request.getServletContext().getContextPath()%>/mostrarMark">Marketing</a></li>
            <li><a href="<%= request.getServletContext().getContextPath()%>/mostrararti">Inventario</a></li>
            <li><a href="/PuntoDeVenta/ReporteServlet">Reportes</a></li>
            </ul>
             <a class="Salir" href="<%= request.getServletContext().getContextPath()%>/index?accion=borrar" >Cerrar Sesi&oacute;n</a>
             <hr>
         </div>
            
          
       <div id="cajitaPersonal">   
           <div class="TABLA_ER">
           <button id="AgregarP" onclick="window.location.href='<%= request.getServletContext().getContextPath()%>/mostrar?accion=llenar'" ><img src="/PuntoDeVenta/images/garra.png" alt="Producto" width="20" style="padding-right: 8px;">Agregar Nuevo Empleado</button>               
           
           <table border="1">  
                  <tr><th>Foto</th><th>Nombre Completo</th><th>Puesto</th><th>Sucursal</th><th>Fecha de Nacimiento</th><th>CURP</th> <th>Municipio</th> <th>Estado</th> <th>Eliminar</th> <th>Editar</th></tr>
                   <%
                    List<Usuario> usu = (List<Usuario>) request.getAttribute("usuario");
                    String puesto = "";
                    if (usu != null) {
                    for (Usuario emp : usu) {
                        
                        if(emp.getPuesto().equalsIgnoreCase("m")) puesto = "Manager";
                        else  puesto= "Cajero";
                            
                    %>
                  
                  <tr>
                      <td><img src="<%= request.getServletContext().getContextPath() + "/imagen?id=" + emp.getId() %>" alt="Producto" width="50"></td> 
                      <td> <%= emp.getNombre() + ' ' + emp.getApePaterno() + ' ' +emp.getApeMaterno() %></td>
                      <td><%=puesto %></td> 
                      <td><%= emp.getNombreS() %></td> 
                      <td><%=emp.getFechaN() %></td>
                      <td><%=emp.getCurp() %></td> 
                      <td><%=emp.getNombreM() %></td> 
                      <td><%=emp.getNombreE() %></td> 
                      <td><a href="<%= request.getServletContext().getContextPath()%>/mostrar?accion=borrar&id=<%= emp.getId() %>">Eliminar</a></td> 
                      <td><a href="<%= request.getServletContext().getContextPath()%>/mostrar?accion=editar&id=<%= emp.getId() %>">Editar</a></td> 
                  </tr>
                  <%      }
                }
            %>
              </table>
           </div> 
       
       </div>
    <div style="clear:both"></div>
        <div id="inferior">
        <h4 id="inferior_1">MercaTodo &reg; S.A de C.V  Miguel Hidalgo 2405 Col. Obispado Monterrey, N.L. 64060</h4>  
        </div> 
    </div>
    </body>
</html>