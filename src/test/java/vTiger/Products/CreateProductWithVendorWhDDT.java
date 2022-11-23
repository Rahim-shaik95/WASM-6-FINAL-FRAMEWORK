package vTiger.Products;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.WebDriverListener;
import io.github.bonigarcia.wdm.WebDriverManager;
import vTigerGenericLiberary.ExcelFiLeLiberary;
import vTigerGenericLiberary.JavaLiberary;
import vTigerGenericLiberary.PropertyFileLiberary;
import vTigerGenericLiberary.WebdriverLibrary;

public class CreateProductWithVendorWhDDT {
	
 public static void main(String[] args) throws IOException {
     	 
	 JavaLiberary jLib =new JavaLiberary();
	 ExcelFiLeLiberary eLib =new ExcelFiLeLiberary();
	 WebdriverLibrary wLib =new WebdriverLibrary();
	 PropertyFileLiberary pLib=new PropertyFileLiberary();
	 
	 String BROWSERNAME =pLib.readDataFromPropertiesFile("browser");
	 String URL= pLib.readDataFromPropertiesFile("url");
	 String USERNAME=pLib.readDataFromPropertiesFile("username");
	 String PASSWORD =pLib.readDataFromPropertiesFile("password");
	 
     String PRODUCTNAME=eLib.readDataFromExceL("Products", 4, 2)+jLib.getRandomNumber();
	 String VENDORNAME=eLib.readDataFromExceL("Products", 4, 3)+jLib.getRandomNumber();
	 
	 WebDriver driver =null;
	 //launch browser
	    if(BROWSERNAME.equalsIgnoreCase("chrome"))
	    {
	    	WebDriverManager.chromedriver().setup();
	    	driver =new ChromeDriver();
	    }
	    else if(BROWSERNAME.equalsIgnoreCase("FIREFOX"))
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
		WebElement moreDropDown = driver.findElement(By.xpath("//img[@src='themes/softed/images/menuDnArrow.gif']"));
		wLib.mouseHoverOn(driver, moreDropDown);
		driver.findElement(By.name("Vendors")).click();
	 
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
	System.out.println("Vendor is created");
   }
   else 
   {
	   System.out.println("Vendor creation is not done");
   }
	    
		//
		driver.findElement(By.linkText("Products")).click();
		
		//
		driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		
		//
		driver.findElement(By.xpath("//input[@name='productname']")).sendKeys(PRODUCTNAME);
		driver.findElement(By.xpath("//img[@title='Select']")).click();
		
		wLib.switchToWindow(driver," Vendors");
		driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys(VENDORNAME);
	    driver.findElement(By.xpath("//input[@name='search']")).click();
	    driver.findElement(By.linkText(VENDORNAME)).click();
	    wLib.switchToWindow(driver,"Products");
	    
	    driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	 //
	  String admname=    driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
	  System.out.println(admname);
	 if(admname.contains(PRODUCTNAME))
	 {
		 System.out.println("pass");
	 }
	 else
	 {
		 System.out.println("fail");
	 }
	 
	 //
     WebElement adminimg =driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	  wLib.mouseHoverOn(driver, adminimg);
	  driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	  //
	  wLib.closeApplication(driver);
 	}
}
