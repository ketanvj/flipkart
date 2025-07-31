package scripts.orangePOAlternate1;
import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TextWithoutPO2 {
	WebDriver driver;
	WebDriverWait Wait;
	
	@Test
	  public void OrangeHRM() throws InterruptedException {
		
		     driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
			 WebElement user = driver.findElement(By.name("username"));
		     user.sendKeys("Admin");
		     WebElement password = driver.findElement(By.name("password"));
		     password.sendKeys("admin123");
		     user.submit();
		     String expectedTitle = "OrangeHRM";
		     Wait.until(ExpectedConditions.titleContains(expectedTitle));
		     String actualTitle = driver.getTitle();
		     
		     assertEquals(actualTitle,expectedTitle);  
		     
	  }
		@BeforeClass	
		public void beforeClass()
		{
	  driver = new FirefoxDriver();
	  driver.manage().window().maximize();
	  Wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	    }

	  
	  @AfterClass
	  public void afterMethod() {
		  driver.quit();
}
}