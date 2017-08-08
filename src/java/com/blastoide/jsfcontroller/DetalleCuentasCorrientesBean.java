
package com.blastoide.jsfcontroller;

import com.blastoide.jpa.DetalleCuentasCorrientesDAO;
import com.blastoide.jsf.Cliente;
import com.blastoide.jsf.ClienteBueno;
import com.blastoide.jsf.DetalleCuentasCorrientes;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;


/**
 *
 * @author cuello.juanpablo@gmail.com
 */

@ManagedBean
@ViewScoped
public class DetalleCuentasCorrientesBean implements Serializable{
    
    private ClienteBueno cliente;
     
    
    private List<DetalleCuentasCorrientes> lista = new ArrayList();

    
    
    
    
    
    public ClienteBueno getCliente() {
        return cliente;
    }

    public void setCliente(ClienteBueno cliente) {
        this.cliente = cliente;
    }

    public List<DetalleCuentasCorrientes> getLista() {
        return lista;
    }

    public void setLista(List<DetalleCuentasCorrientes> lista) {
        
        
        this.lista = lista;
         
    }
    
    
    public List<DetalleCuentasCorrientes> darlistaConDetalles(int cuentaCorrienteID) throws Exception{
        
        DetalleCuentasCorrientesDAO detalleCuentasCorrientesDAO = new DetalleCuentasCorrientesDAO();
                
       System.err.println("vino al darlistaConDetalles");
            System.err.println("cuentaCorrienteID: "+cuentaCorrienteID);
       
                        lista = detalleCuentasCorrientesDAO.listar(cuentaCorrienteID);
                        return lista;


    }
    
    
    
    public void pedirDetalleCtaCorriente() throws Exception{
    
        FacesContext context = FacesContext.getCurrentInstance();
        
        DetalleCuentasCorrientesBean detalleCtaCorrienteBean = context.getApplication().evaluateExpressionGet(context, "#{detalleCuentasCorrientesBean}", DetalleCuentasCorrientesBean.class);
        
            
        
        detalleCtaCorrienteBean.darlistaConDetalles(this.cliente.getCuentaCorrienteID());
        System.err.println("vino al pedirDetalleCtaCorriente:");
        System.err.println("id de cta corriente del cliente: "+this.cliente.getCuentaCorrienteID());
        
        
        
    }
    
    
    
}
