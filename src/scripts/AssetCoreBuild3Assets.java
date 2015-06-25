package scripts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
	

	import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

	import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

	public class AssetCoreBuild3Assets {
	  private WebDriver driver;
	  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();

      
	  @Before
	  public void setUp() throws Exception {
	    driver = new FirefoxDriver();
	    baseUrl = "http://localhost:8012/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }

	  @Test
	  public void DBClearAssetTable() throws Exception {
		     String dbUrl = "jdbc:mysql://localhost:3306/assetcore";
			 String username = "root";
			 String password = "password";
//	         String query1    = "delete from asset where id > 1;";
	         String query2    = "select count(*) from asset;";
			 
			Connection con = DriverManager.getConnection(dbUrl,username,password);
			 
			System.out.println("Connected to database");
			 
//			Statement stmt1 =con.createStatement();
			Statement stmt2 =con.createStatement();
			
//		    stmt1.executeUpdate(query1);
			ResultSet rs2 = stmt2.executeQuery(query2);
			
			  while (rs2.next()) {
			  String  CountOfRecords = rs2.getString(1);
				  System.out.println(CountOfRecords);
				  org.junit.Assert.assertEquals("failure - strings are not equal", CountOfRecords, String.valueOf('4'));
			  }  
			    
	        con.close();
			System.out.println("Connection closed");
	}
	  
	  @Test
	  public void testBuild3Assets() throws Exception {
		     String dbUrl = "jdbc:mysql://localhost:3306/assetcore";
			 String username = "root";
			 String password = "password";
	         String query1    = "delete from asset where id > 1;";
	         String query2    = "select count(*) from asset;";
			 
			Connection con = DriverManager.getConnection(dbUrl,username,password);
			 
			System.out.println("Connected to database");
			 
			Statement stmt1 =con.createStatement();
			Statement stmt2 =con.createStatement();
			
		    stmt1.executeUpdate(query1);
			ResultSet rs2 = stmt2.executeQuery(query2);
			
			  while (rs2.next()) {
			      String CountOfRecords = rs2.getString(1);
				  System.out.println(CountOfRecords);
				  }
		  
	        con.close();
			System.out.println("Connection closed");  
		  
	    driver.get(baseUrl + "/AssetCore/login");
	    driver.findElement(By.name("username")).clear();
	    driver.findElement(By.name("username")).sendKeys("a");
	    driver.findElement(By.name("password")).clear();
	    driver.findElement(By.name("password")).sendKeys("a");
	    driver.findElement(By.name("submit")).click();
	    driver.findElement(By.id("topNavButtonAddChildId")).click();
	    driver.findElement(By.id("newAssetNameId")).clear();
	    driver.findElement(By.id("newAssetNameId")).sendKeys("a1");
	    driver.findElement(By.name("submit")).click();
	    driver.findElement(By.id("topNavOverlayId")).click();
	    driver.findElement(By.id("topNavButtonAddChildId")).click();
	    driver.findElement(By.id("newAssetNameId")).clear();
	    driver.findElement(By.id("newAssetNameId")).sendKeys("a2");
	    new Select(driver.findElement(By.id("newAssetArchetypeId"))).selectByVisibleText("Information System");
	    driver.findElement(By.name("submit")).click();
	    driver.findElement(By.id("topNavOverlayId")).click();
	    driver.findElement(By.id("topNavButtonAddChildId")).click();
	    driver.findElement(By.id("newAssetNameId")).clear();
	    driver.findElement(By.id("newAssetNameId")).sendKeys("a3");
	    new Select(driver.findElement(By.id("newAssetArchetypeId"))).selectByVisibleText("Data");
	    driver.findElement(By.name("submit")).click();
	    driver.findElement(By.id("topNavOverlayId")).click();
	    driver.findElement(By.id("topNavButtonSaveId")).click();
	    driver.findElement(By.id("topNavUserNameId")).click();
	    driver.findElement(By.id("signOutOfAssetId")).click();
	  }
	  
  
	  @After
	  public void tearDown() throws Exception {
	    driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	  }

	  private boolean isElementPresent(By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }

	  private boolean isAlertPresent() {
	    try {
	      driver.switchTo().alert();
	      return true;
	    } catch (NoAlertPresentException e) {
	      return false;
	    }
	  }

	  private String closeAlertAndGetItsText() {
	    try {
	      Alert alert = driver.switchTo().alert();
	      String alertText = alert.getText();
	      if (acceptNextAlert) {
	        alert.accept();
	      } else {
	        alert.dismiss();
	      }
	      return alertText;
	    } finally {
	      acceptNextAlert = true;
	    }
	  }
	}

