package testscripts.regression;

import java.util.HashMap;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.BasePage;
import pages.LoginPage;
import pages.SearchHotelPage;
import utils.UtilKit;

public class ValidateSelectHotelUsingPOMDataProvider extends BaseTest {

	
	@Test(dataProvider = "getData")
	public void validateLoginTest(HashMap<String, String> dataMap)
	{
		
		LoginPage loginPage=PageFactory.initElements(driver, LoginPage.class);
		
		loginPage.usernameTextbox(dataMap.get("username"));
		
		loginPage.passwordTextbox(dataMap.get("password"));
		
		BasePage.screenshot();
		
		loginPage.loginButton();
		
		loginPage.validateTitle(dataMap.get("Expected Title1"));
		
		BasePage.screenshot();
		
		SearchHotelPage searchHotelPage=PageFactory.initElements(driver, SearchHotelPage.class);
		
		searchHotelPage.locationDropdown(dataMap.get("Location"));
		searchHotelPage.checkInDateTextbox(dataMap.get("Check In Date"));
		searchHotelPage.checkOutDateTextbox(dataMap.get("Check Out Date"));
		
	}
	
	@DataProvider
	public Object[][] getData()
	{
		
		Object[][] data=new Object[1][1];
		
		data[0][0]=UtilKit.getTestDataFromExcel("TC-102");
		
		return data;
		
	}
	
	
}
