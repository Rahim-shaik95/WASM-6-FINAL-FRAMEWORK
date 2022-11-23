package vTiger.contact;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ObjectRepository.ContactsInfoPage;
import ObjectRepository.ContactsPage;
import ObjectRepository.CreateNewContactPage;
import ObjectRepository.CreateNewOrganizationPage;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import ObjectRepository.OrganizationsInfoPage;
import ObjectRepository.OrganizationsPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import vTigerGenericLiberary.BaseClass;
import vTigerGenericLiberary.ExcelFiLeLiberary;
import vTigerGenericLiberary.JavaLiberary;
import vTigerGenericLiberary.PropertyFileLiberary;
import vTigerGenericLiberary.WebdriverLibrary;

@Listeners(vTigerGenericLiberary.ListnerImplementationLibrary.class)
public class createContactWithOrganization extends BaseClass  {
	@Test(groups="regressionsuite")
	
	public void createContactWithorg() throws IOException {
		
		//Step 1: Reade data from
	    
	    String LASTNAME = eLib.readDataFromExceL("Contacts", 4, 2)+jLib.getRandomNumber();
	    String ORGNAME = eLib.readDataFromExceL("Contacts", 4, 3)+jLib.getRandomNumber();
		
		//step4: navigate to organization link
		  HomePage hp =new HomePage(driver);
		   hp.clickOrganizationsLnk();
		   Reporter.log("Organization link is clicked ",true);
		   
		 // step 5 : navigate to create organization look up page
		   OrganizationsPage op =new OrganizationsPage(driver);
		    op.clickOnCreateOrgImg();
		    Reporter.log("Organization lookup page is clicked",true);
		    
		    //step6 : create new organization and save
		   CreateNewOrganizationPage cnop =new CreateNewOrganizationPage(driver);
		   cnop.createNewOrg(ORGNAME);
	   
	   // Step 7 : validate for organization
	    OrganizationsInfoPage oip=new OrganizationsInfoPage(driver);
	    String orgHeader =oip.getOrgHeader();
	    Assert.assertTrue( orgHeader.contains(ORGNAME),"Organization is created");
	     Reporter.log("Organization is created successfully",true);
	     
		  //Step 9 : navigate to contacts link
		   hp.clickContactsLnk();
		   Reporter.log("Contacts page is clicked",true);  
		   
		  //Step 10 : navigate to create contact lookup page
		   ContactsPage cp =new ContactsPage(driver);
		   cp.clickOnCreateContactImg();
		   Reporter.log("Contact look up page is clicked",true);
		  
		  //Step 11 : create contact with manidatory fields
		  CreateNewContactPage cncp =new CreateNewContactPage(driver);
		 cncp.createNewContact(LASTNAME, ORGNAME, driver);
		  
		//Step 12: validation
		  ContactsInfoPage cip =new ContactsInfoPage(driver);
		  String contactHeader =cip.getContactHeader();
		   Assert.assertTrue( contactHeader.contains(LASTNAME),"Contact is createad");
		   Reporter.log("Contact is creataed ",true);
		   
		  //step 13: logout
		   hp.signOutOfApp(driver); 
	}
		
}

	
	

	
