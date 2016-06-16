package controllers;

import entities.AccTraEnfLab;
import controllers.util.JsfUtil;
import controllers.util.JsfUtil.PersistAction;
import sessions.AccTraEnfLabFacade;

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

@Named("accTraEnfLabController")
@SessionScoped
public class AccTraEnfLabController implements Serializable {

    @EJB
    private sessions.AccTraEnfLabFacade ejbFacade;
    private List<AccTraEnfLab> items = null;
    private AccTraEnfLab selected;

    public AccTraEnfLabController() {
    }

    public AccTraEnfLab getSelected() {
        return selected;
    }

    public void setSelected(AccTraEnfLab selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private AccTraEnfLabFacade getFacade() {
        return ejbFacade;
    }

    public AccTraEnfLab prepareCreate() {
        selected = new AccTraEnfLab();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("AccTraEnfLabCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("AccTraEnfLabUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("AccTraEnfLabDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<AccTraEnfLab> getItems() {
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

    public AccTraEnfLab getAccTraEnfLab(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<AccTraEnfLab> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<AccTraEnfLab> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = AccTraEnfLab.class)
    public static class AccTraEnfLabControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            AccTraEnfLabController controller = (AccTraEnfLabController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "accTraEnfLabController");
            return controller.getAccTraEnfLab(getKey(value));
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
            if (object instanceof AccTraEnfLab) {
                AccTraEnfLab o = (AccTraEnfLab) object;
                return getStringKey(o.getIdAtel());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), AccTraEnfLab.class.getName()});
                return null;
            }
        }

    }

}
