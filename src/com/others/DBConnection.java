/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.others;

import java.sql.Connection;  
import java.sql.DriverManager;   
import java.sql.SQLException;
/**
 *
 * @author admin
 */
public class DBConnection {
      
         private static Connection connection;
         
         public static Connection getDBConnection() throws ClassNotFoundException, SQLException {
              Class.forName("com.mysql.jdbc.Driver");
              connection = null;
	try {
              
		connection = DriverManager.getConnection("jdbc:mysql://localhost/test","root","pass");
		return connection;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
       connection.close();
           return connection;  
         }
}
