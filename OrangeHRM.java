package scripts.orangePOAlternate1;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class OrangeHRM {
	
	//Locator
	private By username = By.name("username");
	private By password = By.name("password");
	private By login = By.xpath("//button[@type='submit']");
	
	private WebDriver driver;
	
	public String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
			
	
	//Contructor
	public OrangeHRM() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		assertEquals(driver.getTitle(),"OrangeHRM");
	}
	
	//Method
	public void login(String user, String pass) {
	driver.findElement(username).sendKeys(user);
	driver.findElement(password).sendKeys(pass);
	driver.findElement(login).click();
	}
	
	public void closebrowser() {
		driver.quit();
	}

	
	public String getTitleAfterLogin() {
		return driver.getTitle();
	}
	
}

