package com.blastoide.jsfcontroller;

import com.blastoide.jsf.ProductoXProveedor;
import com.blastoide.jsf.Productos;
import com.blastoide.jsf.Proveedores;

import com.blastoide.jsfcontroller.util.JsfUtil;
import com.blastoide.jsfcontroller.util.JsfUtil.PersistAction;
import com.blastoide.jpa.ProductoXProveedorFacade;

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

@Named("productoXProveedorController")
@SessionScoped
public class ProductoXProveedorController implements Serializable {

    @EJB
    private com.blastoide.jpa.ProductoXProveedorFacade ejbFacade;
    private List<ProductoXProveedor> items = null;
    private ProductoXProveedor selected;

    private List<ProductoXProveedor> filteredItems;

    private Productos producto = new Productos();
    
    private Proveedores proveedor = new Proveedores();
    
    private String productoCodigo = "";
    
    private String proveedorNombre = "";
    
    private String productoID;
    
    public ProductoXProveedorController() {
    }

    public String getProductoCodigo() {
        return productoCodigo;
    }

    public void setProductoCodigo(String productoCodigo) {
        this.productoCodigo = productoCodigo;
    }

    public String getProveedorNombre() {
        return proveedorNombre;
    }

    public void setProveedorNombre(String proveedorNombre) {
        this.proveedorNombre = proveedorNombre;
    }
    public String getProductoID() {
        return productoID;
    }

    public void setProductoID(String productoID) {
        this.productoID = productoID;
    }

    public Proveedores getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedores proveedor) {
        this.proveedor = proveedor;
    }

    
    
    public Productos getProducto() {
        return producto;
    }

    public void setProducto(Productos producto) {
        this.producto = producto;
    }

    public List<ProductoXProveedor> getFilteredItems() {
        return filteredItems;
    }

    public void setFilteredItems(List<ProductoXProveedor> filteredItems) {
        this.filteredItems = filteredItems;
    }
    
    public ProductoXProveedor getSelected() {
        return selected;
    }

    public void setSelected(ProductoXProveedor selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private ProductoXProveedorFacade getFacade() {
        return ejbFacade;
    }

    public ProductoXProveedor prepareCreate() {
        selected = new ProductoXProveedor();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("ProductoXProveedorCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("ProductoXProveedorUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("ProductoXProveedorDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<ProductoXProveedor> getItems() {
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

    public ProductoXProveedor getProductoXProveedor(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<ProductoXProveedor> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<ProductoXProveedor> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = ProductoXProveedor.class)
    public static class ProductoXProveedorControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ProductoXProveedorController controller = (ProductoXProveedorController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "productoXProveedorController");
            return controller.getProductoXProveedor(getKey(value));
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
            if (object instanceof ProductoXProveedor) {
                ProductoXProveedor o = (ProductoXProveedor) object;
                return getStringKey(o.getProductoXProveedorID());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), ProductoXProveedor.class.getName()});
                return null;
            }
        }

    }
    
    public void filtrarPorProductoOPorProveedor(){
        filteredItems = new ArrayList<>();
        
        System.out.println("Entro al metodo filtrarPorProductoOPorProveedor");
        
        if(producto == null && proveedor == null){

                    filteredItems = items;
                      
        }else{
                
                if(producto == null && proveedor != null){
                      
                      for(int i = 0; i<items.size();i++){
                          if(proveedor.getProveedorID() == items.get(i).getProveedorID()){
                          filteredItems.add(items.get(i));
                          }
                      }
                     proveedor = null; 
                }else{
                    if(proveedor == null&& producto != null){
                            
                            for(int i = 0; i<items.size();i++){
                              if(producto.getProductoID() == items.get(i).getProductoID()){
                              filteredItems.add(items.get(i));
                                }
                            }
                        producto = null;
                    }else{
                            
                        for(int i = 0; i<items.size();i++){
                                if(producto.getProductoID() == items.get(i).getProductoID() && proveedor.getProveedorID() == items.get(i).getProveedorID()){
                                      filteredItems.add(items.get(i));
                                }
                        }
                        producto = null;
                        proveedor= null;
                    }
                }
        }
    }
    
    public void filtrarPorProducto(){
        filteredItems = new ArrayList<>();
        
        if(producto != null){
            
                    for(int i = 0; i<items.size();i++){
                        if(producto.getProductoID() == items.get(i).getProductoID()){
                            filteredItems.add(items.get(i));
                        }
                    }
        }else{
            filteredItems = items;
        }
    }
    
        public void filtrarPorProveedor(){
        filteredItems = new ArrayList<>();
                if(proveedor != null){

                 for(int i = 0; i<items.size();i++){

                            if(proveedor.getProveedorID()== items.get(i).getProveedorID()){
                                filteredItems.add(items.get(i));
                            }
                        }
                
                }else{
                    filteredItems = items;
                }
        }
 
     public List FiltrarPorProductoYProveedor (String productoCodigo){
        filteredItems = new ArrayList<>();
     
        FacesContext context = FacesContext.getCurrentInstance();
        
        
        ProductosController productosController = context.getApplication().evaluateExpressionGet(context, "#{productosController}", ProductosController.class);
        
                               String todos = "todos";
                         System.out.println("producto CODIGO:" +productoCodigo);
                        // System.out.println("proveedorNombre:" +proveedorNombre);
                          System.out.println("%%%%%%%%%%%%%%%%%%%%%%");
                             System.out.println("validacion: "+  productoCodigo.equals("todos"));
                             System.out.println("validacion 2: "+  productoCodigo.equalsIgnoreCase(todos));        
                        
                        System.out.println("validacion 3: "+  productoCodigo.isEmpty());        
                       
                        if(productoCodigo.equalsIgnoreCase(todos) || productoCodigo.isEmpty() ){
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("no se encontro nungun resultado"));
                           filteredItems = this.getItems();
                        return filteredItems;
                            
                        }else{
                            for(int i = 0; i<items.size();i++){
                            
                            if(productoCodigo.equals(productosController.getProductos(items.get(i).getProductoID()).getCodigo())){
                                System.out.println("entro al if !!!!");
                                filteredItems.add(items.get(i));
                            }
                          }
                        
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cantidad de resultados encontrados: "+filteredItems.size()));
                        return filteredItems;
                        }
                        
     }   
}