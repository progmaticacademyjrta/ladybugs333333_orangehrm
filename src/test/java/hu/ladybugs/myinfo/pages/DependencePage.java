package hu.ladybugs.myinfo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class DependencePage {
    WebDriver driver;
    WebDriverWait wait;

    By loginUserName = By.cssSelector("input[Name='username']");
    By loginPassWord = By.cssSelector("input[Name='password']");
    By loginButtonElement = By.cssSelector("button[class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']");
    By myInfo = By.linkText("My Info");
    By personalDetailsSite = By.cssSelector("h6[class='oxd-text oxd-text--h6 orangehrm-main-title']");
    By dependentSubMenuElement = By.cssSelector("a[href='/web/index.php/pim/viewDependents/empNumber/7']");

    By addButtonElement = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/div/button");

    By nameFieldElement = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[1]/div/div[1]/div/div[2]/input");

    By relationshipSelectArrowElement = By.cssSelector("div[class='oxd-select-text--after']");

    By relationshipSelectInputElement = By.cssSelector("div[class='oxd-select-text-input']");

    By dateOfBirthCalenderInputElement = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[2]/div/div/div/div[2]/div/div/input");
    By saveButtonElement = By.cssSelector("button[class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']");


    public DependencePage(WebDriver driver, WebDriverWait wait) {
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

    public void dependentEnteringDataAndSaveIt() throws InterruptedException {
        WebElement dependentSubMenu = driver.findElement(dependentSubMenuElement);
        dependentSubMenu.click();

        WebElement addButton = driver.findElement(addButtonElement);
        addButton.click();

        WebElement nameField = driver.findElement(nameFieldElement);
        nameField.sendKeys(Keys.chord(Keys.CONTROL,"a"));
        nameField.sendKeys(Keys.BACK_SPACE);
        nameField.sendKeys("Peter");

        WebElement relationshipSelectArrow = driver.findElement(relationshipSelectArrowElement);
        relationshipSelectArrow.click();

        WebElement getRelationshipSelectInput = driver.findElement(relationshipSelectInputElement);
        getRelationshipSelectInput.sendKeys(Keys.DOWN);
        //   getRelationshipSelectInput.sendKeys(Keys.DOWN);
        getRelationshipSelectInput.sendKeys(Keys.RETURN);

        WebElement dateOfBirthCalenderInput = driver.findElement(dateOfBirthCalenderInputElement);
        dateOfBirthCalenderInput.sendKeys(Keys.chord(Keys.CONTROL,"a"));
        dateOfBirthCalenderInput.sendKeys(Keys.BACK_SPACE);
        dateOfBirthCalenderInput.sendKeys("2013-02-23");

        WebElement saveButton = driver.findElement(saveButtonElement);
        saveButton.click();

    }
}
