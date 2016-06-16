package controllers;

import entities.Empresas;
import controllers.util.JsfUtil;
import controllers.util.JsfUtil.PersistAction;
import entities.Pacientes;
import sessions.EmpresasFacade;

import java.io.Serializable;
import java.util.Date;
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
import sessions.PacientesFacade;

@Named("empresasController")
@SessionScoped
public class EmpresasController implements Serializable {

    @EJB
    private sessions.EmpresasFacade ejbFacade;
    @EJB
    private sessions.PacientesFacade pacientesFacade;
    private List<Empresas> items = null;
    private List<Pacientes> listPacientes = null;
    private Pacientes pacienteActual;
    private Empresas selected;

    public EmpresasController() {
    }

    public Empresas getSelected() {
        return selected;
    }

    public void setSelected(Empresas selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private EmpresasFacade getFacade() {
        return ejbFacade;
    }

    public Empresas prepareCreate() {
        selected = new Empresas();
        initializeEmbeddableKey();
        return selected;
    }
    
    public String prepareCreatePaciente() {
        pacienteActual = new Pacientes();
        recargarListaPacientes();
        return "/pacientes/Create2.xhtml";
    }
    
    public String addPaciente() {
        try {
            pacienteActual.setIdClem(selected);
            getPacientesFacade().create(pacienteActual);
            pacienteActual = new Pacientes();
            update();
            recargarListaPacientes();
            addSuccesMessage("Crear Examen", "Examen Creado Exitosamente");
        } catch (Exception e) {
            addErrorMessage("Error closing resource " + e.getClass().getName(), "Message: " + e.getMessage());
        }
        
        return "/pacientes/List.xhtml";
    }

    public String updatePaciente() {
        try {
            getPacientesFacade().edit(pacienteActual);
            recargarListaPacientes();
            addSuccesMessage("Actualizar Paciente", "Paciente Actualizado Exitosamente");
            return "View";
        } catch (Exception e) {
            addErrorMessage("Error closing resource " + e.getClass().getName(), "Message: " + e.getMessage());
            return null;
        }
    }
    
    private void recargarListaPacientes() {
        listPacientes = null;
    }
    
    public List<Pacientes> getListPacientes() {
        if (listPacientes == null) {
            listPacientes = getPacientesFacade().findByEmpresa(selected);
        }
        return listPacientes;
    }

    public List<Pacientes> getListPacientes(Empresas empresa) {
        return getPacientesFacade().findByEmpresa(empresa);
    }
    
    public PacientesFacade getPacientesFacade() {
        return pacientesFacade;
    }
    
    
    public Pacientes getPacienteActual() {
        return pacienteActual;
    }

    public void create() {
        selected.setFecCreClem(new Date());
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("EmpresasCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("EmpresasUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("EmpresasDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Empresas> getItems() {
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

    public Empresas getEmpresas(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Empresas> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Empresas> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Empresas.class)
    public static class EmpresasControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            EmpresasController controller = (EmpresasController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "empresasController");
            return controller.getEmpresas(getKey(value));
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
            if (object instanceof Empresas) {
                Empresas o = (Empresas) object;
                return getStringKey(o.getIdClem());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Empresas.class.getName()});
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
