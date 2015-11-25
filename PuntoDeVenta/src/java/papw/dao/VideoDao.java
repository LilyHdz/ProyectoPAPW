/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package papw.dao;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import static papw.dao.ArticuloDao.Codigo;
import static papw.dao.ArticuloDao.existencia;
import papw.model.Articulo;
import papw.model.Video;
import java.util.Date;

/**
 *
 * @author Ayrton
 */
public class VideoDao {
    public static void insertarVideo(Video v,Date fechaInicio,Date fechaFin,int idSucursal)
    {
         ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        CallableStatement cs = null;
        CallableStatement cs2 = null;
        try {
            cs = conn.prepareCall("{ call sp_agregarVideo(?) }");
            cs.setString(1, v.getNombre());
            int res = cs.executeUpdate();  
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DBUtil.closeStatement(cs);
            pool.freeConnection(conn);
        }
    }
}
