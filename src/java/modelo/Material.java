/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
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
@Table(name = "MATERIAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Material.findAll", query = "SELECT m FROM Material m")
    , @NamedQuery(name = "Material.findByIdMateriales", query = "SELECT m FROM Material m WHERE m.idMateriales = :idMateriales")
    , @NamedQuery(name = "Material.findByNombremateriles", query = "SELECT m FROM Material m WHERE m.nombremateriles = :nombremateriles")
    , @NamedQuery(name = "Material.findByCostomateriales", query = "SELECT m FROM Material m WHERE m.costomateriales = :costomateriales")})
public class Material implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "materialIdMateriales")
    private Collection<Capacitacion> capacitacionCollection;

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_MATERIALES")
    private int idMateriales;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NOMBREMATERILES")
    private String nombremateriles;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COSTOMATERIALES")
    private int costomateriales;

    public Material() {
    }

    public Material(int idMateriales) {
        this.idMateriales = idMateriales;
    }

    public Material( String nombremateriles, int costomateriales) {
       // this.idMateriales = idMateriales;
        this.nombremateriles = nombremateriles;
        this.costomateriales = costomateriales;
    }

    public int getIdMateriales() {
        return idMateriales;
    }

    public void setIdMateriales(int idMateriales) {
        this.idMateriales = idMateriales;
    }

    public String getNombremateriles() {
        return nombremateriles;
    }

    public void setNombremateriles(String nombremateriles) {
        this.nombremateriles = nombremateriles;
    }

    public int getCostomateriales() {
        return costomateriales;
    }

    public void setCostomateriales(int costomateriales) {
        this.costomateriales = costomateriales;
    }


    @Override
    public String toString() {
        return "modelo.Material[ idMateriales=" + idMateriales + " ]";
    }

    @XmlTransient
    public Collection<Capacitacion> getCapacitacionCollection() {
        return capacitacionCollection;
    }

    public void setCapacitacionCollection(Collection<Capacitacion> capacitacionCollection) {
        this.capacitacionCollection = capacitacionCollection;
    }
    
}
