package Verifications;

import com.aventstack.extentreports.Status;

import launchings.BaseTest;

public class Verify3 extends BaseTest
{

	public static void main(String[] args) throws Exception 
	{

		init();
		test = rep.createTest("Verify3");
		test.log(Status.INFO, "Init the properties files....");
		
		launch("chromebrowser");
		test.log(Status.INFO, "Launching the browser: "+p.getProperty("chromebrowser"));
		
		navigateUrl("amazonurl");
		test.log(Status.INFO, "Navigate to URL: "+ childprop.getProperty("amazonurl"));
		
		String expectedlink = "Customer Service";
		if (!isLinkEqual(expectedlink))
			//System.out.println("Both links are not equal....");
			reportFailure("Both links are not equal....");
		else 
			//System.out.println("Both links are equal...");
			reportSuccess("Both links are equal...");
		
		rep.flush();
	}

}
