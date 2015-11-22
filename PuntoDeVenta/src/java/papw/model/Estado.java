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
public class Estado {
int id;
String nombre;
int idmunicipio;
String nombreMunicipio;


    public Estado(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Estado(int id, int idmunicipio, String nombreMunicipio) {
        this.id = id;
        this.idmunicipio = idmunicipio;
        this.nombreMunicipio = nombreMunicipio;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdmunicipio() {
        return idmunicipio;
    }

    public void setIdmunicipio(int idmunicipio) {
        this.idmunicipio = idmunicipio;
    }

    public String getNombreMunicipio() {
        return nombreMunicipio;
    }

    public void setNombreMunicipio(String nombreMunicipio) {
        this.nombreMunicipio = nombreMunicipio;
    }
    
    
}
