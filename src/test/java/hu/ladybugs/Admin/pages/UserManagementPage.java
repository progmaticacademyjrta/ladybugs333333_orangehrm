package hu.ladybugs.Admin.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.Random;

public class UserManagementPage {
    WebDriver driver;
    WebDriverWait wait;

    By loginTextBy = By.cssSelector("h5[class='oxd-text oxd-text--h5 orangehrm-login-title']");
    By usernameBy = By.cssSelector("input[name='username']");
    By passwordBy = By.cssSelector("input[name='password']");
    By loginButtonBy = By.cssSelector("button[type='submit'][class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']");

    By adminMenuBy = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a/span");
    By addButtonBy = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[1]/button");
    By userRoleSelectBy = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div/div[1]");
    By userRoleArrowBy = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div/div[2]/i");
    By statusSelectBy = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/div[2]/div/div/div[1]");
    By statusArrowBy = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/div[2]/div/div/div[2]/i");

    By statusEssBy = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div/div[1]");
    By employeeNameBy = By.cssSelector("input[placeholder='Type for hints...']");
    By usernameToNewUserBy = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[4]/div/div[2]/input");
    By passwordToNewUserBy = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[1]/div/div[2]/input");
    By confirmPasswordBy = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/div/div[2]/input");
    By saveButtonBy = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/button[2]");
    By cancelButtonBy = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/button[1]");
    By checkboxToDeleteBy = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div[3]/div/div[1]/div/div/label/span/i");
    By deleteSelectedButtonBy = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[2]/div/div/button");
    By deleteFromPopUpBy = By.xpath("//*[@id=\"app\"]/div[3]/div/div/div/div[3]/button[2]/i");
    By cancelFromPopUpBy = By.xpath("//*[@id=\"app\"]/div[3]/div/div/div/div[3]/button[1]");
    By recordsFoundBy = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[2]/div/span");
    By searchUserRoleArrayBy = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/div/div/div[2]/i");
    By searchUserRoleFieldBy = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/div/div/div[1]");
    By searchButtonBy = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]");
    By userRoleTypeBy = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div[1]/div/div[3]/div");
    By resetButtonBy = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[1]");
    By userRoleTextBy = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/div/div/div[1]");
    By pencilIconBy = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div[3]/div/div[6]/div/button[2]/i");
    By changePasswordCheckboxInEditUserBy = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[5]/div/div[2]/div/label/span/i");
    By newPasswordInEditUserBy = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[1]/div/div[2]/input");
    By confirmPasswordInEditUserBy = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/div/div[2]/input");
    By editUserSaveButtonBy = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/button[2]");
    By editUserCancelButtonBy = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/button[1]");

    public UserManagementPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void loadLoginPage() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        WebElement loginText = driver.findElement(loginTextBy);
        Assert.assertTrue(loginText.isDisplayed());
        System.out.println("Webpage loaded successfully.");
    }

    public void loginWithValidUsernameAndValidPassword() {
        WebElement username = driver.findElement(usernameBy);
        username.sendKeys("Admin");
        WebElement password = driver.findElement(passwordBy);
        password.sendKeys("admin123");
        WebElement loginButton = driver.findElement(loginButtonBy);
        loginButton.click();

        Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
        System.out.println("Login with valid username and valid password was successful.");

    }


    public void navigateToAdminMenu() {
        WebElement adminMenu = driver.findElement(adminMenuBy);
        adminMenu.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers");
        System.out.println("Navigating to the Admin menu was successful.");
    }


    public void addNewSystemUser() throws InterruptedException {
        WebElement addButton = driver.findElement(addButtonBy);
        addButton.click();

        WebElement userRoleArrow = driver.findElement(userRoleArrowBy);
        userRoleArrow.click();
        WebElement userRole = driver.findElement(userRoleSelectBy);
        userRole.click();
        userRole.sendKeys(Keys.DOWN);
        userRole.sendKeys(Keys.DOWN);
        userRole.sendKeys(Keys.RETURN);

        WebElement statusArrow = driver.findElement(statusArrowBy);
        statusArrow.click();
        WebElement status = driver.findElement(statusSelectBy);
        status.click();
        status.sendKeys(Keys.DOWN);
        status.sendKeys(Keys.DOWN);
        status.sendKeys(Keys.RETURN);

        WebElement employeeName = driver.findElement(employeeNameBy);
        employeeName.click();
        employeeName.sendKeys("m");
        Thread.sleep(2000);
        employeeName.sendKeys(Keys.ARROW_DOWN);
        employeeName.click();
        employeeName.sendKeys(Keys.ARROW_DOWN);
        employeeName.sendKeys(Keys.RETURN);


        WebElement usernameToNewUser = driver.findElement(usernameToNewUserBy);
        usernameToNewUser.clear();
        Random randomGenerator = new Random();
        int randomNumber = randomGenerator.nextInt(9999);
        String userName = "AlmaMater" + randomNumber;
        usernameToNewUser.sendKeys(userName);
        Thread.sleep(2000);


        WebElement passwordToNewUser = driver.findElement(passwordToNewUserBy);
        passwordToNewUser.clear();
        randomNumber = randomGenerator.nextInt(9999);
        String password = "Mamika" + randomNumber + "!";
        passwordToNewUser.sendKeys(password);


        WebElement confirmPassword = driver.findElement(confirmPasswordBy);
        confirmPassword.sendKeys(password);

        WebElement saveButton = driver.findElement(saveButtonBy);
        saveButton.click();
        Thread.sleep(10000);
        Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers");

        System.out.println("New System User added successfully.");

    }

    public void addNewSystemUserWithCancel() throws InterruptedException {
        WebElement addButton = driver.findElement(addButtonBy);
        addButton.click();
        WebElement userRoleArrow = driver.findElement(userRoleArrowBy);
        userRoleArrow.click();
        WebElement userRole = driver.findElement(userRoleSelectBy);
        userRole.click();
        userRole.sendKeys(Keys.DOWN);
        userRole.sendKeys(Keys.DOWN);
        userRole.sendKeys(Keys.RETURN);

        WebElement statusArrow = driver.findElement(statusArrowBy);
        statusArrow.click();
        WebElement status = driver.findElement(statusSelectBy);
        status.click();
        status.sendKeys(Keys.DOWN);
        status.sendKeys(Keys.DOWN);
        status.sendKeys(Keys.RETURN);

        WebElement employeeName = driver.findElement(employeeNameBy);
        employeeName.click();
        employeeName.sendKeys("l");
        Thread.sleep(2000);
        employeeName.sendKeys(Keys.ARROW_DOWN);
        employeeName.sendKeys(Keys.ARROW_DOWN);
        employeeName.sendKeys(Keys.RETURN);
        Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/admin/saveSystemUser");
        WebElement cancelButton = driver.findElement(cancelButtonBy);
        cancelButton.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers");

        System.out.println("Cancel button operates.");
    }

    public void deleteSystemUser() throws InterruptedException {
        WebElement recordsFound1 = driver.findElement(recordsFoundBy);

        String recordsFound1Text = recordsFound1.getText();
        WebElement checkboxToDelete = driver.findElement(checkboxToDeleteBy);
        checkboxToDelete.click();

        WebElement deleteSelectedButton = driver.findElement(deleteSelectedButtonBy);
        deleteSelectedButton.click();

        WebElement deleteFromPopUp = driver.findElement(deleteFromPopUpBy);
        deleteFromPopUp.click();

        Thread.sleep(2000);

        WebElement recordsFound2 = driver.findElement(recordsFoundBy);
        String recordsFound2Text = recordsFound2.getText();

        Assert.assertNotEquals(recordsFound1Text, recordsFound2Text);
        System.out.println("Selected system user deleted successfully.");

    }

    public void deleteSystemUserWithCancel() {
        WebElement recordsFound1 = driver.findElement(recordsFoundBy);

        String recordsFound1Text = recordsFound1.getText();
        WebElement checkboxToDelete = driver.findElement(checkboxToDeleteBy);
        checkboxToDelete.click();

        WebElement deleteSelectedButton = driver.findElement(deleteSelectedButtonBy);
        deleteSelectedButton.click();

        WebElement cancelFromPopUp = driver.findElement(cancelFromPopUpBy);
        cancelFromPopUp.click();

        checkboxToDelete.click();

        WebElement recordsFound2 = driver.findElement(recordsFoundBy);
        String recordsFound2Text = recordsFound2.getText();

        Assert.assertEquals(recordsFound1Text, recordsFound2Text);
        System.out.println("No, Cancel button operates.");

    }

    public void searchSystemUser() {
        WebElement searchUserRoleArrow = driver.findElement(searchUserRoleArrayBy);
        searchUserRoleArrow.click();

        WebElement searchUserRoleField = driver.findElement(searchUserRoleFieldBy);
        searchUserRoleField.click();
        searchUserRoleField.sendKeys(Keys.DOWN);
        searchUserRoleField.sendKeys(Keys.DOWN);
        searchUserRoleField.sendKeys(Keys.RETURN);

        WebElement searchButton = driver.findElement(searchButtonBy);
        searchButton.click();
        WebElement userRoleType = driver.findElement(userRoleTypeBy);
        Assert.assertEquals(userRoleType.getText(), "ESS");

        System.out.println("Search function operates.");

    }

    public void searchSystemUserWithReset() throws InterruptedException {
        WebElement searchUserRoleArrow = driver.findElement(searchUserRoleArrayBy);
        searchUserRoleArrow.click();

        WebElement searchUserRoleField = driver.findElement(searchUserRoleFieldBy);
        searchUserRoleField.click();
        searchUserRoleField.sendKeys(Keys.DOWN);
        searchUserRoleField.sendKeys(Keys.DOWN);
        searchUserRoleField.sendKeys(Keys.RETURN);

        WebElement resetButton = driver.findElement(resetButtonBy);
        resetButton.click();
        WebElement userRoleText = driver.findElement(userRoleTextBy);
        System.out.println(userRoleText);
        Thread.sleep(2000);
        Assert.assertEquals(userRoleText.getText(), "-- Select --");

        System.out.println("Reset search function operates.");

    }

    public void editSystemUser() throws InterruptedException {
        WebElement pencilIcon = driver.findElement(pencilIconBy);
        pencilIcon.click();

        WebElement changePasswordCheckboxInEditUser = driver.findElement(changePasswordCheckboxInEditUserBy);
        changePasswordCheckboxInEditUser.click();

        WebElement newPasswordInEditUser = driver.findElement(newPasswordInEditUserBy);

        Random randomGenerator = new Random();
        int randomNumber = randomGenerator.nextInt(9000)+1000;
        String password = "Akarmi" + randomNumber + "!";
        newPasswordInEditUser.sendKeys(password);
        WebElement confirmPasswordEditUser = driver.findElement(confirmPasswordInEditUserBy);
        confirmPasswordEditUser.sendKeys(password);

        Thread.sleep(3000);
        WebElement editUserSaveButton = driver.findElement(editUserSaveButtonBy);
//        WebElement editUserSaveButton = wait.until(ExpectedConditions.elementToBeClickable(editUserSaveButtonBy));
        editUserSaveButton.click();
        Thread.sleep(5000);
        Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers");
        System.out.println("Editing existing system user was successful.");
    }

    public void editSystemUserWithCancel() throws InterruptedException {
        WebElement pencilIcon = driver.findElement(pencilIconBy);
        pencilIcon.click();

        WebElement changePasswordCheckboxInEditUser = driver.findElement(changePasswordCheckboxInEditUserBy);
        changePasswordCheckboxInEditUser.click();

        WebElement newPasswordInEditUser = driver.findElement(newPasswordInEditUserBy);
        newPasswordInEditUser.sendKeys("Akarmi229!");
        WebElement confirmPasswordEditUser = driver.findElement(confirmPasswordInEditUserBy);
        confirmPasswordEditUser.sendKeys("Akarmi229!");

        WebElement editUserCancelButton = driver.findElement(editUserCancelButtonBy);
        Thread.sleep(3000);
        editUserCancelButton.click();
        Assert.assertNotEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/admin/saveSystemUser/18");
        System.out.println("In edit system user clicking on the cancel button was successful.");
    }


}
