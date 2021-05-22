/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.math.BigDecimal;
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
    private BigDecimal idtipoextra;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @OneToMany(mappedBy = "tipoextraIdtipoextra")
    private Collection<Servicioextra> servicioextraCollection;

    public Tipoextra() {
    }

    public Tipoextra(BigDecimal idtipoextra) {
        this.idtipoextra = idtipoextra;
    }

    public Tipoextra(BigDecimal idtipoextra, String descripcion) {
        this.idtipoextra = idtipoextra;
        this.descripcion = descripcion;
    }

    public BigDecimal getIdtipoextra() {
        return idtipoextra;
    }

    public void setIdtipoextra(BigDecimal idtipoextra) {
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
    public int hashCode() {
        int hash = 0;
        hash += (idtipoextra != null ? idtipoextra.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipoextra)) {
            return false;
        }
        Tipoextra other = (Tipoextra) object;
        if ((this.idtipoextra == null && other.idtipoextra != null) || (this.idtipoextra != null && !this.idtipoextra.equals(other.idtipoextra))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Tipoextra[ idtipoextra=" + idtipoextra + " ]";
    }
    
}
