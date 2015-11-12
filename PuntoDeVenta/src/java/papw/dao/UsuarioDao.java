/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package papw.dao;

import java.io.InputStream;
import papw.model.Usuario;
import java.util.Date;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

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
            cs = conn.prepareCall("{ call sp_agregarUsuario(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }");
            cs.setString(1, e.getNombre());
            cs.setString(2, e.getApePaterno());
            cs.setString(3, e.getApeMaterno());
            cs.setString(4, e.getPuesto());
            cs.setString(5, e.getSexo());
            cs.setString(6, e.getNivelEstudio());
            cs.setString(7, e.getRfc());
            cs.setString(8, e.getCurp());
            cs.setInt(9, e.getNomina());
            cs.setBlob(10, e.getFotostream());
            cs.setString(11, e.getCalle());
            cs.setInt(12, e.getNumero());
            cs.setString(13, e.getColonia());
            cs.setInt(14, e.getMunicipio());
            cs.setInt(15, e.getEstado());
            cs.setInt(16, e.getPostal());
            cs.setString(17, e.getContrasena());
            cs.setInt(18, e.getIdSucursal());

            int res = cs.executeUpdate();   
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DBUtil.closeStatement(cs);
            pool.freeConnection(conn);
        }
    }
        
        public static List<Usuario> buscarPersonal() {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        CallableStatement cs = null;
        ResultSet rs = null;
        try {
            List<Usuario> usuario = new ArrayList();
            cs = connection.prepareCall("{ call buscar_todos() }");
            rs = cs.executeQuery();
            while (rs.next()) {
                Usuario user = new Usuario(
                        rs.getInt("idUsuario"),
                        rs.getString("NombreUsuario"), 
                        rs.getString("ApellidoParternoUsuario"), 
                        rs.getString("ApellidoMaternoUsuario"),
                        rs.getString("PuestoUsuario"),
                        rs.getString("SexoUsuario"),
                        rs.getString("NivelEstudioUsuario"),
                        rs.getString("RfcUsuario"),
                        rs.getString("CurpUsuario"),
                        rs.getInt("NumeroNominaUsuario"),
                        rs.getBinaryStream("FotoUsuario"),
                        rs.getString("Calle"),rs.getInt("numero"), 
                        rs.getString("Colonia"),
                        rs.getInt("idmunicipio"),
                        rs.getInt("idEstado"),
                        rs.getInt("CodigoPostal"),
                        rs.getString("Contasena"));
                
                usuario.add(user);
            }
            return usuario;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
            
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closeStatement(cs);
            pool.freeConnection(connection);
        }
    }
        
        public static InputStream obtenerImagen(int id) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        CallableStatement cs = null;
        ResultSet rs = null;
        try { 
            cs = connection.prepareCall("{ call imagen(?) }");
            cs.setInt(1, id);
            rs = cs.executeQuery();
            if (rs.next()) {
                return rs.getBinaryStream(1);
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
        
        public static void borrar(int id) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        CallableStatement cs = null;
        try {
            cs = connection.prepareCall("{ call sp_eliminarUsuario(?) }");
            cs.setInt(1, id);
            //cs.registerOutParameter(2, Types.BIT);
            cs.execute();
            //byte res = cs.getByte(2);
            //System.out.println("[Borrar] Resultado=" + res);
            
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DBUtil.closeStatement(cs);
            pool.freeConnection(connection);
        }
    }
        
        public static Usuario buscarPersona(int id) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        CallableStatement cs = null;
        ResultSet rs = null;
        try {
            cs = connection.prepareCall("{ call buscar_persona(?) }");
            cs.setInt(1, id);
            rs = cs.executeQuery();
            if (rs.next()) {
               Usuario user = new Usuario(
                        rs.getInt("idUsuario"),
                        rs.getString("NombreUsuario"), 
                        rs.getString("ApellidoParternoUsuario"), 
                        rs.getString("ApellidoMaternoUsuario"),
                        rs.getString("PuestoUsuario"),
                        rs.getString("SexoUsuario"),
                        rs.getString("NivelEstudioUsuario"),
                        rs.getString("RfcUsuario"),
                        rs.getString("CurpUsuario"),
                        rs.getInt("NumeroNominaUsuario"),
                        rs.getBinaryStream("FotoUsuario"),
                        rs.getString("Calle"),rs.getInt("numero"), 
                        rs.getString("Colonia"),
                        rs.getInt("idmunicipio"),
                        rs.getInt("idEstado"),
                        rs.getInt("CodigoPostal"),
                        rs.getString("Contasena"),
                        rs.getInt("idSucursal"));
                //Departamento d = new Departamento(rs.getInt("departamento_id"));
                //emp.setDepartamento(d);
                return user;
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
