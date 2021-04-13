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
import javax.persistence.JoinColumns;
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
@Table(name = "EXTRA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Extra.findAll", query = "SELECT e FROM Extra e")
    , @NamedQuery(name = "Extra.findByIdSolicitudes", query = "SELECT e FROM Extra e WHERE e.extraPK.idSolicitudes = :idSolicitudes")
    , @NamedQuery(name = "Extra.findByDescripcion", query = "SELECT e FROM Extra e WHERE e.descripcion = :descripcion")
    , @NamedQuery(name = "Extra.findByTipo", query = "SELECT e FROM Extra e WHERE e.tipo = :tipo")
    , @NamedQuery(name = "Extra.findByFecha", query = "SELECT e FROM Extra e WHERE e.fecha = :fecha")
    , @NamedQuery(name = "Extra.findByContratoIdContrato", query = "SELECT e FROM Extra e WHERE e.extraPK.contratoIdContrato = :contratoIdContrato")
    , @NamedQuery(name = "Extra.findByContratoClienteIdCliente", query = "SELECT e FROM Extra e WHERE e.extraPK.contratoClienteIdCliente = :contratoClienteIdCliente")
    , @NamedQuery(name = "Extra.findByContratoCliUsIdUsuario", query = "SELECT e FROM Extra e WHERE e.extraPK.contratoCliUsIdUsuario = :contratoCliUsIdUsuario")
    , @NamedQuery(name = "Extra.findByIdCliente", query = "SELECT e FROM Extra e WHERE e.idCliente = :idCliente")})
public class Extra implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ExtraPK extraPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "TIPO")
    private String tipo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_CLIENTE")
    private BigInteger idCliente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "extra")
    private Collection<Capacitacion> capacitacionCollection;
    @JoinColumns({
        @JoinColumn(name = "CONTRATO_ID_CONTRATO", referencedColumnName = "ID_CONTRATO", insertable = false, updatable = false)
        , @JoinColumn(name = "CONTRATO_CLIENTE_ID_CLIENTE", referencedColumnName = "CLIENTE_ID_CLIENTE", insertable = false, updatable = false)
        , @JoinColumn(name = "CONTRATO_CLI_US_ID_USUARIO", referencedColumnName = "CLIENTE_USUARIO_ID_USUARIO", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Contrato contrato;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "extra")
    private Collection<Llamada> llamadaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "extra")
    private Collection<Asesoria> asesoriaCollection;

    public Extra() {
    }

    public Extra(ExtraPK extraPK) {
        this.extraPK = extraPK;
    }

    public Extra(ExtraPK extraPK, String descripcion, String tipo, Date fecha, BigInteger idCliente) {
        this.extraPK = extraPK;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.fecha = fecha;
        this.idCliente = idCliente;
    }

    public Extra(BigInteger idSolicitudes, BigInteger contratoIdContrato, BigInteger contratoClienteIdCliente, BigInteger contratoCliUsIdUsuario) {
        this.extraPK = new ExtraPK(idSolicitudes, contratoIdContrato, contratoClienteIdCliente, contratoCliUsIdUsuario);
    }

    public ExtraPK getExtraPK() {
        return extraPK;
    }

    public void setExtraPK(ExtraPK extraPK) {
        this.extraPK = extraPK;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public BigInteger getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(BigInteger idCliente) {
        this.idCliente = idCliente;
    }

    @XmlTransient
    public Collection<Capacitacion> getCapacitacionCollection() {
        return capacitacionCollection;
    }

    public void setCapacitacionCollection(Collection<Capacitacion> capacitacionCollection) {
        this.capacitacionCollection = capacitacionCollection;
    }

    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }

    @XmlTransient
    public Collection<Llamada> getLlamadaCollection() {
        return llamadaCollection;
    }

    public void setLlamadaCollection(Collection<Llamada> llamadaCollection) {
        this.llamadaCollection = llamadaCollection;
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
        hash += (extraPK != null ? extraPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Extra)) {
            return false;
        }
        Extra other = (Extra) object;
        if ((this.extraPK == null && other.extraPK != null) || (this.extraPK != null && !this.extraPK.equals(other.extraPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Extra[ extraPK=" + extraPK + " ]";
    }
    
}
