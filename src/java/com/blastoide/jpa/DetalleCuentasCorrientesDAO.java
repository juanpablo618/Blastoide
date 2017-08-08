/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blastoide.jpa;
import com.blastoide.jpa.conexion.DAO;
import com.blastoide.jsf.DetalleCuentasCorrientes;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cuello.juanpablo@gmail.com
 */
public class DetalleCuentasCorrientesDAO extends DAO{
    
    public void insertarDetalleCtaCorriente(double debe, float haber, String descripcion, int cuentaCorrienteID) throws SQLException{
    
           try {
            
            this.Conectar();
            this.getCn().setAutoCommit(false);
            
            
            
            PreparedStatement st2 = this.getCn().prepareStatement("SELECT LAST_INSERT_ID() from Venta limit 1");
                    ResultSet rs;
                    int ventaID = 0;


                    rs = st2.executeQuery();

                    while(rs.next()){
                        ventaID = rs.getInt(1);
                    }
                    rs.close();

            
            
            
            
            
            
            
            PreparedStatement st = this.getCn().prepareStatement("insert into DetalleCuentasCorrientes (debe, haber, descripcion, cuentaCorrienteID, ventaID) values(?,?,?,?,?)");
                                System.err.println("llego aca al insert de DetalleCuentasCorrientesDAO");

                
                st.setDouble(1, debe);
                st.setFloat(2, haber);
                st.setString(3, descripcion);
                st.setInt(4, cuentaCorrienteID);
                st.setInt(5, ventaID);
         st.executeUpdate();
         st.close();
         
        
        PreparedStatement st4 = this.getCn().prepareStatement("SELECT saldo from CuentasCorrientes where cuentaCorrienteID = "+cuentaCorrienteID) ;
                    ResultSet rs2;
                    float saldoDeCtaCorriente = 0;


                    rs2 = st4.executeQuery();

                    while(rs2.next()){
                        saldoDeCtaCorriente = rs.getFloat(1);
                    }
                    rs2.close();

            
            float saldoActual= (float) (saldoDeCtaCorriente - debe) ;
         
         
           
           String sqlUpdateSaldoDeCtaCorriente = "UPDATE CuentasCorrientes SET saldo="+saldoActual + " WHERE cuentaCorrienteID="+cuentaCorrienteID; 
                    
            System.err.println(sqlUpdateSaldoDeCtaCorriente);
            
            PreparedStatement st5 = this.getCn().prepareStatement(sqlUpdateSaldoDeCtaCorriente);

            st5.execute();
            st5.close();
        
            
            
                
       
        
        this.getCn().commit();
        System.err.println("entro al commit de DetalleCuentasCorrientesDAO");
        } catch (Exception e) {
        this.getCn().rollback();
                    System.err.println("hizo el rollback de DetalleCuentasCorrientesDAO");
        }finally{
            this.Cerrar();
        }
     
    }
    
    
    public List<DetalleCuentasCorrientes> listar(int cuentaCorrienteID) throws Exception{
        
        System.err.println("paso para el listar de DetalleCuentasCorrienteDAO");
        
        System.err.println("cuentaCorrienteID"+cuentaCorrienteID);
        
        List<DetalleCuentasCorrientes> lista;
            
        ResultSet rs;
        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareCall("SELECT detalleCuentaCorrienteID, debe, haber, descripcion, fecha, cuentaCorrienteID, ventaID from DetalleCuentasCorrientes where cuentaCorrienteID= "+cuentaCorrienteID);
            rs = st.executeQuery();
                lista = new ArrayList();
            while(rs.next()){
                
                
                DetalleCuentasCorrientes detalleCtaCorriente = new DetalleCuentasCorrientes();
                
                detalleCtaCorriente.setDetalleCuentaCorrienteID(rs.getInt("detalleCuentaCorrienteID"));
                detalleCtaCorriente.setDebe(rs.getFloat("debe"));
                detalleCtaCorriente.setHaber(rs.getFloat("haber"));
                detalleCtaCorriente.setDescripcion(rs.getString("descripcion"));
                detalleCtaCorriente.setFecha(rs.getString("fecha"));
                detalleCtaCorriente.setCuentaCorrienteID(rs.getInt("cuentaCorrienteID"));
                detalleCtaCorriente.setVentaID(rs.getInt("ventaID"));
                
                
                
                lista.add(detalleCtaCorriente);
                
            }
            
            
        } catch (Exception e) {
        throw e;
        }finally{
            this.Cerrar();
        }
        System.err.println(lista.toString());
            
        return lista;
    
    }

    
   
    
    
    
}
