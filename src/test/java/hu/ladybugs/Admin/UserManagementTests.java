package hu.ladybugs.Admin;


import hu.ladybugs.Admin.pages.UserManagementPage;
import hu.ladybugs.driverfactory.DriverBaseTest;
import org.testng.annotations.Test;

public class UserManagementTests extends DriverBaseTest {

    UserManagementPage userManagementPage;

    @Test(description = "Checking that Orange HRM login page loaded successfully and Login text element is displayed.")
    public void loginPageLoadedTest() {
        userManagementPage = new UserManagementPage(driver, wait);
        userManagementPage.loadLoginPage();
    }

    @Test(description = "Checking that user can login successfully with the valid username and password.")
    public void loginWithValidUsernameAndValidPassowrdTest() {
        userManagementPage = new UserManagementPage(driver, wait);
        userManagementPage.loadLoginPage();
        userManagementPage.loginWithValidUsernameAndValidPassword();
    }

    @Test(description = "Checking that user can navigate to the Admin screen.")
    public void navigateToAdminMenuTest() {
        userManagementPage = new UserManagementPage(driver, wait);
        userManagementPage.loadLoginPage();
        userManagementPage.loginWithValidUsernameAndValidPassword();
        userManagementPage.navigateToAdminMenu();
    }

    @Test(description = "Checking that user can add a new system user successfully.")
    public void addingNewSystemUserTest() throws InterruptedException {
        userManagementPage = new UserManagementPage(driver, wait);
        userManagementPage.loadLoginPage();
        userManagementPage.loginWithValidUsernameAndValidPassword();
        userManagementPage.navigateToAdminMenu();
        userManagementPage.addNewSystemUser();
    }

    @Test(description = "Checking that after user clicked the add button, filled some fields, they can click on the Cancel button in order not to add a new system user.")
    public void addingNewSystemUserAndClickCancelTest() throws InterruptedException {
        userManagementPage = new UserManagementPage(driver, wait);
        userManagementPage.loadLoginPage();
        userManagementPage.loginWithValidUsernameAndValidPassword();
        userManagementPage.navigateToAdminMenu();
        userManagementPage.addNewSystemUserWithCancel();
    }

    @Test(description = "Checking that user can delete an existing system user.")
    public void deleteSystemUserTest() throws InterruptedException {
        userManagementPage = new UserManagementPage(driver, wait);
        userManagementPage.loadLoginPage();
        userManagementPage.loginWithValidUsernameAndValidPassword();
        userManagementPage.navigateToAdminMenu();
        userManagementPage.rewriteThreeUsername();
        userManagementPage.deleteSystemUser();
    }

    @Test(description = "After clicking on delete selected, user can choose No, Cancel button in order not to delete anything.")
    public void deleteSystemUserWithCancelTest() throws InterruptedException {
        userManagementPage = new UserManagementPage(driver, wait);
        userManagementPage.loadLoginPage();
        userManagementPage.loginWithValidUsernameAndValidPassword();
        userManagementPage.navigateToAdminMenu();
        userManagementPage.rewriteThreeUsername();
        userManagementPage.deleteSystemUserWithCancel();
    }

    @Test(description = "Checking that user can select the first option in the search row from employee name.")
    public void searchWithKeysSelectingTheFirstOption() throws InterruptedException {
        userManagementPage = new UserManagementPage(driver, wait);
        userManagementPage.loadLoginPage();
        userManagementPage.loginWithValidUsernameAndValidPassword();
        userManagementPage.navigateToAdminMenu();
        userManagementPage.searchWithKeysSelectingTheFirstOption();
    }

    @Test(description = "Checking choosing an option to the User Role dropdown and clicking on the Search button.")
    public void searchSystemUserTest() throws InterruptedException {
        userManagementPage = new UserManagementPage(driver, wait);
        userManagementPage.loadLoginPage();
        userManagementPage.loginWithValidUsernameAndValidPassword();
        userManagementPage.navigateToAdminMenu();
        userManagementPage.searchSystemUser();
    }

    @Test(description = "Checking that reset button operates in search function.")
    public void searchSystemUserWithResetTest() throws InterruptedException {
        userManagementPage = new UserManagementPage(driver, wait);
        userManagementPage.loadLoginPage();
        userManagementPage.loginWithValidUsernameAndValidPassword();
        userManagementPage.navigateToAdminMenu();
        userManagementPage.searchSystemUserWithReset();
    }

    @Test(description = "Checking that edit user function operates.")
    public void editSystemUserTest() throws InterruptedException {
        userManagementPage = new UserManagementPage(driver, wait);
        userManagementPage.loadLoginPage();
        userManagementPage.loginWithValidUsernameAndValidPassword();
        userManagementPage.navigateToAdminMenu();
        userManagementPage.rewriteThreeUsername();
        userManagementPage.editSystemUser();
    }

    @Test(description = "Checking that cancel button operates in edit user function.")
    public void editSystemUserWithCancelTest() throws InterruptedException {
        userManagementPage = new UserManagementPage(driver, wait);
        userManagementPage.loadLoginPage();
        userManagementPage.loginWithValidUsernameAndValidPassword();
        userManagementPage.navigateToAdminMenu();
        userManagementPage.rewriteThreeUsername();
        userManagementPage.editSystemUserWithCancel();
    }

   




}
