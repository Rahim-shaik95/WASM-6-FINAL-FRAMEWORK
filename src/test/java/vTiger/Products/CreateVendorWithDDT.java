package vTiger.Products;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTigerGenericLiberary.ExcelFiLeLiberary;
import vTigerGenericLiberary.IconstantsLiberary;
import vTigerGenericLiberary.JavaLiberary;
import vTigerGenericLiberary.PropertyFileLiberary;
import vTigerGenericLiberary.WebdriverLibrary;

public class CreateVendorWithDDT {
	
 public static void main(String[] args) throws IOException {
	
	 JavaLiberary jLib=new JavaLiberary();
	 PropertyFileLiberary pLib=new PropertyFileLiberary();
	 ExcelFiLeLiberary eLib =new ExcelFiLeLiberary();
	 WebdriverLibrary wLib =new WebdriverLibrary();
	 
	//Step 1 : Read all the required data
	String BROWSER=pLib.readDataFromPropertiesFile("browser");
	String URL= pLib.readDataFromPropertiesFile("url");
	String USERNAME=pLib.readDataFromPropertiesFile("username");
	String PASSWORD =pLib.readDataFromPropertiesFile("password");
	
	   String VENDORNAME = eLib.readDataFromExceL("Vendors",1 , 2)+jLib.getRandomNumber();
	 
	    WebDriver driver =null;
	 //launch browser
	    if(BROWSER.equalsIgnoreCase("chrome"))
	    {
	    	WebDriverManager.chromedriver().setup();
	    	driver =new ChromeDriver();
	    }
	    else if(BROWSER.equalsIgnoreCase("FIREFOX"))
	    {
	    	WebDriverManager.firefoxdriver().setup();
	    	driver =new FirefoxDriver();
	    }
	    else
	    {
	    	System.out.println("invalid browser");
	    }
	    driver.manage().window().maximize();
	    wLib.waitingForPageLoad(driver);
	    driver.get(URL);
	    
	    //login to application
	    driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
	    
		//navigate to vendor link
		WebElement ven =driver.findElement(By.xpath("//a[text()='More']"));
		wLib.mouseHoverOn(driver,ven);
	     driver.findElement(By.xpath("//a[@name='Vendors']")).click();
	 
	 //
	    driver.findElement(By.xpath("//img[@title='Create Vendor...']")).click();
	    
	    //
	    driver.findElement(By.xpath("//input[@name='vendorname']")).sendKeys(VENDORNAME);
	    driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	    
	    //Validation
	      String adminname = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
	      System.out.println(adminname);
   if(adminname.contains(VENDORNAME))
   {
	System.out.println("Pass");
   }
   else 
   {
	   System.out.println("Fail");
   }
  //
      WebElement adminimg =driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	  wLib.mouseHoverOn(driver, adminimg);
	  driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	      
}
}
