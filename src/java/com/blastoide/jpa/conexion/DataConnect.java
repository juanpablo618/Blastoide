/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package com.blastoide.jpa.conexion;

/**
 *
 * @author cuello.juanpablo@gmail.com
 * http://www.journaldev.com/7252/jsf-authentication-login-logout-database-example
 */
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//
//public class DataConnect {
//
//	public static Connection getConnection() {
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			Connection con = DriverManager.getConnection(
//					"jdbc:mysql://localhost:3306/Blastoide", "root", "");
//			return con;
//		} catch (Exception ex) {
//			System.out.println("Database.getConnection() Error -->"
//					+ ex.getMessage());
//			return null;
//		}
//	}
//
//	public static void close(Connection con) {
//		try {
//			con.close();
//		} catch (Exception ex) {
//		}
//	}
//}