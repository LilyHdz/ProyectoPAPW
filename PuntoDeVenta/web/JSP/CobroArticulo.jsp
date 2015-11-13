



<%@page import="papw.model.Ticket"%>
<%@page import="papw.model.Articulo"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%-- 
    Document   : CobroArticulo
    Created on : 10/11/2015, 03:40:38 PM
    Author     : Ayrton
--%>
<%@page import="java.util.List"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <% 
        String limpiarCampo="";
    %>
    <head>
        <title>Punto de Venta</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        
         <link rel="stylesheet" type="text/css" href="/PuntoDeVenta/CSS/styleArt.css">
    </head>
    
<body>
    
    <%          Articulo articulo = (Articulo) request.getAttribute("Articulo");
                
    %>
     
       <div class="main">
        
        <header id="Encabezado">      
            <img id="Letrero" src="/PuntoDeVenta/images/Logo_Tienda3.png" alt="MercaTodo" >
             <a id="Salir" href="" >Salir</a>
            <hr> 
        </header>
            
        <div class="marqueeV">
             <h3>"..::MERCATODO::.."</h3> 
             <h3>"Donde encuentra de todo"</h3>  
        </div>
            
         <hr> 
         <form>
             <input type="submit" action="/PuntoDeVenta/VentaArticulo" method ="post" name="LimpiarTicket" value="Borrar Ticket" class="AgreButton">
         </form>
 
         <div class="Ticket">
             <table width="100%" border="1">
                 <caption>MERCATODO S.A y C.V</caption>
                 <tr class="Renglones"><td>FUNDIDORA</td></tr>
                 <tr class="Renglones"><td>MIGUEL HIDALGO 2405 COL. OBISPADO MTY, N.L. 64060</td></tr>
                 <tr class="Renglones"><td>CALZADA MADERO OTE 1515</td></tr>
                 <tr class="Renglones"><td>TERMINAL 64580</td></tr>
                 <tr class="Renglones"><td>MONTERREY, NUEVO LEON</td></tr>
                 <tr class="Renglones"><td>04/07/215 22:01:07 </td></tr>
             </table>
                <table width="100%" border="1">
               
                    <tr class="ProductList"><th>Eliminar</th> <th>CANT.</th> <th>ARTICULO</th> <th>PRE. UNIT</th> <th>TOTAL</th></tr>
                 
                <% 
    
                    List<Articulo> ticket = (List<Articulo>) request.getAttribute("Ticket");
                    double Total=0;
                    double IVA=0;
                    int Subtotal=0;
                    int index=0;
                    if(ticket!=null) 
                    {
                        for(Articulo ticketL :ticket)
                        {   
                            int totalArticulo =( ticketL.getPrecio()-ticketL.getDescuento()) * ticketL.getCantidad();
                            Subtotal = Subtotal + totalArticulo;
                            if(ticketL.getAplicaImpuesto()==null)
                                ticketL.setAplicaImpuesto("N");
                            if(ticketL.getAplicaImpuesto()=="S")
                            {
                                IVA =IVA + (totalArticulo * .16f);
                            }
                            Total = Subtotal + IVA;
                            
                            
                 %>
                 <form name="_Eliminar" action="/PuntoDeVenta/VentaArticulo" method="POST">
                    <tr class="ProductList">

                        <td><input type="image" action="/PuntoDeVenta/VentaArticulo" method ="post"  name="eliminar" class="AgreButton"  value="<%= index %>" src="/PuntoDeVenta/images/cross.png"></td>
                        <td><%= ticketL.getCantidad() %>  </td>
                        <td><%= ticketL.getDescripcionCorta() %></td> 
                        <td><%= ticketL.getPrecio() %></td>
                        <td> <%= totalArticulo %></td> 
                    </tr>
                 </form>
                 
                 <%
                    index++;
                     }
                    }
                 %>
                 <tr class="ProductList"><th>--------</th> <th>--------</th> <th>---------   IVA  ----------</th> <th>--------</th> <th><%= IVA %></th> </tr>
                 <tr class="ProductList"><th>--------</th> <th>--------</th> <th>--------- Subtotal ----------</th> <th>--------</th> <th><%= Subtotal %></th> </tr>
                 <tr class="ProductList"><th>--------</th> <th>--------</th> <th>---------  TOTAL  ----------</th> <th>--------</th> <th><%= Total %></th> </tr>

                 
                </table>
                <form name="_finalizar" action="/PuntoDeVenta/VentaArticulo" method="POST" >
                    <table width="100%" border="1">

 
                     <tr class="ProductList">
                         <th></th> 
                         <th></th> 
                         <th><input type="submit" action="/PuntoDeVenta/VentaArticulo" method ="post" name="finalizar" value="Finalizar Compra"></th>
                         <th></th> 
                         <th></th> 
                     </tr>
                    </table>
                </form>  
                 
         </div>
           
         <div class="ImProducto">
             
               <div class="CodigoBarras">
            <h2>Codigo de Barras</h2>
            <form name="_Codigo" action="/PuntoDeVenta/VentaArticulo" method="POST">
                 <input type="text" value="" name="Codigo">
             </form>
            </div> 
             <% if(articulo!=null){ %> 
             <table >
                 <caption>Producto</caption>
                 
                 <tr><td><img src="<%= request.getServletContext().getContextPath() + "/ImagenArticulo?id=" + articulo.getIdArticulo() %>" alt="Producto" id="ImagenProducto"></td></tr>


             </table>
                              <%}
                
                 %>
             <form name="_Agregar" action="/PuntoDeVenta/VentaArticulo" method ="POST">
             <table> 
                 <% if(articulo!=null){ %> 
                 <tr>
                     <td>
                         <input type="text" hidden="false" enable="false" visible="false" name="idProducto" value="<%= articulo.getIdArticulo()  %>"> </input>
                         <label > Producto:</label>
                     </td>
                     <td>
                         <label id="lblDescripcionCorta" name="DescripcionCorta"> 
                           
                             <%= articulo.getDescripcionCorta() %>
                         
                         </label>
                     </td>
                 </tr> 
                 <tr>
                     <td>
                         <label>Cantidad </label>
                     </td>
                     <td>
                         <input type="text" value="" name="cantidad">
                     </td>
                 </tr>
                 <tr>
                     <td>
                             <input type="submit" name="agregar" class="AgreButton"  value="Agrega" >                 
                     </td>
                     
                 </tr>
                 <%}
                             %>
             </table>
            </form>
             
         </div>
         
          <div class="Videos">
             <table id="_Video">
                 <tr><td><video src="/PuntoDeVenta/images/Cucaracha_mtv.mp4" width="480" ></video></td></tr>
             </table>
             
         </div>
         
         
         <div class="BusquedaProducto">
             <form name="_Busqueda" action="/PuntoDeVenta/VentaArticulo" method ="post">
                 <table width="100%">
                     <tr><td><label>Búsqueda de Producto : </label></td> 
                         <td>
                             <input type="text" placeholder="CodigoBarras o NombreProducto" name="busqueda"  method="POST">
                             <input type="submit" value="Buscar">
                         </td>
                 </table>
             </form>
             
              <table width="100%" border="1">
                  <tr class="ProductList"><th>ARTICULO</th><th>NOMBRE</th><th>PRE. UNIT</th> <th>DESCRIPCION</th><th>CODIGO</th></tr>
            <%
                List<Articulo> Articulos = (List<Articulo>) request.getAttribute("listArticulos");
                int index2=0;
                if (Articulos != null) {
                    for (Articulo articuloL : Articulos) {
                        
            %>              
                 <tr class="ProductList">
                    
                     <td><img src="<%= request.getServletContext().getContextPath() + "/ImagenArticulo?id=" + articuloL.getIdArticulo() %>" alt="Producto" width="100"></td> 
                     <td><%= articuloL.getDescripcionCorta() %> </td> 
                     <td><%= articuloL.getPrecio() %></td> 
                     <td><%= articuloL.getDesCripcionLarga() %></td>
                     <td><%= articuloL.getIdArticulo()%></td>
                 </tr>
                 
                  
            <%      index2++;
                    }
                }
            %>
                  
                 
                </table>
        </div>
         
        </div>
    </body>
</html>
