/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package papw.model;

/**
 *
 * @author Owner
 */
public class Sucursal {
  String nombre;
    int id;
    int idempresa;
    int municipio;
    int estado;

    public Sucursal(String nombre, int id, int idempresa, int municipio) {
        this.nombre = nombre;
        this.id = id;
        this.municipio = municipio;
    }

    public Sucursal(int id,String nombre, int municipio) {
        this.nombre = nombre;
        this.municipio = municipio;
        this.id = id;
       
    }

    public Sucursal(String nombre, int municipio) {
        this.nombre = nombre;
        this.municipio = municipio;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(int idempresa) {
        this.idempresa = idempresa;
    }

    public int getMunicipio() {
        return municipio;
    }

    public void setMunicipio(int municipio) {
        this.municipio = municipio;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }   
}
