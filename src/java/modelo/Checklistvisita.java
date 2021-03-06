/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
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
@Table(name = "CHECKLISTVISITA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Checklistvisita.findAll", query = "SELECT c FROM Checklistvisita c")
    , @NamedQuery(name = "Checklistvisita.findByIdChecklistvisita", query = "SELECT c FROM Checklistvisita c WHERE c.idChecklistvisita = :idChecklistvisita")
    , @NamedQuery(name = "Checklistvisita.findByFechachecklistvisita", query = "SELECT c FROM Checklistvisita c WHERE c.fechachecklistvisita = :fechachecklistvisita")
    , @NamedQuery(name = "Checklistvisita.findByMejora", query = "SELECT c FROM Checklistvisita c WHERE c.mejora = :mejora")
    , @NamedQuery(name = "Checklistvisita.findByEstadochecklist", query = "SELECT c FROM Checklistvisita c WHERE c.estadochecklist = :estadochecklist")
    , @NamedQuery(name = "Checklistvisita.findByFechamodificacion", query = "SELECT c FROM Checklistvisita c WHERE c.fechamodificacion = :fechamodificacion")
    , @NamedQuery(name = "Checklistvisita.findByIdProfesional", query = "SELECT c FROM Checklistvisita c WHERE c.idProfesional = :idProfesional")})
public class Checklistvisita implements Serializable {

    @JoinColumn(name = "VISITA_ID_VISITA", referencedColumnName = "ID_VISITA")
    @ManyToOne
    private Visita visitaIdVisita;

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_CHECKLISTVISITA")
    private int idChecklistvisita;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHACHECKLISTVISITA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechachecklistvisita;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "MEJORA")
    private String mejora;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTADOCHECKLIST")
    private Character estadochecklist;
    @Column(name = "FECHAMODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechamodificacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PROFESIONAL")
    private int idProfesional;

    public Checklistvisita() {
    }

    public Checklistvisita(int idChecklistvisita) {
        this.idChecklistvisita = idChecklistvisita;
    }

    public Checklistvisita( Date fechachecklistvisita, String mejora, Character estadochecklist, int idProfesional) {
       // this.idChecklistvisita = idChecklistvisita;
        this.fechachecklistvisita = fechachecklistvisita;
        this.mejora = mejora;
        this.estadochecklist = estadochecklist;
        this.idProfesional = idProfesional;
    }

    public int getIdChecklistvisita() {
        return idChecklistvisita;
    }

    public void setIdChecklistvisita(int idChecklistvisita) {
        this.idChecklistvisita = idChecklistvisita;
    }

    public Date getFechachecklistvisita() {
        return fechachecklistvisita;
    }

    public void setFechachecklistvisita(Date fechachecklistvisita) {
        this.fechachecklistvisita = fechachecklistvisita;
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

    public int getIdProfesional() {
        return idProfesional;
    }

    public void setIdProfesional(int idProfesional) {
        this.idProfesional = idProfesional;
    }


    @Override
    public String toString() {
        return "modelo.Checklistvisita[ idChecklistvisita=" + idChecklistvisita + " ]";
    }

    public Visita getVisitaIdVisita() {
        return visitaIdVisita;
    }

    public void setVisitaIdVisita(Visita visitaIdVisita) {
        this.visitaIdVisita = visitaIdVisita;
    }
    
}
