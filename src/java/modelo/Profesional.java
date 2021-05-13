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
@Table(name = "PROFESIONAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Profesional.findAll", query = "SELECT p FROM Profesional p")
    , @NamedQuery(name = "Profesional.findByIdProfesional", query = "SELECT p FROM Profesional p WHERE p.idProfesional = :idProfesional")
    , @NamedQuery(name = "Profesional.findByNombreprofesional", query = "SELECT p FROM Profesional p WHERE p.nombreprofesional = :nombreprofesional")
    , @NamedQuery(name = "Profesional.findByApaterno", query = "SELECT p FROM Profesional p WHERE p.apaterno = :apaterno")
    , @NamedQuery(name = "Profesional.findByAmaterno", query = "SELECT p FROM Profesional p WHERE p.amaterno = :amaterno")
    , @NamedQuery(name = "Profesional.findByUsuarioIdUsuario", query = "SELECT p FROM Profesional p WHERE p.usuarioIdUsuario = :usuarioIdUsuario")})
public class Profesional implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PROFESIONAL")
    private int idProfesional;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NOMBREPROFESIONAL")
    private String nombreprofesional;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "APATERNO")
    private String apaterno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "AMATERNO")
    private String amaterno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "USUARIO_ID_USUARIO")
    private int usuarioIdUsuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "profesionalIdProfesional")
    private Collection<Capacitacion> capacitacionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "profesionalIdProfesional")
    private Collection<Contrato> contratoCollection;
    @OneToMany(mappedBy = "profesionalIdProfesional")
    private Collection<Llamada> llamadaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "profesionalIdProfesional")
    private Collection<Visita> visitaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "profesionalIdProfesional")
    private Collection<Asesoria> asesoriaCollection;

    public Profesional() {
    }

    public Profesional(int idProfesional) {
        this.idProfesional = idProfesional;
    }

    public Profesional(String nombreprofesional, String apaterno, String amaterno, int usuarioIdUsuario) {
        
        this.nombreprofesional = nombreprofesional;
        this.apaterno = apaterno;
        this.amaterno = amaterno;
        this.usuarioIdUsuario = usuarioIdUsuario;
    }

    public int getIdProfesional() {
        return idProfesional;
    }

    public void setIdProfesional(int idProfesional) {
        this.idProfesional = idProfesional;
    }

    public String getNombreprofesional() {
        return nombreprofesional;
    }

    public void setNombreprofesional(String nombreprofesional) {
        this.nombreprofesional = nombreprofesional;
    }

    public String getApaterno() {
        return apaterno;
    }

    public void setApaterno(String apaterno) {
        this.apaterno = apaterno;
    }

    public String getAmaterno() {
        return amaterno;
    }

    public void setAmaterno(String amaterno) {
        this.amaterno = amaterno;
    }

    public int getUsuarioIdUsuario() {
        return usuarioIdUsuario;
    }

    public void setUsuarioIdUsuario(int usuarioIdUsuario) {
        this.usuarioIdUsuario = usuarioIdUsuario;
    }

    @XmlTransient
    public Collection<Capacitacion> getCapacitacionCollection() {
        return capacitacionCollection;
    }

    public void setCapacitacionCollection(Collection<Capacitacion> capacitacionCollection) {
        this.capacitacionCollection = capacitacionCollection;
    }

    @XmlTransient
    public Collection<Contrato> getContratoCollection() {
        return contratoCollection;
    }

    public void setContratoCollection(Collection<Contrato> contratoCollection) {
        this.contratoCollection = contratoCollection;
    }

    @XmlTransient
    public Collection<Llamada> getLlamadaCollection() {
        return llamadaCollection;
    }

    public void setLlamadaCollection(Collection<Llamada> llamadaCollection) {
        this.llamadaCollection = llamadaCollection;
    }

    @XmlTransient
    public Collection<Visita> getVisitaCollection() {
        return visitaCollection;
    }

    public void setVisitaCollection(Collection<Visita> visitaCollection) {
        this.visitaCollection = visitaCollection;
    }

    @XmlTransient
    public Collection<Asesoria> getAsesoriaCollection() {
        return asesoriaCollection;
    }

    public void setAsesoriaCollection(Collection<Asesoria> asesoriaCollection) {
        this.asesoriaCollection = asesoriaCollection;
    }

    

    @Override
    public String toString() {
        return "modelo.Profesional[ idProfesional=" + idProfesional + " ]";
    }
    
}
