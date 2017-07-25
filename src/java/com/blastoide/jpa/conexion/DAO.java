package com.blastoide.jpa.conexion;

import java.sql.*;



public class DAO {

private Connection cn;

    public Connection getCn() {
        return cn;
    }

    public void setCn(Connection cn) {
        this.cn = cn;
    }

       
public void Conectar() throws ClassNotFoundException, SQLException{
    
    try {
        
                Class.forName("com.mysql.jdbc.Driver");
                cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Blastoide?user=root&password=");

    } catch (Exception e) {
        throw e;
    }

    }


    public void Cerrar() throws SQLException{
        
        if(cn != null){
            if(cn.isClosed() == false){
                cn.close();
            }
        }

    }


    
    
    

}
