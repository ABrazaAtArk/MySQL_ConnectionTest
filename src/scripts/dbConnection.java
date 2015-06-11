package scripts;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class dbConnection {

		 public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
	     String dbUrl = "jdbc:postgresql://localhost:5432/arkncc";
		 String username = "arkncc";
		 String password = "password";
         String query1    = "select userid from login;";
         String query2    = "select firstname from login;";
         String query3    = "select lastname from login;";
         String query4    = "select id_number from login;";
         
		 Class.forName("org.postgresql.Driver");
		 
	     Connection con = DriverManager.getConnection(dbUrl,username,password);
			  
		 System.out.println("Connected to database");
			 
		 Statement stmt1 =con.createStatement();
		 Statement stmt2 =con.createStatement();
		 Statement stmt3 =con.createStatement();
		 Statement stmt4 =con.createStatement();
		 
		 ResultSet rs1 = stmt1.executeQuery(query1);
		 ResultSet rs2 = stmt2.executeQuery(query2);
		 ResultSet rs3 = stmt3.executeQuery(query3);
		 ResultSet rs4 = stmt4.executeQuery(query4);
		 
		  while (rs1.next()) {
		      String userID = rs1.getString(1);
			  System.out.println(userID);
			  }
		  while (rs2.next()) {
		      String userFName = rs2.getString(1);
			  System.out.println(userFName);
			  }
		  
		  while (rs3.next()) {
		      String userLName = rs3.getString(1);
			  System.out.println(userLName);
			  }

		  while (rs4.next()) {
		      String IDNumber = rs4.getString(1);
			  System.out.println(IDNumber);
			  }

		  
        con.close();
		System.out.println("Connection closed");
		
		 }
		
}			




