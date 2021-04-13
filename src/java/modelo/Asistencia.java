/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.math.BigInteger;
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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author norar
 */
@Entity
@Table(name = "ASISTENCIA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Asistencia.findAll", query = "SELECT a FROM Asistencia a")
    , @NamedQuery(name = "Asistencia.findByIdAsistencia", query = "SELECT a FROM Asistencia a WHERE a.asistenciaPK.idAsistencia = :idAsistencia")
    , @NamedQuery(name = "Asistencia.findByPresentes", query = "SELECT a FROM Asistencia a WHERE a.presentes = :presentes")
    , @NamedQuery(name = "Asistencia.findByTcapacitacion", query = "SELECT a FROM Asistencia a WHERE a.tcapacitacion = :tcapacitacion")
    , @NamedQuery(name = "Asistencia.findByCapacitacionIdCap", query = "SELECT a FROM Asistencia a WHERE a.asistenciaPK.capacitacionIdCap = :capacitacionIdCap")
    , @NamedQuery(name = "Asistencia.findByCapExtraIdSolicitudes", query = "SELECT a FROM Asistencia a WHERE a.asistenciaPK.capExtraIdSolicitudes = :capExtraIdSolicitudes")
    , @NamedQuery(name = "Asistencia.findByCapExtraContIdContrato", query = "SELECT a FROM Asistencia a WHERE a.asistenciaPK.capExtraContIdContrato = :capExtraContIdContrato")
    , @NamedQuery(name = "Asistencia.findByCapExtraContCliIdCliente", query = "SELECT a FROM Asistencia a WHERE a.asistenciaPK.capExtraContCliIdCliente = :capExtraContCliIdCliente")
    , @NamedQuery(name = "Asistencia.findByCapExtraContUsIdUsuario", query = "SELECT a FROM Asistencia a WHERE a.asistenciaPK.capExtraContUsIdUsuario = :capExtraContUsIdUsuario")
    , @NamedQuery(name = "Asistencia.findByCapacitacionIdVisita", query = "SELECT a FROM Asistencia a WHERE a.asistenciaPK.capacitacionIdVisita = :capacitacionIdVisita")
    , @NamedQuery(name = "Asistencia.findByCapacitacionIdProfesional", query = "SELECT a FROM Asistencia a WHERE a.capacitacionIdProfesional = :capacitacionIdProfesional")
    , @NamedQuery(name = "Asistencia.findByCapacitacionIdProfesional1", query = "SELECT a FROM Asistencia a WHERE a.capacitacionIdProfesional1 = :capacitacionIdProfesional1")
    , @NamedQuery(name = "Asistencia.findByCapacitacionIdProfesional3", query = "SELECT a FROM Asistencia a WHERE a.asistenciaPK.capacitacionIdProfesional3 = :capacitacionIdProfesional3")
    , @NamedQuery(name = "Asistencia.findByCapacitacionIdProfesional12", query = "SELECT a FROM Asistencia a WHERE a.asistenciaPK.capacitacionIdProfesional12 = :capacitacionIdProfesional12")
    , @NamedQuery(name = "Asistencia.findByIdCliente", query = "SELECT a FROM Asistencia a WHERE a.idCliente = :idCliente")
    , @NamedQuery(name = "Asistencia.findByIdSolicitudes", query = "SELECT a FROM Asistencia a WHERE a.idSolicitudes = :idSolicitudes")})
