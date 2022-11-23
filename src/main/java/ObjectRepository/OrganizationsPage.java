package ObjectRepository;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
    import vTigerGenericLiberary.WebdriverLibrary;

	public class OrganizationsPage extends WebdriverLibrary{
		
		//declaration
		@FindBy(xpath="//img[@alt='Create Organization...']")
		private WebElement createOrgImg;
		
		//initialization
		public OrganizationsPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
		//utilization
		public WebElement getCreateOrgImg() {
			return createOrgImg;
		}
		
		//business library
		/**
		 * This method will click on create organization look up image
		 */
		public void clickOnCreateOrgImg()
		{
			createOrgImg.click();
		}

	}

