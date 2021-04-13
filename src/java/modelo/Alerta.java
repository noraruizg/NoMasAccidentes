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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author norar
 */
@Entity
@Table(name = "ALERTA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Alerta.findAll", query = "SELECT a FROM Alerta a")
    , @NamedQuery(name = "Alerta.findByIdAlerta", query = "SELECT a FROM Alerta a WHERE a.alertaPK.idAlerta = :idAlerta")
    , @NamedQuery(name = "Alerta.findByFecha", query = "SELECT a FROM Alerta a WHERE a.fecha = :fecha")
    , @NamedQuery(name = "Alerta.findByHora", query = "SELECT a FROM Alerta a WHERE a.hora = :hora")
    , @NamedQuery(name = "Alerta.findByVisitaIdVisita", query = "SELECT a FROM Alerta a WHERE a.alertaPK.visitaIdVisita = :visitaIdVisita")
    , @NamedQuery(name = "Alerta.findByVisitaIdProfesional2", query = "SELECT a FROM Alerta a WHERE a.alertaPK.visitaIdProfesional2 = :visitaIdProfesional2")
    , @NamedQuery(name = "Alerta.findByVisitaIdProfesional1", query = "SELECT a FROM Alerta a WHERE a.alertaPK.visitaIdProfesional1 = :visitaIdProfesional1")})
public class Alerta implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AlertaPK alertaPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "HORA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date hora;
    @JoinColumns({
        @JoinColumn(name = "VISITA_ID_VISITA", referencedColumnName = "ID_VISITA", insertable = false, updatable = false)
        , @JoinColumn(name = "VISITA_ID_PROFESIONAL2", referencedColumnName = "ID_PROFESIONAL3", insertable = false, updatable = false)
        , @JoinColumn(name = "VISITA_ID_PROFESIONAL1", referencedColumnName = "ID_PROFESIONAL1", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Visita visita;

    public Alerta() {
    }

    public Alerta(AlertaPK alertaPK) {
        this.alertaPK = alertaPK;
    }

    public Alerta(AlertaPK alertaPK, Date fecha, Date hora) {
        this.alertaPK = alertaPK;
        this.fecha = fecha;
        this.hora = hora;
    }

    public Alerta(BigInteger idAlerta, BigInteger visitaIdVisita, BigInteger visitaIdProfesional2, BigInteger visitaIdProfesional1) {
        this.alertaPK = new AlertaPK(idAlerta, visitaIdVisita, visitaIdProfesional2, visitaIdProfesional1);
    }

    public AlertaPK getAlertaPK() {
        return alertaPK;
    }

    public void setAlertaPK(AlertaPK alertaPK) {
        this.alertaPK = alertaPK;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public Visita getVisita() {
        return visita;
    }

    public void setVisita(Visita visita) {
        this.visita = visita;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (alertaPK != null ? alertaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alerta)) {
            return false;
        }
        Alerta other = (Alerta) object;
        if ((this.alertaPK == null && other.alertaPK != null) || (this.alertaPK != null && !this.alertaPK.equals(other.alertaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Alerta[ alertaPK=" + alertaPK + " ]";
    }
    
}
