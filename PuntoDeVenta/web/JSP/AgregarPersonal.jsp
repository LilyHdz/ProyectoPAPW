
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->

<%@page import="papw.model.Usuario"%>
<%@page import="papw.model.Sucursal"%>
<%@page import="papw.model.Estado"%>
<%@page import="java.util.List"%>

<!DOCTYPE html>
<html>
    <head>
        <title>ADMINISTRACION</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="/PuntoDeVenta/CSS/style.css">
 
       <script type="text/javascript" src="js/jquery-latest.min.js"></script>
       <script src="validCampoFranz.js"></script>
        
       <script type="text/javascript" >
           
        function mostrar_estado(){
            $.post("/PuntoDeVenta/JSP/ComboboxMunicipio.jsp",$("#dataf").serialize(), function(dataf){ $("#muni").html(dataf);});
        }
        
       function soloLetras(e){
       key = e.keyCode || e.which;
       tecla = String.fromCharCode(key).toLowerCase();
       letras = " �����abcdefghijklmn�opqrstuvwxyz";
       especiales = "8-37-39-46";

       tecla_especial = false
       for(var i in especiales){
            if(key == especiales[i]){
                tecla_especial = true;
                break;
            }
        }

        if(letras.indexOf(tecla)==-1 && !tecla_especial){
            return false;
        }
    }
   

       $(document).ready(function (){
          $(".solo-numero").keyup(function (){
            this.value = (this.value + '').replace(/[^0-9]/g, '');
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
            <div>
            <form enctype="multipart/form-data" action="/PuntoDeVenta/update" method="POST" id="dataf" >
                <fieldset>
                    <legend>Ingrese la informaci&oacute;n:</legend>
		
                    <table style="padding-left: 10px;">
                            <tr>
                                <td><label>Foto de Empleado:</label></td><td><input type="file" name="foto"/></td>
                            </tr>
                            <tr>
                                <td><label>Nombre(s):</label></td>
                                <td><input type="text"  style="width:200px; height: 20px;" onkeypress="return soloLetras(event)" name="nombre" required=""><br></td>
                            </tr>
                            
                             <tr>
                                <td><label>Apellido Paterno:</label></td>
                                <td><input type="text"  style="width:200px; height: 20px;" onkeypress="return soloLetras(event)" name="apP"  required=""><br></td>
                            </tr>
                             <tr>
                                <td><label>Apellido Materno:</label></td>
                                <td><input type="text" style="width:200px; height: 20px;" onkeypress="return soloLetras(event)" name="apM"  required=""><br></td>
                            </tr>
                            
                            <tr>
                                <td><label>Sucursal:</label></td>
                                <td><select id="Suc" style="width:200px; height: 25px;" name="Suc" required="">
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
                                <td><select id="_puesto" style="margin-left:50px; margin-top: 10px; width:100px" name="_puesto" required="">
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
                                <td><input type="date" style="width:200px; height: 25px;" name="fecha" value="" required=""><br></td>
                            </tr>
                            
                            <tr>
                                <td><label>Contrasena:</label></td>
                                <td><input type="password" style="width:200px; height: 20px;" name="contra" required=""><br></td>
                            </tr>
 
                            <tr>
                                <td> <label>Nivel de Estudios:</label></td>
                                <td><select name="study" style="width:200px; height: 25px;" required="">
                                        <option value="" selected>---------Selecciona--------</option>
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
                                <td><input type="text"  style="width:200px; height: 25px;" onkeypress="return soloLetras(event)" name="calle"  required=""><br></td>     
                            </tr>  
                            
                             <tr>
                                <td><label>Numero</label></td>
                                <td><input  type="text"   class="solo-numero" style="width:200px; height: 25px;" name="calle_num" maxlength="4" required=""><br></td>     
                            </tr>  
                            
                            <tr>
                                <td><label>C&oacute;digo Postal</label></td>
                                <td><input  type="text"   class="solo-numero" style="width:200px; height: 25px;" name="postal" id="postal" maxlength="5" required="" ><br></td>     
                            </tr>
                            
                            <tr>
                                <td><label>Colonia</label></td>
                                <td><input type="text"  style="width:200px; height: 25px;" onkeypress="return soloLetras(event)" name="colonia"  required=""><br></td>     
                            </tr>
                            
                            <tr>
                                <td><label>Estado</label></td>
                                <td><select name="estado" style="width:200px; height: 25px;" id="esta" onchange="mostrar_estado()" required="">
                                         <option value="" selected>---------Selecciona--------</option>
                                        <%
                                            List<Estado> estado = (List<Estado>) request.getAttribute("estado");
                                                if (estado != null) {
                                                for (Estado est : estado) {
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
                                <td><select  id="muni" name="muni" required="" >
                                    <option value="" selected>---------Selecciona--------</option>
                                   </select></td>   
                            </tr>
                             
                            <tr>
                                <td><label>RFC:</label></td>
                                <td><input type="text" id="rfc" maxlength="14" name="rfc" style="width:200px; height: 20px;" required=""><br></td>                      
                             </tr>
                    
                             <tr>
                                <td><label>CURP:</label></td>
                                <td><input type="text" id="curp" maxlength="18" name="curp" style="width:200px; height: 20px;" required=""><br></td>                      
                             </tr>
                             
                             <tr>
                                <td><label>Numero de N&oacute;mina:</label></td>
                                <td><input  type="text"  class="solo-numero" name="nomina" style="width:200px; height: 20px;" required=""><br></td>  
                             </tr>
                        </table>
                                        
                         <br>
                        <input type="submit" name="nameFacul" class="AgreButton" value="Guardar">
                        <input type="reset" name="Cancelar" class="AgreButton" value="Cancelar">

                </fieldset>
            </form>
           <div>
        </div>
                                        
        <div id="inferior">
        <h4 id="inferior_1">MercaTodo &reg; S.A de C.V  Miguel Hidalgo 2405 Col. Obispado Monterrey, N.L. 64060</h4>  
        </div>
           
        <div style="clear:both"></div>
     </div>
                                        
    </body>
</html>