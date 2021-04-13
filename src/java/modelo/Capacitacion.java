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
@Table(name = "CAPACITACION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Capacitacion.findAll", query = "SELECT c FROM Capacitacion c")
    , @NamedQuery(name = "Capacitacion.findByIdCap", query = "SELECT c FROM Capacitacion c WHERE c.capacitacionPK.idCap = :idCap")
    , @NamedQuery(name = "Capacitacion.findByFechacap", query = "SELECT c FROM Capacitacion c WHERE c.fechacap = :fechacap")
    , @NamedQuery(name = "Capacitacion.findByHoracap", query = "SELECT c FROM Capacitacion c WHERE c.horacap = :horacap")
    , @NamedQuery(name = "Capacitacion.findByCasistentes", query = "SELECT c FROM Capacitacion c WHERE c.casistentes = :casistentes")
    , @NamedQuery(name = "Capacitacion.findByMateriales", query = "SELECT c FROM Capacitacion c WHERE c.materiales = :materiales")
    , @NamedQuery(name = "Capacitacion.findByValor", query = "SELECT c FROM Capacitacion c WHERE c.valor = :valor")
    , @NamedQuery(name = "Capacitacion.findByDescripcion", query = "SELECT c FROM Capacitacion c WHERE c.descripcion = :descripcion")
    , @NamedQuery(name = "Capacitacion.findByExtraIdSolicitudes", query = "SELECT c FROM Capacitacion c WHERE c.capacitacionPK.extraIdSolicitudes = :extraIdSolicitudes")
    , @NamedQuery(name = "Capacitacion.findByExtraContratoIdContrato", query = "SELECT c FROM Capacitacion c WHERE c.capacitacionPK.extraContratoIdContrato = :extraContratoIdContrato")
    , @NamedQuery(name = "Capacitacion.findByExtraContClienteIdCliente", query = "SELECT c FROM Capacitacion c WHERE c.capacitacionPK.extraContClienteIdCliente = :extraContClienteIdCliente")
    , @NamedQuery(name = "Capacitacion.findByExtraContCliUsIdUsuario", query = "SELECT c FROM Capacitacion c WHERE c.capacitacionPK.extraContCliUsIdUsuario = :extraContCliUsIdUsuario")
    , @NamedQuery(name = "Capacitacion.findByIdVisita", query = "SELECT c FROM Capacitacion c WHERE c.capacitacionPK.idVisita = :idVisita")
    , @NamedQuery(name = "Capacitacion.findByIdProfesional", query = "SELECT c FROM Capacitacion c WHERE c.idProfesional = :idProfesional")
    , @NamedQuery(name = "Capacitacion.findByIdProfesional1", query = "SELECT c FROM Capacitacion c WHERE c.idProfesional1 = :idProfesional1")
    , @NamedQuery(name = "Capacitacion.findByIdProfesional2", query = "SELECT c FROM Capacitacion c WHERE c.capacitacionPK.idProfesional2 = :idProfesional2")
    , @NamedQuery(name = "Capacitacion.findByIdProfesional11", query = "SELECT c FROM Capacitacion c WHERE c.capacitacionPK.idProfesional11 = :idProfesional11")
    , @NamedQuery(name = "Capacitacion.findByIdCliente", query = "SELECT c FROM Capacitacion c WHERE c.idCliente = :idCliente")
    , @NamedQuery(name = "Capacitacion.findByIdSolicitudes", query = "SELECT c FROM Capacitacion c WHERE c.idSolicitudes = :idSolicitudes")})
