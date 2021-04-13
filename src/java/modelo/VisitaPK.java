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
public class VisitaPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_VISITA")
    private BigInteger idVisita;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PROFESIONAL3")
    private BigInteger idProfesional3;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PROFESIONAL1")
    private BigInteger idProfesional1;

    public VisitaPK() {
    }

    public VisitaPK(BigInteger idVisita, BigInteger idProfesional3, BigInteger idProfesional1) {
        this.idVisita = idVisita;
        this.idProfesional3 = idProfesional3;
        this.idProfesional1 = idProfesional1;
    }

    public BigInteger getIdVisita() {
        return idVisita;
    }

    public void setIdVisita(BigInteger idVisita) {
        this.idVisita = idVisita;
    }

    public BigInteger getIdProfesional3() {
        return idProfesional3;
    }

    public void setIdProfesional3(BigInteger idProfesional3) {
        this.idProfesional3 = idProfesional3;
    }

    public BigInteger getIdProfesional1() {
        return idProfesional1;
    }

    public void setIdProfesional1(BigInteger idProfesional1) {
        this.idProfesional1 = idProfesional1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVisita != null ? idVisita.hashCode() : 0);
        hash += (idProfesional3 != null ? idProfesional3.hashCode() : 0);
        hash += (idProfesional1 != null ? idProfesional1.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VisitaPK)) {
            return false;
        }
        VisitaPK other = (VisitaPK) object;
        if ((this.idVisita == null && other.idVisita != null) || (this.idVisita != null && !this.idVisita.equals(other.idVisita))) {
            return false;
        }
        if ((this.idProfesional3 == null && other.idProfesional3 != null) || (this.idProfesional3 != null && !this.idProfesional3.equals(other.idProfesional3))) {
            return false;
        }
        if ((this.idProfesional1 == null && other.idProfesional1 != null) || (this.idProfesional1 != null && !this.idProfesional1.equals(other.idProfesional1))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.VisitaPK[ idVisita=" + idVisita + ", idProfesional3=" + idProfesional3 + ", idProfesional1=" + idProfesional1 + " ]";
    }
    
}
