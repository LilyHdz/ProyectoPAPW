/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package papw.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import papw.model.Venta;
import papw.model.VentaDetalle;

/**
 *
 * @author Ayrton
 */
public class VentaDetalleDao {
    static public void insertarVentaDetalle (VentaDetalle e)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        CallableStatement cs = null;

        
        
        try {
            cs = conn.prepareCall("{call sp_agregarVentaDetalle (?,?,?)}");
            
            cs.setInt(1,  e.getIdVenta());
            cs.setInt(2, e.getIdArticulo());
            cs.setInt(3, e.getCantidad());

            int res = cs.executeUpdate();   
              
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DBUtil.closeStatement(cs);
            pool.freeConnection(conn);
        }
    }
}
