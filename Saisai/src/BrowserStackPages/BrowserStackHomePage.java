package BrowserStackPages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static org.testng.Assert.assertEquals;

public class BrowserStackHomePage {
	
	WebDriver driver;
	
	By Header=By.xpath("//h1");
	
	By getStarted=By.xpath("//*[@id='signupModalButton']");
	
	public BrowserStackHomePage(WebDriver driver) {
		this.driver=driver;
		}

	public void verifyHeader() {
		
		
		String getheadertext = driver.findElement(Header).getText();
		assertEquals("App & Browser Testing Made Easy", getheadertext);
		
		
	}
	
	public void clickongetstarted() {
		
		driver.findElement(getStarted).click();
		
		
		
	} 
}
