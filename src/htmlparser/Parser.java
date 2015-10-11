/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package htmlparser;

import com.parser.menu.Database;
import com.parser.menu.UserDB;
import java.io.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;

import java.net.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author admin
 */
public class Parser {
                    private static int percentage_count = 0;
        public static void ParseLink(String userLink)  throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
                ArrayList<Data> DataList = new ArrayList<Data>();
	        Document doc;
                 Database object = new Database();  
                  String host = "jdbc:mysql://localhost:3306/test";
                  
	          String user = "root";
                        
	          String pass = "pass";
                        
	          String DRIVER = "com.mysql.jdbc.Driver";
	           Connection con = null;
                try {
	 /* Establish MySQL connection  */ 
                   Class.forName(DRIVER);
		   con = (Connection) DriverManager.getConnection(host, user, pass);
		   Statement s = (Statement) con.createStatement();
           /* Parse method Button */
		 URL url = new URL(userLink);
		 URLConnection conn = url.openConnection();
		 conn.setDoOutput(true);
                   int i_count=0;
		doc = Jsoup.parse(conn.getInputStream(), "UTF-8", userLink);
		Elements content = doc.getElementsByTag("table");
		Element k = content.get(1);
		Elements content2 = k.getElementsByTag("tr");
		for (Element link : content2) {
			Elements content3 = link.getElementsByTag("td");
			 int count = 0;
			  Data data1 = new Data();
			  for (Element link1 : content3) {
				  String linkText2 = link1.text();//for each column element get the value.
                                       i_count++;
                                       setPercentage_count(i_count);
				     if (count == 0) { 
				    	 data1.setIDstring(linkText2);
				          } else if (count == 1) {
				              data1.setSechkiIDstring(linkText2);
				          } else if (count == 2) {
				              data1.setPageIDstring(linkText2);
				          } else if (count == 3) {
				              data1.setName(linkText2);
				          } else if (count == 4) {
				              data1.setAddress(linkText2);
				          } else if (count == 5) {
				        	  data1.setYearString(linkText2);
				          }
				              count++;
				          }
			                  if (count != 0) {
				                  DataList.add(data1);
				                }
			                  s.executeUpdate("INSERT INTO azerbaijan_nesemi (IDstring, sechkiID, pageID, name, address, year) VALUES ('" + data1.getIDstring() + "', '" + data1.getSechkiIDstring() + "', '" + data1.getPageIDstring() + "','" + data1.getName()+"', '" + data1.getAddress() + "', '" + data1.getYearString() + "')");
						    	 System.out.println(DataList);   
		} 
	} catch (IOException e) {
		e.printStackTrace();
	}  catch (ClassNotFoundException e) {
		  System.out.println(e.getMessage());
  }   catch (SQLException e) {
	  e.printStackTrace();
    }
                
 }

    /**
     * @return the percentage_count
     */
    public static int getPercentage_count() {
        return percentage_count;
    }

    /**
     * @param percentage_count the percentage_count to set
     */
    public static void setPercentage_count(int percentage_count) {
        Parser.percentage_count = percentage_count;
    }
}

