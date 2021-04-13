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
import javax.persistence.ManyToMany;
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
@Table(name = "SERVICIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Servicio.findAll", query = "SELECT s FROM Servicio s")
    , @NamedQuery(name = "Servicio.findByIdServicio", query = "SELECT s FROM Servicio s WHERE s.idServicio = :idServicio")
    , @NamedQuery(name = "Servicio.findByDescripcionservicio", query = "SELECT s FROM Servicio s WHERE s.descripcionservicio = :descripcionservicio")
    , @NamedQuery(name = "Servicio.findByCosto", query = "SELECT s FROM Servicio s WHERE s.costo = :costo")
    , @NamedQuery(name = "Servicio.findByIdCliente", query = "SELECT s FROM Servicio s WHERE s.idCliente = :idCliente")
    , @NamedQuery(name = "Servicio.findByIdUsuario", query = "SELECT s FROM Servicio s WHERE s.idUsuario = :idUsuario")
    , @NamedQuery(name = "Servicio.findByContratoIdContrato", query = "SELECT s FROM Servicio s WHERE s.contratoIdContrato = :contratoIdContrato")
    , @NamedQuery(name = "Servicio.findByContratoClienteIdCliente", query = "SELECT s FROM Servicio s WHERE s.contratoClienteIdCliente = :contratoClienteIdCliente")
    , @NamedQuery(name = "Servicio.findByContratoClienteIdUsuario", query = "SELECT s FROM Servicio s WHERE s.contratoClienteIdUsuario = :contratoClienteIdUsuario")})
public class Servicio implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_SERVICIO")
    private BigDecimal idServicio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "DESCRIPCIONSERVICIO")
    private String descripcionservicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COSTO")
    private BigInteger costo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_CLIENTE")
    private BigInteger idCliente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_USUARIO")
    private BigInteger idUsuario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CONTRATO_ID_CONTRATO")
    private BigInteger contratoIdContrato;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CONTRATO_CLIENTE_ID_CLIENTE")
    private BigInteger contratoClienteIdCliente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CONTRATO_CLIENTE_ID_USUARIO")
    private BigInteger contratoClienteIdUsuario;
    @ManyToMany(mappedBy = "servicioCollection")
    private Collection<Contrato> contratoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "servicio")
    private Collection<Relation13> relation13Collection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "servicioIdServicio")
    private Collection<Capacitacion> capacitacionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "servicio")
    private Collection<Llamada> llamadaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "servicioIdServicio")
    private Collection<Visita> visitaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "servicioIdServicio")
    private Collection<Pago> pagoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "servicioIdServicio")
    private Collection<Asesoria> asesoriaCollection;

    public Servicio() {
    }

    public Servicio(BigDecimal idServicio) {
        this.idServicio = idServicio;
    }

    public Servicio(BigDecimal idServicio, String descripcionservicio, BigInteger costo, BigInteger idCliente, BigInteger idUsuario, BigInteger contratoIdContrato, BigInteger contratoClienteIdCliente, BigInteger contratoClienteIdUsuario) {
        this.idServicio = idServicio;
        this.descripcionservicio = descripcionservicio;
        this.costo = costo;
        this.idCliente = idCliente;
        this.idUsuario = idUsuario;
        this.contratoIdContrato = contratoIdContrato;
        this.contratoClienteIdCliente = contratoClienteIdCliente;
        this.contratoClienteIdUsuario = contratoClienteIdUsuario;
    }

    public BigDecimal getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(BigDecimal idServicio) {
        this.idServicio = idServicio;
    }

    public String getDescripcionservicio() {
        return descripcionservicio;
    }

    public void setDescripcionservicio(String descripcionservicio) {
        this.descripcionservicio = descripcionservicio;
    }

    public BigInteger getCosto() {
        return costo;
    }

    public void setCosto(BigInteger costo) {
        this.costo = costo;
    }

    public BigInteger getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(BigInteger idCliente) {
        this.idCliente = idCliente;
    }

    public BigInteger getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(BigInteger idUsuario) {
        this.idUsuario = idUsuario;
    }

    public BigInteger getContratoIdContrato() {
        return contratoIdContrato;
    }

    public void setContratoIdContrato(BigInteger contratoIdContrato) {
        this.contratoIdContrato = contratoIdContrato;
    }

    public BigInteger getContratoClienteIdCliente() {
        return contratoClienteIdCliente;
    }

    public void setContratoClienteIdCliente(BigInteger contratoClienteIdCliente) {
        this.contratoClienteIdCliente = contratoClienteIdCliente;
    }

    public BigInteger getContratoClienteIdUsuario() {
        return contratoClienteIdUsuario;
    }

    public void setContratoClienteIdUsuario(BigInteger contratoClienteIdUsuario) {
        this.contratoClienteIdUsuario = contratoClienteIdUsuario;
    }

    @XmlTransient
    public Collection<Contrato> getContratoCollection() {
        return contratoCollection;
    }

    public void setContratoCollection(Collection<Contrato> contratoCollection) {
        this.contratoCollection = contratoCollection;
    }

    @XmlTransient
    public Collection<Relation13> getRelation13Collection() {
        return relation13Collection;
    }

    public void setRelation13Collection(Collection<Relation13> relation13Collection) {
        this.relation13Collection = relation13Collection;
    }

    @XmlTransient
    public Collection<Capacitacion> getCapacitacionCollection() {
        return capacitacionCollection;
    }

    public void setCapacitacionCollection(Collection<Capacitacion> capacitacionCollection) {
        this.capacitacionCollection = capacitacionCollection;
    }

    @XmlTransient
    public Collection<Llamada> getLlamadaCollection() {
        return llamadaCollection;
    }

    public void setLlamadaCollection(Collection<Llamada> llamadaCollection) {
        this.llamadaCollection = llamadaCollection;
    }

    @XmlTransient
    public Collection<Visita> getVisitaCollection() {
        return visitaCollection;
    }

    public void setVisitaCollection(Collection<Visita> visitaCollection) {
        this.visitaCollection = visitaCollection;
    }

    @XmlTransient
    public Collection<Pago> getPagoCollection() {
        return pagoCollection;
    }

    public void setPagoCollection(Collection<Pago> pagoCollection) {
        this.pagoCollection = pagoCollection;
    }

    @XmlTransient
    public Collection<Asesoria> getAsesoriaCollection() {
        return asesoriaCollection;
    }

    public void setAsesoriaCollection(Collection<Asesoria> asesoriaCollection) {
        this.asesoriaCollection = asesoriaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idServicio != null ? idServicio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Servicio)) {
            return false;
        }
        Servicio other = (Servicio) object;
        if ((this.idServicio == null && other.idServicio != null) || (this.idServicio != null && !this.idServicio.equals(other.idServicio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Servicio[ idServicio=" + idServicio + " ]";
    }

    public Usuario get(int parseInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
