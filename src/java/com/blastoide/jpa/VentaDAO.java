/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blastoide.jpa;

import com.blastoide.jpa.conexion.ConexionMySql;
import com.blastoide.jpa.conexion.DAO;
import com.blastoide.jsf.Venta;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import com.blastoide.jsf.DetalleVenta;
/**
 *
 * @author developer
 */
public class VentaDAO extends DAO{

    
     public ConexionMySql conexion = new ConexionMySql();
        
   
    
    public void registrar(Venta venta, List<DetalleVenta> lista ) throws Exception{
        try {
            
            this.Conectar();
            this.getCn().setAutoCommit(false);
            
            PreparedStatement st = this.getCn().prepareStatement("insert into Venta (fecha, ClienteID, monto) values(?,?,?)");
                                System.err.println("llego aca al insert de ventaDAO");

        
                st.setDate(1, (Date) venta.getFecha());
                st.setInt(2, venta.getCliente().getClienteID());
                st.setDouble(3, venta.getMonto());
                
        
        PreparedStatement st2 = this.getCn().prepareStatement("select last_insert_id() from Venta limit 1");
        ResultSet rs;
        int CodVenta = 0;
        rs = st2.executeQuery();
        while(rs.next()){
            CodVenta = rs.getInt(1);
        }
        
        
       for(DetalleVenta det : lista){
           
           PreparedStatement st3 = this.getCn().prepareStatement("insert into DetalleVenta (CodVenta, CodProducto, cantidad) values(?,?,?)");
                                        System.err.println("llego aca al insert de DetalleVenta");

                st3.setInt(1, CodVenta);
                st3.setString(2, det.getProducto().getCodigo());
                st3.setInt(3, det.getCantidad());
                st3.executeUpdate();
                st3.close();
        
           
       
       } 
        
        this.getCn().commit();
        } catch (Exception e) {
        this.getCn().rollback();
            
        }finally{
            this.Cerrar();
        }
        
    }
    
    
}
