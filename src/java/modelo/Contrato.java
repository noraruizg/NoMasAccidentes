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
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author norar
 */
@Entity
@Table(name = "CONTRATO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contrato.findAll", query = "SELECT c FROM Contrato c")
    , @NamedQuery(name = "Contrato.findByIdContrato", query = "SELECT c FROM Contrato c WHERE c.contratoPK.idContrato = :idContrato")
    , @NamedQuery(name = "Contrato.findByFinicio", query = "SELECT c FROM Contrato c WHERE c.finicio = :finicio")
    , @NamedQuery(name = "Contrato.findByFvencimiento", query = "SELECT c FROM Contrato c WHERE c.fvencimiento = :fvencimiento")
    , @NamedQuery(name = "Contrato.findByClienteIdCliente", query = "SELECT c FROM Contrato c WHERE c.contratoPK.clienteIdCliente = :clienteIdCliente")
    , @NamedQuery(name = "Contrato.findByClienteUsuarioIdUsuario", query = "SELECT c FROM Contrato c WHERE c.contratoPK.clienteUsuarioIdUsuario = :clienteUsuarioIdUsuario")
    , @NamedQuery(name = "Contrato.findByIdCliente", query = "SELECT c FROM Contrato c WHERE c.idCliente = :idCliente")})
public class Contrato implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ContratoPK contratoPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FINICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date finicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FVENCIMIENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fvencimiento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_CLIENTE")
    private BigInteger idCliente;
    @JoinTable(name = "RELATION_15", joinColumns = {
        @JoinColumn(name = "CONTRATO_ID_CONTRATO", referencedColumnName = "ID_CONTRATO")
        , @JoinColumn(name = "CONTRATO_CLIENTE_ID_CLIENTE", referencedColumnName = "CLIENTE_ID_CLIENTE")
        , @JoinColumn(name = "CONT_CLI_USUARIO_ID_USUARIO", referencedColumnName = "CLIENTE_USUARIO_ID_USUARIO")}, inverseJoinColumns = {
        @JoinColumn(name = "SERVICIO_ID_SERVICIO", referencedColumnName = "ID_SERVICIO")})
    @ManyToMany
    private Collection<Servicio> servicioCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contrato")
    private Collection<Extra> extraCollection;
    @JoinColumns({
        @JoinColumn(name = "CLIENTE_ID_CLIENTE", referencedColumnName = "ID_CLIENTE", insertable = false, updatable = false)
        , @JoinColumn(name = "CLIENTE_USUARIO_ID_USUARIO", referencedColumnName = "USUARIO_ID_USUARIO", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Cliente cliente;

    public Contrato() {
    }

    public Contrato(ContratoPK contratoPK) {
        this.contratoPK = contratoPK;
    }

    public Contrato(ContratoPK contratoPK, Date finicio, Date fvencimiento, BigInteger idCliente) {
        this.contratoPK = contratoPK;
        this.finicio = finicio;
        this.fvencimiento = fvencimiento;
        this.idCliente = idCliente;
    }

    public Contrato(BigInteger idContrato, BigInteger clienteIdCliente, BigInteger clienteUsuarioIdUsuario) {
        this.contratoPK = new ContratoPK(idContrato, clienteIdCliente, clienteUsuarioIdUsuario);
    }

    public ContratoPK getContratoPK() {
        return contratoPK;
    }

    public void setContratoPK(ContratoPK contratoPK) {
        this.contratoPK = contratoPK;
    }

    public Date getFinicio() {
        return finicio;
    }

    public void setFinicio(Date finicio) {
        this.finicio = finicio;
    }

    public Date getFvencimiento() {
        return fvencimiento;
    }

    public void setFvencimiento(Date fvencimiento) {
        this.fvencimiento = fvencimiento;
    }

    public BigInteger getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(BigInteger idCliente) {
        this.idCliente = idCliente;
    }

    @XmlTransient
    public Collection<Servicio> getServicioCollection() {
        return servicioCollection;
    }

    public void setServicioCollection(Collection<Servicio> servicioCollection) {
        this.servicioCollection = servicioCollection;
    }

    @XmlTransient
    public Collection<Extra> getExtraCollection() {
        return extraCollection;
    }

    public void setExtraCollection(Collection<Extra> extraCollection) {
        this.extraCollection = extraCollection;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (contratoPK != null ? contratoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contrato)) {
            return false;
        }
        Contrato other = (Contrato) object;
        if ((this.contratoPK == null && other.contratoPK != null) || (this.contratoPK != null && !this.contratoPK.equals(other.contratoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Contrato[ contratoPK=" + contratoPK + " ]";
    }
    
}
