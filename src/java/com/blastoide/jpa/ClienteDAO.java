/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blastoide.jpa;

import com.blastoide.jpa.conexion.DAO;
import com.blastoide.jsf.Cliente;
import com.blastoide.jsf.CuentasCorrientes;

import java.sql.*;
import java.util.List;
import java.sql.ResultSet;
import java.util.ArrayList;


public class ClienteDAO extends DAO{
    
    
    
    public List<Cliente> listar() throws Exception{
        
        List<Cliente> lista;
            
        ResultSet rs;
        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareCall("SELECT ClienteID, nombre, dni, tipoClienteID, FormaDePagoID, razonSocial, telefonoFijo, telefonoCelular, email, cuentaCorrienteID from Cliente");
            rs = st.executeQuery();
                lista = new ArrayList();
            while(rs.next()){
                Cliente cliente = new Cliente();
                cliente.setClienteID(rs.getInt("ClienteID"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setDni(rs.getString("dni"));
                cliente.setTipoCliente(rs.getInt("tipoClienteID"));
                cliente.setFormaDePagoID(rs.getInt("FormaDePagoID"));
                cliente.setRazonSocial(rs.getString("razonSocial"));
                cliente.setTelefonoFijo(rs.getString("telefonoFijo"));
                cliente.setTelefonoCelular(rs.getString("telefonoCelular"));
                cliente.setEmail(rs.getString("email"));
                cliente.setCuentaCorrienteID(rs.getInt("cuentaCorrienteID"));
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
            PreparedStatement st = this.getCn().prepareCall("SELECT nombre, dni, tipoClienteID from Cliente where ClienteID= ?");
            st.setInt(1, cliente.getClienteID());
           rs = st.executeQuery();
            
            while (rs.next()) {                
                clien = new Cliente();
                clien.setNombre(rs.getString("nombre"));
                clien.setDni("dni");
                clien.setTipoCliente(rs.getInt("tipoClienteID"));
                
                
            }
           
            
        } catch (Exception e) {
        throw e;
        }finally{
            this.Cerrar();
        }
        return cliente;
    }
    
    
    
    //este anda no tocar por ahora 31 de julio de 2017
// public void crearClienteNuevo(Cliente cliente, CuentasCorrientes cuentasCorrientes) throws SQLException, ClassNotFoundException{   
//     try {
//            
//            this.Conectar();
//            this.getCn().setAutoCommit(false);
//            
//            
//            PreparedStatement st = this.getCn().prepareStatement("insert into CuentasCorrientes (saldo) values(?)");
//                          
//                st.setFloat(1, cuentasCorrientes.getSaldo());
//                
//         st.executeUpdate();
//         st.close();
//         
//         
//        PreparedStatement st2 = this.getCn().prepareStatement("SELECT LAST_INSERT_ID() from CuentasCorrientes limit 1");
//        ResultSet rs;
//        int CuentaCorrienteid = 0;
//                 
//
//        rs = st2.executeQuery();
//        
//        while(rs.next()){
//            CuentaCorrienteid = rs.getInt(1);
//        }
//        rs.close();
//        
//
//           
//                PreparedStatement st3 = this.getCn().prepareStatement("insert into Cliente (nombre, dni, tipoClienteID, FormaDePagoID, apellido, email, cuitCuil,  numeroDocumento, razonSocial, sexo, telefonoFijo, telefonoCelular, condicionIvaID, diaDePago, cuentaCorrienteID) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"); 
//                    st3.setString(1, cliente.getNombre());
//                    st3.setString(2, cliente.getDni() );
//                    st3.setInt(3, cliente.getTipoCliente());
//                    st3.setInt(4, cliente.getFormaDePagoID());
//                    st3.setString(5, cliente.getApellido());
//                    st3.setString(6, cliente.getEmail());
//                    st3.setString(7, cliente.getCuitCuil());
//                    st3.setString(8, cliente.getDni());
//                    st3.setString(9, cliente.getRazonSocial());
//                    st3.setString(10, cliente.getSexo());
//                    st3.setString(11, cliente.getTelefonoFijo());
//                    st3.setString(12, cliente.getTelefonoCelular());
//                    st3.setInt(13, cliente.getCondicionIva());
//                    st3.setString(14, cliente.getDiaDePago());
//                    st3.setInt(15, CuentaCorrienteid);
//    
//                    st3.executeUpdate();
//                    st3.close();
//        
//        this.getCn().commit();
//        System.err.println("entro al commit");
//        } catch (Exception e) {
//        this.getCn().rollback();
//                    System.err.println("hizo el rollback");
//        }finally{
//            this.Cerrar();
//        }
//        
//    }
//    
    
    
    
    public void crearClienteNuevo(Cliente cliente, CuentasCorrientes cuentasCorrientes) throws SQLException, ClassNotFoundException{   
     try {
            
            this.Conectar();
            this.getCn().setAutoCommit(false);
            
            
        PreparedStatement st = this.getCn().prepareStatement("insert into CuentasCorrientes (saldo) values(?)");
                          
                st.setFloat(1, cuentasCorrientes.getSaldo());
                
                st.executeUpdate();
                st.close();
         
         
        PreparedStatement st2 = this.getCn().prepareStatement("SELECT LAST_INSERT_ID() from CuentasCorrientes limit 1");
        ResultSet rs;
        int CuentaCorrienteid = 0;
                 

                 rs = st2.executeQuery();
        
        while(rs.next()){
            CuentaCorrienteid = rs.getInt(1);
        }
        rs.close();
        

           
        PreparedStatement st3 = this.getCn().prepareStatement("insert into Cliente (nombre, dni, tipoClienteID, FormaDePagoID, apellido, email, cuitCuil,  numeroDocumento, razonSocial, sexo, telefonoFijo, telefonoCelular, condicionIvaID, diaDePago, cuentaCorrienteID) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"); 
                    st3.setString(1, cliente.getNombre());
                    st3.setString(2, cliente.getDni() );
                    st3.setInt(3, cliente.getTipoCliente());
                    st3.setInt(4, cliente.getFormaDePagoID());
                    st3.setString(5, cliente.getApellido());
                    st3.setString(6, cliente.getEmail());
                    st3.setString(7, cliente.getCuitCuil());
                    st3.setString(8, cliente.getDni());
                    st3.setString(9, cliente.getRazonSocial());
                    st3.setString(10, cliente.getSexo());
                    st3.setString(11, cliente.getTelefonoFijo());
                    st3.setString(12, cliente.getTelefonoCelular());
                    st3.setInt(13, cliente.getCondicionIva());
                    st3.setString(14, cliente.getDiaDePago());
                    st3.setInt(15, CuentaCorrienteid);
    
                    st3.executeUpdate();
                    st3.close();
        
        this.getCn().commit();
        System.err.println("entro al commit");
        } catch (Exception e) {
        this.getCn().rollback();
                    System.err.println("hizo el rollback");
        }finally{
            this.Cerrar();
        }
        
    }
 
    
}
