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
public class DocumentoPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_DOC")
    private BigInteger idDoc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PAGO_ID_PAGO")
    private BigInteger pagoIdPago;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PAGO_ID_CONTRATO")
    private BigInteger pagoIdContrato;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PAGO_ID_CLIENTE")
    private BigInteger pagoIdCliente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PAGO_ID_USUARIO")
    private BigInteger pagoIdUsuario;

    public DocumentoPK() {
    }

    public DocumentoPK(BigInteger idDoc, BigInteger pagoIdPago, BigInteger pagoIdContrato, BigInteger pagoIdCliente, BigInteger pagoIdUsuario) {
        this.idDoc = idDoc;
        this.pagoIdPago = pagoIdPago;
        this.pagoIdContrato = pagoIdContrato;
        this.pagoIdCliente = pagoIdCliente;
        this.pagoIdUsuario = pagoIdUsuario;
    }

    public BigInteger getIdDoc() {
        return idDoc;
    }

    public void setIdDoc(BigInteger idDoc) {
        this.idDoc = idDoc;
    }

    public BigInteger getPagoIdPago() {
        return pagoIdPago;
    }

    public void setPagoIdPago(BigInteger pagoIdPago) {
        this.pagoIdPago = pagoIdPago;
    }

    public BigInteger getPagoIdContrato() {
        return pagoIdContrato;
    }

    public void setPagoIdContrato(BigInteger pagoIdContrato) {
        this.pagoIdContrato = pagoIdContrato;
    }

    public BigInteger getPagoIdCliente() {
        return pagoIdCliente;
    }

    public void setPagoIdCliente(BigInteger pagoIdCliente) {
        this.pagoIdCliente = pagoIdCliente;
    }

    public BigInteger getPagoIdUsuario() {
        return pagoIdUsuario;
    }

    public void setPagoIdUsuario(BigInteger pagoIdUsuario) {
        this.pagoIdUsuario = pagoIdUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDoc != null ? idDoc.hashCode() : 0);
        hash += (pagoIdPago != null ? pagoIdPago.hashCode() : 0);
        hash += (pagoIdContrato != null ? pagoIdContrato.hashCode() : 0);
        hash += (pagoIdCliente != null ? pagoIdCliente.hashCode() : 0);
        hash += (pagoIdUsuario != null ? pagoIdUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DocumentoPK)) {
            return false;
        }
        DocumentoPK other = (DocumentoPK) object;
        if ((this.idDoc == null && other.idDoc != null) || (this.idDoc != null && !this.idDoc.equals(other.idDoc))) {
            return false;
        }
        if ((this.pagoIdPago == null && other.pagoIdPago != null) || (this.pagoIdPago != null && !this.pagoIdPago.equals(other.pagoIdPago))) {
            return false;
        }
        if ((this.pagoIdContrato == null && other.pagoIdContrato != null) || (this.pagoIdContrato != null && !this.pagoIdContrato.equals(other.pagoIdContrato))) {
            return false;
        }
        if ((this.pagoIdCliente == null && other.pagoIdCliente != null) || (this.pagoIdCliente != null && !this.pagoIdCliente.equals(other.pagoIdCliente))) {
            return false;
        }
        if ((this.pagoIdUsuario == null && other.pagoIdUsuario != null) || (this.pagoIdUsuario != null && !this.pagoIdUsuario.equals(other.pagoIdUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.DocumentoPK[ idDoc=" + idDoc + ", pagoIdPago=" + pagoIdPago + ", pagoIdContrato=" + pagoIdContrato + ", pagoIdCliente=" + pagoIdCliente + ", pagoIdUsuario=" + pagoIdUsuario + " ]";
    }
    
}
