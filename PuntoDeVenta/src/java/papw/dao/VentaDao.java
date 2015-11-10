/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package papw.dao;


import java.util.Date;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import papw.model.Venta;

/**
 *
 * @author Ayrton
 */
public class VentaDao {
    
    
    public static void InsertarVenta(Venta e)
    {
            ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        CallableStatement cs = null;
        Date time = new Date();
        
        
        try {
            cs = conn.prepareCall("{call sp_agregarVenta (?,?,?,?)}");
            cs.setDate(1, (java.sql.Date) time);
            cs.setInt(2, e.getIdUsuario());
            cs.setInt(3, e.getTotalVenta());
            cs.setString(4, e.getFormaPago());
            
               int res = cs.executeUpdate();   
                
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DBUtil.closeStatement(cs);
            pool.freeConnection(conn);
        }
    }
}
