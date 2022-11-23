package vTiger.organization;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hpsf.HPSFException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import ObjectRepository.CreateNewOrganizationPage;
import ObjectRepository.HomePage;
import ObjectRepository.OrganizationsPage;
import vTigerGenericLiberary.BaseClass;

@Listeners(vTigerGenericLiberary.ListnerImplementationLibrary.class)
public class CreateOrganiztion extends BaseClass{
	
	@Test
	public void createOrganizationTest() throws EncryptedDocumentException, IOException
	{
		//read  the data 
		String orgname = eLib.readDataFromExceL("Organization", 1, 2)+jLib.getRandomNumber();
		
		//navigate to organizations link
		HomePage hp =new HomePage(driver);
		hp.clickOrganizationsLnk();
		
		//enter  data inmanidatorty fields and save
		 OrganizationsPage op =new OrganizationsPage(driver);
		 op.clickOnCreateOrgImg();
		 
		 CreateNewOrganizationPage cnop =new CreateNewOrganizationPage(driver);
		 cnop.createNewOrg(orgname);
	
	}
}
