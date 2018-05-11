package com.blastoide.jpa;

import com.blastoide.jpa.conexion.DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author cuello.juanpablo@gmail.com
 */
public class TipoDeClienteDAO extends DAO{
    
    public Double buscarPorcentajeDeTipoDeCLiente(int TipoCliente ) throws Exception{
                
                try {

                    this.Conectar();
                    this.getCn().setAutoCommit(false);

                    String sql = "SELECT porcentajeInteres FROM TipoClientes where tipoClienteID = "+TipoCliente ;
                    
                 PreparedStatement st2 = this.getCn().prepareStatement(sql);
System.err.println("st2 de buscar porcentaje de tipo de cliente: "+st2.toString());
                

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
