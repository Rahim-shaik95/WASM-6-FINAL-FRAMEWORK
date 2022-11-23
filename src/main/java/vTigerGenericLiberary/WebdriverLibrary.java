package vTigerGenericLiberary;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class contains all the generic methods related to web driver actions
 * @author Rahim
 *
 */
public class WebdriverLibrary {
   /**
    * This Method  will maximize the window
    * @param driver
    */
	public void maximizeWindow(WebDriver driver)
	{
	   driver.manage().window().maximize();
	}
	/**
	 *  This method will minimize the window
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	/**
	 * This method will wait for 20secs to load the web page
	 * @param driver
	 */
	public void waitingForPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	}
	/**
	 * This method will wait for 10 seconds for element to be visible
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeVisible(WebDriver driver ,WebElement element)
	{
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(10L));
		 wait.until(ExpectedConditions.visibilityOfAllElements(element));	
	}
	/**
	 * This method will wait for 10 seconds for the element to be clickable 
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeClickable(WebDriver driver ,WebElement element)
	{
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(10L));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * This is a custom wait which is used to wait for element and perform click actions
	 * @param element
	 * @throws InterruptedException
	 */
	public void waitAndClickOnElement(WebElement element) throws InterruptedException
	{
		int count =0;
		while(count<10)
		{
			try
		     	{
				    element.click();
			         break;
		     	}
			catch (Exception e) 
		     	{
			     	Thread.sleep(1000);
			     	count++;
		    	}
	    }
	}
	/**
	 * This method will handle drop down through select class and select data by index
	 * @param element
	 * @param index
	 */
	public void handleDropDown(WebElement element, int index )
	{
	  Select s =new Select(element);
	  s.selectByIndex(index); 
	}
	/**
	 * This method will handle drop down through select class and select data by value
	 * @param element
	 * @param value
	 */
	public void handleDropDown(WebElement element ,String value)
	{
		 Select s =new Select(element);
		 s.selectByValue(value);
	}
	/**
	 * This method will handle drop down through select class and select data by visible text
	 * @param text
	 * @param element
	 */
	public void handleDropDown(String text,WebElement element)
	    {
		Select s =new Select(element);
		s.selectByVisibleText(text);
		}

	/**
	 * This method will perform mouse hover action
	 * @param driver
	 * @param element
	 */
	public void mouseHoverOn(WebDriver driver, WebElement element){
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	/**
	 * This method will perform right click 
	 * @param driver
	 * @param element
	 */
	public void rightClickOn(WebDriver driver)
	{
		Actions ac=new Actions(driver);
		ac.contextClick().perform();
	}
	/**
	 * This method will perform right click operation on particular web element
	 * @param driver
	 * @param element
	 */
	public void rightClickOn(WebDriver driver,WebElement element)
	{
		Actions act =new Actions(driver);
		act.contextClick(element);
		act.perform();
	}
	/**
	 * This method will perform double click on Webpage
	 * @param driver
	 */
	public void doubleClickOn(WebDriver driver)
	{
		Actions act =new Actions(driver);
		act.doubleClick().perform();
	}
	/**
	 * This method will perform double click on a particular web element
	 * @param driver
	 * @param element
	 */
	public void doubleClickOn(WebDriver driver ,WebElement element)
	{
		Actions act =new Actions(driver);
		act.doubleClick(element).perform();
	}
	/**
	 * This method will perform dragAnddrop operaton on srcelement to destelement
	 * @param driver
	 * @param srcelement
	 * @param destelement
	 */
	public void dragAndDropOn(WebDriver driver ,WebElement srcelement,WebElement destelement)
	{
		Actions act =new Actions(driver);
		act.dragAndDrop(srcelement, destelement).perform();
		
	}
	/**
	 * This method will mouse hover using offset values of x and y coordinates
	 * @param driver
	 * @param xoff
	 * @param yoff
	 */
	public void mouseHover(WebDriver driver ,int xoff ,int yoff)
	{
	  Actions act =new Actions (driver);
	  act.moveByOffset(xoff, yoff).perform();
	}
	/**
	 * This method will switch to frame based on index
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver ,int index)
	{
		driver.switchTo().frame(index);
	}
	/**
	 * This method will switch to frame based on nameOrId
	 * @param driver
	 * @param nameOrId
	 */
	public void switchToFrame(WebDriver driver ,String nameOrId)
	{
		driver.switchTo().frame(nameOrId);
	}
	/**
	 * This method will switch to frame based on element
	 * @param element
	 * @param driver
	 */
	public void switchToFrame(WebElement element,WebDriver driver)
	{
		driver.switchTo().frame(element);
	}
	/**
	 * This method will switch from current frame to immediate parent frame
	 * @param driver
	 */
	public void switchToParentFrame(WebDriver driver )
	{
		driver.switchTo().parentFrame();
	}
	/**
	 * This method will switch from current frame to default frame
	 * @param driver
	 */
	public void switchToDefaultFrame(WebDriver driver)
	{
	  driver.switchTo().defaultContent();	
	}
	/**
	 * This method will click on alert pop up
	 * @param driver
	 */
	public void accepctAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	/**
	 * This method will click on cancel in alert pop up
	 * @param driver
	 */
	public void dismissAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	/**
	 * This method will return the text of alert pop up to the caller
	 * @param driver
	 * @return
	 */
	public String getAlertText(WebDriver driver)
	{
		String alertText = driver.switchTo().alert().getText();
		return alertText;
	}
	/**
	 * This method will press enter key 
	 * @throws AWTException
	 */
	public void pressEnter() throws AWTException
	{
		Robot r =new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);	
	}
	/**
	 * This method will switch from parent window to any child window or from any child window to 
	 * parent window based on the partial window title
	 * @param driver
	 * @param partialWindowTitle
	 */
	public void switchToWindow(WebDriver driver ,String partialWindowTitle)
    	 {
	             	// Step 1 : get all the window handles    ----> we can use ForEach loop
	              	Set <String> windowIds =driver.getWindowHandles();
		
		           //Step2 : iterate through all the window ids
	                      Iterator < String> it	=windowIds.iterator();
	      
	                // step 3 : navigate to each window and check the title
	          while(it.hasNext())
	            {
	                 //Step 4 : capture the individual window id 
	    	       String winId =it.next();
	    	  
	                //Step 5 : compare current title with partial title
	    	        String  currentTitle=driver.switchTo().window(winId).getTitle();
	    	        if(currentTitle.contains(partialWindowTitle))
	    	        {
	    	        	break;
	    	        }
	    	   }
	     }
	/**
	 * This method will take the screenshot
	 * @param driver
	 * @param screenshotName
	 * @return
	 * @throws IOException
	 */
	   public String TakeScreenShot(WebDriver driver ,String screenshotName) throws IOException
	   {
		   TakesScreenshot ts = (TakesScreenshot)driver ;
		   File src=ts.getScreenshotAs(OutputType.FILE);
		   File dest= new File(".\\ScreenShots\\"+screenshotName+".png");
		   FileUtils.copyFile(src, dest);
		   
		   return dest.getAbsolutePath();   
	   }
		/**
		 * This method will scroll down for 500 units
		 * @param driver
		 */
	   public void scrollAction(WebDriver driver )
	   {
		   JavascriptExecutor jse =(JavascriptExecutor) driver;
		   jse.executeScript("window.scrollBy(0,500)", "");
	   }
	   /**
	    * This method will scroll untill the specified element is found
	    * @param driver
	    * @param element
	    */
	    public void scrollAction(WebDriver driver,WebElement element )
	    {
	    	JavascriptExecutor jse =(JavascriptExecutor) driver;
	    	//jse.executeScript("arguments[0].scrollIntoview();", element);
	    	
	    	int y =element.getLocation().getY();
	    	jse.executeScript("window.scrollBy(0,"+y+")",element);	
	    }
	    /**
	     * This method will close all the tabs along with parrent tabs
	     * @param driver
	     */
	    public void closeApplication(WebDriver driver) {
	    	driver.quit();
	    }
	}
	
	
	
