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
    
    
    
}
