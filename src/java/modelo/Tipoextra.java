/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author norar
 */
@Entity
@Table(name = "TIPOEXTRA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipoextra.findAll", query = "SELECT t FROM Tipoextra t")
    , @NamedQuery(name = "Tipoextra.findByIdtipoextra", query = "SELECT t FROM Tipoextra t WHERE t.idtipoextra = :idtipoextra")
    , @NamedQuery(name = "Tipoextra.findByDescripcion", query = "SELECT t FROM Tipoextra t WHERE t.descripcion = :descripcion")})
public class Tipoextra implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDTIPOEXTRA")
    private int idtipoextra;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @OneToMany(mappedBy = "tipoextraIdtipoextra")
    private Collection<Servicioextra> servicioextraCollection;

    public Tipoextra() {
    }

    public Tipoextra(int idtipoextra) {
        this.idtipoextra = idtipoextra;
    }

    public Tipoextra(String descripcion) {
        //this.idtipoextra = idtipoextra;
        this.descripcion = descripcion;
    }

    public int getIdtipoextra() {
        return idtipoextra;
    }

    public void setIdtipoextra(int idtipoextra) {
        this.idtipoextra = idtipoextra;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public Collection<Servicioextra> getServicioextraCollection() {
        return servicioextraCollection;
    }

    public void setServicioextraCollection(Collection<Servicioextra> servicioextraCollection) {
        this.servicioextraCollection = servicioextraCollection;
    }


    @Override
    public String toString() {
        return "modelo.Tipoextra[ idtipoextra=" + idtipoextra + " ]";
    }
    
}
