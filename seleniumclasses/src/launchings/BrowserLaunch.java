package launchings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserLaunch 
{

	public static void main(String[] args) 
	{
		WebDriver driver;
		
		//System.setProperty("webdriver.chrome.driver", "C:/Hareesh/web drivers/chromedriver_win32/chromedriver.exe/");
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		
			//System.setProperty("webdriver.chrome.driver", "C:/Hareesh/web drivers/chromedriver_win32/chromedriver.exe/");
			WebDriverManager.firefoxdriver().setup();
			 driver = new FirefoxDriver();
	}

}
