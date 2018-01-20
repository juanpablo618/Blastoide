/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blastoide.jpa.conexion;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author developer
 */
public class ConexionMySql {
        
    
    /**
     *
     * @param host
     * @param port
     * @param database
     * @param user
     * @param password
     * @return
     */
    public Connection conectarDatabase(String host, String port, String database,
            String user, String password) {
        String url = null;
        try {
            // We register the MySQL driver
            // Registramos el driver de MySQL
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                System.out.println("Error al registrar el driver de MySQL: " + ex);
            }
            Connection connection = null;
            url ="jdbc:mysql://" + host + ":" + port + "/" + database;
            // Database connect
            // Conectamos con la base de datos
            return connection = DriverManager.getConnection(
                    url,
                    user, password);           
            
         
            
        } catch (java.sql.SQLException sqle) {
            System.out.println("Error al conectar con la base de datos de MySQL (" + url + "): " + sqle);
        }
        return null;
    }




   
}

    



