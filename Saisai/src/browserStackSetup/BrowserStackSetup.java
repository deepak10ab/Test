package browserStackSetup;

//import BrowserStackPages.BrowserStackSignUpPage;
import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import BrowserStackPages.BrowserStackHomePage;

public class BrowserStackSetup {

	
	
	WebDriver driver;
	
	BrowserStackHomePage objBrowserstackHomePage;
	
	@BeforeTest
	
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "/Users/deepak/eclipse-workspace/xyz/Drivers/chromedriver");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.browserstack.com/");
			
	}
	
	@Test(priority = 1)
	
	public void navigate_getstarted() {
		
		objBrowserstackHomePage = new BrowserStackHomePage(driver);
		
		objBrowserstackHomePage.verifyHeader();
		
		objBrowserstackHomePage.clickongetstarted();
		
	}
	


@AfterMethod //AfterMethod annotation - This method executes after every test execution
public void screenShot(ITestResult result){
//using ITestResult.FAILURE is equals to result.getStatus then it enter into if condition
	if(ITestResult.FAILURE==result.getStatus()){
		try{
			// To create reference of TakesScreenshot
			TakesScreenshot screenshot=(TakesScreenshot)driver;
			// Call method to capture screenshot
			File src=screenshot.getScreenshotAs(OutputType.FILE);
			// Copy files to specific location 
			// result.getName() will return name of test case so that screenshot name will be same as test case name
			FileUtils.copyFile(src, new File("/Users/deepak/eclipse-workspace/Saisai/test-output"+result.getName()+".png"));
			System.out.println("Successfully captured a screenshot");
		}catch (Exception e){
			System.out.println("Exception while taking screenshot "+e.getMessage());
		
		} 
}
driver.quit();
}
}
	
