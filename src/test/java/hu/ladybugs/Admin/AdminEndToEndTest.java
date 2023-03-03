package hu.ladybugs.Admin;

import hu.ladybugs.Admin.pages.JobPage;
import hu.ladybugs.Admin.pages.UserManagementPage;
import hu.ladybugs.driverfactory.DriverBaseTest;
import org.testng.annotations.Test;

public class AdminEndToEndTest extends DriverBaseTest {

    UserManagementPage userManagementPage;
    JobPage jobPage;

    @Test(description = "Checking that edit user function operates.")
    public void adminEntToEndTest() throws InterruptedException {
        userManagementPage = new UserManagementPage(driver, wait);
        jobPage = new JobPage(driver, wait);

        userManagementPage.loadLoginPage();
        userManagementPage.loginWithValidUsernameAndValidPassword();
        userManagementPage.navigateToAdminMenu();
        userManagementPage.searchSystemUserWithReset();
        userManagementPage.searchSystemUser();
        userManagementPage.addNewSystemUserWithCancel();
        userManagementPage.addNewSystemUser();
        userManagementPage.rewriteThreeUsername();
        userManagementPage.editSystemUserWithCancel();
        userManagementPage.editSystemUser();
        userManagementPage.deleteSystemUserWithCancel();
        userManagementPage.deleteSystemUser();

        jobPage.navigateToJobJobTitleSubmenu();
        jobPage.addNewJobTitleWithCancel();
        jobPage.addNewJobTitle();
        jobPage.deleteJobTitleWithCancel();
        jobPage.deleteJobTitle();
        jobPage.editJobTitleWithCancel();
        jobPage.editJobTitle();




    }
}

