package com.blastoide.jsfcontroller;

import com.blastoide.jpa.Caja;
import com.blastoide.jsfcontroller.util.JsfUtil;
import com.blastoide.jsfcontroller.util.JsfUtil.PersistAction;
import com.blastoide.jsf.CajaFacade;
import com.sun.javafx.scene.control.skin.VirtualFlow;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;


@Named("cajaController")
@SessionScoped
public class CajaController implements Serializable {

    @EJB
    private com.blastoide.jsf.CajaFacade ejbFacade;
    private List<Caja> items = null;
    private List<Caja> itemsFechaDeHoy = null;
    private Caja selected;
    private List<Caja> filteredCaja = null;
    private double ventaDiariaActual = 0;
    private double ventaDiariaActualSoloTarjetas = 0;
    
    public CajaController() {
    }

    
    
    public double getVentaDiariaActual() {
        
        SimpleDateFormat formDate = new SimpleDateFormat("dd/MM/yyyy");
        String fechaDeHoy = formDate.format(new Date()); 
            
        FacesContext context = FacesContext.getCurrentInstance();
        CajaController cajaController = context.getApplication().evaluateExpressionGet(context, "#{cajaController}", CajaController.class);
        
        double totalVentaDiarioSoloEfectivo = 0;
        double totalegresoDiario = 0;
        double totalDiario = 0;
        
        for(int index=0; index<=cajaController.getItems().size() - 1;index++){
         
            if(cajaController.getItems().get(index).getFecha()!=null){
                
                    if(cajaController.getItems().get(index).getFecha().equals(fechaDeHoy)){
                        if(cajaController.getItems().get(index).getDescripcion()!=null){        
                                    if(cajaController.getItems().get(index).getDescripcion().contains("Contado efectivo") || cajaController.getItems().get(index).getDescripcion().contains("Contado")){
                                      
                                        totalVentaDiarioSoloEfectivo = totalVentaDiarioSoloEfectivo + cajaController.getItems().get(index).getIngreso();
                                            
                                        }else{
                                            if(cajaController.getItems().get(index).getDescripcion().startsWith("Cliente:")){
                                                continue;
                                            }else{
                                                totalVentaDiarioSoloEfectivo = totalVentaDiarioSoloEfectivo + cajaController.getItems().get(index).getIngreso();
                                        
                                            }
                                        }
                                    }

                            if(cajaController.getItems().get(index).getFecha().equals(fechaDeHoy)){
                                if(cajaController.getItems().get(index).getEgreso()!=null){  
                                    totalegresoDiario = totalegresoDiario + cajaController.getItems().get(index).getEgreso();
                                }
                            }    
                    }
            }     
                    
        }
        System.out.println("totalVentaDiarioSoloEfectivo: "+ totalVentaDiarioSoloEfectivo);
        System.out.println("totalegresoDiario: "+ totalegresoDiario);

        totalDiario = totalVentaDiarioSoloEfectivo - totalegresoDiario;
        
        System.out.println("Total vendido hoy solo efectivo - totalegresoDiario: "+ totalDiario);
        setVentaDiariaActual(totalDiario);
        return ventaDiariaActual;
    }

    public double getVentaDiariaActualSoloTarjetas() {
   
        SimpleDateFormat formDate = new SimpleDateFormat("dd/MM/yyyy");
        String fechaDeHoy = formDate.format(new Date()); 
            
        FacesContext context = FacesContext.getCurrentInstance();
        CajaController cajaController = context.getApplication().evaluateExpressionGet(context, "#{cajaController}", CajaController.class);
        
        double totalVentaDiarioSoloTarjetas = 0;
        double totalegresoDiario = 0;
        double totalDiario = 0;
        for(int index=0; index<=cajaController.getItems().size() - 1;index++){
           
                if(cajaController.getItems().get(index).getFecha().equals(fechaDeHoy)){
                        if(cajaController.getItems().get(index).getDescripcion().contains("Tarjetas")){
                            if(cajaController.getItems().get(index).getIngreso()!=null){  
                                totalVentaDiarioSoloTarjetas = totalVentaDiarioSoloTarjetas + cajaController.getItems().get(index).getIngreso();
                            }
                        }
                }
                if(cajaController.getItems().get(index).getFecha().equals(fechaDeHoy)){
                    if(cajaController.getItems().get(index).getEgreso()!=null){  
                            totalegresoDiario = totalegresoDiario + cajaController.getItems().get(index).getEgreso();
                    }
                }
        }

        System.out.println("totalVentaDiarioSoloTarjetas: "+ totalVentaDiarioSoloTarjetas);
        System.out.println("totalegresoDiario: "+ totalegresoDiario);
        
        totalDiario = totalVentaDiarioSoloTarjetas - totalegresoDiario;
        
        System.out.println("Total vendido hoy solo tarjetas - totalDiario: "+ totalDiario);
        setVentaDiariaActualSoloTarjetas(totalDiario);
        return ventaDiariaActualSoloTarjetas;
    }

