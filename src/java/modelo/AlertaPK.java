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
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author norar
 */
@Embeddable
public class AlertaPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_ALERTA")
    private BigInteger idAlerta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VISITA_ID_VISITA")
    private BigInteger visitaIdVisita;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VISITA_ID_PROFESIONAL2")
    private BigInteger visitaIdProfesional2;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VISITA_ID_PROFESIONAL1")
    private BigInteger visitaIdProfesional1;

    public AlertaPK() {
    }

    public AlertaPK(BigInteger idAlerta, BigInteger visitaIdVisita, BigInteger visitaIdProfesional2, BigInteger visitaIdProfesional1) {
        this.idAlerta = idAlerta;
        this.visitaIdVisita = visitaIdVisita;
        this.visitaIdProfesional2 = visitaIdProfesional2;
        this.visitaIdProfesional1 = visitaIdProfesional1;
    }

    public BigInteger getIdAlerta() {
        return idAlerta;
    }

    public void setIdAlerta(BigInteger idAlerta) {
        this.idAlerta = idAlerta;
    }

    public BigInteger getVisitaIdVisita() {
        return visitaIdVisita;
    }

    public void setVisitaIdVisita(BigInteger visitaIdVisita) {
        this.visitaIdVisita = visitaIdVisita;
    }

    public BigInteger getVisitaIdProfesional2() {
        return visitaIdProfesional2;
    }

    public void setVisitaIdProfesional2(BigInteger visitaIdProfesional2) {
        this.visitaIdProfesional2 = visitaIdProfesional2;
    }

    public BigInteger getVisitaIdProfesional1() {
        return visitaIdProfesional1;
    }

    public void setVisitaIdProfesional1(BigInteger visitaIdProfesional1) {
        this.visitaIdProfesional1 = visitaIdProfesional1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAlerta != null ? idAlerta.hashCode() : 0);
        hash += (visitaIdVisita != null ? visitaIdVisita.hashCode() : 0);
        hash += (visitaIdProfesional2 != null ? visitaIdProfesional2.hashCode() : 0);
        hash += (visitaIdProfesional1 != null ? visitaIdProfesional1.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AlertaPK)) {
            return false;
        }
        AlertaPK other = (AlertaPK) object;
        if ((this.idAlerta == null && other.idAlerta != null) || (this.idAlerta != null && !this.idAlerta.equals(other.idAlerta))) {
            return false;
        }
        if ((this.visitaIdVisita == null && other.visitaIdVisita != null) || (this.visitaIdVisita != null && !this.visitaIdVisita.equals(other.visitaIdVisita))) {
            return false;
        }
        if ((this.visitaIdProfesional2 == null && other.visitaIdProfesional2 != null) || (this.visitaIdProfesional2 != null && !this.visitaIdProfesional2.equals(other.visitaIdProfesional2))) {
            return false;
        }
        if ((this.visitaIdProfesional1 == null && other.visitaIdProfesional1 != null) || (this.visitaIdProfesional1 != null && !this.visitaIdProfesional1.equals(other.visitaIdProfesional1))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.AlertaPK[ idAlerta=" + idAlerta + ", visitaIdVisita=" + visitaIdVisita + ", visitaIdProfesional2=" + visitaIdProfesional2 + ", visitaIdProfesional1=" + visitaIdProfesional1 + " ]";
    }
    
}
