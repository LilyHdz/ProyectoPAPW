/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package papw.dao;

import papw.model.Login;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

/**
 *
 * @author Owner
 */
public class LoginDao {
    
        public static Login validarLogin(int num, String password) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        CallableStatement cs = null;
        ResultSet rs = null;
        try {
            cs = connection.prepareCall("{ call sp_validarLogin(?, ?) }");
            cs.setInt(1, num);
            cs.setString(2, password);
            rs = cs.executeQuery();
            if (rs.next()) {
                Login u = new Login(
                        rs.getInt("idUsuario"),
                        rs.getString("NumeroNominaUsuario"),
                        rs.getString("PuestoUsuario"),
                        rs.getInt("idSucursal")
                        
                ); 
                               
                return u;
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
}
