package vTiger.contact;

import static org.testng.Assert.fail;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ObjectRepository.ContactsInfoPage;
import ObjectRepository.ContactsPage;
import ObjectRepository.CreateNewContactPage;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import vTigerGenericLiberary.BaseClass;
import vTigerGenericLiberary.ExcelFiLeLiberary;
import vTigerGenericLiberary.JavaLiberary;
import vTigerGenericLiberary.PropertyFileLiberary;
import vTigerGenericLiberary.WebdriverLibrary;

@Listeners(vTigerGenericLiberary.ListnerImplementationLibrary.class)
public class Create_contact extends BaseClass {

	@Test(groups ="smokesuite")
	public void createContact() throws IOException  {
		
		String LASTNAME =eLib.readDataFromExceL("Contacts", 1, 2)+jLib.getRandomNumber();
		
	  
	  //Step 5 : navigate to contacts link
	  HomePage hp =new HomePage(driver);
	  hp.clickContactsLnk();
	  
	  //Step 6 : navigate to create contact lookup page
	  ContactsPage cp =new ContactsPage(driver);
	  cp.clickOnCreateContactImg();
	  
	  //Step 7 : create contact with manidatory fields
     CreateNewContactPage ccp =new CreateNewContactPage(driver);
     ccp.createNewContact(LASTNAME);
	  
	  //Step 8:  Validation
     ContactsInfoPage cip =new ContactsInfoPage(driver);
	  String contactHeader =cip.getContactHeader();
	   Assert.assertTrue( contactHeader.contains(LASTNAME),"Contact is creataed");
	  
	      // logout of application
	        hp.signOutOfApp(driver);
	}
	
	  @Test(groups ={"regressionsuite","smokesuite"})
	  public void createContactWithDemoTest()
	  {
		  System.out.println("Demo test");
		 
	  }
	 
	  @Test
	  public void createContactWithLeadSource()
	  {
		  System.out.println("With laed sourse");
		  
	  }
	  @Test
	  public void createContactWithLeadSourceAndOrg()
	  {
		  System.out.println("laed source with org");
		  
	  }
	  
	}
	



