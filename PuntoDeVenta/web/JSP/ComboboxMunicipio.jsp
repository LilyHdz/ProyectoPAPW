
<%@page import="java.sql.ResultSet" %>
<%@page import="papw.dao.UsuarioDao" %>
<%@page import="papw.model.Municipio" %>
<%@page import="papw.model.Estado" %>
<%@page import="papw.dao.ConnectionPool" %>
<%@page import="papw.dao.DBUtil"%>
<%@page import="java.sql.CallableStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import=" java.sql.SQLException"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

    <select name="munic" id="munic">
    <option value="" >---------------Selecciona1--------------</option>
<% 
    try { 
    ConnectionPool pool = ConnectionPool.getInstance();
    Connection connection = pool.getConnection();
    CallableStatement cs = null;
         
    String strId = request.getParameter("estado");
    int id = 0;
            if (strId != null && !strId.equals("")) {
                id = Integer.parseInt(strId);
            }
            
    ResultSet rs = null;
    cs = connection.prepareCall("{ call sp_buscarMunicipios(?) }");
            cs.setInt(1, id);
            rs = cs.executeQuery();
             while (rs.next()) { %>
     
             <option value="<%=rs.getInt("idmunicipio")%>"><%=rs.getString("municipio")%></option>        
             <% } %>   
           <% 
            } catch (Exception ex) {
            ex.printStackTrace();
            
        } finally {
         
           
        }
           %>
    </select>
    

