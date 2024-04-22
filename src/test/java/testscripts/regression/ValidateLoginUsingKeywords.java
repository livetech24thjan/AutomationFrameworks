package testscripts.regression;

import org.testng.annotations.Test;

import base.BaseTest;
import keywords.ApplicationKeywords;

public class ValidateLoginUsingKeywords extends BaseTest {
	
	@Test
	public void validateLogin()
	{
		ApplicationKeywords app=new ApplicationKeywords();
		
		app.startBrowser();
		
		app.launchApp();
		
		app.type("username_textbox_xpath", "reyaz0806");
		
		app.type("password_textbox_name", "reyaz123");
		
		app.click("login_button_xpath");
		
		app.validateTitle("Adactin.com - Search Hotel");
		
		app.closeBrowser();
		
	}

}
