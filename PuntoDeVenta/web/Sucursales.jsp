<%-- 
    Document   : Personal
    Created on : 11/10/2015, 11:18:24 PM
    Author     : Liliana
--%>

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
        
         <link rel="stylesheet" type="text/css" href="style.css">
         
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
            
         <img id="Letrero" src="images/Logo_Tienda3.png" alt="MercaTodo" >
        <h3>"Donde encuentra de todo"</h3>
         <a id="Salir" href="index.jsp" >Cerrar Sesión</a>
        </header>
            
           <div id="Nav">
            
            <ul class="navo">
            <li><a href="PaginaAdministracion.html">Administración</a>
                  <ul>
                        <li><a href="Personal.jsp">Personal</a></li>
                        <li><a href="Sucursales.jsp">Sucursales</a></li>
                        <li><a href="Departamentos.jsp">Departamentos</a></li>
                        <li><a href="Articulos.html">Articulos</a></li>
                    </ul>
            </li>
            <li><a href="PaginaMarketing.html">Marketing</a></li>
            <li><a href="PaginaInventario.html">Inventario</a></li>
            <li><a href="PaginaReportes.html">Reportes</a></li>
            </ul>
             <hr>
         </div>
                     
            <button id="AgregarP" onclick="visible_div();">Agregar Sucursal</button>
            
            <div class="cajitaSuc" id="esconder">
            <form action="" method="POST">
                <fieldset >
                    <legend>Ingrese Nueva Sucursal:</legend>
		
                        <table>
                    
                            <tr>
                                <td><label>Nombre(s):</label></td>
                                <td><input type="text" style="width:200px; height: 20px;"><br></td>
                            </tr>
                            
                             <tr>
                                 <td><select>
                                    <option value="Estado">Estado</option>
                                    <option value="Nuevo Leon">Nuevo Leon</option>
                                     </select></td>
                                 <td><select>
                                    <option value="Municipio">Municipio</option>
                                    <option value="Cadereyta Jimenez">Cadereyta Jimenez</option>
                                         </select></td>
                            </tr>
                        </table>
                    <br>
                
                    <input type="submit" name="nameFacul" class="AgreButton" value="Guardar">
                    <input type="submit" name="Cancelar" class="AgreButton" value="Cancelar">
                </fieldset>
            </form>
        </div>
            
            <div class="Busca">
                <label>Buscar sucursal: </label>
                <select>
                     <option value="Estado">Estado</option>
                     <option value="Nuevo Leon">Nuevo Leon</option>
                </select>
                <select>
                     <option value="Municipio">Municipio</option>
                     <option value="Cadereyta Jimenez">Cadereyta Jimenez</option>
                </select>
                <button>Aceptar</button>                      
            </div>
            
            <div class="TABLA_ER">
                <table>
               
                  <tr><th>NOMBRE</th><th>MUNICIPIO</th><th>ESTADO</th><th>Editar</th><th>Eliminar</th></tr>
                  <tr>
                      <td> Julia Martinez Vega</td>
                      <td>Cadereyta Jimenez</td> 
                      <td>Nuevo Leon</td>  
                      <td><a href="">Editar</a></td> 
                      <td><a href="">Eliminar</a></td> 
                  </tr>
                  
                 <tr>
                     <td> Aarón Martinez Hernández</td>
                     <td>Guadalupe</td> 
                     <td>Nuevo Leon</td>  
                      <td><a href="">Editar</a></td> 
                      <td><a href="">Eliminar</a></td> 
                 </tr>
              </table>
            </div>
        
        <div id="inferior">
        <h4 id="inferior_1">MercaTodo &reg; S.A de C.V  Miguel Hidalgo 2405 Col. Obispado Monterrey, N.L. 64060</h4>  
        </div>
            
            
        <div style="clear:both"></div>
    </div>
    </body>
</html>

