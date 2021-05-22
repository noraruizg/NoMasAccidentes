/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "ASISTENTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Asistente.findAll", query = "SELECT a FROM Asistente a")
    , @NamedQuery(name = "Asistente.findByRutAsistente", query = "SELECT a FROM Asistente a WHERE a.rutAsistente = :rutAsistente")
    , @NamedQuery(name = "Asistente.findByNombreasistente", query = "SELECT a FROM Asistente a WHERE a.nombreasistente = :nombreasistente")
    , @NamedQuery(name = "Asistente.findByAppaternoasistente", query = "SELECT a FROM Asistente a WHERE a.appaternoasistente = :appaternoasistente")
    , @NamedQuery(name = "Asistente.findByApmaternoasistente", query = "SELECT a FROM Asistente a WHERE a.apmaternoasistente = :apmaternoasistente")})
public class Asistente implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "asistenteRutAsistente")
    private Collection<Capacitacion> capacitacionCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "RUT_ASISTENTE")
    private String rutAsistente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NOMBREASISTENTE")
    private String nombreasistente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "APPATERNOASISTENTE")
    private String appaternoasistente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "APMATERNOASISTENTE")
    private String apmaternoasistente;

    public Asistente() {
    }

    public Asistente(String rutAsistente) {
        this.rutAsistente = rutAsistente;
    }

    public Asistente(String rutAsistente, String nombreasistente, String appaternoasistente, String apmaternoasistente) {
        this.rutAsistente = rutAsistente;
        this.nombreasistente = nombreasistente;
        this.appaternoasistente = appaternoasistente;
        this.apmaternoasistente = apmaternoasistente;
    }

    public String getRutAsistente() {
        return rutAsistente;
    }

    public void setRutAsistente(String rutAsistente) {
        this.rutAsistente = rutAsistente;
    }

    public String getNombreasistente() {
        return nombreasistente;
    }

    public void setNombreasistente(String nombreasistente) {
        this.nombreasistente = nombreasistente;
    }

    public String getAppaternoasistente() {
        return appaternoasistente;
    }

    public void setAppaternoasistente(String appaternoasistente) {
        this.appaternoasistente = appaternoasistente;
    }

    public String getApmaternoasistente() {
        return apmaternoasistente;
    }

    public void setApmaternoasistente(String apmaternoasistente) {
        this.apmaternoasistente = apmaternoasistente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rutAsistente != null ? rutAsistente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Asistente)) {
            return false;
        }
        Asistente other = (Asistente) object;
        if ((this.rutAsistente == null && other.rutAsistente != null) || (this.rutAsistente != null && !this.rutAsistente.equals(other.rutAsistente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Asistente[ rutAsistente=" + rutAsistente + " ]";
    }

    @XmlTransient
    public Collection<Capacitacion> getCapacitacionCollection() {
        return capacitacionCollection;
    }

    public void setCapacitacionCollection(Collection<Capacitacion> capacitacionCollection) {
        this.capacitacionCollection = capacitacionCollection;
    }
    
}
