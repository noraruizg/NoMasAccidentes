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
@Table(name = "CHECKLIST")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Checklist.findAll", query = "SELECT c FROM Checklist c")
    , @NamedQuery(name = "Checklist.findByIdCheck", query = "SELECT c FROM Checklist c WHERE c.checklistPK.idCheck = :idCheck")
    , @NamedQuery(name = "Checklist.findByDetalle", query = "SELECT c FROM Checklist c WHERE c.detalle = :detalle")
    , @NamedQuery(name = "Checklist.findByMejora", query = "SELECT c FROM Checklist c WHERE c.mejora = :mejora")
    , @NamedQuery(name = "Checklist.findByIdProfesional", query = "SELECT c FROM Checklist c WHERE c.checklistPK.idProfesional = :idProfesional")
    , @NamedQuery(name = "Checklist.findByProfesionalProfesionalId", query = "SELECT c FROM Checklist c WHERE c.profesionalProfesionalId = :profesionalProfesionalId")})
public class Checklist implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ChecklistPK checklistPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "DETALLE")
    private String detalle;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "MEJORA")
    private String mejora;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PROFESIONAL_PROFESIONAL_ID")
    private BigInteger profesionalProfesionalId;
    @JoinColumn(name = "PROFESIONAL_ID_PROFESIONAL", referencedColumnName = "ID_PROFESIONAL")
    @ManyToOne(optional = false)
    private Profesional profesionalIdProfesional;

    public Checklist() {
    }

    public Checklist(ChecklistPK checklistPK) {
        this.checklistPK = checklistPK;
    }

    public Checklist(ChecklistPK checklistPK, String detalle, String mejora, BigInteger profesionalProfesionalId) {
        this.checklistPK = checklistPK;
        this.detalle = detalle;
        this.mejora = mejora;
        this.profesionalProfesionalId = profesionalProfesionalId;
    }

    public Checklist(BigInteger idCheck, BigInteger idProfesional) {
        this.checklistPK = new ChecklistPK(idCheck, idProfesional);
    }

    public ChecklistPK getChecklistPK() {
        return checklistPK;
    }

    public void setChecklistPK(ChecklistPK checklistPK) {
        this.checklistPK = checklistPK;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getMejora() {
        return mejora;
    }

    public void setMejora(String mejora) {
        this.mejora = mejora;
    }

    public BigInteger getProfesionalProfesionalId() {
        return profesionalProfesionalId;
    }

    public void setProfesionalProfesionalId(BigInteger profesionalProfesionalId) {
        this.profesionalProfesionalId = profesionalProfesionalId;
    }

    public Profesional getProfesionalIdProfesional() {
        return profesionalIdProfesional;
    }

    public void setProfesionalIdProfesional(Profesional profesionalIdProfesional) {
        this.profesionalIdProfesional = profesionalIdProfesional;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (checklistPK != null ? checklistPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Checklist)) {
            return false;
        }
        Checklist other = (Checklist) object;
        if ((this.checklistPK == null && other.checklistPK != null) || (this.checklistPK != null && !this.checklistPK.equals(other.checklistPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Checklist[ checklistPK=" + checklistPK + " ]";
    }
    
}
