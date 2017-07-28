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
 * @author cuello.juanpablo@gmail.com
 */
public class FormaDePagoDAO extends DAO{
    
    public Double buscarPorcentaje(int FormaDePagoID ) throws Exception{
                
                try {

                    this.Conectar();
                    this.getCn().setAutoCommit(false);

                    String sql = "SELECT porcentaje FROM FormaDePago where formaDePagoID = "+FormaDePagoID ;
                    
                 PreparedStatement st2 = this.getCn().prepareStatement(sql);

System.err.println("st2 de buscar porcentaje de Forma de pago: "+st2.toString());

                ResultSet rs;
                rs = st2.executeQuery();
                Double porcentaje = null;

                while(rs.next()){
                    porcentaje = rs.getDouble(1);
                }                   
                rs.close();
                return porcentaje;

                } catch (Exception e) {
                }finally{
                    this.Cerrar();
                }
                        return null;

        }
}