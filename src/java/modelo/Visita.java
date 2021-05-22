/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
    , @NamedQuery(name = "Visita.findByIdVisita", query = "SELECT v FROM Visita v WHERE v.idVisita = :idVisita")
    , @NamedQuery(name = "Visita.findByTipovisita", query = "SELECT v FROM Visita v WHERE v.tipovisita = :tipovisita")
    , @NamedQuery(name = "Visita.findByFechavisita", query = "SELECT v FROM Visita v WHERE v.fechavisita = :fechavisita")})
public class Visita implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_VISITA")
    private BigDecimal idVisita;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "TIPOVISITA")
    private String tipovisita;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHAVISITA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechavisita;
    @OneToMany(mappedBy = "visitaIdVisita")
    private Collection<PlanServicio> planServicioCollection;
    @JoinColumn(name = "PROFESIONAL_ID_PROFESIONAL", referencedColumnName = "ID_PROFESIONAL")
    @ManyToOne(optional = false)
    private Profesional profesionalIdProfesional;
    @OneToMany(mappedBy = "visitaIdVisita")
    private Collection<Checklistvisita> checklistvisitaCollection;

    public Visita() {
    }

    public Visita(BigDecimal idVisita) {
        this.idVisita = idVisita;
    }

    public Visita(BigDecimal idVisita, String tipovisita, Date fechavisita) {
        this.idVisita = idVisita;
        this.tipovisita = tipovisita;
        this.fechavisita = fechavisita;
    }

    public BigDecimal getIdVisita() {
        return idVisita;
    }

    public void setIdVisita(BigDecimal idVisita) {
        this.idVisita = idVisita;
    }

    public String getTipovisita() {
        return tipovisita;
    }

    public void setTipovisita(String tipovisita) {
        this.tipovisita = tipovisita;
    }

    public Date getFechavisita() {
        return fechavisita;
    }

    public void setFechavisita(Date fechavisita) {
        this.fechavisita = fechavisita;
    }

    @XmlTransient
    public Collection<PlanServicio> getPlanServicioCollection() {
        return planServicioCollection;
    }

    public void setPlanServicioCollection(Collection<PlanServicio> planServicioCollection) {
        this.planServicioCollection = planServicioCollection;
    }

    public Profesional getProfesionalIdProfesional() {
        return profesionalIdProfesional;
    }

    public void setProfesionalIdProfesional(Profesional profesionalIdProfesional) {
        this.profesionalIdProfesional = profesionalIdProfesional;
    }

    @XmlTransient
    public Collection<Checklistvisita> getChecklistvisitaCollection() {
        return checklistvisitaCollection;
    }

    public void setChecklistvisitaCollection(Collection<Checklistvisita> checklistvisitaCollection) {
        this.checklistvisitaCollection = checklistvisitaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVisita != null ? idVisita.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Visita)) {
            return false;
        }
        Visita other = (Visita) object;
        if ((this.idVisita == null && other.idVisita != null) || (this.idVisita != null && !this.idVisita.equals(other.idVisita))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Visita[ idVisita=" + idVisita + " ]";
    }
    
}
