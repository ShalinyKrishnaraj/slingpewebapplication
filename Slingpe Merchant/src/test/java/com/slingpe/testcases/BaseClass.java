package com.slingpe.testcases;


import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.slingpe.utility.ReadConfig;


public class BaseClass {
	ReadConfig readconfig=new ReadConfig();
	public String baseUrl=readconfig.getWebApplicationURL();
	public String username=readconfig.getApplicationUserName();
	public String password=readconfig.getApplicationPassword();
	public static WebDriver driver;
	public static Logger Log;
	public static Robot re;
	public static Actions ac;
	public static Select se;
	public static Alert al;
	public static Object js;
	

   

	
	@Parameters("browser")

	@BeforeClass
	
	public void setUp(@Optional("Abc") String br)
	
	{
		Log=LogManager.getLogger("LoginTestCase");
		if(br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",readconfig.getApplicationDriver1());
			driver=new ChromeDriver();
	
		}
		else if(br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",readconfig.getApplicationDriver2());
			driver=new FirefoxDriver();

		}
		else if(br.equals("ie")) {
			System.setProperty("webdriver.ie.driver",readconfig.getApplicationDriver3());
			driver=new InternetExplorerDriver();
			
		}
		

	
	}
	
@AfterTest


	public void hitEnter() throws Exception 
	{
	re = new Robot();
	re.keyPress(KeyEvent.VK_ENTER);
	re.keyRelease(KeyEvent.VK_ENTER);
		
	}


	public void hitBackspace() throws Exception 
	{
		re = new Robot();
		re.keyPress(KeyEvent.VK_BACK_SPACE);
		re.keyRelease(KeyEvent.VK_BACK_SPACE);
	}


	public void hitDelete() throws Exception 
	{
		re = new Robot();
		re.keyPress(KeyEvent.VK_DELETE);
		re.keyRelease(KeyEvent.VK_DELETE);
	}


	public void selectAll() throws Exception
	{
		re = new Robot();
		re.keyPress(KeyEvent.VK_CONTROL);
		re.keyPress(KeyEvent.VK_A);
		re.keyRelease(KeyEvent.VK_CONTROL);
		re.keyRelease(KeyEvent.VK_A);
	}


	public void copyAll() throws Exception 
	{
		re = new Robot();
		re.keyPress(KeyEvent.VK_CONTROL);
		re.keyPress(KeyEvent.VK_C);
		re.keyRelease(KeyEvent.VK_CONTROL);
		re.keyRelease(KeyEvent.VK_C);
	}


	public void pasteAll() throws Exception
	{
		re = new Robot();
		re.keyPress(KeyEvent.VK_CONTROL);
		re.keyPress(KeyEvent.VK_V);
		re.keyRelease(KeyEvent.VK_CONTROL);
		re.keyRelease(KeyEvent.VK_V);
	}


	/* To Capture Screenshot(Replaces if already exists) */
	/*
	 * Also, Make sure that the automation in running in the foreground to
	 * capture the Image of the Browser. Else, It'll capture the open Window
	 */
	public void robotScreenCapture(String robotImageName) throws Exception 
	{
		re = new Robot();
		Rectangle area = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
		BufferedImage bufferedImage = re.createScreenCapture(area);
		// Save as PNG
		File file = new File(robotImageName);
		if (file.exists()) {
			file.delete();
		}
		ImageIO.write(bufferedImage, "png", file);
	}


	
	public void robotZoomOut() throws Exception 
	{
		re = new Robot();
		re.keyPress(KeyEvent.VK_CONTROL);
		re.keyPress(KeyEvent.VK_SUBTRACT);
		re.keyRelease(KeyEvent.VK_SUBTRACT);
		re.keyRelease(KeyEvent.VK_CONTROL);
	}


	
	public void robotZoomIn() throws Exception 
	{
		re = new Robot();
		re.keyPress(KeyEvent.VK_CONTROL);
		re.keyPress(KeyEvent.VK_ADD);
		re.keyRelease(KeyEvent.VK_ADD);
		re.keyRelease(KeyEvent.VK_CONTROL);
	}


	public void robotScrollUp() throws Exception 
	{
		re = new Robot();
		re.keyPress(KeyEvent.VK_PAGE_UP);
		re.keyRelease(KeyEvent.VK_PAGE_UP);
	}


 void robotScrollDown() throws Exception
	{
		re = new Robot();
		re.keyPress(KeyEvent.VK_PAGE_DOWN);
		re.keyRelease(KeyEvent.VK_PAGE_DOWN);
	}


