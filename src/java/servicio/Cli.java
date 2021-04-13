/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio;

import java.util.ArrayList;
import modelo.Cliente;
import modelo.Usuario;
/**
 *
 * @author norar
 */
public class Cli {
    private ArrayList<Cliente> clt;
    private Usuario activo;
    
    public void agregarCliente(Cliente ct){
        this.clt.add(ct);
    }
    
    public ArrayList<Cliente> getCliente(){
        return this.clt;    
    }
    
    public Usuario getActivo(){
        return this.activo;
    } 
}
