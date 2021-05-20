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
public class ContratoPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_CONTRATO")
    private BigInteger idContrato;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CLIENTE_ID_CLIENTE")
    private BigInteger clienteIdCliente;

    public ContratoPK() {
    }

    public ContratoPK(BigInteger idContrato, BigInteger clienteIdCliente) {
        this.idContrato = idContrato;
        this.clienteIdCliente = clienteIdCliente;
    }

    public BigInteger getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(BigInteger idContrato) {
        this.idContrato = idContrato;
    }

    public BigInteger getClienteIdCliente() {
        return clienteIdCliente;
    }

    public void setClienteIdCliente(BigInteger clienteIdCliente) {
        this.clienteIdCliente = clienteIdCliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idContrato != null ? idContrato.hashCode() : 0);
        hash += (clienteIdCliente != null ? clienteIdCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ContratoPK)) {
            return false;
        }
        ContratoPK other = (ContratoPK) object;
        if ((this.idContrato == null && other.idContrato != null) || (this.idContrato != null && !this.idContrato.equals(other.idContrato))) {
            return false;
        }
        if ((this.clienteIdCliente == null && other.clienteIdCliente != null) || (this.clienteIdCliente != null && !this.clienteIdCliente.equals(other.clienteIdCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.ContratoPK[ idContrato=" + idContrato + ", clienteIdCliente=" + clienteIdCliente + " ]";
    }
    
}
