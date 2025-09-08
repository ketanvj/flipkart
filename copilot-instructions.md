# Copilot Instructions for Flipkart Selenium Test Automation

This repository contains Selenium-based test automation for Flipkart e-commerce testing. Follow these guidelines when assisting with code generation and maintenance.

## Project Overview

This is a Java-based test automation framework that uses:
- **Selenium WebDriver** for browser automation
- **TestNG** as the testing framework  
- **Jenkins** for CI/CD pipeline
- **Chrome/Firefox** browsers for test execution

## Project Structure

```
├── MyFirstWebDriverTest.java          # Basic WebDriver test example
├── WebElementCommandsFinal.java       # WebElement interaction tests
├── smoke/                            # Smoke test suite
│   ├── MyFirstTestNGTest.java        # TestNG-based tests
│   ├── Payments.java                 # Payment-related tests
│   └── Person.java                   # Person/user-related tests
├── Score123.java                     # Utility/helper class
├── Shipment.java                     # Shipment-related test cases
├── Jenkinsfile                       # CI/CD pipeline configuration
└── Jenkinsfile1                      # Alternative pipeline config
```

## Coding Standards and Patterns

### 1. Test Class Structure
Follow this pattern when creating new test classes:
```java
package scripts;

import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.testng.Assert.*;

public class NewTestClass {
    WebDriver driver;
    
    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    
    @Test
    public void testMethodName() {
        // Test implementation
    }
    
    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
```

### 2. WebElement Interaction Patterns
Use these established patterns for common operations:

**Element Finding and Interaction:**
```java
// Standard pattern for finding and interacting with elements
WebElement element = driver.findElement(By.name("elementName"));
element.sendKeys("text");

// Method chaining for simple operations
driver.findElement(By.name("password")).clear();
driver.findElement(By.name("password")).sendKeys("value");
```

**Dropdown Handling:**
```java
WebElement dropdown = driver.findElement(By.name("dropdownName"));
Select select = new Select(dropdown);
select.selectByVisibleText("Option Text");
select.selectByValue("optionValue");
select.selectByIndex(0);
```

**Checkbox/Radio Button Handling:**
```java
WebElement checkbox = driver.findElement(By.name("checkboxName"));
if (!checkbox.isSelected()) {
    checkbox.click();
}
```

### 3. Test Annotations and Groups
Use TestNG groups to categorize tests:
```java
@Test(groups = "Smoke")        // For smoke tests
@Test(groups = "Regression")   // For regression tests
```

### 4. Assertions
Use TestNG assertions with meaningful error messages:
```java
assertEquals(actualValue, expectedValue, "Custom error message explaining what failed");
assertTrue(condition, "Explanation of what should be true");
assertFalse(condition, "Explanation of what should be false");
```

### 5. Synchronization
Use Thread.sleep() sparingly and only when necessary:
```java
Thread.sleep(5000); // Only use when no other synchronization option available
```

## Common Test Scenarios

### Login Tests
Target URLs and test data commonly used:
- `https://nichethyself.com/tourism/home.html` - Tourism site login
- Username: `stc123`, Password: `12345`
- Expected page title after login: `My account`

### Web Element Tests  
- `http://www.cookbook.seleniumacademy.com/Config.html` - Configuration page
- `https://the-internet.herokuapp.com/dynamic_loading/1` - Dynamic content

### Browser Configuration
Default browser setup patterns:
```java
// Chrome (preferred)
WebDriver driver = new ChromeDriver();
driver.manage().window().maximize();

// Firefox (alternative)
WebDriver driver = new FirefoxDriver();

// Chrome with options (when needed)
ChromeOptions options = new ChromeOptions();
options.addArguments("--remote-allow-origins=*");
driver = new ChromeDriver(options);
```

## File Naming Conventions
- Test classes should end with `Test.java` (e.g., `LoginTest.java`)
- Use descriptive names that indicate the functionality being tested
- Group related tests in packages (e.g., `scripts` package)

## Best Practices for New Code

1. **Package Structure**: Place all test classes in the `scripts` package
2. **Method Naming**: Use descriptive test method names starting with `test` prefix
3. **Error Handling**: Include meaningful error messages in assertions
4. **Resource Cleanup**: Always call `driver.quit()` in `@AfterClass` or `@AfterMethod`
5. **Page Validation**: Validate expected page titles and elements after navigation
6. **Code Reuse**: Extract common operations into reusable methods

## Jenkins Integration
The project includes Jenkins pipeline files (`Jenkinsfile` and `Jenkinsfile1`) with stages:
- Hello/Setup
- Unit Testing  
- Build
- Testing
- Deployment

## Dependencies and Setup
The project uses these key dependencies:
- Selenium WebDriver
- TestNG
- Chrome/Firefox WebDriver executables

## Debugging Tips
- Use `System.out.println()` for debugging output
- Check element visibility with `element.isDisplayed()`
- Validate element state with `element.isEnabled()` and `element.isSelected()`
- Use `driver.getTitle()` to verify page navigation

When generating new code, follow these established patterns and maintain consistency with the existing codebase structure and naming conventions.