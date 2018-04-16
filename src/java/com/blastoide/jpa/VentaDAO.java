package com.blastoide.jpa;


import com.blastoide.jpa.conexion.DAO;
import com.blastoide.jsf.Venta;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import com.blastoide.jsf.DetalleVenta;
import java.sql.SQLException;
/**
 *
 * @author cuello.juanpablo@gmail.com
 */


public class VentaDAO extends DAO{

    /** comentario en javadoc*/ 
    public void registrar(Venta venta, List<DetalleVenta> lista ) throws Exception{
        try {
            
            this.Conectar();
            this.getCn().setAutoCommit(false);
            
            System.err.println("variables en ventaDAO");
            System.err.println(venta.getFecha().toString());
            System.err.println(venta.getMonto());
            System.err.println(venta.getCliente().getClienteID());
            
            
            
            PreparedStatement st = this.getCn().prepareStatement("insert into Venta (ClienteID, monto, formaDePagoID, empleado) values(?,?,?,?)");
                                System.err.println("llego aca al insert de ventaDAO");
System.err.println("empleado: " +venta.getEmpleado());
                
                st.setInt(1, venta.getCliente().getClienteID());
                st.setDouble(2, venta.getMonto());
                st.setInt(3, venta.getFormadePagoID());
                st.setString(4, venta.getEmpleado());

                System.err.println("st: "+st.toString());

                
         st.executeUpdate();
         st.close();
         
         
        PreparedStatement st2 = this.getCn().prepareStatement("SELECT LAST_INSERT_ID() from Venta limit 1");
        ResultSet rs;
        int CodVenta = 0;
                 

        rs = st2.executeQuery();
        
        while(rs.next()){
            CodVenta = rs.getInt(1);
        }
        rs.close();
        
       for(DetalleVenta det : lista){
           
                PreparedStatement st3 = this.getCn().prepareStatement("insert into DetalleVenta (CodVenta, productoID, cantidad) values(?,?,?)"); 
                    System.err.println("CodVenta:"+ CodVenta);
                    st3.setInt(1, CodVenta);
                    st3.setInt(2, det.getProducto().getProductoID());
                    st3.setInt(3, det.getCantidad());
                    
                    
                    st3.executeUpdate();
                    st3.close();
                    
                
        } 
        
        this.getCn().commit();
        System.err.println("entro al commit de VentaDAO");
        } catch (Exception e) {
        this.getCn().rollback();
                    System.err.println("hizo el rollback en ventaDAO");
        }finally{
            this.Cerrar();
        }
        
    }

    public int buscarUltimoIdInsertado() throws ClassNotFoundException, SQLException {
    
            this.Conectar();
        
        PreparedStatement st2 = this.getCn().prepareStatement("SELECT MAX(ventaID) AS id FROM Venta");
        ResultSet rs;
        int CodVenta = 0;
                 

        rs = st2.executeQuery();
        
        while(rs.next()){
            CodVenta = rs.getInt(1);
        }
        rs.close();
        return CodVenta;
    }
    
}
