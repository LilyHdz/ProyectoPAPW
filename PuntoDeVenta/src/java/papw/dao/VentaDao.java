/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package papw.dao;


//import java.util.Date;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import papw.model.Venta;
import java.sql.Date;
import java.sql.ResultSet;
/**
 *
 * @author Ayrton
 */
public class VentaDao {
    
    
    public static int InsertarVenta(Venta e)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        CallableStatement cs = null;

        java.util.Date fromDate = new java.util.Date() ;
        Date sqlDate = new java.sql.Date(fromDate.getTime());
        ResultSet rs = null;
        int  idVenta=0;
         
        try {
            cs = conn.prepareCall("{call sp_agregarVenta (?,?,?,?,?)}");
            
            cs.setInt(2, e.getIdUsuario());
            cs.setDouble(3, e.getTotalVenta());
            cs.setString(4, e.getFormaPago());
            cs.setDate(1,  sqlDate);
            cs.setInt(5, e.getIdSucursal());
      
            rs = cs.executeQuery();
            while (rs.next()) {
                idVenta = rs.getInt("idVenta");
                }
            return idVenta;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return 0;
        } finally {
            DBUtil.closeStatement(cs);
            pool.freeConnection(conn);
        }
    }
    
}
