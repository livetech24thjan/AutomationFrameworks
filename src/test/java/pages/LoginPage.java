package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	
	@FindBy(xpath="//input[@name='username']") 
	WebElement usernameTextbox;
	
	@FindBy(xpath="//input[@name='password']") 
	WebElement passwordTextbox;
	
	@FindBy(xpath="//input[@name='login']") 
	WebElement loginButton;
	
	public void usernameTextbox(String text)
	{
		//usernameTextbox.sendKeys(text);
		type(usernameTextbox, text);
	}
	
	public void passwordTextbox(String text)
	{
		//passwordTextbox.sendKeys(text);
		type(passwordTextbox, text);
	}
	
	public void loginButton()
	{
		//loginButton.click();
		click(loginButton);
	}
	
	

}
