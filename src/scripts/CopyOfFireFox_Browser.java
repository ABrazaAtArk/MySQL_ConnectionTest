package scripts;

import java.sql.Connection;
import java.sql.DriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.*;

//DB Connection
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.postgresql.*;

public class CopyOfFireFox_Browser {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//System.setProperty("webdriver.ie.driver", "C:\\Selenium\\IEDriverServer.exe");	
		//WebDriver driver = new InternetExplorerDriver();
	     String dbUrl = "jdbc:postgresql://localhost:5432/arkncc";
		 String username = "arkncc";
		 String password = "password";
         String query1    = "select userid from login;";
         String query2    = "select firstname from login;";
         String query3    = "select lastname from login;";
         String query4    = "select id_number from login;";
         
         
    	WebDriver driver = new FirefoxDriver();
		driver.get("http://localhost:8012/AssetCore/");
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
	  
	    driver.get("http://localhost:8012/AssetCore/login");
		System.out.println(driver.getTitle());
		driver.findElement(By.id("username_or_email")).clear();
	    driver.findElement(By.id("username_or_email")).sendKeys("u");
	    driver.findElement(By.id("password")).clear();
	    driver.findElement(By.id("password")).sendKeys("p");
	    driver.findElement(By.id("remember_me")).click();
	    driver.findElement(By.id("login")).click();
	    driver.findElement(By.linkText("Manage")).click();
	    driver.findElement(By.linkText("View")).click();
	    driver.findElement(By.linkText("Reports")).click();
	    driver.findElement(By.linkText("?")).click();
	    driver.findElement(By.linkText("M")).click();
	    driver.findElement(By.xpath("(//a[contains(@href, '#')])[6]")).click();
	    driver.findElement(By.xpath("(//a[contains(@href, '#')])[7]")).click();
	    driver.findElement(By.linkText("<")).click();
	    driver.findElement(By.linkText("<")).click();
	    driver.findElement(By.linkText(">")).click();
	    driver.findElement(By.linkText("^")).click();
	    driver.findElement(By.linkText("+")).click();
	    driver.findElement(By.cssSelector("a.logo")).click();
	    
	    driver.close();
	    System.out.println("Connection closed");
	    
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
