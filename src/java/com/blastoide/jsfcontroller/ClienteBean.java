/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blastoide.jsfcontroller;

import com.blastoide.jpa.ClienteDAO;
import com.blastoide.jsf.Cliente;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author developer
 */

@ManagedBean
@RequestScoped
public class ClienteBean {
    
    private List<Cliente> lstClientes;
    private Cliente cliente = new Cliente();

    
    
    public List<Cliente> getLstClientes() {
        return lstClientes;
    }

    public void setLstClientes(List<Cliente> lstClientes) {
        this.lstClientes = lstClientes;
    }

    
    
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    
    
    
    
    
    public void listar(String valor) throws Exception{
     ClienteDAO dao;
        
           try {
               if(valor.equals("F") ){
               
                   if(isPostBacak() == false){
                   
                        dao = new ClienteDAO();
                        lstClientes = dao.listar();
                        System.err.println("paso por listar de clienteBean");
               }
                   
               }else{
                        dao = new ClienteDAO();
                        lstClientes = dao.listar();
                        
               System.err.println("paso por 222");
               
               }
               
               

            
            
        } catch (Exception e) {
        }
 
    
    }
    
    public void leerId(Cliente cliente) throws Exception{
        
        ClienteDAO dao;
        
        Cliente clienteTemporal;
        
           try {
            dao = new ClienteDAO();
           clienteTemporal = dao.leerId(cliente);
            
           
           if(clienteTemporal != null){
               this.cliente = clienteTemporal;
           }
            
        } catch (Exception e) {
        }
 
        
        
        
    }
    
    
    private boolean isPostBacak(){
    
        boolean respuesta;
        respuesta = FacesContext.getCurrentInstance().isPostback();
        
        return respuesta;
    }
    
    
    
    
    
    
    
    
    
    
}
