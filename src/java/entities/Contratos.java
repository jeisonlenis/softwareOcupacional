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
@Table(name = "contratos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contratos.findAll", query = "SELECT c FROM Contratos c"),
    @NamedQuery(name = "Contratos.findByIdCont", query = "SELECT c FROM Contratos c WHERE c.idCont = :idCont"),
    @NamedQuery(name = "Contratos.findByNumCont", query = "SELECT c FROM Contratos c WHERE c.numCont = :numCont"),
    @NamedQuery(name = "Contratos.findByConceptoCont", query = "SELECT c FROM Contratos c WHERE c.conceptoCont = :conceptoCont"),
    @NamedQuery(name = "Contratos.findByFechaIniCon", query = "SELECT c FROM Contratos c WHERE c.fechaIniCon = :fechaIniCon"),
    @NamedQuery(name = "Contratos.findByFechaFinCont", query = "SELECT c FROM Contratos c WHERE c.fechaFinCont = :fechaFinCont"),
    @NamedQuery(name = "Contratos.findByPagoCont", query = "SELECT c FROM Contratos c WHERE c.pagoCont = :pagoCont"),
    @NamedQuery(name = "Contratos.findByTelCelCont", query = "SELECT c FROM Contratos c WHERE c.telCelCont = :telCelCont"),
    @NamedQuery(name = "Contratos.findByDirCont", query = "SELECT c FROM Contratos c WHERE c.dirCont = :dirCont"),
    @NamedQuery(name = "Contratos.findByNomCont", query = "SELECT c FROM Contratos c WHERE c.nomCont = :nomCont"),
    @NamedQuery(name = "Contratos.findByEmailCont", query = "SELECT c FROM Contratos c WHERE c.emailCont = :emailCont")})
public class Contratos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cont")
    private Integer idCont;
    @Column(name = "num_cont")
    private Integer numCont;
    @Size(max = 45)
    @Column(name = "concepto_cont")
    private String conceptoCont;
    @Size(max = 45)
    @Column(name = "fecha_ini_con")
    private String fechaIniCon;
    @Size(max = 45)
    @Column(name = "fecha_fin_cont")
    private String fechaFinCont;
    @Size(max = 45)
    @Column(name = "pago_cont")
    private String pagoCont;
    @Column(name = "tel_cel_cont")
    private Integer telCelCont;
    @Column(name = "dir_cont")
    private Integer dirCont;
    @Size(max = 45)
    @Column(name = "nom_cont")
    private String nomCont;
    @Size(max = 45)
    @Column(name = "email_cont")
    private String emailCont;
    @JoinColumn(name = "id_clem", referencedColumnName = "id_clem")
    @ManyToOne(optional = false)
    private Empresas idClem;

    public Contratos() {
    }

    public Contratos(Integer idCont) {
        this.idCont = idCont;
    }

    public Integer getIdCont() {
        return idCont;
    }

    public void setIdCont(Integer idCont) {
        this.idCont = idCont;
    }

    public Integer getNumCont() {
        return numCont;
    }

    public void setNumCont(Integer numCont) {
        this.numCont = numCont;
    }

    public String getConceptoCont() {
        return conceptoCont;
    }

    public void setConceptoCont(String conceptoCont) {
        this.conceptoCont = conceptoCont;
    }

    public String getFechaIniCon() {
        return fechaIniCon;
    }

    public void setFechaIniCon(String fechaIniCon) {
        this.fechaIniCon = fechaIniCon;
    }

    public String getFechaFinCont() {
        return fechaFinCont;
    }

    public void setFechaFinCont(String fechaFinCont) {
        this.fechaFinCont = fechaFinCont;
    }

    public String getPagoCont() {
        return pagoCont;
    }

    public void setPagoCont(String pagoCont) {
        this.pagoCont = pagoCont;
    }

    public Integer getTelCelCont() {
        return telCelCont;
    }

    public void setTelCelCont(Integer telCelCont) {
        this.telCelCont = telCelCont;
    }

    public Integer getDirCont() {
        return dirCont;
    }

    public void setDirCont(Integer dirCont) {
        this.dirCont = dirCont;
    }

    public String getNomCont() {
        return nomCont;
    }

    public void setNomCont(String nomCont) {
        this.nomCont = nomCont;
    }

    public String getEmailCont() {
        return emailCont;
    }

    public void setEmailCont(String emailCont) {
        this.emailCont = emailCont;
    }

    public Empresas getIdClem() {
        return idClem;
    }

    public void setIdClem(Empresas idClem) {
        this.idClem = idClem;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCont != null ? idCont.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contratos)) {
            return false;
        }
        Contratos other = (Contratos) object;
        if ((this.idCont == null && other.idCont != null) || (this.idCont != null && !this.idCont.equals(other.idCont))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Contratos[ idCont=" + idCont + " ]";
    }
    
}
