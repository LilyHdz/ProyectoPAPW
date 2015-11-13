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
public class VentaDetalle {
    
    private int idVenta;
    private int idArticulo;
    private int cantidad;

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public int getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(int idArticulo) {
        this.idArticulo = idArticulo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    public VentaDetalle(int idVenta,int idArticulo,int Cantidad)
    {
        this.idVenta = idVenta;
        this.idArticulo=idArticulo;
        this.cantidad=Cantidad;
    }
}
