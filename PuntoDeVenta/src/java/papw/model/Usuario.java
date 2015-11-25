/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package papw.model;

import java.io.InputStream;
import java.util.Date;

/**
 *
 * @author Owner
 */
public class Usuario {
    private int id;
    private String nombre;
    private String apePaterno;
    private String apeMaterno;
    private String Puesto;
    private String sexo;
    private String NivelEstudio;
    private String rfc;
    private String curp;
    private int nomina;

    private String fotoUbicacion;
    private InputStream fotostream;
    
    private String fechaN;
    private String calle;
    private int numero;
    private String colonia;
    private int municipio;
    private String nombreM;
    private String nombreS;
    private String nombreE;
    private int estado;
    private int postal;
    private String contrasena;
    private int idSucursal;

    public Usuario(String nombre, String apePaterno, String apeMaterno, String Puesto, String sexo, 
            String NivelEstudio, String rfc, String curp, int nomina,InputStream fotostream, String calle,
            int numero, String colonia, int municipio, int estado, int postal, String contrasena, int idSucursal) {
        
        this.nombre = nombre;
        this.apePaterno = apePaterno;
        this.apeMaterno = apeMaterno;
        this.Puesto = Puesto;
        this.sexo = sexo;
        this.NivelEstudio = NivelEstudio;
        this.rfc = rfc;
        this.curp = curp;
        this.nomina = nomina;
        this.fotostream = fotostream;
        this.calle = calle;
        this.numero = numero;
        this.colonia = colonia;
        this.municipio = municipio;
        this.estado = estado;
        this.postal = postal;
        this.contrasena = contrasena;
        this.idSucursal = idSucursal;
    }
    
    public Usuario(int id, String nombre, String apePaterno, String apeMaterno, String Puesto, String sexo, String NivelEstudio, String rfc, String curp, int nomina,InputStream fotostream, String calle, int numero, String colonia, int municipio, int estado, int postal, String contrasena) {
        this.id = id;
        this.nombre = nombre;
        this.apePaterno = apePaterno;
        this.apeMaterno = apeMaterno;
        this.Puesto = Puesto;
        this.sexo = sexo;
        this.NivelEstudio = NivelEstudio;
        this.rfc = rfc;
        this.curp = curp;
        this.nomina = nomina;
        this.fotostream = fotostream;
        this.calle = calle;
        this.numero = numero;
        this.colonia = colonia;
        this.municipio = municipio;
        this.estado = estado;
        this.postal = postal;
        this.contrasena = contrasena;
    }
    
    public Usuario(int id, String nombre, String apePaterno, String apeMaterno, String Puesto, String sexo, String NivelEstudio, String rfc, String curp, int nomina,InputStream fotostream, String calle, int numero, String colonia, int municipio, int estado, int postal, String contrasena, int idSucursal) {
        this.id = id;
        this.nombre = nombre;
        this.apePaterno = apePaterno;
        this.apeMaterno = apeMaterno;
        this.Puesto = Puesto;
        this.sexo = sexo;
        this.NivelEstudio = NivelEstudio;
        this.rfc = rfc;
        this.curp = curp;
        this.nomina = nomina;
        this.fotostream = fotostream;
        this.calle = calle;
        this.numero = numero;
        this.colonia = colonia;
        this.municipio = municipio;
        this.estado = estado;
        this.postal = postal;
        this.contrasena = contrasena;
        this.idSucursal = idSucursal;
    }
    
    public Usuario(int id, String nombre, String apePaterno, String apeMaterno, String Puesto, String sexo, String NivelEstudio, String rfc, String curp, String calle, int numero, String colonia, int municipio, int estado, int postal, String contrasena, int idSucursal) {
        this.id = id;
        this.nombre = nombre;
        this.apePaterno = apePaterno;
        this.apeMaterno = apeMaterno;
        this.Puesto = Puesto;
        this.sexo = sexo;
        this.NivelEstudio = NivelEstudio;
        this.rfc = rfc;
        this.curp = curp;
        this.calle = calle;
        this.numero = numero;
        this.colonia = colonia;
        this.municipio = municipio;
        this.estado = estado;
        this.postal = postal;
        this.contrasena = contrasena;
        this.idSucursal = idSucursal;
    }

    public String getNombreM() {
        return nombreM;
    }

    public void setNombreM(String nombreM) {
        this.nombreM = nombreM;
    }

    public String getNombreS() {
        return nombreS;
    }

    public void setNombreS(String nombreS) {
        this.nombreS = nombreS;
    }

    public String getNombreE() {
        return nombreE;
    }

    public void setNombreE(String nombreE) {
        this.nombreE = nombreE;
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

    public String getApePaterno() {
        return apePaterno;
    }

    public void setApePaterno(String apePaterno) {
        this.apePaterno = apePaterno;
    }

    public String getApeMaterno() {
        return apeMaterno;
    }

    public void setApeMaterno(String apeMaterno) {
        this.apeMaterno = apeMaterno;
    }

    public String getPuesto() {
        return Puesto;
    }

    public void setPuesto(String Puesto) {
        this.Puesto = Puesto;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getNivelEstudio() {
        return NivelEstudio;
    }

    public void setNivelEstudio(String NivelEstudio) {
        this.NivelEstudio = NivelEstudio;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public int getNomina() {
        return nomina;
    }

    public void setNomina(int nomina) {
        this.nomina = nomina;
    }

    public String getFechaN() {
        return fechaN;
    }

    public void setFechaN(String fechaN) {
        this.fechaN = fechaN;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
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

    public int getPostal() {
        return postal;
    }

    public void setPostal(int postal) {
        this.postal = postal;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    
        public String getFotoUbicacion() {
        return fotoUbicacion;
    }

    public void setFotoUbicacion(String fotoUbicacion) {
        this.fotoUbicacion = fotoUbicacion;
    }

    public InputStream getFotostream() {
        return fotostream;
    }

    public void setFotostream(InputStream fotostream) {
        this.fotostream = fotostream;
    }

    public int getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(int idSucursal) {
        this.idSucursal = idSucursal;
    }
    
    
    
}
