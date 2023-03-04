package hu.ladybugs.myinfo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class MembershipsPage {
    WebDriver driver;
    WebDriverWait wait;

    By loginUserName = By.cssSelector("input[Name='username']");
    By loginPassWord = By.cssSelector("input[Name='password']");
    By loginButtonElement = By.cssSelector("button[class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']");
    By myInfo = By.linkText("My Info");
    By personalDetailsSite = By.cssSelector("h6[class='oxd-text oxd-text--h6 orangehrm-main-title']");
    By membershipsSubMenuButtonElement = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[1]/div[2]/div[11]/a");
    By assignedMembershipsAddButtonElement = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/div/button/i");
    By membershipSelectArrowElement = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[1]/div/div[1]/div/div[2]/div/div/div[2]/i");
    By membershipSelectInputElement = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[1]/div/div[1]/div/div[2]/div/div/div[1]");
    By subscriptionPaidByArrowElement = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[1]/div/div[2]/div/div[2]/div/div/div[2]/i");
    By subscriptionPaidBySelectInputElement = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[1]/div/div[2]/div/div[2]/div/div/div[1]");
    By subscriptionAmountInputElement = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[1]/div/div[3]/div/div[2]/input");
    By currencySelectArrowElement = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[1]/div/div[4]/div/div[2]/div/div/div[2]/i");

    By currencySelectInputElement = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[1]/div/div[4]/div/div[2]/div/div/div[1]");
    By subscriptionCommenceDateInputElement = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[1]/div/div[5]/div/div[2]/div/div/input");
    By subscriptionRenewalDateInputElement = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[1]/div/div[6]/div/div[2]/div/div/input");
    By saveButtonElement = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[2]/button[2]");
    By confirmatoryMessageElement = By.id("oxd-toaster_1");

    public MembershipsPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }


    public void loadHomePage() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        WebElement headerElement = driver.findElement((By.cssSelector("h5[class='oxd-text oxd-text--h5 orangehrm-login-title']")));
        Assert.assertTrue(headerElement.isDisplayed());
    }

    public void loginWhitValidUsernameAndValidPwd() {
        WebElement loginUsername = driver.findElement(loginUserName);
        Assert.assertTrue(loginUsername.isDisplayed());
        loginUsername.click();
        loginUsername.sendKeys("Admin");
        WebElement loginPassword = driver.findElement(loginPassWord);
        Assert.assertTrue(loginUsername.isDisplayed());
        loginPassword.click();
        loginPassword.sendKeys("admin123");
        WebElement loginButton = driver.findElement(loginButtonElement);
        loginButton.click();
        WebElement myInfoMenu = driver.findElement(myInfo);
        myInfoMenu.click();
        WebElement personalDetailsText = driver.findElement(personalDetailsSite);
        Assert.assertTrue(personalDetailsText.isDisplayed());
    }

    public void assignedMembershipsAdd() throws InterruptedException {
        WebElement membershipsSubMenuButton = driver.findElement(membershipsSubMenuButtonElement);
        membershipsSubMenuButton.click();

        WebElement assignedMembershipsAddButton = driver.findElement(assignedMembershipsAddButtonElement);
        assignedMembershipsAddButton.click();

        WebElement membershipSelectArrow = driver.findElement(membershipSelectArrowElement);
        membershipSelectArrow.click();

        WebElement membershipSelectInput = driver.findElement(membershipSelectInputElement);
        membershipSelectInput.sendKeys(Keys.DOWN);
        membershipSelectInput.sendKeys(Keys.DOWN);
        membershipSelectInput.sendKeys(Keys.RETURN);

        WebElement subscriptionPaidByArrow = driver.findElement(subscriptionPaidByArrowElement);
        subscriptionPaidByArrow.click();

        WebElement subscriptionPaidBySelectInput = driver.findElement(subscriptionPaidBySelectInputElement);
        subscriptionPaidBySelectInput.sendKeys(Keys.DOWN);
        subscriptionPaidBySelectInput.sendKeys(Keys.DOWN);
        subscriptionPaidBySelectInput.sendKeys(Keys.RETURN);

        WebElement subscriptionAmountInput = driver.findElement(subscriptionAmountInputElement);
        subscriptionAmountInput.sendKeys("5000");

        WebElement currencySelectArrow = driver.findElement(currencySelectArrowElement);
        currencySelectArrow.click();

        WebElement currencySelectInput = driver.findElement(currencySelectInputElement);
        currencySelectInput.sendKeys(Keys.DOWN);
        currencySelectInput.sendKeys(Keys.DOWN);
        currencySelectInput.sendKeys(Keys.DOWN);
        currencySelectInput.sendKeys(Keys.RETURN);

        WebElement subscriptionCommenceDateInput = driver.findElement(subscriptionCommenceDateInputElement);
        subscriptionCommenceDateInput.sendKeys("2022-01-02");

        WebElement subscriptionRenewalDateInput = driver.findElement(subscriptionRenewalDateInputElement);
        subscriptionRenewalDateInput.sendKeys("2023-02-20");

        WebElement saveButton = driver.findElement(saveButtonElement);
        saveButton.click();

        WebElement confirmatoryMessage = driver.findElement(confirmatoryMessageElement);
        wait.until(ExpectedConditions.elementToBeClickable(confirmatoryMessage));
        Assert.assertTrue(confirmatoryMessage.isDisplayed());
        Thread.sleep(7000);
    }
}
