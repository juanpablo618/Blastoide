/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blastoide.jpa;

import com.blastoide.jpa.conexion.DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author developer
 */
public class CuentasCorrientesDAO extends DAO {
    
    
    public void CambiarSaldo(int clienteID ,float saldo ) throws Exception{
        try {
            
            this.Conectar();
            this.getCn().setAutoCommit(false);
            
            
            String sqlFinal = "UPDATE CuentasCorrientes SET saldo="+saldo + " WHERE cuentaCorrienteID="+clienteID; 
                    
            System.err.println(sqlFinal.toString());
            
            PreparedStatement st = this.getCn().prepareStatement(sqlFinal);

         st.execute();
         st.close();
        
        this.getCn().commit();
        System.err.println("entro al commit para modificar salgo");
        } catch (Exception e) {
        this.getCn().rollback();
                    System.err.println("hizo el rollback para modificar saldo");
        }finally{
            this.Cerrar();
        }
        
    }
    

    
    public float buscarSaldo(int cuentaCorrienteID) throws Exception{
    
                    try {

                    this.Conectar();
                    this.getCn().setAutoCommit(false);

                    String sql = "SELECT saldo FROM CuentasCorrientes where cuentaCorrienteID = "+cuentaCorrienteID ;
                    
                 PreparedStatement st2 = this.getCn().prepareStatement(sql);


                ResultSet rs;
                rs = st2.executeQuery();
                float saldo = 0;

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
    
    
    
}
