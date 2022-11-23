package vtigerPractive;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactAndOrgnameWithDDT {

	
	public static void main(String[] args) throws Exception {
		//Step 1: read the required data
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\commonData.properties");
		Properties pobj = new Properties();
		pobj.load(fis);
		String BROWSER = pobj.getProperty("browser");
		String URL = pobj.getProperty("url");
		String USERNAME = pobj.getProperty("username");
		String PASSWORD = pobj.getProperty("password");
		
		FileInputStream fis1 = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet sh = wb.getSheet("Contacts");
		Row rw = sh.getRow(1);
		Cell cl = rw.getCell(2);
		String LASTNAME = cl.getStringCellValue();
		
		Row rw1 = sh.getRow(4);
		Cell cl1 = rw.getCell(3);
		String OrgName = cl.getStringCellValue();
			
		WebDriver driver = null;
		
		//Step 2: Launch the browser - RUN TIME POLYMORPHISM
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
		    driver = new ChromeDriver();
			System.out.println("=== "+BROWSER+" is launched ===");
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println("=== "+BROWSER+" is launched ===");
		}
		else
		{
			System.out.println("invalid Browser name");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(URL);
		
		//Step 3: Login to the application
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
				
		//Step 4: Navigate to contacts link
		driver.findElement(By.linkText("Contacts")).click();
			
		//Step 5: create contact with mandatory fields
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
		driver.findElement(By.xpath("(//img[@title='Select'])[1]")).click();
		
		String parentid=driver.getWindowHandle();
		Set<String>Childid =driver.getWindowHandles();
		for(String allid :Childid)
		{
		  if(!parentid.equals(allid))
		  {
			  driver.switchTo().window(allid);
		  }
		}
				driver.findElement(By.xpath("//input[@id='search_txt']")).sendKeys(OrgName);
				driver.findElement(By.xpath("//input[@name='search']")).click();
				driver.findElement(By.xpath("//a[text()='Wipros']")).click();
				
		//step 6: save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				
		//Step 7 : logout browser
		WebElement element = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
				
		driver.findElement(By.linkText("Sign Out")).click();
		
	}
}
