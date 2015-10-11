/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parser.menu;

import java.sql.Connection;  
import java.sql.DriverManager;   
import java.sql.SQLException;

/**
 *
 * @author admin
 */

public class UserDB {
        private static Connection connectionUser;
        
         public static Connection getUserDBConnection() throws ClassNotFoundException, SQLException {
              Class.forName("com.mysql.jdbc.Driver");
              connectionUser = null;
               Database object = new Database();
                String user = "root";
                        user = object.getDb_user();
                String host = "jdbc:mysql://localhost:3306/test"; 
                   if(object.getDb_name().length()>1) { host += object.getDb_name(); }
                String pass = "pass";
                        pass = object.getDb_pass();
	try {
		connectionUser = DriverManager.getConnection(host,user,pass);
		return connectionUser;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
       connectionUser.close();
           return connectionUser;  
         }
}
