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
public class AsistenciaPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_ASISTENCIA")
    private BigInteger idAsistencia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CAPACITACION_ID_CAP")
    private BigInteger capacitacionIdCap;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CAP_EXTRA_ID_SOLICITUDES")
    private BigInteger capExtraIdSolicitudes;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CAP_EXTRA_CONT_ID_CONTRATO")
    private BigInteger capExtraContIdContrato;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CAP_EXTRA_CONT_CLI_ID_CLIENTE")
    private BigInteger capExtraContCliIdCliente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CAP_EXTRA_CONT_US_ID_USUARIO")
    private BigInteger capExtraContUsIdUsuario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CAPACITACION_ID_VISITA")
    private BigInteger capacitacionIdVisita;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CAPACITACION_ID_PROFESIONAL3")
    private BigInteger capacitacionIdProfesional3;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CAPACITACION_ID_PROFESIONAL12")
    private BigInteger capacitacionIdProfesional12;

    public AsistenciaPK() {
    }

    public AsistenciaPK(BigInteger idAsistencia, BigInteger capacitacionIdCap, BigInteger capExtraIdSolicitudes, BigInteger capExtraContIdContrato, BigInteger capExtraContCliIdCliente, BigInteger capExtraContUsIdUsuario, BigInteger capacitacionIdVisita, BigInteger capacitacionIdProfesional3, BigInteger capacitacionIdProfesional12) {
        this.idAsistencia = idAsistencia;
        this.capacitacionIdCap = capacitacionIdCap;
        this.capExtraIdSolicitudes = capExtraIdSolicitudes;
        this.capExtraContIdContrato = capExtraContIdContrato;
        this.capExtraContCliIdCliente = capExtraContCliIdCliente;
        this.capExtraContUsIdUsuario = capExtraContUsIdUsuario;
        this.capacitacionIdVisita = capacitacionIdVisita;
        this.capacitacionIdProfesional3 = capacitacionIdProfesional3;
        this.capacitacionIdProfesional12 = capacitacionIdProfesional12;
    }

    public BigInteger getIdAsistencia() {
        return idAsistencia;
    }

    public void setIdAsistencia(BigInteger idAsistencia) {
        this.idAsistencia = idAsistencia;
    }

    public BigInteger getCapacitacionIdCap() {
        return capacitacionIdCap;
    }

    public void setCapacitacionIdCap(BigInteger capacitacionIdCap) {
        this.capacitacionIdCap = capacitacionIdCap;
    }

    public BigInteger getCapExtraIdSolicitudes() {
        return capExtraIdSolicitudes;
    }

    public void setCapExtraIdSolicitudes(BigInteger capExtraIdSolicitudes) {
        this.capExtraIdSolicitudes = capExtraIdSolicitudes;
    }

    public BigInteger getCapExtraContIdContrato() {
        return capExtraContIdContrato;
    }

    public void setCapExtraContIdContrato(BigInteger capExtraContIdContrato) {
        this.capExtraContIdContrato = capExtraContIdContrato;
    }

    public BigInteger getCapExtraContCliIdCliente() {
        return capExtraContCliIdCliente;
    }

    public void setCapExtraContCliIdCliente(BigInteger capExtraContCliIdCliente) {
        this.capExtraContCliIdCliente = capExtraContCliIdCliente;
    }

    public BigInteger getCapExtraContUsIdUsuario() {
        return capExtraContUsIdUsuario;
    }

    public void setCapExtraContUsIdUsuario(BigInteger capExtraContUsIdUsuario) {
        this.capExtraContUsIdUsuario = capExtraContUsIdUsuario;
    }

    public BigInteger getCapacitacionIdVisita() {
        return capacitacionIdVisita;
    }

    public void setCapacitacionIdVisita(BigInteger capacitacionIdVisita) {
        this.capacitacionIdVisita = capacitacionIdVisita;
    }

    public BigInteger getCapacitacionIdProfesional3() {
        return capacitacionIdProfesional3;
    }

    public void setCapacitacionIdProfesional3(BigInteger capacitacionIdProfesional3) {
        this.capacitacionIdProfesional3 = capacitacionIdProfesional3;
    }

    public BigInteger getCapacitacionIdProfesional12() {
        return capacitacionIdProfesional12;
    }

    public void setCapacitacionIdProfesional12(BigInteger capacitacionIdProfesional12) {
        this.capacitacionIdProfesional12 = capacitacionIdProfesional12;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAsistencia != null ? idAsistencia.hashCode() : 0);
        hash += (capacitacionIdCap != null ? capacitacionIdCap.hashCode() : 0);
        hash += (capExtraIdSolicitudes != null ? capExtraIdSolicitudes.hashCode() : 0);
        hash += (capExtraContIdContrato != null ? capExtraContIdContrato.hashCode() : 0);
        hash += (capExtraContCliIdCliente != null ? capExtraContCliIdCliente.hashCode() : 0);
        hash += (capExtraContUsIdUsuario != null ? capExtraContUsIdUsuario.hashCode() : 0);
        hash += (capacitacionIdVisita != null ? capacitacionIdVisita.hashCode() : 0);
        hash += (capacitacionIdProfesional3 != null ? capacitacionIdProfesional3.hashCode() : 0);
        hash += (capacitacionIdProfesional12 != null ? capacitacionIdProfesional12.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AsistenciaPK)) {
            return false;
        }
        AsistenciaPK other = (AsistenciaPK) object;
        if ((this.idAsistencia == null && other.idAsistencia != null) || (this.idAsistencia != null && !this.idAsistencia.equals(other.idAsistencia))) {
            return false;
        }
        if ((this.capacitacionIdCap == null && other.capacitacionIdCap != null) || (this.capacitacionIdCap != null && !this.capacitacionIdCap.equals(other.capacitacionIdCap))) {
            return false;
        }
        if ((this.capExtraIdSolicitudes == null && other.capExtraIdSolicitudes != null) || (this.capExtraIdSolicitudes != null && !this.capExtraIdSolicitudes.equals(other.capExtraIdSolicitudes))) {
            return false;
        }
        if ((this.capExtraContIdContrato == null && other.capExtraContIdContrato != null) || (this.capExtraContIdContrato != null && !this.capExtraContIdContrato.equals(other.capExtraContIdContrato))) {
            return false;
        }
        if ((this.capExtraContCliIdCliente == null && other.capExtraContCliIdCliente != null) || (this.capExtraContCliIdCliente != null && !this.capExtraContCliIdCliente.equals(other.capExtraContCliIdCliente))) {
            return false;
        }
        if ((this.capExtraContUsIdUsuario == null && other.capExtraContUsIdUsuario != null) || (this.capExtraContUsIdUsuario != null && !this.capExtraContUsIdUsuario.equals(other.capExtraContUsIdUsuario))) {
            return false;
        }
        if ((this.capacitacionIdVisita == null && other.capacitacionIdVisita != null) || (this.capacitacionIdVisita != null && !this.capacitacionIdVisita.equals(other.capacitacionIdVisita))) {
            return false;
        }
        if ((this.capacitacionIdProfesional3 == null && other.capacitacionIdProfesional3 != null) || (this.capacitacionIdProfesional3 != null && !this.capacitacionIdProfesional3.equals(other.capacitacionIdProfesional3))) {
            return false;
        }
        if ((this.capacitacionIdProfesional12 == null && other.capacitacionIdProfesional12 != null) || (this.capacitacionIdProfesional12 != null && !this.capacitacionIdProfesional12.equals(other.capacitacionIdProfesional12))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.AsistenciaPK[ idAsistencia=" + idAsistencia + ", capacitacionIdCap=" + capacitacionIdCap + ", capExtraIdSolicitudes=" + capExtraIdSolicitudes + ", capExtraContIdContrato=" + capExtraContIdContrato + ", capExtraContCliIdCliente=" + capExtraContCliIdCliente + ", capExtraContUsIdUsuario=" + capExtraContUsIdUsuario + ", capacitacionIdVisita=" + capacitacionIdVisita + ", capacitacionIdProfesional3=" + capacitacionIdProfesional3 + ", capacitacionIdProfesional12=" + capacitacionIdProfesional12 + " ]";
    }
    
}
