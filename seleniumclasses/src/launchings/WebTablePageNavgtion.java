package launchings;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTablePageNavgtion
{

	public static void main(String[] args) throws Exception 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://datatables.net/examples/advanced_init/dt_events.html");
		driver.manage().window().maximize();
		
		int PageMaxSize = driver.findElements(By.cssSelector("div[id='example_paginate']>span>a")).size();

		System.out.println("No of pages are: "+PageMaxSize);
		
		for(int i=1;i<=PageMaxSize;i++)
		{
			String PageSelector = "div[id='example_paginate']>span>a:nth-child("+i+")";
			driver.findElement(By.cssSelector(PageSelector)).click();
			
			List<WebElement> elementnames = driver.findElements(By.cssSelector("table[id='example']>tbody>tr>td:nth-child(1)"));
			for(WebElement elementname: elementnames)
			{
				System.out.println(elementname.getText());
			}
			Thread.sleep(5000);
		}
		
	}

}
