package launchings;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class IrctcTicketBooking extends BaseTest
{

	public static void main(String[] args) throws Exception 
	{
		init();
		launch("chromebrowser");
		navigateUrl("irctcurl");
		
		driver.findElement(By.cssSelector("button[class='btn btn-primary']")).click();
		
		driver.findElement(By.cssSelector("input[class='ng-tns-c58-8 ui-inputtext ui-widget ui-state-default ui-corner-all ui-autocomplete-input ng-star-inserted']")).sendKeys("SULLURUPETA - SPE");
		
		driver.findElement(By.xpath("//input[@class='ng-tns-c58-9 ui-inputtext ui-widget ui-state-default ui-corner-all ui-autocomplete-input ng-star-inserted']")).sendKeys("HYDERABAD DECAN-HYB");
		
		driver.findElement(By.xpath("//input[@class='ng-tns-c59-10 ui-inputtext ui-widget ui-state-default ui-corner-all ng-star-inserted']")).click();
		
		while(!driver.findElement(By.cssSelector("div[class='ui-datepicker-title ng-tns-c59-10']>span")).getText().contains("February"))
		{
			driver.findElement(By.xpath("//span[@class='ui-datepicker-next-icon pi pi-chevron-right ng-tns-c59-10']")).click();
		}
		
		List<WebElement> dateslist = driver.findElements(By.cssSelector("tbody[class='ng-tns-c59-10']>tr>td"));
		for(int i=0;i<dateslist.size();i++)
		{
			String date = dateslist.get(i).getText();
			System.out.println(date);
			
			if(dateslist.get(i).getText().equals("14"))
			{
				dateslist.get(i).click();
				break;
			}
		}
	}

}
