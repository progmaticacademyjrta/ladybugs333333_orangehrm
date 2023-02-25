package hu.ladybugs.myinfo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ContactDetailsPage {
    WebDriver driver;
    WebDriverWait wait;

    By loginUserName = By.cssSelector("input[Name='username']");
    By loginPassWord = By.cssSelector("input[Name='password']");
    By loginButtonElement = By.cssSelector("button[class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']");
    By myInfo = By.linkText("My Info");
    By personalDetailsSite = By.cssSelector("h6[class='oxd-text oxd-text--h6 orangehrm-main-title']");

    By contactDetailsElement = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[1]/div[2]/div[2]/a");
    By street1Element = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[1]/div/div[1]/div/div[2]/input");
    By street2Element = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[1]/div/div[2]/div/div[2]/input");
    By cityFieldElement = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[1]/div/div[3]/div/div[2]/input");
    By stateFieldElement = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[1]/div/div[4]/div/div[2]/input");
    By zipCodeFieldElement = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[1]/div/div[5]/div/div[2]/input");
    By countrySearchArrowElement = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[1]/div/div[6]/div/div[2]/div/div/div[2]/i");
    By getCountrySearchElement = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[1]/div/div[6]/div/div[2]/div/div/div[1]");

    By telephoneHomeFieldElement = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[2]/div/div[1]/div/div[2]/input");
    By telephoneMobileFieldElement = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[2]/div/div[2]/div/div[2]/input");
    By telephoneWorkFieldElement = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[2]/div/div[3]/div/div[2]/input");


    public ContactDetailsPage(WebDriver driver, WebDriverWait wait) {
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
        // WebElement myInfoMenuSpan = driver.findElement(By.cssSelector("span[class='oxd-text oxd-text--span oxd-main-menu-item--name']"));
        //Assert.assertTrue(myInfoMenuSpan.isDisplayed());
    }

    public void contactDetailsFillingAndSaving() throws InterruptedException {
        WebElement contactDetails = driver.findElement(contactDetailsElement);
        contactDetails.click();

        WebElement street1 = driver.findElement(street1Element);
        street1.click();
        street1.sendKeys("Freedom Street");

        WebElement street2 = driver.findElement(street2Element);
        street2.click();
        street2.sendKeys("Other Street");

        WebElement cityField = driver.findElement(cityFieldElement);
        cityField.sendKeys("Budapest");

        WebElement stateField = driver.findElement(stateFieldElement);
        stateField.sendKeys("kerület");

        WebElement zipCodeField = driver.findElement(zipCodeFieldElement);
        zipCodeField.sendKeys("1039");

        WebElement countrySearchArrow = driver.findElement(countrySearchArrowElement);
        countrySearchArrow.click();
        WebElement getCountrySearch = driver.findElement(getCountrySearchElement);
        getCountrySearch.sendKeys(Keys.DOWN);
        getCountrySearch.sendKeys(Keys.DOWN);
        getCountrySearch.sendKeys(Keys.DOWN);
        getCountrySearch.sendKeys(Keys.RETURN);

        WebElement telephoneHomeField = driver.findElement(telephoneHomeFieldElement);
        telephoneHomeField.sendKeys("+3611234356");

        WebElement telephoneMobileField = driver.findElement(telephoneMobileFieldElement);
        telephoneMobileField.sendKeys("+3611234356");

        WebElement telephoneWorkField = driver.findElement(telephoneWorkFieldElement);
        telephoneWorkField.sendKeys("+3611234356");





        Thread.sleep(7000);


    }
}
