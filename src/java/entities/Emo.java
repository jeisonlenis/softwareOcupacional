/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author D4MN4710N
 */
@Entity
@Table(name = "emo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Emo.findAll", query = "SELECT e FROM Emo e"),
    @NamedQuery(name = "Emo.findByIdEmo", query = "SELECT e FROM Emo e WHERE e.idEmo = :idEmo"),
    @NamedQuery(name = "Emo.findByIdPaciente", query = "SELECT e FROM Emo e WHERE e.idPaciente = :idPaciente"),
    @NamedQuery(name = "Emo.findByRestriccionesLab", query = "SELECT e FROM Emo e WHERE e.restriccionesLab = :restriccionesLab"),
    @NamedQuery(name = "Emo.findByCualesUno", query = "SELECT e FROM Emo e WHERE e.cualesUno = :cualesUno"),
    @NamedQuery(name = "Emo.findByAntFam", query = "SELECT e FROM Emo e WHERE e.antFam = :antFam"),
    @NamedQuery(name = "Emo.findByHipertension", query = "SELECT e FROM Emo e WHERE e.hipertension = :hipertension"),
    @NamedQuery(name = "Emo.findByDiabetes", query = "SELECT e FROM Emo e WHERE e.diabetes = :diabetes"),
    @NamedQuery(name = "Emo.findByAsma", query = "SELECT e FROM Emo e WHERE e.asma = :asma"),
    @NamedQuery(name = "Emo.findByCardiovasculares", query = "SELECT e FROM Emo e WHERE e.cardiovasculares = :cardiovasculares"),
    @NamedQuery(name = "Emo.findByPsiquiatricos", query = "SELECT e FROM Emo e WHERE e.psiquiatricos = :psiquiatricos"),
    @NamedQuery(name = "Emo.findByEpilepsia", query = "SELECT e FROM Emo e WHERE e.epilepsia = :epilepsia"),
    @NamedQuery(name = "Emo.findByVisuales", query = "SELECT e FROM Emo e WHERE e.visuales = :visuales"),
    @NamedQuery(name = "Emo.findByRespiratorias", query = "SELECT e FROM Emo e WHERE e.respiratorias = :respiratorias"),
    @NamedQuery(name = "Emo.findByDermatologicos", query = "SELECT e FROM Emo e WHERE e.dermatologicos = :dermatologicos"),
    @NamedQuery(name = "Emo.findByReumatologicos", query = "SELECT e FROM Emo e WHERE e.reumatologicos = :reumatologicos"),
    @NamedQuery(name = "Emo.findByNeurologicos", query = "SELECT e FROM Emo e WHERE e.neurologicos = :neurologicos"),
    @NamedQuery(name = "Emo.findByVarices", query = "SELECT e FROM Emo e WHERE e.varices = :varices"),
    @NamedQuery(name = "Emo.findByCancer", query = "SELECT e FROM Emo e WHERE e.cancer = :cancer"),
    @NamedQuery(name = "Emo.findByHipotiroidismo", query = "SELECT e FROM Emo e WHERE e.hipotiroidismo = :hipotiroidismo"),
    @NamedQuery(name = "Emo.findByAlergicos", query = "SELECT e FROM Emo e WHERE e.alergicos = :alergicos"),
    @NamedQuery(name = "Emo.findByQuimicos", query = "SELECT e FROM Emo e WHERE e.quimicos = :quimicos"),
    @NamedQuery(name = "Emo.findByTraumaticos", query = "SELECT e FROM Emo e WHERE e.traumaticos = :traumaticos"),
    @NamedQuery(name = "Emo.findByFumas", query = "SELECT e FROM Emo e WHERE e.fumas = :fumas"),
    @NamedQuery(name = "Emo.findByCuantos", query = "SELECT e FROM Emo e WHERE e.cuantos = :cuantos"),
    @NamedQuery(name = "Emo.findByTiempoHaceCuanto", query = "SELECT e FROM Emo e WHERE e.tiempoHaceCuanto = :tiempoHaceCuanto"),
    @NamedQuery(name = "Emo.findByExfumador", query = "SELECT e FROM Emo e WHERE e.exfumador = :exfumador"),
    @NamedQuery(name = "Emo.findByLicor", query = "SELECT e FROM Emo e WHERE e.licor = :licor"),
    @NamedQuery(name = "Emo.findByHabitual", query = "SELECT e FROM Emo e WHERE e.habitual = :habitual"),
    @NamedQuery(name = "Emo.findByDeporte", query = "SELECT e FROM Emo e WHERE e.deporte = :deporte"),
    @NamedQuery(name = "Emo.findByQueDeporte", query = "SELECT e FROM Emo e WHERE e.queDeporte = :queDeporte"),
    @NamedQuery(name = "Emo.findByCuantasVecesSemana", query = "SELECT e FROM Emo e WHERE e.cuantasVecesSemana = :cuantasVecesSemana"),
    @NamedQuery(name = "Emo.findByManualidades", query = "SELECT e FROM Emo e WHERE e.manualidades = :manualidades"),
    @NamedQuery(name = "Emo.findByCualesDos", query = "SELECT e FROM Emo e WHERE e.cualesDos = :cualesDos"),
    @NamedQuery(name = "Emo.findByMeranea", query = "SELECT e FROM Emo e WHERE e.meranea = :meranea"),
    @NamedQuery(name = "Emo.findByGravida", query = "SELECT e FROM Emo e WHERE e.gravida = :gravida"),
    @NamedQuery(name = "Emo.findByPartos", query = "SELECT e FROM Emo e WHERE e.partos = :partos"),
    @NamedQuery(name = "Emo.findByCesareas", query = "SELECT e FROM Emo e WHERE e.cesareas = :cesareas"),
    @NamedQuery(name = "Emo.findByAbortos", query = "SELECT e FROM Emo e WHERE e.abortos = :abortos"),
    @NamedQuery(name = "Emo.findByHijosVivos", query = "SELECT e FROM Emo e WHERE e.hijosVivos = :hijosVivos"),
    @NamedQuery(name = "Emo.findByFechaUltimaMenst", query = "SELECT e FROM Emo e WHERE e.fechaUltimaMenst = :fechaUltimaMenst"),
    @NamedQuery(name = "Emo.findByCitologia", query = "SELECT e FROM Emo e WHERE e.citologia = :citologia"),
    @NamedQuery(name = "Emo.findByCiclos", query = "SELECT e FROM Emo e WHERE e.ciclos = :ciclos"),
    @NamedQuery(name = "Emo.findBySintOsteom", query = "SELECT e FROM Emo e WHERE e.sintOsteom = :sintOsteom"),
    @NamedQuery(name = "Emo.findByCodos", query = "SELECT e FROM Emo e WHERE e.codos = :codos"),
    @NamedQuery(name = "Emo.findByCadera", query = "SELECT e FROM Emo e WHERE e.cadera = :cadera"),
    @NamedQuery(name = "Emo.findByCervical", query = "SELECT e FROM Emo e WHERE e.cervical = :cervical"),
    @NamedQuery(name = "Emo.findByCuelloUno", query = "SELECT e FROM Emo e WHERE e.cuelloUno = :cuelloUno"),
    @NamedQuery(name = "Emo.findByDedos", query = "SELECT e FROM Emo e WHERE e.dedos = :dedos"),
    @NamedQuery(name = "Emo.findByDorsal", query = "SELECT e FROM Emo e WHERE e.dorsal = :dorsal"),
    @NamedQuery(name = "Emo.findByDorsolumbar", query = "SELECT e FROM Emo e WHERE e.dorsolumbar = :dorsolumbar"),
    @NamedQuery(name = "Emo.findByHombros", query = "SELECT e FROM Emo e WHERE e.hombros = :hombros"),
    @NamedQuery(name = "Emo.findByLumbosacra", query = "SELECT e FROM Emo e WHERE e.lumbosacra = :lumbosacra"),
    @NamedQuery(name = "Emo.findByManos", query = "SELECT e FROM Emo e WHERE e.manos = :manos"),
    @NamedQuery(name = "Emo.findByMuniecas", query = "SELECT e FROM Emo e WHERE e.muniecas = :muniecas"),
    @NamedQuery(name = "Emo.findByPies", query = "SELECT e FROM Emo e WHERE e.pies = :pies"),
    @NamedQuery(name = "Emo.findByRodillasUno", query = "SELECT e FROM Emo e WHERE e.rodillasUno = :rodillasUno"),
    @NamedQuery(name = "Emo.findByDescOsteom", query = "SELECT e FROM Emo e WHERE e.descOsteom = :descOsteom"),
    @NamedQuery(name = "Emo.findByOtros", query = "SELECT e FROM Emo e WHERE e.otros = :otros"),
    @NamedQuery(name = "Emo.findByRevisionSistemas", query = "SELECT e FROM Emo e WHERE e.revisionSistemas = :revisionSistemas"),
    @NamedQuery(name = "Emo.findByDescSiste", query = "SELECT e FROM Emo e WHERE e.descSiste = :descSiste"),
    @NamedQuery(name = "Emo.findByApariencia", query = "SELECT e FROM Emo e WHERE e.apariencia = :apariencia"),
    @NamedQuery(name = "Emo.findByDominancia", query = "SELECT e FROM Emo e WHERE e.dominancia = :dominancia"),
    @NamedQuery(name = "Emo.findByPeso", query = "SELECT e FROM Emo e WHERE e.peso = :peso"),
    @NamedQuery(name = "Emo.findByTalla", query = "SELECT e FROM Emo e WHERE e.talla = :talla"),
    @NamedQuery(name = "Emo.findByImc", query = "SELECT e FROM Emo e WHERE e.imc = :imc"),
    @NamedQuery(name = "Emo.findByTas", query = "SELECT e FROM Emo e WHERE e.tas = :tas"),
    @NamedQuery(name = "Emo.findByPresSist", query = "SELECT e FROM Emo e WHERE e.presSist = :presSist"),
    @NamedQuery(name = "Emo.findByTad", query = "SELECT e FROM Emo e WHERE e.tad = :tad"),
    @NamedQuery(name = "Emo.findByFc", query = "SELECT e FROM Emo e WHERE e.fc = :fc"),
    @NamedQuery(name = "Emo.findByFr", query = "SELECT e FROM Emo e WHERE e.fr = :fr"),
    @NamedQuery(name = "Emo.findByIt", query = "SELECT e FROM Emo e WHERE e.it = :it"),
    @NamedQuery(name = "Emo.findByAbdomen", query = "SELECT e FROM Emo e WHERE e.abdomen = :abdomen"),
    @NamedQuery(name = "Emo.findByHernias", query = "SELECT e FROM Emo e WHERE e.hernias = :hernias"),
    @NamedQuery(name = "Emo.findByArcoMovilidadArt", query = "SELECT e FROM Emo e WHERE e.arcoMovilidadArt = :arcoMovilidadArt"),
    @NamedQuery(name = "Emo.findByBoca", query = "SELECT e FROM Emo e WHERE e.boca = :boca"),
    @NamedQuery(name = "Emo.findByCicaTatu", query = "SELECT e FROM Emo e WHERE e.cicaTatu = :cicaTatu"),
    @NamedQuery(name = "Emo.findByColumCerv", query = "SELECT e FROM Emo e WHERE e.columCerv = :columCerv"),
    @NamedQuery(name = "Emo.findByColumLumbo", query = "SELECT e FROM Emo e WHERE e.columLumbo = :columLumbo"),
    @NamedQuery(name = "Emo.findByColumTora", query = "SELECT e FROM Emo e WHERE e.columTora = :columTora"),
    @NamedQuery(name = "Emo.findByColumVertebral", query = "SELECT e FROM Emo e WHERE e.columVertebral = :columVertebral"),
    @NamedQuery(name = "Emo.findByCorazon", query = "SELECT e FROM Emo e WHERE e.corazon = :corazon"),
    @NamedQuery(name = "Emo.findByCuelloDos", query = "SELECT e FROM Emo e WHERE e.cuelloDos = :cuelloDos"),
    @NamedQuery(name = "Emo.findByFilkenstein", query = "SELECT e FROM Emo e WHERE e.filkenstein = :filkenstein"),
    @NamedQuery(name = "Emo.findByGenitales", query = "SELECT e FROM Emo e WHERE e.genitales = :genitales"),
    @NamedQuery(name = "Emo.findByLasegue", query = "SELECT e FROM Emo e WHERE e.lasegue = :lasegue"),
    @NamedQuery(name = "Emo.findByLimitacionFuncional", query = "SELECT e FROM Emo e WHERE e.limitacionFuncional = :limitacionFuncional"),
    @NamedQuery(name = "Emo.findByMarchaPuntas", query = "SELECT e FROM Emo e WHERE e.marchaPuntas = :marchaPuntas"),
    @NamedQuery(name = "Emo.findByMarchaTalones", query = "SELECT e FROM Emo e WHERE e.marchaTalones = :marchaTalones"),
    @NamedQuery(name = "Emo.findByMiembrosInf", query = "SELECT e FROM Emo e WHERE e.miembrosInf = :miembrosInf"),
    @NamedQuery(name = "Emo.findByMiembrosSup", query = "SELECT e FROM Emo e WHERE e.miembrosSup = :miembrosSup"),
    @NamedQuery(name = "Emo.findByOidos", query = "SELECT e FROM Emo e WHERE e.oidos = :oidos"),
    @NamedQuery(name = "Emo.findByOjos", query = "SELECT e FROM Emo e WHERE e.ojos = :ojos"),
    @NamedQuery(name = "Emo.findByPanel", query = "SELECT e FROM Emo e WHERE e.panel = :panel"),
    @NamedQuery(name = "Emo.findByPiel", query = "SELECT e FROM Emo e WHERE e.piel = :piel"),
    @NamedQuery(name = "Emo.findByPulmones", query = "SELECT e FROM Emo e WHERE e.pulmones = :pulmones"),
    @NamedQuery(name = "Emo.findByRodillasDos", query = "SELECT e FROM Emo e WHERE e.rodillasDos = :rodillasDos"),
    @NamedQuery(name = "Emo.findBySilla", query = "SELECT e FROM Emo e WHERE e.silla = :silla"),
    @NamedQuery(name = "Emo.findByTinel", query = "SELECT e FROM Emo e WHERE e.tinel = :tinel"),
    @NamedQuery(name = "Emo.findByTrabajoAlturas", query = "SELECT e FROM Emo e WHERE e.trabajoAlturas = :trabajoAlturas"),
    @NamedQuery(name = "Emo.findByPruebasVestibular", query = "SELECT e FROM Emo e WHERE e.pruebasVestibular = :pruebasVestibular")})
