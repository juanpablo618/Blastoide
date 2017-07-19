/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blastoide.jpa;

import com.blastoide.jpa.conexion.DAO;
import com.blastoide.jsf.Cliente;
import java.sql.*;
import java.util.List;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author developer
 */
public class ClienteDAO extends DAO{
    
    
    
    public List<Cliente> listar() throws Exception{
        
        List<Cliente> lista;
            
        ResultSet rs;
        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareCall("SELECT ClienteID, nombre, dni, TipoCliente, FormaDePagoID from Cliente");
            rs = st.executeQuery();
                lista = new ArrayList();
            while(rs.next()){
                Cliente cliente = new Cliente();
                cliente.setClienteID(rs.getInt("ClienteID"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setDni(rs.getString("dni"));
                cliente.setTipoCliente(rs.getInt("TipoCliente"));
                cliente.setFormaDePagoID(rs.getInt("FormaDePagoID"));
                lista.add(cliente);
                
            }
            
            
        } catch (Exception e) {
        throw e;
        }finally{
            this.Cerrar();
        }
        return lista;
    
    }
    
    
    
    public Cliente leerId(Cliente cliente) throws Exception{
        Cliente clien;
        
        ResultSet rs;
        
        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareCall("SELECT nombre, dni, TipoCliente from Cliente where ClienteID= ?");
            st.setInt(1, cliente.getClienteID());
           rs = st.executeQuery();
            
            while (rs.next()) {                
                clien = new Cliente();
                clien.setNombre(rs.getString("nombre"));
                clien.setDni("dni");
                clien.setTipoCliente(rs.getInt("TipoCliente"));
                
                
            }
           
            
        } catch (Exception e) {
        throw e;
        }finally{
            this.Cerrar();
        }
        return cliente;
    }
    
    
    
    
    
    
    
    
    
    
    
    
}
