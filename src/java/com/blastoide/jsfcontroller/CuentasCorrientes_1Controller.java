package com.blastoide.jsfcontroller;

import com.blastoide.jsf.CuentasCorrientes_1;
import com.blastoide.jsfcontroller.util.JsfUtil;
import com.blastoide.jsfcontroller.util.JsfUtil.PersistAction;
import com.blastoide.jpa.CuentasCorrientes_1Facade;

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

@Named("cuentasCorrientes_1Controller")
@SessionScoped
public class CuentasCorrientes_1Controller implements Serializable {

    @EJB
    private com.blastoide.jpa.CuentasCorrientes_1Facade ejbFacade;
    private List<CuentasCorrientes_1> items = null;
    private CuentasCorrientes_1 selected;

    public CuentasCorrientes_1Controller() {
    }

    public CuentasCorrientes_1 getSelected() {
        return selected;
    }

    public void setSelected(CuentasCorrientes_1 selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private CuentasCorrientes_1Facade getFacade() {
        return ejbFacade;
    }

    public CuentasCorrientes_1 prepareCreate() {
        selected = new CuentasCorrientes_1();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("CuentasCorrientes_1Created"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("CuentasCorrientes_1Updated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("CuentasCorrientes_1Deleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<CuentasCorrientes_1> getItems() {
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

    public CuentasCorrientes_1 getCuentasCorrientes_1(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<CuentasCorrientes_1> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<CuentasCorrientes_1> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = CuentasCorrientes_1.class)
    public static class CuentasCorrientes_1ControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            CuentasCorrientes_1Controller controller = (CuentasCorrientes_1Controller) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "cuentasCorrientes_1Controller");
            return controller.getCuentasCorrientes_1(getKey(value));
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
            if (object instanceof CuentasCorrientes_1) {
                CuentasCorrientes_1 o = (CuentasCorrientes_1) object;
                return getStringKey(o.getCuentaCorrienteID());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), CuentasCorrientes_1.class.getName()});
                return null;
            }
        }

    }
}