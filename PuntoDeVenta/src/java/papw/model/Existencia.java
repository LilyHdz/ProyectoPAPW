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
public class Existencia {
    private int idArticulo;
    private int cantidadExistencia;

    public int getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(int idArticulo) {
        this.idArticulo = idArticulo;
    }

    public int getCantidadExistencia() {
        return cantidadExistencia;
    }

    public void setCantidadExistencia(int cantidadExistencia) {
        this.cantidadExistencia = cantidadExistencia;
    }
    public Existencia(int idArticulo, int cantidadExistencia)
    {
        this.cantidadExistencia=cantidadExistencia;
        this.idArticulo=idArticulo;
    }
}
