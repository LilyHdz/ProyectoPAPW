<%-- 
    Document   : PaginaInventario
    Created on : Nov 11, 2015, 10:01:00 PM
    Author     : Owner
--%>

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
             
             function visible_div(op){
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
            <button id="AgregarP" onclick="visible_div();">Agregar Articulo</button>
            
            <div class="cajitaSuc" id="esconder">
            <form enctype="multipart/form-data"  action="/PuntoDeVenta/articulo" method="POST">
                <fieldset >
                    <legend>Ingrese Nuevo Articulo:</legend>
		
                        <table>
                            <tr>
                                <td><label>Imagen de Articulo</label></td><td><input type="file" name="ima" /></td>
                            </tr>
                            
                            <tr>
                                
                                <td><label>Nombre(s):</label></td>
                                <td><input type="text" style="width:200px; height: 20px;" name="nombreP"><br></td>
                            </tr>
                            
                            <tr>
                                
                                <td><label>Departamento:</label></td>
                                <td><input type="text" style="width:200px; height: 20px;" name="depa" ><br></td>
                            </tr>
                            
                            <tr>
                                
                                <td><label>Descripci&oacute;n Larga:</label></td>
                                <td><input type="text" style="width:200px; height: 20px;" name="descripcion" ><br></td>
                            </tr>
                            
                            <tr>
                                
                                <td><label>Precio Unitario:</label></td>
                                <td><input type="text" style="width:200px; height: 20px;" name="precio" ><br></td>
                            </tr>
                            
                            <tr>
                                
                                <td><label>Unidad de Medida:</label></td>
                                <td><input type="text" style="width:200px; height: 20px;" name="uniM" ><br></td>
                            </tr>
                            
                            <tr>
                                
                                <td><label>Cantidad:</label></td>
                                <td><input type="text" style="width:200px; height: 20px;" name="existencia"><br></td>
                            </tr>
                            
                            <tr>
                                
                            <td> <label>Seleccione Sucursal: </label></td>
                            <td><select name="sucursal">
                            <option value="1">Sucursal 1</option>
                            <option value="2">Sucursal 2</option>
                            <option value="3">Sucursal 3</option>
                            <option value="4">Sucursal 4</option>
                            </select></td>
                            
                            </tr>
                            
                            <tr>
                                <td><label>Descuento:</label><br></td>
                                <td><input type="radio" name="descuento" value="50">50%
                                <input type="radio" name="descuento" value="25">25%
                                <input type="radio" name="descuento" value="10">10%</td>
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
                     
          <div class="Inv">
                <label>Seleccione Sucursal: </label>
                <select>
                     <option value="1">Sucursal 1</option>
                     <option value="2">Sucursal 2</option>
                     <option value="3">Sucursal 3</option>
                     <option value="4">Sucursal 4</option>
                </select>
                <button>Aceptar</button>             
            </div>
            
            <div id="filtro">
                <label>Filtar por: </label>
                <select>
                     <option value="1">Nombre</option>
                     <option value="2">Departamento</option>
                     <option value="3">Codigo</option>
                     
                </select>
                 
                 <input type="text"><button>Aceptar</button>
            </div>
            
            
            <div class="TABLA_ER">
                <table>
               
                    <tr><th>CODIGO</th><th>FOTO</th><th>ARTICULO</th><th>DEPARTAMENTO</th><th>DESCRIPCION</th> <th>PRECIO PUBLICO</th> <th>U. M.</th> <th>EXISTENCIA</th> <th>SUCURSAL</th> <th>Editar</th> <th>Eliminar</th></tr>
                  <tr> 
                      <td> 1000</td>
                      <td><img src="../images/ImagePerson/foto1.jpg" alt="Producto" width="50"></td>
                      <td>Pan</td> 
                      <td>Panaderia</td> 
                      <td>XXXXX</td> 
                      <td>$34.00</td> 
                      <td>1 kg</td> 
                      <td>10</td> 
                      <td>10</td> 
                      <td><a href="">Editar</a></td> 
                      <td><a href="">Eliminar</a></td>
                     
                  </tr>

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



