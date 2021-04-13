/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author norar
 */
@Entity
@Table(name = "LLAMADA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Llamada.findAll", query = "SELECT l FROM Llamada l")
    , @NamedQuery(name = "Llamada.findByIdLlamada", query = "SELECT l FROM Llamada l WHERE l.llamadaPK.idLlamada = :idLlamada")
    , @NamedQuery(name = "Llamada.findByFechallamada", query = "SELECT l FROM Llamada l WHERE l.fechallamada = :fechallamada")
    , @NamedQuery(name = "Llamada.findByHorallamada", query = "SELECT l FROM Llamada l WHERE l.horallamada = :horallamada")
    , @NamedQuery(name = "Llamada.findByCosto", query = "SELECT l FROM Llamada l WHERE l.costo = :costo")
    , @NamedQuery(name = "Llamada.findByDescripcion", query = "SELECT l FROM Llamada l WHERE l.descripcion = :descripcion")
    , @NamedQuery(name = "Llamada.findByExtraIdSolicitudes", query = "SELECT l FROM Llamada l WHERE l.llamadaPK.extraIdSolicitudes = :extraIdSolicitudes")
    , @NamedQuery(name = "Llamada.findByExtraContratoIdContrato", query = "SELECT l FROM Llamada l WHERE l.llamadaPK.extraContratoIdContrato = :extraContratoIdContrato")
    , @NamedQuery(name = "Llamada.findByExtraContCliIdCliente", query = "SELECT l FROM Llamada l WHERE l.llamadaPK.extraContCliIdCliente = :extraContCliIdCliente")
    , @NamedQuery(name = "Llamada.findByExtraContCliUsIdUsuario", query = "SELECT l FROM Llamada l WHERE l.llamadaPK.extraContCliUsIdUsuario = :extraContCliUsIdUsuario")
    , @NamedQuery(name = "Llamada.findByServicioIdServicio", query = "SELECT l FROM Llamada l WHERE l.llamadaPK.servicioIdServicio = :servicioIdServicio")
    , @NamedQuery(name = "Llamada.findByIdCliente", query = "SELECT l FROM Llamada l WHERE l.idCliente = :idCliente")
    , @NamedQuery(name = "Llamada.findByIdSolicitudes", query = "SELECT l FROM Llamada l WHERE l.idSolicitudes = :idSolicitudes")})
public class Llamada implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected LlamadaPK llamadaPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHALLAMADA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechallamada;
    @Basic(optional = false)
    @NotNull
    @Column(name = "HORALLAMADA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horallamada;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COSTO")
    private BigInteger costo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_CLIENTE")
    private BigInteger idCliente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_SOLICITUDES")
    private BigInteger idSolicitudes;
    @JoinColumns({
        @JoinColumn(name = "EXTRA_ID_SOLICITUDES", referencedColumnName = "ID_SOLICITUDES", insertable = false, updatable = false)
        , @JoinColumn(name = "EXTRA_CONTRATO_ID_CONTRATO", referencedColumnName = "CONTRATO_ID_CONTRATO", insertable = false, updatable = false)
        , @JoinColumn(name = "EXTRA_CONT_CLI_ID_CLIENTE", referencedColumnName = "CONTRATO_CLIENTE_ID_CLIENTE", insertable = false, updatable = false)
        , @JoinColumn(name = "EXTRA_CONT_CLI_US_ID_USUARIO", referencedColumnName = "CONTRATO_CLI_US_ID_USUARIO", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Extra extra;
    @JoinColumn(name = "SERVICIO_ID_SERVICIO", referencedColumnName = "ID_SERVICIO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Servicio servicio;

    public Llamada() {
    }

    public Llamada(LlamadaPK llamadaPK) {
        this.llamadaPK = llamadaPK;
    }

    public Llamada(LlamadaPK llamadaPK, Date fechallamada, Date horallamada, BigInteger costo, String descripcion, BigInteger idCliente, BigInteger idSolicitudes) {
        this.llamadaPK = llamadaPK;
        this.fechallamada = fechallamada;
        this.horallamada = horallamada;
        this.costo = costo;
        this.descripcion = descripcion;
        this.idCliente = idCliente;
        this.idSolicitudes = idSolicitudes;
    }

    public Llamada(BigInteger idLlamada, BigInteger extraIdSolicitudes, BigInteger extraContratoIdContrato, BigInteger extraContCliIdCliente, BigInteger extraContCliUsIdUsuario, BigInteger servicioIdServicio) {
        this.llamadaPK = new LlamadaPK(idLlamada, extraIdSolicitudes, extraContratoIdContrato, extraContCliIdCliente, extraContCliUsIdUsuario, servicioIdServicio);
    }

    public LlamadaPK getLlamadaPK() {
        return llamadaPK;
    }

    public void setLlamadaPK(LlamadaPK llamadaPK) {
        this.llamadaPK = llamadaPK;
    }

    public Date getFechallamada() {
        return fechallamada;
    }

    public void setFechallamada(Date fechallamada) {
        this.fechallamada = fechallamada;
    }

    public Date getHorallamada() {
        return horallamada;
    }

    public void setHorallamada(Date horallamada) {
        this.horallamada = horallamada;
    }

    public BigInteger getCosto() {
        return costo;
    }

    public void setCosto(BigInteger costo) {
        this.costo = costo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigInteger getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(BigInteger idCliente) {
        this.idCliente = idCliente;
    }

    public BigInteger getIdSolicitudes() {
        return idSolicitudes;
    }

    public void setIdSolicitudes(BigInteger idSolicitudes) {
        this.idSolicitudes = idSolicitudes;
    }

    public Extra getExtra() {
        return extra;
    }

    public void setExtra(Extra extra) {
        this.extra = extra;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (llamadaPK != null ? llamadaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Llamada)) {
            return false;
        }
        Llamada other = (Llamada) object;
        if ((this.llamadaPK == null && other.llamadaPK != null) || (this.llamadaPK != null && !this.llamadaPK.equals(other.llamadaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Llamada[ llamadaPK=" + llamadaPK + " ]";
    }
    
}
