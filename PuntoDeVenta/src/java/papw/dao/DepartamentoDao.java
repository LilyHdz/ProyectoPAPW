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

/**
 *
 * @author Owner
 */
public class DepartamentoDao {
        
    public static void insertar(Departamento e) {
        
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        CallableStatement cs = null;
        try {
            cs = conn.prepareCall("{ call sp_agregarDepartamento(?) }");
            cs.setString(1, e.getNombre());

            int res = cs.executeUpdate();   
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DBUtil.closeStatement(cs);
            pool.freeConnection(conn);
        }
    }
        
        public static List<Departamento> buscarDepartamentos() {
       
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        CallableStatement cs = null;
        ResultSet rs = null;
        try {
            
            List<Departamento> departamento = new ArrayList();
            cs = connection.prepareCall("{ call sp_buscarDepartamentos() }");
            rs = cs.executeQuery();
            while (rs.next()) {
                
                Departamento depa = new Departamento(
                        rs.getInt("idDepartamento"),
                        rs.getString("NombreDepartamento")
                        );
                
                departamento.add(depa);
            }
            return departamento;
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
            cs = connection.prepareCall("{ call sp_eliminarDepartamento(?) }");
            cs.setInt(1, id);
         
            cs.execute();
   
    
            
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DBUtil.closeStatement(cs);
            pool.freeConnection(connection);
        }
    }
        
        public static Departamento buscarDepartamento(int id) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        CallableStatement cs = null;
        ResultSet rs = null;
        try {
            cs = connection.prepareCall("{ call sp_buscarDepartamento(?) }");
            cs.setInt(1, id);
            rs = cs.executeQuery();
            if (rs.next()) {
               Departamento depa = new Departamento(
                        rs.getInt("idDepartamento"),
                        rs.getString("NombreDepartamento"));
                        
                //Departamento d = new Departamento(rs.getInt("departamento_id"));
                //emp.setDepartamento(d);
                return depa;
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
        
        public static void editar(Departamento e) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        CallableStatement cs = null;
        try {
            cs = conn.prepareCall("{call sp_modificarDepartamento(?,?) }");
            
            cs.setString(1, e.getNombre());
            cs.setInt(2, e.getId());
            
            int res = cs.executeUpdate();   
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DBUtil.closeStatement(cs);
            pool.freeConnection(conn);
        }
    }
}
