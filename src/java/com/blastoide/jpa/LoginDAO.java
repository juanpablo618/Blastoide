
package com.blastoide.jpa;

/**
 *
 * @author cuello.juanpablo@gmail.com
 * http://www.journaldev.com/7252/jsf-authentication-login-logout-database-example
 */


import com.blastoide.jpa.conexion.DAO;
import com.blastoide.jsf.Users;
import com.blastoide.jsfcontroller.UsersController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {

    private static String rol;

    public static String getRol() {
        return rol;
    }

    public static void setRol(String rol) {
        LoginDAO.rol = rol;
    }
    
    
    
    
	public static boolean validate(String user, String password) {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = DAO.getConnection();
			ps = con.prepareStatement("Select rol, uname, password from Users where uname = ? and password = ?");
			ps.setString(1, user);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				//result found, means valid inputs
                                
                                //UsuarioDAO usuariodao = new UsuarioDAO();
                                //usuariodao.BuscarUsuario("uname");
                                
                                
                                System.err.println("rol: " + rs.getString("rol"));
                                setRol(rs.getString("rol"));
                                
                                return true;

			}
		} catch (SQLException ex) {
			System.out.println("Login error -->" + ex.getMessage());
			return false;
		} finally {
			DAO.close(con);
		}
		return false;
	}
        
        
        
}







