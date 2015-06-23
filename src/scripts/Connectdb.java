package scripts;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connectdb {

		 public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
	     String dbUrl = "jdbc:mysql://localhost:3306/assetcore";
		 String username = "root";
		 String password = "password";
         String query1    = "select * from Person;";
         
		 Class.forName("org.postgresql.Driver");
		 
	     Connection con = DriverManager.getConnection(dbUrl,username,password);
			  
		 System.out.println("Connected to database");
			 
		 Statement stmt1 =con.createStatement();

		 
		 ResultSet rs1 = stmt1.executeQuery(query1);

		  while (rs1.next()) {
		      String userID = rs1.getString(1);
			  System.out.println(userID);
			  }
		  
        con.close();
		System.out.println("Connection closed");
		
		 }
		
}			




