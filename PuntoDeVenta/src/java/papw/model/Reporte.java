/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package papw.model;

import java.util.Date;

/**
 *
 * @author Ayrton
 */
public class Reporte {
    private Date fechaVenta;
    private String nombreSucursal;
    private String nombreDepartamento;
    private String nombreUsuario;
    private String descripcionCorta;
    private int cantidadProducto;
    private int descuento;
    private String formaPago;
    private String aplicaImpuesto;
    private int totalVenta;
    private int precio;

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public String getNombreSucursal() {
        return nombreSucursal;
    }

    public void setNombreSucursal(String nombreSucursal) {
        this.nombreSucursal = nombreSucursal;
    }

    public String getNombreDepartamento() {
        return nombreDepartamento;
    }

    public void setNombreDepartamento(String nombreDepartamento) {
        this.nombreDepartamento = nombreDepartamento;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getDescripcionCorta() {
        return descripcionCorta;
    }

    public void setDescripcionCorta(String descripcionCorta) {
        this.descripcionCorta = descripcionCorta;
    }

    public int getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }
    
    public Reporte(Date fechaVenta,String nombreSucursal,String nombreDepartamento, String nombreUsuario, String descripcionCorta, int cantidadProducto, int descuento,String aplicaImpuesto, String formaPago)
    {
        this.fechaVenta=fechaVenta;
        this.nombreSucursal=nombreSucursal;
        this.nombreDepartamento=nombreDepartamento;
        this.nombreUsuario=nombreUsuario;
        this.descripcionCorta=descripcionCorta;
        this.cantidadProducto=cantidadProducto;
        this.descuento=descuento;
        this.formaPago=formaPago;
        this.aplicaImpuesto=aplicaImpuesto;
    }
    public Reporte(String nombreSucursal,String nombreDepartamento,String nombreUsuario,int cantidadProducto,int descuento,int totalVenta, int precio)
    {
        this.nombreSucursal=nombreSucursal;
        this.nombreUsuario=nombreUsuario;
        this.cantidadProducto=cantidadProducto;
        this.descuento=descuento;
        this.totalVenta=totalVenta;
        this.precio=precio;
    }
    
    public Reporte(Date fechaVenta,String nombreSucursal,String nombreDepartamento, String nombreUsuario, String descripcionCorta, int cantidadProducto, int descuento,String aplicaImpuesto, int precio)
    {
        this.fechaVenta=fechaVenta;
        this.nombreSucursal=nombreSucursal;
        this.nombreDepartamento=nombreDepartamento;
        this.nombreUsuario=nombreUsuario;
        this.descripcionCorta=descripcionCorta;
        this.cantidadProducto=cantidadProducto;
        this.descuento=descuento;
        this.precio=precio;
        this.aplicaImpuesto=aplicaImpuesto;
    }
    

    public String getAplicaImpuesto() {
        return aplicaImpuesto;
    }

    public void setAplicaImpuesto(String aplicaImpuesto) {
        this.aplicaImpuesto = aplicaImpuesto;
    }

    public int getTotalVenta() {
        return totalVenta;
    }

    public void setTotalVenta(int totalVenta) {
        this.totalVenta = totalVenta;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
}
