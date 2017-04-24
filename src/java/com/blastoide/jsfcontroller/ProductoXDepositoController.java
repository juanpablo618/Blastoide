package com.blastoide.jsfcontroller;

import com.blastoide.jsf.ProductoXDeposito;
import com.blastoide.jsfcontroller.util.JsfUtil;
import com.blastoide.jsfcontroller.util.JsfUtil.PersistAction;
import com.blastoide.jpa.ProductoXDepositoFacade;

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

@Named("productoXDepositoController")
@SessionScoped
public class ProductoXDepositoController implements Serializable {

    @EJB
    private com.blastoide.jpa.ProductoXDepositoFacade ejbFacade;
    private List<ProductoXDeposito> items = null;
    private ProductoXDeposito selected;

    public ProductoXDepositoController() {
    }

    public ProductoXDeposito getSelected() {
        return selected;
    }

    public void setSelected(ProductoXDeposito selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
        selected.getProductoXDepositoPK().setDepositoID(selected.getDepositos().getDepositoID());
        selected.getProductoXDepositoPK().setProductoID(selected.getProductos().getProductoID());
    }

    protected void initializeEmbeddableKey() {
        selected.setProductoXDepositoPK(new com.blastoide.jsf.ProductoXDepositoPK());
    }

    private ProductoXDepositoFacade getFacade() {
        return ejbFacade;
    }

    public ProductoXDeposito prepareCreate() {
        selected = new ProductoXDeposito();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("ProductoXDepositoCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("ProductoXDepositoUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("ProductoXDepositoDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<ProductoXDeposito> getItems() {
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

    public ProductoXDeposito getProductoXDeposito(com.blastoide.jsf.ProductoXDepositoPK id) {
        return getFacade().find(id);
    }

    public List<ProductoXDeposito> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<ProductoXDeposito> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = ProductoXDeposito.class)
    public static class ProductoXDepositoControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ProductoXDepositoController controller = (ProductoXDepositoController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "productoXDepositoController");
            return controller.getProductoXDeposito(getKey(value));
        }

        com.blastoide.jsf.ProductoXDepositoPK getKey(String value) {
            com.blastoide.jsf.ProductoXDepositoPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new com.blastoide.jsf.ProductoXDepositoPK();
            key.setDepositoID(Integer.parseInt(values[0]));
            key.setProductoID(Integer.parseInt(values[1]));
            return key;
        }

        String getStringKey(com.blastoide.jsf.ProductoXDepositoPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getDepositoID());
            sb.append(SEPARATOR);
            sb.append(value.getProductoID());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof ProductoXDeposito) {
                ProductoXDeposito o = (ProductoXDeposito) object;
                return getStringKey(o.getProductoXDepositoPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), ProductoXDeposito.class.getName()});
                return null;
            }
        }

    }

}
