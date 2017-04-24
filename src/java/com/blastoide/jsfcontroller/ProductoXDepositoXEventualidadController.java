package com.blastoide.jsfcontroller;

import com.blastoide.jsf.ProductoXDepositoXEventualidad;
import com.blastoide.jsfcontroller.util.JsfUtil;
import com.blastoide.jsfcontroller.util.JsfUtil.PersistAction;
import com.blastoide.jpa.ProductoXDepositoXEventualidadFacade;

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

@Named("productoXDepositoXEventualidadController")
@SessionScoped
public class ProductoXDepositoXEventualidadController implements Serializable {

    @EJB
    private com.blastoide.jpa.ProductoXDepositoXEventualidadFacade ejbFacade;
    private List<ProductoXDepositoXEventualidad> items = null;
    private ProductoXDepositoXEventualidad selected;

    public ProductoXDepositoXEventualidadController() {
    }

    public ProductoXDepositoXEventualidad getSelected() {
        return selected;
    }

    public void setSelected(ProductoXDepositoXEventualidad selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
        selected.getProductoXDepositoXEventualidadPK().setEventualidadID(selected.getEventualidades().getEventualidadID());
        selected.getProductoXDepositoXEventualidadPK().setProductoID(selected.getProductos().getProductoID());
        selected.getProductoXDepositoXEventualidadPK().setDepositoID(selected.getDepositos().getDepositoID());
    }

    protected void initializeEmbeddableKey() {
        selected.setProductoXDepositoXEventualidadPK(new com.blastoide.jsf.ProductoXDepositoXEventualidadPK());
    }

    private ProductoXDepositoXEventualidadFacade getFacade() {
        return ejbFacade;
    }

    public ProductoXDepositoXEventualidad prepareCreate() {
        selected = new ProductoXDepositoXEventualidad();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("ProductoXDepositoXEventualidadCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("ProductoXDepositoXEventualidadUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("ProductoXDepositoXEventualidadDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<ProductoXDepositoXEventualidad> getItems() {
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

    public ProductoXDepositoXEventualidad getProductoXDepositoXEventualidad(com.blastoide.jsf.ProductoXDepositoXEventualidadPK id) {
        return getFacade().find(id);
    }

    public List<ProductoXDepositoXEventualidad> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<ProductoXDepositoXEventualidad> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = ProductoXDepositoXEventualidad.class)
    public static class ProductoXDepositoXEventualidadControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ProductoXDepositoXEventualidadController controller = (ProductoXDepositoXEventualidadController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "productoXDepositoXEventualidadController");
            return controller.getProductoXDepositoXEventualidad(getKey(value));
        }

        com.blastoide.jsf.ProductoXDepositoXEventualidadPK getKey(String value) {
            com.blastoide.jsf.ProductoXDepositoXEventualidadPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new com.blastoide.jsf.ProductoXDepositoXEventualidadPK();
            key.setEventualidadID(Integer.parseInt(values[0]));
            key.setProductoID(Integer.parseInt(values[1]));
            key.setDepositoID(Integer.parseInt(values[2]));
            return key;
        }

        String getStringKey(com.blastoide.jsf.ProductoXDepositoXEventualidadPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getEventualidadID());
            sb.append(SEPARATOR);
            sb.append(value.getProductoID());
            sb.append(SEPARATOR);
            sb.append(value.getDepositoID());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof ProductoXDepositoXEventualidad) {
                ProductoXDepositoXEventualidad o = (ProductoXDepositoXEventualidad) object;
                return getStringKey(o.getProductoXDepositoXEventualidadPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), ProductoXDepositoXEventualidad.class.getName()});
                return null;
            }
        }

    }

}
