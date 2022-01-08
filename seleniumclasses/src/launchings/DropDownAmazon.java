package launchings;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownAmazon
{

	public static void main(String[] args) throws Exception 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com");
		driver.manage().window().maximize();
		
		int count = driver.findElements(By.xpath("//select[@id='searchDropdownBox']/option")).size();
		System.out.println("Total no of options in the dropdown is: "+count);
		
		for(int i=1;i<=count;i++) 
		{
			List<WebElement> element = driver.findElements(By.xpath("//select[@id='searchDropdownBox']/option["+i+"]"));
			for(WebElement elements : element)
				{
				System.out.println(elements.getText());
				}
			
			Thread.sleep(2000);
		}
		
	}

}