	public void scrollUp() throws Exception 
	{
		js=((JavascriptExecutor) driver).executeScript("scroll(0, -100);");
	}


	public void scrollDown() throws Exception 
	{
		js=((JavascriptExecutor) driver).executeScript("scroll(0, 100);");
	}


	/* To Move cursor to the Desired Location */
	public void moveCursor(int X_Position, int Y_Position) throws Exception 
	{
		re.mouseMove(X_Position, Y_Position);
	}



	public void alertAccept() throws Exception
	{
		al = driver.switchTo().alert();
		al.accept();
	}



	public void alertDismiss() throws Exception 
	{
		al = driver.switchTo().alert();
		al.dismiss();
	}


	/* To Get the Alert Messages */
	public String getAlertText() throws Exception 
	{
		al = driver.switchTo().alert();
		String text = al.getText();
		Thread.sleep(2000);
		alertAccept();
		return text;
	}


	/* To Upload a File using JAVA AWT ROBOT */
	public void fileUpload(String FileToUpload) throws Exception 
	{
		Thread.sleep(5000);
		StringSelection filetocopy = new StringSelection(FileToUpload);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filetocopy, null);
		Thread.sleep(1000);
		re = new Robot();
		re.keyPress(KeyEvent.VK_CONTROL);
		re.keyPress(KeyEvent.VK_V);
		re.keyRelease(KeyEvent.VK_V);
		re.keyRelease(KeyEvent.VK_CONTROL);
		re.keyPress(KeyEvent.VK_ENTER);
		re.keyRelease(KeyEvent.VK_ENTER);
	}


	public void mousehover(WebElement element) 
	{
		ac = new Actions(driver);
		ac.moveToElement(element).build().perform();
	}

	public void selectByVisibleText(WebElement element, String value)
	{
		se = new Select(element);
		se.selectByVisibleText(value);
	}

	public void selectByIndex(WebElement element, int value)
	{
		se = new Select(element);
		se.selectByIndex(value);
	}

	public void selectByValue(WebElement element, String value) 
	{
		se = new Select(element);
		se.selectByValue(value);
	}


	public void click(WebElement element) 
	{
		element.click();
	}


	/* To click a certain Web Element using DOM/ JavaScript Executor */
	public void JSclick(WebElement element) 
	{
		((JavascriptExecutor) driver).executeScript("return arguments[0].click();", element);
	}


	public void sendKeys(WebElement element, String value) 
	{
		element.sendKeys(value);
	}



	public void clear(WebElement element) 
	{
		element.clear();
	}


	
	public void dragandDrop(WebElement Source, WebElement Destination)
	{
		ac = new Actions(driver);
		ac.dragAndDrop(Source, Destination);
	}


	/*To Drag from the given WebElement Location and Drop at the given WebElement location */
	public void dragandDropTo(WebElement Source, int XOffset, int YOffset) throws Exception 
	{
		ac = new Actions(driver);
		ac.dragAndDropBy(Source, XOffset, YOffset);
	}


	public void rightClick(WebElement element) 
	{
		ac = new Actions(driver);
		ac.contextClick(element);
		ac.build().perform();	
	}


	public void closeCurrentTab() 
	{
		driver.close();		
	}

	public void clickAndHold(WebElement element)
	{
		ac = new Actions(driver);
		ac.clickAndHold(element);
		ac.build().perform();
	}

	public void doubleClick(WebElement element)
	{
		ac = new Actions(driver);
		ac.doubleClick(element);
		ac.build().perform();
	}

	public void switchToFrameByIndex(int index) throws Exception
	{
		driver.switchTo().frame(index);
	}


	public void switchToFrameByFrameName(String frameName) throws Exception
	{
driver.switchTo().frame(frameName);
	}


	/*To Switch To Frame By Web Element */
	public void switchToFrameByWebElement(WebElement element) throws Exception
	{
		driver.switchTo().frame(element);
	}


	public void switchOutOfFrame() throws Exception
	{
		driver.switchTo().defaultContent();
	}


	public String getTooltipText(WebElement element)
	{
		String tooltipText = element.getAttribute("title").trim();
		return tooltipText;
	}


	public void closeAllTabsExceptFirst() 
	{
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		for(int i=1;i<tabs.size();i++)
		{	
			driver.switchTo().window(tabs.get(i));
			driver.close();
		}
		driver.switchTo().window(tabs.get(0));
	}


	public void printAllTheWindows() 
	{
		ArrayList<String> al = new ArrayList<String>(driver.getWindowHandles());
		for(String window : al)
		{
			System.out.println(window);
		}
	}
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}



