package launchings;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest 
{
	public static WebDriver driver;
	public static String projectpath = System.getProperty("user.dir");
	public static FileInputStream fis;
	public static Properties p;
	public static Properties mainprop;
	public static Properties childprop;
	public static Properties orProp;
	public static ExtentReports rep;
	public static ExtentTest test;
	
	
	public static void init() throws Exception
	{
		
		fis = new FileInputStream(projectpath+"\\data.properties");
		p = new Properties();
		p.load(fis);
		
		fis = new FileInputStream(projectpath+"\\environment.properties");
		mainprop = new Properties();
		mainprop.load(fis);
		String e = mainprop.getProperty("env");
		System.out.println(e);
		
		fis  = new FileInputStream(projectpath+"\\"+e+".properties");
		childprop = new Properties();
		childprop.load(fis);
		System.out.println(childprop.getProperty("amazonurl"));
		
		fis = new FileInputStream(projectpath+"\\or.properties");
		orProp = new Properties();
		orProp.load(fis);
		
		fis = new FileInputStream(projectpath+"\\log4jconfig.properties");
		PropertyConfigurator.configure(fis);
		
		rep = ExtentManager.getInstance();
		
	}
	
	public static void launch(String browser)
	{
		if(p.getProperty(browser).equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			
			ChromeOptions option = new ChromeOptions();
			option.addArguments("user-data-dir=C:\\Users\\manne\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 2");
			option.addArguments("--disable-notifications");
			option.addArguments("--start-maximized");
			option.addArguments("-ignore-certificate-errors");
			//option.addArguments("--proxy-server=https://192.168.10.1:9090");
			
			 driver = new ChromeDriver(option);
		}
		
		else if(p.getProperty(browser).equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			
			ProfilesIni p = new ProfilesIni();
			FirefoxProfile profile = p.getProfile("DecemberFirefoxProfile");
			
			FirefoxOptions option = new FirefoxOptions();
			option.setProfile(profile);
			
			//Notifications
			profile.setPreference("dom.webnotifications.enabled", false);
		
			//Certificate Errors
			profile.setAcceptUntrustedCertificates(true);
			profile.setAssumeUntrustedCertificateIssuer(false);
			
			//How to work with the proxy settings
			profile.setPreference("network.proxy.type", 1);
			profile.setPreference("network.proxy.socks", "192.168.10.1");
			profile.setPreference("network proxy.socks_port", 1744);
		
			 driver = new FirefoxDriver(option);
		}
		
		//driver.manage().window().maximize();
	}
	
	public static void navigateUrl(String url)
	{
		driver.get(childprop.getProperty(url));
		
		//driver.navigate().to(url);
	
	}
	
	public static void clickElement(String locatorKey) 
	{
		//driver.findElement(By.xpath(orProp.getProperty(locatorKey))).click();
		getElement(locatorKey).click();
	}

	public static void typeText(String locatorKey, String text) 
	{
		//driver.findElement(By.id(orProp.getProperty(locatorKey))).sendKeys(text);
		getElement(locatorKey).sendKeys(text);
	}

	public static void selectOption(String locatorKey, String option) 
	{
		//driver.findElement(By.id(orProp.getProperty(locatorKey))).sendKeys(option);	
		getElement(locatorKey).sendKeys(option);
	}
	
	public static WebElement getElement(String locatorKey) 
	{
		
		//check for presence of element
		if(!isElementPresent(locatorKey))
			//report the failure
			System.out.println("element not present"+locatorKey);
		
		if(!isElementVisible(locatorKey))
			//report the failure
			System.out.println("element not visible"+locatorKey);
			
			
			
		WebElement element = null;
		
		element = driver.findElement(getLocator(locatorKey));
		/*
		 * if(locatorKey.endsWith("_id")){ element =
		 * driver.findElement(By.id(orProp.getProperty(locatorKey))); }else
		 * if(locatorKey.endsWith("_name")){ element =
		 * driver.findElement(By.name(orProp.getProperty(locatorKey))); }else
		 * if(locatorKey.endsWith("classname")){ element =
		 * driver.findElement(By.className(orProp.getProperty(locatorKey))); }else
		 * if(locatorKey.endsWith("xpath")){ element =
		 * driver.findElement(By.xpath(orProp.getProperty(locatorKey))); }else
		 * if(locatorKey.endsWith("css")){ element =
		 * driver.findElement(By.cssSelector(orProp.getProperty(locatorKey))); }else
		 * if(locatorKey.endsWith("linktext")){ element =
		 * driver.findElement(By.linkText(orProp.getProperty(locatorKey))); }else
		 * if(locatorKey.endsWith("partiallinktext")){ element =
		 * driver.findElement(By.partialLinkText(orProp.getProperty(locatorKey))); }
		 */
		
		return element;
	
	}

	private static boolean isElementVisible(String locatorKey) {
		// TODO Auto-generated method stub
		return false;
	}

	public static boolean isElementPresent(String locatorKey) 
	{
		System.out.println("checking for Element presence: "+ locatorKey);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
		try {
			
			wait.until(ExpectedConditions.presenceOfElementLocated(getLocator(locatorKey)));
			/*
			 * if(locatorKey.endsWith("_id")) {
			 * wait.until(ExpectedConditions.presenceOfElementLocated(By.id(orProp.
			 * getProperty(locatorKey)))); }else if(locatorKey.endsWith("_name")) {
			 * wait.until(ExpectedConditions.presenceOfElementLocated(By.name(orProp.
			 * getProperty(locatorKey)))); }else if(locatorKey.endsWith("_classname")) {
			 * wait.until(ExpectedConditions.presenceOfElementLocated(By.className(orProp.
			 * getProperty(locatorKey)))); }else if(locatorKey.endsWith("_xpath")) {
			 * wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(orProp.
			 * getProperty(locatorKey)))); }else if(locatorKey.endsWith("css")) {
			 * wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(orProp.
			 * getProperty(locatorKey)))); }else if(locatorKey.endsWith("linktext")) {
			 * wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(orProp.
			 * getProperty(locatorKey)))); }else if(locatorKey.endsWith("partiallinktext"))
			 * { wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText(
			 * orProp.getProperty(locatorKey)))); }
			 */
		} 
		catch (Exception e) 
		{
			return false;
		}
		return true;
	}
	
	
	public static By getLocator(String LocatorKey)
	{
		By by = null;
		if(LocatorKey.endsWith("_id")) {
			by = By.id(orProp.getProperty(LocatorKey));
		}else if(LocatorKey.endsWith("_name")) {
			by = By.name(orProp.getProperty(LocatorKey));
		}else if(LocatorKey.endsWith("_classname")) {
			by = By.className(orProp.getProperty(LocatorKey));
		}else if(LocatorKey.endsWith("_xpath")) {
			by = By.xpath(orProp.getProperty(LocatorKey));
		}else if(LocatorKey.endsWith("_css")) {
			by = By.cssSelector(orProp.getProperty(LocatorKey));
		}else if(LocatorKey.endsWith("linktext")) {
			by = By.linkText(orProp.getProperty(LocatorKey));
		}else if(LocatorKey.endsWith("_partilalinktext")) {
			by = By.partialLinkText(orProp.getProperty(LocatorKey));
		}
		
		return by;
		
	}
	
	//Verifications
	public static boolean isLinkEqual(String expectedlink) 
	{
		String actulalink = driver.findElement(By.linkText("Customer Service")).getText();
		if(actulalink.equals(expectedlink))
			return true;
		else 
			return false;
	}

	public static void reportSuccess(String passMessage) 
	{
			test.log(Status.PASS, passMessage);
	}

	public static void reportFailure(String failMessage) throws Exception 
	{
			test.log(Status.FAIL, failMessage);
			takeScreenshot();
	}

	public static void takeScreenshot() throws Exception 
	{
		Date dt = new Date();
		System.out.println(dt);
		String dateformat = dt.toString().replace(':', '_').replace(' ', '_')+".png";
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(srcFile, new File(projectpath+"//failurescreenshots//"+dateformat));
		
		test.log(Status.INFO, "Screenshot------>"+test.addScreenCaptureFromPath(projectpath+"//failurescreenshots//"+dateformat));
		
	}
	
}
