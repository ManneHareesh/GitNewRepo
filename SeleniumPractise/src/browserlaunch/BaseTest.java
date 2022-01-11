package browserlaunch;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	
	
	public static void init() throws Exception
	{
		fis = new FileInputStream(projectpath+"//data.properties");
		p = new Properties();
		p.load(fis);
		
		fis = new FileInputStream(projectpath+"//environment.properties");
		mainprop = new Properties();
		mainprop.load(fis);
		String e = mainprop.getProperty("env");
		System.out.println(e);
		
		fis = new FileInputStream(projectpath+"//"+e+".properties");
		childprop = new Properties();
		childprop.load(fis);
		System.out.println(childprop.getProperty("amazonurl"));
		
		fis = new FileInputStream(projectpath+"//or.properties");
		orProp=new Properties();
		orProp.load(fis);
	}
	
	public static void launch(String browser) 
	{
		if(p.getProperty(browser).equals("chrome"))
		{
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		}
		 
		 else if(p.getProperty(browser).equals("firefox"))
		 {
		WebDriverManager.firefoxdriver().setup();
		 driver = new FirefoxDriver();
		 }
		
		driver.manage().window().maximize();
	}
		
		public static void navigateUrl(String url)
		{
			//driver.get(childprop.getProperty(url));
			
			driver.navigate().to(childprop.getProperty(url));
		}
		
		public static void clickelement(String locatorKey) 
		{
			//driver.findElement(By.xpath(orProp.getProperty(locatorKey))).click();	
			getElement(locatorKey).click();
		}

		public static void typetext(String locatorKey, String text) 
		{
			//driver.findElement(By.id(orProp.getProperty(locatorKey))).sendKeys(text);
			getElement(locatorKey).sendKeys(text);
		}

		public static void selectoption(String locatorKey, String option) 
		{
			//driver.findElement(By.id(orProp.getProperty(locatorKey))).sendKeys(option);
			getElement(locatorKey).sendKeys(option);	
		}

		public static WebElement getElement(String locatorKey) 
		{
			
			if(!isElementpresent(locatorKey))
				System.out.println("element not present: "+locatorKey);
			
			WebElement element = null;
			element = driver.findElement(getLocator(locatorKey));
			
			return element;
		}
		
		public static boolean isElementpresent(String locatorKey) 
		{
			System.out.println("checking for the element presence"+ locatorKey);
			WebDriverWait wait = new WebDriverWait(driver, 30);
			
			try 
			{
				wait.until(ExpectedConditions.presenceOfElementLocated(getLocator(locatorKey)));
			} 
			catch (Exception e) 
			{
				return false;
			}
			return true;
		}

		public static By getLocator(String locatorKey)
		{
			By by = null;
			if(locatorKey.endsWith("_id")) {
				by = By.id(orProp.getProperty(locatorKey));
			}else if(locatorKey.endsWith("_name")) {
				by = By.name(orProp.getProperty(locatorKey));
			}else if(locatorKey.endsWith("_classname")) {
				by = By.className(orProp.getProperty(locatorKey));
			}else if(locatorKey.endsWith("_xpath")) {
				by = By.xpath(orProp.getProperty(locatorKey));
			}else if(locatorKey.endsWith("_css")) {
				by = By.cssSelector(orProp.getProperty(locatorKey));
			}else if(locatorKey.endsWith("linktext")) {
				by = By.linkText(orProp.getProperty(locatorKey));
			}else if(locatorKey.endsWith("_partilalinktext")) {
				by = By.partialLinkText(orProp.getProperty(locatorKey));
			}
			return by;
			
		}
		

}
