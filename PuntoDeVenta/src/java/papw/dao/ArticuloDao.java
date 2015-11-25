/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package papw.dao;

import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import papw.model.Articulo;

/**
 *
 * @author Ayrton
 */
public class ArticuloDao {
    
public static void insertar(Articulo e) {
        
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        CallableStatement cs = null;
        CallableStatement cs2 = null;
        try {
            cs = conn.prepareCall("{ call sp_agregarArticulo(?,?,?,?,?,?,?,?) }");
            cs.setString(1, e.getDescripcionCorta());
            cs.setString(2, e.getDesCripcionLarga());
            cs.setInt(3, e.getPrecio());
            cs.setInt(4, e.getIdUnidadMedida());
            cs.setBlob(5, e.getImagenArticulo());
            cs.setString(6, e.getAplicaImpuesto());
            cs.setInt(7, e.getDescuento());
            cs.setInt(8, e.getIdDepartamento());
            
            int res = cs.executeUpdate();  
            
            Articulo ar = Codigo();
            
            ar.setSucursal(e.getSucursal());
            ar.setIdUnidadMedida(e.getIdUnidadMedida());
            ar.setExistencia(e.getExistencia());
            
            existencia(ar);
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DBUtil.closeStatement(cs);
            pool.freeConnection(conn);
        }
    }
     
public static void existencia(Articulo e) {
        
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        CallableStatement cs = null;
        try {
            cs = conn.prepareCall("{ call sp_agregarExistencia(?,?,?) }");
            cs.setInt(1, e.getExistencia());
            cs.setInt(2, e.getIdArticulo());
            cs.setInt(3, e.getSucursal());
            
            int res = cs.executeUpdate();  

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
           DBUtil.closeStatement(cs);
           pool.freeConnection(conn);
        }
    }
    
public static Articulo Codigo()
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        CallableStatement cs = null;
        ResultSet rs = null;
         try {
            Articulo articulos =new Articulo();
            int codigo = 0;
            cs = conn.prepareCall("{ call sp_buscarCodigo() }");
            rs = cs.executeQuery();
            while (rs.next()) {
                
                   articulos = new Articulo(
                        rs.getInt("idArticulo"), 
                        rs.getInt("idDepartamento"),
                        rs.getString("DescripcionCorta"),
                        rs.getString("DescripcionLarga"),
                        rs.getInt("Precio"),
                        rs.getInt("idUnidadMedida"),
                        rs.getBinaryStream("ImagenArticulo"),
                        rs.getString("AplicaImpuesto") ,
                        rs.getInt("Descuento"));
                    
            }
            return articulos;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
            
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closeStatement(cs);
            pool.freeConnection(conn);
        }
       
    }
     
public static void editar(Articulo e) {
        
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        CallableStatement cs = null;
        CallableStatement cs2 = null;
        try {
            cs = conn.prepareCall("{ call sp_modificarArticulo(?,?,?,?,?,?,?,?) }");
            cs.setInt(1, e.getIdArticulo() );
            cs.setInt(2, e.getIdDepartamento());
            cs.setString(3,e.getDescripcionCorta() );
            cs.setString(4, e.getDesCripcionLarga());
            cs.setInt(5, e.getPrecio());
            cs.setInt(6, e.getIdUnidadMedida());
            cs.setString(7, e.getAplicaImpuesto());
            cs.setInt(8, e.getDescuento());
         
            int res = cs.executeUpdate();  
            
            Articulo ar = Codigo();
            
            ar.setSucursal(e.getSucursal());
            ar.setIdUnidadMedida(e.getIdUnidadMedida());
            ar.setExistencia(e.getExistencia());
            
            editarExistencia(ar);
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DBUtil.closeStatement(cs);
            pool.freeConnection(conn);
        }
    }

public static void editarExistencia(Articulo e) {
        
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        CallableStatement cs = null;
        try {
            cs = conn.prepareCall("{ call sp_modificarExistencia(?,?,?) }");
            cs.setInt(1, e.getExistencia());
            cs.setInt(2, e.getIdArticulo());
            cs.setInt(3, e.getSucursal());
            
            int res = cs.executeUpdate();  

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
           DBUtil.closeStatement(cs);
           pool.freeConnection(conn);
        }
    }

public static void borrar(int id) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        CallableStatement cs = null;
        try {
            cs = connection.prepareCall("{ call sp_eliminarExistencia(?) }");
            cs.setInt(1, id);
         
            cs.execute();
   
    
            
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DBUtil.closeStatement(cs);
            pool.freeConnection(connection);
        }
    }

