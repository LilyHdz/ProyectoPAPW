/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package papw.dao;

import java.io.InputStream;
import papw.model.Usuario;
import papw.model.Estado;
import papw.model.Municipio;
import java.util.Date;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import papw.controller.Encriptar;

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
            cs = conn.prepareCall("{ call sp_agregarUsuario(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }");
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
            cs.setString(11, e.getFechaN());
            cs.setString(12, e.getCalle());
            cs.setInt(13, e.getNumero());
            cs.setString(14, e.getColonia());
            cs.setInt(15, e.getMunicipio());
            cs.setInt(16, e.getEstado());
            cs.setInt(17, e.getPostal());
            cs.setString(18, e.getContrasena());
            cs.setInt(19, e.getIdSucursal());

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
             Encriptar enc = new Encriptar();
        
            
            List<Usuario> usuario = new ArrayList();
            cs = connection.prepareCall("{ call sp_buscarTodos() }");
            rs = cs.executeQuery();
            while (rs.next()) {
                
                String desContra =  enc.desencp(rs.getString("Contrasenia"));
                
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
                        rs.getString("Calle"),
                        rs.getInt("numero"), 
                        rs.getString("Colonia"),
                        rs.getInt("idmunicipio"),
                        rs.getInt("idEstado"),
                        rs.getInt("CodigoPostal"),
                        desContra
                        );
                
                user.setFechaN(rs.getString("FechaNacimientoUsuario"));
                user.setNombreE(rs.getString("estado"));
                user.setNombreM(rs.getString("municipio"));
                user.setNombreS(rs.getString("Sucursal"));
                
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
            cs = connection.prepareCall("{ call sp_imagen(?) }");
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
          
            cs.execute();
            
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
            
            cs = connection.prepareCall("{ call sp_buscarPersona(?) }");
            cs.setInt(1, id);
            rs = cs.executeQuery();
            if (rs.next()) {
                
               String desContra =(rs.getString("Contrasenia"));
               String desC =  Encriptar.desencp(desContra);
                
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
                        rs.getString("Calle"),
                        rs.getInt("numero"), 
                        rs.getString("Colonia"),
                        rs.getInt("idmunicipio"),
                        rs.getInt("idEstado"),
                        rs.getInt("CodigoPostal"),
                        desContra,
                        rs.getInt("idSucursal"));
               
               user.setFechaN(rs.getString("FechaNacimientoUsuario"));
              
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
        
public static void editar(Usuario e) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        CallableStatement cs = null;
        try {
            cs = conn.prepareCall("{call sp_modificarUsuario(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }");
            cs.setInt(1, e.getId());
            cs.setString(2, e.getNombre());
            cs.setString(3, e.getApePaterno());
            cs.setString(4, e.getApeMaterno());
            cs.setString(5, e.getPuesto());
            cs.setString(6, e.getSexo());
            cs.setString(7, e.getNivelEstudio());
            cs.setString(8, e.getRfc());
            cs.setString(9, e.getCurp());
            cs.setString(10, e.getCalle());
            cs.setInt(11, e.getNumero());
            cs.setString(12, e.getFechaN());
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
      
    public static List<Estado> buscarEstados() {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        CallableStatement cs = null;
        ResultSet rs = null;
        try {
            
            List<Estado> nombre  = new ArrayList();
            cs = connection.prepareCall("{ call sp_buscarEstados() }");
            rs = cs.executeQuery();
            while (rs.next()) {
                
                Estado user = new Estado(
                        rs.getInt("idEstado"),
                        rs.getString("estado")
                        );
                
                nombre.add(user);
            }
            return nombre;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
            
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closeStatement(cs);
            pool.freeConnection(connection);
        }
    }
         
    public static List<Estado> buscarMunicipios(int id) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        CallableStatement cs = null;
        ResultSet rs = null;
        try { 
            List<Estado> nombre  = new ArrayList();
            cs = connection.prepareCall("{ call sp_buscarMunicipios(?) }");
            cs.setInt(1, id);
            rs = cs.executeQuery();
            
            while (rs.next()) {
                
                Estado user = new Estado(
                        rs.getInt("idmunicipio"),
                        rs.getString("nombreMunicipio")
                        );
                
                nombre.add(user);
            }
            return nombre;
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
