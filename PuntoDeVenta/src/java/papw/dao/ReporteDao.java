/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package papw.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import papw.model.Articulo;
import papw.model.Reporte;

/**
 *
 * @author Ayrton
 */
public class ReporteDao {
    
    public static List<Reporte> consultaReporteFecha(Date fechaInicio,Date fechaFin)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        CallableStatement cs = null;
        ResultSet rs = null;
        
        java.sql.Date sqlDate2 = new java.sql.Date(fechaFin.getTime());
        java.sql.Date sqlDate1 = new java.sql.Date(fechaInicio.getTime());
        
         try {
            List<Reporte> listReporte = new ArrayList<Reporte>();
            cs = conn.prepareCall("{call sp_reporteFechas (?,?)}");
            
            cs.setDate(1, sqlDate1);
            cs.setDate(2, sqlDate2);
            
            rs = cs.executeQuery();
            while (rs.next()) {
                Reporte reporte = new Reporte(
                                    rs.getDate("fechaVenta"),
                                    rs.getString("nombreSucursal"),
                        rs.getString("nombreDepartamento"),
                        rs.getString("nombreUsuario"),
                        rs.getString("descripcionCorta"),
                        rs.getInt("cantidadProducto"),
                        rs.getInt("descuento"),
                        rs.getString("aplicaImpuesto"),
                        rs.getString("formaPago"));

                listReporte.add(reporte);
            }
            return listReporte;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
            
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closeStatement(cs);
            pool.freeConnection(conn);
        }
    }
    
    public static List<Reporte> consultaReporteDepartamento(int idDepartamento,String fechaInicio ,String fechaFin)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        CallableStatement cs = null;
        ResultSet rs = null;
         try {
            List<Reporte> listReporte = new ArrayList<Reporte>();
            cs = conn.prepareCall("{ call sp_reporteDepartamento(?,?,?) }");
            cs.setInt(1, idDepartamento);
            cs.setString(2, fechaInicio);
            cs.setString(3, fechaFin);
            rs = cs.executeQuery();
            while (rs.next()) {
                Reporte reporte = new Reporte(
                        
                        rs.getString("nombreSucursal"),
                        rs.getString("nombreDepartamento"),
                        rs.getString("nombreUsuario"),
                        rs.getInt("cantidadProducto"),
                        rs.getInt("descuento"),
                        rs.getInt("totalVenta"),
                        rs.getInt("Precio")
                        );

                listReporte.add(reporte);
            }
            return listReporte;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
            
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closeStatement(cs);
            pool.freeConnection(conn);
        }
    }
    
    public static List<Reporte> consultaReporteSucursal(int idSucursal,String fechaInicio ,String fechaFin)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        CallableStatement cs = null;
        ResultSet rs = null;
         try {
            List<Reporte> listReporte = new ArrayList<Reporte>();
            cs = conn.prepareCall("{ call sp_reporteSucursal(?,?,?) }");
            cs.setInt(1, idSucursal);
            cs.setString(2, fechaInicio);
            cs.setString(3, fechaFin);
            rs = cs.executeQuery();
            while (rs.next()) {
                Reporte reporte = new Reporte(
                                    rs.getDate("fechaVenta"),
                                    rs.getString("nombreSucursal"),
                        rs.getString("nombreDepartamento"),
                        rs.getString("nombreUsuario"),
                        rs.getString("descripcionCorta"),
                        rs.getInt("cantidadProducto"),
                        rs.getInt("descuento"),
                        rs.getString("aplicaImpuesto"),
                        rs.getInt("Precio"));

                listReporte.add(reporte);
            }
            return listReporte;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
            
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closeStatement(cs);
            pool.freeConnection(conn);
        }
    }
    
    public static List<Reporte> consultaReporteCajero(int idUsuario,String fechaInicio ,String fechaFin)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getConnection();
        CallableStatement cs = null;
        ResultSet rs = null;
         try {
            List<Reporte> listReporte = new ArrayList<Reporte>();
            cs = conn.prepareCall("{ call sp_reporteCajero(?,?,?) }");
            cs.setInt(1, idUsuario);
            cs.setString(2, fechaInicio);
            cs.setString(3, fechaFin);
            rs = cs.executeQuery();
            while (rs.next()) {
                Reporte reporte = new Reporte(
                        rs.getDate("fechaVenta"),
                        rs.getString("nombreSucursal"),
                        rs.getString("nombreDepartamento"),
                        rs.getString("nombreUsuario"),
                        rs.getString("descripcionCorta"),
                        rs.getInt("cantidadProducto"),
                        rs.getInt("descuento"),
                        rs.getString("aplicaImpuesto"),
                        rs.getInt("Precio"));

                listReporte.add(reporte);
            }
            return listReporte;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
            
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closeStatement(cs);
            pool.freeConnection(conn);
        }
    }
}