public static List<Articulo> consultaArticulo(String Buscar)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        CallableStatement cs = null;
        ResultSet rs = null;
         try {
            List<Articulo> Articulos = new ArrayList<Articulo>();
            cs = conn.prepareCall("{ call sp_buscarArticuli2('"+Buscar+"') }");
            rs = cs.executeQuery();
            while (rs.next()) {
                Articulo articulo = new Articulo(
                        rs.getInt("idArticulo"), 
                        rs.getInt("idDepartamento"),
                        rs.getString("DescripcionCorta"),
                        rs.getString("DescripcionLarga"),
                        rs.getInt("Precio"),
                        rs.getInt("idUnidadMedida"),
                        rs.getBinaryStream("ImagenArticulo"),
                        rs.getString("AplicaImpuesto") ,
                        rs.getInt("Descuento"));

                Articulos.add(articulo);
            }
            return Articulos;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
            
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closeStatement(cs);
            pool.freeConnection(conn);
        }
        
    }
    
public static Articulo obtenerArticulo(String Codigo)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        CallableStatement cs = null;
        ResultSet rs = null;
         try {
           Articulo articulos =new Articulo();
            cs = conn.prepareCall("{ call sp_obtenerArticulo('"+Codigo+"') }");
            rs = cs.executeQuery();
            while (rs.next()) {
                 articulos = new Articulo(
                        rs.getInt("idArticulo"), 
                        rs.getInt("idDepartamento"),
                        rs.getString("DescripcionCorta"),
                        rs.getString("DescripcionLarga"),
                        rs.getInt("Precio"),
                        rs.getInt("idUnidadMedida"),
                        rs.getBinaryStream("ImagenArticulo"),
                        rs.getString("AplicaImpuesto") ,
                        rs.getInt("Descuento"),
                        rs.getInt("cantidadExistenncia"));
            }
            return articulos;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
            
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closeStatement(cs);
            pool.freeConnection(conn);
        }
    }
    
public static Articulo buscarArticulo(int Codigo)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        CallableStatement cs = null;
        ResultSet rs = null;
         try {
           Articulo articulos =new Articulo();
            cs = conn.prepareCall("{ call sp_buscarArticulo('"+Codigo+"') }");
            rs = cs.executeQuery();
            while (rs.next()) {           
                        articulos.setIdArticulo(rs.getInt("Codigo"));
                        articulos.setDescripcionCorta(rs.getString("Nombre"));
                        articulos.setDesCripcionLarga(rs.getString("Descripcion"));
                        articulos.setPrecio(rs.getInt("Precio"));
                        articulos.setImagenArticulo(rs.getBinaryStream("ImagenArticulo"));
                        articulos.setNombreDepartamento(rs.getString("Departamento"));
                        articulos.setNombreMedida(rs.getString("TipoMedida"));
                        articulos.setAplicaImpuesto(rs.getString("AplicaImpuesto"));                      
                        articulos.setDescuento(rs.getInt("Descuento"));
                        articulos.setExistencia(rs.getInt("Existencia"));
                        articulos.setNombreSucursal(rs.getString("Sucursal"));
            }
            return articulos;
            
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closeStatement(cs);
            pool.freeConnection(conn);
        }
   }

public static List<Articulo> obtenerArticulos()
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        CallableStatement cs = null;
        ResultSet rs = null;
         try {
            List<Articulo> Articulos = new ArrayList<Articulo>();
            cs = conn.prepareCall("{ call sp_buscarArticulos() }");
            rs = cs.executeQuery();
            while (rs.next()) {
                Articulo articulo = new Articulo();
              
                        articulo.setIdArticulo(rs.getInt("Codigo"));
                        articulo.setDescripcionCorta(rs.getString("Nombre"));
                        articulo.setDesCripcionLarga(rs.getString("Descripcion"));
                        articulo.setPrecio(rs.getInt("Precio"));
                        articulo.setImagenArticulo(rs.getBinaryStream("ImagenArticulo"));
                        articulo.setNombreDepartamento(rs.getString("Departamento"));
                        articulo.setNombreMedida(rs.getString("TipoMedida"));
                        articulo.setAplicaImpuesto(rs.getString("AplicaImpuesto"));                      
                        articulo.setDescuento(rs.getInt("Descuento"));
                        articulo.setExistencia(rs.getInt("Existencia"));
                        articulo.setNombreSucursal(rs.getString("Sucursal"));

                Articulos.add(articulo);
            }
            return Articulos;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
            
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closeStatement(cs);
            pool.freeConnection(conn);
        }
    }

public static List<Articulo> obtenerMedida()
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        CallableStatement cs = null;
        ResultSet rs = null;
         try {
            List<Articulo> Articulos = new ArrayList<Articulo>();
            cs = conn.prepareCall("{ call sp_buscarMedida() }");
            rs = cs.executeQuery();
            while (rs.next()) {
                Articulo articulo = new Articulo();
              
                        articulo.setIdUnidadMedida(rs.getInt("IdUnidadMedida"));
                        articulo.setNombreMedida(rs.getString("TipoMedida"));

                Articulos.add(articulo);
            }
            return Articulos;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
            
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closeStatement(cs);
            pool.freeConnection(conn);
        }
    }
    
   public static InputStream obtenerImagen(int id) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        CallableStatement cs = null;
        ResultSet rs = null;
        try { 
            cs = connection.prepareCall("{ call sp_obtenerImagenArticulo(?) }");
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
        
}
