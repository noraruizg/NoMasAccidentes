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
@Table(name = "CONTRATO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contrato.findAll", query = "SELECT c FROM Contrato c")
    , @NamedQuery(name = "Contrato.findByIdContrato", query = "SELECT c FROM Contrato c WHERE c.contratoPK.idContrato = :idContrato")
    , @NamedQuery(name = "Contrato.findByFechainicio", query = "SELECT c FROM Contrato c WHERE c.fechainicio = :fechainicio")
    , @NamedQuery(name = "Contrato.findByFechatermino", query = "SELECT c FROM Contrato c WHERE c.fechatermino = :fechatermino")
    , @NamedQuery(name = "Contrato.findByClienteIdCliente", query = "SELECT c FROM Contrato c WHERE c.contratoPK.clienteIdCliente = :clienteIdCliente")
    , @NamedQuery(name = "Contrato.findByEstado", query = "SELECT c FROM Contrato c WHERE c.estado = :estado")})
public class Contrato implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ContratoPK contratoPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHAINICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechainicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHATERMINO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechatermino;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "ESTADO")
    private String estado;
    @JoinColumn(name = "CLIENTE_ID_CLIENTE", referencedColumnName = "ID_CLIENTE", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Cliente cliente;
    @JoinColumn(name = "PLAN_SERVICIO_ID_PLAN_SERVICIO", referencedColumnName = "ID_PLAN_SERVICIO")
    @ManyToOne(optional = false)
    private PlanServicio planServicioIdPlanServicio;
    @JoinColumn(name = "PROFESIONAL_ID_PROFESIONAL", referencedColumnName = "ID_PROFESIONAL")
    @ManyToOne(optional = false)
    private Profesional profesionalIdProfesional;
    @OneToMany(mappedBy = "contrato")
    private Collection<Pago> pagoCollection;
    @OneToMany(mappedBy = "contrato")
    private Collection<Servicioextra> servicioextraCollection;

    public Contrato() {
    }

    public Contrato(ContratoPK contratoPK) {
        this.contratoPK = contratoPK;
    }

    public Contrato( Date fechainicio, Date fechatermino, String estado) {
        //this.contratoPK = contratoPK;
        this.fechainicio = fechainicio;
        this.fechatermino = fechatermino;
        this.estado = estado;
    }

    public Contrato(int idContrato, int clienteIdCliente) {
        this.contratoPK = new ContratoPK(idContrato, clienteIdCliente);
    }

    public ContratoPK getContratoPK() {
        return contratoPK;
    }

    public void setContratoPK(ContratoPK contratoPK) {
        this.contratoPK = contratoPK;
    }

    public Date getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(Date fechainicio) {
        this.fechainicio = fechainicio;
    }

    public Date getFechatermino() {
        return fechatermino;
    }

    public void setFechatermino(Date fechatermino) {
        this.fechatermino = fechatermino;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public PlanServicio getPlanServicioIdPlanServicio() {
        return planServicioIdPlanServicio;
    }

    public void setPlanServicioIdPlanServicio(PlanServicio planServicioIdPlanServicio) {
        this.planServicioIdPlanServicio = planServicioIdPlanServicio;
    }

    public Profesional getProfesionalIdProfesional() {
        return profesionalIdProfesional;
    }

    public void setProfesionalIdProfesional(Profesional profesionalIdProfesional) {
        this.profesionalIdProfesional = profesionalIdProfesional;
    }

    @XmlTransient
    public Collection<Pago> getPagoCollection() {
        return pagoCollection;
    }

    public void setPagoCollection(Collection<Pago> pagoCollection) {
        this.pagoCollection = pagoCollection;
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
        hash += (contratoPK != null ? contratoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contrato)) {
            return false;
        }
        Contrato other = (Contrato) object;
        if ((this.contratoPK == null && other.contratoPK != null) || (this.contratoPK != null && !this.contratoPK.equals(other.contratoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Contrato[ contratoPK=" + contratoPK + " ]";
    }
    
}
