<%-- 
    Document   : Reportes
    Created on : Nov 11, 2015, 10:01:37 PM
    Author     : Owner
--%>

<%@page import="papw.model.Usuario"%>
<%@page import="papw.model.Reporte"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="papw.model.Sucursal"%>
<%@page import="papw.model.Departamento"%>
<%@page import="java.util.List"%>
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
             
             function myFunction() {
                 var numero = document.getElementById("rango").options.selectedIndex;
                 alert(numero);
            }

             function esconde_input(){
                 var elemento1 = document.getElementById("fecha1");
                 var elemento2 = document.getElementById("fecha2");
                 var elemento3 = document.getElementById("fecha_aceptar");
                 
                 var elemento4 = document.getElementById("_departamento");
                 var elemento5 = document.getElementById("texto_aceptar");
                 var elemento6 = document.getElementById("_sucursal");
                 var elemento7 = document.getElementById("_cajero");
                 
                 var numero = document.getElementById("rango").options.selectedIndex;
                 
                 switch(numero)
                 {
                     case 0:
                         elemento1.style.display='initial';
                         elemento2.style.display='initial';
                         elemento3.style.display='none';
                         elemento4.style.display='none';
                         elemento5.style.display='initial';
                         elemento6.style.display='initial';
                         elemento7.style.display='none';
                         break;
                         
                     case 1:
                         elemento1.style.display='initial';
                         elemento2.style.display='initial';
                         elemento3.style.display='none';
                         elemento4.style.display='initial';
                         elemento5.style.display='initial';
                         elemento6.style.display='none';
                         elemento7.style.display='none';
                         break;
                         
                     case 2:
                         elemento1.style.display='initial';
                         elemento2.style.display='initial';
                         elemento3.style.display='none';
                         elemento4.style.display='none';
                         elemento5.style.display='initial';
                         elemento6.style.display='none';
                         elemento7.style.display='initial';
                         break;
                 }
             }

          </script>
          
          <%    
              List<Departamento> listDepartamento= (List<Departamento>) request.getAttribute("listDepartamento");
              List<Sucursal> listSucursal = (List<Sucursal>) request.getAttribute("listSucursal");
              List<Reporte> listReporte = (List<Reporte>)request.getAttribute("listReporte");
              List<Usuario> listUsuario = (List<Usuario>)request.getAttribute("listCajero");
              double Total=0;
              double IVA=0;
              double subtotal=0;
          %>
          
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
                <li><a href="<%= request.getServletContext().getContextPath()%>/mostrarMark">Marketing</a></li>
                <li><a href="<%= request.getServletContext().getContextPath()%>/mostrararti">Inventario</a></li>
                <li><a href="/PuntoDeVenta/ReporteServlet">Reportes</a></li>
            </ul>
           <a class="Salir" href="/PuntoDeVenta/index.jsp" >Cerrar Sesi&oacute;n</a>
            <hr>
         </div>

    <div class="cajita">
            <h4>Reportes</h4>
            
            <div id="filtro">
                <label>Filtar por: </label>
                <select id="rango" onchange="esconde_input();">
                     <option value="1" id="S">Sucursal</option>
                     <option value="2" id="D">Departamentos</option>
                     <option value="3" id="C">Cajero</option>
                     
                </select>
                <form>
                <input type="date" name="fecha1" id="fecha1" style="display:visible;">
                <input type="date" name="fecha2" id="fecha2" style="display:visible;"  >
                <button style="display:visible;"  name="fecha" id="fecha_aceptar" action="/PuntoDeVenta/ReporteServlet"  > Aceptar </button>
                
                <select name="cajero" id="_cajero" style="display:none;" >
                    <option value="" name=""> Selecciona un cajero</option>
                    <% 
                        if(listUsuario!=null)
                        {
                            for (Usuario us:listUsuario)
                            {
                    %>
                    <option value="<%= us.getId() %>" name="idCajero"> <%= us.getNombre() +" "+ us.getApePaterno()  %></option>
                    <%
                            }
                        }
                    %>
                </select>   
                
                <select name="departamento"  id="_departamento" style="display:none;">
                    <option value="" name="">Selecciona un departamento</option>
                    <%
                        if(listDepartamento!=null){
                        for(Departamento dep :listDepartamento)
                        {
                    %>
                    <option value="<%= dep.getId() %>"  name="idDepartamento" > <%= dep.getNombre() %></option>
                    <%
                        }}
                    %>
                </select>
                    
                <select name="sucursal" id="_sucursal" style="display:none;">
                    <option value="" name="">Selecciona una sucursal</option>
                    <%
                        if(listSucursal!=null){
                        for(Sucursal suc:listSucursal)
                        {
                    %>
                    <option value="<%= suc.getId() %>" id="idSucursal" name="idSucursal"> <%= suc.getNombre() %> </option>
                    <%
                        }}
                    %>
                    
                </select>
                    
                <button id="texto_aceptar" name="buscar" action="/PuntoDeVenta/ReporteServlet" style="display:none;"> Aceptar </button>
                </form>
            </div>
                    
            <div class="TABLA_RE">
                <table>
                     <% 
                        double impuesto=0;
                        if(listReporte!=null)
                        {%>
                    <tr>
                        <th>FECHA DE VENTA</th>
                        <th>SUCURSAL</th>
                        <th>DEPARTAMENTO</th>
                        <th>CAJERO</th>
                        <th>ARTICULO</th> 
                        <th>CANTIDAD</th>  
                        <th>DESCUENTO</th> 
                        <th>IMPUESTO</th>  
                        <th>METODO DE PAGO</th>
                    </tr>
                  
                      <%  
                          for(Reporte rep: listReporte)  
                          { 
                      %>
                         <tr> 
                          <td><%= rep.getFechaVenta() %></td>
                          <td><%= rep.getNombreSucursal() %></td>
                          <td><%= rep.getNombreDepartamento() %></td>
                          <td><%= rep.getNombreUsuario() %></td> 
                          <td><%= rep.getDescripcionCorta() %></td> 
                          <td><%= rep.getCantidadProducto() %></td> 
                          <td><%= rep.getDescuento() %></td> 
                          <td><%= impuesto %></td> 
                          <td><%= rep.getFormaPago()  %></td>
                        </tr>
                        <% 
                        subtotal += (rep.getCantidadProducto()-rep.getDescuento()) * rep.getCantidadProducto();
                        if(rep.getAplicaImpuesto()=="S")
                        {
                        IVA=rep.getTotalVenta()*.16f;
                        }
                          }
                          Total=subtotal+IVA;
                          
                      } %>
                  
                  

                 

              </table>
                      
                <label style="margin-top: 50px; ">SUBTOTAL DE VENTA : <%= subtotal %> $</label>
                <label style="margin-top: 50px; ">TOTAL DE IVA : <%= IVA %> $</label>
                <label style="margin-top: 50px; ">TOTAL DE VENTA : <%= Total %> $</label>

            </div>  
    </div>
          
            <div></div>
        
        <div id="inferior">
        <h4 id="inferior_1">MercaTodo &reg; S.A de C.V  Miguel Hidalgo 2405 Col. Obispado Monterrey, N.L. 64060</h4>  
        </div>
        
    </div>
    </body>
</html>
