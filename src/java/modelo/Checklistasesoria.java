/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "CHECKLISTASESORIA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Checklistasesoria.findAll", query = "SELECT c FROM Checklistasesoria c")
    , @NamedQuery(name = "Checklistasesoria.findByIdChecklistasesoria", query = "SELECT c FROM Checklistasesoria c WHERE c.idChecklistasesoria = :idChecklistasesoria")
    , @NamedQuery(name = "Checklistasesoria.findByFechachecklistasesoria", query = "SELECT c FROM Checklistasesoria c WHERE c.fechachecklistasesoria = :fechachecklistasesoria")
    , @NamedQuery(name = "Checklistasesoria.findByCausanteasesoria", query = "SELECT c FROM Checklistasesoria c WHERE c.causanteasesoria = :causanteasesoria")
    , @NamedQuery(name = "Checklistasesoria.findByMejora", query = "SELECT c FROM Checklistasesoria c WHERE c.mejora = :mejora")
    , @NamedQuery(name = "Checklistasesoria.findByEstadochecklist", query = "SELECT c FROM Checklistasesoria c WHERE c.estadochecklist = :estadochecklist")
    , @NamedQuery(name = "Checklistasesoria.findByFechamodificacion", query = "SELECT c FROM Checklistasesoria c WHERE c.fechamodificacion = :fechamodificacion")})
public class Checklistasesoria implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_CHECKLISTASESORIA")
    private BigDecimal idChecklistasesoria;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHACHECKLISTASESORIA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechachecklistasesoria;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "CAUSANTEASESORIA")
    private String causanteasesoria;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "MEJORA")
    private String mejora;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTADOCHECKLIST")
    private Character estadochecklist;
    @Column(name = "FECHAMODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechamodificacion;
    @JoinColumn(name = "ASESORIA_ID_ASESORIA", referencedColumnName = "ID_ASESORIA")
    @ManyToOne
    private Asesoria asesoriaIdAsesoria;

    public Checklistasesoria() {
    }

    public Checklistasesoria(BigDecimal idChecklistasesoria) {
        this.idChecklistasesoria = idChecklistasesoria;
    }

    public Checklistasesoria(BigDecimal idChecklistasesoria, Date fechachecklistasesoria, String causanteasesoria, String mejora, Character estadochecklist) {
        this.idChecklistasesoria = idChecklistasesoria;
        this.fechachecklistasesoria = fechachecklistasesoria;
        this.causanteasesoria = causanteasesoria;
        this.mejora = mejora;
        this.estadochecklist = estadochecklist;
    }

    public BigDecimal getIdChecklistasesoria() {
        return idChecklistasesoria;
    }

    public void setIdChecklistasesoria(BigDecimal idChecklistasesoria) {
        this.idChecklistasesoria = idChecklistasesoria;
    }

    public Date getFechachecklistasesoria() {
        return fechachecklistasesoria;
    }

    public void setFechachecklistasesoria(Date fechachecklistasesoria) {
        this.fechachecklistasesoria = fechachecklistasesoria;
    }

    public String getCausanteasesoria() {
        return causanteasesoria;
    }

    public void setCausanteasesoria(String causanteasesoria) {
        this.causanteasesoria = causanteasesoria;
    }

    public String getMejora() {
        return mejora;
    }

    public void setMejora(String mejora) {
        this.mejora = mejora;
    }

    public Character getEstadochecklist() {
        return estadochecklist;
    }

    public void setEstadochecklist(Character estadochecklist) {
        this.estadochecklist = estadochecklist;
    }

    public Date getFechamodificacion() {
        return fechamodificacion;
    }

    public void setFechamodificacion(Date fechamodificacion) {
        this.fechamodificacion = fechamodificacion;
    }

    public Asesoria getAsesoriaIdAsesoria() {
        return asesoriaIdAsesoria;
    }

    public void setAsesoriaIdAsesoria(Asesoria asesoriaIdAsesoria) {
        this.asesoriaIdAsesoria = asesoriaIdAsesoria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idChecklistasesoria != null ? idChecklistasesoria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Checklistasesoria)) {
            return false;
        }
        Checklistasesoria other = (Checklistasesoria) object;
        if ((this.idChecklistasesoria == null && other.idChecklistasesoria != null) || (this.idChecklistasesoria != null && !this.idChecklistasesoria.equals(other.idChecklistasesoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Checklistasesoria[ idChecklistasesoria=" + idChecklistasesoria + " ]";
    }
    
}
