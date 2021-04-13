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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author norar
 */
@Entity
@Table(name = "R_VISITA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RVisita.findAll", query = "SELECT r FROM RVisita r")
    , @NamedQuery(name = "RVisita.findByIdRvisitas", query = "SELECT r FROM RVisita r WHERE r.rVisitaPK.idRvisitas = :idRvisitas")
    , @NamedQuery(name = "RVisita.findByVisitaIdVisita", query = "SELECT r FROM RVisita r WHERE r.rVisitaPK.visitaIdVisita = :visitaIdVisita")
    , @NamedQuery(name = "RVisita.findByVisitaIdProfesional", query = "SELECT r FROM RVisita r WHERE r.visitaIdProfesional = :visitaIdProfesional")
    , @NamedQuery(name = "RVisita.findByVisitaProfIdProfesional", query = "SELECT r FROM RVisita r WHERE r.visitaProfIdProfesional = :visitaProfIdProfesional")
    , @NamedQuery(name = "RVisita.findByMejoras", query = "SELECT r FROM RVisita r WHERE r.mejoras = :mejoras")
    , @NamedQuery(name = "RVisita.findByVisitaIdProfesional2", query = "SELECT r FROM RVisita r WHERE r.rVisitaPK.visitaIdProfesional2 = :visitaIdProfesional2")
    , @NamedQuery(name = "RVisita.findByVisitaIdProfesional1", query = "SELECT r FROM RVisita r WHERE r.rVisitaPK.visitaIdProfesional1 = :visitaIdProfesional1")})
public class RVisita implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RVisitaPK rVisitaPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VISITA_ID_PROFESIONAL")
    private BigInteger visitaIdProfesional;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VISITA_PROF_ID_PROFESIONAL")
    private BigInteger visitaProfIdProfesional;
    @Size(max = 100)
    @Column(name = "MEJORAS")
    private String mejoras;
    @JoinColumns({
        @JoinColumn(name = "VISITA_ID_VISITA", referencedColumnName = "ID_VISITA", insertable = false, updatable = false)
        , @JoinColumn(name = "VISITA_ID_PROFESIONAL2", referencedColumnName = "ID_PROFESIONAL3", insertable = false, updatable = false)
        , @JoinColumn(name = "VISITA_ID_PROFESIONAL1", referencedColumnName = "ID_PROFESIONAL1", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Visita visita;

    public RVisita() {
    }

    public RVisita(RVisitaPK rVisitaPK) {
        this.rVisitaPK = rVisitaPK;
    }

    public RVisita(RVisitaPK rVisitaPK, BigInteger visitaIdProfesional, BigInteger visitaProfIdProfesional) {
        this.rVisitaPK = rVisitaPK;
        this.visitaIdProfesional = visitaIdProfesional;
        this.visitaProfIdProfesional = visitaProfIdProfesional;
    }

    public RVisita(BigInteger idRvisitas, BigInteger visitaIdVisita, BigInteger visitaIdProfesional2, BigInteger visitaIdProfesional1) {
        this.rVisitaPK = new RVisitaPK(idRvisitas, visitaIdVisita, visitaIdProfesional2, visitaIdProfesional1);
    }

    public RVisitaPK getRVisitaPK() {
        return rVisitaPK;
    }

    public void setRVisitaPK(RVisitaPK rVisitaPK) {
        this.rVisitaPK = rVisitaPK;
    }

    public BigInteger getVisitaIdProfesional() {
        return visitaIdProfesional;
    }

    public void setVisitaIdProfesional(BigInteger visitaIdProfesional) {
        this.visitaIdProfesional = visitaIdProfesional;
    }

    public BigInteger getVisitaProfIdProfesional() {
        return visitaProfIdProfesional;
    }

    public void setVisitaProfIdProfesional(BigInteger visitaProfIdProfesional) {
        this.visitaProfIdProfesional = visitaProfIdProfesional;
    }

    public String getMejoras() {
        return mejoras;
    }

    public void setMejoras(String mejoras) {
        this.mejoras = mejoras;
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
        hash += (rVisitaPK != null ? rVisitaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RVisita)) {
            return false;
        }
        RVisita other = (RVisita) object;
        if ((this.rVisitaPK == null && other.rVisitaPK != null) || (this.rVisitaPK != null && !this.rVisitaPK.equals(other.rVisitaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.RVisita[ rVisitaPK=" + rVisitaPK + " ]";
    }
    
}
