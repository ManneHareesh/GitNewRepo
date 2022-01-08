package Verifications;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Verify1 
{

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in");
		driver.manage().window().maximize();
		
		//String actualvalue = driver.findElement(By.linkText("Customer Service")).getText();
		String actualvalue = driver.findElement(By.linkText("Customer Service")).getAttribute("innerHTML");
		String expectedvalue = "Customer";
		
		System.out.println("Actual link :  "+actualvalue);
		System.out.println("Expected link :  "+expectedvalue);
		
		//if(actualvalue.equals(expectedvalue))
		//if(actualvalue.equalsIgnoreCase(expectedvalue))
		
		if(actualvalue.contains(expectedvalue))
			System.out.println("Both the links are equal...");
		else
			System.out.println("Both the links are not equal...");

	}

}
