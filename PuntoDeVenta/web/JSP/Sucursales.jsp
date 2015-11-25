<%-- 
    Document   : Personal
    Created on : 11/10/2015, 11:18:24 PM
    Author     : Liliana
--%>
<%@page import="papw.model.Estado"%>
<%@page import="papw.model.Sucursal"%>
<%@page import="papw.model.Login"%>
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
        <title>ADMINISTRACION</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        
         <link rel="stylesheet" type="text/css" href="/PuntoDeVenta/CSS/style.css">
         <script type="text/javascript" src="js/jquery-latest.min.js"></script>
        
       <script type="text/javascript" >
        function mostrar_estado(){
            
            $("#rfc").val("1");
            $.post("/PuntoDeVenta/JSP/ComboboxMunicipio.jsp",$("#sucur").serialize(), function(sucur){ $("#muni").html(sucur);});
        }
       
        </script>
          
       <script type="text/javascript" >
           
	$(document).ready(function()
	    {
	    $("#AgregarP").on( "click", function() {	 
	        $("#esconder").toggle();
	         });
	    });
       
        </script>

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
            <li><a href="/PuntoDeVenta/JSP/ReporteServlet">Reportes</a></li>
            </ul>
             <hr>
         </div>
        </header>
            
         
    <div class="cajita">     
           <button id="AgregarP" >Agregar Sucursal</button>
            
            <div class="cajitaSuc" id="esconder">
            <form action="/PuntoDeVenta/sucursal" method="POST" id="sucur">
                <fieldset >
                    <legend>Ingrese Nueva Sucursal:</legend>
		
                        <table>
                    
                            <tr>
                                <td><label>Nombre(s):</label></td>
                                <td><input name="nameSuc" type="text" style="width:200px; height: 20px;"><br></td>
                            </tr>
                            
                           <tr>
                                <td><label>Estado</label></td>
                                <td><select name="estado" style="width:200px; height: 25px;" id="esta" onchange="mostrar_estado()" >
                                         <option value="" selected>---------Selecciona--------</option>
                                        <%
                                            List<Estado> estados = (List<Estado>) request.getAttribute("estado_");
                                                if (estados != null) {
                                                for (Estado est : estados) {
                                         %>
                                        <option value="<%= est.getId() %>" ><%= est.getNombre() %>  </option>

                                        <%
                                                    }
                                                }
                                        %>
                                        </select></td>    
                            </tr>
                            
                            <tr>
                                <td><label>Municipio</label></td>
                                <td><select  id="muni" name="muni" >
                                    <option value="" selected>---------Selecciona--------</option>
                                   </select></td>   
                            </tr>
                            
                        </table>
                    <br>
                
                    <input type="submit" name="nameFacul" class="AgreButton" value="Guardar">
                    <input type="reset" name="Cancelar" class="AgreButton" value="Cancelar">
                </fieldset>
            </form>
        </div>
            
  
            
            <div class="TABLA_ER">
                <table>
               
                  <tr><th>NOMBRE</th><th>MUNICIPIO</th><th>ESTADO</th><th>Editar</th><th>Eliminar</th></tr>
                   <%
                    List<Sucursal> sucu = (List<Sucursal>) request.getAttribute("sucu");
                    if (sucu != null) {
                    for (Sucursal sucursal : sucu) {
                    %>
                  <tr>
                      <td> <%= sucursal.getNombre()%></td>
                      <td><%= sucursal.getMunicipio() %></td> 
                      <td><%= sucursal.getNombreE() %></td> 
 
                      <td><a href="<%= request.getServletContext().getContextPath()%>/mostrarsuc?accion=editar&id=<%= sucursal.getId() %>">Editar</a></td> 
                      <td><a href="<%= request.getServletContext().getContextPath()%>/mostrarsuc?accion=borrar&id=<%= sucursal.getId() %>">Eliminar</a></td> 
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

