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
public class Login {
    private int id;
    private String email;
    private String puesto;
    private int idSucursal;

    public Login(int id, String email, String puesto) {
        this.id = id;
        this.email = email;
        this.puesto = puesto;
    }
    
        public Login(int id, String email, String puesto,int idSucursal) {
        this.id = id;
        this.email = email;
        this.puesto = puesto;
        this.idSucursal=idSucursal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public int getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(int idSucursal) {
        this.idSucursal = idSucursal;
    }



    
}
