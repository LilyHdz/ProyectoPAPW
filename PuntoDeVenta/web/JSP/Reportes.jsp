<%-- 
    Document   : Reportes
    Created on : Nov 11, 2015, 10:01:37 PM
    Author     : Owner
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
         
         <script>
             
             function myFunction() {
                 var numero = document.getElementById("rango").options.selectedIndex;
                 alert(numero);
            }

             function esconde_input(){
                 var elemento1 = document.getElementById("fecha1");
                 var elemento2 = document.getElementById("fecha2");
                 var elemento3 = document.getElementById("fecha_aceptar");
                 
                 var elemento4 = document.getElementById("_texto");
                 var elemento5 = document.getElementById("texto_aceptar");
                 
                 var numero = document.getElementById("rango").options.selectedIndex;
                 
                 switch(numero)
                 {
                     case 0:
                         elemento1.style.display='initial';
                         elemento2.style.display='initial';
                         elemento3.style.display='initial';
                         elemento4.style.display='none';
                         elemento5.style.display='none';

                         break;
                         
                     case 1:
                         elemento1.style.display='none';
                         elemento2.style.display='none';
                         elemento3.style.display='none';
                         elemento4.style.display='initial';
                         elemento5.style.display='initial';
                         break;
                         
                     case 2:
                         elemento1.style.display='none';
                         elemento2.style.display='none';
                         elemento3.style.display='none';
                         elemento4.style.display='initial';
                         elemento5.style.display='initial';
                         break;
                 }
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
            <h4>Reportes</h4>
            
            <div id="filtro">
                <label>Filtar por: </label>
                <select id="rango" onchange="esconde_input();">
                     <option value="1" id="R">Rango de Fecha</option>
                     <option value="2" id="S">Sucursal</option>
                     <option value="3" id="D">Departamentos</option>
                     
                </select>
                 
                <input type="date" id="fecha1" style="display:visible;"> <input type="date" id="fecha2" style="display:visible;" > <button style="display:visible;" id="fecha_aceptar" onclick="myFunction();" > Aceptar </button>
                <input type="text" id="_texto" style="display:none;"> <button id="texto_aceptar" style="display:none;"> Aceptar </button>
            </div>
           
            <div class="TABLA_RE">
                <table>
               
                    <tr><th></th> <th>FECHA DE VENTA</th><th>SUCURSAL</th><th>DEPARTAMENTO</th><th>CAJERO</th><th>ARTICULO</th> <th>DESCRIPCION</th> <th>CANTIDAD</th> <th>PRECIO V.</th> <th>DESCUENTO</th> <th>IMPUESTO</th> <th>SUBTOTAL</th> <th>METODO DE PAGO</th></tr>
                  <tr> 
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td> 
                      <td></td> 
                      <td></td> 
                      <td></td> 
                      <td></td> 
                      <td>dfsfsfsdfdsf</td> 
                      <td></td> 
                      <td></td>
                      <td></td> 
                      <td></td>
                  </tr>
                  
                 <tr>
                      <td></td>
                      <td></td>
                      <td></td>
                      <td></td> 
                      <td></td> 
                      <td></td> 
                      <td></td> 
                      <td></td> 
                      <td></td> 
                      <td></td> 
                      <td></td>
                      <td></td> 
                      <td></td>
                      
                 </tr>
                 
                  <tr>
                      <th>TOTAL</th>
                      <td></td>
                      <td></td>
                      <td></td> 
                      <td></td> 
                      <td></td> 
                      <td></td> 
                      <td></td> 
                      <td></td> 
                      <td></td> 
                      <td></td>
                      <td></td> 
                      <td></td>
                      
                 </tr>
              </table>
                
                <label style="margin-top: 50px; ">TOTAL DE VENTA : $</label>

            </div>  
    </div>
          
            <div></div>
        
        <div id="inferior">
        <h4 id="inferior_1">MercaTodo &reg; S.A de C.V  Miguel Hidalgo 2405 Col. Obispado Monterrey, N.L. 64060</h4>  
        </div>
        
    </div>
    </body>
</html>
