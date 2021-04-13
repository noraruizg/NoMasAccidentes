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
public class LlamadaPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_LLAMADA")
    private BigInteger idLlamada;
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
    @Column(name = "EXTRA_CONT_CLI_ID_CLIENTE")
    private BigInteger extraContCliIdCliente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "EXTRA_CONT_CLI_US_ID_USUARIO")
    private BigInteger extraContCliUsIdUsuario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SERVICIO_ID_SERVICIO")
    private BigInteger servicioIdServicio;

    public LlamadaPK() {
    }

    public LlamadaPK(BigInteger idLlamada, BigInteger extraIdSolicitudes, BigInteger extraContratoIdContrato, BigInteger extraContCliIdCliente, BigInteger extraContCliUsIdUsuario, BigInteger servicioIdServicio) {
        this.idLlamada = idLlamada;
        this.extraIdSolicitudes = extraIdSolicitudes;
        this.extraContratoIdContrato = extraContratoIdContrato;
        this.extraContCliIdCliente = extraContCliIdCliente;
        this.extraContCliUsIdUsuario = extraContCliUsIdUsuario;
        this.servicioIdServicio = servicioIdServicio;
    }

    public BigInteger getIdLlamada() {
        return idLlamada;
    }

    public void setIdLlamada(BigInteger idLlamada) {
        this.idLlamada = idLlamada;
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

    public BigInteger getExtraContCliIdCliente() {
        return extraContCliIdCliente;
    }

    public void setExtraContCliIdCliente(BigInteger extraContCliIdCliente) {
        this.extraContCliIdCliente = extraContCliIdCliente;
    }

    public BigInteger getExtraContCliUsIdUsuario() {
        return extraContCliUsIdUsuario;
    }

    public void setExtraContCliUsIdUsuario(BigInteger extraContCliUsIdUsuario) {
        this.extraContCliUsIdUsuario = extraContCliUsIdUsuario;
    }

    public BigInteger getServicioIdServicio() {
        return servicioIdServicio;
    }

    public void setServicioIdServicio(BigInteger servicioIdServicio) {
        this.servicioIdServicio = servicioIdServicio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLlamada != null ? idLlamada.hashCode() : 0);
        hash += (extraIdSolicitudes != null ? extraIdSolicitudes.hashCode() : 0);
        hash += (extraContratoIdContrato != null ? extraContratoIdContrato.hashCode() : 0);
        hash += (extraContCliIdCliente != null ? extraContCliIdCliente.hashCode() : 0);
        hash += (extraContCliUsIdUsuario != null ? extraContCliUsIdUsuario.hashCode() : 0);
        hash += (servicioIdServicio != null ? servicioIdServicio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LlamadaPK)) {
            return false;
        }
        LlamadaPK other = (LlamadaPK) object;
        if ((this.idLlamada == null && other.idLlamada != null) || (this.idLlamada != null && !this.idLlamada.equals(other.idLlamada))) {
            return false;
        }
        if ((this.extraIdSolicitudes == null && other.extraIdSolicitudes != null) || (this.extraIdSolicitudes != null && !this.extraIdSolicitudes.equals(other.extraIdSolicitudes))) {
            return false;
        }
        if ((this.extraContratoIdContrato == null && other.extraContratoIdContrato != null) || (this.extraContratoIdContrato != null && !this.extraContratoIdContrato.equals(other.extraContratoIdContrato))) {
            return false;
        }
        if ((this.extraContCliIdCliente == null && other.extraContCliIdCliente != null) || (this.extraContCliIdCliente != null && !this.extraContCliIdCliente.equals(other.extraContCliIdCliente))) {
            return false;
        }
        if ((this.extraContCliUsIdUsuario == null && other.extraContCliUsIdUsuario != null) || (this.extraContCliUsIdUsuario != null && !this.extraContCliUsIdUsuario.equals(other.extraContCliUsIdUsuario))) {
            return false;
        }
        if ((this.servicioIdServicio == null && other.servicioIdServicio != null) || (this.servicioIdServicio != null && !this.servicioIdServicio.equals(other.servicioIdServicio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.LlamadaPK[ idLlamada=" + idLlamada + ", extraIdSolicitudes=" + extraIdSolicitudes + ", extraContratoIdContrato=" + extraContratoIdContrato + ", extraContCliIdCliente=" + extraContCliIdCliente + ", extraContCliUsIdUsuario=" + extraContCliUsIdUsuario + ", servicioIdServicio=" + servicioIdServicio + " ]";
    }
    
}
