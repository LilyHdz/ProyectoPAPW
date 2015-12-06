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
import java.util.ArrayList;
import java.util.List;

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
    
public static List<Publicidad> buscarPublicidad()
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        CallableStatement cs = null;
        ResultSet rs = null;
        try { 
            List<Publicidad> publicidad = new ArrayList();
            cs = connection.prepareCall("{ call sp_buscarPublicidad() }");
            rs = cs.executeQuery();
            while (rs.next()) {
                
                Publicidad u = new  Publicidad(rs.getString("pathPublicidad")); 
                u.setDia(rs.getInt("dia"));
                u.setHorarios(rs.getInt("horario"));
                u.setNomSuc(rs.getString("NombreSucursal"));
                u.setIdPublicidad(rs.getInt("idPublicidad"));
               
                publicidad.add(u);
            }
            return publicidad;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
            
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closeStatement(cs);
            pool.freeConnection(connection);
        }
    }

 public static Publicidad buscarPublicidad2(int id)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        CallableStatement cs = null;
        ResultSet rs = null;
        
        try {
            cs = connection.prepareCall("{ call sp_buscarPublicidad2(?) }");
            cs.setInt(1, id);
            rs = cs.executeQuery();
            if (rs.next()) {
              Publicidad u = new  Publicidad(rs.getInt("idPublicidad"));
              u.setDia(rs.getInt("dia"));
              u.setHorarios(rs.getInt("horario"));
              u.setPathPublicidad(rs.getString("PathPublicidad"));
                               
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
