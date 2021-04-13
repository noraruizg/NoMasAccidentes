/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio;

import java.util.ArrayList;
import modelo.Contrato;
import modelo.Usuario;
/**
 *
 * @author norar
 */
public class Cont {
    private ArrayList<Contrato> cntr;
    private Usuario activo;
    
    public void agregarContrato(Contrato cn){
        this.cntr.add(cn);
    }
    
    public ArrayList<Contrato> getContrato(){
        return this.cntr;    
    }
    
    public Usuario getActivo(){
        return this.activo;
    } 
}
