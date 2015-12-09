/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package papw.model;


/**
 *
 * @author Ayrton
 */
public class Venta {

    
        private int idUsuario;
        private double totalVenta;
        private String formaPago;
        private int idSucursal;


    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public double getTotalVenta() {
        return totalVenta;
    }

    public void setTotalVenta(int totalVenta) {
        this.totalVenta = totalVenta;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }
    
    public Venta(int idUsuario, int totalVenta, String formaPago)
    {
        
        this.idUsuario=idUsuario;
        this.totalVenta=totalVenta;
        this.formaPago=formaPago;
    }
    public Venta(int idUsuario, double totalVenta, String formaPago,int idSucursal)
    {
        this.idSucursal=idSucursal;
        this.idUsuario=idUsuario;
        this.totalVenta=totalVenta;
        this.formaPago=formaPago;
    }

    public int getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(int idSucursal) {
        this.idSucursal = idSucursal;
    }

    
}
