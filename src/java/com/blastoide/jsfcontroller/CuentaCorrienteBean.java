/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blastoide.jsfcontroller;

import com.blastoide.jpa.CuentasCorrientesDAO;
import com.blastoide.jsf.ClienteBueno;
import com.blastoide.jsf.CuentasCorrientes_1;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author cuello.juanpablo@gmail.com
 */

@ManagedBean
@ViewScoped
public class CuentaCorrienteBean implements Serializable{
    
    private CuentasCorrientes_1 cuentacorriente = new CuentasCorrientes_1(); 

    public CuentasCorrientes_1 getCuentacorriente() {
        return cuentacorriente;
    }

    public void setCuentacorriente(CuentasCorrientes_1 cuentacorriente) {
        this.cuentacorriente = cuentacorriente;
    }
    
    
    
    
    
    
    public void cambiarLimite(int clienteID ,float limite) throws Exception{
         
        
        System.err.println("clienteID"+ clienteID);
            
        System.err.println("limite:"+ limite);
        
        
        
        CuentasCorrientesDAO cuentasCorrientesDAO = new CuentasCorrientesDAO();
        cuentasCorrientesDAO.CambiarLimite(clienteID, cuentacorriente.getLimite());
        

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("limite actualizado: "+limite));

        
    }
    
    
     public float buscarLimite(int cuentaCorrienteID) throws Exception{
     CuentasCorrientesDAO cuentasCorrientesDAO = new CuentasCorrientesDAO();
     float retornaLimite = 0;
     
     retornaLimite = cuentasCorrientesDAO.buscarLimite(cuentaCorrienteID);
         
     return retornaLimite ;
     }
     
     
     public Double buscarCantidadQueDebe(int cuentaCorrienteID) throws Exception{
     CuentasCorrientesDAO cuentasCorrientesDAO = new CuentasCorrientesDAO();
     
     Double retornaCantidadQueDebe;
     
     retornaCantidadQueDebe = cuentasCorrientesDAO.buscarCantidadQueDebe(cuentaCorrienteID);
         
     return retornaCantidadQueDebe ;
     
     
     
     }
     
     
    
}
