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
public class Municipio {
    
    String nombreMunicipio;
    int idMunicipio;

    public Municipio(String nombreMunicipio, int idMunicipio) {
        this.nombreMunicipio = nombreMunicipio;
        this.idMunicipio = idMunicipio;
    }

    public String getNombreMunicipio() {
        return nombreMunicipio;
    }

    public void setNombreMunicipio(String nombreMunicipio) {
        this.nombreMunicipio = nombreMunicipio;
    }

    public int getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(int idMunicipio) {
        this.idMunicipio = idMunicipio;
    }
    
    
    
}
