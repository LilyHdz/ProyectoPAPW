/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package papw.dao;

import papw.model.Usuario;
import java.util.Date;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Owner
 */
public class UsuarioDao {
    
    
        public static void insertar(Usuario e) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        CallableStatement cs = null;
        try {
            cs = conn.prepareCall("{ call sp_agregarUsuario(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }");
            cs.setString(1, e.getNombre());
            cs.setString(2, e.getApePaterno());
            cs.setString(3, e.getApeMaterno());
            cs.setString(4, e.getPuesto());
            cs.setString(5, e.getSexo());
            cs.setString(6, e.getNivelEstudio());
            cs.setString(7, e.getRfc());
            cs.setString(8, e.getCurp());
            cs.setInt(9, e.getNomina());
            cs.setString(10, e.getCalle());
            cs.setInt(11, e.getNumero());
            cs.setString(12, e.getColonia());
            cs.setInt(13, e.getMunicipio());
            cs.setInt(14, e.getEstado());
            cs.setInt(15, e.getPostal());
            cs.setString(16, e.getContrasena());

            int res = cs.executeUpdate();            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DBUtil.closeStatement(cs);
            pool.freeConnection(conn);
        }
    }
}
