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
public class ExtraPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_SOLICITUDES")
    private BigInteger idSolicitudes;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CONTRATO_ID_CONTRATO")
    private BigInteger contratoIdContrato;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CONTRATO_CLIENTE_ID_CLIENTE")
    private BigInteger contratoClienteIdCliente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CONTRATO_CLI_US_ID_USUARIO")
    private BigInteger contratoCliUsIdUsuario;

    public ExtraPK() {
    }

    public ExtraPK(BigInteger idSolicitudes, BigInteger contratoIdContrato, BigInteger contratoClienteIdCliente, BigInteger contratoCliUsIdUsuario) {
        this.idSolicitudes = idSolicitudes;
        this.contratoIdContrato = contratoIdContrato;
        this.contratoClienteIdCliente = contratoClienteIdCliente;
        this.contratoCliUsIdUsuario = contratoCliUsIdUsuario;
    }

    public BigInteger getIdSolicitudes() {
        return idSolicitudes;
    }

    public void setIdSolicitudes(BigInteger idSolicitudes) {
        this.idSolicitudes = idSolicitudes;
    }

    public BigInteger getContratoIdContrato() {
        return contratoIdContrato;
    }

    public void setContratoIdContrato(BigInteger contratoIdContrato) {
        this.contratoIdContrato = contratoIdContrato;
    }

    public BigInteger getContratoClienteIdCliente() {
        return contratoClienteIdCliente;
    }

    public void setContratoClienteIdCliente(BigInteger contratoClienteIdCliente) {
        this.contratoClienteIdCliente = contratoClienteIdCliente;
    }

    public BigInteger getContratoCliUsIdUsuario() {
        return contratoCliUsIdUsuario;
    }

    public void setContratoCliUsIdUsuario(BigInteger contratoCliUsIdUsuario) {
        this.contratoCliUsIdUsuario = contratoCliUsIdUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSolicitudes != null ? idSolicitudes.hashCode() : 0);
        hash += (contratoIdContrato != null ? contratoIdContrato.hashCode() : 0);
        hash += (contratoClienteIdCliente != null ? contratoClienteIdCliente.hashCode() : 0);
        hash += (contratoCliUsIdUsuario != null ? contratoCliUsIdUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ExtraPK)) {
            return false;
        }
        ExtraPK other = (ExtraPK) object;
        if ((this.idSolicitudes == null && other.idSolicitudes != null) || (this.idSolicitudes != null && !this.idSolicitudes.equals(other.idSolicitudes))) {
            return false;
        }
        if ((this.contratoIdContrato == null && other.contratoIdContrato != null) || (this.contratoIdContrato != null && !this.contratoIdContrato.equals(other.contratoIdContrato))) {
            return false;
        }
        if ((this.contratoClienteIdCliente == null && other.contratoClienteIdCliente != null) || (this.contratoClienteIdCliente != null && !this.contratoClienteIdCliente.equals(other.contratoClienteIdCliente))) {
            return false;
        }
        if ((this.contratoCliUsIdUsuario == null && other.contratoCliUsIdUsuario != null) || (this.contratoCliUsIdUsuario != null && !this.contratoCliUsIdUsuario.equals(other.contratoCliUsIdUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.ExtraPK[ idSolicitudes=" + idSolicitudes + ", contratoIdContrato=" + contratoIdContrato + ", contratoClienteIdCliente=" + contratoClienteIdCliente + ", contratoCliUsIdUsuario=" + contratoCliUsIdUsuario + " ]";
    }
    
}
