/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package papw.model;

import java.io.InputStream;
import java.sql.Blob;
import javax.websocket.Decoder;

/**
 *
 * @author Ayrton
 */
public class Articulo extends Ticket {
    
    private int idArticulo;
    private int idDepartamento;
    private String descripcionCorta;
    private String desCripcionLarga;
    private int precio;
    private int idUnidadMedida;
    private String aplicaImpuesto;
    private int descuento;
    private InputStream imagenArticulo;
    private int existencia;

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getDescripcionCorta() {
        return descripcionCorta;
    }

    public void setDescripcionCorta(String descripcionCorta) {
        this.descripcionCorta = descripcionCorta;
    }

    public String getDesCripcionLarga() {
        return desCripcionLarga;
    }

    public void setDesCripcionLarga(String desCripcionLarga) {
        this.desCripcionLarga = desCripcionLarga;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getIdUnidadMedida() {
        return idUnidadMedida;
    }

    public void setIdUnidadMedida(int idUnidadMedida) {
        this.idUnidadMedida = idUnidadMedida;
    }

    public String getAplicaImpuesto() {
        return aplicaImpuesto;
    }

    public void setAplicaImpuesto(String aplicaDescuento) {
        this.aplicaImpuesto = aplicaDescuento;
    }

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }
    
    public Articulo (int idArticulo,int idDepartamento, String descripcionCorta, String descripcionLarga,int precio,int idUnidadMedida,InputStream imageArticulo,String aplicaImpuesto,int descuento,int existencia){
        this.idArticulo=idArticulo;
    this.idDepartamento=idDepartamento;
    this.descripcionCorta=descripcionCorta;
    this.desCripcionLarga=descripcionLarga;
    this.precio=precio;
    this.idUnidadMedida=idUnidadMedida;
    this.aplicaImpuesto=aplicaImpuesto;
    this.descuento=descuento;
    this.imagenArticulo=imageArticulo;
    this.existencia=existencia;
    }
     public Articulo (int idArticulo,int idDepartamento, String descripcionCorta, String descripcionLarga,int precio,int idUnidadMedida,InputStream imageArticulo,String aplicaImpuesto,int descuento){
     this.idArticulo=idArticulo;
    this.idDepartamento=idDepartamento;
    this.descripcionCorta=descripcionCorta;
    this.desCripcionLarga=descripcionLarga;
    this.precio=precio;
    this.idUnidadMedida=idUnidadMedida;
    this.aplicaImpuesto=aplicaImpuesto;
    this.descuento=descuento;
    this.imagenArticulo=imageArticulo;

    }
    public Articulo()
    {
        
    }

    public int getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(int idArticulo) {
        this.idArticulo = idArticulo;
    }

    public InputStream getImagenArticulo() {
        return imagenArticulo;
    }

    public void setImagenArticulo(InputStream imagenArticulo) {
        this.imagenArticulo = imagenArticulo;
    }

    public int getExistencia() {
        return existencia;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }
}
