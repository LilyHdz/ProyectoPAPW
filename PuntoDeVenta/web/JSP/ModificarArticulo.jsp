
<%-- 
    Document   : PaginaInventario
    Created on : Nov 11, 2015, 10:01:00 PM
    Author     : Owner
--%>

<%@page import="papw.model.Articulo"%>
<%@page import="papw.model.Sucursal"%>
<%@page import="papw.model.Departamento"%>
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
        <title>INVENTARIO</title>
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
                    
          <%
            Articulo articulo = (Articulo) request.getAttribute("articulo");
            int id = 0;
            String nombre = "";
            String descripcion = "";
            String descripcionLarga = "";
            int precio = 0;
            String nombreMedida = "";
            String nombreDepartamento = "";
            String aplicaImpuesto = "";
            int descuento = 0;
            int existencia = 0;
            String nombreSucursal = "";

            if (articulo != null) {
                
                id = articulo.getIdArticulo();
                nombre = articulo.getDescripcionCorta() != null ? articulo.getDescripcionCorta() : "";
                descripcion = articulo.getDesCripcionLarga() != null ? articulo.getDesCripcionLarga() : "";
                precio = articulo.getPrecio();
                nombreMedida = articulo.getNombreMedida() != null ? articulo.getNombreMedida() : "";
                nombreDepartamento = articulo.getNombreDepartamento() != null ? articulo.getNombreDepartamento() : "";
                aplicaImpuesto = articulo.getAplicaImpuesto() != null ? articulo.getAplicaImpuesto() : "";
                descuento = articulo.getDescuento();
                existencia = articulo.getExistencia();
                nombreSucursal = articulo.getNombreSucursal() != null ? articulo.getNombreSucursal() : "" ;  
            }
        %>
            
            <div class="cajitaSuc" id="esconder" style="display: block">
            <form enctype="multipart/form-data"  action="<%= request.getServletContext().getContextPath()%>/articulo?accion=modificar&id=<%= articulo.getIdArticulo() %>" method="POST">
                <fieldset >
                    <legend>Articulo:a Editar</legend>
		
                        <table>
                            <tr>
                                <td><label>Imagen de Articulo</label></td><td><input type="file" name="ima" /></td>
                            </tr>
                            
                            <tr>
                                
                                <td><label>Nombre(s):</label></td>
                                <td><input type="text" style="width:200px; height: 20px;" name="nombreP" value="<%= nombre %>"><br></td>
                            </tr>
                            
                            <tr>
                                <td><label>Departamento:</label></td>
                                <td><select  style="width:200px; height: 25px;" name="depa" >
                                    <option value="" selected>------------Selecciona-----------</option>    
                                    <%
                                            List<Departamento> departamento = (List<Departamento>) request.getAttribute("departamento");
                                                if (departamento!= null) {
                                                for (Departamento depa : departamento) {
                                    %>
                                     <option value="<%= depa.getId() %>" ><%= depa.getNombre() %>  </option>

                                        <%
                                                    }
                                                }
                                        %>
                            </tr>
                            <tr>
                                
                                <td><label>Descripci&oacute;n Larga:</label></td>
                                <td><input type="text" style="width:200px; height: 20px;" name="descripcion" value="<%= descripcion %>"><br></td>
                            </tr>
                            
                            <tr>
                                
                                <td><label>Precio Unitario:</label></td>
                                <td><input type="text" style="width:200px; height: 20px;" name="precio" value="<%= precio %>"><br></td>
                            </tr>
                            
                            <tr>
                                
                                <td><label>Unidad de Medida:</label></td>
                                <td><select style="width:200px; height: 25px;" name="uniM" >
                                    <option value="" selected>------------Selecciona-----------</option>    
                                    <%
                                            List<Articulo> unidad = (List<Articulo>) request.getAttribute("unidad");
                                                if (unidad != null) {
                                                for (Articulo medida : unidad) {
                                    %>
                                     <option value="<%= medida.getIdUnidadMedida() %>" ><%= medida.getNombreMedida() %>  </option>

                                        <%
                                                    }
                                                }
                                        %>
                            </tr>
                            
                            <tr>
                                
                                <td><label>Cantidad:</label></td>
                                <td><input type="text" style="width:200px; height: 20px;" name="existencia" value="<%= existencia %>"><br></td>
                            </tr>
                            
                            <tr>      
                            <td> <label>Seleccione Sucursal: </label></td>
                            <td><select style="width:200px; height: 25px;" name="sucursal" >
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
                            
                            </tr>
                            
                            <tr>
                                <td><label>Descuento:</label><br></td>
                                <td><input type="radio" name="descuento" value="0">0
                                <input type="radio" name="descuento" value="10">10%
                                <input type="radio" name="descuento" value="20">20%
                                <input type="radio" name="descuento" value="50">50%</td>
                            </tr> 
                            
                            <tr>
                                <td><label>Impuesto:</label><br></td>
                                <td><input type="radio" name="impuesto" value="Si">Si
                                <input type="radio" name="impuesto" value="No">No</td>
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




