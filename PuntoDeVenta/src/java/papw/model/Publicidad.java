/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package papw.model;

/**
 *
 * @author SAGG
 */
public class Publicidad {
    private String pathPublicidad;

    public String getPathPublicidad() {
        return pathPublicidad;
    }

    public void setPathPublicidad(String pathPublicidad) {
        this.pathPublicidad = pathPublicidad;
    }
    
    public Publicidad(String pathPublicidad)
    {
        this.pathPublicidad=pathPublicidad;
    }
}
