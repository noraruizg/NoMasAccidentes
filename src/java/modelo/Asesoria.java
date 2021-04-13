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
@Table(name = "ASESORIA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Asesoria.findAll", query = "SELECT a FROM Asesoria a")
    , @NamedQuery(name = "Asesoria.findByIdAsesoria", query = "SELECT a FROM Asesoria a WHERE a.asesoriaPK.idAsesoria = :idAsesoria")
    , @NamedQuery(name = "Asesoria.findByFechaasesoria", query = "SELECT a FROM Asesoria a WHERE a.fechaasesoria = :fechaasesoria")
    , @NamedQuery(name = "Asesoria.findByHoraasesoria", query = "SELECT a FROM Asesoria a WHERE a.horaasesoria = :horaasesoria")
    , @NamedQuery(name = "Asesoria.findByValor", query = "SELECT a FROM Asesoria a WHERE a.valor = :valor")
    , @NamedQuery(name = "Asesoria.findByDescripcion", query = "SELECT a FROM Asesoria a WHERE a.descripcion = :descripcion")
    , @NamedQuery(name = "Asesoria.findByExtraIdSolicitudes", query = "SELECT a FROM Asesoria a WHERE a.asesoriaPK.extraIdSolicitudes = :extraIdSolicitudes")
    , @NamedQuery(name = "Asesoria.findByExtraContratoIdContrato", query = "SELECT a FROM Asesoria a WHERE a.asesoriaPK.extraContratoIdContrato = :extraContratoIdContrato")
    , @NamedQuery(name = "Asesoria.findByExtraContClienteIdCliente", query = "SELECT a FROM Asesoria a WHERE a.asesoriaPK.extraContClienteIdCliente = :extraContClienteIdCliente")
    , @NamedQuery(name = "Asesoria.findByExtraContCliUsIdUsuario", query = "SELECT a FROM Asesoria a WHERE a.asesoriaPK.extraContCliUsIdUsuario = :extraContCliUsIdUsuario")
    , @NamedQuery(name = "Asesoria.findByIdVisita", query = "SELECT a FROM Asesoria a WHERE a.asesoriaPK.idVisita = :idVisita")
    , @NamedQuery(name = "Asesoria.findByIdProfesional", query = "SELECT a FROM Asesoria a WHERE a.idProfesional = :idProfesional")
    , @NamedQuery(name = "Asesoria.findByIdProfesional1", query = "SELECT a FROM Asesoria a WHERE a.idProfesional1 = :idProfesional1")
    , @NamedQuery(name = "Asesoria.findByIdProfesional2", query = "SELECT a FROM Asesoria a WHERE a.asesoriaPK.idProfesional2 = :idProfesional2")
    , @NamedQuery(name = "Asesoria.findByIdProfesional11", query = "SELECT a FROM Asesoria a WHERE a.asesoriaPK.idProfesional11 = :idProfesional11")
    , @NamedQuery(name = "Asesoria.findByIdCliente", query = "SELECT a FROM Asesoria a WHERE a.idCliente = :idCliente")
    , @NamedQuery(name = "Asesoria.findByIdSolicitudes", query = "SELECT a FROM Asesoria a WHERE a.idSolicitudes = :idSolicitudes")})
public class Asesoria implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AsesoriaPK asesoriaPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHAASESORIA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaasesoria;
    @Basic(optional = false)
    @NotNull
    @Column(name = "HORAASESORIA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horaasesoria;
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

    public Asesoria() {
    }

    public Asesoria(AsesoriaPK asesoriaPK) {
        this.asesoriaPK = asesoriaPK;
    }

    public Asesoria(AsesoriaPK asesoriaPK, Date fechaasesoria, Date horaasesoria, BigInteger valor, String descripcion, BigInteger idProfesional, BigInteger idProfesional1, BigInteger idCliente, BigInteger idSolicitudes) {
        this.asesoriaPK = asesoriaPK;
        this.fechaasesoria = fechaasesoria;
        this.horaasesoria = horaasesoria;
        this.valor = valor;
        this.descripcion = descripcion;
        this.idProfesional = idProfesional;
        this.idProfesional1 = idProfesional1;
        this.idCliente = idCliente;
        this.idSolicitudes = idSolicitudes;
    }

    public Asesoria(BigInteger idAsesoria, BigInteger extraIdSolicitudes, BigInteger extraContratoIdContrato, BigInteger extraContClienteIdCliente, BigInteger extraContCliUsIdUsuario, BigInteger idVisita, BigInteger idProfesional2, BigInteger idProfesional11) {
        this.asesoriaPK = new AsesoriaPK(idAsesoria, extraIdSolicitudes, extraContratoIdContrato, extraContClienteIdCliente, extraContCliUsIdUsuario, idVisita, idProfesional2, idProfesional11);
    }

    public AsesoriaPK getAsesoriaPK() {
        return asesoriaPK;
    }

    public void setAsesoriaPK(AsesoriaPK asesoriaPK) {
        this.asesoriaPK = asesoriaPK;
    }

    public Date getFechaasesoria() {
        return fechaasesoria;
    }

    public void setFechaasesoria(Date fechaasesoria) {
        this.fechaasesoria = fechaasesoria;
    }

    public Date getHoraasesoria() {
        return horaasesoria;
    }

    public void setHoraasesoria(Date horaasesoria) {
        this.horaasesoria = horaasesoria;
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
        hash += (asesoriaPK != null ? asesoriaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Asesoria)) {
            return false;
        }
        Asesoria other = (Asesoria) object;
        if ((this.asesoriaPK == null && other.asesoriaPK != null) || (this.asesoriaPK != null && !this.asesoriaPK.equals(other.asesoriaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Asesoria[ asesoriaPK=" + asesoriaPK + " ]";
    }
    
}
