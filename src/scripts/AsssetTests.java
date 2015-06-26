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

	public class AsssetTests {
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
	  public void testTemp() throws Exception {
  		System.out.println("Connection to AssetCore/login opened for testBuild3Asset"); 
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
	    System.out.println("Connection to AssetCore/login closed for testBuild3Asset"); 
	    System.out.println();
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
	
	  public  void main(String[] args) throws ClassNotFoundException, SQLException {
			//System.setProperty("webdriver.ie.driver", "C:\\Selenium\\IEDriverServer.exe");	
			//WebDriver driver = new InternetExplorerDriver();
		     String dbUrl = "jdbc:mysql://localhost:3306/one";
			 String username = "root";
			 String password = "password";
	         String query1    = "select name from pets;";
	         String query2    = "select owner from pets;";
	         String query3    = "select species from pets;";
	         String query4    = "select sex from pets;";
	         String query5    = "select birth from pets;";         
	         String query6    = "select death from pets;";      
	         String query7    = "select * from pets;"; 
	                 
			Connection con = DriverManager.getConnection(dbUrl,username,password);
			 
			System.out.println("Connected to database");
			 
			Statement stmt1 =con.createStatement();
			Statement stmt2 =con.createStatement();
			Statement stmt3 =con.createStatement();
			Statement stmt4 =con.createStatement();
			Statement stmt5 =con.createStatement();
			Statement stmt6 =con.createStatement();
			Statement stmt7 =con.createStatement();

			
			ResultSet rs1 = stmt1.executeQuery(query1);
			ResultSet rs2 = stmt2.executeQuery(query2);
			ResultSet rs3 = stmt3.executeQuery(query3);
			ResultSet rs4 = stmt4.executeQuery(query4);
			ResultSet rs5 = stmt5.executeQuery(query5);
			ResultSet rs6 = stmt6.executeQuery(query6);
			ResultSet rs7 = stmt7.executeQuery(query7);

			
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
			  
			  while (rs5.next()) {
			      String IDNumber = rs5.getString(1);
				  System.out.println(IDNumber);
				  }
			  
			  while (rs6.next()) {
			      String IDNumber = rs6.getString(1);
				  System.out.println(IDNumber);
				  }
			  
			  while (rs7.next()) {
			      String Name = rs7.getString(1);
				  System.out.print(Name + ' ');
			      String Owner = rs7.getString(2);
				  System.out.print(Owner + ' ');
			      String Species = rs7.getString(3);
				  System.out.print(Species + ' ');
			      String Sex = rs7.getString(4);
				  System.out.print(Sex + ' ');
			      String Birth = rs7.getString(5);
				  System.out.println(Birth + ' ');
				  }
			  
	        con.close();
			System.out.println("Connection closed");
			
	   System.out.println("Connection to AssetCore/login opened for testBuild3Asset"); 
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
	    System.out.println("Connection to AssetCore/login closed for testBuild3Asset"); 
	    System.out.println();	
		 
	    
		}
	}

