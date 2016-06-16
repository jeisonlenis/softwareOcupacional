/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author D4MN4710N
 */
@Entity
@Table(name = "acc_tra_enf_lab")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AccTraEnfLab.findAll", query = "SELECT a FROM AccTraEnfLab a"),
    @NamedQuery(name = "AccTraEnfLab.findByIdAtel", query = "SELECT a FROM AccTraEnfLab a WHERE a.idAtel = :idAtel"),
    @NamedQuery(name = "AccTraEnfLab.findByAnio", query = "SELECT a FROM AccTraEnfLab a WHERE a.anio = :anio"),
    @NamedQuery(name = "AccTraEnfLab.findByDescIni", query = "SELECT a FROM AccTraEnfLab a WHERE a.descIni = :descIni"),
    @NamedQuery(name = "AccTraEnfLab.findByAccTrab", query = "SELECT a FROM AccTraEnfLab a WHERE a.accTrab = :accTrab"),
    @NamedQuery(name = "AccTraEnfLab.findByEnferProfe", query = "SELECT a FROM AccTraEnfLab a WHERE a.enferProfe = :enferProfe"),
    @NamedQuery(name = "AccTraEnfLab.findByEmpAcc", query = "SELECT a FROM AccTraEnfLab a WHERE a.empAcc = :empAcc"),
    @NamedQuery(name = "AccTraEnfLab.findBySecuelas", query = "SELECT a FROM AccTraEnfLab a WHERE a.secuelas = :secuelas"),
    @NamedQuery(name = "AccTraEnfLab.findByArl", query = "SELECT a FROM AccTraEnfLab a WHERE a.arl = :arl")})
public class AccTraEnfLab implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_atel")
    private Integer idAtel;
    @Column(name = "anio")
    private Integer anio;
    @Size(max = 45)
    @Column(name = "desc_ini")
    private String descIni;
    @Size(max = 200)
    @Column(name = "acc_trab")
    private String accTrab;
    @Size(max = 200)
    @Column(name = "enfer_profe")
    private String enferProfe;
    @Size(max = 45)
    @Column(name = "emp_acc")
    private String empAcc;
    @Size(max = 45)
    @Column(name = "secuelas")
    private String secuelas;
    @Size(max = 45)
    @Column(name = "arl")
    private String arl;
    @JoinColumn(name = "id_emo", referencedColumnName = "id_emo")
    @ManyToOne(optional = false)
    private Emo idEmo;

    public AccTraEnfLab() {
    }

    public AccTraEnfLab(Integer idAtel) {
        this.idAtel = idAtel;
    }

    public Integer getIdAtel() {
        return idAtel;
    }

    public void setIdAtel(Integer idAtel) {
        this.idAtel = idAtel;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public String getDescIni() {
        return descIni;
    }

    public void setDescIni(String descIni) {
        this.descIni = descIni;
    }

    public String getAccTrab() {
        return accTrab;
    }

    public void setAccTrab(String accTrab) {
        this.accTrab = accTrab;
    }

    public String getEnferProfe() {
        return enferProfe;
    }

    public void setEnferProfe(String enferProfe) {
        this.enferProfe = enferProfe;
    }

    public String getEmpAcc() {
        return empAcc;
    }

    public void setEmpAcc(String empAcc) {
        this.empAcc = empAcc;
    }

    public String getSecuelas() {
        return secuelas;
    }

    public void setSecuelas(String secuelas) {
        this.secuelas = secuelas;
    }

    public String getArl() {
        return arl;
    }

    public void setArl(String arl) {
        this.arl = arl;
    }

    public Emo getIdEmo() {
        return idEmo;
    }

    public void setIdEmo(Emo idEmo) {
        this.idEmo = idEmo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAtel != null ? idAtel.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AccTraEnfLab)) {
            return false;
        }
        AccTraEnfLab other = (AccTraEnfLab) object;
        if ((this.idAtel == null && other.idAtel != null) || (this.idAtel != null && !this.idAtel.equals(other.idAtel))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.AccTraEnfLab[ idAtel=" + idAtel + " ]";
    }
    
}
