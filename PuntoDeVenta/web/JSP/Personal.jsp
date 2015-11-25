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
        
        <header id="Encabezado">  
            
         <img id="Letrero" src="/PuntoDeVenta/images/Logo_Tienda3.png" alt="MercaTodo" >
        <h3>"Donde encuentra de todo"</h3>
         <a id="Salir" href="<%= request.getServletContext().getContextPath()%>/index?accion=borrar" >Cerrar Sesi&oacute;n</a>
        
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
            
          
       <div class="cajita">   
           <button id="AgregarP" onclick="window.location.href='<%= request.getServletContext().getContextPath()%>/mostrar?accion=llenar'" >Agregar Nuevo Empleado</button>
                    
            
            <div class="TABLA_ER">
                <table>
               
                  <tr><th>FOTO</th><th>NOMBRE COMPLETO</th><th>PUESTO</th><th>SUCURSAL</th><th>FECHA NACIMIENTO</th> <th>RFC</th> <th>CURP</th> <th>MUNICIPIO</th> <th>ESTADO</th> <th>Editar</th> <th>Eliminar</th></tr>
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
                      <td><%= puesto %></td> 
                      <td><%= emp.getNombreS() %></td> 
                      <td><%= emp.getFechaN() %></td>
                      <td><%= emp.getRfc() %></td> 
                      <td><%= emp.getCurp() %></td> 
                      <td><%= emp.getNombreM() %></td> 
                      <td><%= emp.getNombreE() %></td> 
                      <td><a href="<%= request.getServletContext().getContextPath()%>/mostrar?accion=borrar&id=<%= emp.getId() %>">Eliminar</a></td> 
                      <td><a href="<%= request.getServletContext().getContextPath()%>/mostrar?accion=editar&id=<%= emp.getId() %>">Editar</a></td> 
                  </tr>
                  <%      }
                }
            %>
              </table>
            </div>
       </div>
        
        <div id="inferior">
        <h4 id="inferior_1">MercaTodo &reg; S.A de C.V  Miguel Hidalgo 2405 Col. Obispado Monterrey, N.L. 64060</h4>  
        </div>
            
            
        <div style="clear:both"></div>
    </div>
    </body>
</html>