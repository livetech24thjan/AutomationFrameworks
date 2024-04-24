package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import utils.ExtentManager;

public class BaseTest {
	
	public static WebDriver driver;
	
	public static FileInputStream fis1;
	public static Properties locatorsProp;
	public static ExtentReports reports;
	public static ExtentTest test;

	@BeforeTest
	public void readPropertiesFiles() throws IOException
	{
		reports=ExtentManager.getReports();
		fis1=new FileInputStream("src\\test\\resources\\properties\\locators.properties");
		locatorsProp=new Properties();
		locatorsProp.load(fis1);
		
		
		System.out.println("End of BeforeTest ..");
		
	}

	@BeforeMethod
	public void setUp(ITestContext context)
	{
		
		test=reports.createTest(context.getCurrentXmlTest().getName());
		
		
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Properties configProp=new Properties();
		
		try {
			configProp.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String browserName=configProp.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
			test.log(Status.INFO, "Started the browser " + browserName);
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
			test.log(Status.INFO, "Started the browser " + browserName);
		}
		else  if(browserName.equalsIgnoreCase("edge"))
		{
			driver=new EdgeDriver();
			test.log(Status.INFO, "Started the browser " + browserName);
		}
		
		driver.get(configProp.getProperty("url"));
		
		test.log(Status.INFO, "App is launched using url  " + configProp.getProperty("url"));
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(configProp.getProperty("implicitWaitTime"))));
		
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	
	@AfterTest
	public void closeReports()
	{
		if(reports!=null)
		{
			reports.flush();
		}
	}
	

}
