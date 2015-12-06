/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package papw.model;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author SAGG
 */
public class Publicidad {
    private String pathPublicidad;
    private int idPublicidad;
    private int horarios;
    private int dia;
    private String nomSuc;
    private int sucursal;

    public int getSucursal() {
        return sucursal;
    }

    public void setSucursal(int sucursal) {
        this.sucursal = sucursal;
    }
    
    public int getIdPublicidad() {
        return idPublicidad;
    }

    public void setIdPublicidad(int idPublicidad) {
        this.idPublicidad = idPublicidad;
    }
    
    public int getHorarios() {
        return horarios;
    }

    public void setHorarios(int horarios) {
        this.horarios = horarios;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public String getNomSuc() {
        return nomSuc;
    }

    public void setNomSuc(String nomSuc) {
        this.nomSuc = nomSuc;
    }
    
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

    public Publicidad(int idPublicidad) {
        this.idPublicidad = idPublicidad;
    }
    
    public static int getDayOfTheWeek(Date d){
	GregorianCalendar cal = new GregorianCalendar();
	cal.setTime(d);
	return cal.get(Calendar.DAY_OF_WEEK);		
    }
    
     public static String dia(int auxiliar){
	String dia="";
         switch(auxiliar){
             case 1:
                 dia="Domingo";
                 break;
             case 2:
                 dia="Lunes";
                 break;
             case 3:
                 dia="Martes";
                 break;
             case 4:
                 dia="Miercoles";
                 break;
             case 5:
                 dia="Jueves";
                 break;
             case 6:
                 dia="Viernes";
                 break;
             case 7:
                 dia="Sabado";
                 break;
         }
         
         return dia;
    }
     
    public static String horario(int auxiliar){
	String horario="";
         switch(auxiliar){
             case 1:
                 horario="Matutino";
                 break;
             case 2:
                 horario="Vespertino";
                 break;
             case 3:
                 horario="Nocturno";
                 break;
         }
         
         return horario;
    }
}
