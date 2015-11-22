<%-- 
    Document   : Personal
    Created on : 11/10/2015, 11:18:24 PM
    Author     : Liliana
--%>

<%@page import="papw.model.Departamento"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.io.OutputStream"%>
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
         
         <script>
             function esconde_div(){
                 var elemento = document.getElementById('esconder');
                 elemento.style.display = 'none';
             }
             
             function visible_div(){
                 var elemento = document.getElementById('esconder');
                 elemento.style.display='block';
             }
    
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
            <li><a href="/PuntoDeVenta/JSP/PaginaInventario.jsp">Inventario</a></li>
            <li><a href="/PuntoDeVenta/JSP/Reportes.jsp">Reportes</a></li>
            </ul>
             <hr>
         </div>
         
        </header>
 
        <div class="cajita">
            <button id="AgregarP" onclick="visible_div();">Agregar Departamento</button>
            
            <div class="cajitaSuc" id="esconder">
            <form action="/PuntoDeVenta/departamento" method="POST">
                <fieldset >
                    <legend>Ingrese Nuevo Departamento:</legend>
		
                        <table>
                    
                            <tr>
                                <td><label>Nombre(s):</label></td>
                                <td><input name="nomDepa" type="text" style="width:200px; height: 20px;"><br></td>
                            </tr>
                            
                        </table>
                    <br>
                
                    <input type="submit" name="nameFacul" class="AgreButton" value="Guardar">
                    <input type="reset" name="Cancelar" class="AgreButton" value="Cancelar">
                </fieldset>
            </form>
        </div>
                     
            <div class="Busca">
                <form method="post">
                <label>Buscar: </label>
                <input type="text"/>
                <input type="submit" value="Aceptar"/>
               </form>
                                     
            </div>
            
            <div class="TABLA_ER">
                <table>
               
                  <tr><th>Departamento</th></tr>
                    <%
                    List<Departamento> depa = (List<Departamento>) request.getAttribute("dep");
                    if (depa != null) {
                    for (Departamento departa : depa) {
                    %>
                  <tr>
                      <td><%= departa.getNombre()%></td>
                      <td><a href="<%= request.getServletContext().getContextPath()%>/mostrardepa?accion=editar&id=<%= departa.getId() %>">Editar</a></td> 
                      <td><a href="<%= request.getServletContext().getContextPath()%>/mostrardepa?accion=borrar&id=<%= departa.getId() %>">Eliminar</a></td> 
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


