package seleniumassignments;
//test
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class Triphobo {
	WebDriver driver;
	WebDriverWait wait;
	Actions actions;
	WebElement planVacation;
	WebElement whereToGo;
	WebElement selectCity;
	WebElement endDestination;
	WebElement selectDestination;
	WebElement startDate;
	WebElement startPlanning;
	WebElement nextButton;
	WebElement skipButton;
	WebElement skipOverviewButton;
	WebElement editPlan;
	WebElement closeWindow;
	WebElement dragElement;
	WebElement dropElement;
	WebElement savePlan;
	WebElement finishPlan;
  @Test
  public void firstTest()  {
	  driver.get("https://www.triphobo.com/");
	  String expectedTitle = "Vacation Planner for Your Holidays: TripHobo";
	  assertEquals(driver.getTitle(),expectedTitle);
	  planVacation=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Plan Your Next Vacation']")));
	  planVacation.click();
	  whereToGo=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Where do you want to go?']")));
	  whereToGo.sendKeys("Houston");
	  selectCity=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Houston, Texas, United States']")));
	  selectCity.click();
	  endDestination=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter City, Country or Region']")));
	  endDestination.sendKeys("Mumbai");
	  selectDestination=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Mumbai, Maharashtra, India']")));
	  //startDate=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Start Date']")));
	  selectDestination.click();
	  startPlanning=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='button p-color full-width start-planning']")));
	  startPlanning.click(); 
	  nextButton=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='js_city_next_step_title']")));
	  nextButton.click();
	  skipButton=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Skip to']")));
	  skipButton.click();
	  skipOverviewButton=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Trip Overview']")));
	  skipOverviewButton.click();
	  editPlan=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Edit This Plan']")));
	  editPlan.click();
	  closeWindow=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='icon-close-modal']")));
	  closeWindow.click();
	  dragElement=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Houston Museum Of Natural Science']")));
	//  dropElement=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Houston Museum Of Natural Science']")));
	  actions.dragAndDrop(dragElement, dropElement).perform();
	  savePlan=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Save Plan']")));
	  finishPlan=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Finish Planning']")));
	  actions.moveToElement(savePlan).moveToElement(finishPlan).build().perform();

	
	

	  
	  

	
	 
	  
	  
	  
	 
	  
	 
	 
	  
  }
  @BeforeClass
  public void beforeClass() {
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	  actions
	  = new Actions(driver);
  }

  @AfterClass
  public void afterClass() {
	  driver.close();
  }

}
