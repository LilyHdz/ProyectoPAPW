<%-- 
    Document   : ModificarVideos
    Created on : 3/12/2015, 01:45:59 AM
    Author     : Liliana
--%>
<%@page import="papw.model.Sucursal"%>
<%@page import="papw.model.Publicidad"%>
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
          <script type="text/javascript" src="js/jquery-latest.min.js"></script>
        
            <script type="text/javascript" >
           
            $(document).ready(function()
	    {
	    $("#boton1").on( "click", function() {	 
	        $("#horario").toggle();
                $("#contenido1").text("");
	         });
	    });
            
            $(document).ready(function()
	    {
	    $("#boton2").on( "click", function() {	 
	        $("#dia").toggle();
                 $("#contenido2").text("");
	         });
	    });
                        
            </script>
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
            
        <h2>Programaci&oacute;n de Promocionales</h2>  
        
        <table class="mercaM">
            <tr>
                <th>Horario</th>
                <th>Hora</th>
            </tr>
            <tr>
                <td>Matutino</td>
                <td>10:00 am <br>- 12:00 pm</td>
            </tr> 
            <tr>
                <td>Vespertino</td>
                <td>12:00 pm <br>- 6:00 pm</td>
            </tr> 
            <tr>
                <td>Nocturno</td>
                <td>6:00 pm <br>- 10:00 pm</td>
            </tr> 
         </table>

         <%
            Publicidad publi = (Publicidad) request.getAttribute("publi");
            int id = 0;
            int dia = 0;
            int hora = 0;
            String path = "";


            if (publi != null) {
                
                id = publi.getIdPublicidad();
                dia = publi.getDia();
                hora = publi.getHorarios();
                path = publi.getPathPublicidad() != null ? publi.getPathPublicidad() : "";
 
            }
        %>
        
         <div class="TABLA_ER" style="">
           <fieldset>
            <legend>Ingrese Nuevo Horaio-Video:</legend>
            <form method="post" enctype="multipart/form-data" action="/PuntoDeVenta/MarketingServlet?accion=modificar&id=<%=id%>">
                <table>
                    <tr>
                        <th>Video</th> 
                        <th>Hora</th> 
                        <th>Dia</th> 
                        <th>Sucursal</th>
                    </tr>
                    
                    <tr>  
                         <td><video  width="480"  width="128" height="240" controls muted>
                                    <% if(publi != null) {
                                        char cha =92;
                                        char cha2 =47;
                                        
                                    %>
                                    
                                    <source src="<%= getServletContext().getContextPath()+"/images/videos/"+ publi.getPathPublicidad() %>" type="video/mp4">
                                    <% 
                                    }
                                     %>
                                    
                                    Your browser does not support HTML5 video.
                            </video></td>   
                        <td>                                                    
                 <label type="text" value="<%=publi.getHorarios()%>" id="contenido1" name="contenido1"><%=Publicidad.horario(publi.getHorarios())%> </label> 
                 <label id="boton1"value="toggle()" >Cambiar</label> 
                 <select name="horario" id="horario" style="display: none;">
                                <option id="1" value="1">Matutino</option>
                                <option id="2" value="2">Vespertino</option>
                                <option id="3" value="3">Nocturno</option>
                            </select>    
                        </td>
                        <td>
                <label type="text" value="<%=publi.getDia()%>" id="contenido2" name="contenido2"><%=Publicidad.dia(publi.getDia())%> </label>
                <label id="boton2"value="toggle()" >Cambiar</label> 
                <select name="dia" id="dia" style="display: none;">
                                <option value="1">Domingo</option>
                                <option value="2">Lunes</option>
                                <option value="3">Martes</option>
                                <option value="4">Miercoles</option>
                                <option value="5">Jueves</option>
                                <option value="6">Viernes</option>
                                <option value="7">Sabado</option>
                            </select></td> 
                        <td>    
                            <% List<Sucursal> listSucursal = (List<Sucursal>) request.getAttribute("listSucursal"); 
                             %>
                            <select name="idSucursal">
                                <option value="" name="">Selecciona una sucursal</option>
                                <%
                                    if (listSucursal != null) {
                                    for(Sucursal suc: listSucursal)
                                    {
                                %>
                                <option value="<%= suc.getId() %>" id="idSucursal" > <%= suc.getNombre() %> </option>
                                <%
                                    }
                                 }
                                %>
                            </select></td> 
                    </tr>   
                </table>
                <input type="submit" name="videoBoton" method="post" text="agregar" value="Guardar"></td>   
                </fieldset>
            </form>
        </div>
                              
        </div>
        
        <div id="inferior">
        <h4 id="inferior_1">MercaTodo &reg; S.A de C.V  Miguel Hidalgo 2405 Col. Obispado Monterrey, N.L. 64060</h4>  
        </div>
            
        <div style="clear:both"></div>
    </div>
    </body>
</html>


