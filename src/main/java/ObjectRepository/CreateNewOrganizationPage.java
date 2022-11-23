package ObjectRepository;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
    import vTigerGenericLiberary.WebdriverLibrary;

	public class CreateNewOrganizationPage extends WebdriverLibrary{
		
		//declaration
		@FindBy(name="accountname")
		private WebElement OrgNameEdt;
		
		@FindBy(name="industry")
		private WebElement industryDropDown;
		
		@FindBy(name="accounttype")
		private WebElement typeDropDown;
		
		@FindBy(xpath="//input[@title='Save [Alt+S]']")
		private WebElement saveBtn;
		
		//initialization
		public CreateNewOrganizationPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}

		//utilization
		public WebElement getOrgNameEdt() {
			return OrgNameEdt;
		}

		public WebElement getIndustryDropDown() {
			return industryDropDown;
		}

		public WebElement getTypeDropDown() {
			return typeDropDown;
		}

		public WebElement getSaveBtn() {
			return saveBtn;
		}
		
		//Business library
		/**
		 * This method will create new organization
		 * @param Orgname
		 */
		public void createNewOrg(String Orgname)
		{
			OrgNameEdt.sendKeys(Orgname);
			saveBtn.click();
		}
		
		/**
		 * This method will create organization with industry type
		 * @param orgName
		 * @param indType
		 */
		public void createNewOrg(String orgName, String indType)
		{
			OrgNameEdt.sendKeys(orgName);
			handleDropDown(indType, industryDropDown);
			saveBtn.click();
		}
		
		/**
		 * This method will create organization with industry and type
		 * @param orgName
		 * @param indType
		 * @param type
		 */
		public void createNewOrg(String orgName, String indType, String type)
		{
			OrgNameEdt.sendKeys(orgName);
			handleDropDown(indType, industryDropDown);
			handleDropDown(type, typeDropDown);
			saveBtn.click();
		}
		
	}


