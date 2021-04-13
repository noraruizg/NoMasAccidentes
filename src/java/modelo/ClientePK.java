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
public class ClientePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_CLIENTE")
    private BigInteger idCliente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "USUARIO_ID_USUARIO")
    private BigInteger usuarioIdUsuario;

    public ClientePK() {
    }

    public ClientePK(BigInteger idCliente, BigInteger usuarioIdUsuario) {
        this.idCliente = idCliente;
        this.usuarioIdUsuario = usuarioIdUsuario;
    }

    public BigInteger getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(BigInteger idCliente) {
        this.idCliente = idCliente;
    }

    public BigInteger getUsuarioIdUsuario() {
        return usuarioIdUsuario;
    }

    public void setUsuarioIdUsuario(BigInteger usuarioIdUsuario) {
        this.usuarioIdUsuario = usuarioIdUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCliente != null ? idCliente.hashCode() : 0);
        hash += (usuarioIdUsuario != null ? usuarioIdUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClientePK)) {
            return false;
        }
        ClientePK other = (ClientePK) object;
        if ((this.idCliente == null && other.idCliente != null) || (this.idCliente != null && !this.idCliente.equals(other.idCliente))) {
            return false;
        }
        if ((this.usuarioIdUsuario == null && other.usuarioIdUsuario != null) || (this.usuarioIdUsuario != null && !this.usuarioIdUsuario.equals(other.usuarioIdUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.ClientePK[ idCliente=" + idCliente + ", usuarioIdUsuario=" + usuarioIdUsuario + " ]";
    }
    
}
