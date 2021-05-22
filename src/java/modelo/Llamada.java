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
@Table(name = "LLAMADA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Llamada.findAll", query = "SELECT l FROM Llamada l")
    , @NamedQuery(name = "Llamada.findByIdLlamada", query = "SELECT l FROM Llamada l WHERE l.idLlamada = :idLlamada")
    , @NamedQuery(name = "Llamada.findByFechallamada", query = "SELECT l FROM Llamada l WHERE l.fechallamada = :fechallamada")
    , @NamedQuery(name = "Llamada.findByDescripcionllamada", query = "SELECT l FROM Llamada l WHERE l.descripcionllamada = :descripcionllamada")
    , @NamedQuery(name = "Llamada.findByCantllamada", query = "SELECT l FROM Llamada l WHERE l.cantllamada = :cantllamada")})
public class Llamada implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_LLAMADA")
    private int idLlamada;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHALLAMADA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechallamada;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "DESCRIPCIONLLAMADA")
    private String descripcionllamada;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CANTLLAMADA")
    private int cantllamada;
    @OneToMany(mappedBy = "llamadaIdLlamada")
    private Collection<PlanServicio> planServicioCollection;
    @JoinColumn(name = "PROFESIONAL_ID_PROFESIONAL", referencedColumnName = "ID_PROFESIONAL")
    @ManyToOne
    private Profesional profesionalIdProfesional;

    public Llamada() {
    }

    public Llamada(int idLlamada) {
        this.idLlamada = idLlamada;
    }

    public Llamada( Date fechallamada, String descripcionllamada, int cantllamada) {
       // this.idLlamada = idLlamada;
        this.fechallamada = fechallamada;
        this.descripcionllamada = descripcionllamada;
        this.cantllamada = cantllamada;
    }

    public int getIdLlamada() {
        return idLlamada;
    }

    public void setIdLlamada(int idLlamada) {
        this.idLlamada = idLlamada;
    }

    public Date getFechallamada() {
        return fechallamada;
    }

    public void setFechallamada(Date fechallamada) {
        this.fechallamada = fechallamada;
    }

    public String getDescripcionllamada() {
        return descripcionllamada;
    }

    public void setDescripcionllamada(String descripcionllamada) {
        this.descripcionllamada = descripcionllamada;
    }

    public int getCantllamada() {
        return cantllamada;
    }

    public void setCantllamada(int cantllamada) {
        this.cantllamada = cantllamada;
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
        return "modelo.Llamada[ idLlamada=" + idLlamada + " ]";
    }
    
}
