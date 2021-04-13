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
public class CapacitacionPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_CAP")
    private BigInteger idCap;
    @Basic(optional = false)
    @NotNull
    @Column(name = "EXTRA_ID_SOLICITUDES")
    private BigInteger extraIdSolicitudes;
    @Basic(optional = false)
    @NotNull
    @Column(name = "EXTRA_CONTRATO_ID_CONTRATO")
    private BigInteger extraContratoIdContrato;
    @Basic(optional = false)
    @NotNull
    @Column(name = "EXTRA_CONT_CLIENTE_ID_CLIENTE")
    private BigInteger extraContClienteIdCliente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "EXTRA_CONT_CLI_US_ID_USUARIO")
    private BigInteger extraContCliUsIdUsuario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_VISITA")
    private BigInteger idVisita;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PROFESIONAL2")
    private BigInteger idProfesional2;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PROFESIONAL11")
    private BigInteger idProfesional11;

    public CapacitacionPK() {
    }

    public CapacitacionPK(BigInteger idCap, BigInteger extraIdSolicitudes, BigInteger extraContratoIdContrato, BigInteger extraContClienteIdCliente, BigInteger extraContCliUsIdUsuario, BigInteger idVisita, BigInteger idProfesional2, BigInteger idProfesional11) {
        this.idCap = idCap;
        this.extraIdSolicitudes = extraIdSolicitudes;
        this.extraContratoIdContrato = extraContratoIdContrato;
        this.extraContClienteIdCliente = extraContClienteIdCliente;
        this.extraContCliUsIdUsuario = extraContCliUsIdUsuario;
        this.idVisita = idVisita;
        this.idProfesional2 = idProfesional2;
        this.idProfesional11 = idProfesional11;
    }

    public BigInteger getIdCap() {
        return idCap;
    }

    public void setIdCap(BigInteger idCap) {
        this.idCap = idCap;
    }

    public BigInteger getExtraIdSolicitudes() {
        return extraIdSolicitudes;
    }

    public void setExtraIdSolicitudes(BigInteger extraIdSolicitudes) {
        this.extraIdSolicitudes = extraIdSolicitudes;
    }

    public BigInteger getExtraContratoIdContrato() {
        return extraContratoIdContrato;
    }

    public void setExtraContratoIdContrato(BigInteger extraContratoIdContrato) {
        this.extraContratoIdContrato = extraContratoIdContrato;
    }

    public BigInteger getExtraContClienteIdCliente() {
        return extraContClienteIdCliente;
    }

    public void setExtraContClienteIdCliente(BigInteger extraContClienteIdCliente) {
        this.extraContClienteIdCliente = extraContClienteIdCliente;
    }

    public BigInteger getExtraContCliUsIdUsuario() {
        return extraContCliUsIdUsuario;
    }

    public void setExtraContCliUsIdUsuario(BigInteger extraContCliUsIdUsuario) {
        this.extraContCliUsIdUsuario = extraContCliUsIdUsuario;
    }

    public BigInteger getIdVisita() {
        return idVisita;
    }

    public void setIdVisita(BigInteger idVisita) {
        this.idVisita = idVisita;
    }

    public BigInteger getIdProfesional2() {
        return idProfesional2;
    }

    public void setIdProfesional2(BigInteger idProfesional2) {
        this.idProfesional2 = idProfesional2;
    }

    public BigInteger getIdProfesional11() {
        return idProfesional11;
    }

    public void setIdProfesional11(BigInteger idProfesional11) {
        this.idProfesional11 = idProfesional11;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCap != null ? idCap.hashCode() : 0);
        hash += (extraIdSolicitudes != null ? extraIdSolicitudes.hashCode() : 0);
        hash += (extraContratoIdContrato != null ? extraContratoIdContrato.hashCode() : 0);
        hash += (extraContClienteIdCliente != null ? extraContClienteIdCliente.hashCode() : 0);
        hash += (extraContCliUsIdUsuario != null ? extraContCliUsIdUsuario.hashCode() : 0);
        hash += (idVisita != null ? idVisita.hashCode() : 0);
        hash += (idProfesional2 != null ? idProfesional2.hashCode() : 0);
        hash += (idProfesional11 != null ? idProfesional11.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CapacitacionPK)) {
            return false;
        }
        CapacitacionPK other = (CapacitacionPK) object;
        if ((this.idCap == null && other.idCap != null) || (this.idCap != null && !this.idCap.equals(other.idCap))) {
            return false;
        }
        if ((this.extraIdSolicitudes == null && other.extraIdSolicitudes != null) || (this.extraIdSolicitudes != null && !this.extraIdSolicitudes.equals(other.extraIdSolicitudes))) {
            return false;
        }
        if ((this.extraContratoIdContrato == null && other.extraContratoIdContrato != null) || (this.extraContratoIdContrato != null && !this.extraContratoIdContrato.equals(other.extraContratoIdContrato))) {
            return false;
        }
        if ((this.extraContClienteIdCliente == null && other.extraContClienteIdCliente != null) || (this.extraContClienteIdCliente != null && !this.extraContClienteIdCliente.equals(other.extraContClienteIdCliente))) {
            return false;
        }
        if ((this.extraContCliUsIdUsuario == null && other.extraContCliUsIdUsuario != null) || (this.extraContCliUsIdUsuario != null && !this.extraContCliUsIdUsuario.equals(other.extraContCliUsIdUsuario))) {
            return false;
        }
        if ((this.idVisita == null && other.idVisita != null) || (this.idVisita != null && !this.idVisita.equals(other.idVisita))) {
            return false;
        }
        if ((this.idProfesional2 == null && other.idProfesional2 != null) || (this.idProfesional2 != null && !this.idProfesional2.equals(other.idProfesional2))) {
            return false;
        }
        if ((this.idProfesional11 == null && other.idProfesional11 != null) || (this.idProfesional11 != null && !this.idProfesional11.equals(other.idProfesional11))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.CapacitacionPK[ idCap=" + idCap + ", extraIdSolicitudes=" + extraIdSolicitudes + ", extraContratoIdContrato=" + extraContratoIdContrato + ", extraContClienteIdCliente=" + extraContClienteIdCliente + ", extraContCliUsIdUsuario=" + extraContCliUsIdUsuario + ", idVisita=" + idVisita + ", idProfesional2=" + idProfesional2 + ", idProfesional11=" + idProfesional11 + " ]";
    }
    
}
