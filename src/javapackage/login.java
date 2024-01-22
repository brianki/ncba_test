package javapackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class login {


	    public static void main(String[] args) {
	        // Set the path to the chromedriver.exe file
	        System.setProperty("webdriver.chrome.driver", "C:\\Selenium Webdrivers\\chromedriver-win64\\chromedriver.exe");

	        // Initialize ChromeDriver
	        WebDriver driver = new ChromeDriver();

	        try {
	            // Step 1-3: Launch browser, Navigate to URL, Verify home page
	            driver.get("http://automationexercise.com");

	            // Verify home page
	            String expectedTitle = "Automation Practice Website";
	            String actualTitle = driver.getTitle();
	            if (actualTitle.contains(expectedTitle)) {
	                System.out.println("Step 3: Home page is visible successfully.");
	            } else {
	                System.out.println("Step 3: Home page verification failed.");
	            }

	            // Step 4-5: Click on 'Signup / Login' button, Verify 'Login to your account' is visible
	            WebElement signupLoginButton = driver.findElement(By.linkText("Signup / Login"));
	            signupLoginButton.click();

	            // Verify 'Login to your account' is visible
	            WebElement loginHeaderText = driver.findElement(By.xpath("//h2[contains(text(),'Login to your account')]"));
	            if (loginHeaderText.isDisplayed()) {
	                System.out.println("Step 5: 'Login to your account' is visible.");
	            } else {
	                System.out.println("Step 5: 'Login to your account' verification failed.");
	            }

	            // Step 6-7: Enter correct email address and password, Click 'login' button
	            WebElement emailInput = driver.findElement(By.name("email"));
	            WebElement passwordInput = driver.findElement(By.name("password"));
	            WebElement loginButton = driver.findElement(By.cssSelector("button[data-qa='login-button']"));

	            emailInput.sendKeys("your_email@example.com");
	            passwordInput.sendKeys("your_password");

	            loginButton.click();

	            // Step 8: Verify 'Logged in as username' is visible
	            WebElement loggedInText = driver.findElement(By.xpath("//div[contains(text(),'Logged in as')]"));
	            if (loggedInText.isDisplayed()) {
	                System.out.println("Step 8: 'Logged in as username' is visible.");
	            } else {
	                System.out.println("Step 8: 'Logged in as username' verification failed.");
	            }

	            // Step 9-10: Click 'Delete Account' button, Verify 'ACCOUNT DELETED!' is visible
	            WebElement deleteAccountButton = driver.findElement(By.xpath("//button[contains(text(),'Delete Account')]"));
	            deleteAccountButton.click();

	            // Wait for 'ACCOUNT DELETED!' to be visible
	            Thread.sleep(2000);

	            // Verify 'ACCOUNT DELETED!' is visible
	            WebElement accountDeletedText = driver.findElement(By.xpath("//div[contains(text(),'ACCOUNT DELETED!')]"));
	            if (accountDeletedText.isDisplayed()) {
	                System.out.println("Step 10: 'ACCOUNT DELETED!' is visible.");
	            } else {
	                System.out.println("Step 10: 'ACCOUNT DELETED!' verification failed.");
	            }

	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        } finally {
	            // Close the browser window
	            driver.quit();
	        }
	    }
	}
