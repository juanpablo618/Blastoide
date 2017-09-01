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


    
    public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/Blastoide", "root", "");
			return con;
		} catch (Exception ex) {
			System.out.println("Database.getConnection() Error --> en la clase DAO."
					+ ex.getMessage());
			return null;
		}
	}

	public static void close(Connection con) {
		try {
			con.close();
		} catch (Exception ex) {
		}
	}
    

}
