
<%@page import="papw.model.Usuario"%>
<%@page import="java.util.List"%>
<%@page import="papw.model.Sucursal"%>
<%@page import="papw.model.Estado"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>

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
            $.post("/PuntoDeVenta/JSP/ComboboxMunicipio.jsp",$("#dataf").serialize(), function(dataf){ $("#muni").html(dataf);});
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
            

                     
        <%
            Usuario persona = (Usuario) request.getAttribute("usuario");
            int id = 0;
            String nombre = "";
            String apePaterno = "";
            String apeMaterno = "";
            String Puesto = "";
            String sexo = "";
            String NivelEstudio = "";
            String rfc = "";
            String curp = "";
            int nomina = 0;
            
            String calle = "";
            int numero = 0;
            String colonia = "";
            int municipio = 0;
            int estado = 0;
            int postal = 0;
            String contrasena = "";
            int idsuc = 0;
            
            int deptoId = 0;
            
            if (persona != null) {
                id = persona.getId();
                nombre = persona.getNombre() != null ? persona.getNombre() : "";
                apePaterno = persona.getApePaterno() != null ? persona.getApePaterno() : "";
                apeMaterno = persona.getApeMaterno() != null ? persona.getApeMaterno() : "";
                sexo = persona.getSexo();
                Puesto = persona.getPuesto() != null ? persona.getPuesto() : "";
                
            }
        %>
         
         
         <div class="cajita">
            <form enctype="multipart/form-data" action="<%= request.getServletContext().getContextPath()%>/update?accion=modificar&id=<%= persona.getId() %>" method="POST" id="dataf" >
                <fieldset >
                    <legend>Ingrese la informaci&oacute;n:</legend>
		
                        <table>
                            <tr>
                                <td><label>Foto de Empleado:</label></td>
                                <td><img src="" alt="Producto" width="50"></td>
                                <td><input type="file" name="foto"/></td>
                            </tr>
                            <tr>
                                <td><label>Nombre(s):</label></td>
                                <td><input type="text" style="width:200px; height: 20px;" name="nombre" value="<%= nombre %>" ><br></td>
                            </tr>
                            
                             <tr>
                                <td><label>Apellido Paterno:</label></td>
                                <td><input type="text" style="width:200px; height: 20px;" name="apP" value="<%= nombre %>"><br></td>
                            </tr>
                             <tr>
                                <td><label>Apellido Materno:</label></td>
                                <td><input type="text" style="width:200px; height: 20px;" name="apM" value="<%= nombre %>"><br></td>
                            </tr>
                            
                            <tr>
                                <td><label>Sucursal:</label></td>
                                <td><select id="Suc" style="width:200px; height: 25px;" name="Suc" >
                                    <option value="" selected>------------Selecciona-----------</option>    
                                    <%
                                            List<Sucursal> sucursal = (List<Sucursal>) request.getAttribute("sucursal");
                                                if (sucursal != null) {
                                                for (Sucursal sucu : sucursal) {
                                    %>
                                     <option value="<%= sucu.getId() %>" ><%= sucu.getNombre() + "-" + sucu.getNombreM() %>  </option>

                                        <%
                                                    }
                                                }
                                        %>
                                
                            </select><br></td>                      
                             </tr>
                             
                             <tr>
                                <td><label>Puesto:</label></td>
                                <td><select id="_puesto" style="margin-left:50px; margin-top: 10px; width:100px" name="_puesto">
                                <option value="M" id="M">Manager</option>
                                <option value="C" id="C">Cajero</option>
                            </select><br></td>                      
                             </tr>
                    
                            <tr>
                                <td><label>Sexo:</label><br></td>
                                <td><input type="radio" name="Genero" value="H">Hombre
                                <input type="radio" name="Genero" value="M">Mujer</td>
                            </tr>
                    
                            <tr>
                                <td><label>Fecha de Nacimiento:</label></td>
                                <td><input type="date" style="width:200px; height: 25px;" name="fecha"><br></td>
                            </tr>
                            
                            <tr>
                                <td><label>Contrasena:</label></td>
                                <td><input type="password" style="width:200px; height: 20px;" name="contra" value="<%= nombre %>"><br></td>
                            </tr>
 
                            <tr>
                                <td> <label>Nivel de Estudios:</label></td>
                                <td><select name="study" style="width:200px; height: 25px;">
                                        <option value="Primaria" selected>Primaria</option>
                                        <option value="Secundaria">Secundaria</option>
                                        <option value="Preparatoria">Preparatoria</option>
                                        <option value="Licenciatura">Licenciatura</option>
                                        <option value="Ingenieria">Ingenieria</option>
                                        <option value="Maestria">Maestria</option>
                                        <option value="Doctorado">Doctorado</option>
                                     </select></td>
                            </tr>
                
                            <tr>
                                <td><label>Calle</label></td>
                                <td><input type="text" style="width:200px; height: 25px;" name="calle" value="<%= nombre %>"><br></td>     
                            </tr>  
                            
                             <tr>
                                <td><label>Numero</label></td>
                                <td><input type="text" style="width:200px; height: 25px;" name="calle_num" value="<%= nombre %>"><br></td>     
                            </tr>  
                            
                            <tr>
                                <td><label>C&oacute;digo Postal</label></td>
                                <td><input type="text" style="width:200px; height: 25px;" name="postal" value="<%= nombre %>"><br></td>     
                            </tr>
                            
                            <tr>
                                <td><label>Colonia</label></td>
                                <td><input type="text" style="width:200px; height: 25px;" name="colonia" value="<%= nombre %>"><br></td>     
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
                            
                            <tr>
                                <td><label>RFC:</label></td>
                                <td><input type="text" name="rfc" style="width:200px; height: 20px;" value="<%= nombre %>" id="rfc" ><br></td>                      
                             </tr>
                    
                             <tr>
                                <td><label>CURP:</label></td>
                                <td><input type="text" name="curp" style="width:200px; height: 20px;" value="<%= nombre %>"><br></td>                      
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
