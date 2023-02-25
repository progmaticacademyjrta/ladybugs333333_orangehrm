package hu.ladybugs.Admin.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

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
    By checkboxToDeleteBy = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div[2]/div/div[1]/div/div/label/span/i");
    By deleteSelectedButtonBy = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[2]/div/div/button");
    By deleteFromPopUpBy = By.xpath("//*[@id=\"app\"]/div[3]/div/div/div/div[3]/button[2]/i");
    By cancelFromPopUpBy = By.xpath("//*[@id=\"app\"]/div[3]/div/div/div/div[3]/button[1]");
    By searchUserRoleArrayBy = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/div/div/div[2]/i");
    By searchUserRoleFieldBy = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/div/div/div[1]");
    By searchButtonBy = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]");
    By userRoleTypeBy = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div[1]/div/div[3]/div");
    By pencilIconBy = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div[1]/div/div[6]/div/button[2]/i");
    By editUserSaveButtonBy = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/button[2]");


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
//        driver.switchTo().alert().accept();

        Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
        System.out.println("Login with valid username and valid password was successful.");

    }

//    public void navigateToMyInfoMenu() {
//        WebElement myInfoMenu = driver.findElement(myInfoMenuBy);
//        myInfoMenu.click();
//        Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewPersonalDetails/empNumber/7");
//        System.out.println("Navigation to My Info menu is successful.");
//    }
//
//    public void setMyInfo() {
//        WebElement firstNameOnMyInfo = driver.findElement(firstNameOnMyInfoBy);
//        firstNameOnMyInfo.click();
//        firstNameOnMyInfo.clear();
//        firstNameOnMyInfo.sendKeys("Milan");
//
//        WebElement lastNameOnMyInfo = driver.findElement(lastNameOnMyInfoBy);
//        lastNameOnMyInfo.click();
//        lastNameOnMyInfo.clear();
//        lastNameOnMyInfo.sendKeys("Florian");
//
//        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
//
//        WebElement saveButtonOnMyInfo = driver.findElement(saveButtonOnMyInfoBy);
//        saveButtonOnMyInfo.click();
//
//        System.out.println("Setting the user name is successful.");
//
//    }

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
        usernameToNewUser.sendKeys("Mammamiam789");


        WebElement passwordToNewUser = driver.findElement(passwordToNewUserBy);
        passwordToNewUser.clear();
        passwordToNewUser.sendKeys("Mamika7788!");


        WebElement confirmPassword = driver.findElement(confirmPasswordBy);
        confirmPassword.sendKeys("Mamika7788!");

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
        WebElement checkboxToDelete = driver.findElement(checkboxToDeleteBy);
        checkboxToDelete.click();
        WebElement deleteSelectedButton = driver.findElement(deleteSelectedButtonBy);
        deleteSelectedButton.click();
        WebElement deleteFromPopUp = driver.findElement(deleteFromPopUpBy);
        deleteFromPopUp.click();
        System.out.println("Selected system user deleted successfully.");
        Thread.sleep(2000);
    }

    public void deleteSystemUserWithCancel() {
        WebElement checkboxToDelete = driver.findElement(checkboxToDeleteBy);
        checkboxToDelete.click();
        WebElement deleteSelectedButton = driver.findElement(deleteSelectedButtonBy);
        deleteSelectedButton.click();
        WebElement cancelFromPopUp = driver.findElement(cancelFromPopUpBy);
        cancelFromPopUp.click();
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

    public void editSystemUser() throws InterruptedException {
        WebElement pencilIcon = driver.findElement(pencilIconBy);
        pencilIcon.click();

        WebElement editUserSaveButton = driver.findElement(editUserSaveButtonBy);
        editUserSaveButton.click();


        Thread.sleep(30000);

//        Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers");
        System.out.println("Editing existing system user was successful.");
    }

}
