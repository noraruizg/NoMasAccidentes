/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
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
@Table(name = "ASESORIA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Asesoria.findAll", query = "SELECT a FROM Asesoria a")
    , @NamedQuery(name = "Asesoria.findByIdAsesoria", query = "SELECT a FROM Asesoria a WHERE a.idAsesoria = :idAsesoria")
    , @NamedQuery(name = "Asesoria.findByFechaasesoria", query = "SELECT a FROM Asesoria a WHERE a.fechaasesoria = :fechaasesoria")
    , @NamedQuery(name = "Asesoria.findByTipoasesoria", query = "SELECT a FROM Asesoria a WHERE a.tipoasesoria = :tipoasesoria")})
public class Asesoria implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_ASESORIA")
    private int idAsesoria;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHAASESORIA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaasesoria;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "TIPOASESORIA")
    private String tipoasesoria;
    @OneToMany(mappedBy = "asesoriaIdAsesoria")
    private Collection<Checklistasesoria> checklistasesoriaCollection;
    @OneToMany(mappedBy = "asesoriaIdAsesoria")
    private Collection<PlanServicio> planServicioCollection;
    @JoinColumn(name = "PROFESIONAL_ID_PROFESIONAL", referencedColumnName = "ID_PROFESIONAL")
    @ManyToOne(optional = false)
    private Profesional profesionalIdProfesional;

    public Asesoria() {
    }

    public Asesoria(int idAsesoria) {
        this.idAsesoria = idAsesoria;
    }

    public Asesoria( Date fechaasesoria, String tipoasesoria) {
        //this.idAsesoria = idAsesoria;
        this.fechaasesoria = fechaasesoria;
        this.tipoasesoria = tipoasesoria;
    }

    public int getIdAsesoria() {
        return idAsesoria;
    }

    public void setIdAsesoria(int idAsesoria) {
        this.idAsesoria = idAsesoria;
    }

    public Date getFechaasesoria() {
        return fechaasesoria;
    }

    public void setFechaasesoria(Date fechaasesoria) {
        this.fechaasesoria = fechaasesoria;
    }

    public String getTipoasesoria() {
        return tipoasesoria;
    }

    public void setTipoasesoria(String tipoasesoria) {
        this.tipoasesoria = tipoasesoria;
    }

    @XmlTransient
    public Collection<Checklistasesoria> getChecklistasesoriaCollection() {
        return checklistasesoriaCollection;
    }

    public void setChecklistasesoriaCollection(Collection<Checklistasesoria> checklistasesoriaCollection) {
        this.checklistasesoriaCollection = checklistasesoriaCollection;
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


    @Override
    public String toString() {
        return "modelo.Asesoria[ idAsesoria=" + idAsesoria + " ]";
    }
    
}
