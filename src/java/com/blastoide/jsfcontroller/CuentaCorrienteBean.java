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
    
    
    
    
    
    
    public void cambiarSaldo(int clienteID ,float saldo) throws Exception{
         
        
        System.err.println("clienteID"+ clienteID);
            
        System.err.println("saldo:"+ saldo);
        
        
        
        CuentasCorrientesDAO cuentasCorrientesDAO = new CuentasCorrientesDAO();
        cuentasCorrientesDAO.CambiarSaldo(clienteID, cuentacorriente.getSaldo());
        

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Saldo actualizado: "+saldo));

        
    }
    
    
     public float BuscarSaldo(int cuentaCorrienteID) throws Exception{
     CuentasCorrientesDAO cuentasCorrientesDAO = new CuentasCorrientesDAO();
     float retornaSaldo = 0;
     
     retornaSaldo = cuentasCorrientesDAO.buscarSaldo(cuentaCorrienteID);
         
     return retornaSaldo ;
     }
    
}
