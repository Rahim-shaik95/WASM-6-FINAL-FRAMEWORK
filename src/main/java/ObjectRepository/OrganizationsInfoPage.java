package ObjectRepository;

		import org.openqa.selenium.WebDriver;
		import org.openqa.selenium.WebElement;
		import org.openqa.selenium.support.FindBy;
		import org.openqa.selenium.support.PageFactory;

import vTigerGenericLiberary.WebdriverLibrary;

	

		public class OrganizationsInfoPage extends WebdriverLibrary{
			//declaration
			@FindBy(xpath="//span[@class='dvHeaderText']")
			private WebElement Orgheader;
			
			//initialization
			/**
			 * 
			 * @param driver
			 */
			public OrganizationsInfoPage(WebDriver driver)
			{
				PageFactory.initElements(driver, this);
			}

			//utilization
			/**
			 * 
			 * @return
			 */
			public WebElement getOrgheader() {
				return Orgheader;
			}
			
			//Business library
			/**
			 * 
			 * @return
			 */
			public String getOrgHeader()
			{
				return Orgheader.getText();
			}

		}

	
