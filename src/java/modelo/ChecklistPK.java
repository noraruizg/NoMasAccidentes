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
public class ChecklistPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_CHECK")
    private BigInteger idCheck;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PROFESIONAL")
    private BigInteger idProfesional;

    public ChecklistPK() {
    }

    public ChecklistPK(BigInteger idCheck, BigInteger idProfesional) {
        this.idCheck = idCheck;
        this.idProfesional = idProfesional;
    }

    public BigInteger getIdCheck() {
        return idCheck;
    }

    public void setIdCheck(BigInteger idCheck) {
        this.idCheck = idCheck;
    }

    public BigInteger getIdProfesional() {
        return idProfesional;
    }

    public void setIdProfesional(BigInteger idProfesional) {
        this.idProfesional = idProfesional;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCheck != null ? idCheck.hashCode() : 0);
        hash += (idProfesional != null ? idProfesional.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ChecklistPK)) {
            return false;
        }
        ChecklistPK other = (ChecklistPK) object;
        if ((this.idCheck == null && other.idCheck != null) || (this.idCheck != null && !this.idCheck.equals(other.idCheck))) {
            return false;
        }
        if ((this.idProfesional == null && other.idProfesional != null) || (this.idProfesional != null && !this.idProfesional.equals(other.idProfesional))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.ChecklistPK[ idCheck=" + idCheck + ", idProfesional=" + idProfesional + " ]";
    }
    
}
