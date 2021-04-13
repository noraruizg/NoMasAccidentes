/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author norar
 */
@Entity
@Table(name = "PAGO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pago.findAll", query = "SELECT p FROM Pago p")
    , @NamedQuery(name = "Pago.findByIdPago", query = "SELECT p FROM Pago p WHERE p.pagoPK.idPago = :idPago")
    , @NamedQuery(name = "Pago.findByFechapago", query = "SELECT p FROM Pago p WHERE p.fechapago = :fechapago")
    , @NamedQuery(name = "Pago.findByMonto", query = "SELECT p FROM Pago p WHERE p.monto = :monto")
    , @NamedQuery(name = "Pago.findByIdContrato", query = "SELECT p FROM Pago p WHERE p.pagoPK.idContrato = :idContrato")
    , @NamedQuery(name = "Pago.findByIdCliente", query = "SELECT p FROM Pago p WHERE p.pagoPK.idCliente = :idCliente")
    , @NamedQuery(name = "Pago.findByIdUsuario", query = "SELECT p FROM Pago p WHERE p.pagoPK.idUsuario = :idUsuario")
    , @NamedQuery(name = "Pago.findByTipopago", query = "SELECT p FROM Pago p WHERE p.tipopago = :tipopago")
    , @NamedQuery(name = "Pago.findByIdCliente1", query = "SELECT p FROM Pago p WHERE p.idCliente1 = :idCliente1")})
public class Pago implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PagoPK pagoPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHAPAGO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechapago;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MONTO")
    private BigInteger monto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "TIPOPAGO")
    private String tipopago;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_CLIENTE1")
    private BigInteger idCliente1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pago")
    private Collection<Documento> documentoCollection;
    @JoinColumn(name = "SERVICIO_ID_SERVICIO", referencedColumnName = "ID_SERVICIO")
    @ManyToOne(optional = false)
    private Servicio servicioIdServicio;

    public Pago() {
    }

    public Pago(PagoPK pagoPK) {
        this.pagoPK = pagoPK;
    }

    public Pago(PagoPK pagoPK, Date fechapago, BigInteger monto, String tipopago, BigInteger idCliente1) {
        this.pagoPK = pagoPK;
        this.fechapago = fechapago;
        this.monto = monto;
        this.tipopago = tipopago;
        this.idCliente1 = idCliente1;
    }

    public Pago(BigInteger idPago, BigInteger idContrato, BigInteger idCliente, BigInteger idUsuario) {
        this.pagoPK = new PagoPK(idPago, idContrato, idCliente, idUsuario);
    }

    public PagoPK getPagoPK() {
        return pagoPK;
    }

    public void setPagoPK(PagoPK pagoPK) {
        this.pagoPK = pagoPK;
    }

    public Date getFechapago() {
        return fechapago;
    }

    public void setFechapago(Date fechapago) {
        this.fechapago = fechapago;
    }

    public BigInteger getMonto() {
        return monto;
    }

    public void setMonto(BigInteger monto) {
        this.monto = monto;
    }

    public String getTipopago() {
        return tipopago;
    }

    public void setTipopago(String tipopago) {
        this.tipopago = tipopago;
    }

    public BigInteger getIdCliente1() {
        return idCliente1;
    }

    public void setIdCliente1(BigInteger idCliente1) {
        this.idCliente1 = idCliente1;
    }

    @XmlTransient
    public Collection<Documento> getDocumentoCollection() {
        return documentoCollection;
    }

    public void setDocumentoCollection(Collection<Documento> documentoCollection) {
        this.documentoCollection = documentoCollection;
    }

    public Servicio getServicioIdServicio() {
        return servicioIdServicio;
    }

    public void setServicioIdServicio(Servicio servicioIdServicio) {
        this.servicioIdServicio = servicioIdServicio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pagoPK != null ? pagoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pago)) {
            return false;
        }
        Pago other = (Pago) object;
        if ((this.pagoPK == null && other.pagoPK != null) || (this.pagoPK != null && !this.pagoPK.equals(other.pagoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Pago[ pagoPK=" + pagoPK + " ]";
    }
    
}
