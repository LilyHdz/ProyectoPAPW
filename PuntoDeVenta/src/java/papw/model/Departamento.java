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
public class Departamento {
    
    String nombre;
    int id;
    
   public Departamento(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        
    }
   
      public Departamento() {
        
    }
   
      public Departamento(String nombre) {
      
        this.nombre = nombre;
        
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
}
