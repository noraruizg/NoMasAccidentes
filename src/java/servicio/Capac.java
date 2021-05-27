/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio;

import java.util.ArrayList;
import modelo.Capacitacion;
import modelo.Usuario;
/**
 *
 * @author norar
 */
public class Capac {
    private ArrayList<Capacitacion> cntr;
    private Usuario activo;
    
    public void agregarCapacitacion(Capacitacion cn){
        this.cntr.add(cn);
    }
    
    public ArrayList<Capacitacion> getCapacitacion(){
        return this.cntr;    
    }
    
    public Usuario getActivo(){
        return this.activo;
    } 
}