public class Emo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_emo")
    private Integer idEmo;
    @Column(name = "restricciones_lab")
    private Boolean restriccionesLab;
    @Size(max = 200)
    @Column(name = "cuales_uno")
    private String cualesUno;
    @Column(name = "ant_fam")
    private String antFam;
    @Column(name = "hipertension")
    private Boolean hipertension;
    @Column(name = "diabetes")
    private Boolean diabetes;
    @Column(name = "asma")
    private Boolean asma;
    @Column(name = "cardiovasculares")
    private Boolean cardiovasculares;
    @Column(name = "psiquiatricos")
    private Boolean psiquiatricos;
    @Column(name = "epilepsia")
    private Boolean epilepsia;
    @Column(name = "visuales")
    private Boolean visuales;
    @Column(name = "respiratorias")
    private Boolean respiratorias;
    @Column(name = "dermatologicos")
    private Boolean dermatologicos;
    @Column(name = "reumatologicos")
    private Boolean reumatologicos;
    @Column(name = "neurologicos")
    private Boolean neurologicos;
    @Column(name = "varices")
    private Boolean varices;
    @Column(name = "cancer")
    private Boolean cancer;
    @Column(name = "hipotiroidismo")
    private Boolean hipotiroidismo;
    @Column(name = "alergicos")
    private Boolean alergicos;
    @Column(name = "quimicos")
    private Boolean quimicos;
    @Column(name = "traumaticos")
    private Boolean traumaticos;
    @Column(name = "fumas")
    private Boolean fumas;
    @Column(name = "cuantos")
    private Integer cuantos;
    @Size(max = 45)
    @Column(name = "tiempo_hace_cuanto")
    private String tiempoHaceCuanto;
    @Column(name = "exfumador")
    private Boolean exfumador;
    @Column(name = "licor")
    private Boolean licor;
    @Column(name = "habitual")
    private Boolean habitual;
    @Column(name = "deporte")
    private Boolean deporte;
    @Size(max = 100)
    @Column(name = "que_deporte")
    private String queDeporte;
    @Size(max = 25)
    @Column(name = "cuantas_veces_semana")
    private String cuantasVecesSemana;
    @Column(name = "manualidades")
    private Boolean manualidades;
    @Size(max = 100)
    @Column(name = "cuales_dos")
    private String cualesDos;
    @Size(max = 45)
    @Column(name = "meranea")
    private String meranea;
    @Column(name = "gravida")
    private Integer gravida;
    @Column(name = "partos")
    private Integer partos;
    @Column(name = "cesareas")
    private Integer cesareas;
    @Column(name = "abortos")
    private Integer abortos;
    @Column(name = "hijos_vivos")
    private Integer hijosVivos;
    @Column(name = "fecha_ultima_menst")
    @Temporal(TemporalType.DATE)
    private Date fechaUltimaMenst;
    @Column(name = "citologia")
    @Temporal(TemporalType.DATE)
    private Date citologia;
    @Size(max = 45)
    @Column(name = "ciclos")
    private String ciclos;
    @Column(name = "sint_osteom")
    private Boolean sintOsteom;
    @Column(name = "codos")
    private Boolean codos;
    @Column(name = "cadera")
    private Boolean cadera;
    @Column(name = "cervical")
    private Boolean cervical;
    @Column(name = "cuello_uno")
    private Boolean cuelloUno;
    @Column(name = "dedos")
    private Boolean dedos;
    @Column(name = "dorsal")
    private Boolean dorsal;
    @Column(name = "dorsolumbar")
    private Boolean dorsolumbar;
    @Column(name = "hombros")
    private Boolean hombros;
    @Column(name = "lumbosacra")
    private Boolean lumbosacra;
    @Column(name = "manos")
    private Boolean manos;
    @Column(name = "muniecas")
    private Boolean muniecas;
    @Column(name = "pies")
    private Boolean pies;
    @Column(name = "rodillas_uno")
    private Boolean rodillasUno;
    @Size(max = 1000)
    @Column(name = "desc_osteom")
    private String descOsteom;
    @Size(max = 450)
    @Column(name = "otros")
    private String otros;
    @Column(name = "revision_sistemas")
    private Boolean revisionSistemas;
    @Size(max = 45)
    @Column(name = "desc_siste")
    private String descSiste;
    @Size(max = 450)
    @Column(name = "apariencia")
    private String apariencia;
    @Size(max = 45)
    @Column(name = "dominancia")
    private String dominancia;
    @Size(max = 45)
    @Column(name = "peso")
    private String peso;
    @Size(max = 45)
    @Column(name = "talla")
    private String talla;
    @Column(name = "imc")
    private Integer imc;
    @Column(name = "tas")
    private Integer tas;
    @Column(name = "pres_sist")
    private Integer presSist;
    @Column(name = "tad")
    private Integer tad;
    @Column(name = "fc")
    private Integer fc;
    @Column(name = "fr")
    private Integer fr;
    @Column(name = "it")
    private Integer it;
    @Size(max = 45)
    @Column(name = "abdomen")
    private String abdomen;
    @Column(name = "hernias")
    private Boolean hernias;
    @Size(max = 45)
    @Column(name = "arco_movilidad_art")
    private String arcoMovilidadArt;
    @Size(max = 45)
    @Column(name = "boca")
    private String boca;
    @Column(name = "cica_tatu")
    private Boolean cicaTatu;
    @Size(max = 45)
    @Column(name = "colum_cerv")
    private String columCerv;
    @Size(max = 45)
    @Column(name = "colum_lumbo")
    private String columLumbo;
    @Size(max = 45)
    @Column(name = "colum_tora")
    private String columTora;
    @Size(max = 45)
    @Column(name = "colum_vertebral")
    private String columVertebral;
    @Size(max = 45)
    @Column(name = "corazon")
    private String corazon;
    @Size(max = 45)
    @Column(name = "cuello_dos")
    private String cuelloDos;
    @Size(max = 45)
    @Column(name = "filkenstein")
    private String filkenstein;
    @Size(max = 45)
    @Column(name = "genitales")
    private String genitales;
    @Size(max = 45)
    @Column(name = "lasegue")
    private String lasegue;
    @Size(max = 45)
    @Column(name = "limitacion_funcional")
    private String limitacionFuncional;
    @Size(max = 45)
    @Column(name = "marcha_puntas")
    private String marchaPuntas;
    @Size(max = 45)
    @Column(name = "marcha_talones")
    private String marchaTalones;
    @Size(max = 45)
    @Column(name = "miembros_inf")
    private String miembrosInf;
    @Size(max = 45)
    @Column(name = "miembros_sup")
    private String miembrosSup;
    @Size(max = 45)
    @Column(name = "oidos")
    private String oidos;
    @Size(max = 45)
    @Column(name = "ojos")
    private String ojos;
    @Size(max = 45)
    @Column(name = "panel")
    private String panel;
    @Size(max = 45)
    @Column(name = "piel")
    private String piel;
    @Size(max = 45)
    @Column(name = "pulmones")
    private String pulmones;
    @Size(max = 45)
    @Column(name = "rodillas_dos")
    private String rodillasDos;
    @Size(max = 45)
    @Column(name = "silla")
    private String silla;
    @Size(max = 45)
    @Column(name = "tinel")
    private String tinel;
    @Size(max = 45)
    @Column(name = "trabajo_alturas")
    private String trabajoAlturas;
    @Column(name = "pruebas_vestibular")
    private Boolean pruebasVestibular;
    @JoinColumn(name = "id_paciente", referencedColumnName = "id_paciente")
    @ManyToOne(optional = false)
    private Pacientes idPaciente;

    public Emo() {
    }

    public Emo(Integer idEmo) {
        this.idEmo = idEmo;
    }

    public Integer getIdEmo() {
        return idEmo;
    }

    public void setIdEmo(Integer idEmo) {
        this.idEmo = idEmo;
    }
    
    public Boolean getRestriccionesLab() {
        return restriccionesLab;
    }

    public void setRestriccionesLab(Boolean restriccionesLab) {
        this.restriccionesLab = restriccionesLab;
    }

    public String getCualesUno() {
        return cualesUno;
    }

    public void setCualesUno(String cualesUno) {
        this.cualesUno = cualesUno;
    }

    public String getAntFam() {
        return antFam;
    }

    public void setAntFam(String antFam) {
        this.antFam = antFam;
    }

    public Boolean getHipertension() {
        return hipertension;
    }

    public void setHipertension(Boolean hipertension) {
        this.hipertension = hipertension;
    }

    public Boolean getDiabetes() {
        return diabetes;
    }

    public void setDiabetes(Boolean diabetes) {
        this.diabetes = diabetes;
    }

    public Boolean getAsma() {
        return asma;
    }

    public void setAsma(Boolean asma) {
        this.asma = asma;
    }

    public Boolean getCardiovasculares() {
        return cardiovasculares;
    }

    public void setCardiovasculares(Boolean cardiovasculares) {
        this.cardiovasculares = cardiovasculares;
    }

    public Boolean getPsiquiatricos() {
        return psiquiatricos;
    }

    public void setPsiquiatricos(Boolean psiquiatricos) {
        this.psiquiatricos = psiquiatricos;
    }

    public Boolean getEpilepsia() {
        return epilepsia;
    }

    public void setEpilepsia(Boolean epilepsia) {
        this.epilepsia = epilepsia;
    }

    public Boolean getVisuales() {
        return visuales;
    }

    public void setVisuales(Boolean visuales) {
        this.visuales = visuales;
    }

    public Boolean getRespiratorias() {
        return respiratorias;
    }

    public void setRespiratorias(Boolean respiratorias) {
        this.respiratorias = respiratorias;
    }

    public Boolean getDermatologicos() {
        return dermatologicos;
    }

    public void setDermatologicos(Boolean dermatologicos) {
        this.dermatologicos = dermatologicos;
    }

    public Boolean getReumatologicos() {
        return reumatologicos;
    }

    public void setReumatologicos(Boolean reumatologicos) {
        this.reumatologicos = reumatologicos;
    }

    public Boolean getNeurologicos() {
        return neurologicos;
    }

    public void setNeurologicos(Boolean neurologicos) {
        this.neurologicos = neurologicos;
    }

    public Boolean getVarices() {
        return varices;
    }

    public void setVarices(Boolean varices) {
        this.varices = varices;
    }

    public Boolean getCancer() {
        return cancer;
    }

    public void setCancer(Boolean cancer) {
        this.cancer = cancer;
    }

    public Boolean getHipotiroidismo() {
        return hipotiroidismo;
    }

    public void setHipotiroidismo(Boolean hipotiroidismo) {
        this.hipotiroidismo = hipotiroidismo;
    }

    public Boolean getAlergicos() {
        return alergicos;
    }

    public void setAlergicos(Boolean alergicos) {
        this.alergicos = alergicos;
    }

    public Boolean getQuimicos() {
        return quimicos;
    }

    public void setQuimicos(Boolean quimicos) {
        this.quimicos = quimicos;
    }

    public Boolean getTraumaticos() {
        return traumaticos;
    }

    public void setTraumaticos(Boolean traumaticos) {
        this.traumaticos = traumaticos;
    }

    public Boolean getFumas() {
        return fumas;
    }

    public void setFumas(Boolean fumas) {
        this.fumas = fumas;
    }

    public Integer getCuantos() {
        return cuantos;
    }

    public void setCuantos(Integer cuantos) {
        this.cuantos = cuantos;
    }

    public String getTiempoHaceCuanto() {
        return tiempoHaceCuanto;
    }

    public void setTiempoHaceCuanto(String tiempoHaceCuanto) {
        this.tiempoHaceCuanto = tiempoHaceCuanto;
    }

    public Boolean getExfumador() {
        return exfumador;
    }

    public void setExfumador(Boolean exfumador) {
        this.exfumador = exfumador;
    }

    public Boolean getLicor() {
        return licor;
    }

    public void setLicor(Boolean licor) {
        this.licor = licor;
    }

    public Boolean getHabitual() {
        return habitual;
    }

    public void setHabitual(Boolean habitual) {
        this.habitual = habitual;
    }

    public Boolean getDeporte() {
        return deporte;
    }

    public void setDeporte(Boolean deporte) {
        this.deporte = deporte;
    }

    public String getQueDeporte() {
        return queDeporte;
    }

    public void setQueDeporte(String queDeporte) {
        this.queDeporte = queDeporte;
    }

    public String getCuantasVecesSemana() {
        return cuantasVecesSemana;
    }

    public void setCuantasVecesSemana(String cuantasVecesSemana) {
        this.cuantasVecesSemana = cuantasVecesSemana;
    }

    public Boolean getManualidades() {
        return manualidades;
    }

    public void setManualidades(Boolean manualidades) {
        this.manualidades = manualidades;
    }

    public String getCualesDos() {
        return cualesDos;
    }

    public void setCualesDos(String cualesDos) {
        this.cualesDos = cualesDos;
    }

    public String getMeranea() {
        return meranea;
    }

    public void setMeranea(String meranea) {
        this.meranea = meranea;
    }

    public Integer getGravida() {
        return gravida;
    }

    public void setGravida(Integer gravida) {
        this.gravida = gravida;
    }

    public Integer getPartos() {
        return partos;
    }

    public void setPartos(Integer partos) {
        this.partos = partos;
    }

    public Integer getCesareas() {
        return cesareas;
    }

    public void setCesareas(Integer cesareas) {
        this.cesareas = cesareas;
    }

    public Integer getAbortos() {
        return abortos;
    }

    public void setAbortos(Integer abortos) {
        this.abortos = abortos;
    }

    public Integer getHijosVivos() {
        return hijosVivos;
    }

    public void setHijosVivos(Integer hijosVivos) {
        this.hijosVivos = hijosVivos;
    }

    public Date getFechaUltimaMenst() {
        return fechaUltimaMenst;
    }

    public void setFechaUltimaMenst(Date fechaUltimaMenst) {
        this.fechaUltimaMenst = fechaUltimaMenst;
    }

    public Date getCitologia() {
        return citologia;
    }

    public void setCitologia(Date citologia) {
        this.citologia = citologia;
    }

    public String getCiclos() {
        return ciclos;
    }

    public void setCiclos(String ciclos) {
        this.ciclos = ciclos;
    }

    public Boolean getSintOsteom() {
        return sintOsteom;
    }

    public void setSintOsteom(Boolean sintOsteom) {
        this.sintOsteom = sintOsteom;
    }

    public Boolean getCodos() {
        return codos;
    }

    public void setCodos(Boolean codos) {
        this.codos = codos;
    }

    public Boolean getCadera() {
        return cadera;
    }

    public void setCadera(Boolean cadera) {
        this.cadera = cadera;
    }

    public Boolean getCervical() {
        return cervical;
    }

    public void setCervical(Boolean cervical) {
        this.cervical = cervical;
    }

    public Boolean getCuelloUno() {
        return cuelloUno;
    }

    public void setCuelloUno(Boolean cuelloUno) {
        this.cuelloUno = cuelloUno;
    }

    public Boolean getDedos() {
        return dedos;
    }

    public void setDedos(Boolean dedos) {
        this.dedos = dedos;
    }

    public Boolean getDorsal() {
        return dorsal;
    }

    public void setDorsal(Boolean dorsal) {
        this.dorsal = dorsal;
    }

    public Boolean getDorsolumbar() {
        return dorsolumbar;
    }

    public void setDorsolumbar(Boolean dorsolumbar) {
        this.dorsolumbar = dorsolumbar;
    }

    public Boolean getHombros() {
        return hombros;
    }

    public void setHombros(Boolean hombros) {
        this.hombros = hombros;
    }

    public Boolean getLumbosacra() {
        return lumbosacra;
    }

    public void setLumbosacra(Boolean lumbosacra) {
        this.lumbosacra = lumbosacra;
    }

    public Boolean getManos() {
        return manos;
    }

    public void setManos(Boolean manos) {
        this.manos = manos;
    }

    public Boolean getMuniecas() {
        return muniecas;
    }

    public void setMuniecas(Boolean muniecas) {
        this.muniecas = muniecas;
    }

    public Boolean getPies() {
        return pies;
    }

    public void setPies(Boolean pies) {
        this.pies = pies;
    }

    public Boolean getRodillasUno() {
        return rodillasUno;
    }

    public void setRodillasUno(Boolean rodillasUno) {
        this.rodillasUno = rodillasUno;
    }

    public String getDescOsteom() {
        return descOsteom;
    }

    public void setDescOsteom(String descOsteom) {
        this.descOsteom = descOsteom;
    }

    public String getOtros() {
        return otros;
    }

    public void setOtros(String otros) {
        this.otros = otros;
    }

    public Boolean getRevisionSistemas() {
        return revisionSistemas;
    }

    public void setRevisionSistemas(Boolean revisionSistemas) {
        this.revisionSistemas = revisionSistemas;
    }

    public String getDescSiste() {
        return descSiste;
    }

    public void setDescSiste(String descSiste) {
        this.descSiste = descSiste;
    }

    public String getApariencia() {
        return apariencia;
    }

    public void setApariencia(String apariencia) {
        this.apariencia = apariencia;
    }

    public String getDominancia() {
        return dominancia;
    }

    public void setDominancia(String dominancia) {
        this.dominancia = dominancia;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public Integer getImc() {
        return imc;
    }

    public void setImc(Integer imc) {
        this.imc = imc;
    }

    public Integer getTas() {
        return tas;
    }

    public void setTas(Integer tas) {
        this.tas = tas;
    }

    public Integer getPresSist() {
        return presSist;
    }

    public void setPresSist(Integer presSist) {
        this.presSist = presSist;
    }

    public Integer getTad() {
        return tad;
    }

    public void setTad(Integer tad) {
        this.tad = tad;
    }

    public Integer getFc() {
        return fc;
    }

    public void setFc(Integer fc) {
        this.fc = fc;
    }

    public Integer getFr() {
        return fr;
    }

    public void setFr(Integer fr) {
        this.fr = fr;
    }

    public Integer getIt() {
        return it;
    }

    public void setIt(Integer it) {
        this.it = it;
    }

    public String getAbdomen() {
        return abdomen;
    }

    public void setAbdomen(String abdomen) {
        this.abdomen = abdomen;
    }

    public Boolean getHernias() {
        return hernias;
    }

    public void setHernias(Boolean hernias) {
        this.hernias = hernias;
    }

    public String getArcoMovilidadArt() {
        return arcoMovilidadArt;
    }

    public void setArcoMovilidadArt(String arcoMovilidadArt) {
        this.arcoMovilidadArt = arcoMovilidadArt;
    }

    public String getBoca() {
        return boca;
    }

    public void setBoca(String boca) {
        this.boca = boca;
    }

    public Boolean getCicaTatu() {
        return cicaTatu;
    }

    public void setCicaTatu(Boolean cicaTatu) {
        this.cicaTatu = cicaTatu;
    }

    public String getColumCerv() {
        return columCerv;
    }

    public void setColumCerv(String columCerv) {
        this.columCerv = columCerv;
    }

    public String getColumLumbo() {
        return columLumbo;
    }

    public void setColumLumbo(String columLumbo) {
        this.columLumbo = columLumbo;
    }

    public String getColumTora() {
        return columTora;
    }

    public void setColumTora(String columTora) {
        this.columTora = columTora;
    }

    public String getColumVertebral() {
        return columVertebral;
    }

    public void setColumVertebral(String columVertebral) {
        this.columVertebral = columVertebral;
    }

    public String getCorazon() {
        return corazon;
    }

    public void setCorazon(String corazon) {
        this.corazon = corazon;
    }

    public String getCuelloDos() {
        return cuelloDos;
    }

    public void setCuelloDos(String cuelloDos) {
        this.cuelloDos = cuelloDos;
    }

    public String getFilkenstein() {
        return filkenstein;
    }

    public void setFilkenstein(String filkenstein) {
        this.filkenstein = filkenstein;
    }

    public String getGenitales() {
        return genitales;
    }

    public void setGenitales(String genitales) {
        this.genitales = genitales;
    }

    public String getLasegue() {
        return lasegue;
    }

    public void setLasegue(String lasegue) {
        this.lasegue = lasegue;
    }

    public String getLimitacionFuncional() {
        return limitacionFuncional;
    }

    public void setLimitacionFuncional(String limitacionFuncional) {
        this.limitacionFuncional = limitacionFuncional;
    }

    public String getMarchaPuntas() {
        return marchaPuntas;
    }

    public void setMarchaPuntas(String marchaPuntas) {
        this.marchaPuntas = marchaPuntas;
    }

    public String getMarchaTalones() {
        return marchaTalones;
    }

    public void setMarchaTalones(String marchaTalones) {
        this.marchaTalones = marchaTalones;
    }

    public String getMiembrosInf() {
        return miembrosInf;
    }

    public void setMiembrosInf(String miembrosInf) {
        this.miembrosInf = miembrosInf;
    }

    public String getMiembrosSup() {
        return miembrosSup;
    }

    public void setMiembrosSup(String miembrosSup) {
        this.miembrosSup = miembrosSup;
    }

    public String getOidos() {
        return oidos;
    }

    public void setOidos(String oidos) {
        this.oidos = oidos;
    }

    public String getOjos() {
        return ojos;
    }

    public void setOjos(String ojos) {
        this.ojos = ojos;
    }

    public String getPanel() {
        return panel;
    }

    public void setPanel(String panel) {
        this.panel = panel;
    }

    public String getPiel() {
        return piel;
    }

    public void setPiel(String piel) {
        this.piel = piel;
    }

    public String getPulmones() {
        return pulmones;
    }

    public void setPulmones(String pulmones) {
        this.pulmones = pulmones;
    }

    public String getRodillasDos() {
        return rodillasDos;
    }

    public void setRodillasDos(String rodillasDos) {
        this.rodillasDos = rodillasDos;
    }

    public String getSilla() {
        return silla;
    }

    public void setSilla(String silla) {
        this.silla = silla;
    }

    public String getTinel() {
        return tinel;
    }

    public void setTinel(String tinel) {
        this.tinel = tinel;
    }

    public String getTrabajoAlturas() {
        return trabajoAlturas;
    }

    public void setTrabajoAlturas(String trabajoAlturas) {
        this.trabajoAlturas = trabajoAlturas;
    }

    public Boolean getPruebasVestibular() {
        return pruebasVestibular;
    }

    public void setPruebasVestibular(Boolean pruebasVestibular) {
        this.pruebasVestibular = pruebasVestibular;
    }

    public Pacientes getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Pacientes idPaciente) {
        this.idPaciente = idPaciente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEmo != null ? idEmo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Emo)) {
            return false;
        }
        Emo other = (Emo) object;
        if ((this.idEmo == null && other.idEmo != null) || (this.idEmo != null && !this.idEmo.equals(other.idEmo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Emo[ idEmo=" + idEmo + " ]";
    }
    
}
