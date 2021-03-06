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
@Table(name = "CAPACITACION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Capacitacion.findAll", query = "SELECT c FROM Capacitacion c")
    , @NamedQuery(name = "Capacitacion.findByIdCapacitacion", query = "SELECT c FROM Capacitacion c WHERE c.idCapacitacion = :idCapacitacion")
    , @NamedQuery(name = "Capacitacion.findByFechacapacitacion", query = "SELECT c FROM Capacitacion c WHERE c.fechacapacitacion = :fechacapacitacion")
    , @NamedQuery(name = "Capacitacion.findByDescripcioncapacitacion", query = "SELECT c FROM Capacitacion c WHERE c.descripcioncapacitacion = :descripcioncapacitacion")
    , @NamedQuery(name = "Capacitacion.findByCantcapacitacion", query = "SELECT c FROM Capacitacion c WHERE c.cantcapacitacion = :cantcapacitacion")})
public class Capacitacion implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_CAPACITACION")
    private int idCapacitacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHACAPACITACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechacapacitacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "DESCRIPCIONCAPACITACION")
    private String descripcioncapacitacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CANTCAPACITACION")
    private int cantcapacitacion;
    @JoinColumn(name = "ASISTENTE_RUT_ASISTENTE", referencedColumnName = "RUT_ASISTENTE")
    @ManyToOne(optional = false)
    private Asistente asistenteRutAsistente;
    @JoinColumn(name = "MATERIAL_ID_MATERIALES", referencedColumnName = "ID_MATERIALES")
    @ManyToOne(optional = false)
    private Material materialIdMateriales;
    @JoinColumn(name = "PROFESIONAL_ID_PROFESIONAL", referencedColumnName = "ID_PROFESIONAL")
    @ManyToOne(optional = false)
    private Profesional profesionalIdProfesional;
    @OneToMany(mappedBy = "capacitacionIdCapacitacion")
    private Collection<PlanServicio> planServicioCollection;

    public Capacitacion() {
    }

    public Capacitacion(int idCapacitacion) {
        this.idCapacitacion = idCapacitacion;
    }

    public Capacitacion( Date fechacapacitacion, String descripcioncapacitacion,int cantcapacitacion) {
        //this.idCapacitacion = idCapacitacion;
        this.fechacapacitacion = fechacapacitacion;
        this.descripcioncapacitacion = descripcioncapacitacion;
        this.cantcapacitacion = cantcapacitacion;
    }

    public int getIdCapacitacion() {
        return idCapacitacion;
    }

    public void setIdCapacitacion(int idCapacitacion) {
        this.idCapacitacion = idCapacitacion;
    }

    public Date getFechacapacitacion() {
        return fechacapacitacion;
    }

    public void setFechacapacitacion(Date fechacapacitacion) {
        this.fechacapacitacion = fechacapacitacion;
    }

    public String getDescripcioncapacitacion() {
        return descripcioncapacitacion;
    }

    public void setDescripcioncapacitacion(String descripcioncapacitacion) {
        this.descripcioncapacitacion = descripcioncapacitacion;
    }

    public int getCantcapacitacion() {
        return cantcapacitacion;
    }

    public void setCantcapacitacion(int cantcapacitacion) {
        this.cantcapacitacion = cantcapacitacion;
    }

    public Asistente getAsistenteRutAsistente() {
        return asistenteRutAsistente;
    }

    public void setAsistenteRutAsistente(Asistente asistenteRutAsistente) {
        this.asistenteRutAsistente = asistenteRutAsistente;
    }

    public Material getMaterialIdMateriales() {
        return materialIdMateriales;
    }

    public void setMaterialIdMateriales(Material materialIdMateriales) {
        this.materialIdMateriales = materialIdMateriales;
    }

    public Profesional getProfesionalIdProfesional() {
        return profesionalIdProfesional;
    }

    public void setProfesionalIdProfesional(Profesional profesionalIdProfesional) {
        this.profesionalIdProfesional = profesionalIdProfesional;
    }

    @XmlTransient
    public Collection<PlanServicio> getPlanServicioCollection() {
        return planServicioCollection;
    }

    public void setPlanServicioCollection(Collection<PlanServicio> planServicioCollection) {
        this.planServicioCollection = planServicioCollection;
    }

    @Override
    public String toString() {
        return "modelo.Capacitacion[ idCapacitacion=" + idCapacitacion + " ]";
    }
    
}
