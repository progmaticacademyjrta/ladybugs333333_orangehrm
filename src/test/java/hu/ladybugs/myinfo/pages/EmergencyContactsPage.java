package hu.ladybugs.myinfo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class EmergencyContactsPage {
    WebDriver driver;
    WebDriverWait wait;

    By loginUserName = By.cssSelector("input[Name='username']");
    By loginPassWord = By.cssSelector("input[Name='password']");
    By loginButtonElement = By.cssSelector("button[class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']");
    By myInfo = By.linkText("My Info");
    By personalDetailsSite = By.cssSelector("h6[class='oxd-text oxd-text--h6 orangehrm-main-title']");

    By emergencyContactSubMenuElement = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[1]/div[2]/div[3]/a");
    By emergencyContactAddButtonElement = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/div/button/i");
    By nameInputFieldElement = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[1]/div/div[1]/div/div[2]/input");

    By relationshipFiledElement = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[1]/div/div[2]/div/div[2]/input");

    By homeTelephoneFieldElement = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[2]/div/div[1]/div/div[2]/input");

    By mobileTelephoneFieldElement = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[2]/div/div[2]/div/div[2]/input");
    By workMobileFieldElement = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[2]/div/div[3]/div/div[2]/input");

    By saveButtonElement = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[3]/button[2]");

    By confirmationMessageElement = By.id("oxd-toaster_1");

    By deleteIconElement = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[3]/div/div[2]/div/div/div[7]/div/button[1]/i");
    By deleteYesDeleteButtonElement = By.cssSelector("button[class='oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin']");
    By deleteNoDeleteButtonElement = By.cssSelector("button[class='oxd-button oxd-button--medium oxd-button--text orangehrm-button-margin']");
    By editorPencilIconElement = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[3]/div/div[2]/div[1]/div/div[7]/div/button[2]");


    public EmergencyContactsPage(WebDriver driver, WebDriverWait wait) {
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

    public void addNewEmergencyContacts() throws InterruptedException {
        WebElement emergencyContactSubMenu = driver.findElement(emergencyContactSubMenuElement);
        emergencyContactSubMenu.click();

        WebElement emergencyContactAddButton = driver.findElement(emergencyContactAddButtonElement);
        emergencyContactAddButton.click();

        WebElement nameInputField = driver.findElement(nameInputFieldElement);
        nameInputField.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        nameInputField.sendKeys(Keys.BACK_SPACE);
        nameInputField.sendKeys("Peter");


        WebElement relationshipFiled = driver.findElement(relationshipFiledElement);
        relationshipFiled.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        relationshipFiled.sendKeys(Keys.BACK_SPACE);
        relationshipFiled.sendKeys("father");

        WebElement homeTelephoneField = driver.findElement(homeTelephoneFieldElement);
        homeTelephoneField.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        homeTelephoneField.sendKeys(Keys.BACK_SPACE);
        homeTelephoneField.sendKeys("+361342345");

        WebElement mobileTelephoneField = driver.findElement(mobileTelephoneFieldElement);
        mobileTelephoneField.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        mobileTelephoneField.sendKeys(Keys.BACK_SPACE);
        mobileTelephoneField.sendKeys("+3630456789");

        WebElement workMobileField = driver.findElement(workMobileFieldElement);
        workMobileField.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        workMobileField.sendKeys(Keys.BACK_SPACE);
        workMobileField.sendKeys("+3618765434");

        WebElement saveButton = driver.findElement(saveButtonElement);
        saveButton.click();

        WebElement confirmationMessage = driver.findElement(confirmationMessageElement);
        confirmationMessage.isDisplayed();
        Thread.sleep(7000);
    }

    public void RecordsDeleteFunction() throws InterruptedException {
        WebElement emergencyContactSubMenu = driver.findElement(emergencyContactSubMenuElement);
        emergencyContactSubMenu.click();

        WebElement deleteIcon = driver.findElement(deleteIconElement);
        deleteIcon.click();

        WebElement deleteYesDeleteButton = driver.findElement(deleteYesDeleteButtonElement);
        deleteYesDeleteButton.click();

        WebElement confirmationMessageForDelete = driver.findElement(confirmationMessageElement);
        confirmationMessageForDelete.isDisplayed();
        Thread.sleep(7000);
    }

    public void RecordsDeleteFunctionCancel() throws InterruptedException {
        WebElement emergencyContactSubMenu = driver.findElement(emergencyContactSubMenuElement);
        emergencyContactSubMenu.click();

        WebElement deleteIcon = driver.findElement(deleteIconElement);
        deleteIcon.click();


        WebElement deleteNoDeleteButton = driver.findElement(deleteNoDeleteButtonElement);
        deleteNoDeleteButton.click();

        Assert.assertTrue(deleteIcon.isDisplayed());
    }

    public void recordsFoundEditingFunction() throws InterruptedException {
        WebElement emergencyContactSubMenu = driver.findElement(emergencyContactSubMenuElement);
        emergencyContactSubMenu.click();

        WebElement editorPencilIcon = driver.findElement(editorPencilIconElement);
        editorPencilIcon.click();

        WebElement nameInputField = driver.findElement(nameInputFieldElement);
        Assert.assertTrue(nameInputField.isDisplayed());
        nameInputField.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        nameInputField.sendKeys(Keys.BACK_SPACE);
        nameInputField.sendKeys("Somebody");

        WebElement saveButton = driver.findElement(saveButtonElement);
        saveButton.click();

        WebElement confirmationMessage = driver.findElement(confirmationMessageElement);
        confirmationMessage.isDisplayed();
    }
}
