/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author norar
 */
@Entity
@Table(name = "RELATION_13")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Relation13.findAll", query = "SELECT r FROM Relation13 r")
    , @NamedQuery(name = "Relation13.findByProfesionalIdProfesional", query = "SELECT r FROM Relation13 r WHERE r.relation13PK.profesionalIdProfesional = :profesionalIdProfesional")
    , @NamedQuery(name = "Relation13.findByServicioIdServicio", query = "SELECT r FROM Relation13 r WHERE r.relation13PK.servicioIdServicio = :servicioIdServicio")
    , @NamedQuery(name = "Relation13.findByServicioIdContrato", query = "SELECT r FROM Relation13 r WHERE r.relation13PK.servicioIdContrato = :servicioIdContrato")
    , @NamedQuery(name = "Relation13.findByServicioIdCliente1", query = "SELECT r FROM Relation13 r WHERE r.relation13PK.servicioIdCliente1 = :servicioIdCliente1")
    , @NamedQuery(name = "Relation13.findByServicioIdUsuario1", query = "SELECT r FROM Relation13 r WHERE r.relation13PK.servicioIdUsuario1 = :servicioIdUsuario1")
    , @NamedQuery(name = "Relation13.findByProfesionalProfesionalId", query = "SELECT r FROM Relation13 r WHERE r.relation13PK.profesionalProfesionalId = :profesionalProfesionalId")})
public class Relation13 implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected Relation13PK relation13PK;
    @JoinColumn(name = "PROFESIONAL_ID_PROFESIONAL", referencedColumnName = "ID_PROFESIONAL", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Profesional profesional;
    @JoinColumn(name = "SERVICIO_ID_SERVICIO", referencedColumnName = "ID_SERVICIO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Servicio servicio;

    public Relation13() {
    }

    public Relation13(Relation13PK relation13PK) {
        this.relation13PK = relation13PK;
    }

    public Relation13(BigInteger profesionalIdProfesional, BigInteger servicioIdServicio, BigInteger servicioIdContrato, BigInteger servicioIdCliente1, BigInteger servicioIdUsuario1, BigInteger profesionalProfesionalId) {
        this.relation13PK = new Relation13PK(profesionalIdProfesional, servicioIdServicio, servicioIdContrato, servicioIdCliente1, servicioIdUsuario1, profesionalProfesionalId);
    }

    public Relation13PK getRelation13PK() {
        return relation13PK;
    }

    public void setRelation13PK(Relation13PK relation13PK) {
        this.relation13PK = relation13PK;
    }

    public Profesional getProfesional() {
        return profesional;
    }

    public void setProfesional(Profesional profesional) {
        this.profesional = profesional;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (relation13PK != null ? relation13PK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Relation13)) {
            return false;
        }
        Relation13 other = (Relation13) object;
        if ((this.relation13PK == null && other.relation13PK != null) || (this.relation13PK != null && !this.relation13PK.equals(other.relation13PK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Relation13[ relation13PK=" + relation13PK + " ]";
    }
    
}
