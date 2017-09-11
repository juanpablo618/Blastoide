/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blastoide.jpa;

import com.blastoide.jpa.conexion.DAO;
import com.blastoide.jsf.Productos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cuello.juanpablo@gmail.com
 */
public class ProductosDAO extends DAO{
    
    
    
    
/* todas las columnas en la bd actualmente 11 sep. 2017
productoID
codigo
nombre
marca
fragancia
caracteristica
medida
precioVenta
unidadMedidaID (no se usa)
tipoProductoID 
tipoRubroID (no se usa)
        
        
ultimaActualizacionStock
inventarioID
precioFinalAFacturar (no se usa)
stockactual
stockMinimo
*/
    
    public List<Productos> listarProductosSinStock() throws Exception{
        
        List<Productos> lista;
            
        ResultSet rs;
        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareCall("SELECT productoID, codigo, nombre, marca, fragancia, caracteristica, medida, precioVenta, ultimaActualizacionStock, stockactual, stockMinimo from Productos where stockMinimo >= stockactual");
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
                producto.setPrecioVenta(rs.getDouble("precioVenta"));
                
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
    
    
}
