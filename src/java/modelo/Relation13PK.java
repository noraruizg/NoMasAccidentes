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
public class Relation13PK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "PROFESIONAL_ID_PROFESIONAL")
    private BigInteger profesionalIdProfesional;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SERVICIO_ID_SERVICIO")
    private BigInteger servicioIdServicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SERVICIO_ID_CONTRATO")
    private BigInteger servicioIdContrato;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SERVICIO_ID_CLIENTE1")
    private BigInteger servicioIdCliente1;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SERVICIO_ID_USUARIO1")
    private BigInteger servicioIdUsuario1;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PROFESIONAL_PROFESIONAL_ID")
    private BigInteger profesionalProfesionalId;

    public Relation13PK() {
    }

    public Relation13PK(BigInteger profesionalIdProfesional, BigInteger servicioIdServicio, BigInteger servicioIdContrato, BigInteger servicioIdCliente1, BigInteger servicioIdUsuario1, BigInteger profesionalProfesionalId) {
        this.profesionalIdProfesional = profesionalIdProfesional;
        this.servicioIdServicio = servicioIdServicio;
        this.servicioIdContrato = servicioIdContrato;
        this.servicioIdCliente1 = servicioIdCliente1;
        this.servicioIdUsuario1 = servicioIdUsuario1;
        this.profesionalProfesionalId = profesionalProfesionalId;
    }

    public BigInteger getProfesionalIdProfesional() {
        return profesionalIdProfesional;
    }

    public void setProfesionalIdProfesional(BigInteger profesionalIdProfesional) {
        this.profesionalIdProfesional = profesionalIdProfesional;
    }

    public BigInteger getServicioIdServicio() {
        return servicioIdServicio;
    }

    public void setServicioIdServicio(BigInteger servicioIdServicio) {
        this.servicioIdServicio = servicioIdServicio;
    }

    public BigInteger getServicioIdContrato() {
        return servicioIdContrato;
    }

    public void setServicioIdContrato(BigInteger servicioIdContrato) {
        this.servicioIdContrato = servicioIdContrato;
    }

    public BigInteger getServicioIdCliente1() {
        return servicioIdCliente1;
    }

    public void setServicioIdCliente1(BigInteger servicioIdCliente1) {
        this.servicioIdCliente1 = servicioIdCliente1;
    }

    public BigInteger getServicioIdUsuario1() {
        return servicioIdUsuario1;
    }

    public void setServicioIdUsuario1(BigInteger servicioIdUsuario1) {
        this.servicioIdUsuario1 = servicioIdUsuario1;
    }

    public BigInteger getProfesionalProfesionalId() {
        return profesionalProfesionalId;
    }

    public void setProfesionalProfesionalId(BigInteger profesionalProfesionalId) {
        this.profesionalProfesionalId = profesionalProfesionalId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (profesionalIdProfesional != null ? profesionalIdProfesional.hashCode() : 0);
        hash += (servicioIdServicio != null ? servicioIdServicio.hashCode() : 0);
        hash += (servicioIdContrato != null ? servicioIdContrato.hashCode() : 0);
        hash += (servicioIdCliente1 != null ? servicioIdCliente1.hashCode() : 0);
        hash += (servicioIdUsuario1 != null ? servicioIdUsuario1.hashCode() : 0);
        hash += (profesionalProfesionalId != null ? profesionalProfesionalId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Relation13PK)) {
            return false;
        }
        Relation13PK other = (Relation13PK) object;
        if ((this.profesionalIdProfesional == null && other.profesionalIdProfesional != null) || (this.profesionalIdProfesional != null && !this.profesionalIdProfesional.equals(other.profesionalIdProfesional))) {
            return false;
        }
        if ((this.servicioIdServicio == null && other.servicioIdServicio != null) || (this.servicioIdServicio != null && !this.servicioIdServicio.equals(other.servicioIdServicio))) {
            return false;
        }
        if ((this.servicioIdContrato == null && other.servicioIdContrato != null) || (this.servicioIdContrato != null && !this.servicioIdContrato.equals(other.servicioIdContrato))) {
            return false;
        }
        if ((this.servicioIdCliente1 == null && other.servicioIdCliente1 != null) || (this.servicioIdCliente1 != null && !this.servicioIdCliente1.equals(other.servicioIdCliente1))) {
            return false;
        }
        if ((this.servicioIdUsuario1 == null && other.servicioIdUsuario1 != null) || (this.servicioIdUsuario1 != null && !this.servicioIdUsuario1.equals(other.servicioIdUsuario1))) {
            return false;
        }
        if ((this.profesionalProfesionalId == null && other.profesionalProfesionalId != null) || (this.profesionalProfesionalId != null && !this.profesionalProfesionalId.equals(other.profesionalProfesionalId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Relation13PK[ profesionalIdProfesional=" + profesionalIdProfesional + ", servicioIdServicio=" + servicioIdServicio + ", servicioIdContrato=" + servicioIdContrato + ", servicioIdCliente1=" + servicioIdCliente1 + ", servicioIdUsuario1=" + servicioIdUsuario1 + ", profesionalProfesionalId=" + profesionalProfesionalId + " ]";
    }
    
}
