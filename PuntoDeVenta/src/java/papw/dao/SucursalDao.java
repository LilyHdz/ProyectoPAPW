/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package papw.dao;

import papw.model.Departamento;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import papw.model.Sucursal;

/**
 *
 * @author Owner
 */
public class SucursalDao {
    
     public static void insertar(Sucursal e) {
        
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        CallableStatement cs = null;
        try {
            cs = conn.prepareCall("{ call sp_agregarSucursal(?,?) }");
            cs.setString(1, e.getNombre());
            cs.setInt(2, e.getMunicipio());

            int res = cs.executeUpdate();   
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DBUtil.closeStatement(cs);
            pool.freeConnection(conn);
        }
    }
        
        public static List<Sucursal> buscarSucursales() {
       
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        CallableStatement cs = null;
        ResultSet rs = null;
        try {
            
            List<Sucursal> sucursal = new ArrayList();
            cs = connection.prepareCall("{ call sp_buscarSucursales() }");
            rs = cs.executeQuery();
            while (rs.next()) {
                
                Sucursal suc = new Sucursal(
                        rs.getInt("idSucursal"),
                        rs.getString("NombreSucursal"),
                        rs.getInt("idmunicipio")
                        );
                
                sucursal.add(suc);
            }
            return sucursal;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
            
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closeStatement(cs);
            pool.freeConnection(connection);
        }
    }
        
        
        public static void borrar(int id) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        CallableStatement cs = null;
        try {
            cs = connection.prepareCall("{ call sp_sp_eliminarSucursal(?) }");
            cs.setInt(1, id);
         
            cs.execute();
   
    
            
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DBUtil.closeStatement(cs);
            pool.freeConnection(connection);
        }
    }
        
        public static Sucursal buscarSucursal(int id) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        CallableStatement cs = null;
        ResultSet rs = null;
        try {
            cs = connection.prepareCall("{ call sp_buscarSucursal(?) }");
            cs.setInt(1, id);
            rs = cs.executeQuery();
            if (rs.next()) {
               Sucursal suc = new Sucursal(
                        rs.getInt("idSucursal"),
                        rs.getString("NombreSucursal"),
                        rs.getInt("idmunicipio"));
                        
                //Departamento d = new Departamento(rs.getInt("departamento_id"));
                //emp.setDepartamento(d);
                return suc;
            }
            return null;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
            
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closeStatement(cs);
            pool.freeConnection(connection);
        }
    }
        
        public static void editar(Sucursal e) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        CallableStatement cs = null;
        try {
            cs = conn.prepareCall("{call sp_modificarSucursal(?,?,?) }");

            cs.setInt(1, e.getId());
            cs.setString(2, e.getNombre());
            cs.setInt(3, e.getMunicipio());
            
            int res = cs.executeUpdate();   
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DBUtil.closeStatement(cs);
            pool.freeConnection(conn);
        }
    }
}
