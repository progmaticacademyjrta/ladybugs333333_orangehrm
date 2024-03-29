package hu.ladybugs.login;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginTests {
    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void driverSetup() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

        //Creating an object of ChromeDriver
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofMillis(30000));
        driver.manage().window().maximize();
        //Deleting all the cookies
        driver.manage().deleteAllCookies();

        //Specifiying pageLoadTimeout and Implicit wait
        driver.manage().timeouts().pageLoadTimeout(Duration.ofMillis(30000));
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(30000));
        System.out.println("Test case execution started");
    }

    @After
    public void driverCleanUp() {
        driver.quit();
        System.out.println("Test case execution finished");
    }

    @Given("Webpage has been loaded {string}")
    public void loadWebPage(String url) {
        driver.get(url);
    }

    @When("The user enters the username as {string} and password as {string} and click to Login button")
    public void filloutInputFieldsAndClickLogin(String username, String password) throws InterruptedException {
        Thread.sleep(2000);
        WebElement usernameInput = driver.findElement(By.cssSelector("input[name='username']"));
        usernameInput.sendKeys(username);
        WebElement pwdInput = driver.findElement(By.cssSelector("input[name='password']"));
        pwdInput.sendKeys(password);
        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit'][class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']"));
        loginButton.click();
    }

    @Then("the user should be able to login successfully.")
    public void validateLogin() throws InterruptedException {
        String pageCurrentUrl = driver.getCurrentUrl();
        Assert.assertEquals(pageCurrentUrl, "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
        Thread.sleep(2000);
    }



    @Then("the user should NOT be able to login successfully and {string} error message comes.")
    public void validateNotLogin(String errorMsg) throws InterruptedException {
        WebElement errorMessage = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/div/div[1]/div[1]"));
        Assert.assertEquals(errorMessage.getText(), errorMsg);
        Thread.sleep(2000);
    }

    @Then("the user should NOT be able to login successfully with empty credentials and {string} error message comes.")
    public void validateNotLoginEmpty1(String errorMsg) throws InterruptedException {
        WebElement errorMessage = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/span"));
        Assert.assertEquals(errorMessage.getText(), errorMsg);
        Thread.sleep(2000);
    }

    @Then("the user should NOT be able to login successfully with another empty credentials and {string} error message comes.")
    public void validateNotLoginEmpty2(String errorMsg) throws InterruptedException {
        WebElement errorMessage = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/span"));
        Assert.assertEquals(errorMessage.getText(), errorMsg);
        Thread.sleep(2000);
    }

}
