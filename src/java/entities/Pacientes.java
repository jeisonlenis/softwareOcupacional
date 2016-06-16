/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
 * @author D4MN4710N
 */
@Entity
@Table(name = "pacientes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pacientes.findAll", query = "SELECT p FROM Pacientes p"),
    @NamedQuery(name = "Pacientes.findByIdPaciente", query = "SELECT p FROM Pacientes p WHERE p.idPaciente = :idPaciente"),
    @NamedQuery(name = "Pacientes.findByIdClem", query = "SELECT e FROM Pacientes e WHERE e.idClem = :idClem"),
    @NamedQuery(name = "Pacientes.findByNombres", query = "SELECT p FROM Pacientes p WHERE p.nombres = :nombres"),
    @NamedQuery(name = "Pacientes.findByApellidos", query = "SELECT p FROM Pacientes p WHERE p.apellidos = :apellidos"),
    @NamedQuery(name = "Pacientes.findByTipoDoc", query = "SELECT p FROM Pacientes p WHERE p.tipoDoc = :tipoDoc"),
    @NamedQuery(name = "Pacientes.findByNumDoc", query = "SELECT p FROM Pacientes p WHERE p.numDoc = :numDoc"),
    @NamedQuery(name = "Pacientes.findByFecNac", query = "SELECT p FROM Pacientes p WHERE p.fecNac = :fecNac"),
    @NamedQuery(name = "Pacientes.findByEdad", query = "SELECT p FROM Pacientes p WHERE p.edad = :edad"),
    @NamedQuery(name = "Pacientes.findByTelCel", query = "SELECT p FROM Pacientes p WHERE p.telCel = :telCel"),
    @NamedQuery(name = "Pacientes.findByDireccion", query = "SELECT p FROM Pacientes p WHERE p.direccion = :direccion"),
    @NamedQuery(name = "Pacientes.findByCiudad", query = "SELECT p FROM Pacientes p WHERE p.ciudad = :ciudad"),
    @NamedQuery(name = "Pacientes.findByEstCiv", query = "SELECT p FROM Pacientes p WHERE p.estCiv = :estCiv"),
    @NamedQuery(name = "Pacientes.findByNivAca", query = "SELECT p FROM Pacientes p WHERE p.nivAca = :nivAca"),
    @NamedQuery(name = "Pacientes.findByAfp", query = "SELECT p FROM Pacientes p WHERE p.afp = :afp"),
    @NamedQuery(name = "Pacientes.findByEps", query = "SELECT p FROM Pacientes p WHERE p.eps = :eps"),
    @NamedQuery(name = "Pacientes.findByArl", query = "SELECT p FROM Pacientes p WHERE p.arl = :arl"),
    @NamedQuery(name = "Pacientes.findByNumHijos", query = "SELECT p FROM Pacientes p WHERE p.numHijos = :numHijos"),
    @NamedQuery(name = "Pacientes.findByGenero", query = "SELECT p FROM Pacientes p WHERE p.genero = :genero")})
public class Pacientes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_paciente")
    private Integer idPaciente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombres")
    private String nombres;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "apellidos")
    private String apellidos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "tipo_doc")
    private String tipoDoc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "num_doc")
    private int numDoc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fec_nac")
    @Temporal(TemporalType.DATE)
    private Date fecNac;
    @Basic(optional = false)
    @NotNull
    @Column(name = "edad")
    private int edad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tel_cel")
    private int telCel;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "direccion")
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "ciudad")
    private String ciudad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "est_civ")
    private String estCiv;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "niv_aca")
    private String nivAca;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "afp")
    private String afp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "eps")
    private String eps;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "arl")
    private String arl;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "num_hijos")
    private String numHijos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "genero")
    private Character genero;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPaciente")
    private List<Emo> emoList;
    @JoinColumn(name = "id_clem", referencedColumnName = "id_clem")
    @ManyToOne(optional = false)
    private Empresas idClem;

    public Pacientes() {
    }

    public Pacientes(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }

    public Pacientes(Integer idPaciente, String nombres, String apellidos, String tipoDoc, int numDoc, Date fecNac, int edad, int telCel, String direccion, String ciudad, String estCiv, String nivAca, String afp, String eps, String arl, String numHijos, Character genero) {
        this.idPaciente = idPaciente;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.tipoDoc = tipoDoc;
        this.numDoc = numDoc;
        this.fecNac = fecNac;
        this.edad = edad;
        this.telCel = telCel;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.estCiv = estCiv;
        this.nivAca = nivAca;
        this.afp = afp;
        this.eps = eps;
        this.arl = arl;
        this.numHijos = numHijos;
        this.genero = genero;
    }

    public Integer getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTipoDoc() {
        return tipoDoc;
    }

    public void setTipoDoc(String tipoDoc) {
        this.tipoDoc = tipoDoc;
    }

    public int getNumDoc() {
        return numDoc;
    }

    public void setNumDoc(int numDoc) {
        this.numDoc = numDoc;
    }

    public Date getFecNac() {
        return fecNac;
    }

    public void setFecNac(Date fecNac) {
        this.fecNac = fecNac;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getTelCel() {
        return telCel;
    }

    public void setTelCel(int telCel) {
        this.telCel = telCel;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEstCiv() {
        return estCiv;
    }

    public void setEstCiv(String estCiv) {
        this.estCiv = estCiv;
    }

    public String getNivAca() {
        return nivAca;
    }

    public void setNivAca(String nivAca) {
        this.nivAca = nivAca;
    }

    public String getAfp() {
        return afp;
    }

    public void setAfp(String afp) {
        this.afp = afp;
    }

    public String getEps() {
        return eps;
    }

    public void setEps(String eps) {
        this.eps = eps;
    }

    public String getArl() {
        return arl;
    }

    public void setArl(String arl) {
        this.arl = arl;
    }

    public String getNumHijos() {
        return numHijos;
    }

    public void setNumHijos(String numHijos) {
        this.numHijos = numHijos;
    }

    public Character getGenero() {
        return genero;
    }

    public void setGenero(Character genero) {
        this.genero = genero;
    }

    @XmlTransient
    public List<Emo> getEmoList() {
        return emoList;
    }

    public void setEmoList(List<Emo> emoList) {
        this.emoList = emoList;
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
        hash += (idPaciente != null ? idPaciente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pacientes)) {
            return false;
        }
        Pacientes other = (Pacientes) object;
        if ((this.idPaciente == null && other.idPaciente != null) || (this.idPaciente != null && !this.idPaciente.equals(other.idPaciente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Pacientes[ idPaciente=" + idPaciente + " ]";
    }
    
}
