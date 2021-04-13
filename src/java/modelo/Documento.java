/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author norar
 */
@Entity
@Table(name = "DOCUMENTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Documento.findAll", query = "SELECT d FROM Documento d")
    , @NamedQuery(name = "Documento.findByIdDoc", query = "SELECT d FROM Documento d WHERE d.documentoPK.idDoc = :idDoc")
    , @NamedQuery(name = "Documento.findByTipodocumento", query = "SELECT d FROM Documento d WHERE d.tipodocumento = :tipodocumento")
    , @NamedQuery(name = "Documento.findByFechadocumento", query = "SELECT d FROM Documento d WHERE d.fechadocumento = :fechadocumento")
    , @NamedQuery(name = "Documento.findByRut", query = "SELECT d FROM Documento d WHERE d.rut = :rut")
    , @NamedQuery(name = "Documento.findByNombre", query = "SELECT d FROM Documento d WHERE d.nombre = :nombre")
    , @NamedQuery(name = "Documento.findByValorneto", query = "SELECT d FROM Documento d WHERE d.valorneto = :valorneto")
    , @NamedQuery(name = "Documento.findByIva", query = "SELECT d FROM Documento d WHERE d.iva = :iva")
    , @NamedQuery(name = "Documento.findByTotal", query = "SELECT d FROM Documento d WHERE d.total = :total")
    , @NamedQuery(name = "Documento.findByPagoIdPago", query = "SELECT d FROM Documento d WHERE d.documentoPK.pagoIdPago = :pagoIdPago")
    , @NamedQuery(name = "Documento.findByPagoIdContrato", query = "SELECT d FROM Documento d WHERE d.documentoPK.pagoIdContrato = :pagoIdContrato")
    , @NamedQuery(name = "Documento.findByPagoIdCliente", query = "SELECT d FROM Documento d WHERE d.documentoPK.pagoIdCliente = :pagoIdCliente")
    , @NamedQuery(name = "Documento.findByPagoIdUsuario", query = "SELECT d FROM Documento d WHERE d.documentoPK.pagoIdUsuario = :pagoIdUsuario")
    , @NamedQuery(name = "Documento.findByIdCliente", query = "SELECT d FROM Documento d WHERE d.idCliente = :idCliente")
    , @NamedQuery(name = "Documento.findByIdPago", query = "SELECT d FROM Documento d WHERE d.idPago = :idPago")})
public class Documento implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DocumentoPK documentoPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "TIPODOCUMENTO")
    private String tipodocumento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHADOCUMENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechadocumento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "RUT")
    private String rut;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VALORNETO")
    private BigInteger valorneto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IVA")
    private BigInteger iva;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TOTAL")
    private BigInteger total;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_CLIENTE")
    private BigInteger idCliente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PAGO")
    private BigInteger idPago;
    @JoinColumns({
        @JoinColumn(name = "PAGO_ID_PAGO", referencedColumnName = "ID_PAGO", insertable = false, updatable = false)
        , @JoinColumn(name = "PAGO_ID_CONTRATO", referencedColumnName = "ID_CONTRATO", insertable = false, updatable = false)
        , @JoinColumn(name = "PAGO_ID_CLIENTE", referencedColumnName = "ID_CLIENTE", insertable = false, updatable = false)
        , @JoinColumn(name = "PAGO_ID_USUARIO", referencedColumnName = "ID_USUARIO", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Pago pago;

    public Documento() {
    }

    public Documento(DocumentoPK documentoPK) {
        this.documentoPK = documentoPK;
    }

    public Documento(DocumentoPK documentoPK, String tipodocumento, Date fechadocumento, String rut, String nombre, BigInteger valorneto, BigInteger iva, BigInteger total, BigInteger idCliente, BigInteger idPago) {
        this.documentoPK = documentoPK;
        this.tipodocumento = tipodocumento;
        this.fechadocumento = fechadocumento;
        this.rut = rut;
        this.nombre = nombre;
        this.valorneto = valorneto;
        this.iva = iva;
        this.total = total;
        this.idCliente = idCliente;
        this.idPago = idPago;
    }

    public Documento(BigInteger idDoc, BigInteger pagoIdPago, BigInteger pagoIdContrato, BigInteger pagoIdCliente, BigInteger pagoIdUsuario) {
        this.documentoPK = new DocumentoPK(idDoc, pagoIdPago, pagoIdContrato, pagoIdCliente, pagoIdUsuario);
    }

    public DocumentoPK getDocumentoPK() {
        return documentoPK;
    }

    public void setDocumentoPK(DocumentoPK documentoPK) {
        this.documentoPK = documentoPK;
    }

    public String getTipodocumento() {
        return tipodocumento;
    }

    public void setTipodocumento(String tipodocumento) {
        this.tipodocumento = tipodocumento;
    }

    public Date getFechadocumento() {
        return fechadocumento;
    }

    public void setFechadocumento(Date fechadocumento) {
        this.fechadocumento = fechadocumento;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigInteger getValorneto() {
        return valorneto;
    }

    public void setValorneto(BigInteger valorneto) {
        this.valorneto = valorneto;
    }

    public BigInteger getIva() {
        return iva;
    }

    public void setIva(BigInteger iva) {
        this.iva = iva;
    }

    public BigInteger getTotal() {
        return total;
    }

    public void setTotal(BigInteger total) {
        this.total = total;
    }

    public BigInteger getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(BigInteger idCliente) {
        this.idCliente = idCliente;
    }

    public BigInteger getIdPago() {
        return idPago;
    }

    public void setIdPago(BigInteger idPago) {
        this.idPago = idPago;
    }

    public Pago getPago() {
        return pago;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (documentoPK != null ? documentoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Documento)) {
            return false;
        }
        Documento other = (Documento) object;
        if ((this.documentoPK == null && other.documentoPK != null) || (this.documentoPK != null && !this.documentoPK.equals(other.documentoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Documento[ documentoPK=" + documentoPK + " ]";
    }
    
}
