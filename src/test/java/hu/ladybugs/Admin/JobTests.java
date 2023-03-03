package hu.ladybugs.Admin;


import hu.ladybugs.Admin.pages.JobPage;
import hu.ladybugs.Admin.pages.UserManagementPage;
import hu.ladybugs.driverfactory.DriverBaseTest;
import org.testng.annotations.Test;

public class JobTests extends DriverBaseTest {

    UserManagementPage userManagementPage;
    JobPage jobPage;


    @Test(description = "Checking that admin can add a new job title.")
    public void addNewJobTitleTest() throws InterruptedException {
        userManagementPage = new UserManagementPage(driver, wait);
        userManagementPage.loadLoginPage();
        userManagementPage.loginWithValidUsernameAndValidPassword();
        userManagementPage.navigateToAdminMenu();
        jobPage = new JobPage(driver, wait);
        jobPage.navigateToJobJobTitleSubmenu();
        jobPage.addNewJobTitle();
    }

    @Test(description = "Checking that admin can cancel adding a new job title.")
    public void addNewJobTitleWithCancelTest() throws InterruptedException {
        userManagementPage = new UserManagementPage(driver, wait);
        userManagementPage.loadLoginPage();
        userManagementPage.loginWithValidUsernameAndValidPassword();
        userManagementPage.navigateToAdminMenu();
        jobPage = new JobPage(driver, wait);
        jobPage.navigateToJobJobTitleSubmenu();
        jobPage.addNewJobTitleWithCancel();
    }

    @Test(description = "Checking that admin can edit a job title.")
    public void editJobTitleTest() throws InterruptedException {
        userManagementPage = new UserManagementPage(driver, wait);
        userManagementPage.loadLoginPage();
        userManagementPage.loginWithValidUsernameAndValidPassword();
        userManagementPage.navigateToAdminMenu();
        jobPage = new JobPage(driver, wait);
        jobPage.navigateToJobJobTitleSubmenu();
        jobPage.editJobTitle();
    }

    @Test(description = "Checking that admin can cancel editing a job title.")
    public void editJobTitleWithCancelTest() throws InterruptedException {
        userManagementPage = new UserManagementPage(driver, wait);
        userManagementPage.loadLoginPage();
        userManagementPage.loginWithValidUsernameAndValidPassword();
        userManagementPage.navigateToAdminMenu();
        jobPage = new JobPage(driver, wait);
        jobPage.navigateToJobJobTitleSubmenu();
        jobPage.editJobTitleWithCancel();
    }

    @Test(description = "Checking that admin can delete an existing job title.")
    public void deleteJobTitleTest() throws InterruptedException {
        userManagementPage = new UserManagementPage(driver, wait);
        userManagementPage.loadLoginPage();
        userManagementPage.loginWithValidUsernameAndValidPassword();
        userManagementPage.navigateToAdminMenu();
        jobPage = new JobPage(driver, wait);
        jobPage.navigateToJobJobTitleSubmenu();
        jobPage.deleteJobTitle();
    }

    @Test(description = "Checking that admin can cancel deleting an existing job title.")
    public void deleteJobTitleTestWithCancel() throws InterruptedException {
        userManagementPage = new UserManagementPage(driver, wait);
        userManagementPage.loadLoginPage();
        userManagementPage.loginWithValidUsernameAndValidPassword();
        userManagementPage.navigateToAdminMenu();
        jobPage = new JobPage(driver, wait);
        jobPage.navigateToJobJobTitleSubmenu();
        jobPage.deleteJobTitleWithCancel();
    }
}
