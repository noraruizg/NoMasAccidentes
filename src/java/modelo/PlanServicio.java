/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "PLAN_SERVICIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlanServicio.findAll", query = "SELECT p FROM PlanServicio p")
    , @NamedQuery(name = "PlanServicio.findByIdPlanServicio", query = "SELECT p FROM PlanServicio p WHERE p.idPlanServicio = :idPlanServicio")
    , @NamedQuery(name = "PlanServicio.findByNombreplan", query = "SELECT p FROM PlanServicio p WHERE p.nombreplan = :nombreplan")
    , @NamedQuery(name = "PlanServicio.findByDescripcionplan", query = "SELECT p FROM PlanServicio p WHERE p.descripcionplan = :descripcionplan")
    , @NamedQuery(name = "PlanServicio.findByCostoplan", query = "SELECT p FROM PlanServicio p WHERE p.costoplan = :costoplan")
    , @NamedQuery(name = "PlanServicio.findByVisitaIdVisita", query = "SELECT p FROM PlanServicio p WHERE p.visitaIdVisita = :visitaIdVisita")})
public class PlanServicio implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PLAN_SERVICIO")
    private BigDecimal idPlanServicio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOMBREPLAN")
    private String nombreplan;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "DESCRIPCIONPLAN")
    private String descripcionplan;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COSTOPLAN")
    private BigInteger costoplan;
    @Column(name = "VISITA_ID_VISITA")
    private BigInteger visitaIdVisita;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "planServicioIdPlanServicio")
    private Collection<Contrato> contratoCollection;
    @JoinColumn(name = "ASESORIA_ID_ASESORIA", referencedColumnName = "ID_ASESORIA")
    @ManyToOne
    private Asesoria asesoriaIdAsesoria;
    @JoinColumn(name = "CAPACITACION_ID_CAPACITACION", referencedColumnName = "ID_CAPACITACION")
    @ManyToOne
    private Capacitacion capacitacionIdCapacitacion;
    @JoinColumn(name = "LLAMADA_ID_LLAMADA", referencedColumnName = "ID_LLAMADA")
    @ManyToOne
    private Llamada llamadaIdLlamada;

    public PlanServicio() {
    }

    public PlanServicio(BigDecimal idPlanServicio) {
        this.idPlanServicio = idPlanServicio;
    }

    public PlanServicio(BigDecimal idPlanServicio, String nombreplan, String descripcionplan, BigInteger costoplan) {
        this.idPlanServicio = idPlanServicio;
        this.nombreplan = nombreplan;
        this.descripcionplan = descripcionplan;
        this.costoplan = costoplan;
    }

    public BigDecimal getIdPlanServicio() {
        return idPlanServicio;
    }

    public void setIdPlanServicio(BigDecimal idPlanServicio) {
        this.idPlanServicio = idPlanServicio;
    }

    public String getNombreplan() {
        return nombreplan;
    }

    public void setNombreplan(String nombreplan) {
        this.nombreplan = nombreplan;
    }

    public String getDescripcionplan() {
        return descripcionplan;
    }

    public void setDescripcionplan(String descripcionplan) {
        this.descripcionplan = descripcionplan;
    }

    public BigInteger getCostoplan() {
        return costoplan;
    }

    public void setCostoplan(BigInteger costoplan) {
        this.costoplan = costoplan;
    }

    public BigInteger getVisitaIdVisita() {
        return visitaIdVisita;
    }

    public void setVisitaIdVisita(BigInteger visitaIdVisita) {
        this.visitaIdVisita = visitaIdVisita;
    }

    @XmlTransient
    public Collection<Contrato> getContratoCollection() {
        return contratoCollection;
    }

    public void setContratoCollection(Collection<Contrato> contratoCollection) {
        this.contratoCollection = contratoCollection;
    }

    public Asesoria getAsesoriaIdAsesoria() {
        return asesoriaIdAsesoria;
    }

    public void setAsesoriaIdAsesoria(Asesoria asesoriaIdAsesoria) {
        this.asesoriaIdAsesoria = asesoriaIdAsesoria;
    }

    public Capacitacion getCapacitacionIdCapacitacion() {
        return capacitacionIdCapacitacion;
    }

    public void setCapacitacionIdCapacitacion(Capacitacion capacitacionIdCapacitacion) {
        this.capacitacionIdCapacitacion = capacitacionIdCapacitacion;
    }

    public Llamada getLlamadaIdLlamada() {
        return llamadaIdLlamada;
    }

    public void setLlamadaIdLlamada(Llamada llamadaIdLlamada) {
        this.llamadaIdLlamada = llamadaIdLlamada;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPlanServicio != null ? idPlanServicio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlanServicio)) {
            return false;
        }
        PlanServicio other = (PlanServicio) object;
        if ((this.idPlanServicio == null && other.idPlanServicio != null) || (this.idPlanServicio != null && !this.idPlanServicio.equals(other.idPlanServicio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.PlanServicio[ idPlanServicio=" + idPlanServicio + " ]";
    }
    
}
