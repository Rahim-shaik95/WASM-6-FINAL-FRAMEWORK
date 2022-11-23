package vtigerPractive;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Login_Operation {
	
	public static void main(String[] args) throws Exception {
	
		//step 1 Read the required data
		FileInputStream fis =new FileInputStream(".\\src\\test\\resources\\commonData.properties");
		Properties pro =new Properties();
		pro.load(fis);
		String USERNAME =pro.getProperty("username");
		String PASSWORD =pro.getProperty("password");
		String URL =pro.getProperty("url");
		String BROWSER =pro.getProperty("browser");
		
		WebDriver driver = null;
		// Step 2 launch the browser
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver =new ChromeDriver();
			System.out.println("---------"+BROWSER+"IS LAUNCHED"+"----");
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			System.out.println("---------"+BROWSER+"IS LAUNCHED"+"----");
		}
		else 
		{
			System.out.println("invalid browser name");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get(URL);
		
		//LOGIN TO application
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		
	}	
}
