package ObjectRepository;

	import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
    import vTigerGenericLiberary.WebdriverLibrary;

	public class CreateNewContactPage extends WebdriverLibrary{
		
		//declaration
		@FindBy(name="lastname")
		private WebElement lastNameEdt;
		
		@FindBy(name="leadsource")
		private WebElement leadSourceDropDown;
		
		@FindBy(xpath="//input[@name='account_name']/following-sibling::img[@title='Select']")
		private WebElement organizationImg;
		
		@FindBy(name="search_text")
		private WebElement searchEdt;
		
		@FindBy(name="search")
		private WebElement searchBtn;
		
		@FindBy(xpath="//input[@title='Save [Alt+S]']")
		private WebElement saveBtn;
		
		//initialization
		public CreateNewContactPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
		//utilization
		public WebElement getLastNameEdt() {
			return lastNameEdt;
		}

		public WebElement getLeadSourceDropDown() {
			return leadSourceDropDown;
		}

		public WebElement getOrganizationImg() {
			return organizationImg;
		}

		public WebElement getSearchEdt() {
			return searchEdt;
		}

		public WebElement getSearchBtn() {
			return searchBtn;
		}

		public WebElement getSaveBtn() {
			return saveBtn;
		}
		
		//Business library
		/**
		 * This method will create new contact with last name
		 * @param lastname
		 */
		public void createNewContact(String lastname)
		{
			lastNameEdt.sendKeys(lastname);
			saveBtn.click();
		}
		
		/**
		 * This method will create new contact with lead source drop down
		 * @param lastname
		 * @param leadSourceValue
		 */
		public void createNewContact(String lastname, String leadSourceValue)
		{
			lastNameEdt.sendKeys(lastname);
			handleDropDown(leadSourceDropDown, leadSourceValue);
			saveBtn.click();
		}
		/**
		 * This method will create new contact with organization 
		 * @param lastname
		 * @param orgname
		 * @param driver
		 */
		public void createNewContact(String lastname,String orgname,WebDriver driver)
		{
			lastNameEdt.sendKeys(lastname);
			organizationImg.click();
			switchToWindow(driver, "Accounts");
			searchEdt.sendKeys(orgname);
			searchBtn.click();
			driver.findElement(By.xpath("//a[text() ='"+orgname+"']")).click();
			switchToWindow(driver, "Contacts");
			saveBtn.click();
		}
		
	}


