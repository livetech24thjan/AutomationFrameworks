package testscripts.regression;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import pages.SearchHotelPage;

public class ValidateSelectHotelUsingPOM extends BaseTest {

	
	@Test
	public void validateLoginTest()
	{
		
		LoginPage loginPage=PageFactory.initElements(driver, LoginPage.class);
		
		loginPage.usernameTextbox("reyaz0806");
		
		loginPage.passwordTextbox("reyaz123");
		
		loginPage.loginButton();
		
		loginPage.validateTitle("Adactin.com - Search Hotel");
		
		SearchHotelPage searchHotelPage=PageFactory.initElements(driver, SearchHotelPage.class);
		
		searchHotelPage.locationDropdown("Sydney");
		searchHotelPage.checkInDateTextbox("24/04/2024");
		searchHotelPage.checkOutDateTextbox("26/04/2024");
		
	}
	
	
}
