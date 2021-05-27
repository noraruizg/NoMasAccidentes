/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "ALERTA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Alerta.findAll", query = "SELECT a FROM Alerta a")
    , @NamedQuery(name = "Alerta.findByIdAlerta", query = "SELECT a FROM Alerta a WHERE a.idAlerta = :idAlerta")
    , @NamedQuery(name = "Alerta.findByFecha", query = "SELECT a FROM Alerta a WHERE a.fecha = :fecha")
    , @NamedQuery(name = "Alerta.findByDescripcionalerta", query = "SELECT a FROM Alerta a WHERE a.descripcionalerta = :descripcionalerta")
    , @NamedQuery(name = "Alerta.findByEstadoalerta", query = "SELECT a FROM Alerta a WHERE a.estadoalerta = :estadoalerta")})
public class Alerta implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_ALERTA")
    private int idAlerta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "DESCRIPCIONALERTA")
    private String descripcionalerta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTADOALERTA")
    private Character estadoalerta;
    @OneToMany(mappedBy = "alertaIdAlerta")
    private Collection<Usuario> usuarioCollection;
    @JoinColumn(name = "ACCIDENTE_ID_ACCIDENTE", referencedColumnName = "ID_ACCIDENTE")
    @ManyToOne(optional = false)
    private Accidente accidenteIdAccidente;

    public Alerta() {
    }

    public Alerta(int idAlerta) {
        this.idAlerta = idAlerta;
    }

    public Alerta(int idAlerta, Date fecha, String descripcionalerta, Character estadoalerta) {
        this.idAlerta = idAlerta;
        this.fecha = fecha;
        this.descripcionalerta = descripcionalerta;
        this.estadoalerta = estadoalerta;
    }

    public int getIdAlerta() {
        return idAlerta;
    }

    public void setIdAlerta(int idAlerta) {
        this.idAlerta = idAlerta;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDescripcionalerta() {
        return descripcionalerta;
    }

    public void setDescripcionalerta(String descripcionalerta) {
        this.descripcionalerta = descripcionalerta;
    }

    public Character getEstadoalerta() {
        return estadoalerta;
    }

    public void setEstadoalerta(Character estadoalerta) {
        this.estadoalerta = estadoalerta;
    }

    @XmlTransient
    public Collection<Usuario> getUsuarioCollection() {
        return usuarioCollection;
    }

    public void setUsuarioCollection(Collection<Usuario> usuarioCollection) {
        this.usuarioCollection = usuarioCollection;
    }

    public Accidente getAccidenteIdAccidente() {
        return accidenteIdAccidente;
    }

    public void setAccidenteIdAccidente(Accidente accidenteIdAccidente) {
        this.accidenteIdAccidente = accidenteIdAccidente;
    }


    @Override
    public String toString() {
        return "modelo.Alerta[ idAlerta=" + idAlerta + " ]";
    }
    
}
