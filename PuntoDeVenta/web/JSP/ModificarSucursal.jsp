<%-- 
    Document   : ModificarSucursal
    Created on : Nov 15, 2015, 6:28:03 PM
    Author     : Owner
--%>

<%@page import="papw.model.Estado"%>
<%@page import="papw.model.Sucursal"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.io.OutputStream"%>
<%@page import="papw.model.Login"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

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
            

                     
        <%
            Sucursal suc = (Sucursal) request.getAttribute("sucursal");
            int id = 0;
            String nombre = "";
            int  ciudad = 0;

            if (suc != null) {
                id = suc.getId();
                nombre = suc.getNombre() != null ? suc.getNombre() : "";
                
                
            }
        %>
            
            <div class="cajitaSuc" id="esconder" style="display: block">
            <form action="<%= request.getServletContext().getContextPath()%>/sucursal?accion=modificar&id=<%= suc.getId() %>" method="POST" id="sucur" >
                <fieldset >
                    <legend>Ingrese Nueva Sucursal:</legend>
		
                        <table>
                    
                            <tr>
                                <td><label>Nombre(s):</label></td>
                                <td><input name="nameSuc" type="text" style="width:200px; height: 20px;" value="<%= nombre %>"><br></td>
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
             
        <div id="inferior">
        <h4 id="inferior_1">MercaTodo &reg; S.A de C.V  Miguel Hidalgo 2405 Col. Obispado Monterrey, N.L. 64060</h4>  
        </div>
            
            
        <div style="clear:both"></div>
    </div>
    </body>
</html>

