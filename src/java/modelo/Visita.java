/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author norar
 */
@Entity
@Table(name = "VISITA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Visita.findAll", query = "SELECT v FROM Visita v")
    , @NamedQuery(name = "Visita.findByIdVisita", query = "SELECT v FROM Visita v WHERE v.visitaPK.idVisita = :idVisita")
    , @NamedQuery(name = "Visita.findByDescripcionvisita", query = "SELECT v FROM Visita v WHERE v.descripcionvisita = :descripcionvisita")
    , @NamedQuery(name = "Visita.findByHora", query = "SELECT v FROM Visita v WHERE v.hora = :hora")
    , @NamedQuery(name = "Visita.findByObservacion", query = "SELECT v FROM Visita v WHERE v.observacion = :observacion")
    , @NamedQuery(name = "Visita.findByIdProfesional", query = "SELECT v FROM Visita v WHERE v.idProfesional = :idProfesional")
    , @NamedQuery(name = "Visita.findByFecha", query = "SELECT v FROM Visita v WHERE v.fecha = :fecha")
    , @NamedQuery(name = "Visita.findByCosto", query = "SELECT v FROM Visita v WHERE v.costo = :costo")
    , @NamedQuery(name = "Visita.findByIdProfesional3", query = "SELECT v FROM Visita v WHERE v.visitaPK.idProfesional3 = :idProfesional3")
    , @NamedQuery(name = "Visita.findByIdProfesional1", query = "SELECT v FROM Visita v WHERE v.visitaPK.idProfesional1 = :idProfesional1")
    , @NamedQuery(name = "Visita.findByProfesionalProfesionalId", query = "SELECT v FROM Visita v WHERE v.profesionalProfesionalId = :profesionalProfesionalId")})
public class Visita implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected VisitaPK visitaPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "DESCRIPCIONVISITA")
    private String descripcionvisita;
    @Basic(optional = false)
    @NotNull
    @Column(name = "HORA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date hora;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "OBSERVACION")
    private String observacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PROFESIONAL")
    private BigInteger idProfesional;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COSTO")
    private BigInteger costo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PROFESIONAL_PROFESIONAL_ID")
    private BigInteger profesionalProfesionalId;
    @JoinColumn(name = "PROFESIONAL_ID_PROFESIONAL", referencedColumnName = "ID_PROFESIONAL")
    @ManyToOne(optional = false)
    private Profesional profesionalIdProfesional;
    @JoinColumn(name = "SERVICIO_ID_SERVICIO", referencedColumnName = "ID_SERVICIO")
    @ManyToOne(optional = false)
    private Servicio servicioIdServicio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "visita")
    private Collection<Alerta> alertaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "visita")
    private Collection<RVisita> rVisitaCollection;

    public Visita() {
    }

    public Visita(VisitaPK visitaPK) {
        this.visitaPK = visitaPK;
    }

    public Visita(VisitaPK visitaPK, String descripcionvisita, Date hora, String observacion, BigInteger idProfesional, Date fecha, BigInteger costo, BigInteger profesionalProfesionalId) {
        this.visitaPK = visitaPK;
        this.descripcionvisita = descripcionvisita;
        this.hora = hora;
        this.observacion = observacion;
        this.idProfesional = idProfesional;
        this.fecha = fecha;
        this.costo = costo;
        this.profesionalProfesionalId = profesionalProfesionalId;
    }

    public Visita(BigInteger idVisita, BigInteger idProfesional3, BigInteger idProfesional1) {
        this.visitaPK = new VisitaPK(idVisita, idProfesional3, idProfesional1);
    }

    public VisitaPK getVisitaPK() {
        return visitaPK;
    }

    public void setVisitaPK(VisitaPK visitaPK) {
        this.visitaPK = visitaPK;
    }

    public String getDescripcionvisita() {
        return descripcionvisita;
    }

    public void setDescripcionvisita(String descripcionvisita) {
        this.descripcionvisita = descripcionvisita;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public BigInteger getIdProfesional() {
        return idProfesional;
    }

    public void setIdProfesional(BigInteger idProfesional) {
        this.idProfesional = idProfesional;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public BigInteger getCosto() {
        return costo;
    }

    public void setCosto(BigInteger costo) {
        this.costo = costo;
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

    public Servicio getServicioIdServicio() {
        return servicioIdServicio;
    }

    public void setServicioIdServicio(Servicio servicioIdServicio) {
        this.servicioIdServicio = servicioIdServicio;
    }

    @XmlTransient
    public Collection<Alerta> getAlertaCollection() {
        return alertaCollection;
    }

    public void setAlertaCollection(Collection<Alerta> alertaCollection) {
        this.alertaCollection = alertaCollection;
    }

    @XmlTransient
    public Collection<RVisita> getRVisitaCollection() {
        return rVisitaCollection;
    }

    public void setRVisitaCollection(Collection<RVisita> rVisitaCollection) {
        this.rVisitaCollection = rVisitaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (visitaPK != null ? visitaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Visita)) {
            return false;
        }
        Visita other = (Visita) object;
        if ((this.visitaPK == null && other.visitaPK != null) || (this.visitaPK != null && !this.visitaPK.equals(other.visitaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Visita[ visitaPK=" + visitaPK + " ]";
    }
    
}
