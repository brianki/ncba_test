package javapackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Selenium {

    public static void main(String[] args) throws InterruptedException {
        // Set the path to the chromedriver.exe file
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium Webdrivers\\chromedriver-win64\\chromedriver.exe");

        // Initialize ChromeDriver
        WebDriver driver = new ChromeDriver();

        try {
            // Step 1-3: Launch browser, Navigate to URL, Verify home page
            driver.get("http://automationexercise.com");

            // Implicit wait to wait for 10 seconds
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            // Verify home page
            String expectedTitle = "Automation Practice Website";
            String actualTitle = driver.getTitle();
            if (actualTitle.contains(expectedTitle)) {
                System.out.println("Step 3: Home page is visible successfully.");
            } else {
                System.out.println("Step 3: Home page verification failed.");
            }

            // Step 4-5: Click on 'Signup / Login' button, Verify 'New User Signup!' is visible
            WebElement signupLoginButton = driver.findElement(By.linkText("Signup / Login"));
            signupLoginButton.click();

            // Explicit wait for 'Date of Birth' dropdowns
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("days")));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("months")));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("years")));

            // Locate day dropdown
            WebElement dayDropdown = driver.findElement(By.id("days"));
            Select daySelect = new Select(dayDropdown);

            // Choose the day (e.g., 1)
            daySelect.selectByValue("1");

            // Locate month dropdown
            WebElement monthDropdown = driver.findElement(By.id("months"));
            Select monthSelect = new Select(monthDropdown);

            // Choose the month (e.g., January)
            monthSelect.selectByValue("1");

            // Locate year dropdown
            WebElement yearDropdown = driver.findElement(By.id("years"));
            Select yearSelect = new Select(yearDropdown);

            // Choose the year (e.g., 1990)
            yearSelect.selectByValue("1990");

            // Continue with the registration steps...

        } finally {
            // Close the browser window
            driver.quit();
        }
    }
}
