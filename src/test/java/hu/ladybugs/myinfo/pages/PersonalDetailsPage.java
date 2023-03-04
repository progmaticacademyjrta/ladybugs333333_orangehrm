package hu.ladybugs.myinfo.pages;


import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class PersonalDetailsPage {
    WebDriver driver;
    WebDriverWait wait;

    By loginUserName = By.cssSelector("input[Name='username']");
    By loginPassWord = By.cssSelector("input[Name='password']");
    By loginButtonElement = By.cssSelector("button[class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']");
    By myInfo = By.linkText("My Info");
    By personalDetailsSite = By.cssSelector("h6[class='oxd-text oxd-text--h6 orangehrm-main-title']");
    By firstNameElement = By.cssSelector("input[Name='firstName']");
    By middleNameElement = By.cssSelector("input[Name='middleName']");
    By lastNameElement = By.cssSelector("input[Name='lastName']");
    By nickNameElement = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[1]/div[2]/div/div/div[2]/input");
    By employeeIdElement = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[2]/div[1]/div[1]/div/div[2]/input");
    By otherIdElement = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[2]/div[1]/div[2]/div/div[2]/input");
    By driversLicenseNumberElement = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[2]/div[2]/div[1]/div/div[2]/input");
    By licenseExpiryDateElement = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[2]/div[2]/div[2]/div/div[2]/div/div/input");
    By ssnNumberElement = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[2]/div[3]/div[1]/div/div[2]/input");
    By sinNumberElement = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[2]/div[3]/div[2]/div/div[2]/input");
    By nationalitySelectArrowElement = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[3]/div[1]/div[1]/div/div[2]/div/div/div[2]/i");
    By nationalitySelectElement = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[3]/div[1]/div[1]/div/div[2]/div/div/div[1]");
    By maritalStatusArrowElement = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[3]/div[1]/div[2]/div/div[2]/div/div/div[2]/i");
    By maritalStatusElement = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[3]/div[1]/div[2]/div/div[2]/div/div/div[1]");
    By militaryServiceElement = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[4]/div/div[1]/div/div[2]/input");
    By personalDetailsSaveButtonElement = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[5]/button");
    By confirmatoryMessageElement = By.id("oxd-toaster_1");

    By bloodTypeSelectArrowElement = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[2]/div/form/div[1]/div/div/div/div[2]/div/div/div[2]/i");
    By bloodTypeSelectElement = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[2]/div/form/div[1]/div/div/div/div[2]/div/div/div[1]");
    By attachmentAddButtonElement = By.cssSelector("button[class='oxd-button oxd-button--medium oxd-button--text']");
    By getAttachmentCommentElement = By.cssSelector("textarea[class='oxd-textarea oxd-textarea--active oxd-textarea--resize-vertical']");
    By AttachmentBrowseElement = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[3]/div/form/div[1]/div/div/div/div[2]/input");

    By checkboxDeleteElement = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[3]/div[3]/div/div[2]/div/div/div[1]/div/div/label/span/i");
    By attachmentsAddSaveButtonElement = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[3]/div/form/div[3]/button[2]");
    By recordDeleteIconElement = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[3]/div[3]/div/div[2]/div[1]/div/div[8]/div/button[2]/i");
    By yesDeletePopupButtonElement = By.cssSelector("button[class='oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin']");

    By recordDeleteCancelButtonElement = By.cssSelector("button[class='oxd-button oxd-button--medium oxd-button--text orangehrm-button-margin']");

    By recordEditingPencilIconElement = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[3]/div[3]/div/div[2]/div[1]/div/div[8]/div/button[1]/i");
    By attachmentAddInputElement = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[3]/div/form/div[2]/div/div/div/div[2]/input");
    By attachmentSaveButtonElement = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[3]/div/form/div[4]/button[2]");

    public PersonalDetailsPage(WebDriver driver, WebDriverWait wait) {
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

    public void personalDetailsDataFillingAndSaving() throws InterruptedException {
        WebElement firstName = driver.findElement(firstNameElement);
        wait.until(ExpectedConditions.elementToBeClickable(firstNameElement));
        Thread.sleep(3000);
        firstName.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        firstName.sendKeys(Keys.BACK_SPACE);
        firstName.click();
        firstName.sendKeys("Robert");

        WebElement middleName = driver.findElement(middleNameElement);
        middleName.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        middleName.sendKeys(Keys.BACK_SPACE);
        middleName.click();
        middleName.sendKeys("Paul");

        WebElement lastName = driver.findElement(lastNameElement);
        lastName.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        lastName.sendKeys(Keys.BACK_SPACE);
        lastName.click();
        lastName.sendKeys("Smith");


        WebElement employeeId = driver.findElement(employeeIdElement);
        employeeId.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        employeeId.sendKeys(Keys.BACK_SPACE);
        employeeId.click();
        employeeId.sendKeys("1234");

        WebElement otherId = driver.findElement(otherIdElement);
        otherId.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        otherId.sendKeys(Keys.BACK_SPACE);
        otherId.click();
        otherId.sendKeys("2345");

        WebElement driversLicenseNumber = driver.findElement(driversLicenseNumberElement);
        driversLicenseNumber.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        driversLicenseNumber.sendKeys(Keys.BACK_SPACE);
        driversLicenseNumber.click();
        driversLicenseNumber.sendKeys("1234");

        WebElement licenseExpiryDate = driver.findElement(licenseExpiryDateElement);
        licenseExpiryDate.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        licenseExpiryDate.sendKeys(Keys.BACK_SPACE);
        licenseExpiryDate.click();
        licenseExpiryDate.sendKeys("2023-03-09");

        WebElement ssnNumber = driver.findElement(ssnNumberElement);
        ssnNumber.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        ssnNumber.sendKeys(Keys.BACK_SPACE);
        ssnNumber.click();
        ssnNumber.sendKeys("235-23-4569");

        WebElement sinNumber = driver.findElement(sinNumberElement);
        sinNumber.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        sinNumber.sendKeys(Keys.BACK_SPACE);
        sinNumber.click();
        sinNumber.sendKeys("123 123 123");

        WebElement sinNumberToScroll = driver.findElement(sinNumberElement);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", sinNumberToScroll);


        WebElement nationalitySelectArrow = driver.findElement(nationalitySelectArrowElement);
        nationalitySelectArrow.click();
        WebElement nationalitySelect = driver.findElement(nationalitySelectElement);
        nationalitySelect.sendKeys(Keys.DOWN);
        nationalitySelect.sendKeys(Keys.DOWN);
        nationalitySelect.sendKeys(Keys.DOWN);
        nationalitySelect.sendKeys(Keys.RETURN);

        WebElement maritalStatusArrow = driver.findElement(maritalStatusArrowElement);
        maritalStatusArrow.click();
        WebElement maritalStatus = driver.findElement(maritalStatusElement);
        maritalStatus.sendKeys(Keys.DOWN);
        maritalStatus.sendKeys(Keys.DOWN);
        maritalStatus.sendKeys(Keys.DOWN);
        maritalStatus.sendKeys(Keys.RETURN);

        WebElement militaryService = driver.findElement(militaryServiceElement);
        militaryService.click();
        maritalStatus.sendKeys("Yes");

        WebElement personalDetailsSaveButton = driver.findElement(personalDetailsSaveButtonElement);
        personalDetailsSaveButton.click();

        WebElement savedMessage = driver.findElement(confirmatoryMessageElement);
        wait.until(ExpectedConditions.elementToBeClickable(savedMessage));
        Assert.assertTrue(savedMessage.isDisplayed());

        WebElement bloodTypeSelectArrow = driver.findElement(bloodTypeSelectArrowElement);
        bloodTypeSelectArrow.click();
        WebElement bloodTypeSelect = driver.findElement(bloodTypeSelectElement);
        bloodTypeSelect.sendKeys(Keys.DOWN);
        bloodTypeSelect.sendKeys(Keys.DOWN);
        bloodTypeSelect.sendKeys(Keys.RETURN);

        WebElement savedMessageForBloodType = driver.findElement(confirmatoryMessageElement);
        wait.until(ExpectedConditions.elementToBeClickable(savedMessageForBloodType));
        Assert.assertTrue(savedMessageForBloodType.isDisplayed());


    }

    public void attachmentsAdd() throws InterruptedException {
        WebElement bloodTypeToScroll = driver.findElement(bloodTypeSelectElement);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", bloodTypeToScroll);


        WebElement attachmentAddButton = driver.findElement(attachmentAddButtonElement);
        attachmentAddButton.click();
        WebElement attachmentBrowse = driver.findElement(AttachmentBrowseElement);
        attachmentBrowse.sendKeys("C:\\Users\\PC\\Downloads\\Fa.jpg");

        WebElement getAttachmentComment = driver.findElement(getAttachmentCommentElement);
        getAttachmentComment.click();
        getAttachmentComment.sendKeys("Other information");

        WebElement attachmentsAddSaveButton = driver.findElement(attachmentsAddSaveButtonElement);
        attachmentsAddSaveButton.click();

        WebElement savedMessageForAttachment = driver.findElement(confirmatoryMessageElement);
        wait.until(ExpectedConditions.elementToBeClickable(savedMessageForAttachment));


    }

    public void recordsFoundDelete() throws InterruptedException {
        WebElement recordDeleteScroll = driver.findElement(bloodTypeSelectElement);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", recordDeleteScroll);

        WebElement checkboxDelete = driver.findElement(checkboxDeleteElement);
        checkboxDelete.click();

        WebElement recordDeleteIcon = driver.findElement(recordDeleteIconElement);
        recordDeleteIcon.click();

        WebElement yesDeletePopupButton = driver.findElement(yesDeletePopupButtonElement);
        wait.until(ExpectedConditions.elementToBeClickable(yesDeletePopupButton));
        yesDeletePopupButton.click();

        WebElement deleteMessage = driver.findElement(confirmatoryMessageElement);
        wait.until(ExpectedConditions.elementToBeClickable(deleteMessage));
        Assert.assertTrue(deleteMessage.isDisplayed());

    }

    public void recordsFoundDeleteCancel() throws InterruptedException {
        WebElement recordDeleteScroll = driver.findElement(bloodTypeSelectElement);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", recordDeleteScroll);

        WebElement checkboxDelete = driver.findElement(checkboxDeleteElement);
        checkboxDelete.click();
        WebElement recordDeleteIcon = driver.findElement(recordDeleteIconElement);
        recordDeleteIcon.click();
        WebElement recordDeleteCancelButton = driver.findElement(recordDeleteCancelButtonElement);
        wait.until(ExpectedConditions.elementToBeClickable(recordDeleteCancelButton));
        recordDeleteCancelButton.click();
        Assert.assertTrue(checkboxDelete.isDisplayed());
    }

    public void personalDetailsRecordsFoundEditingFunction() throws InterruptedException {
        WebElement recordDeleteScroll = driver.findElement(bloodTypeSelectElement);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", recordDeleteScroll);

        WebElement recordEditingPencilIcon = driver.findElement(recordEditingPencilIconElement);
        recordEditingPencilIcon.click();

        WebElement attachmentBrowse = driver.findElement(attachmentAddInputElement);
        attachmentBrowse.sendKeys("C:\\Users\\PC\\Downloads\\playground.png");

        WebElement attachmentSaveButton = driver.findElement(attachmentSaveButtonElement);
        attachmentSaveButton.click();

        WebElement savedMessageForAttachment = driver.findElement(confirmatoryMessageElement);
        wait.until(ExpectedConditions.elementToBeClickable(savedMessageForAttachment));

    }

    public void ssnNumberWhitInvalidCharacter() throws InterruptedException {
        WebElement ssnNumber = driver.findElement(ssnNumberElement);
        ssnNumber.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        ssnNumber.sendKeys(Keys.BACK_SPACE);
        ssnNumber.click();
        ssnNumber.sendKeys("dfk*,***");
        WebElement personalDetailsSaveButton = driver.findElement(personalDetailsSaveButtonElement);
        personalDetailsSaveButton.click();

        WebElement savedMessage = driver.findElement(confirmatoryMessageElement);
        wait.until(ExpectedConditions.elementToBeClickable(savedMessage));
        Assert.assertTrue(!savedMessage.isDisplayed());
    }
}