public class Capacitacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CapacitacionPK capacitacionPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHACAP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechacap;
    @Basic(optional = false)
    @NotNull
    @Column(name = "HORACAP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horacap;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CASISTENTES")
    private BigInteger casistentes;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "MATERIALES")
    private String materiales;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VALOR")
    private BigInteger valor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PROFESIONAL")
    private BigInteger idProfesional;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PROFESIONAL1")
    private BigInteger idProfesional1;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_CLIENTE")
    private BigInteger idCliente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_SOLICITUDES")
    private BigInteger idSolicitudes;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "capacitacion")
    private Collection<Asistencia> asistenciaCollection;
    @JoinColumns({
        @JoinColumn(name = "EXTRA_ID_SOLICITUDES", referencedColumnName = "ID_SOLICITUDES", insertable = false, updatable = false)
        , @JoinColumn(name = "EXTRA_CONTRATO_ID_CONTRATO", referencedColumnName = "CONTRATO_ID_CONTRATO", insertable = false, updatable = false)
        , @JoinColumn(name = "EXTRA_CONT_CLIENTE_ID_CLIENTE", referencedColumnName = "CONTRATO_CLIENTE_ID_CLIENTE", insertable = false, updatable = false)
        , @JoinColumn(name = "EXTRA_CONT_CLI_US_ID_USUARIO", referencedColumnName = "CONTRATO_CLI_US_ID_USUARIO", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Extra extra;
    @JoinColumn(name = "SERVICIO_ID_SERVICIO", referencedColumnName = "ID_SERVICIO")
    @ManyToOne(optional = false)
    private Servicio servicioIdServicio;

    public Capacitacion() {
    }

    public Capacitacion(CapacitacionPK capacitacionPK) {
        this.capacitacionPK = capacitacionPK;
    }

    public Capacitacion(CapacitacionPK capacitacionPK, Date fechacap, Date horacap, BigInteger casistentes, String materiales, BigInteger valor, String descripcion, BigInteger idProfesional, BigInteger idProfesional1, BigInteger idCliente, BigInteger idSolicitudes) {
        this.capacitacionPK = capacitacionPK;
        this.fechacap = fechacap;
        this.horacap = horacap;
        this.casistentes = casistentes;
        this.materiales = materiales;
        this.valor = valor;
        this.descripcion = descripcion;
        this.idProfesional = idProfesional;
        this.idProfesional1 = idProfesional1;
        this.idCliente = idCliente;
        this.idSolicitudes = idSolicitudes;
    }

    public Capacitacion(BigInteger idCap, BigInteger extraIdSolicitudes, BigInteger extraContratoIdContrato, BigInteger extraContClienteIdCliente, BigInteger extraContCliUsIdUsuario, BigInteger idVisita, BigInteger idProfesional2, BigInteger idProfesional11) {
        this.capacitacionPK = new CapacitacionPK(idCap, extraIdSolicitudes, extraContratoIdContrato, extraContClienteIdCliente, extraContCliUsIdUsuario, idVisita, idProfesional2, idProfesional11);
    }

    public CapacitacionPK getCapacitacionPK() {
        return capacitacionPK;
    }

    public void setCapacitacionPK(CapacitacionPK capacitacionPK) {
        this.capacitacionPK = capacitacionPK;
    }

    public Date getFechacap() {
        return fechacap;
    }

    public void setFechacap(Date fechacap) {
        this.fechacap = fechacap;
    }

    public Date getHoracap() {
        return horacap;
    }

    public void setHoracap(Date horacap) {
        this.horacap = horacap;
    }

    public BigInteger getCasistentes() {
        return casistentes;
    }

    public void setCasistentes(BigInteger casistentes) {
        this.casistentes = casistentes;
    }

    public String getMateriales() {
        return materiales;
    }

    public void setMateriales(String materiales) {
        this.materiales = materiales;
    }

    public BigInteger getValor() {
        return valor;
    }

    public void setValor(BigInteger valor) {
        this.valor = valor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigInteger getIdProfesional() {
        return idProfesional;
    }

    public void setIdProfesional(BigInteger idProfesional) {
        this.idProfesional = idProfesional;
    }

    public BigInteger getIdProfesional1() {
        return idProfesional1;
    }

    public void setIdProfesional1(BigInteger idProfesional1) {
        this.idProfesional1 = idProfesional1;
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

    @XmlTransient
    public Collection<Asistencia> getAsistenciaCollection() {
        return asistenciaCollection;
    }

    public void setAsistenciaCollection(Collection<Asistencia> asistenciaCollection) {
        this.asistenciaCollection = asistenciaCollection;
    }

    public Extra getExtra() {
        return extra;
    }

    public void setExtra(Extra extra) {
        this.extra = extra;
    }

    public Servicio getServicioIdServicio() {
        return servicioIdServicio;
    }

    public void setServicioIdServicio(Servicio servicioIdServicio) {
        this.servicioIdServicio = servicioIdServicio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (capacitacionPK != null ? capacitacionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Capacitacion)) {
            return false;
        }
        Capacitacion other = (Capacitacion) object;
        if ((this.capacitacionPK == null && other.capacitacionPK != null) || (this.capacitacionPK != null && !this.capacitacionPK.equals(other.capacitacionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Capacitacion[ capacitacionPK=" + capacitacionPK + " ]";
    }
    
}
