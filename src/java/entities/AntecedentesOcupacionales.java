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
@Table(name = "antecedentes_ocupacionales")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AntecedentesOcupacionales.findAll", query = "SELECT a FROM AntecedentesOcupacionales a"),
    @NamedQuery(name = "AntecedentesOcupacionales.findByIdAntOcu", query = "SELECT a FROM AntecedentesOcupacionales a WHERE a.idAntOcu = :idAntOcu"),
    @NamedQuery(name = "AntecedentesOcupacionales.findByNomEmp", query = "SELECT a FROM AntecedentesOcupacionales a WHERE a.nomEmp = :nomEmp"),
    @NamedQuery(name = "AntecedentesOcupacionales.findByActEcoEmp", query = "SELECT a FROM AntecedentesOcupacionales a WHERE a.actEcoEmp = :actEcoEmp"),
    @NamedQuery(name = "AntecedentesOcupacionales.findByOficio", query = "SELECT a FROM AntecedentesOcupacionales a WHERE a.oficio = :oficio"),
    @NamedQuery(name = "AntecedentesOcupacionales.findByAntiguedad", query = "SELECT a FROM AntecedentesOcupacionales a WHERE a.antiguedad = :antiguedad"),
    @NamedQuery(name = "AntecedentesOcupacionales.findByRiesgos", query = "SELECT a FROM AntecedentesOcupacionales a WHERE a.riesgos = :riesgos"),
    @NamedQuery(name = "AntecedentesOcupacionales.findByEpp", query = "SELECT a FROM AntecedentesOcupacionales a WHERE a.epp = :epp")})
public class AntecedentesOcupacionales implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_ant_ocu")
    private Integer idAntOcu;
    @Size(max = 45)
    @Column(name = "nom_emp")
    private String nomEmp;
    @Size(max = 45)
    @Column(name = "act_eco_emp")
    private String actEcoEmp;
    @Size(max = 45)
    @Column(name = "oficio")
    private String oficio;
    @Column(name = "antiguedad")
    private Integer antiguedad;
    @Size(max = 100)
    @Column(name = "riesgos")
    private String riesgos;
    @Size(max = 100)
    @Column(name = "epp")
    private String epp;
    @JoinColumn(name = "id_emo", referencedColumnName = "id_emo")
    @ManyToOne(optional = false)
    private Emo idEmo;

    public AntecedentesOcupacionales() {
    }

    public AntecedentesOcupacionales(Integer idAntOcu) {
        this.idAntOcu = idAntOcu;
    }

    public Integer getIdAntOcu() {
        return idAntOcu;
    }

    public void setIdAntOcu(Integer idAntOcu) {
        this.idAntOcu = idAntOcu;
    }

    public String getNomEmp() {
        return nomEmp;
    }

    public void setNomEmp(String nomEmp) {
        this.nomEmp = nomEmp;
    }

    public String getActEcoEmp() {
        return actEcoEmp;
    }

    public void setActEcoEmp(String actEcoEmp) {
        this.actEcoEmp = actEcoEmp;
    }

    public String getOficio() {
        return oficio;
    }

    public void setOficio(String oficio) {
        this.oficio = oficio;
    }

    public Integer getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(Integer antiguedad) {
        this.antiguedad = antiguedad;
    }

    public String getRiesgos() {
        return riesgos;
    }

    public void setRiesgos(String riesgos) {
        this.riesgos = riesgos;
    }

    public String getEpp() {
        return epp;
    }

    public void setEpp(String epp) {
        this.epp = epp;
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
        hash += (idAntOcu != null ? idAntOcu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AntecedentesOcupacionales)) {
            return false;
        }
        AntecedentesOcupacionales other = (AntecedentesOcupacionales) object;
        if ((this.idAntOcu == null && other.idAntOcu != null) || (this.idAntOcu != null && !this.idAntOcu.equals(other.idAntOcu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.AntecedentesOcupacionales[ idAntOcu=" + idAntOcu + " ]";
    }
    
}
