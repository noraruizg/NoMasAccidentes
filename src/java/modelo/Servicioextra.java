/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "SERVICIOEXTRA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Servicioextra.findAll", query = "SELECT s FROM Servicioextra s")
    , @NamedQuery(name = "Servicioextra.findByIdExtra", query = "SELECT s FROM Servicioextra s WHERE s.idExtra = :idExtra")
    , @NamedQuery(name = "Servicioextra.findByDescripcionextra", query = "SELECT s FROM Servicioextra s WHERE s.descripcionextra = :descripcionextra")
    , @NamedQuery(name = "Servicioextra.findByFechaextra", query = "SELECT s FROM Servicioextra s WHERE s.fechaextra = :fechaextra")
    , @NamedQuery(name = "Servicioextra.findByCostoextra", query = "SELECT s FROM Servicioextra s WHERE s.costoextra = :costoextra")})
public class Servicioextra implements Serializable {

    @JoinColumns({
        @JoinColumn(name = "CONTRATO_ID_CONTRATO", referencedColumnName = "ID_CONTRATO")
        , @JoinColumn(name = "CONTRATO_CLIENTE_ID_CLIENTE", referencedColumnName = "CLIENTE_ID_CLIENTE")})
    @ManyToOne
    private Contrato contrato;

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_EXTRA")
    private BigDecimal idExtra;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "DESCRIPCIONEXTRA")
    private String descripcionextra;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHAEXTRA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaextra;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COSTOEXTRA")
    private BigInteger costoextra;
    @JoinColumn(name = "TIPOEXTRA_IDTIPOEXTRA", referencedColumnName = "IDTIPOEXTRA")
    @ManyToOne
    private Tipoextra tipoextraIdtipoextra;

    public Servicioextra() {
    }

    public Servicioextra(BigDecimal idExtra) {
        this.idExtra = idExtra;
    }

    public Servicioextra(BigDecimal idExtra, String descripcionextra, Date fechaextra, BigInteger costoextra) {
        this.idExtra = idExtra;
        this.descripcionextra = descripcionextra;
        this.fechaextra = fechaextra;
        this.costoextra = costoextra;
    }

    public BigDecimal getIdExtra() {
        return idExtra;
    }

    public void setIdExtra(BigDecimal idExtra) {
        this.idExtra = idExtra;
    }

    public String getDescripcionextra() {
        return descripcionextra;
    }

    public void setDescripcionextra(String descripcionextra) {
        this.descripcionextra = descripcionextra;
    }

    public Date getFechaextra() {
        return fechaextra;
    }

    public void setFechaextra(Date fechaextra) {
        this.fechaextra = fechaextra;
    }

    public BigInteger getCostoextra() {
        return costoextra;
    }

    public void setCostoextra(BigInteger costoextra) {
        this.costoextra = costoextra;
    }

    public Tipoextra getTipoextraIdtipoextra() {
        return tipoextraIdtipoextra;
    }

    public void setTipoextraIdtipoextra(Tipoextra tipoextraIdtipoextra) {
        this.tipoextraIdtipoextra = tipoextraIdtipoextra;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idExtra != null ? idExtra.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Servicioextra)) {
            return false;
        }
        Servicioextra other = (Servicioextra) object;
        if ((this.idExtra == null && other.idExtra != null) || (this.idExtra != null && !this.idExtra.equals(other.idExtra))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Servicioextra[ idExtra=" + idExtra + " ]";
    }

    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }
    
}
