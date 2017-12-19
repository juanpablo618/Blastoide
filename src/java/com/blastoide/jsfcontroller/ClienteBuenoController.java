package com.blastoide.jsfcontroller;

import com.blastoide.jsf.ClienteBueno;
import com.blastoide.jsfcontroller.util.JsfUtil;
import com.blastoide.jsfcontroller.util.JsfUtil.PersistAction;
import com.blastoide.jpa.ClienteBuenoFacade;

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

@Named("clienteBuenoController")
@SessionScoped
public class ClienteBuenoController implements Serializable {

    @EJB
    private com.blastoide.jpa.ClienteBuenoFacade ejbFacade;
    private List<ClienteBueno> items = null;
    private ClienteBueno selected;

    
    public ClienteBuenoController() {
    }

    public ClienteBueno getSelected() {
        return selected;
    }

    public void setSelected(ClienteBueno selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private ClienteBuenoFacade getFacade() {
        return ejbFacade;
    }

    public ClienteBueno prepareCreate() {
        selected = new ClienteBueno();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("ClienteBuenoCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("ClienteBuenoUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("ClienteBuenoDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<ClienteBueno> getItems() {
            items = getFacade().findAll();
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

    public ClienteBueno getClienteBueno(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<ClienteBueno> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<ClienteBueno> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = ClienteBueno.class)
    public static class ClienteBuenoControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ClienteBuenoController controller = (ClienteBuenoController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "clienteBuenoController");
            return controller.getClienteBueno(getKey(value));
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
            if (object instanceof ClienteBueno) {
                ClienteBueno o = (ClienteBueno) object;
                return getStringKey(o.getClienteID());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), ClienteBueno.class.getName()});
                return null;
            }
        }

    }
    
    
    
    

}
