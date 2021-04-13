/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio;

import java.util.ArrayList;
import modelo.Profesional;
import modelo.Usuario;
/**
 *
 * @author norar
 */
public class Prof {
    private ArrayList<Profesional> prfs;
    private Usuario activo;
    
    public void agregarProfesional(Profesional pro){
        this.prfs.add(pro);
    }
    
    public ArrayList<Profesional> getProfesional(){
        return this.prfs;    
    }
    
    public Usuario getActivo(){
        return this.activo;
    } 
}
