package launchings;

import org.apache.log4j.Logger;

public class TC_003 extends BaseTest
{
	private static final Logger log = Logger.getLogger("TC_003");
	

	public static void main(String[] args) throws Exception 
	{
		init();
		log.info("Init thte properties files....");
		
		launch("chromebrowser");
		log.info("Launching the browser: "+p.getProperty("chromebrowser"));
		
		navigateUrl("amazonurl");
		log.info("Navigate to URL: "+ childprop.getProperty("amazonurl"));
		
		selectOption("amazondropdown_id", "Books");
		log.info("Select the option Books by using Locator: "+ orProp.getProperty("amazondropdown_id"));
		
		typeText("amazonetextbox_name", "Harry Potter");
		log.info("Enter the text Harry Potter by using locator :"+orProp.getProperty("amazonetextbox_name"));
		
		clickElement("amazonsearchbox_xpath");
		log.info("Click the element by using locator :"+orProp.getProperty("amazonsearchbox_xpath"));
		
		//driver.findElement(By.linkText("Customer Service")).click();
		
		//driver.findElement(By.partialLinkText("Customer Serv"));
		
		/*
		 * List<WebElement> elements = driver.findElements(By.tagName("a"));
		 * 
		 * for(int i=0;i<elements.size();i++) { if(!elements.get(i).getText().isEmpty())
		 * System.out.println(elements.get(i).getText()); }
		 */
		
		
		//WebElement loc = driver.findElement(By.id("searchDropdownBox"));
		//loc.sendKeys(",");
		
		//driver.findElement(By.name("field-keywords")).sendKeys("Harry Potter");
		
		//driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
		
	}

}
