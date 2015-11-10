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
        
         <link rel="stylesheet" type="text/css" href="/PuntoDeVenta/CSS/style.css">
    </head>
    
    <body>
        <div class="main">
        
        <header id="Encabezado">  
            
         <img id="Letrero" src="/PuntoDeVenta/images/Logo_Tienda3.png" alt="MercaTodo" >
        <h3>"Donde encuentra de todo"</h3>
         <a id="Salir" href="/PuntoDeVenta/index.jsp" >Cerrar Sesi&oacute;n</a>
        </header>
            
           <div id="Nav">
            
            <ul class="navo">
            <li><a href="">Administraci&oacute;n</a>
                  <ul>
                        <li><a href="/PuntoDeVenta/JSP/Personal.jsp">Personal</a></li>
                        <li><a href="/PuntoDeVenta/JSP/Sucursales.jsp">Sucursales</a></li>
                        <li><a href="/PuntoDeVenta/JSP/Departamentos.jsp">Departamentos</a></li>
                        
                    </ul>
            </li>
            <li><a href="/PuntoDeVenta/JSP/PaginaMarketing.html">Marketing</a></li>
            <li><a href="/PuntoDeVenta/JSP/PaginaInventario.html">Inventario</a></li>
            <li><a href="/PuntoDeVenta/JSP/PaginaReportes.html">Reportes</a></li>
            </ul>
             <hr>
         </div>
            
            <button id="AgregarP" onclick="window.location.href='AgregarPersonal.jsp' ">Agregar Nuevo Empleado</button>
            <div class="Busca"> 
                <label>Buscar personal por: </label>
                <select>
                     <option value="Nombre">NOMBRE</option>
                     <option value="Apellido">APELLIDO</option>
                     <option value="CURP">CURP</option>
                     <option value="Puesto">PUESTO</option>
                </select>
                <input type="text">
                <button>Aceptar</button>                      
            </div>
            
            <div class="TABLA_ER">
                <table>
               
                  <tr><th>FOTO</th><th>NOMBRE COMPLETO</th><th>PUESTO</th><th>SUCURSAL</th> <th>RFC</th> <th>Editar</th> <th>Eliminar</th></tr>
                  <tr>
                      <td><img src="../images/ImagePerson/foto1.jpg" alt="Producto" width="50"></td> 
                      <td> Julia Martinez Vega</td>
                      <td>Cajero</td> 
                      <td>Fundidora</td> 
                      <td>XXXXX</td> 
                      <td><a href="">Editar</a></td> 
                      <td><a href="">Eliminar</a></td> 
                  </tr>
                  
                 <tr>
                     <td><img src="../images/ImagePerson/foto2.png" alt="Producto" width="50"></td> 
                     <td> Aarón Martinez Hernández</td>
                     <td>Manager</td> 
                     <td>Fundidora</td> 
                     <td>XXXXX</td> 
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