<%-- 
    Document   : index
    Created on : 10/10/2015, 04:27:23 PM
    Author     : Liliana
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Bienvenido</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="CSS/style.css">

</head>
<body>
    <div class="main">
        <header id="Encabezado">  
            
            <img id="Letrero" src="images/Logo_Tienda3.png" alt="MercaTodo" >
            <h3>"Donde encuentra de todo"</h3>
        </header>
    
    <div class="Login">
        
        <form action="JSP/PaginaInicio.html">
         
            <h4>Iniciar Sesión</h4>
            <table id="Tabla">
                <tr>
                    <td><label>No. Empleado </label></td>
                </tr>
                <tr>
                    <td><input type="text"  size="35" ></td>
                </tr>
                <tr>
                    <td><label>Contraseña </label></td>
                </tr>
                 <tr>
                    <td><input type="password" size="35"> </td>
                </tr>
            </table>
            <input  type="submit" value="Entrar" class="Botones">
            <input  type="submit" value="Cancelar" class="Botones"> 
            <br><a href="" id="OlvidoContra">Olvido su contraseña?</a>
        </form>
        
    </div>
        
        <div class="Vision">
        <aside >
            <h2>Nuestra Misión y Valores</h2>
            <p>Nuestro compromiso diario, desde 1963, es ganar la confianza de 
                nuestros clientes, ofreciendo siempre los mejores productos, los 
                mejores precios y la atención personalizada que ellos merecen.<br><br>
                MercaTodo se ha consolidado como una compañía privada de autoservicios 
                de mayor expansión y trascendencia en Texas y en las zonas Norte y 
                Bajío de México y es reconocida por su gran calidad y buen servicio.<br><br>

                Distinguiéndose siempre por ser una empresa comprometida tanto con sus 
                clientes como con su comunidad, MercaTodo continúa creciendo y sobre todo, 
                manteniendo su compromiso de servicio, frescura, calidad y los precios 
                más bajos. </p>
            
        </aside>
        </div>
        
    <div id="inferior">
        <h4 id="inferior_1">MercaTodo &reg; S.A de C.V  Miguel Hidalgo 2405 Col. Obispado Monterrey, N.L. 64060</h4>  
    </div>
        
        <div style="clear:both"></div>
    </div>

</body>
</html>

