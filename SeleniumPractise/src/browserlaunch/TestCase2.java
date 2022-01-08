package browserlaunch;

public class TestCase2 extends BaseTest
{

	public static void main(String[] args) throws Exception 
	{
		init();
		
		launch("chromebrowser");
		
		navigateUrl("amazonurl");
		
		selectoption("amazondropdown_id","Beauty");
		
		typetext("amazontextbox_id","hair dryer");
		
		clickelement("amazonsearchbox_xpath");
		
		//WebElement loc = driver.findElement(By.id("searchDropdownBox"));
		//loc.sendKeys("Beauty");
		
		//driver.findElement(By.name("field-keywords")).sendKeys("hair dryer");
		
		//driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
		
	}


}
