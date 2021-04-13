/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author norar
 */
@Entity
@Table(name = "HISTORIAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Historial.findAll", query = "SELECT h FROM Historial h")
    , @NamedQuery(name = "Historial.findByIdHistorial", query = "SELECT h FROM Historial h WHERE h.idHistorial = :idHistorial")
    , @NamedQuery(name = "Historial.findByDescripcion", query = "SELECT h FROM Historial h WHERE h.descripcion = :descripcion")
    , @NamedQuery(name = "Historial.findByIdProfesional", query = "SELECT h FROM Historial h WHERE h.idProfesional = :idProfesional")
    , @NamedQuery(name = "Historial.findByProfesionalProfesionalId", query = "SELECT h FROM Historial h WHERE h.profesionalProfesionalId = :profesionalProfesionalId")})
public class Historial implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_HISTORIAL")
    private BigDecimal idHistorial;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PROFESIONAL")
    private BigInteger idProfesional;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PROFESIONAL_PROFESIONAL_ID")
    private BigInteger profesionalProfesionalId;
    @JoinColumn(name = "PROFESIONAL_ID_PROFESIONAL", referencedColumnName = "ID_PROFESIONAL")
    @ManyToOne(optional = false)
    private Profesional profesionalIdProfesional;

    public Historial() {
    }

    public Historial(BigDecimal idHistorial) {
        this.idHistorial = idHistorial;
    }

    public Historial(BigDecimal idHistorial, String descripcion, BigInteger idProfesional, BigInteger profesionalProfesionalId) {
        this.idHistorial = idHistorial;
        this.descripcion = descripcion;
        this.idProfesional = idProfesional;
        this.profesionalProfesionalId = profesionalProfesionalId;
    }

    public BigDecimal getIdHistorial() {
        return idHistorial;
    }

    public void setIdHistorial(BigDecimal idHistorial) {
        this.idHistorial = idHistorial;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigInteger getIdProfesional() {
        return idProfesional;
    }

    public void setIdProfesional(BigInteger idProfesional) {
        this.idProfesional = idProfesional;
    }

    public BigInteger getProfesionalProfesionalId() {
        return profesionalProfesionalId;
    }

    public void setProfesionalProfesionalId(BigInteger profesionalProfesionalId) {
        this.profesionalProfesionalId = profesionalProfesionalId;
    }

    public Profesional getProfesionalIdProfesional() {
        return profesionalIdProfesional;
    }

    public void setProfesionalIdProfesional(Profesional profesionalIdProfesional) {
        this.profesionalIdProfesional = profesionalIdProfesional;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idHistorial != null ? idHistorial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Historial)) {
            return false;
        }
        Historial other = (Historial) object;
        if ((this.idHistorial == null && other.idHistorial != null) || (this.idHistorial != null && !this.idHistorial.equals(other.idHistorial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Historial[ idHistorial=" + idHistorial + " ]";
    }
    
}
