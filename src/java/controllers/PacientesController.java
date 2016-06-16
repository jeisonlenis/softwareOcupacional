package controllers;

import entities.Pacientes;
import controllers.util.JsfUtil;
import controllers.util.JsfUtil.PersistAction;
import entities.AccTraEnfLab;
import entities.AntecedentesOcupacionales;
import entities.Emo;
import sessions.PacientesFacade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import sessions.AccTraEnfLabFacade;
import sessions.AntecedentesOcupacionalesFacade;
import sessions.EmoFacade;

@Named("pacientesController")
@SessionScoped
public class PacientesController implements Serializable {

    @EJB
    private sessions.PacientesFacade ejbFacade;
    @EJB
    private sessions.EmoFacade emoFacade;
    @EJB
    private sessions.AntecedentesOcupacionalesFacade antecedentesOcupacionalesFacade;
    private AntecedentesOcupacionalesFacade antecedenteFacade;

    private AccTraEnfLabFacade accidenteenfermedadFacade;

    private List<Emo> listEmo = null;
    private List<Pacientes> items = null;
    private List<AntecedentesOcupacionales> listAntecedentes = null;
    private List<AccTraEnfLab> listAccidenteenfermedad = null;
    private Emo examenActual;
    private Pacientes selected;

    private AntecedentesOcupacionales antecedenteActual;
    private AccTraEnfLab accidenteenfermedadActual;

    public PacientesController() {
    }

    public AntecedentesOcupacionales getAntecedenteActual() {
        return antecedenteActual;
    }

    public void setAntecedenteActual(AntecedentesOcupacionales selected) {
        this.antecedenteActual = selected;
    }

    public Pacientes getSelected() {
        return selected;
    }

    public void setSelected(Pacientes selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private PacientesFacade getFacade() {
        return ejbFacade;
    }

    public Pacientes prepareCreate() {
        selected = new Pacientes();
        initializeEmbeddableKey();
        return selected;
    }

    public String prepareCreateEmo() {
        examenActual = new Emo();
        antecedenteActual = new AntecedentesOcupacionales();
        initializeEmbeddableKey();
        listAntecedentes = new ArrayList<>();
        recargarListaEmo();
        return "/emo/Create2.xhtml";
    }

    public void agregarAntecedente() {
        listAntecedentes.add(antecedenteActual);
        antecedenteActual = new AntecedentesOcupacionales();
        initializeEmbeddableKey();
    }

    public void eliminarAntecedente() {
        listAntecedentes.remove(antecedenteActual);
    }

    public List<AntecedentesOcupacionales> getItemsAntecedentes() {
        return listAntecedentes;
    }

    public void agregarAntecedentes() {
        listAntecedentes.add(antecedenteActual);
        antecedenteActual = new AntecedentesOcupacionales();
        initializeEmbeddableKey();
    }

    public String addEmo() {
        try {
            examenActual.setIdPaciente(selected);
            antecedenteActual.setIdEmo(examenActual);
            getEmoFacade().create(examenActual);
            for (AntecedentesOcupacionales item : listAntecedentes) {
                antecedenteActual = item;
                antecedenteActual.setIdEmo(examenActual);
                persistAntecedente(PersistAction.CREATE, null);
            }
            update();
            recargarListaEmo();
            addSuccesMessage("Crear Examen", "Examen Creado Exitosamente");
        } catch (Exception e) {
            addErrorMessage("Error closing resource " + e.getClass().getName(), "Message: " + e.getMessage());
        }

        return "/emo/List.xhtml";
    }

    private void persistAntecedente(PersistAction persistAction, String successMessage) {
        if (antecedenteActual != null) {
            setEmbeddableKeys();
            try {
                if (persistAction == PersistAction.CREATE) {
                    getAntecedentesOcupacionalesFacade().create(antecedenteActual);
                } else if (persistAction == PersistAction.UPDATE) {
                    getAntecedentesOcupacionalesFacade().edit(antecedenteActual);
                } else {
                    getAntecedentesOcupacionalesFacade().remove(antecedenteActual);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/resources/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/resources/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    private void recargarListaEmo() {
        listEmo = null;
    }

    public List<Emo> getListEmo() {
        if (listEmo == null) {
            listEmo = getEmoFacade().findByPaciente(selected);
        }
        return listEmo;
    }

    public List<Emo> getListEmo(Pacientes paciente) {
        return getEmoFacade().findByPaciente(paciente);
    }

    public EmoFacade getEmoFacade() {
        return emoFacade;
    }

    public void create() {
        for (AntecedentesOcupacionales item : listAntecedentes) {
            antecedenteActual = item;
            antecedenteActual.setIdAntOcu(Integer.SIZE);
            persist(PersistAction.CREATE, null);
        }
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("PacientesUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("PacientesDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

//    public List<Emo> getListEmo() {
//        if (listEmo == null) {
//            listEmo = getEmoFacade().findByPaciente(selected);
//        }
//        return listEmo;
//    }
//
//    public List<Emo> getListEmo(Pacientes paciente) {
//        return getEmoFacade().findByPaciente(paciente);
//    }
    public List<Pacientes> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public Pacientes getPacientes(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Pacientes> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Pacientes> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    /**
     * @return the examenActual
     */
    public Emo getExamenActual() {
        return examenActual;
    }

    /**
     * @param examenActual the examenActual to set
     */
    public void setExamenActual(Emo examenActual) {
        this.examenActual = examenActual;
    }

    /**
     * @return the antecedentesOcupacionalesFacade
     */
    public sessions.AntecedentesOcupacionalesFacade getAntecedentesOcupacionalesFacade() {
        return antecedentesOcupacionalesFacade;
    }

    /**
     * @param antecedentesOcupacionalesFacade the
     * antecedentesOcupacionalesFacade to set
     */
    public void setAntecedentesOcupacionalesFacade(sessions.AntecedentesOcupacionalesFacade antecedentesOcupacionalesFacade) {
        this.antecedentesOcupacionalesFacade = antecedentesOcupacionalesFacade;
    }

    @FacesConverter(forClass = Pacientes.class)
    public static class PacientesControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            PacientesController controller = (PacientesController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "pacientesController");
            return controller.getPacientes(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Pacientes) {
                Pacientes o = (Pacientes) object;
                return getStringKey(o.getIdPaciente());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Pacientes.class.getName()});
                return null;
            }
        }

    }

    private void addErrorMessage(String title, String msg) {
        FacesMessage faceMsg
                = new FacesMessage(FacesMessage.SEVERITY_ERROR, title, msg);
        FacesContext.getCurrentInstance().addMessage(null, faceMsg);
    }

    private void addSuccesMessage(String title, String msg) {
        FacesMessage facesMessage
                = new FacesMessage(FacesMessage.SEVERITY_INFO, title, msg);
    }

}
