package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchHotelPage extends BasePage{
	
	@FindBy(xpath="//select[@name='location']") 
	WebElement locationDropdown;
	
	@FindBy(xpath="//select[@name='hotels']") 
	WebElement hotelsDropdown;
	
	@FindBy(xpath="//select[@name='room_type']") 
	WebElement roomTypeDropdown;
	
	@FindBy(xpath="//select[@name='room_nos']") 
	WebElement noOfRoomsDropdown;
	
	@FindBy(xpath="//input[@name='adult_room']") 
	WebElement adultsPerRoomDropdown;
	
	@FindBy(xpath="//input[@name='datepick_in']") 
	WebElement checkInDateTextbox;
	
	@FindBy(xpath="//input[@name='datepick_out']") 
	WebElement checkOutDateTextbox;
	
	public void locationDropdown(String option)
	{
		selectFromDropdown(locationDropdown, option);
	}
	
	public void hotelsDropdown(String option)
	{
		selectFromDropdown(hotelsDropdown, option);
	}
	
	public void roomTypeDropdown(String option)
	{
		selectFromDropdown(roomTypeDropdown, option);
	}
	
	public void noOfRoomsDropdown(String option)
	{
		selectFromDropdown(noOfRoomsDropdown, option);
	}
	
	public void checkInDateTextbox(String text)
	{
		
		clearAndType(checkInDateTextbox, text);
	}
	
	
	public void checkOutDateTextbox(String text)
	{
		
		clearAndType(checkOutDateTextbox, text);
	}
	

}
