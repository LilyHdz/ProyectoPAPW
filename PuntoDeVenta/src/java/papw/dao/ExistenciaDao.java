/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package papw.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import papw.model.Existencia;

/**
 *
 * @author Ayrton
 */
public class ExistenciaDao {
        static public void modificarExistencia (Existencia e)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        CallableStatement cs = null;
        try {
            cs = conn.prepareCall("{call sp_modificarExistencia (?,?)}");
            
            cs.setInt(1,  e.getIdArticulo());
            cs.setInt(2, e.getCantidadExistencia());

            int res = cs.executeUpdate();   
              
        } 
        catch (Exception ex) 
        {
            ex.printStackTrace();
        } 
        finally {
            DBUtil.closeStatement(cs);
            pool.freeConnection(conn);
        }
    }
}
