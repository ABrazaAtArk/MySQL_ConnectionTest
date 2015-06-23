package scripts;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import org.junit.Ignore;
import static org.junit.Assert.assertEquals;
import java.lang.Object;

public class Connectdb {

		 public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
	     String dbUrl = "jdbc:mysql://localhost:3306/one";
		 String username = "root";
		 String password = "password";
         String query1    = "select * from pets;";
         String Text1     = "Text";
         
//		 Class.forName("org.mysql.jdbc.Driver");
		 
	     Connection con = DriverManager.getConnection(dbUrl,username,password);
			  
		 System.out.println("Connected to database");
	      org.junit.Assert.assertEquals("failure - strings are not equal", "text", "text");	 
		 Statement stmt1 =con.createStatement();

		 
		 ResultSet rs1 = stmt1.executeQuery(query1);

		  while (rs1.next()) {
		      String userID = rs1.getString(1);
		      int returncode = 0;
			  System.out.println(userID);
//			   returncode = org.junit.Assert.assertNotNull(userID);
			   System.out.println("returncode" + returncode);
			  }
  
	      org.junit.Assert.assertEquals("failure - strings are not equal", "test1", "text");
		  
        con.close();
		System.out.println("Connection closed");
		
	      
	      Result result = JUnitCore.runClasses(TestJunit2.class);
	      for (Failure failure : result.getFailures()) {
	         System.out.println(failure.toString());
	      }
	      System.out.println("TestJunit2 is " + result.wasSuccessful());
	      
		 }

	 	
		
}			








