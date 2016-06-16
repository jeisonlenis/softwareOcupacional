package controllers;

import entities.Emo;
import controllers.util.JsfUtil;
import controllers.util.JsfUtil.PersistAction;
import entities.AccTraEnfLab;
import entities.AntecedentesOcupacionales;
import sessions.EmoFacade;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import sessions.AccTraEnfLabFacade;
import sessions.AntecedentesOcupacionalesFacade;

@Named("emoController")
@SessionScoped
public class EmoController implements Serializable {

    @EJB
    private sessions.EmoFacade ejbFacade;
    private AntecedentesOcupacionalesFacade antecedenteFacade;
    private AccTraEnfLabFacade accidenteenfermedadFacade;
    private List<Emo> items = null;
    private List<AntecedentesOcupacionales> listAntecedentes = null;
    private List<AccTraEnfLab> listAccidenteenfermedad = null;
    private Emo selected;
    private AntecedentesOcupacionales antecedenteActual;
    private AccTraEnfLab accidenteenfermedadActual;

    public EmoController() {
    }

    public Emo getSelected() {
        return selected;
    }

    public void setSelected(Emo selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private EmoFacade getFacade() {
        return ejbFacade;
    }

    public Emo prepareCreate() {
        selected = new Emo();
        initializeEmbeddableKey();
        return selected;
    }
    
    public String prepareCreate2() {
        selected = new Emo();
        initializeEmbeddableKey();
        return "/emo/Create2";
    }
//
//    public String prepareCreateEmo() {
//        examenActual = new Emo();
//        recargarListaEmo();
//        return "/emo/Create2.xhtml";
//    }
//    
//    public String addEmo() {
//        try {
//            examenActual.setIdPaciente(selected);
//            getEmoFacade().create(examenActual);
//            examenActual = new Emo();
//            update();
//            recargarListaEmo();
//            addSuccesMessage("Crear Examen", "Examen Creado Exitosamente");
//        } catch (Exception e) {
//            addErrorMessage("Error closing resource " + e.getClass().getName(), "Message: " + e.getMessage());
//        }
//        
//        return "/emo/List.xhtml";
//    }
//    
//    private void recargarListaEmo() {
//        listEmo = null;
//    }
//    
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
//    
//    public EmoFacade getEmoFacade() {
//        return emoFacade;
//    }
    
    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("EmoCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("EmoUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("EmoDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Emo> getItems() {
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

    public Emo getEmo(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Emo> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Emo> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Emo.class)
    public static class EmoControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            EmoController controller = (EmoController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "emoController");
            return controller.getEmo(getKey(value));
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
            if (object instanceof Emo) {
                Emo o = (Emo) object;
                return getStringKey(o.getIdEmo());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Emo.class.getName()});
                return null;
            }
        }

    }

}
