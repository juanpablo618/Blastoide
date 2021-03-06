package com.blastoide.jpa;

import com.blastoide.jpa.conexion.DAO;
import com.blastoide.jsf.Productos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cuello.juanpablo@gmail.com
 */
public class ProductosDAO extends DAO{
    
    public List<Productos> listarProductosSinStock() throws Exception{
        
        List<Productos> lista;
            
        ResultSet rs;
        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareCall("SELECT productoID, codigo, nombre, marca, fragancia, caracteristica, medida, precioFinalAFacturar, ultimaActualizacionStock, stockactual, stockMinimo from Productos where stockMinimo >= stockactual");
            rs = st.executeQuery();
                lista = new ArrayList();
            while(rs.next()){
                Productos producto = new Productos();
                producto.setProductoID(rs.getInt("productoID"));
                producto.setCodigo(rs.getString("codigo"));
                producto.setNombre(rs.getString("nombre"));
                producto.setMarca(rs.getString("marca"));
                producto.setFragancia(rs.getString("fragancia"));
                producto.setCaracteristica(rs.getString("caracteristica"));
                producto.setMedida(rs.getString("medida"));
                producto.setPrecioFinalAFacturar(rs.getDouble("precioFinalAFacturar"));
                
                producto.setUltimaActualizacionStock(rs.getDate("ultimaActualizacionStock"));
                producto.setStockactual(rs.getInt("stockactual"));
                producto.setStockMinimo(rs.getInt("stockMinimo"));
                
                lista.add(producto);
                
            }
            
        } catch (Exception e) {
        throw e;
        }finally{
            this.Cerrar();
        }
        return lista;
    }

    public int buscarPorCodigoDeBarra(String productoCodBarra) throws SQLException {
       
        int idBuscado = 0;
        ResultSet rs;
        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareCall("SELECT productoID FROM `Productos` WHERE codigo = ".concat(productoCodBarra));
            rs = st.executeQuery();
            while(rs.next()){
                idBuscado = rs.getInt("productoID");
            }
        } catch (Exception e) {
        }finally{
            this.Cerrar();
        }
        return idBuscado;

    }

    public double buscarPrecioFinalAFacturar(int idProductoPorCambiarValor) throws SQLException {
    double precioFinalBuscado = 0;
        ResultSet rs;
        try {
            this.Conectar();
            PreparedStatement st;
        st = this.getCn().prepareCall("SELECT precioFinalAFacturar FROM `Productos` WHERE productoID = "+idProductoPorCambiarValor);
            rs = st.executeQuery();
            while(rs.next()){
                precioFinalBuscado = rs.getDouble("precioFinalAFacturar");
            }
        } catch (Exception e) {
        }finally{
            this.Cerrar();
        }
        return precioFinalBuscado;
    }
}