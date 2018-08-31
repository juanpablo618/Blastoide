package com.blastoide.jsfcontroller;

import com.blastoide.jpa.CuentasCorrientesDAO;
import com.blastoide.jpa.DetalleCuentasCorrientesDAO;
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
    private DetalleCuentasCorrientes detalleCtaCorriente = new DetalleCuentasCorrientes();

    public DetalleCuentasCorrientes getDetalleCtaCorriente() {
        return detalleCtaCorriente;
    }

    public void setDetalleCtaCorriente(DetalleCuentasCorrientes detalleCtaCorriente) {
        this.detalleCtaCorriente = detalleCtaCorriente;
    }
    
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
    
    public void pedirDetalleCtaCorriente(int clienteId) throws Exception{
    
        System.out.println("/////////////////////////////////////////////////////");
        System.out.println("clienteId: "+clienteId);
        if(clienteId == 0){
            clienteId=32;
        }
        FacesContext context = FacesContext.getCurrentInstance();
        
        DetalleCuentasCorrientesBean detalleCtaCorrienteBean = context.getApplication().evaluateExpressionGet(context, "#{detalleCuentasCorrientesBean}", DetalleCuentasCorrientesBean.class);
        ClienteBuenoController clienteBuenoController = context.getApplication().evaluateExpressionGet(context, "#{clienteBuenoController}", ClienteBuenoController.class);
        
        ClienteBueno clienteBueno = new ClienteBueno();
        
        clienteBueno = clienteBuenoController.getClienteBueno(clienteId);
        
        detalleCtaCorrienteBean.darlistaConDetalles(clienteBueno.getCuentaCorrienteID());
        System.err.println("vino al pedirDetalleCtaCorriente:");
        System.err.println("id de cta corriente del cliente: "+clienteBueno.getCuentaCorrienteID());
    }
    
    
    public void ingresarNuevoHaberEnCuentaCorriente(float haber, String descripcion, int cuentaCorrienteID) throws Exception{
    
        //debe hacer 2 cosas
        CuentasCorrientesDAO cuentaCorrienteDAO = new CuentasCorrientesDAO();
        
        float saldoHistorico= cuentaCorrienteDAO.buscarSaldo(cuentaCorrienteID);
        // insert en detalleCuentasCorrientes
        float saldoActualizado = saldoHistorico - haber ;
               
        DetalleCuentasCorrientesDAO detalleCuentasCorrientesDAO = new DetalleCuentasCorrientesDAO();
        detalleCuentasCorrientesDAO.ingresarNuevoDetalleDeCuentaCorriente( haber, descripcion, cuentaCorrienteID, saldoActualizado );
        
        // Update de SALDO en tabla CuentasCorrientes
        cuentaCorrienteDAO.actualizarSaldo(cuentaCorrienteID, saldoActualizado);
        
    }
}