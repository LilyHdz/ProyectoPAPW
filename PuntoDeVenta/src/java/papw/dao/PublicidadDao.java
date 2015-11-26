/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package papw.dao;

import papw.model.Publicidad;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;

/**
 *
 * @author SAGG
 */
public class PublicidadDao {
    
    public static Publicidad consultaPublicidad(int idUsuario)
    {
         ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        CallableStatement cs = null;
        ResultSet rs = null;
        java.util.Date fromDate = new java.util.Date() ;
        Date sqlDate = new java.sql.Date(fromDate.getTime());
        Publicidad u;
        try {
                cs = connection.prepareCall("{ call sp_consultaPublicidad(?,?) }");
            cs.setInt(1, idUsuario);
            cs.setDate(2, sqlDate);
            rs = cs.executeQuery();
            if (rs.next()) {
                u = new  Publicidad(rs.getString("pathPublicidad"));
                               
                return u;
            }
            else{
            return null;}
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
            
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closeStatement(cs);
            pool.freeConnection(connection);
        }
    }
}
