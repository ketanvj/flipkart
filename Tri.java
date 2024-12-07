package seleniumassignments;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Tri {
    public static void main(String[] args) {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");

        // Create a new instance of the Chrome driver
        WebDriver driver = new ChromeDriver();

        // Open the TripHobo website
        driver.get("https://www.triphobo.com/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Click on "Plan Your Next Vacation" button
        WebElement planVacationButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Plan Your Next Vacation')]")));
        planVacationButton.click();

        // Type in "Where do you want to go?" field
        WebElement destinationField = wait.until(ExpectedConditions.elementToBeClickable(By.id("destination-text")));
        destinationField.sendKeys("Houston, Texas, United States");

        // Select start and end dates
        WebElement startDateInput = wait.until(ExpectedConditions.elementToBeClickable(By.id("start-date")));
        startDateInput.click();
        selectDate(driver, "2024-08-01");

        WebElement endDateInput = wait.until(ExpectedConditions.elementToBeClickable(By.id("end-date")));
        endDateInput.click();
        selectDate(driver, "2024-08-15");

        // Click on "Start Planning" button
        WebElement startPlanningButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Start Planning')]")));
        startPlanningButton.click();

        // Click on "Next -> About Your Trip" button
        WebElement nextButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Next -> About Your Trip')]")));
        nextButton.click();

        // Click on "Skip to About You"
        WebElement skipToAboutYouButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Skip to About You')]")));
        skipToAboutYouButton.click();

        // Click on "Skip to Trip Overview"
        WebElement skipToTripOverviewButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Skip to Trip Overview')]")));
        skipToTripOverviewButton.click();

        // Click on "Edit this plan"
        WebElement editThisPlanButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Edit this plan')]")));
        editThisPlanButton.click();

        // Handle any unwanted pop-ups
        try {
            WebElement closeButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class,'close-button')]")));
            closeButton.click();
        } catch (Exception e) {
            System.out.println("No pop-up appeared.");
        }

        // Drag one activity from day 1 to day 3
        WebElement activityToDrag = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-day='1']//div[contains(@class,'activity')]")));
        WebElement targetDay3 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-day='3']")));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(activityToDrag, targetDay3).perform();

        // Click on "Save plan" -> "Finish Planning"
        WebElement savePlanButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Save plan')]")));
        savePlanButton.click();

        WebElement finishPlanningButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Finish Planning')]")));
        finishPlanningButton.click();

        // Close the browser
        driver.quit();
    }

    private static void selectDate(WebDriver driver, String date) {
        // Split the date into components
        String[] dateParts = date.split("-");
        String year = dateParts[0];
        String month = dateParts[1];
        String day = dateParts[2];

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Select the year
        WebElement yearElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@class='ui-datepicker-year']/option[@value='" + year + "']")));
        yearElement.click();

        // Select the month
        WebElement monthElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@class='ui-datepicker-month']/option[@value='" + (Integer.parseInt(month) - 1) + "']")));
        monthElement.click();

        // Select the day
        WebElement dayElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='" + day + "']")));
        dayElement.click();
    }
}
