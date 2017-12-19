package com.blastoide.jpa;

import com.blastoide.jpa.conexion.DAO;
import com.blastoide.jsf.Venta;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author juan
 */
public class CajaDiariaDAO extends DAO{
    
    public void registrarEnCajaDiaria(Venta venta) throws Exception{
        try {
            
            this.Conectar();
            this.getCn().setAutoCommit(false);
            
            System.err.println("variables en caja diaria DAO");
            System.err.println(venta.getFecha().toString());
            System.err.println(venta.getMonto());
            System.err.println(venta.getCliente().getClienteID());
            
            SimpleDateFormat formDate = new SimpleDateFormat("dd/MM/yyyy");

       // String strDate = formDate.format(System.currentTimeMillis()); // option 1
           String strDate = formDate.format(new Date()); // option 2
            
            PreparedStatement st = this.getCn().prepareStatement("insert into caja (descripcion, ingreso, fecha) values(?,?,?)");
                                System.err.println("llego aca al insert de cajaDiariaDAO");
                
                st.setString(1, "cliente: ".concat(venta.getCliente().getNombre()));
                st.setDouble(2, venta.getMonto());
                st.setString(3, strDate);
                System.err.println("st: "+st.toString());

                
         st.executeUpdate();
         st.close();
        
         this.getCn().commit();
        System.err.println("entro al commit de cja Diario DAO ");
        } catch (Exception e) {
        this.getCn().rollback();
                    System.err.println("hizo el rollback en caja diaria DAO");
        }finally{
            this.Cerrar();
        }
    
    }
}