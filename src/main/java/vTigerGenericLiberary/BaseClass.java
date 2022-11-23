package vTigerGenericLiberary;

	import java.io.IOException;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.testng.annotations.AfterClass;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.AfterSuite;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.BeforeSuite;
    import org.testng.annotations.BeforeTest;
    import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
	import ObjectRepository.HomePage;
	import ObjectRepository.LoginPage;

	/**
	 * This is a generic class which consists of all basic configuration annotations
	 * @author Rahim
	 *
	 */
	public class BaseClass {
		
		public PropertyFileLiberary pLib = new PropertyFileLiberary();
		public ExcelFiLeLiberary eLib = new ExcelFiLeLiberary();
		public JavaLiberary jLib = new JavaLiberary();
		public WebdriverLibrary wLib = new WebdriverLibrary();
		public WebDriver driver = null;
		public static WebDriver sDriver;
		
		@BeforeSuite(groups ={"regressionsuite","smokesuite"})
		public void bsConfig()
		{
			System.out.println("--- database connected successfully ---");
		}
		//@Parameters("browser")
		//@BeforeTest
		@BeforeClass(groups ={"regressionsuite","smokesuite"})
		public void bcConfig(/*String BROWSER*/) throws IOException
		{
			String BROWSER = pLib.readDataFromPropertiesFile("browser");
			String URL = pLib.readDataFromPropertiesFile("url");
			
			if(BROWSER.equalsIgnoreCase("chrome"))
			{
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				System.out.println("--- Browser launched successfully -> "+BROWSER+" ---");
			}
			else if(BROWSER.equalsIgnoreCase("firefox"))
			{
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				System.out.println("--- Browser launched successfully -> "+BROWSER+" ---");
			}
			else
			{
				System.out.println("invalid browser name");
			}
			sDriver =driver;
			wLib.maximizeWindow(driver);
			wLib.waitingForPageLoad(driver);
			driver.get(URL);
		}
		
		@BeforeMethod(groups ={"regressionsuite","smokesuite"})
		public void bmConfig() throws IOException
		{
			String USERNAME = pLib.readDataFromPropertiesFile("username");
			String PASSWORD = pLib.readDataFromPropertiesFile("password");
			
			LoginPage lp = new LoginPage(driver);
			lp.loginToApp(USERNAME, PASSWORD);
			System.out.println(" --- login is successfull ---");
		}
		
		@AfterMethod(groups ={"regressionsuite","smokesuite"})
		public void amConfig()
		{
			HomePage hp = new HomePage(driver);
			hp.signOutOfApp(driver);
			System.out.println("--- Logout successfull ---");
		}
		
		@AfterClass(groups ={"regressionsuite","smokesuite"})
		public void acConfig()
		{
			driver.quit();
			System.out.println("--- browser closed successfully ---");
		}
		
		@AfterSuite(groups ={"regressionsuite","smokesuite"})
		public void asConfig()
		{
			System.out.println("--- database closed successfully ---");
		}

	}


