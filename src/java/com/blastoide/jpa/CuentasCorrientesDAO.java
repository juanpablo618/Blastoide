/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blastoide.jpa;

import com.blastoide.jpa.conexion.DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author developer
 */
public class CuentasCorrientesDAO extends DAO {
    
    
    public void CambiarLimite(int clienteID ,float limite ) throws Exception{
        try {
            
            this.Conectar();
            this.getCn().setAutoCommit(false);
            
            String sqlFinal = "UPDATE CuentasCorrientes SET limite="+limite + " WHERE cuentaCorrienteID="+clienteID; 
                    
            System.err.println(sqlFinal.toString());
            
            PreparedStatement st = this.getCn().prepareStatement(sqlFinal);

         st.execute();
         st.close();
        
        this.getCn().commit();
        System.err.println("entro al commit para modificar limite");
        } catch (Exception e) {
        this.getCn().rollback();
                    System.err.println("hizo el rollback para modificar limite");
        }finally{
            this.Cerrar();
        }
    }
    
    public Double buscarCantidadQueDebe (int cuentaCorrienteID) throws Exception{
    
                 try {

                    this.Conectar();
                    this.getCn().setAutoCommit(false);

                     String sql = "SELECT debe FROM CuentasCorrientes where cuentaCorrienteID = "+cuentaCorrienteID ;
                     PreparedStatement st2 = this.getCn().prepareStatement(sql);

                    ResultSet rs;
                    rs = st2.executeQuery();
                    Double debe = null ;

                    while(rs.next()){
                        debe = rs.getDouble(1);
                    }                   
                    rs.close();
                    return debe;

                } catch (Exception e) {
                }finally{
                    this.Cerrar();
                }
        return null;
    }
    
    public float buscarSaldo (int cuentaCorrienteID) throws Exception{
    
        try {

                this.Conectar();
                this.getCn().setAutoCommit(false);

                String sql = "SELECT saldo FROM CuentasCorrientes where cuentaCorrienteID = "+cuentaCorrienteID ;
                    
                 PreparedStatement st2 = this.getCn().prepareStatement(sql);

                ResultSet rs;
                rs = st2.executeQuery();
                float saldo = 0 ;

                while(rs.next()){
                    saldo = rs.getFloat(1);
                }                   
                rs.close();
                return saldo;

        } catch (Exception e) {
        
        }finally{
           this.Cerrar();
        }
        return 0;
    
    }
    
    public float buscarLimite(int cuentaCorrienteID) throws Exception{
    
       try {
                this.Conectar();
                this.getCn().setAutoCommit(false);

                String sql = "SELECT limite FROM CuentasCorrientes where cuentaCorrienteID = "+cuentaCorrienteID ;
                  
                PreparedStatement st2 = this.getCn().prepareStatement(sql);


                ResultSet rs;
                rs = st2.executeQuery();
                float limite = 0;

                while(rs.next()){
                    limite = rs.getFloat(1);
                }                   
                rs.close();
                return limite;

            } catch (Exception e) {
            
            }finally{
            
                this.Cerrar();
            
        }
    
       return 0;
      
    }
    
    public void  sumarMontoACtaCorriente(int cuentaCorrienteID, double monto, int ventaID) throws SQLException{
     try {
            
            this.Conectar();
            this.getCn().setAutoCommit(false);
            
            PreparedStatement st2 = this.getCn().prepareStatement("SELECT debe from DetalleCuentasCorrientes WHERE cuentaCorrienteID = LAST_INSERT_ID()");
                ResultSet rs;
                float debe = 0;


                rs = st2.executeQuery();

                while(rs.next()){
                    debe = rs.getFloat(1);
                }
                rs.close();

            System.err.println("debe: " + debe);

            debe = (float) (debe + monto);
            
            PreparedStatement st3 = this.getCn().prepareStatement("SELECT saldo from CuentasCorrientes WHERE cuentaCorrienteID = " + cuentaCorrienteID);
                ResultSet rs2;
                float saldo = 0;

                rs2 = st3.executeQuery();

                while(rs2.next()){
                    saldo = rs2.getFloat(1);
                }
                rs2.close();

            System.err.println("saldo: " + debe);
                    
        this.getCn().commit();
        System.err.println("Sumo monto a debe en cta corriente");
        
        } catch (Exception e) {
        this.getCn().rollback();
                    System.err.println("hizo el rollback para sumar monto a debe en cta corriente");
        }finally{
            this.Cerrar();
        }
       
    }
    
    public void actualizarSaldo(int cuentaCorrienteID, float saldoActualizado) throws SQLException{
    
        try {
            
            this.Conectar();
            this.getCn().setAutoCommit(false);
            
            String sqlFinal = "UPDATE CuentasCorrientes SET saldo="+saldoActualizado + " WHERE cuentaCorrienteID="+cuentaCorrienteID; 
                    
            System.err.println(sqlFinal.toString());
            
            PreparedStatement st = this.getCn().prepareStatement(sqlFinal);

         st.execute();
         st.close();
        
        this.getCn().commit();
        System.err.println("entro al commit para actualizar saldo en CuentasCorrientesDAO");
        } catch (Exception e) {
        this.getCn().rollback();
                    System.err.println("hizo el rollback para modificar limite");
        }finally{
            this.Cerrar();
        }
            
    }
    
}