package com.blastoide.jpa;

import com.blastoide.jpa.conexion.DAO;
import com.blastoide.jsf.Venta;
import com.blastoide.jsfcontroller.FormaDePagoController;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.faces.context.FacesContext;

/**
 *
 * @author cuello.juanpablo@gmail.com
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

           String strDate = formDate.format(new Date()); // option 2
            
           FacesContext context = FacesContext.getCurrentInstance();
           FormaDePagoController formaDePagoController = context.getApplication().evaluateExpressionGet(context, "#{formaDePagoController}", FormaDePagoController.class);
           
           System.out.println(" ");
           System.out.println("venta.getFormadePagoID(): "+ venta.getFormadePagoID()); 
           System.out.println(" ");
           System.out.println("venta.getCliente().getFormaDePagoID())" + venta.getCliente().getFormaDePagoID()); 
           
           PreparedStatement st;
           
           if(venta.getFormadePagoID() == 1 || venta.getFormadePagoID()== 2 ){
                System.out.println(" ");
               System.out.println("la forma de pago es contado o contado efectivo");
            st = this.getCn().prepareStatement("insert into caja (descripcion, ingreso, fecha) values(?,?,?)");
                              System.err.println("llego aca al insert de cajaDiariaDAO");
                
                st.setString(1, "Cliente: ".concat(venta.getCliente().getNombre()).concat(" "+venta.getCliente().getApellido()).concat(" F.Pago: ").concat(formaDePagoController.getFormaDePago(venta.getFormadePagoID()).getNombre()));
                st.setDouble(2, venta.getMonto());
                st.setString(3, strDate);
                System.err.println("st: "+st.toString());
                
            }else{
               System.out.println(" ");
               System.out.println("la forma de pago NO ES NI contado NI contado efectivo");           
               st = this.getCn().prepareStatement("insert into caja (descripcion, CtaCorriente, fecha) values(?,?,?)");
                                System.err.println("llego aca al insert de cajaDiariaDAO");
                
                st.setString(1, "Cliente: ".concat(venta.getCliente().getNombre()).concat(" "+venta.getCliente().getApellido()) .concat(" F.Pago: ").concat(formaDePagoController.getFormaDePago(venta.getFormadePagoID()).getNombre()));
                st.setDouble(2, venta.getMonto());
                st.setString(3, strDate);
                System.err.println("st: "+st.toString());
           }
                
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
    
    public void registrarEnCajaDiariaElPresupuesto(Venta venta, String tipoDeCobro ) throws Exception{
        try {
            
            this.Conectar();
            this.getCn().setAutoCommit(false);
            
            System.err.println("variables en caja diaria DAO");
            System.err.println(venta.getFecha().toString());
            System.err.println(venta.getMonto());
            System.err.println(venta.getCliente().getClienteID());
            
            SimpleDateFormat formDate = new SimpleDateFormat("dd/MM/yyyy");

           String strDate = formDate.format(new Date()); // option 2
            
           FacesContext context = FacesContext.getCurrentInstance();
           FormaDePagoController formaDePagoController = context.getApplication().evaluateExpressionGet(context, "#{formaDePagoController}", FormaDePagoController.class);
           
           System.out.println(" ");
           System.out.println("venta.getFormadePagoID(): "+ venta.getFormadePagoID()); 
           System.out.println(" ");
           System.out.println("venta.getCliente().getFormaDePagoID())" + venta.getCliente().getFormaDePagoID()); 
           
           PreparedStatement st;
           
           if(venta.getFormadePagoID() == 1 || venta.getFormadePagoID()== 2 ){
                System.out.println(" ");
               System.out.println("la forma de pago es contado o contado efectivo");
            st = this.getCn().prepareStatement("insert into caja (descripcion, ingreso, fecha) values(?,?,?)");
                              System.err.println("llego aca al insert de cajaDiariaDAO");
                
                st.setString(1, "Cliente: ".concat(venta.getCliente().getNombre()).concat(" "+venta.getCliente().getApellido()).concat(" F.Pago: ").concat(formaDePagoController.getFormaDePago(venta.getFormadePagoID()).getNombre()).concat(tipoDeCobro));
                st.setDouble(2, venta.getMonto());
                st.setString(3, strDate);
                System.err.println("st: "+st.toString());
                
            }else{
               System.out.println(" ");
               System.out.println("la forma de pago NO ES NI contado NI contado efectivo");           
               st = this.getCn().prepareStatement("insert into caja (descripcion, CtaCorriente, fecha) values(?,?,?)");
                                System.err.println("llego aca al insert de cajaDiariaDAO");
                
                st.setString(1, "Cliente: ".concat(venta.getCliente().getNombre()).concat(" "+venta.getCliente().getApellido()) .concat(" F.Pago: ").concat(formaDePagoController.getFormaDePago(venta.getFormadePagoID()).getNombre()).concat(tipoDeCobro));
                st.setDouble(2, venta.getMonto());
                st.setString(3, strDate);
                System.err.println("st: "+st.toString());
           }
                
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