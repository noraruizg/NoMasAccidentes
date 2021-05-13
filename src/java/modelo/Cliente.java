/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author norar
 */
@Entity
@Table(name = "CLIENTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c")
    , @NamedQuery(name = "Cliente.findByIdCliente", query = "SELECT c FROM Cliente c WHERE c.idCliente = :idCliente")
    , @NamedQuery(name = "Cliente.findByNombre", query = "SELECT c FROM Cliente c WHERE c.nombre = :nombre")
    , @NamedQuery(name = "Cliente.findByRubro", query = "SELECT c FROM Cliente c WHERE c.rubro = :rubro")
    , @NamedQuery(name = "Cliente.findByDescripcioncliente", query = "SELECT c FROM Cliente c WHERE c.descripcioncliente = :descripcioncliente")
    , @NamedQuery(name = "Cliente.findByUsuarioIdUsuario", query = "SELECT c FROM Cliente c WHERE c.usuarioIdUsuario = :usuarioIdUsuario")})
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_CLIENTE")
    private int idCliente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "RUBRO")
    private int rubro;
    @Size(max = 200)
    @Column(name = "DESCRIPCIONCLIENTE")
    private String descripcioncliente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "USUARIO_ID_USUARIO")
    private int usuarioIdUsuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
    private Collection<Contrato> contratoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clienteIdCliente")
    private Collection<Accidente> accidenteCollection;

    public Cliente() {
    }

    public Cliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public Cliente( String nombre, int rubro, int usuarioIdUsuario) {
       
        this.nombre = nombre;
        this.rubro = rubro;
        this.usuarioIdUsuario = usuarioIdUsuario;
    }

    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getRubro() {
        return rubro;
    }

    public void setRubro(int rubro) {
        this.rubro = rubro;
    }

    public String getDescripcioncliente() {
        return descripcioncliente;
    }

    public void setDescripcioncliente(String descripcioncliente) {
        this.descripcioncliente = descripcioncliente;
    }

    public int getUsuarioIdUsuario() {
        return usuarioIdUsuario;
    }

    public void setUsuarioIdUsuario(int usuarioIdUsuario) {
        this.usuarioIdUsuario = usuarioIdUsuario;
    }

    @XmlTransient
    public Collection<Contrato> getContratoCollection() {
        return contratoCollection;
    }

    public void setContratoCollection(Collection<Contrato> contratoCollection) {
        this.contratoCollection = contratoCollection;
    }

    @XmlTransient
    public Collection<Accidente> getAccidenteCollection() {
        return accidenteCollection;
    }

    public void setAccidenteCollection(Collection<Accidente> accidenteCollection) {
        this.accidenteCollection = accidenteCollection;
    }

       

    @Override
    public String toString() {
        return "modelo.Cliente[ idCliente=" + idCliente + " ]";
    }
    
}
