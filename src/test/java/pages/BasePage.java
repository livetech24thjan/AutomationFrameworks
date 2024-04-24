package pages;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import base.BaseTest;

public class BasePage extends BaseTest {

	public void validateTitle(String expTitle)
	{
		Assert.assertEquals(driver.getTitle(), expTitle);
	}
	
	public void type(WebElement element,String text)
	{
		element.sendKeys(text);
		test.log(Status.INFO, "Entered text "+text+ " into the WebElement "+element);
	}
	
	public void clearAndType(WebElement element,String text)
	{
		element.clear();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		element.sendKeys(text);
		
		test.log(Status.INFO, "Cleared and Entered text "+text+ " into the WebElement "+element);

	}
	
	public void click(WebElement element)
	{
		element.click();
		
		test.log(Status.INFO, "Clicked the WebElement "+element);

	}
	
	public void selectFromDropdown(WebElement element,String option)
	{
		new Select(element).selectByVisibleText(option);
		
		test.log(Status.INFO, "Selected option  "+option+ " from the dropdown WebElement "+element);

	}
	
	public static void screenshot()
	{
		String screenshotFolderPath=System.getProperty("user.dir")+"\\screenshots";
		
		File screenshotsFolder=new File(screenshotFolderPath);
		
		screenshotsFolder.mkdir();
		
		File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		
		String pattern="yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date = simpleDateFormat.format(new Date());
		System.out.println(date);
		date=date.replace(":", "-");
		System.out.println(date);
		
		
		
		try {
			FileUtils.copyFile(srcFile, new File( screenshotFolderPath+"\\"+date+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
}