    public void setVentaDiariaActualSoloTarjetas(double ventaDiariaActualSoloTarjetas) {
        this.ventaDiariaActualSoloTarjetas = ventaDiariaActualSoloTarjetas;
    }
    
    public void setVentaDiariaActual(double ventaDiariaActual) {
        this.ventaDiariaActual = ventaDiariaActual;
    }
   
    public Caja getSelected() {
        return selected;
    }

    public List<Caja> getFilteredCaja() {
        return filteredCaja;
    }

    public void setFilteredCaja(List<Caja> filteredCaja) {
        this.filteredCaja = filteredCaja;
    }
    
    public void setSelected(Caja selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private CajaFacade getFacade() {
        return ejbFacade;
    }

    public Caja prepareCreate() {
        selected = new Caja();
        initializeEmbeddableKey();

        SimpleDateFormat formDate = new SimpleDateFormat("dd/MM/yyyy");
        String fechaDeHoy = formDate.format(new Date()); 
       
        selected.setFecha(fechaDeHoy);
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("CajaCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("CajaUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("CajaDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Caja> getItems() {
            items = getFacade().findAll();
        return items;
    }

    public List<Caja> getItemsFechaDeHoy() {
            itemsFechaDeHoy = new ArrayList<>();
        SimpleDateFormat formDate = new SimpleDateFormat("dd/MM/yyyy");
        String fechaDeHoy = formDate.format(new Date()); 
        
        FacesContext context = FacesContext.getCurrentInstance();
        CajaController cajaController = context.getApplication().evaluateExpressionGet(context, "#{cajaController}", CajaController.class);
        
           for(int indice = 0;indice<cajaController.getItems().size();indice++){

                if(cajaController.getItems().get(indice).getFecha().equals(fechaDeHoy)){
                        itemsFechaDeHoy.add(cajaController.getItems().get(indice));
                }
        }
        System.out.println("itemsfechaDeHoy size: "+ itemsFechaDeHoy.size());
        return itemsFechaDeHoy;
    }

    public void setItemsFechaDeHoy(List<Caja> itemsFechaDeHoy) {
        this.itemsFechaDeHoy = itemsFechaDeHoy;
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

    public Caja getCaja(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Caja> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Caja> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    private void setVentaDiariaActual() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @FacesConverter(forClass = Caja.class)
    public static class CajaControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            CajaController controller = (CajaController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "cajaController");
            return controller.getCaja(getKey(value));
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
            if (object instanceof Caja) {
                Caja o = (Caja) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Caja.class.getName()});
                return null;
            }
        }

    }
    
    public void mostrarVentaDiariaActual(){
                SimpleDateFormat formDate = new SimpleDateFormat("dd/MM/yyyy");
                String fechaDeHoy = formDate.format(new Date()); 
            
        FacesContext context = FacesContext.getCurrentInstance();
        CajaController cajaController = context.getApplication().evaluateExpressionGet(context, "#{cajaController}", CajaController.class);
         
        double totalVentaDiaria = 0;
        
        for(int index=0; index<=cajaController.getItems().size() - 1;index++){
           
                if(cajaController.getItems().get(index).getFecha().equals(fechaDeHoy)){
                    if(cajaController.getItems().get(index).getIngreso()!=null){    
                    totalVentaDiaria = totalVentaDiaria + cajaController.getItems().get(index).getIngreso();
                    }
                }
        }
        
        System.out.println("Total vendido hoy: "+ totalVentaDiaria);
        JsfUtil.addSuccessMessage("total vendido hoy: "+ totalVentaDiaria);
            
    }
    
    public void mostrarVentaMensualActual() throws ParseException{
            SimpleDateFormat formDate = new SimpleDateFormat("MM/yyyy");
            String mesYAnnioDeHoy = formDate.format(new Date()); 
            
            System.out.println("mesYAnnioDeHoy: "+ mesYAnnioDeHoy);    
                
        FacesContext context = FacesContext.getCurrentInstance();
        CajaController cajaController = context.getApplication().evaluateExpressionGet(context, "#{cajaController}", CajaController.class);
         
        double totalVentaMensual = 0;
        
        for(int index=0; index<=cajaController.getItems().size() - 1;index++){
                
            String fechaDeCaja = cajaController.getItems().get(index).getFecha();
                        fechaDeCaja = fechaDeCaja.substring(3);
            
                System.out.println("fechaDeCaja CORTADA: "+ fechaDeCaja);    

                if(fechaDeCaja.equals(mesYAnnioDeHoy)){
                    if(cajaController.getItems().get(index).getIngreso()!=null){
                    totalVentaMensual = totalVentaMensual + cajaController.getItems().get(index).getIngreso();
                    }
                }
        }
        
        System.out.println("Total vendido mensual: "+ totalVentaMensual);
        JsfUtil.addSuccessMessage("total vendido mensual: "+ totalVentaMensual);
            
    }    
}