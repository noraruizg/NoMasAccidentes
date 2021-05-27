/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
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
    private int idContrato;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CLIENTE_ID_CLIENTE")
    private int clienteIdCliente;

    public ContratoPK() {
    }

    public ContratoPK(int idContrato, int clienteIdCliente) {
        this.idContrato = idContrato;
        this.clienteIdCliente = clienteIdCliente;
    }

    public int getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(int idContrato) {
        this.idContrato = idContrato;
    }

    public int getClienteIdCliente() {
        return clienteIdCliente;
    }

    public void setClienteIdCliente(int clienteIdCliente) {
        this.clienteIdCliente = clienteIdCliente;
    }



    @Override
    public String toString() {
        return "modelo.ContratoPK[ idContrato=" + idContrato + ", clienteIdCliente=" + clienteIdCliente + " ]";
    }
    
}
