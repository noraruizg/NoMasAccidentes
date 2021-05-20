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
public class User {
    private ArrayList<Usuario> usrs;
    private ArrayList<Profesional> prfs;
    private Usuario activo;
    private int idUsuario = 1;
    
    public User(){
        activo = null;
        usrs = new ArrayList();
        
    }
    public boolean login(String usuario, String pass){
        for(Usuario u:this.usrs){
            if(u.getEmail().equals(usuario)
                    && u.getPassword().equals(pass)){
                this.activo=u;
                return true;
            }
        }
        return false;
    }
    public void agregarUsuario(Usuario us){
        us.setIdUsuario(idUsuario);
        idUsuario++;
        //return this.usrs.add(us);
    }
    
    public ArrayList<Usuario> getAll(){
        return this.usrs;    
    }
    
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