public class Asistencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AsistenciaPK asistenciaPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRESENTES")
    private BigInteger presentes;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TCAPACITACION")
    private BigInteger tcapacitacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CAPACITACION_ID_PROFESIONAL")
    private BigInteger capacitacionIdProfesional;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CAPACITACION_ID_PROFESIONAL1")
    private BigInteger capacitacionIdProfesional1;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_CLIENTE")
    private BigInteger idCliente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_SOLICITUDES")
    private BigInteger idSolicitudes;
    @JoinColumns({
        @JoinColumn(name = "CAPACITACION_ID_CAP", referencedColumnName = "ID_CAP", insertable = false, updatable = false)
        , @JoinColumn(name = "CAP_EXTRA_ID_SOLICITUDES", referencedColumnName = "EXTRA_ID_SOLICITUDES", insertable = false, updatable = false)
        , @JoinColumn(name = "CAP_EXTRA_CONT_ID_CONTRATO", referencedColumnName = "EXTRA_CONTRATO_ID_CONTRATO", insertable = false, updatable = false)
        , @JoinColumn(name = "CAP_EXTRA_CONT_CLI_ID_CLIENTE", referencedColumnName = "EXTRA_CONT_CLIENTE_ID_CLIENTE", insertable = false, updatable = false)
        , @JoinColumn(name = "CAP_EXTRA_CONT_US_ID_USUARIO", referencedColumnName = "EXTRA_CONT_CLI_US_ID_USUARIO", insertable = false, updatable = false)
        , @JoinColumn(name = "CAPACITACION_ID_VISITA", referencedColumnName = "ID_VISITA", insertable = false, updatable = false)
        , @JoinColumn(name = "CAPACITACION_ID_PROFESIONAL3", referencedColumnName = "ID_PROFESIONAL2", insertable = false, updatable = false)
        , @JoinColumn(name = "CAPACITACION_ID_PROFESIONAL12", referencedColumnName = "ID_PROFESIONAL11", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Capacitacion capacitacion;

    public Asistencia() {
    }

    public Asistencia(AsistenciaPK asistenciaPK) {
        this.asistenciaPK = asistenciaPK;
    }

    public Asistencia(AsistenciaPK asistenciaPK, BigInteger presentes, BigInteger tcapacitacion, BigInteger capacitacionIdProfesional, BigInteger capacitacionIdProfesional1, BigInteger idCliente, BigInteger idSolicitudes) {
        this.asistenciaPK = asistenciaPK;
        this.presentes = presentes;
        this.tcapacitacion = tcapacitacion;
        this.capacitacionIdProfesional = capacitacionIdProfesional;
        this.capacitacionIdProfesional1 = capacitacionIdProfesional1;
        this.idCliente = idCliente;
        this.idSolicitudes = idSolicitudes;
    }

    public Asistencia(BigInteger idAsistencia, BigInteger capacitacionIdCap, BigInteger capExtraIdSolicitudes, BigInteger capExtraContIdContrato, BigInteger capExtraContCliIdCliente, BigInteger capExtraContUsIdUsuario, BigInteger capacitacionIdVisita, BigInteger capacitacionIdProfesional3, BigInteger capacitacionIdProfesional12) {
        this.asistenciaPK = new AsistenciaPK(idAsistencia, capacitacionIdCap, capExtraIdSolicitudes, capExtraContIdContrato, capExtraContCliIdCliente, capExtraContUsIdUsuario, capacitacionIdVisita, capacitacionIdProfesional3, capacitacionIdProfesional12);
    }

    public AsistenciaPK getAsistenciaPK() {
        return asistenciaPK;
    }

    public void setAsistenciaPK(AsistenciaPK asistenciaPK) {
        this.asistenciaPK = asistenciaPK;
    }

    public BigInteger getPresentes() {
        return presentes;
    }

    public void setPresentes(BigInteger presentes) {
        this.presentes = presentes;
    }

    public BigInteger getTcapacitacion() {
        return tcapacitacion;
    }

    public void setTcapacitacion(BigInteger tcapacitacion) {
        this.tcapacitacion = tcapacitacion;
    }

    public BigInteger getCapacitacionIdProfesional() {
        return capacitacionIdProfesional;
    }

    public void setCapacitacionIdProfesional(BigInteger capacitacionIdProfesional) {
        this.capacitacionIdProfesional = capacitacionIdProfesional;
    }

    public BigInteger getCapacitacionIdProfesional1() {
        return capacitacionIdProfesional1;
    }

    public void setCapacitacionIdProfesional1(BigInteger capacitacionIdProfesional1) {
        this.capacitacionIdProfesional1 = capacitacionIdProfesional1;
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

    public Capacitacion getCapacitacion() {
        return capacitacion;
    }

    public void setCapacitacion(Capacitacion capacitacion) {
        this.capacitacion = capacitacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (asistenciaPK != null ? asistenciaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Asistencia)) {
            return false;
        }
        Asistencia other = (Asistencia) object;
        if ((this.asistenciaPK == null && other.asistenciaPK != null) || (this.asistenciaPK != null && !this.asistenciaPK.equals(other.asistenciaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Asistencia[ asistenciaPK=" + asistenciaPK + " ]";
    }
    
}
