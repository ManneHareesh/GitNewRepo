package launchings;

import com.aventstack.extentreports.Status;

public class TC_004 extends BaseTest
{

	public static void main(String[] args) throws Exception 
	{
		init();
		test = rep.createTest("TC_004");
		test.log(Status.INFO, "Init thte properties files....");
		
		launch("chromebrowser");
		test.log(Status.PASS, "Launching the browser: "+p.getProperty("chromebrowser"));
		
		navigateUrl("amazonurl");
		test.log(Status.FAIL, "Navigate to URL: "+ childprop.getProperty("amazonurl"));
		
		selectOption("amazondropdown_id", "Books");
		test.log(Status.PASS, "Select the option Books by using Locator: "+ orProp.getProperty("amazondropdown_id"));
		
		typeText("amazonetextbox_name", "Harry Potter");
		test.log(Status.PASS, "Enter the text Harry Potter by using locator :"+orProp.getProperty("amazonetextbox_name"));
		
		clickElement("amazonsearchbox_xpath");
		test.log(Status.PASS, "Click the element by using locator :"+orProp.getProperty("amazonsearchbox_xpath"));
		
		rep.flush();
	}

}
